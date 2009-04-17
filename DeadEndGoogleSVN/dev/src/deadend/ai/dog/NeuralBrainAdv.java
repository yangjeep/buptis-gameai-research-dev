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
import deadend.game.GameConfigClass;

/**
 *
 * @author Yang JiaJian
 */
public class NeuralBrainAdv extends TeamBrainFound{

    NeuralNetwork TheBrain;

    private DeadEndGame game;

    ArrayList<wekaANN> annDogs;

    int catNum;
    boolean onlyWin;


    private String dburl;
    /**
     *
     * @param game
     * @param catNum
     * @param onlyWin
     * @param dburl
     * @param numOfInputs
     * @param numOfHidden
     * @param numOfOutput
     */
    public NeuralBrainAdv(DeadEndGame game,int catNum,boolean onlyWin,String dburl,
            int numOfInputs,int numOfHidden,int numOfOutput
            ){
        this.game=game;
        this.catNum=catNum;
        this.onlyWin=onlyWin;
        this.dburl=dburl;

        this.annDogs=new ArrayList<wekaANN>();
        for(int i=0;i<game.dogs.dogTeam.size();i++){
            wekaANN ann=new wekaANN();
            ann.initialize(numOfInputs,numOfHidden,numOfOutput);
            String odbc="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=";
            String strurl=odbc+dburl+"\\Dog"+(i+1)+".mdb";
            
            ann.LoadData(strurl);
            this.annDogs.add(ann);
        }
    }

