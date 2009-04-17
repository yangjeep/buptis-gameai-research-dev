/*
 * deadend.ai.dog.NeuralBrain
 * Copyright (C) Yang JiaJian 2009 <yangjeep@gmail.com>
 * deadend.ai.dog.NeuralBrain is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.dog.NeuralBrain is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.ai.dog;

import java.util.ArrayList;

import deadend.game.DeadEndGame;
import deadend.ai.dog.neuralnetwork.*;
import universalUtil.neuralnetwork.*;
import deadend.globalenum.Directions;

/**
 *
 * @author Yang JiaJian
 */
public class NeuralBrain extends TeamBrainFound{

    NeuralNetwork TheBrain;

    private DeadEndGame game;

    ArrayList<wekaANN> annDogs;

    int catNum;
    boolean onlyWin;

    /**
     *
     * @param game
     * @param catNum
     * @param onlyWin
     */
    public NeuralBrain(DeadEndGame game,int catNum,boolean onlyWin){
        this.game=game;
        this.catNum=catNum;
        this.onlyWin=onlyWin;

        this.annDogs=new ArrayList<wekaANN>();
        for(int i=0;i<game.dogs.dogTeam.size();i++){
            wekaANN ann=new wekaANN();
            ann.initialize(9, 6, 4);
            String strurl;
            if(onlyWin){
                strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" +
                          "DBQ=E:\\My Java Projects\\sseProj\\dev\\DeadEndGoogleSVN\\DeadEndGoogleSVN\\" +
                          "db\\ann\\Cat"+catNum+"-"+"dog"+(i+1)+"-Win"+".mdb";
            }
            else{
                strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" +
                          "DBQ=E:\\My Java Projects\\sseProj\\dev\\DeadEndGoogleSVN\\DeadEndGoogleSVN\\" +
                          "db\\ann\\Cat"+catNum+"-"+"dog"+(i+1)+".mdb";
            }
            ann.LoadData(strurl);
            this.annDogs.add(ann);
        }
        // TODO apply ANN and load data
    }
    @Override
    public void compute(deadend.game.DeadEndGame thegame){

        directions=new ArrayList<deadend.globalenum.Directions>(deadend.game.GameConfigClass.NumberOfDogs);
        directions.clear();

        for(int i=0;i<this.game.dogs.dogTeam.size();i++){
            this.directions.add(Directions.Still);
        }

        int catToDog1x,catToDog1y,catToDog2x,catToDog2y,catToExitX,catToExitY;
        double catToDog1,catToDog2;
        int turn;
        catToDog1x=game.player.getPosition().x-game.dogs.dogTeam.get(0).getPosition().x;
        catToDog1y=game.player.getPosition().y-game.dogs.dogTeam.get(0).getPosition().y;
        catToDog2x=game.player.getPosition().x-game.dogs.dogTeam.get(1).getPosition().x;
        catToDog2y=game.player.getPosition().y-game.dogs.dogTeam.get(1).getPosition().y;

        catToExitX=game.player.getPosition().x-game.door.get(0).x;
        catToExitY=game.player.getPosition().y-game.door.get(0).y;

        catToDog1=game.player.getPosition().distance(game.dogs.dogTeam.get(0).getPosition());
        catToDog2=game.player.getPosition().distance(game.dogs.dogTeam.get(1).getPosition());

        turn=game.step;

        for(int i=0;i<game.dogs.dogTeam.size();i++){
            this.annDogs.get(i).setInput(0,catToDog1x);
            this.annDogs.get(i).setInput(1,catToDog1y);
            this.annDogs.get(i).setInput(2,catToDog2x);
            this.annDogs.get(i).setInput(3,catToDog2y);
            this.annDogs.get(i).setInput(4,catToDog1);
            this.annDogs.get(i).setInput(5,catToDog2);
            this.annDogs.get(i).setInput(6,catToExitX);
            this.annDogs.get(i).setInput(7,catToExitY);
            this.annDogs.get(i).setInput(8,turn);

            this.annDogs.get(i).feedForward();

            int k=this.annDogs.get(i).getMAxOutPutID();
            Directions d=Directions.Still;
            d=this.loadChoice(i+1,k);
            this.directions.set(i, d);
        }
    }
    /**
     *
     * @return
     */
    @Override
    public String getName(){
        String str="ANN";
        switch(this.catNum){
            case 1:
                str+="-BasicFSM";
                break;
            case 2:
                str+="-Zigzag";
                break;
            case 3:
                str+="-CounterStrike";
                break;
        }
        if(this.onlyWin)str+="-WinOnly";
        else str+="-All";
        str+="-Time"+deadend.game.GameConfigClass.ComputingTimeLimit;
        return str;
    }

