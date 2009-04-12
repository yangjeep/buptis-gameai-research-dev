/*
 * deadend.ai.DogTeamBrain
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.ai.DogTeamBrain is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.DogTeamBrain is distributed in the hope that it will be useful, but
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
import deadend.globalenum.Directions;
import deadend.ai.dog.monteCarloAdvSingle.*;
/**
 *
 * @author Yang JiaJian
 */
public class MCAdvSingleBrain extends TeamBrainFound{

    public MCAdvSingleBrain(DeadEndGame game,int timeLimit) {
        this.game=game;
        this.timeLimitInMS=timeLimit;
        this.goodRound=false;
    }

    DeadEndGame game;

    int timeLimitInMS;

    ArrayList<DirectionCredit> dcredits;

    
    // method computation within time limit
    public void compute(){
        this.dcredits=new ArrayList<DirectionCredit>(deadend.game.GameConfigClass.NumberOfDogs);
        directions=new ArrayList<deadend.globalenum.Directions>(deadend.game.GameConfigClass.NumberOfDogs);
        directions.clear();
        dcredits.clear();
        for(int i=0;i<deadend.game.GameConfigClass.NumberOfDogs;i++){
            this.dcredits.add(new DirectionCredit());
            this.directions.add(Directions.Still);
        }

        long begin = System.currentTimeMillis();
		long limit = begin + this.timeLimitInMS/this.game.dogs.dogTeam.size();

        System.out.println("Time:"+(limit-begin));
        MSimGame msim=new MSimGame(this.game,this.game.player,this.game.dogs.dogTeam);

        int remainder=0;
        for(int j=0;j<this.game.dogs.dogTeam.size();j++){
            do{
            // Computation logic here
            msim.runSim(remainder,j);
            if(msim.simResult!=deadend.globalenum.GameResults.NotEnd){
                //if(j==1 && msim.simResult==deadend.globalenum.GameResults.DogWin)System.out.println("add credits to 2");
                Directions d=msim.nextDir.get(j);
                this.dcredits.get(j).autoAddCredit(d, msim.simResult);
                this.simNum++;
                msim.reset(this.game,this.game.player,this.game.dogs.dogTeam);
                if(remainder<=3)remainder++;
                if(remainder>3)remainder=0;
            }
        }while(System.currentTimeMillis()<=limit);
            System.out.println(j+":Simed:"+simNum);
            simNum=0;
            begin = System.currentTimeMillis();
            limit = begin + this.timeLimitInMS/this.game.dogs.dogTeam.size();
        }
        

        for(int i=0;i<this.directions.size();i++){
            this.directions.set(i, this.dcredits.get(i).findBest(
                    this.game.player.getPosition(),this.game.dogs.dogTeam.get(i).getPosition()
                    ));
            
            if(this.game.player.getPosition().x-this.game.dogs.dogTeam.get(i).getPosition().x==1 &&
                    this.game.player.getPosition().y-this.game.dogs.dogTeam.get(i).getPosition().y==0){
                this.directions.set(i,Directions.Right);
                System.out.println("eat right");
                this.goodRound=true;
            }
            if(this.game.player.getPosition().x-this.game.dogs.dogTeam.get(i).getPosition().x==-1 &&
                    this.game.player.getPosition().y-this.game.dogs.dogTeam.get(i).getPosition().y==0){
                this.directions.set(i,Directions.Left);
                System.out.println("eat left");
                this.goodRound=true;
            }
            if(this.game.player.getPosition().x-this.game.dogs.dogTeam.get(i).getPosition().x==0 &&
                    this.game.player.getPosition().y-this.game.dogs.dogTeam.get(i).getPosition().y==1){
                this.directions.set(i,Directions.Down);
                System.out.println("eat down");
                this.goodRound=true;
            }
            if(this.game.player.getPosition().x-this.game.dogs.dogTeam.get(i).getPosition().x==0 &&
                    this.game.player.getPosition().y-this.game.dogs.dogTeam.get(i).getPosition().y==-1){
                this.directions.set(i,Directions.Up);
                System.out.println("eat up");
                this.goodRound=true;
            }
            
        }
        
    }
    int simNum=0;

    @Override
    public String getName(){
        String str="MonteCarloAdvancedSingle";
        str+="-Time"+deadend.game.GameConfigClass.ComputingTimeLimit;
        return str;
    }
}
