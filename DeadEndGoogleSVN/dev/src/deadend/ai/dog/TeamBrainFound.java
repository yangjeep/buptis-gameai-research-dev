/*
 * deadend.ai.dog.TeamBrainFound
 * Copyright (C) Yang JiaJian 2009 <yangjeep@gmail.com>
 * deadend.ai.dog.TeamBrainFound is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.dog.TeamBrainFound is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.ai.dog;
import java.util.ArrayList;
/**
 *
 * @author Yang JiaJian
 */
public abstract class TeamBrainFound {
    /**
     *
     */
    public ArrayList<deadend.globalenum.Directions> directions;
    /**
     *
     */
    public boolean goodRound;
    /**
     * 
     * @param thegame
     */
    public abstract void compute(deadend.game.DeadEndGame thegame);
    /**
     *
     * @return
     */
    public abstract String getName();
}