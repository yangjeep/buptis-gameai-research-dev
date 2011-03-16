/*
 * deadend.ai.cat.CatZigzagFSM
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.ai.cat.CatZigzagFSM is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.cat.CatZigzagFSM is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.ai.cat;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import deadend.ai.StrategyInterface;
import deadend.globalenum.Directions;
import deadend.game.*;
import deadend.roles.*;

/**
 *
 * @author Yang JiaJian
 */
public class CatZigzagFSM implements StrategyInterface{
    Directions initDir;
    Directions revDir;
    boolean isTouched=false;
    /**
     *
     * @param game
     * @return
     */
    @Override public Directions compute(DeadEndGame game){
        ArrayList<Point> doors=game.door;
        ArrayList<Dog> dogs=game.dogs.dogTeam;

        Point player=game.player.getPosition();

        int step=game.step;

        Random rand=new Random();

        if(step==1){
            boolean r=rand.nextBoolean();
            if(r) {
                this.initDir = Directions.Left;
                this.revDir=Directions.Right;
            }
            else{
                this.initDir=Directions.Right;
                this.revDir=Directions.Left;
            }
        }

        // Find nearest door
        int ne=0;
        double k=player.distance(doors.get(0));
        for(int i=0;i<doors.size();i++){
            if(player.distance(doors.get(i))<k){
                ne=i;
                k=player.distance(doors.get(i));
            }
        }
        Point targetDoor=doors.get(ne);

        boolean isDanger=false;
        Point dd=null;
        double dist=20;
        for(Dog d:dogs){
            if((Math.abs(d.getPosition().x-player.x)<=2)
                    && (player.y-d.getPosition().y>0)
                    && (player.y-d.getPosition().y<4)
                    ){
                isDanger=true;
                dd=d.getPosition();
                if(dd.distance(player)<dist)dist=dd.distance(player);
            }
        }

        if(isDanger){
            if(this.isTouched){
                ArrayList<Directions> ret=new ArrayList<Directions>();
                if(targetDoor.x>player.x && Math.abs(player.x-dd.x)!=1){
                    ret.add(this.revDir);
                }
                if(targetDoor.y<player.y && player.x-dd.x==1){
                    ret.add(Directions.Up);
                }
                int rt=0;
                if(ret.size()!=0){
                    rand.nextInt(ret.size());
                    return ret.get(rt);
                }
            }
            else{
                ArrayList<Directions> ret=new ArrayList<Directions>();
                if(targetDoor.x>player.x && Math.abs(player.x-dd.x)!=1){
                    ret.add(this.initDir);
                }
                if(targetDoor.y<player.y && player.x-dd.x==1){
                    ret.add(Directions.Up);
                }
                int rt=0;
                if(ret.size()!=0){
                    rand.nextInt(ret.size());
                    return ret.get(rt);
                }
            }
        }

        

        if(this.initDir==Directions.Left){
            if(!this.isTouched){
                if(player.y<deadend.game.GameConfigClass.GridY/2){
                    this.isTouched=true;
                }
                if(player.x>0){
                    if(rand.nextBoolean()){
                        return this.initDir;
                    }
                    else return Directions.Up;
                }
                else{
                    this.isTouched=true;
                    if(rand.nextBoolean()){
                        return this.initDir;
                    }
                    else return Directions.Up;
                }
            }else{
                ArrayList<Directions> ret=new ArrayList<Directions>();
                if(targetDoor.x>player.x){
                    ret.add(Directions.Right);
                }
                if(targetDoor.x<player.x){
                    ret.add(Directions.Left);
                }
                if(targetDoor.y<player.y){
                    ret.add(Directions.Up);
                }
                int rt=0;
                if(ret.size()!=0)rand.nextInt(ret.size());
                else return Directions.Still;
                return ret.get(rt);
            }
        }
        else{
            if(!this.isTouched){
                if(player.y<deadend.game.GameConfigClass.GridY/2){
                    this.isTouched=true;
                }
                if(player.x<(deadend.game.GameConfigClass.GridX-1)){
                        if(rand.nextBoolean()){
                            return this.initDir;
                        }
                        else return Directions.Up;
                }
                else{
                    this.isTouched=true;
                        if(rand.nextBoolean()){
                            return this.initDir;
                        }
                        else {
                            return Directions.Up;
                        }
                }
            }else{
                ArrayList<Directions> ret=new ArrayList<Directions>();
                if(targetDoor.x>player.x){
                    ret.add(Directions.Right);
                }
                if(targetDoor.x<player.x){
                    ret.add(Directions.Left);
                }
                if(targetDoor.y<player.y){
                    ret.add(Directions.Up);
                }
                int rt=rand.nextInt(ret.size());
                return ret.get(rt);
            }
        }

    }

    /**
     *
     */
    @Override
    public void reset(){
        this.initDir=null;
        this.revDir=null;
        this.isTouched=false;
    }
    /**
     *
     * @return
     */
    @Override
    public String getName(){
        return "ZigZagFSM";
    }
}
