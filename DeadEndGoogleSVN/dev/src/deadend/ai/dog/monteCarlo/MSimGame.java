/*
 * deadend.ai.monteCarlo.MSimGame
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.ai.monteCarlo.MSimGame is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.monteCarlo.MSimGame is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.ai.dog.monteCarlo;

import deadend.roles.*;
import deadend.globalenum.*;
import deadend.game.*;
import java.awt.Point;
import java.util.ArrayList;
/**
 *
 * @author Yang JiaJian
 */
public class MSimGame {
    // TODO add the logic of an original game
    public MSimGame(DeadEndGame game,Cat cat,ArrayList<Dog> dogs){
        this.game=game;
        this.nextDir=new ArrayList<Directions>(dogs.size());
        this.simResult=GameResults.NotEnd;

        this.scat=new MCat((Point)cat.getPosition().clone());
        this.sdogs=new ArrayList<MDog>(dogs.size());
        for(int i=0;i<dogs.size();i++){
            Point p=(Point)dogs.get(0).getPosition().clone();
            MDog d=new MDog(p);
            this.sdogs.add(d);
        }
        this.isFinished=false;
    }
    public void reset(DeadEndGame game,Cat cat,ArrayList<Dog> dogs){
        this.game=game;
        this.nextDir=new ArrayList<Directions>(dogs.size());
        this.simResult=GameResults.NotEnd;

        this.scat=new MCat((Point)cat.getPosition().clone());
        this.sdogs.clear();
        this.sdogs=new ArrayList<MDog>(dogs.size());
        for(int i=0;i<dogs.size();i++){
            Point p=(Point)dogs.get(0).getPosition().clone();
            MDog d=new MDog(p);
            this.sdogs.add(d);
        }
        this.isFinished=false;
    }
    public ArrayList<Directions> nextDir;
    public GameResults simResult;
    private DeadEndGame game;

    private MCat scat;
    private ArrayList<MDog> sdogs;

    private int step;

    public boolean isFinished;
    public boolean runSim(){
        for(this.step=1;this.step<=this.game.LimitStep-this.step;this.step++){
            this.judge();
            if(this.isFinished)break;
            if(this.step>=this.game.LimitStep){
                this.isFinished=true;
                this.simResult=GameResults.Draw;
                break;
            }
            for(int s=1;s<=this.game.player.getSpeed();s++){
                this.scat.rMove();
            }
            for(MDog m:this.sdogs){
                m.rMove(step);
            }
        }
        // TODO record the first step of dogs
        this.nextDir.clear();
        
        for(int i=0;i<this.sdogs.size();i++){
            this.nextDir.add(this.sdogs.get(i).first);
        }
        return true;
    }
    public void runToDeath(){
        while(!this.isFinished){
            this.runSim();
        }
    }
    private void judge(){
        for(Point p:this.game.door){
            if(this.scat.position.equals(p)){
                this.simResult=GameResults.CatWin;
                this.isFinished=true;
            }
        }
        for(MDog p:this.sdogs){
            if(p.position.equals(this.scat)){
                this.simResult=GameResults.DogWin;
                this.isFinished=true;
            }
        }
    }
}
