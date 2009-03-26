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

package deadend.ai.dog.monteCarloAdv;

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

    /**
     *
     * @param step
     * @param simGame
     */
    public void rMove(int step,MSimGame simGame){
        java.util.Random rand=new java.util.Random();
        java.util.ArrayList<Directions> choices=new java.util.ArrayList<Directions>();
        choices.clear();

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

        if(step==1){
            this.first=dir;
            if(this.position.x-simGame.scat.position.x==1 &&
                    this.position.y-simGame.scat.position.y==0)this.first=Directions.Left;
            if(this.position.x-simGame.scat.position.x==-1 &&
                    this.position.y-simGame.scat.position.y==0)this.first=Directions.Right;
            if(this.position.x-simGame.scat.position.x==0 &&
                    this.position.y-simGame.scat.position.y==1)this.first=Directions.Down;
            if(this.position.x-simGame.scat.position.x==0 &&
                    this.position.y-simGame.scat.position.y==-1)this.first=Directions.Up;
            //System.out.println(this.first.toString());
            dir=this.first;
        }

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
     * 
     * @deprecated
     * @param step
     */
    public void rMove1(int step){
        java.util.Random rand=new java.util.Random();
        java.util.ArrayList<Directions> choices=new java.util.ArrayList<Directions>();
        choices.clear();
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
        if(step==1){
            this.first=choices.get(c);
            //System.out.println(this.first.toString());
        }

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
