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

    public NeuralBrain(DeadEndGame game){
        this.game=game;

        this.annDogs=new ArrayList<wekaANN>();
        for(int i=0;i<game.dogs.dogTeam.size();i++){
            wekaANN ann=new wekaANN();
            ann.initialize(9, 6, 4);
            String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" +
                          "DBQ=E:\\My Java Projects\\sseProj\\dev\\DeadEndGoogleSVN\\DeadEndGoogleSVN\\" +
                          "db\\ann\\090229dog"+(i+1)+".mdb";
            ann.LoadData(strurl);
            this.annDogs.add(ann);
        }
        // TODO apply ANN and load data
    }
    @Override
    public void compute(){

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
            switch(k){
                case 0:
                    d=Directions.Down;
                    break;
                case 1:
                    d=Directions.Left;
                    break;
                case 2:
                    d=Directions.Up;
                    break;
                case 3:
                    d=Directions.Right;
                    break;
            }
            this.directions.set(i, d);
        }
    }
    @Override
    public String getName(){
        return "ANN";
    }
}
