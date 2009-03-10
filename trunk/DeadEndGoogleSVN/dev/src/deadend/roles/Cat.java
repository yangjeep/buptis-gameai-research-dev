/*
 * deadend.roles.Cat
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.roles.Cat is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.roles.Cat is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.roles;
import deadend.game.DeadEndGame;
import deadend.ai.*;
import deadend.ai.cat.*;
/**
 *
 * @author Yang JiaJian
 */
public class Cat extends Animal{

    DeadEndGame game;

    // Strategy
    private StrategyInterface strategy;

    public Cat(DeadEndGame game) {
        // assign fields
        this.game=game;
    }

    // initialize logic here
    @Override
    public void initialize(){
        this.bornAtHome();
        this.direction=null;

        this.speed=deadend.game.GameConfigClass.CatSpeed;

        this.strategy=new CatBasicFSM();
    }

    // the strategy related logic here
    @Override
    public void compute(){
        // the strategy logic is added here
        this.direction=this.strategy.compute(game);
        super.move();
    }

    // the reset logig is here
    @Override
    public void reset(){
        this.bornAtHome();
        this.direction=null;

        // TODO reborn
        this.bornAtHome();
    }


    // To born at the initial place
    public void bornAtHome(){
        int x,y;
        java.util.Random rand=new java.util.Random();
        x=rand.nextInt(6)+(deadend.game.GameConfigClass.GridX/2-3);
        y=rand.nextInt(4)+(deadend.game.GameConfigClass.GridY-5);

        this.position=new java.awt.Point(deadend.game.GameConfigClass.GridX/2-1,deadend.game.GameConfigClass.GridY-1);
    }

    public void bornAtHome(int a){
        int x,y;
        java.util.Random rand=new java.util.Random();
        x=deadend.game.GameConfigClass.GridX/2-1;
        y=deadend.game.GameConfigClass.GridY-1;

        this.position=new java.awt.Point(deadend.game.GameConfigClass.GridX/2-1,deadend.game.GameConfigClass.GridY-1);
    }
    public StrategyInterface getStrategy() {
        return strategy;
    }

    public void setStrategy(StrategyInterface strategy) {
        this.strategy = strategy;
    }


}
