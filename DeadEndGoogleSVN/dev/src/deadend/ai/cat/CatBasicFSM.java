/*
 * deadend.ai.cat.CatBasicFSM
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.ai.cat.CatBasicFSM is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.cat.CatBasicFSM is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.ai.cat;
import deadend.ai.StrategyInterface;
import deadend.globalenum.Directions;
import deadend.game.DeadEndGame;
/**
 *
 * @author Yang JiaJian
 */
public class CatBasicFSM implements StrategyInterface{
    @Override public Directions compute(DeadEndGame game){
        return Directions.Up;
    }
}
