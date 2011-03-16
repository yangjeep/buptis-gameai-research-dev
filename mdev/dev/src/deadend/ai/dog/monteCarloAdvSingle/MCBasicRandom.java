/*
 * deadend.ai.dog.monteCarloStateSingle.MCBasicChasing
 * Copyright (C) Yang JiaJian 2009 <yangjeep@gmail.com>
 * deadend.ai.dog.monteCarloStateSingle.MCBasicChasing is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.dog.monteCarloStateSingle.MCBasicChasing is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.ai.dog.monteCarloAdvSingle;

import deadend.globalenum.Directions;
/**
 *
 * @author Yang JiaJian
 */
public class MCBasicRandom extends MCSimStrategy{

    /**
     *
     * @param simGame
     * @param selfPos
     * @return
     */
    public deadend.globalenum.Directions nextDir(MSimGame simGame,java.awt.Point selfPos){
        java.awt.Point catPos=simGame.scat.position;
        int cx,cy,dx,dy;
        cx=catPos.x;
        cy=catPos.y;
        dx=selfPos.x;
        dy=selfPos.y;

        java.util.ArrayList<Directions> choices=new java.util.ArrayList<Directions>();
        choices.clear();

        if(dx<deadend.game.GameConfigClass.GridX-1){
        choices.add(Directions.Right);
        }
        if(dx>0){
        choices.add(Directions.Left);
        }
        if(dy<deadend.game.GameConfigClass.GridY-1){
            choices.add(Directions.Down);
        }
        if(dy>0){
            choices.add(Directions.Up);
        }
        /*if(dy>1){
        choices.add(Directions.Up);
        }*/
        java.util.Random rand=new java.util.Random();
        int c=rand.nextInt(choices.size());
        return choices.get(c);
    }
}
