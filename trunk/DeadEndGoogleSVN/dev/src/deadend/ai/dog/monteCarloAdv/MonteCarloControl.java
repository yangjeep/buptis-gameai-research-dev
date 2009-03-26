/*
 * deadend.ai.dog.monteCarlo.MonteCarloControl
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.ai.dog.monteCarlo.MonteCarloControl is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.dog.monteCarlo.MonteCarloControl is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.ai.dog.monteCarloAdv;

import deadend.roles.*;

import java.util.ArrayList;
import java.awt.Point;
/**
 *
 * @author Yang JiaJian
 */
public class MonteCarloControl {

    /**
     * preserved field
     */
    deadend.game.DeadEndGame oGame;
    Cat oCat;
    ArrayList<Dog> odogs;

    public MonteCarloControl(deadend.game.DeadEndGame game,Cat cat,ArrayList<Dog> dogs){
        this.oGame=game;
        this.oCat=cat;
        this.odogs=(ArrayList<Dog>)dogs.clone();

        this.doors=(ArrayList<Point>)this.oGame.door.clone();
        this.mcat=(Point)this.oCat.getPosition().clone();
        this.mdogs=(ArrayList<Point>)this.odogs.clone();
    }

    /**
     * duplicators
     */
    ArrayList<Point> doors;
    ArrayList<Point> mdogs;
    Point mcat;

    
}
