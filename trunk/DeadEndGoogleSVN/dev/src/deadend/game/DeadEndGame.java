/*
 * deadend.game.DeadEndGamee
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.game.DeadEndGame is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * deadend.game.DeadEndGame is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.game;

import java.util.ArrayList;
import java.awt.Point;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import deadend.roles.*;
import deadend.globalenum.GameResults;
import deadend.database.odbc.*;
/**
 *
 * @author Yang JiaJian
 */
public class DeadEndGame implements ActionListener{
    // The characters
    public Cat player;
    public DogTeam dogs;

    // Fields used in game
    public GameResults gameresult;
    public int step;
    public int LimitStep;
    public boolean isGameEnd;

    public Timer ticker;
    public int refreshTime;

    public ArrayList<Point> door;

    // Tools access DB
    private ODBCWrite odbcWriter;
    private ODBCQuery odbcQuery;
    private ODBCManipulate odbcRewriter;

    /**
     * indicators represents if the game is autoruning
     */
    public boolean isAutoRun;

    //State control
    public boolean isPaused;

    // TODO Constructor
    public DeadEndGame(){

    }
    // TODO Initialize
    public void intialize(){
        this.LimitStep=GameConfigClass.Step_Limit;
        this.gameresult=GameResults.NotEnd;
        this.isAutoRun=false;
        this.isGameEnd=false;
        this.isPaused=false;
        this.step=0;

        this.door=new ArrayList<Point>();
        int x,y;
        x=GameConfigClass.GridX/2-1;
        y=0;
        door.add(new Point(x,y));
        x++;
        door.add(new Point(x,y));

        // TODO Initialize the player and npc
        this.player=new Cat(this);
        this.dogs=new DogTeam(this);

        this.player.initialize();
        this.dogs.initialize();

        //Initialize the timer
        this.refreshTime=GameConfigClass.InitRefreshTimeMS;
        this.ticker=new Timer(this.refreshTime,this);
    }
    /**
     * When starting the game it enters the main loop
     */
    public void StartAGame(){
        this.reset();
        this.ticker.start();
    }

    public void StopGame(){
        this.ticker.stop();
    }

    public void PulseGame(){
        if(!this.isPaused){
            this.isPaused=true;
            this.ticker.stop();
        }
    }
    public void ResumeGame(){
        if(this.isPaused){
            this.isPaused=false;
            this.ticker.start();
        }
    }

    public void setRefreshDelay(int delay){
        this.refreshTime=delay;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        this.step++;
        this.judge();
        if(this.isGameEnd || this.isPaused){
            this.ticker.stop();
            return;
        }
        for(int i=1;i<=this.player.getSpeed();i++){
            this.player.compute();
        }
        this.dogs.compute();
    }

    // TODO Reset logic
    public void reset(){
        this.gameresult=GameResults.NotEnd;
        this.isAutoRun=false;
        this.isGameEnd=false;
        this.isPaused=false;
        this.step=0;

        this.player.reset();
        this.dogs.reset();
    }

    // TODO add logic to manipulate data
    private void recordStepToODBC(){
        // TODO record the step
    }
    private void recordGameResultToODBC(){
        // TODO record the game result
    }
    private void appendResultToStepODBC(){
        // TODO query from the record and write it to another table
    }

    /**
     * This part is to judge the result
     */
    private void judge(){
        /**
         * Find if the turns has been reached
         */
        if(this.step>=this.LimitStep){
            this.isGameEnd=true;
        }
        /**
         * Find if dog wins
         */
        for(Dog d:this.dogs.dogTeam){
            if(d.getPosition().equals(this.player.getPosition())){
                this.isGameEnd=true;
                this.gameresult=GameResults.DogWin;
            }
        }
        if(this.isGameEnd && this.gameresult==GameResults.NotEnd){
            this.gameresult=GameResults.Draw;
        }
    }

    /**
     * This part is to implement the autorun feature
     *
     */
    private int autoRun_Rounds;
    public void initAutoRun(int totalRounds){
        this.autoRun_Rounds=totalRounds;
    }
    private boolean isTaskFinished;
    /**
     * execute the autorun task
     */
    public void autoRun(){
    }
}
