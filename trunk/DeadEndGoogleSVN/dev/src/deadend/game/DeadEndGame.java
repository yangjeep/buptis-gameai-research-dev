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


import deadend.roles.*;
import deadend.globalenum.GameResults;
import deadend.database.odbc.*;
/**
 *
 * @author Yang JiaJian
 */
public class DeadEndGame {
    // The characters
    public Cat player;
    public DogTeam dogs;

    // Fields used in game
    public GameResults gameresult;
    public int step;
    public int LimitStep;
    public boolean isGameEnd;

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

        // TODO Initialize the player and npc
        this.player=new Cat(this);
        this.dogs=new DogTeam(this);

        this.player.initialize();
        this.dogs.initialize();
    }
    // TODO Update
    public void update(){
        
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
    }

    /**
     * This part is to implement the autorun feature
     *
     */
    private int autoRun_Rounds;
    public void initAutoRun(int totalRounds){

    }
    private boolean isTaskFinished;
    /**
     * execute the autorun task
     */
    public void autoRun(){
    }
}
