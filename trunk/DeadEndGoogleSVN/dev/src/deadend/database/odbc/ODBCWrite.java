/*
 * deadend.database.odbc.ODBCWrite
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.database.odbc.ODBCWrite is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.database.odbc.ODBCWrite is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.database.odbc;

import deadend.globalenum.GameResults;
import java.sql.*;
/**
 *
 * @author Yang JiaJian
 */
public class ODBCWrite {
    // TODO public method of record step
    // TODO public method of record game result
    public static void writeMCTime(deadend.game.DeadEndGame game){
        try{
	        String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\My Java Projects\\sseProj\\dev\\DeadEndGoogleSVN\\DeadEndGoogleSVN\\db\\ResultRecord\\090229data.mdb";
	        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        Connection connection=DriverManager.getConnection(strurl);

            Integer t=new Integer(deadend.game.GameConfigClass.ComputingTimeLimit);
	        Statement stmt=connection.createStatement();
            int r=0;
            if(game.gameresult==GameResults.NotEnd)return;
            if(game.gameresult==GameResults.CatWin)r=0;
            if(game.gameresult==GameResults.Draw)r=1;
            if(game.gameresult==GameResults.DogWin)r=3;
	        stmt.executeUpdate("insert into MonteCarloCalTimeRev1(calTime , GameResult) values('"
                    +deadend.game.GameConfigClass.ComputingTimeLimit+"','"+r+"')"
                    );
                stmt.close();
                connection.close();
   	        System.out.println(connection+t.toString());

	        }catch(Exception e)
	        {
	            e.printStackTrace();
	        }

    }
}
