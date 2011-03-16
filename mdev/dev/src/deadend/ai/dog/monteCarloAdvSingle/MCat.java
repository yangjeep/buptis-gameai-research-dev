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

package deadend.ai.dog.monteCarloAdvSingle;

import java.awt.*;

import deadend.globalenum.Directions;
/**
 *
 * @author Yang JiaJian
 */
public class MCat {
    Point position;
    /**
     *
     * @param position
     */
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

        MDog nearDog=simGame.sdogs.get(0);
        int nearDogID=0;
        double nearDist=simGame.sdogs.get(0).position.distance(this.position);
        for(int i=0;i<simGame.sdogs.size();i++){
            double dist=simGame.sdogs.get(i).position.distance(this.position);
            if(dist<nearDist){
                nearDog=simGame.sdogs.get(i);
                nearDogID=i;
                nearDist=dist;
            }
        }

        nearDog=simGame.sdogs.get(nearDogID);
        
        if(this.position.x>0){
            if(this.position.x-1==nearDog.position.x && this.position.y==nearDog.position.y){}
                else
                    choices.add(Directions.Left);
        }
        if(this.position.x<deadend.game.GameConfigClass.GridX-1){
            if(this.position.x+1==nearDog.position.x && this.position.y==nearDog.position.y){}
                else
                    choices.add(Directions.Right);
        }
        if(this.position.y>0){
            if(this.position.x==nearDog.position.x && this.position.y-1==nearDog.position.y){}
                else
                    choices.add(Directions.Up);
        }
        /*if(this.position.y<deadend.game.GameConfigClass.GridY-1){
        if(this.position.x==nearDog.position.x && this.position.y+1==nearDog.position.y){}
        else
        choices.add(Directions.Down);
        }*/

        if(choices.size()<=0)choices.add(Directions.Still);
        int c=rand.nextInt(choices.size());

        Point p=(Point)this.position.clone();
        Directions dir=choices.get(c);

        java.util.ArrayList<Point> doors=simGame.game.door;
        Point nearDoor=doors.get(0);
        int id=0;
        double nd=this.position.distance(nearDoor);
        for(int l=0;l<doors.size();l++){
            double dist=this.position.distance(doors.get(l));
            if(dist<nd){
                id=l;
                nearDoor=doors.get(id);
            }
        }

        if(this.position.x-nearDoor.x==1 && this.position.y-nearDoor.y==0){
            dir=Directions.Left;
        }
        if(this.position.x-nearDoor.x==-1 && this.position.y-nearDoor.y==0){
            dir=Directions.Right;
        }
        if(this.position.x-nearDoor.x==0 && this.position.y-nearDoor.y==1){
            dir=Directions.Up;
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