    /**
     *
     * @param game
     * @param catNum
     * @param onlyWin
     */
    public NeuralBrainAdv(DeadEndGame game,int catNum,boolean onlyWin){
        this.game=game;
        this.catNum=catNum;
        this.onlyWin=onlyWin;


        this.annDogs=new ArrayList<wekaANN>();
        for(int i=0;i<game.dogs.dogTeam.size();i++){
            wekaANN ann=new wekaANN();
            ann.initialize(28, 18, 4);
            String strurl;
            if(onlyWin){
                strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" +
                          "DBQ=E:\\My Java Projects\\sseProj\\dev\\trunk\\DeadEndGoogleSVN\\dev\\" +
                          "db\\annAdv\\Cat"+catNum+"-"+"dog"+(i+1)+"-Win"+".mdb";
            }
            else{
                strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" +
                          "DBQ=E:\\My Java Projects\\sseProj\\dev\\trunk\\DeadEndGoogleSVN\\dev\\" +
                          "db\\annAdv\\Cat"+catNum+"-"+"dog"+(i+1)+".mdb";
            }
            this.dburl=strurl;
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

        double catDog1Angle;
        if(game.player.getPosition().x-game.dogs.dogTeam.get(0).getPosition().x!=0){
            catDog1Angle=
                (game.player.getPosition().y-game.dogs.dogTeam.get(0).getPosition().y)/
                (game.player.getPosition().x-game.dogs.dogTeam.get(0).getPosition().x)
                ;
        }
        else{
            catDog1Angle=1;
        }
        double catDog2Angle;
        if(game.player.getPosition().x-game.dogs.dogTeam.get(1).getPosition().x!=0){
            catDog2Angle=
                (game.player.getPosition().y-game.dogs.dogTeam.get(1).getPosition().y)/
                (game.player.getPosition().x-game.dogs.dogTeam.get(1).getPosition().x)
                ;
        }
        else{
            catDog2Angle=1;
        }


        int catToLeft=game.player.getPosition().x-0;
        int catToRight=GameConfigClass.GridX-game.player.getPosition().x;
        int catToTop=game.player.getPosition().y-0;
        int catToBottom=GameConfigClass.GridY-game.player.getPosition().y;

        int dog1ToLeft=game.dogs.dogTeam.get(0).getPosition().x-0;
        int dog1ToRight=GameConfigClass.GridX-game.dogs.dogTeam.get(0).getPosition().x;
        int dog1ToTop=game.dogs.dogTeam.get(0).getPosition().y-0;
        int dog1ToBottom=GameConfigClass.GridY-game.dogs.dogTeam.get(0).getPosition().y;

        int dog2ToLeft=game.dogs.dogTeam.get(1).getPosition().x-0;
        int dog2ToRight=GameConfigClass.GridX-game.dogs.dogTeam.get(1).getPosition().x;
        int dog2ToTop=game.dogs.dogTeam.get(1).getPosition().y-0;
        int dog2ToBottom=GameConfigClass.GridY-game.dogs.dogTeam.get(1).getPosition().y;

        double dogInnerDist=game.dogs.dogTeam.get(0).getPosition().distance(game.dogs.dogTeam.get(1).getPosition());
        int dog1ToExitX=game.dogs.dogTeam.get(0).getPosition().x-game.door.get(0).x;
        int dog1ToExitY=game.dogs.dogTeam.get(0).getPosition().x-game.door.get(0).y;

        int dog2ToExitX=game.dogs.dogTeam.get(1).getPosition().x-game.door.get(0).x;
        int dog2ToExitY=game.dogs.dogTeam.get(1).getPosition().x-game.door.get(0).y;

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

            this.annDogs.get(i).setInput(8,catDog1Angle);
            this.annDogs.get(i).setInput(9,catDog2Angle);

            this.annDogs.get(i).setInput(10,catToLeft);
            this.annDogs.get(i).setInput(11,catToRight);
            this.annDogs.get(i).setInput(12,catToTop);
            this.annDogs.get(i).setInput(13,catToBottom);

            this.annDogs.get(i).setInput(14,dog1ToLeft);
            this.annDogs.get(i).setInput(15,dog1ToRight);
            this.annDogs.get(i).setInput(16,dog1ToTop);
            this.annDogs.get(i).setInput(17,dog1ToBottom);

            this.annDogs.get(i).setInput(18,dog2ToLeft);
            this.annDogs.get(i).setInput(19,dog2ToRight);
            this.annDogs.get(i).setInput(20,dog2ToTop);
            this.annDogs.get(i).setInput(21,dog2ToBottom);

            this.annDogs.get(i).setInput(22,dogInnerDist);

            this.annDogs.get(i).setInput(23,dog1ToExitX);
            this.annDogs.get(i).setInput(24,dog1ToExitY);
            this.annDogs.get(i).setInput(25,dog2ToExitX);
            this.annDogs.get(i).setInput(26,dog2ToExitY);

            this.annDogs.get(i).setInput(27,turn);

            this.annDogs.get(i).feedForward();

            int k=this.annDogs.get(i).getMAxOutPutID();
            Directions d=Directions.Still;
            //d=this.loadChoice(i+1,k);
            d=this.loadChoice(i+1,dburl+(i+1)+".mdb",k);


            if(this.game.player.getPosition().x-this.game.dogs.dogTeam.get(i).getPosition().x==1 &&
                    this.game.player.getPosition().y-this.game.dogs.dogTeam.get(i).getPosition().y==0){
                this.directions.set(i,Directions.Right);
                System.out.println("eat right");
            }
            if(this.game.player.getPosition().x-this.game.dogs.dogTeam.get(i).getPosition().x==-1 &&
                    this.game.player.getPosition().y-this.game.dogs.dogTeam.get(i).getPosition().y==0){
                this.directions.set(i,Directions.Left);
                System.out.println("eat left");
            }
            if(this.game.player.getPosition().x-this.game.dogs.dogTeam.get(i).getPosition().x==0 &&
                    this.game.player.getPosition().y-this.game.dogs.dogTeam.get(i).getPosition().y==1){
                this.directions.set(i,Directions.Down);
                System.out.println("eat down");
            }
            if(this.game.player.getPosition().x-this.game.dogs.dogTeam.get(i).getPosition().x==0 &&
                    this.game.player.getPosition().y-this.game.dogs.dogTeam.get(i).getPosition().y==-1){
                this.directions.set(i,Directions.Up);
                System.out.println("eat up");
            }
            

            this.directions.set(i, d);
        }
    }
    /**
     *
     * @return
     */
    @Override
    public String getName(){
        if(this.dburl.equalsIgnoreCase("db\\enhanced\\current\\MCState300-CS-Win"))return "ANN-MCState300-CS-Win";
        if(this.dburl.equalsIgnoreCase("db\\enhanced\\current\\MCState-ZigZag-Win"))return "ANN-MCState300-Zigzag-Win";
        if(this.dburl.equalsIgnoreCase("db\\enhanced\\current\\MCState300-Square-Win"))return "ANN-MCState300-Square-Win";
        return this.dburl;
    }
    private Directions loadChoice(int dogID,String dburl,int maxID){
        boolean comUrl;

        
        comUrl=this.dburl.equalsIgnoreCase("db\\enhanced\\current\\MCState300-CS-Win");
        if(comUrl){
            if(dogID==1){
                 switch(maxID){
                            case 0:return Directions.Left;
                            case 1:return Directions.Down;
                            case 2:return Directions.Right;
                            case 3:return Directions.Up;
                        }
            }
            if(dogID==2){
                switch(maxID){
                            case 0:return Directions.Left;
                            case 1:return Directions.Down;
                            case 2:return Directions.Right;
                            case 3:return Directions.Up;
                        }
            }
        }

        comUrl=this.dburl.equalsIgnoreCase("db\\enhanced\\current\\MCState-ZigZag-Win");
        if(comUrl){
            if(dogID==1){
                 switch(maxID){
                            case 0:return Directions.Left;
                            case 1:return Directions.Down;
                            case 2:return Directions.Up;
                            case 3:return Directions.Right;
                        }
            }
            if(dogID==2){
                switch(maxID){
                            case 0:return Directions.Left;
                            case 1:return Directions.Right;
                            case 2:return Directions.Down;
                            case 3:return Directions.Up;
                        }
            }
        }

        comUrl=this.dburl.equalsIgnoreCase("db\\enhanced\\current\\MCState300-Square-Win");
        if(comUrl){
            if(dogID==1){
                 switch(maxID){
                            case 0:return Directions.Down;
                            case 1:return Directions.Right;
                            case 2:return Directions.Left;
                            case 3:return Directions.Up;
                        }
            }
            if(dogID==2){
                switch(maxID){
                            case 0:return Directions.Up;
                            case 1:return Directions.Right;
                            case 2:return Directions.Down;
                            case 3:return Directions.Left;
                        }
            }
        }

        return Directions.Still;
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
