/*
 * deadend.database.StepRecordBuffer
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.database.StepRecordBuffer is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.database.StepRecordBuffer is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.database;

import deadend.globalenum.Directions;
/**
 *
 * @author Yang JiaJian
 */
public class StepRecordBuffer {

    //v1
    private int catToDog1x;
    private int catToDog1y;
    private int catToDog2x;
    private int catToDog2y;

    private double catToDog1;
    private double catToDog2;

    private int catToExitX;
    private int catToExitY;

    //v2
    private double catDog1Angle;
    private double catDog2Angle;

    private int catToLeft;
    private int catToRight;
    private int catToTop;
    private int catToBottom;

    private int dog1ToLeft;
    private int dog1ToRight;
    private int dog1ToTop;
    private int dog1ToBottom;

    private int dog2ToLeft;
    private int dog2ToRight;
    private int dog2ToTop;
    private int dog2ToBottom;

    private double dogInnerDist;

    private int dog1ToExitX;
    private int dog1ToExitY;

    private int dog2ToExitX;
    private int dog2ToExitY;

    //v1
    private int turn;

    private Directions dog1Dir;
    private Directions dog2Dir;

    /**
     * @param catToDog1x 
     * @param catToDog2x
     * @param catToDog1y
     * @param catToDog1
     * @param catToDog2y
     * @param turn
     * @param catToDog2
     * @param catToExitY
     * @param catToExitX
     * @param dog2Dir
     * @param dog1Dir
     * @deprecated
     */
    public StepRecordBuffer(int catToDog1x, int catToDog1y, int catToDog2x, int catToDog2y, 
            double catToDog1, double catToDog2, int catToExitX, int catToExitY,
            int turn, Directions dog1Dir, Directions dog2Dir) {
        this.catToDog1x = catToDog1x;
        this.catToDog1y = catToDog1y;
        this.catToDog2x = catToDog2x;
        this.catToDog2y = catToDog2y;
        this.catToDog1 = catToDog1;
        this.catToDog2 = catToDog2;
        this.catToExitX = catToExitX;
        this.catToExitY = catToExitY;
        this.turn = turn;
        this.dog1Dir = dog1Dir;
        this.dog2Dir = dog2Dir;
    }

    /**
     * Constructor to record the game status
     * @param catToDog1x int
     * @param catToDog1y int
     * @param catToDog2x int
     * @param catToDog2y int
     * @param catToDog1 double
     * @param catToDog2 double
     * @param catToExitX int
     * @param catToExitY int
     * @param catDog1Angle double
     * @param catDog2Angle double
     * @param catToLeft int
     * @param catToRight int
     * @param catToTop int
     * @param catToBottom int
     * @param dog1ToLeft int
     * @param dog1ToRight int
     * @param dog1ToTop int
     * @param dog1ToBottom int
     * @param dog2ToLeft int
     * @param dog2ToRight int
     * @param dog2ToTop int
     * @param dog2ToBottom int
     * @param dogInnerDist double
     * @param dog1ToExitX int
     * @param dog1ToExitY int
     * @param dog2ToExitX int
     * @param dog2ToExitY int
     * @param turn int
     * @param dog1Dir Directions
     * @param dog2Dir Directions
     */
    public StepRecordBuffer(int catToDog1x, int catToDog1y, int catToDog2x, int catToDog2y, double catToDog1, double catToDog2, int catToExitX, int catToExitY, double catDog1Angle, double catDog2Angle, int catToLeft, int catToRight, int catToTop, int catToBottom, int dog1ToLeft, int dog1ToRight, int dog1ToTop, int dog1ToBottom, int dog2ToLeft, int dog2ToRight, int dog2ToTop, int dog2ToBottom, double dogInnerDist, int dog1ToExitX, int dog1ToExitY, int dog2ToExitX, int dog2ToExitY, int turn, Directions dog1Dir, Directions dog2Dir) {
        this.catToDog1x = catToDog1x;
        this.catToDog1y = catToDog1y;
        this.catToDog2x = catToDog2x;
        this.catToDog2y = catToDog2y;
        this.catToDog1 = catToDog1;
        this.catToDog2 = catToDog2;
        this.catToExitX = catToExitX;
        this.catToExitY = catToExitY;
        this.catDog1Angle = catDog1Angle;
        this.catDog2Angle = catDog2Angle;
        this.catToLeft = catToLeft;
        this.catToRight = catToRight;
        this.catToTop = catToTop;
        this.catToBottom = catToBottom;
        this.dog1ToLeft = dog1ToLeft;
        this.dog1ToRight = dog1ToRight;
        this.dog1ToTop = dog1ToTop;
        this.dog1ToBottom = dog1ToBottom;
        this.dog2ToLeft = dog2ToLeft;
        this.dog2ToRight = dog2ToRight;
        this.dog2ToTop = dog2ToTop;
        this.dog2ToBottom = dog2ToBottom;
        this.dogInnerDist = dogInnerDist;
        this.dog1ToExitX = dog1ToExitX;
        this.dog1ToExitY = dog1ToExitY;
        this.dog2ToExitX = dog2ToExitX;
        this.dog2ToExitY = dog2ToExitY;
        this.turn = turn;
        this.dog1Dir = dog1Dir;
        this.dog2Dir = dog2Dir;
    }



