/*
 * deadend.roles.Animal
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.roles.Animal is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.roles.Animal is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.roles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import deadend.globalenum.Directions;
/**
 *
 * @author Yang JiaJian
 */
public abstract class Animal {
    /**
     * The core related parameters
     */
    protected Point position;
    /**
     *
     */
    protected Directions direction;
    /**
     *
     */
    protected int speed;
    /**
     * Core related functions
     */
    public abstract void initialize();
    /**
     *
     */
    public abstract void compute();
    /**
     *
     */
    public abstract void reset();

    /**
     *
     */
    public void move(){
        if(this.direction==null){
            System.err.print("The direction is null");
            return;
        }
        Point p=this.position;
        if(this.direction==Directions.Up && this.position.y>0){
            this.position.setLocation(p.x,p.y-1);
        }
        if(this.direction==Directions.Down && this.position.y<deadend.game.GameConfigClass.GridY){
            this.position.setLocation(p.x,p.y+1);
        }
        if(this.direction==Directions.Left && this.position.x>0){
            this.position.setLocation(p.x-1, p.y);
        }
        if(this.direction==Directions.Right && this.position.y<deadend.game.GameConfigClass.GridX){
            this.position.setLocation(p.x+1, p.y);
        }
        this.direction=null;
    }
    /**
     *
     * @param removeDirection
     */
    public void move(boolean removeDirection){
        if(this.direction==null){
            System.err.print("The direction is null");
            return;
        }
        Point p=this.position;
        if(this.direction==Directions.Up && this.position.y>0){
            this.position.setLocation(p.x,p.y-1);
        }
        if(this.direction==Directions.Down && this.position.y<deadend.game.GameConfigClass.GridY){
            this.position.setLocation(p.x,p.y+1);
        }
        if(this.direction==Directions.Left && this.position.x>0){
            this.position.setLocation(p.x-1, p.y);
        }
        if(this.direction==Directions.Right && this.position.y<deadend.game.GameConfigClass.GridX){
            this.position.setLocation(p.x+1, p.y);
        }
    }

    /**
     *
     */
    public void removeDirection(){
        this.direction=null;
    }

    /**
     *
     * @return
     */
    public Directions getDirection() {
        return direction;
    }

    /**
     *
     * @param direction
     */
    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    /**
     *
     * @return
     */
    public Point getPosition() {
        return position;
    }

    /**
     *
     * @param position
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     *
     * @return
     */
    public int getSpeed() {
        return speed;
    }

    /**
     *
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }


}
