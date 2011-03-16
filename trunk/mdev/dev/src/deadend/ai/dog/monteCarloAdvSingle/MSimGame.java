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

package deadend.ai.dog.monteCarloAdvSingle;

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
    private double odist;
    private ArrayList<Double> odists;
    // the logic of an original game
    /**
     *
     * @param game
     * @param cat
     * @param dogs
     */
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

        this.step=game.step;

        this.odists=new ArrayList<Double>();
        for(Dog d:dogs){
            this.odists.add(new Double(d.getPosition().distance(cat.getPosition())));
        }
        /**
         *  double dist=dogs.get(0).getPosition().distance(cat.getPosition());
            for(Dog d:dogs){
            if(d.getPosition().distance(cat.getPosition())<dist)dist=d.getPosition().distance(cat.getPosition());
           }
           this.odist=dist;
         */
        

        this.count=1;
    }
    /**
     *
     * @param game
     * @param cat
     * @param dogs
     */
    public void reset(DeadEndGame game,Cat cat,ArrayList<Dog> dogs){
        this.game=game;
        this.nextDir=new ArrayList<Directions>(dogs.size());
        this.simResult=GameResults.NotEnd;

        this.scat=new MCat((Point)cat.getPosition().clone());
        this.sdogs.clear();
        

        this.step=game.step;

        for(int i=0;i<dogs.size();i++){
            Point p=(Point)dogs.get(0).getPosition().clone();
            MDog d=new MDog(p);
            this.sdogs.add(d);
        }
        this.isFinished=false;

        this.count=1;
    }
    /**
     *
     */
    public ArrayList<Directions> nextDir;
    /**
     *
     */
    public GameResults simResult;
    DeadEndGame game;

    MCat scat;
    /**
     *
     */
    public ArrayList<MDog> sdogs;

    int step;

    private int count;

    /**
     *
     */
    public boolean isFinished;
    /**
     *
     * @param remainder
     * @param dogID
     * @return
     */
    public boolean runSim(int remainder,int dogID){
        do{
            this.step++;
            this.judge();
            
            if(this.isFinished)break;
            
            for(int s=1;s<=deadend.game.GameConfigClass.CatSpeed;s++){
                this.scat.rMove(this);
            }
            for(int i=0;i<this.sdogs.size();i++){
                if(i==dogID)this.sdogs.get(i).rMove(count,this,remainder);
                //else this.sdogs.get(i).rMove(step, this);
            }
            count++;
            //if(!this.isFinished)continue;
            
        }while(this.step<=this.game.LimitStep);

        if(this.step>=this.game.LimitStep &&
                this.simResult!=GameResults.CatWin &&
                this.simResult!=GameResults.DogWin){
                this.isFinished=true;
                this.simResult=GameResults.Draw;
            }
        this.nextDir.clear();
        
        for(int i=0;i<this.sdogs.size();i++){
            this.nextDir.add(this.sdogs.get(i).first);
            //System.out.print(this.sdogs.get(i).first.toString());
        }
        //System.out.println();
        return true;
    }
    private void judge(){
        for(Point p:this.game.door){
            if(this.scat.position.equals(p)){
                this.simResult=GameResults.CatWin;
                this.isFinished=true;
                return;
            }
        }
        for(MDog p:this.sdogs){
            if(p.position.equals(this.scat.position)){
                this.simResult=GameResults.DogWin;
                this.isFinished=true;
            }
        }
        
    }
}
