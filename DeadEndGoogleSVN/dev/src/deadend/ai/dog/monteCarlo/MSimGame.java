/*
 * deadend.ai.monteCarlo.MSimGame
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.ai.monteCarlo.MSimGame is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.monteCarlo.MSimGame is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.ai.dog.monteCarlo;

import deadend.roles.*;
import deadend.globalenum.*;
import deadend.game.*;
import java.awt.Point;
import java.util.ArrayList;
/**
 *
 * @author Yang JiaJian
 */
public class MSimGame {
    // TODO add the logic of an original game
    public MSimGame(DeadEndGame game,Cat cat,ArrayList<Dog> dogs){
        this.game=game;
        this.nextDir=new ArrayList<Directions>(dogs.size());
        this.simResult=GameResults.NotEnd;
    }
    public ArrayList<Directions> nextDir;
    public GameResults simResult;
    private DeadEndGame game;
    
}
