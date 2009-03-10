/*
 * deadend.ai.monteCarlo.MDog
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.ai.monteCarlo.MDog is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.monteCarlo.MDog is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.ai.dog.sMonteCarlo;

import java.awt.Point;

import deadend.globalenum.Directions;
/**
 *
 * @author Yang JiaJian
 */
public class MDog {
    Point position;
    public Directions first;
    public MDog(Point position){
        this.position=position;
        this.first=Directions.Still;
    }

    public void rMove(int step){

        // TODO change the direction into strategy

        java.util.Random rand=new java.util.Random();
        java.util.ArrayList<Directions> choices=new java.util.ArrayList<Directions>();
        choices.clear();
        if(this.position.x>0){
            choices.add(Directions.Left);
        }
        if(this.position.x<deadend.game.GameConfigClass.GridX){
            choices.add(Directions.Right);
        }
        if(this.position.y>0){
            choices.add(Directions.Up);
        }
        if(this.position.y<deadend.game.GameConfigClass.GridY){
            choices.add(Directions.Down);
        }

        int c=rand.nextInt(choices.size());
        if(step==1){
            this.first=choices.get(c);
            //System.out.println(this.first.toString());
        }

        Point p=this.position;
        Directions dir=choices.get(c);
        if(dir==Directions.Up){
            this.position.setLocation(p.x,p.y-1);
        }
        if(dir==Directions.Down){
            this.position.setLocation(p.x,p.y+1);
        }
        if(dir==Directions.Left){
            this.position.setLocation(p.x-1, p.y);
        }
        if(dir==Directions.Right){
            this.position.setLocation(p.x+1, p.y);
        }
    }
}
