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
    // The dimension of the board
    public final static int GridX=20;
    public final static int GridY=20;
    // Number Of dogs
    public final static int NumberOfDogs=2;
    // Cat speed
    public final static int CatSpeed=2;
    // Dog speed
    public final static int DogSpeed=1;
    // Time limit of computing
    public static int ComputingTimeLimit=300;
    // Upper limit of game steps
    public final static int Step_Limit=20;
    // Refresh limit
    public final static int InitRefreshTimeMS=1000;

    public static int currentStepRecordTableVersion=2;

    public static String currentCalTimeTableName="MCTable090323Result";

    public static String currentStepRecordName="MCTable090323";
}
