/*
 * deadend.ai.cat.CatAppealFSM
 * Copyright (C) Yang JiaJian 2009 <yangjeep@gmail.com>
 * deadend.ai.cat.CatAppealFSM is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.cat.CatAppealFSM is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.ai.cat;

import java.util.Random;
import java.util.ArrayList;
import java.awt.Point;

import deadend.globalenum.Directions;
import deadend.game.DeadEndGame;
import deadend.ai.StrategyInterface;
import deadend.roles.Dog;
/**
 *
 * @author Yang JiaJian
 */
public class CatAppealFSM implements StrategyInterface{

    private int catStep;

    public CatAppealFSM() {
        this.catStep=0;
    }


    @Override
    public Directions compute(DeadEndGame game){
        this.catStep++;
        
        ArrayList<Dog> dogs=game.dogs.dogTeam;
        ArrayList<Point> doors=game.door;
        Point player=game.player.getPosition();
        
        // Find if there is dangerous
        boolean isDanger=false;

        int nearDogID=0;
        double distNear=player.distance(dogs.get(0).getPosition());
        for(int i=0;i<dogs.size();i++){
            double dist=player.distance(dogs.get(i).getPosition());
            if(dist<distNear){
                distNear=dist;
                nearDogID=i;
            }
        }

        Point enemy=dogs.get(nearDogID).getPosition();

        Random rand=new Random();
        // If dangerous
        if(this.catStep==1){

           if(player.x==enemy.x && player.y-enemy.y==1){
               if(rand.nextBoolean())return Directions.Right;
               else return Directions.Left;
           }

           if(player.x-enemy.x==1 && player.y-enemy.y==1){
               if(rand.nextBoolean())return Directions.Right;
               else return Directions.Up;
           }

           if(player.x-enemy.x==-1 && player.y-enemy.y==1){
               if(rand.nextBoolean())return Directions.Left;
               else return Directions.Up;
           }

           if(player.x-enemy.x==-1 && player.y==enemy.y){
               return Directions.Up;
           }

           if(player.x-enemy.x==1 && player.y==enemy.y){
               return Directions.Up;
           }
        }
        if(this.catStep==2){

            if(player.x==enemy.x && player.y-enemy.y==1){
                this.catStep=0;
                if(rand.nextBoolean())return Directions.Left;
                else return Directions.Right;
            }

            if(player.x==enemy.x && player.y-enemy.y==2){
                this.catStep=0;
                if(rand.nextBoolean())return Directions.Left;
                else return Directions.Right;
            }

            if(player.x-enemy.x==1 && player.y-enemy.y==1){
                this.catStep=0;
                return Directions.Right;
            }

            if(player.x-enemy.x==-1 && player.y-enemy.y==1){
                this.catStep=0;
                return Directions.Left;
            }

            if(player.x-enemy.x==1 && player.y==enemy.y){
                this.catStep=0;
                return Directions.Up;
            }

            if(player.x-enemy.x==-1 && player.y==enemy.y){
                this.catStep=0;
                return Directions.Up;
            }
            
        }

        // Find the nearest door and go
        Point d=doors.get(0);
        double dis=d.distance(player);
        int target=0;
        for(int i=0;i<doors.size();i++){
            double ds=doors.get(i).distance(player);
            if(ds<dis){
                target=i;
                dis=ds;
            }
        }
        if(this.catStep==2)this.catStep=0;
        if(doors.get(target).x>player.x)return Directions.Right;
        if(doors.get(target).x<player.x)return Directions.Left;

        return Directions.Up;
    }

    @Override
    public void reset(){
        this.catStep=0;
    }

    @Override
    public String getName(){ return "CounterStrike"; }
}
