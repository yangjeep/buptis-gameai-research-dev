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
import deadend.roles.Dog;
/**
 *
 * @author Yang JiaJian
 */
public class CatStill implements StrategyInterface{

    private int catStep;

    /**
     *
     */
    public CatStill() {
        this.catStep=0;
    }


    /**
     *
     * @param game
     * @return
     */
    @Override
    public Directions compute(DeadEndGame game){
        return Directions.Still;
    }

    /**
     *
     */
    @Override
    public void reset(){
        this.catStep=0;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName(){ return "Still"; }
}
