/*
 * deadend.ai.monteCarlo.MCat
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.ai.monteCarlo.MCat is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.monteCarlo.MCat is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.ai.dog.monteCarlo;

import java.awt.*;

import deadend.globalenum.Directions;
/**
 *
 * @author Yang JiaJian
 */
public class MCat {
    Point position;
    public MCat(Point position){
        this.position=position;
    }
    /**
     *
     * @param simGame
     */
    public void rMove(MSimGame simGame){
        java.util.Random rand=new java.util.Random();
        java.util.ArrayList<Directions> choices=new java.util.ArrayList<Directions>();
        if(this.position.x>0){
            choices.add(Directions.Left);
        }
        if(this.position.x<deadend.game.GameConfigClass.GridX-1){
            choices.add(Directions.Right);
        }
        if(this.position.y>0){
            choices.add(Directions.Up);
        }
        if(this.position.y<deadend.game.GameConfigClass.GridY-1){
            choices.add(Directions.Down);
        }

        int c=rand.nextInt(choices.size());

        Point p=(Point)this.position.clone();
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
    /**
     * @deprecated
     */
    public void rMove(){
        java.util.Random rand=new java.util.Random();
        java.util.ArrayList<Directions> choices=new java.util.ArrayList<Directions>();
        if(this.position.x>0){
            choices.add(Directions.Left);
        }
        if(this.position.x<deadend.game.GameConfigClass.GridX-1){
            choices.add(Directions.Right);
        }
        if(this.position.y>0){
            choices.add(Directions.Up);
        }
        if(this.position.y<deadend.game.GameConfigClass.GridY-1){
            choices.add(Directions.Down);
        }

        int c=rand.nextInt(choices.size());

        Point p=(Point)this.position.clone();
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
