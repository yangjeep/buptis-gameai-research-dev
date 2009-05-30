/*
 * multiThread.LaunchMultThread
 * Copyright (C) Yang JiaJian 2009 <yangjeep@gmail.com>
 * multiThread.LaunchMultThread is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * multiThread.LaunchMultThread is distributed in the hope that it will be useful, but
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
public class LaunchMultThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for(int i=1;i<=100;i++){
            Computation c=new Computation(100);
            c.run();
        }
    }

}
