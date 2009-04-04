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

import java.util.ArrayList;

import deadend.database.StepRecordBuffer;
/**
 *
 * @author Yang JiaJian
 */
public class ODBCWrite {
    
    // public method of record game result
    public static void writeMCTime(deadend.game.DeadEndGame game){
        try{
	        String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" +
                    "DBQ=E:\\My Java Projects\\sseProj\\dev\\trunk\\" +
                    "DeadEndGoogleSVN\\dev\\db\\ResultRecord\\current.mdb";
	        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        Connection connection=DriverManager.getConnection(strurl);

            Integer t=new Integer(deadend.game.GameConfigClass.ComputingTimeLimit);
	        Statement stmt=connection.createStatement();
            int r=0;
            if(game.gameresult==GameResults.NotEnd)return;
            if(game.gameresult==GameResults.CatWin)r=0;
            if(game.gameresult==GameResults.Draw)r=1;
            if(game.gameresult==GameResults.DogWin)r=3;
	        stmt.executeUpdate("insert into "+deadend.game.GameConfigClass.currentCalTimeTableName+"(catStrategy,dogStrategy,calTime, GameResult) values('"+
                    game.player.getStrategy().getName()+"','"+game.dogs.getStrategy().getName()+"','"
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
        // method of record step
        public static void writeStep(deadend.game.DeadEndGame game){
            if(deadend.game.GameConfigClass.currentStepRecordTableVersion==1){
                try{
                    String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" +
                            "DBQ=E:\\My Java Projects\\sseProj\\dev\\trunk\\" +
                            "DeadEndGoogleSVN\\dev\\db\\StepRecord\\current.mdb";
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    Connection connection=DriverManager.getConnection(strurl);
                ArrayList<StepRecordBuffer>buf=game.getStepRecordBuf();

                Integer t=new Integer(deadend.game.GameConfigClass.ComputingTimeLimit);
                Statement stmt=connection.createStatement();
                int r=0;
                if(game.gameresult==GameResults.NotEnd)return;
                if(game.gameresult==GameResults.CatWin)r=0;
                if(game.gameresult==GameResults.Draw)r=1;
                if(game.gameresult==GameResults.DogWin)r=3;

                for(StepRecordBuffer b:buf){
                    int catToDog1x=b.getCatToDog1x();
                    int catToDog1y=b.getCatToDog1y();
                    int catToDog2x=b.getCatToDog2x();
                    int catToDog2y=b.getCatToDog2y();

                    double catToDog1=b.getCatToDog1();
                    double catToDog2=b.getCatToDog2();

                    int catToExitX=b.getCatToExitX();
                    int catToExitY=b.getCatToExitY();

                    int turn=b.getTurn();

                    String dog1Dir=b.getDog1Dir();
                    String dog2Dir=b.getDog2Dir();

                    stmt.executeUpdate("insert into "+deadend.game.GameConfigClass.currentStepRecordName+
                            "(catStrategy,dogStrategy,catToDog1x,catToDog1y," +
                            "catToDog2x,catToDog2y,catToDog1,catToDog2," +
                            "catToExitX,catToExitY,turn," +
                            "dog1Dir,dog2Dir,CalculationTime,GameResult) values('"
                            +game.player.getStrategy().getName()+"','"+game.dogs.getStrategy().getName()+"','"
                            +catToDog1x+"','"+catToDog1y+"','"+catToDog2x+"','"+catToDog2y+"','"
                            +catToDog1+"','"+catToDog2+"','"+catToExitX+"','"+catToExitY+"','"+turn+"','"
                            +dog1Dir+"','"+dog2Dir+"','"+deadend.game.GameConfigClass.ComputingTimeLimit+"','"+r+"')"
                            );

                }
                    stmt.close();
                    connection.close();

                System.out.println("Record Buffer Writed to "+ connection);

                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else if(deadend.game.GameConfigClass.currentStepRecordTableVersion==2){
                try{
                    String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" +
                            "DBQ=E:\\My Java Projects\\sseProj\\dev\\trunk" +
                            "\\DeadEndGoogleSVN\\dev\\db\\StepRecord\\current.mdb";
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    Connection connection=DriverManager.getConnection(strurl);
                    ArrayList<StepRecordBuffer>buf=game.getStepRecordBuf();

                    Integer t=new Integer(deadend.game.GameConfigClass.ComputingTimeLimit);
                    Statement stmt=connection.createStatement();
                    int r=0;
                    if(game.gameresult==GameResults.NotEnd)return;
                    if(game.gameresult==GameResults.CatWin)r=0;
                    if(game.gameresult==GameResults.Draw)r=1;
                    if(game.gameresult==GameResults.DogWin)r=3;

                    for(StepRecordBuffer b:buf){
                        int catToDog1x=b.getCatToDog1x();
                        int catToDog1y=b.getCatToDog1y();
                        int catToDog2x=b.getCatToDog2x();
                        int catToDog2y=b.getCatToDog2y();

                        double catToDog1=b.getCatToDog1();
                        double catToDog2=b.getCatToDog2();

                        int catToExitX=b.getCatToExitX();
                        int catToExitY=b.getCatToExitY();

                        double catDog1Angle=b.getCatDog1Angle();
                        double catDog2Angle=b.getCatDog2Angle();

                        int catToLeft=b.getCatToLeft();
                        int catToRight=b.getCatToRight();
                        int catToTop=b.getCatToTop();
                        int catToBottom=b.getCatToBottom();

                        int dog1ToLeft=b.getDog1ToLeft();
                        int dog1ToRight=b.getDog1ToRight();
                        int dog1ToTop=b.getDog1ToTop();
                        int dog1ToBottom=b.getDog1ToBottom();

                        int dog2ToLeft=b.getDog2ToLeft();
                        int dog2ToRight=b.getDog2ToRight();
                        int dog2ToTop=b.getDog2ToTop();
                        int dog2ToBottom=b.getDog2ToBottom();

                        double dogInnerDist=b.getDogInnerDist();

                        int dog1ToExitX=b.getDog1ToExitX();
                        int dog1ToExitY=b.getDog1ToExitY();

                        int dog2ToExitX=b.getDog2ToExitX();
                        int dog2ToExitY=b.getDog2ToExitY();

                        int turn=b.getTurn();

                        String dog1Dir=b.getDog1Dir();
                        String dog2Dir=b.getDog2Dir();

                        String cmd=
                                "insert into "+deadend.game.GameConfigClass.currentStepRecordName+
                                "(catStrategy  ,dogStrategy  , " +
                                "catToDog1x  ,catToDog1y  , catToDog2x  , catToDog2y  ," +
                                "catToDog1  , catToDog2  , " +
                                "catToExitX  , catToExitY  ,catDog1Angle  ,catDog2Angle ," +
                                "catToLeft  ,catToRight  ,catToTop  ,catToBottom  ," +
                                "dog1ToLeft  ,dog1ToRight  ,dog1ToTop  ,dog1ToBottom  ," +
                                "dog2ToLeft  ,dog2ToRight  ,dog2ToTop  ,dog2ToBottom  ," +
                                "dogInnterDist  , " +
                                "dog1ToExitX  ,dog1ToExitY  ,  " +
                                "dog2ToExitX  ,dog2ToExitY  , " +
                                "turn  , dog1Dir  , dog2Dir  ," +
                                " CalculationTime  ,GameResult ) values('"+
                                game.player.getStrategy().getName()+"','"+game.dogs.getStrategy().getName()+"','"+
                                catToDog1x+"','"+catToDog1y+"','"+catToDog2x+"','"+catToDog2y+"','"+
                                catToDog1+"','"+catToDog2+"','"+
                                catToExitX+"','"+catToExitY+"','"+catDog1Angle+"','"+catDog2Angle+"','"+
                                catToLeft+"','"+catToRight+"','"+catToTop+"','"+catToBottom+"','"+
                                dog1ToLeft+"','"+dog1ToRight+"','"+dog1ToTop+"','"+dog1ToBottom+"','"+
                                dog2ToLeft+"','"+dog2ToRight+"','"+dog2ToTop+"','"+dog2ToBottom+"','"+
                                dogInnerDist+"','"+
                                dog1ToExitX+"','"+dog1ToExitY+"','"+
                                dog2ToExitX+"','"+dog2ToExitY+"','"+
                                turn+"','"
                                +dog1Dir+"','"+dog2Dir+"','"+
                                deadend.game.GameConfigClass.ComputingTimeLimit+"','"+r+"')";
                        stmt.executeUpdate(cmd);
                    }
                        stmt.close();
                        connection.close();

                    System.out.println("Record Buffer Writed to "+ connection);

                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }
            }

    }
}
