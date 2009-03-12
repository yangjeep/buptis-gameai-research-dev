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

    private int catToDog1x;
    private int catToDog1y;
    private int catToDog2x;
    private int catToDog2y;

    private double catToDog1;
    private double catToDog2;

    private int catToExitX;
    private int catToExitY;

    private int turn;

    private Directions dog1Dir;
    private Directions dog2Dir;

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

    public double getCatToDog1() {
        return catToDog1;
    }

    public int getCatToDog1x() {
        return catToDog1x;
    }

    public int getCatToDog1y() {
        return catToDog1y;
    }

    public double getCatToDog2() {
        return catToDog2;
    }

    public int getCatToDog2x() {
        return catToDog2x;
    }

    public int getCatToDog2y() {
        return catToDog2y;
    }

    public int getCatToExitX() {
        return catToExitX;
    }

    public int getCatToExitY() {
        return catToExitY;
    }

    public String getDog1Dir() {
        if(this.dog1Dir==Directions.Up)return "Up";
        else if(this.dog1Dir==Directions.Down)return "Down";
        else if(this.dog1Dir==Directions.Left)return "Left";
        else if(this.dog1Dir==Directions.Right)return "Right";
        else return "Still";
    }

    public String getDog2Dir() {
        if(this.dog2Dir==Directions.Up)return "Up";
        else if(this.dog2Dir==Directions.Down)return "Down";
        else if(this.dog2Dir==Directions.Left)return "Left";
        else if(this.dog2Dir==Directions.Right)return "Right";
        else return "Still";
    }

    public int getTurn() {
        return turn;
    }

    
}
