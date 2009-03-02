/*
 * testCode.TestMain
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * testCode.TestMain is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * testCode.TestMain is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package testCode;

/**
 *
 * @author Yang JiaJian
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s;
        java.util.Calendar cal=java.util.Calendar.getInstance();
        s=new String(""+cal.getTime());
        System.out.println(s);
    }

}