    /**
     *
     * @return
     */
    public double getCatToDog1() {
        return catToDog1;
    }

    /**
     *
     * @return
     */
    public int getCatToDog1x() {
        return catToDog1x;
    }

    /**
     *
     * @return
     */
    public int getCatToDog1y() {
        return catToDog1y;
    }

    /**
     *
     * @return
     */
    public double getCatToDog2() {
        return catToDog2;
    }

    /**
     *
     * @return
     */
    public int getCatToDog2x() {
        return catToDog2x;
    }

    /**
     *
     * @return
     */
    public int getCatToDog2y() {
        return catToDog2y;
    }

    /**
     *
     * @return
     */
    public int getCatToExitX() {
        return catToExitX;
    }

    /**
     *
     * @return
     */
    public int getCatToExitY() {
        return catToExitY;
    }

    /**
     *
     * @return
     */
    public String getDog1Dir() {
        if(this.dog1Dir==Directions.Up)return "Up";
        else if(this.dog1Dir==Directions.Down)return "Down";
        else if(this.dog1Dir==Directions.Left)return "Left";
        else if(this.dog1Dir==Directions.Right)return "Right";
        else return "Still";
    }

    /**
     *
     * @return
     */
    public String getDog2Dir() {
        if(this.dog2Dir==Directions.Up)return "Up";
        else if(this.dog2Dir==Directions.Down)return "Down";
        else if(this.dog2Dir==Directions.Left)return "Left";
        else if(this.dog2Dir==Directions.Right)return "Right";
        else return "Still";
    }

    /**
     *
     * @return
     */
    public int getTurn() {
        return turn;
    }

    /**
     *
     * @return
     */
    public double getCatDog1Angle() {
        return catDog1Angle;
    }

    /**
     *
     * @return
     */
    public double getCatDog2Angle() {
        return catDog2Angle;
    }

    /**
     *
     * @return
     */
    public int getCatToBottom() {
        return catToBottom;
    }

    /**
     *
     * @return
     */
    public int getCatToLeft() {
        return catToLeft;
    }

    /**
     *
     * @return
     */
    public int getCatToRight() {
        return catToRight;
    }

    /**
     *
     * @return
     */
    public int getCatToTop() {
        return catToTop;
    }

    /**
     *
     * @return
     */
    public int getDog1ToBottom() {
        return dog1ToBottom;
    }

    /**
     *
     * @return
     */
    public int getDog1ToExitX() {
        return dog1ToExitX;
    }

    /**
     *
     * @return
     */
    public int getDog1ToExitY() {
        return dog1ToExitY;
    }

    /**
     *
     * @return
     */
    public int getDog1ToLeft() {
        return dog1ToLeft;
    }

    /**
     *
     * @return
     */
    public int getDog1ToRight() {
        return dog1ToRight;
    }

    /**
     *
     * @return
     */
    public int getDog1ToTop() {
        return dog1ToTop;
    }

    /**
     *
     * @return
     */
    public int getDog2ToBottom() {
        return dog2ToBottom;
    }

    /**
     *
     * @return
     */
    public int getDog2ToExitX() {
        return dog2ToExitX;
    }

    /**
     *
     * @return
     */
    public int getDog2ToExitY() {
        return dog2ToExitY;
    }

    /**
     *
     * @return
     */
    public int getDog2ToLeft() {
        return dog2ToLeft;
    }

    /**
     *
     * @return
     */
    public int getDog2ToRight() {
        return dog2ToRight;
    }

    /**
     *
     * @return
     */
    public int getDog2ToTop() {
        return dog2ToTop;
    }

    /**
     *
     * @return
     */
    public double getDogInnerDist() {
        return dogInnerDist;
    }


    
}
