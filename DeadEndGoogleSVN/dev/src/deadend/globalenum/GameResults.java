/*
 * deadend.globalenum.GameResults
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.globalenum.GameResults is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.globalenum.GameResults is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.globalenum;

/**
 *
 * @author Yang JiaJian
 */
public enum GameResults {
    /**
     * Cat reach the door
     */
    CatWin,
    /**
     * Dog catched the cat
     */
    DogWin,
    /**
     * Time exceed the limit and no one won
     */
    Draw,
    /**
     * The game is not over
     */
    NotEnd
}
