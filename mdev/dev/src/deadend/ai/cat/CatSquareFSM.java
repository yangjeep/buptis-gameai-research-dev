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
public class CatSquareFSM implements StrategyInterface{

    private int catStep;

    /**
     *
     */
    public CatSquareFSM() {
        this.catStep=0;
    }

    private Directions side;

    private int turnStep;
    /**
     *
     * @param game
     * @return
     */
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
        if(game.step==1){
            this.turnStep=0;
            if(rand.nextBoolean())this.side=Directions.Left;
            else this.side=Directions.Right;
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
        

        // Directions
        int distx,disty;
        distx=enemy.x-player.x;
        disty=enemy.y-player.y;
        
        if(Math.abs(disty)>2 && this.turnStep==0){
            if(doors.get(target).y<player.y)return Directions.Up;
        }
        if(Math.abs(disty)<=2 && this.turnStep==0){
            this.turnStep=game.step;
            if(this.side==Directions.Left && player.x>0)return this.side;
            if(this.side==Directions.Right && player.x<deadend.game.GameConfigClass.GridX-1)return this.side;
        }

        if(this.turnStep!=0 && player.y>4){
            if(player.x>4 && this.side==Directions.Left)return this.side;
            if(player.x<deadend.game.GameConfigClass.GridX-4 && this.side==Directions.Right)return this.side;

            if(player.x<=4 && this.side==Directions.Left)return Directions.Up;
            if(player.x>=deadend.game.GameConfigClass.GridX-4 && this.side==Directions.Right)return Directions.Up;
        }

        if(doors.get(target).x>player.x)return (Directions.Right);
        if(doors.get(target).x<player.x)return (Directions.Left);
        return Directions.Up;
    }

    /**
     *
     */
    @Override
    public void reset(){
        this.catStep=0;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName(){ return "Square"; }
}
