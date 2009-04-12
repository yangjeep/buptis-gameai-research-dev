/*
 * deadend.game.GameConfigClass
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.game.GameConfigClass is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * deadend.game.GameConfigClass is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.game;


/**
 * This is a temporay configuration file instead of xml
 * @version 0.1
 * @author Yang JiaJian
 */
public class GameConfigClass {
    // 
    /**
     * The dimension of the board
     * Number of grids on x-axis
     */
    public final static int GridX=20;
    /**
     * The dimension of the board
     * Number of grids on y-axis
     */
    public final static int GridY=20;
    /**
     * Number Of dogs
     */
    public final static int NumberOfDogs=2;
    /**
     * Cat speed
     */
    public final static int CatSpeed=2;
    /**
     * Dog speed
     */
    public final static int DogSpeed=1;
    /**
     * Time limit of computation
     */
    public static int ComputingTimeLimit=300;
    /**
     * Upper limit of game steps
     */
    public final static int Step_Limit=20;
    /**
     * Minimum refresh rate of the game panel
     */
    public static int InitRefreshTimeMS=300;

    /**
     * The version of the database
     */
    public static int currentStepRecordTableVersion=2;
    /**
     * The name of the table records the game resord
     */
    public static String currentCalTimeTableName="MCResult";
    /**
     * The name of the table records the game steps
     */
    public static String currentStepRecordName="MCStep";
}
