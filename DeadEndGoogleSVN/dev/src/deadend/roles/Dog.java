/*
 * deadend.roles.Dog
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.roles.Dog is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.roles.Dog is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.roles;
import deadend.game.DeadEndGame;
import deadend.globalenum.Directions;
/**
 *
 * @author Yang JiaJian
 */
public class Dog extends Animal{

    public Dog(DeadEndGame game) {
    }

    // initialize logic here
    @Override
    public void initialize(){
        this.bornAtHome();
    }

    public void initialize(int num){
        this.bornAtHome(num);
    }
    // add the strategy related logic here
    /**
     *@param direction Directions
     */
    public void compute(Directions direction){
        // the strategy logic is added here
        this.direction=direction;
        super.move(false);
    }
    @Override
    public void compute(){
    }
    // reset logig is here
    @Override
    public void reset(){
        this.bornAtHome();
    }


    // To born at the initial place
    public void bornAtHome(){
        int x,y;
        java.util.Random rand=new java.util.Random();
        x=rand.nextInt(6)+(deadend.game.GameConfigClass.GridX/2-3);
        y=rand.nextInt(4)+1;

        this.position=new java.awt.Point(x,y);
    }

    // To born at the initial place
    public void bornAtHome(int num){
        int x,y;
        if(num==0)
            x=deadend.game.GameConfigClass.GridX/2-2;
        else
            x=deadend.game.GameConfigClass.GridX/2+1;
        y=5;


        this.position=new java.awt.Point(x,y);
    }
}
