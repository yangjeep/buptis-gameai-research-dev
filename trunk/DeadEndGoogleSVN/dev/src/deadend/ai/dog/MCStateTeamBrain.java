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
import deadend.ai.dog.monteCarloStateSingle.*;
/**
 *
 * @author Yang JiaJian
 */
public class MCStateTeamBrain extends TeamBrainFound{

    public MCStateTeamBrain(DeadEndGame game,int timeLimit) {
        this.game=game;
        this.timeLimitInMS=timeLimit;
        
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
		long limit = begin + this.timeLimitInMS;

        System.out.println("Time:"+(limit-begin));
        MSimGame msim=new MSimGame(this.game,this.game.player,this.game.dogs.dogTeam);
        do{
            
            // Computation logic here
            msim.runSim();
            
            if(msim.simResult!=deadend.globalenum.GameResults.NotEnd){
                if(msim.simResult==deadend.globalenum.GameResults.DogWin)
                {
                    for(int i=0;i<this.game.dogs.dogTeam.size();i++){
                            Directions d=msim.nextDir.get(i);
                            this.dcredits.get(i).addCredit(d);
                        }
                }
                /*
                if(msim.simResult==deadend.globalenum.GameResults.Draw)
                {
                    for(int i=0;i<this.game.dogs.dogTeam.size();i++){
                            Directions d=msim.nextDir.get(i);
                            this.dcredits.get(i).addDrawCredit(d);
                        }
                }
                 */
                this.simNum++;
                msim.reset(this.game,this.game.player,this.game.dogs.dogTeam);
            }
            
        }while(System.currentTimeMillis()<=limit);

        for(int i=0;i<this.directions.size();i++){
            this.directions.set(i, this.dcredits.get(i).findBest(
                    (java.awt.Point)this.game.dogs.dogTeam.get(i).getPosition().clone(),
                    (java.awt.Point)this.game.player.getPosition().clone()));
        }
        System.out.println("Simed:"+simNum);
        this.simNum=0;
    }
    int simNum=0;

    @Override
    public String getName(){
        String str="MonteCarloState";
        str+="-Time"+deadend.game.GameConfigClass.ComputingTimeLimit;
        return str;
    }
}
