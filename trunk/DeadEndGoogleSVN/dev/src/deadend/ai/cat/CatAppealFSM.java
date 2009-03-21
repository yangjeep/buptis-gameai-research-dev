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
/**
 *
 * @author Yang JiaJian
 */
public class CatAppealFSM implements StrategyInterface{

    @Override
    public Directions compute(DeadEndGame game){
        // Find the nearest dog on y axis
        int shortestY=game.player.getPosition().y-game.dogs.dogTeam.get(0).getPosition().y;
        int nearDogX=game.dogs.dogTeam.get(0).getPosition().x;
        int nearDogID=0;
        for(int i=0;i<game.dogs.dogTeam.size();i++){
            int dify=game.player.getPosition().y-game.dogs.dogTeam.get(i).getPosition().y;
            if(dify<shortestY){
                nearDogX=game.dogs.dogTeam.get(i).getPosition().x;
                nearDogID=i;
            }
        }

        Random rand=new Random();

        ArrayList<Point> doors=game.door;
        Point player=game.player.getPosition();
        // Oscillate
        if(Math.abs(shortestY)>10){
            if(rand.nextBoolean()){
                return Directions.Left;
            }
            else return Directions.Right;
        }else{
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
        }
        return null;
    }

    @Override
    public void reset(){
    }

    @Override
    public String getName(){ return "CounterStrike"; }
}
