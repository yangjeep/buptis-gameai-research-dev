/*
 * deadend.ai.cat.CatBasicFSM
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.ai.cat.CatBasicFSM is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.cat.CatBasicFSM is distributed in the hope that it will be useful, but
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

import deadend.ai.StrategyInterface;
import deadend.globalenum.Directions;
import deadend.game.*;
import deadend.roles.*;
/**
 *
 * @author Yang JiaJian
 */
public class CatBasicFSM implements StrategyInterface{
    @Override public Directions compute(DeadEndGame game){
        ArrayList<Point> doors=game.door;
        ArrayList<Dog> dogs=game.dogs.dogTeam;

        Point player=game.player.getPosition();
        boolean escape=false;
        java.util.Random rand=new java.util.Random();
        for(Dog d:dogs){
            if(d.getPosition().distance(player)<2){
                /**
                 * escape mode
                 */
                if(d.getPosition().x>player.x)return Directions.Up;
                if(d.getPosition().x<player.x)return Directions.Up;
                if(d.getPosition().y<player.y){
                    float r=rand.nextFloat();
                    if(r>0.5){
                        return Directions.Left;
                    }else{
                        return Directions.Right;
                    }
                }
            }
        }

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
        if(doors.get(target).x>player.x)return Directions.Right;
        if(doors.get(target).x<player.x)return Directions.Left;

        if(player.y>=0){return Directions.Up;}
        return null;
    }
}
