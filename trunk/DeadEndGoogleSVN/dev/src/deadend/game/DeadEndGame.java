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

import deadend.database.StepRecordBuffer;
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

    public boolean isReseted;

    public Timer ticker;
    public int refreshTime;

    public ArrayList<Point> door;

    public ArrayList<deadend.database.StepRecordBuffer> stepRecordBuf;

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

    // Constructor
    public DeadEndGame(){

    }
    // Initialize
    public void intialize(){
        this.LimitStep=GameConfigClass.Step_Limit;
        this.gameresult=GameResults.NotEnd;
        this.isAutoRun=false;
        this.isGameEnd=true;
        this.isPaused=false;

        this.step=0;

        this.isTaskFinished=true;

        this.door=new ArrayList<Point>();
        int x,y;
        x=GameConfigClass.GridX/2-1;
        y=0;
        door.add(new Point(x,y));
        x++;
        door.add(new Point(x,y));

        // Initialize the player and npc
        this.player=new Cat(this);
        this.dogs=new DogTeam(this);

        this.player.initialize();
        this.dogs.initialize();

        //Initialize the timer
        this.refreshTime=GameConfigClass.InitRefreshTimeMS/(GameConfigClass.CatSpeed+1);
        this.ticker=new Timer(this.refreshTime,this);
        this.prevDelay=this.refreshTime;

        this.prevDelayRecorded=false;
        //
        this.stepRecordBuf=new ArrayList<deadend.database.StepRecordBuffer>();

        this.isReseted=true;

        this.remainder=0;
    }
    /**
     * When starting the game it enters the main loop
     */
    public void StartAGame(){
        if(!this.isReseted){
            this.reset();
        }
        if(!this.isAutoRun)this.ticker.setDelay(this.refreshTime);
        this.ticker.start();
        this.isReseted=false;

    }

    public void StartAGame(int time){
        this.refreshTime=GameConfigClass.ComputingTimeLimit;
        if(!this.isReseted){
            this.reset();
        }
        this.isReseted=false;
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

    int remainder;

    /***/
    int catToDog1x,catToDog1y,catToDog2x,catToDog2y,catToExitX,catToExitY;
    double catToDog1,catToDog2;
    double catDog1Angle;
    double catDog2Angle;
    int catToLeft;
    int catToRight;
    int catToTop;
    int catToBottom;
    int dog1ToLeft;
    int dog1ToRight;
    int dog1ToTop;
    int dog1ToBottom;

    int dog2ToLeft;
    int dog2ToRight;
    int dog2ToTop;
    int dog2ToBottom;

    double dogInnerDist;
    int dog1ToExitX;
    int dog1ToExitY;

    int dog2ToExitX;
    int dog2ToExitY;


    private boolean prevDelayRecorded;
    @Override
    public void actionPerformed(ActionEvent e){
        if(this.i==1 && this.isAutoRun && !this.prevDelayRecorded){
            this.prevDelayRecorded=true;
            this.prevDelay=this.ticker.getDelay();
            this.ticker.setDelay(0);
        }
        if(this.isAutoRun){
            System.out.println("Recorded:"+this.i);
        }
        this.judge();
        if(this.gameresult!=GameResults.NotEnd){
            this.ticker.stop();
            return;
        }
        if(this.isPaused){
            this.ticker.stop();
            return;
        }
        if(this.remainder==0){
            this.step++;
            this.remainder++;
            this.player.compute();
            this.judge();
        }
        else if(this.remainder==1){
            this.remainder++;
            this.player.compute();
            this.judge();        }
        else if(this.remainder==2){

            catToDog1x=this.player.getPosition().x-this.dogs.dogTeam.get(0).getPosition().x;
            catToDog1y=this.player.getPosition().y-this.dogs.dogTeam.get(0).getPosition().y;
            catToDog2x=this.player.getPosition().x-this.dogs.dogTeam.get(1).getPosition().x;
            catToDog2y=this.player.getPosition().y-this.dogs.dogTeam.get(1).getPosition().y;
            catToExitX=this.player.getPosition().x-this.door.get(0).x;
            catToExitY=this.player.getPosition().y-this.door.get(0).y;
            catToDog1=this.player.getPosition().distance(this.dogs.dogTeam.get(0).getPosition());
            catToDog2=this.player.getPosition().distance(this.dogs.dogTeam.get(1).getPosition());

            if(this.player.getPosition().x-this.dogs.dogTeam.get(0).getPosition().x!=0){
                catDog1Angle=
                        (this.player.getPosition().y-this.dogs.dogTeam.get(0).getPosition().y)/
                        (this.player.getPosition().x-this.dogs.dogTeam.get(0).getPosition().x)
                        ;
            }
            else{
                catDog1Angle=1;
            }
            if(this.player.getPosition().x-this.dogs.dogTeam.get(1).getPosition().x!=0){
                catDog2Angle=
                        (this.player.getPosition().y-this.dogs.dogTeam.get(1).getPosition().y)/
                        (this.player.getPosition().x-this.dogs.dogTeam.get(1).getPosition().x)
                        ;
            }            else{
                catDog2Angle=1;
            }             catToLeft=this.player.getPosition().x-0;
            catToRight=GameConfigClass.GridX-this.player.getPosition().x;
            catToTop=this.player.getPosition().y-0;
            catToBottom=GameConfigClass.GridY-this.player.getPosition().y;
            dog1ToLeft=this.dogs.dogTeam.get(0).getPosition().x-0;
            dog1ToRight=GameConfigClass.GridX-this.dogs.dogTeam.get(0).getPosition().x;
            dog1ToTop=this.dogs.dogTeam.get(0).getPosition().y-0;
            dog1ToBottom=GameConfigClass.GridY-this.dogs.dogTeam.get(0).getPosition().y;
            dog2ToLeft=this.dogs.dogTeam.get(1).getPosition().x-0;
            dog2ToRight=GameConfigClass.GridX-this.dogs.dogTeam.get(1).getPosition().x;
            dog2ToTop=this.dogs.dogTeam.get(1).getPosition().y-0;
            dog2ToBottom=GameConfigClass.GridY-this.dogs.dogTeam.get(1).getPosition().y;
            dogInnerDist=this.dogs.dogTeam.get(0).getPosition().distance(this.dogs.dogTeam.get(1).getPosition());
            dog1ToExitX=this.dogs.dogTeam.get(0).getPosition().x-this.door.get(0).x;
            dog1ToExitY=this.dogs.dogTeam.get(0).getPosition().x-this.door.get(0).y;
            dog2ToExitX=this.dogs.dogTeam.get(1).getPosition().x-this.door.get(0).x;
            dog2ToExitY=this.dogs.dogTeam.get(1).getPosition().x-this.door.get(0).y;

            this.dogs.compute();
            this.remainder=0;
            this.judge();

            deadend.globalenum.Directions dog1Dir,dog2Dir;

            dog1Dir=this.dogs.dogTeam.get(0).getDirection();
            dog2Dir=this.dogs.dogTeam.get(1).getDirection();

            this.dogs.removeDirection();
            deadend.database.StepRecordBuffer buf=new deadend.database.StepRecordBuffer(
                    catToDog1x, catToDog1y, catToDog2x, catToDog2y,
                    catToDog1, catToDog2, catToExitX, catToExitY,
                    catDog1Angle, catDog2Angle,
                    catToLeft, catToRight, catToTop, catToBottom,
                    dog1ToLeft, dog1ToRight, dog1ToTop, dog1ToBottom,
                    dog2ToLeft, dog2ToRight, dog2ToTop, dog2ToBottom,
                    dogInnerDist, dog1ToExitX, dog1ToExitY, dog2ToExitX, dog2ToExitY,
                    step, dog1Dir, dog2Dir);
            this.stepRecordBuf.add(buf);
        }

        if(this.gameresult!=GameResults.NotEnd && this.isAutoRun){
            this.reset();
        }

    }
    /**
     * @param e
     * @deprecated
     */
    public void actionPerformedOld(ActionEvent e){
        this.judge();
        if(this.gameresult!=GameResults.NotEnd){
            this.ticker.stop();
            return;
        }
        if(this.isPaused){
            this.ticker.stop();
            return;
        }
        for(int i=1;i<=this.player.getSpeed();i++){
            this.player.compute();
        }

        int catToDog1x,catToDog1y,catToDog2x,catToDog2y,catToExitX,catToExitY;

        catToDog1x=this.player.getPosition().x-this.dogs.dogTeam.get(0).getPosition().x;
        catToDog1y=this.player.getPosition().y-this.dogs.dogTeam.get(0).getPosition().y;
        catToDog2x=this.player.getPosition().x-this.dogs.dogTeam.get(1).getPosition().x;
        catToDog2y=this.player.getPosition().y-this.dogs.dogTeam.get(1).getPosition().y;

        catToExitX=this.player.getPosition().x-this.door.get(0).x;
        catToExitY=this.player.getPosition().y-this.door.get(0).y;

        double catToDog1,catToDog2;

        catToDog1=this.player.getPosition().distance(this.dogs.dogTeam.get(0).getPosition());
        catToDog2=this.player.getPosition().distance(this.dogs.dogTeam.get(1).getPosition());

        double catDog1Angle;
        if(this.player.getPosition().x-this.dogs.dogTeam.get(0).getPosition().x!=0){
            catDog1Angle=
                (this.player.getPosition().y-this.dogs.dogTeam.get(0).getPosition().y)/
                (this.player.getPosition().x-this.dogs.dogTeam.get(0).getPosition().x)
                ;
        }
        else{
            catDog1Angle=1;
        }
        double catDog2Angle;
        if(this.player.getPosition().x-this.dogs.dogTeam.get(1).getPosition().x!=0){
            catDog2Angle=
                (this.player.getPosition().y-this.dogs.dogTeam.get(1).getPosition().y)/
                (this.player.getPosition().x-this.dogs.dogTeam.get(1).getPosition().x)
                ;
        }
        else{
            catDog2Angle=1;
        }


        int catToLeft=this.player.getPosition().x-0;
        int catToRight=GameConfigClass.GridX-this.player.getPosition().x;
        int catToTop=this.player.getPosition().y-0;
        int catToBottom=GameConfigClass.GridY-this.player.getPosition().y;

        int dog1ToLeft=this.dogs.dogTeam.get(0).getPosition().x-0;
        int dog1ToRight=GameConfigClass.GridX-this.dogs.dogTeam.get(0).getPosition().x;
        int dog1ToTop=this.dogs.dogTeam.get(0).getPosition().y-0;
        int dog1ToBottom=GameConfigClass.GridY-this.dogs.dogTeam.get(0).getPosition().y;

        int dog2ToLeft=this.dogs.dogTeam.get(1).getPosition().x-0;
        int dog2ToRight=GameConfigClass.GridX-this.dogs.dogTeam.get(1).getPosition().x;
        int dog2ToTop=this.dogs.dogTeam.get(1).getPosition().y-0;
        int dog2ToBottom=GameConfigClass.GridY-this.dogs.dogTeam.get(1).getPosition().y;

        double dogInnerDist=this.dogs.dogTeam.get(0).getPosition().distance(this.dogs.dogTeam.get(1).getPosition());
        int dog1ToExitX=this.dogs.dogTeam.get(0).getPosition().x-this.door.get(0).x;
        int dog1ToExitY=this.dogs.dogTeam.get(0).getPosition().x-this.door.get(0).y;

        int dog2ToExitX=this.dogs.dogTeam.get(1).getPosition().x-this.door.get(0).x;
        int dog2ToExitY=this.dogs.dogTeam.get(1).getPosition().x-this.door.get(0).y;
        //this.judge();

        this.dogs.compute();

        deadend.globalenum.Directions dog1Dir,dog2Dir;

        dog1Dir=this.dogs.dogTeam.get(0).getDirection();
        dog2Dir=this.dogs.dogTeam.get(1).getDirection();

        this.dogs.removeDirection();

        /*
        deadend.database.StepRecordBuffer buf=new deadend.database.StepRecordBuffer(
                catToDog1x, catToDog1y, catToDog2x, catToDog2y,
            catToDog1, catToDog2, catToExitX, catToExitY,
            this.step, dog1Dir, dog2Dir);
         */
        deadend.database.StepRecordBuffer buf=new deadend.database.StepRecordBuffer(
                catToDog1x, catToDog1y, catToDog2x, catToDog2y,
                catToDog1, catToDog2, catToExitX, catToExitY,
                catDog1Angle, catDog2Angle,
                catToLeft, catToRight, catToTop, catToBottom,
                dog1ToLeft, dog1ToRight, dog1ToTop, dog1ToBottom,
                dog2ToLeft, dog2ToRight, dog2ToTop, dog2ToBottom,
                dogInnerDist, dog1ToExitX, dog1ToExitY, dog2ToExitX, dog2ToExitY,
                step, dog1Dir, dog2Dir);
        this.stepRecordBuf.add(buf);

        this.judge();

    }

    public void playGame(){
        this.judge();
        if(this.gameresult!=GameResults.NotEnd){
            this.ticker.stop();
            return;
        }
        if(this.isPaused){
            this.ticker.stop();
            return;
        }
            if(this.remainder==0){
                this.step++;
                this.remainder++;
                this.player.compute();
                this.judge();
            }
            else if(this.remainder==1){
                this.remainder++;
                this.player.compute();
                this.judge();
            }
            else if(this.remainder==2){

                catToDog1x=this.player.getPosition().x-this.dogs.dogTeam.get(0).getPosition().x;
                catToDog1y=this.player.getPosition().y-this.dogs.dogTeam.get(0).getPosition().y;
                catToDog2x=this.player.getPosition().x-this.dogs.dogTeam.get(1).getPosition().x;
                catToDog2y=this.player.getPosition().y-this.dogs.dogTeam.get(1).getPosition().y;

                catToExitX=this.player.getPosition().x-this.door.get(0).x;
                catToExitY=this.player.getPosition().y-this.door.get(0).y;

                catToDog1=this.player.getPosition().distance(this.dogs.dogTeam.get(0).getPosition());
                catToDog2=this.player.getPosition().distance(this.dogs.dogTeam.get(1).getPosition());

                if(this.player.getPosition().x-this.dogs.dogTeam.get(0).getPosition().x!=0){
                    catDog1Angle=
                            (this.player.getPosition().y-this.dogs.dogTeam.get(0).getPosition().y)/
                            (this.player.getPosition().x-this.dogs.dogTeam.get(0).getPosition().x)
                            ;
                }
                else{
                    catDog1Angle=1;
                }

                if(this.player.getPosition().x-this.dogs.dogTeam.get(1).getPosition().x!=0){
                    catDog2Angle=
                            (this.player.getPosition().y-this.dogs.dogTeam.get(1).getPosition().y)/
                            (this.player.getPosition().x-this.dogs.dogTeam.get(1).getPosition().x)
                            ;
                }
                else{
                    catDog2Angle=1;
                }
                catToLeft=this.player.getPosition().x-0;
                catToRight=GameConfigClass.GridX-this.player.getPosition().x;
                catToTop=this.player.getPosition().y-0;
                catToBottom=GameConfigClass.GridY-this.player.getPosition().y;
                dog1ToLeft=this.dogs.dogTeam.get(0).getPosition().x-0;
                dog1ToRight=GameConfigClass.GridX-this.dogs.dogTeam.get(0).getPosition().x;
                dog1ToTop=this.dogs.dogTeam.get(0).getPosition().y-0;
                dog1ToBottom=GameConfigClass.GridY-this.dogs.dogTeam.get(0).getPosition().y;
                dog2ToLeft=this.dogs.dogTeam.get(1).getPosition().x-0;
                dog2ToRight=GameConfigClass.GridX-this.dogs.dogTeam.get(1).getPosition().x;
                dog2ToTop=this.dogs.dogTeam.get(1).getPosition().y-0;
                dog2ToBottom=GameConfigClass.GridY-this.dogs.dogTeam.get(1).getPosition().y;
                dogInnerDist=this.dogs.dogTeam.get(0).getPosition().distance(this.dogs.dogTeam.get(1).getPosition());
                dog1ToExitX=this.dogs.dogTeam.get(0).getPosition().x-this.door.get(0).x;
                dog1ToExitY=this.dogs.dogTeam.get(0).getPosition().x-this.door.get(0).y;
                dog2ToExitX=this.dogs.dogTeam.get(1).getPosition().x-this.door.get(0).x;
                dog2ToExitY=this.dogs.dogTeam.get(1).getPosition().x-this.door.get(0).y;
                this.dogs.compute();
                this.remainder=0;
                this.judge();

                deadend.globalenum.Directions dog1Dir,dog2Dir;

                dog1Dir=this.dogs.dogTeam.get(0).getDirection();
                dog2Dir=this.dogs.dogTeam.get(1).getDirection();

                this.dogs.removeDirection();
                deadend.database.StepRecordBuffer buf=new deadend.database.StepRecordBuffer(
                        catToDog1x, catToDog1y, catToDog2x, catToDog2y,
                        catToDog1, catToDog2, catToExitX, catToExitY,
                        catDog1Angle, catDog2Angle,
                        catToLeft, catToRight, catToTop, catToBottom,
                        dog1ToLeft, dog1ToRight, dog1ToTop, dog1ToBottom,
                        dog2ToLeft, dog2ToRight, dog2ToTop, dog2ToBottom,
                        dogInnerDist, dog1ToExitX, dog1ToExitY, dog2ToExitX, dog2ToExitY,
                        step, dog1Dir, dog2Dir);
                this.stepRecordBuf.add(buf);
            }
        this.judge();
    }

    // Reset logic
    public void reset(){
        if(this.gameresult!=GameResults.NotEnd){
            if(this.gameresult==GameResults.DogWin && !this.dogs.getStrategy().goodRound)
            {
                System.out.println("No record");
                this.recordGameResultToODBC();
            }
            else {
                this.recordGameResultToODBC();
                this.recordStepToODBC();
            }
        }
        this.dogs.getStrategy().goodRound=false;

        this.gameresult=GameResults.NotEnd;
        //this.isAutoRun=false;
        this.isGameEnd=true;
        this.isPaused=false;
        this.step=0;

        this.isTaskFinished=true;

        this.player.reset();
        this.dogs.reset();

        this.stepRecordBuf.clear();

        this.isReseted=true;

        if(this.isAutoRun){
            i++;
        }
        if(this.i<this.autoRun_Rounds){
            this.ticker.start();
        }
        if(this.i==this.autoRun_Rounds){
            this.ticker.stop();
            this.isAutoRun=false;
            this.i=0;
            this.ticker.setDelay(this.prevDelay);
            this.prevDelayRecorded=false;
        }
        if(!this.isAutoRun){
            this.ticker.setDelay(this.refreshTime);
        }
    }

    // logic to manipulate data
    private void recordStepToODBC(){
        // record the step
        deadend.database.odbc.ODBCWrite.writeStep(this);
    }
    private void recordGameResultToODBC(){
        // record the game result
        deadend.database.odbc.ODBCWrite.writeMCTime(this);
    }
    private void appendResultToStepODBC(){
        // query from the record and write it to another table
    }

    /**
     * This part is to judge the result
     */
    private void judge(){

        /**
         * Find if cat wins
         */
        for(Point d:this.door){
            if(this.player.getPosition().equals(d)){
                this.isGameEnd=true;
                this.gameresult=GameResults.CatWin;
            }
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
        
        /**
         * Find if the turns has been reached
         */
        if(this.step>=this.LimitStep){
            this.isGameEnd=true;
            this.gameresult=GameResults.Draw;
        }
    }

    public ArrayList<StepRecordBuffer> getStepRecordBuf() {
        return stepRecordBuf;
    }

    /**
     * This part is to implement the autorun feature
     *
     */
    public int autoRun_Rounds;
    public void initAutoRun(int totalRounds){
        this.autoRun_Rounds=totalRounds;
        this.i=1;
        this.isBreakTask=false;
        this.ticker.setDelay(0);
        this.reset();
    }
    private boolean isTaskFinished;
    private boolean isBreakTask;
    public void stopAutoRun(){
        this.isBreakTask=true;
    }
    public int i=1;

    public int prevDelay;
    /**
     * execute the autorun task
     */
    public void autoRun(){
        this.isAutoRun=true;
        this.StartAGame();
    }

    /**
     * execute the autorun task
     * @param gamePanel 
     */
    public void autoRun(deadend.gui.DeadEndGamePanel gamePanel){
        do{
            this.playGame();
            gamePanel.repaint();
            if(this.gameresult!=GameResults.NotEnd){
                this.reset();
                i++;
            }
            System.out.println("Record:"+this.i);
        }while(i<=this.autoRun_Rounds);
    }

}
