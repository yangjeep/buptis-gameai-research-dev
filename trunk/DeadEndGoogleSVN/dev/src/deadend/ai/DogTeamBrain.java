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

package deadend.ai;

import deadend.game.DeadEndGame;
/**
 *
 * @author Yang JiaJian
 */
public class DogTeamBrain {

    // TODO constructor
    public DogTeamBrain(DeadEndGame game) {
        this.game=game;
    }

    DeadEndGame game;
    // TODO method computation within time limit
    public void compute(int timeLimitInMS){
        long begin = System.currentTimeMillis();
		long limit = begin + timeLimitInMS;
        do{
            //Computation logic here
        }while(System.currentTimeMillis()<limit);
    }
}