    private Directions loadChoice(int dogNum,int k){
        Directions dir=Directions.Still;
        switch(this.catNum){
            case 1:{
                if(dogNum==1){
                    if(this.onlyWin){
                        // cat1-dog1-onlyWin
                        switch(k){
                            case 0:return Directions.Down;
                            case 1:return Directions.Left;
                            case 2:return Directions.Up;
                            case 3:return Directions.Right;
                        }
                    }
                    else{
                        // cat1-dog1-all
                        switch(k){
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                        }
                    }
                }
                if(dogNum==2){
                    if(this.onlyWin){
                        // cat1-dog2-onlyWin
                        switch(k){
                            case 0:return Directions.Down;
                            case 1:return Directions.Left;
                            case 2:return Directions.Right;
                            case 3:return Directions.Up;
                        }
                    }
                    else{
                        // cat1-dog2-all
                        switch(k){
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                        }
                    }
                }
                break;
            }
            case 2:{
                if(dogNum==1){
                    if(this.onlyWin){
                        // cat2-dog1-onlyWin
                        switch(k){
                            case 0:return Directions.Down;
                            case 1:return Directions.Right;
                            case 2:return Directions.Up;
                            case 3:return Directions.Left;
                        }
                    }
                    else{
                        // cat2-dog1-all
                        switch(k){
                            case 0:return Directions.Down;
                            case 1:return Directions.Up;
                            case 2:return Directions.Left;
                            case 3:return Directions.Right;
                        }
                    }
                }
                if(dogNum==2){
                    if(this.onlyWin){
                        // cat2-dog2-onlyWin
                        switch(k){
                            case 0:return Directions.Down;
                            case 1:return Directions.Right;
                            case 2:return Directions.Left;
                            case 3:return Directions.Up;
                        }
                    }
                    else{
                        // cat2-dog2-all
                        switch(k){
                            case 0:return Directions.Down;
                            case 1:return Directions.Left;
                            case 2:return Directions.Right;
                            case 3:return Directions.Up;
                        }
                    }
                }
                break;
            }
            case 3:{
                if(dogNum==1){
                    if(this.onlyWin){
                        // cat3-dog1-onlyWin
                        switch(k){
                            case 0:return Directions.Left;
                            case 1:return Directions.Right;
                            case 2:return Directions.Down;
                            case 3:return Directions.Up;
                        }
                    }
                    else{
                        // cat3-dog1-all
                        switch(k){
                            case 0:return Directions.Down;
                            case 1:return Directions.Right;
                            case 2:return Directions.Left;
                            case 3:return Directions.Up;
                        }
                    }
                }
                if(dogNum==2){
                    if(this.onlyWin){
                        // cat3-dog2-onlyWin
                        switch(k){
                            case 0:return Directions.Down;
                            case 1:return Directions.Right;
                            case 2:return Directions.Left;
                            case 3:return Directions.Up;
                        }
                    }
                    else{
                        // cat3-dog2-all
                        switch(k){
                            case 0:return Directions.Down;
                            case 1:return Directions.Up;
                            case 2:return Directions.Left;
                            case 3:return Directions.Right;
                        }
                    }
                }
                break;
            }
        }
        return dir;
    }
}
