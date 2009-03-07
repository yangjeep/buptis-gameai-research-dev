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
/**
 *
 * @author Yang JiaJian
 */
public class Dog extends Animal{

    public Dog(DeadEndGame game) {
    }

    // TODO add initialize logic here
    @Override
    public void initialize(){
        this.bornAtHome();
    }

    // TODO add the strategy related logic here
    @Override
    public void compute(){
        // TODO the strategy logic is added here
        
        super.move();
    }

    // TODO the reset logig is here
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
}
