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

package deadend.ai.dog.monteCarloStateSingle;

import deadend.globalenum.Directions;
/**
 *
 * @author Yang JiaJian
 */
public class MCBasicDefence extends MCSimStrategy{

    public deadend.globalenum.Directions nextDir(MSimGame simGame,java.awt.Point selfPos){
        java.awt.Point catPos=simGame.scat.position;
        int cx,cy,dx,dy;
        cx=catPos.x;
        cy=catPos.y;
        dx=selfPos.x;
        dy=selfPos.y;

        java.util.ArrayList<Directions> choices=new java.util.ArrayList<Directions>();
        choices.clear();
        if(cx>dx){
            choices.add(Directions.Right);
        }
        if(cx<dx){
            choices.add(Directions.Left);
        }
        if(cy>=dy && dy>0){
            choices.add(Directions.Up);
        }
        choices.add(Directions.Still);
        java.util.Random rand=new java.util.Random();
        int c=rand.nextInt(choices.size());
        return choices.get(c);
    }
}
