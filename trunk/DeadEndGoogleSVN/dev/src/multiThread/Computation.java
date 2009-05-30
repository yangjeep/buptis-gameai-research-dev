/*
 * multiThread.Computation
 * Copyright (C) Yang JiaJian 2009 <yangjeep@gmail.com>
 * multiThread.Computation is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * multiThread.Computation is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package multiThread;

/**
 *
 * @author Yang JiaJian
 */
public class Computation implements Runnable{

    public int runingRound;
    private deadend.game.DeadEndGame game;

    /**
     *
     * @param runingRound
     */
    public Computation(int runingRound) {
        this.runingRound = runingRound;
        game=new deadend.game.DeadEndGame();
        game.intialize();
        game.initAutoRun(runingRound);
    }

    @Override
    public void run(){
        this.game.autoRunGame();
    }
    
}
