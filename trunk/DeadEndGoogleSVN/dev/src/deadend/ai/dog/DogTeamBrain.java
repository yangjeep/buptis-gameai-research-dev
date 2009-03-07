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
import deadend.ai.dog.monteCarlo.*;
/**
 *
 * @author Yang JiaJian
 */
public class DogTeamBrain {

    public DogTeamBrain(DeadEndGame game,int timeLimit) {
        this.game=game;
        this.timeLimitInMS=timeLimit;
        this.dcredit=new DirectionCredit();
    }

    DeadEndGame game;
    int timeLimitInMS;

    DirectionCredit dcredit;

    public ArrayList<deadend.globalenum.Directions> directions;
    // TODO method computation within time limit
    public void compute(){
        long begin = System.currentTimeMillis();
		long limit = begin + this.timeLimitInMS;

        directions=new ArrayList<deadend.globalenum.Directions>(deadend.game.GameConfigClass.NumberOfDogs);
        
        do{
            //Computation logic here
            
        }while(System.currentTimeMillis()<limit);
    }
    
}
