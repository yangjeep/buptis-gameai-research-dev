package testCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class NeuralNetworkLayer {
  int NumberOfNodes;
  double LearningRate;
  double[] NeuronValues,DesiredValues,Errors,BiasWeights,BiasValues;
  double[][] Weights,WeightChanges; 
  boolean LinearOutPut,UseMomentum;
  double MomentumFactor;
  NeuralNetworkLayer ChildNeuralLayer,ParentNeuralLayer;
  NeuralNetworkLayer(){
	  ParentNeuralLayer=null;
	  ChildNeuralLayer=null;
	  LinearOutPut=false;
	  UseMomentum=false;
	  MomentumFactor=0.9;
  }
  public void Initialize(int NumNodes,NeuralNetworkLayer ChildLayer,NeuralNetworkLayer ParentLayer){
	  NeuronValues=new double[NumNodes];
	  DesiredValues=new double[NumNodes];
	  Errors=new double[NumNodes];
	  
	  if(ChildLayer!=null){	 
	  BiasWeights=new double[ChildLayer.NumberOfNodes];
	  BiasValues=new double[ChildLayer.NumberOfNodes];
	  Weights=new double[NumNodes][ChildLayer.NumberOfNodes];
	  WeightChanges=new double[NumNodes][ChildLayer.NumberOfNodes];
	  }
	  if(ParentLayer != null){
		  ParentNeuralLayer=ParentLayer;
	  }
	  if(ChildLayer != null){
		  ChildNeuralLayer=ChildLayer;
	  } 
      for(int i=0;i<NumberOfNodes;i++){
    	  NeuronValues[i]=0;
    	  DesiredValues[i]=0;
    	  Errors[i]=0;
    	  if(ChildLayer!=null){
    		  for(int a=0;a<ChildLayer.NumberOfNodes;a++){
    			  Weights[i][a]=0;
    			  WeightChanges[i][a]=0;
    		  }
    	  }
      }
      if(ChildLayer!=null){
    	  for(int a=0;a<ChildLayer.NumberOfNodes;a++){
    		  BiasValues[a]=1;
    		  BiasWeights[a]=0;
    	  }
      }
  }
  public void RandomizeWeights1(){
	  double here1,here2,here3,here4,here5,here6,here7,here8,here9;
	  int j=0;
	  try{  
	         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
	         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection conn=DriverManager.getConnection(strurl);
	         Statement stmt=conn.createStatement();
	         ResultSet a;
	         a=stmt.executeQuery("SELECT * FROM weight ");
	         while(a.next()){
	        	 here1=a.getDouble(1);
	        	 here2=a.getDouble(2);
	        	 here3=a.getDouble(3);
	        	 here4=a.getDouble(4);
	        	 here5=a.getDouble(5);
	        	 here6=a.getDouble(6);
	        	 here7=a.getDouble(7);
	        	 here8=a.getDouble(8);
	        	 here9=a.getDouble(14);
	        	 if(j<5){
//	        for(int j=0;j<4;j++){
	   			 Weights[0][j]=here1;
//	   			}
//	   		 for(int j=0;j<4;j++){
	   			 Weights[1][j]=here2;
//	   			}
//	   		 for(int j=0;j<4;j++){
	   			 Weights[2][j]=here3;
//	   			}
//	   		 for(int j=0;j<4;j++){
	   			 Weights[3][j]=here4;
	   			//}
	   		// for(int j=0;j<4;j++){
	   			 Weights[4][j]=here5;
	   		//	}
	   	//	 for(int j=0;j<4;j++){
	   			 Weights[5][j]=here6;
	   		//	}
	   	//	 for(int j=0;j<4;j++){
	   			 Weights[6][j]=here7;
	  // 			}
	//   		 for(int j=0;j<4;j++){
	   			 Weights[7][j]=here8;
//	   			}
	        	 
	   			 BiasWeights[j]=here9;}
	   		 j++;
	 		}
//	        j=0 ;
//	        while(a.next()){	        	
//	        	j++;
//	      	 }
	        stmt.close();
	  	    conn.close();
	     }catch(Exception a)
	     {
	         a.printStackTrace();
	     }
  }
  public void LRUDWeights1(){
	  int con=0;
	  try{  
	         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
	         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection conn=DriverManager.getConnection(strurl);
	         Statement stmt=conn.createStatement();
	         ResultSet a;
	         a=stmt.executeQuery("SELECT * FROM LRUD1 ");
	         while(a.next()){ 
	        	Weights[(int)(con/2)][con-((int)(con/2))*2]=a.getDouble(1);
	        	con++;
	         }
	         con=0;
	         a=stmt.executeQuery("SELECT * FROM LRUD3 ");
	         while(a.next()){ 
		        	BiasWeights[con]=a.getDouble(1);
		        	con++;
		         }	         
	         
	         
	         stmt.close();
		  	 conn.close();
	  }catch(Exception a)
	     {
	         a.printStackTrace();
	     }
  }
  public void No1_1(){
	  int con=0;
	  try{  
	         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
	         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection conn=DriverManager.getConnection(strurl);
	         Statement stmt=conn.createStatement();
	         ResultSet a;
	         a=stmt.executeQuery("SELECT * FROM neural25 ");
	         while(a.next()){ 
	        	Weights[(int)(con/5)][con-((int)(con/5))*5]=a.getDouble(1);
	        	con++;
	         }
	         con=0;
	         a=stmt.executeQuery("SELECT * FROM neural27 ");
	         while(a.next()){ 
		        	BiasWeights[con]=a.getDouble(1);
		        	con++;
		         }	         
	         
	         
	         stmt.close();
		  	 conn.close();
	  }catch(Exception a)
	     {
	         a.printStackTrace();
	     }
  }
  public void No2_1(){
	  int con=0;
	  try{  
	         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
	         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection conn=DriverManager.getConnection(strurl);
	         Statement stmt=conn.createStatement();
	         ResultSet a;
	         a=stmt.executeQuery("SELECT * FROM neural21 ");
	         while(a.next()){ 
	        	Weights[(int)(con/6)][con-((int)(con/6))*6]=a.getDouble(1);
	        	con++;
	         }
	         con=0;
	         a=stmt.executeQuery("SELECT * FROM neural23 ");
	         while(a.next()){ 
		        	BiasWeights[con]=a.getDouble(1);
		        	con++;
		         }	         
	         
	         
	         stmt.close();
		  	 conn.close();
	  }catch(Exception a)
	     {
	         a.printStackTrace();
	     }
  }
  public void LRUDWeights2(){
	  int con=0;
	  try{  
	         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
	         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection conn=DriverManager.getConnection(strurl);
	         Statement stmt=conn.createStatement();
	         ResultSet a;
	         a=stmt.executeQuery("SELECT * FROM LRUD2 ");
	         while(a.next()){ 
	        	Weights[(int)(con/2)][con-((int)(con/2))*2]=a.getDouble(1);
	        	con++;
	         }
	         con=0;
	         a=stmt.executeQuery("SELECT * FROM LRUD4 ");
	         while(a.next()){ 
	        	BiasWeights[con]=a.getDouble(1);
	        	con++;
	         }
	         
	         stmt.close();
		  	 conn.close();
	  }catch(Exception a)
	     {
	         a.printStackTrace();
	     }
  }
  public void No1_2(){
	  int con=0;
	  try{  
	         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
	         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection conn=DriverManager.getConnection(strurl);
	         Statement stmt=conn.createStatement();
	         ResultSet a;
	         a=stmt.executeQuery("SELECT * FROM neural26 ");
	         while(a.next()){ 
	        	Weights[(int)(con/4)][con-((int)(con/4))*4]=a.getDouble(1);
	        	con++;
	         }
	         con=0;
	         a=stmt.executeQuery("SELECT * FROM neural28 ");
	         while(a.next()){ 
	        	BiasWeights[con]=a.getDouble(1);
	        	con++;
	         }
	         
	         stmt.close();
		  	 conn.close();
	  }catch(Exception a)
	     {
	         a.printStackTrace();
	     }
  }
  public void No2_2(){
	  int con=0;
	  try{  
	         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
	         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection conn=DriverManager.getConnection(strurl);
	         Statement stmt=conn.createStatement();
	         ResultSet a;
	         a=stmt.executeQuery("SELECT * FROM neural22 ");
	         while(a.next()){ 
	        	Weights[(int)(con/4)][con-((int)(con/4))*4]=a.getDouble(1);
	        	con++;
	         }
	         con=0;
	         a=stmt.executeQuery("SELECT * FROM neural24 ");
	         while(a.next()){ 
	        	BiasWeights[con]=a.getDouble(1);
	        	con++;
	         }
	         
	         stmt.close();
		  	 conn.close();
	  }catch(Exception a)
	     {
	         a.printStackTrace();
	     }
  }
  public void LRWeights1(){
	  int con=0;
	  try{  
	         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
	         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection conn=DriverManager.getConnection(strurl);
	         Statement stmt=conn.createStatement();
	         ResultSet a;
	         a=stmt.executeQuery("SELECT * FROM LR1 ");
	         while(a.next()){ 
	        	Weights[(int)(con/3)][con-((int)(con/3))*3]=a.getDouble(1);
	        	con++;
	         }
	         con=0;
	         a=stmt.executeQuery("SELECT * FROM LR3 ");
	         while(a.next()){ 
	        	BiasWeights[con]=a.getDouble(1);
	        	con++;
	         }
	         stmt.close();
		  	 conn.close();
	  }catch(Exception a)
	     {
	         a.printStackTrace();
	     }
  }
  public void LRWeights2(){
	  int con=0;
	  try{  
	         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
	         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection conn=DriverManager.getConnection(strurl);
	         Statement stmt=conn.createStatement();
	         ResultSet a;
	         a=stmt.executeQuery("SELECT * FROM LR2 ");
	         while(a.next()){ 
	        	Weights[(int)(con/3)][con-((int)(con/3))*3]=a.getDouble(1);
	        	con++;
	         }
	         con=0;
	         a=stmt.executeQuery("SELECT * FROM LR4 ");
	         while(a.next()){ 
	        	BiasWeights[con]=a.getDouble(1);
	        	con++;
	         }
	         stmt.close();
		  	 conn.close();
	  }catch(Exception a)
	     {
	         a.printStackTrace();
	     }
  }
  public void UDWeights1(){
	  int con=0;
	  try{  
	         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
	         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection conn=DriverManager.getConnection(strurl);
	         Statement stmt=conn.createStatement();
	         ResultSet a;
	         a=stmt.executeQuery("SELECT * FROM UD1 ");
	         while(a.next()){ 
	        	Weights[(int)(con/6)][con-((int)(con/6))*6]=a.getDouble(1);
	        	con++;
	         }
	         con=0;
	         a=stmt.executeQuery("SELECT * FROM UD3 ");
	         while(a.next()){ 
	        	BiasWeights[con]=a.getDouble(1);
	        	con++;
	         }
	         stmt.close();
		  	 conn.close();
	  }catch(Exception a)
	     {
	         a.printStackTrace();
	     }
  }
  public void UDWeights2(){
	  int con=0;
	  try{  
	         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
	         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection conn=DriverManager.getConnection(strurl);
	         Statement stmt=conn.createStatement();
	         ResultSet a;
	         a=stmt.executeQuery("SELECT * FROM UD2 ");
	         while(a.next()){ 
	        	Weights[(int)(con/2)][con-((int)(con/2))*2]=a.getDouble(1);
	        	con++;
	         }
	         con=0;
	         a=stmt.executeQuery("SELECT * FROM UD4 ");
	         while(a.next()){ 
	        	BiasWeights[con]=a.getDouble(1);
	        	con++;
	         }
	         stmt.close();
		  	 conn.close();
	  }catch(Exception a)
	     {
	         a.printStackTrace();
	     }
  }
  public void RandomizeWeights2(){
	  double here1,here2,here3,here4,here5,here6;
	  int j=0;
	  try{  
	         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
	         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection conn=DriverManager.getConnection(strurl);
	         Statement stmt=conn.createStatement();
	         ResultSet a;
	         a=stmt.executeQuery("SELECT * FROM weight ");
	         while(a.next()){
	         here1=a.getDouble(9);
	         here2=a.getDouble(10);
	         here3=a.getDouble(11);
	         here4=a.getDouble(12);
	         here5=a.getDouble(13);
	         here6=a.getDouble(15);
//	         for(int j=0;j<3;j++){
	         if(j<3){
	   			 Weights[0][j]=here1;
//	   			}
//	         for(int j=0;j<3;j++){
	   			 Weights[1][j]=here2;
//	   			}
//	         for(int j=0;j<3;j++){
	   			 Weights[2][j]=here3;
//	   			}
//	         for(int j=0;j<3;j++){
	   			 Weights[3][j]=here4;
//	   			}
	   			 Weights[4][j]=here5;
	   			BiasWeights[j]=here6;}
	   			 j++;
	      }
//	         while(a.next()){
//	        	 for(int j=0;j<3;j++){
//	  	   		   BiasWeights[j]=a.getDouble(14);
//	  	   		 }
//	         }
	         stmt.close();
		  	 conn.close();
	     }catch(Exception a)
	     {
	         a.printStackTrace();
	     }
  }
  public void RandomizeWeights(){
	  double before;
	  for(int i=0;i<NumberOfNodes;i++){
		  for(int a=0;a<ChildNeuralLayer.NumberOfNodes;a++){
			  before=Math.random();
			  if(before>=0.5){
				  Weights[i][a]=Math.random();
			  }
			  else{
				  Weights[i][a]=-Math.random();
				  }
		  }
	  }
	  for(int a=0;a<ChildNeuralLayer.NumberOfNodes;a++){
		  before=Math.random();
		  if(before>=0.5){
			  BiasWeights[a]=Math.random();
		  }
		  else{
			  BiasWeights[a]=-Math.random();
			  }
	  }
  }
  public void RandomizeWeightsAllzero(){
	  double before;
	  for(int i=0;i<NumberOfNodes;i++){
		  for(int a=0;a<ChildNeuralLayer.NumberOfNodes;a++){
			  before=Math.random();
			  if(before>=0.5){
				  Weights[i][a]=Math.random();
			  }
			  else{
				  Weights[i][a]=-Math.random();
				  }
		  }
	  }
	  for(int a=0;a<ChildNeuralLayer.NumberOfNodes;a++){
		  before=Math.random();
		  if(before>=0.5){
			  BiasWeights[a]=Math.random();
		  }
		  else{
			  BiasWeights[a]=-Math.random();
			  }
	  }
  }
	  public void RandomizeWeightsDog1(){
		  Weights[0][0]=-0.13235440908686236;
		  Weights[0][1]=-0.13163874439458978;
		  Weights[1][0]=3.601180982088031;
		  Weights[1][1]=3.417271878201321;
		  BiasWeights[0]=-1.2795081208738277;
		  BiasWeights[1]=-1.2203506162636508;
	  }
	  public void RandomizeWeightsDog2(){
		  Weights[0][0]=2.810491862332737;
		  Weights[0][1]=-1.8101852796655906;
		  Weights[1][0]=1.9841412924475685;
		  Weights[1][1]=-2.1516326028413277;
		  BiasWeights[0]=-1.644360568925382;
		  BiasWeights[1]=1.2508625166502474;
	  }
	  public void RandomizeWeightsDog3_n(){
		/*Weights[0][0]=-0.8177263558653812;
		Weights[0][1]=-0.09472692634179947;
		Weights[0][2]=-0.8591147217875703;
		Weights[0][3]=-0.8066871020164359;
		Weights[0][4]=0.6620451966894805;
		Weights[0][5]=0.9884152523874542;
		Weights[0][6]=-0.12651844286523162;
		Weights[1][0]=9.479130186392046;
		Weights[1][1]=7.380366904449521;
		Weights[1][2]=13.920568826287477;
		Weights[1][3]=5.448278504828583;
		Weights[1][4]=-0.9035719515742211;
		Weights[1][5]=-10.176582059328604;
		Weights[1][6]=0.8397801827309554;
		Weights[2][0]=8.246712458026673;
		Weights[2][1]=-6.992923971160695;
		Weights[2][2]=33.596675730785876;
		Weights[2][3]=-0.3910844922491544;
		Weights[2][4]=3.957815309469779;
		Weights[2][5]=5.820594327911672;
		Weights[2][6]=-0.8069822868346754;
		Weights[3][0]=0.14347683209645834;
		Weights[3][1]=-17.02797114868412;
		Weights[3][2]=-7.665631579834448;
		Weights[3][3]=-10.382901122494555;
		Weights[3][4]=-3.7037237137961334;
		Weights[3][5]=19.895445374557227;
		Weights[3][6]=1.4428785111500304;
		BiasWeights[0]=-8.946578104646697;
		BiasWeights[1]=-2.8183047834164636;
		BiasWeights[2]=8.514801298685208;
		BiasWeights[3]=-2.345203035510589;
		BiasWeights[4]=25.458748139306838;
		BiasWeights[5]=9.145105116280233;
		BiasWeights[6]=-0.7700965145058211;*/
		
		double here1,here2,here3,here4,here9;
		int j=0;
		  try{  
		         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
		         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		         Connection conn=DriverManager.getConnection(strurl);
		         Statement stmt=conn.createStatement();
		         ResultSet a;
		         a=stmt.executeQuery("SELECT * FROM dog10 ");
		         while(a.next()){
		        	 here1=a.getDouble("x1");
		        	 here2=a.getDouble("x2");
		        	 here3=a.getDouble("x3");
		        	 here4=a.getDouble("x4");
		        	 here9=a.getDouble("z1");
		        	 if(j<10){
//		        for(int j=0;j<4;j++){
		   			 Weights[0][j]=here1;
//		   			}
//		   		 for(int j=0;j<4;j++){
		   			 Weights[1][j]=here2;
//		   			}
//		   		 for(int j=0;j<4;j++){
		   			 Weights[2][j]=here3;
//		   			}
//		   		 for(int j=0;j<4;j++){
		   			 Weights[3][j]=here4;
		   			
		        	 
		   			 BiasWeights[j]=here9;}
		   		 j++;
		 		}
//		        j=0 ;
//		        while(a.next()){	        	
//		        	j++;
//		      	 }
		        stmt.close();
		  	    conn.close();
		     }catch(Exception a)
		     {
		         a.printStackTrace();
		     }
	  }
      public void RandomizeWeightsDog4(){
		/*Weights[0][0]=-2.292619590143303;
		Weights[0][1]=2.2925763520533278;
		Weights[1][0]=3.0780545981952567;
		Weights[1][1]=-3.0639153654025155;
		Weights[2][0]=1.6520925452675659;
		Weights[2][1]=-1.6518344808518846;
		Weights[3][0]=-3.142034274915606;
		Weights[3][1]=3.146066785815518;
		Weights[4][0]=2.3294982143697887;
		Weights[4][1]=-2.329678431279046;
		Weights[5][0]=-3.017187818669095;
		Weights[5][1]=3.0340924868863213;
		Weights[6][0]=2.057891006762004;
		Weights[6][1]=-2.638791259002391;
		BiasWeights[0]=0.99857273774986;
		BiasWeights[1]=-0.4347777202530245;*/
		
		
		double here1,here2,here3,here4,here5,here6,here7,here8,here9,here10,here11;
		int j=0;
		  try{  
		         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
		         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		         Connection conn=DriverManager.getConnection(strurl);
		         Statement stmt=conn.createStatement();
		         ResultSet a;
		         a=stmt.executeQuery("SELECT * FROM dog10 ");
		         while(a.next()){
		         here1=a.getDouble("y1");
		         here2=a.getDouble("y2");
		         here3=a.getDouble("y3");
		         here4=a.getDouble("y4");
		         here5=a.getDouble("y5");
		         here6=a.getDouble("y6");
		         here7=a.getDouble("y7");
		         here9=a.getDouble("y8");
		         here10=a.getDouble("y9");
		         here11=a.getDouble("y10");
		         here8=a.getDouble("z2");
//		         for(int j=0;j<3;j++){
		         if(j<2){
		   			 Weights[0][j]=here1;
//		   			}
//		         for(int j=0;j<3;j++){
		   			 Weights[1][j]=here2;
//		   			}
//		         for(int j=0;j<3;j++){
		   			 Weights[2][j]=here3;
//		   			}
//		         for(int j=0;j<3;j++){
		   			 Weights[3][j]=here4;
//		   			}
		   			 Weights[4][j]=here5;
		   			 Weights[5][j]=here6;
		   			 Weights[6][j]=here7;
		   			Weights[7][j]=here9;
		   			Weights[8][j]=here10;
		   			Weights[9][j]=here11;
		   			BiasWeights[j]=here8;}
		   			 j++;
		      }
//		         while(a.next()){
//		        	 for(int j=0;j<3;j++){
//		  	   		   BiasWeights[j]=a.getDouble(14);
//		  	   		 }
//		         }
		         stmt.close();
			  	 conn.close();
		     }catch(Exception a)
		     {
		         a.printStackTrace();
		     }
	  }
      public void RandomizeWeightsDog5_n(){
    	
  		
  		
    	  double here1,here2,here3,here4,here9;
  		int j=0;
  		  try{  
  		         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
  		         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  		         Connection conn=DriverManager.getConnection(strurl);
  		         Statement stmt=conn.createStatement();
  		         ResultSet a;
  		         a=stmt.executeQuery("SELECT * FROM dog11 ");
  		         while(a.next()){
  		        	 here1=a.getDouble("x1");
  		        	 here2=a.getDouble("x2");
  		        	 here3=a.getDouble("x3");
  		        	 here4=a.getDouble("x4");
  		        	 here9=a.getDouble("z1");
  		        	 if(j<10){
//  		        for(int j=0;j<4;j++){
  		   			 Weights[0][j]=here1;
//  		   			}
//  		   		 for(int j=0;j<4;j++){
  		   			 Weights[1][j]=here2;
//  		   			}
//  		   		 for(int j=0;j<4;j++){
  		   			 Weights[2][j]=here3;
//  		   			}
//  		   		 for(int j=0;j<4;j++){
  		   			 Weights[3][j]=here4;
  		   			
  		        	 
  		   			 BiasWeights[j]=here9;}
  		   		 j++;
  		 		}
//  		        j=0 ;
//  		        while(a.next()){	        	
//  		        	j++;
//  		      	 }
  		        stmt.close();
  		  	    conn.close();
  		     }catch(Exception a)
  		     {
  		         a.printStackTrace();
  		     }
  	  }
      public void RandomizeWeightsDog6(){
    	
  		
  		
    	  double here1,here2,here3,here4,here5,here6,here7,here8,here9,here10,here11;
  		int j=0;
  		  try{  
  		         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
  		         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  		         Connection conn=DriverManager.getConnection(strurl);
  		         Statement stmt=conn.createStatement();
  		         ResultSet a;
  		         a=stmt.executeQuery("SELECT * FROM dog11 ");
  		         while(a.next()){
  		         here1=a.getDouble("y1");
  		         here2=a.getDouble("y2");
  		         here3=a.getDouble("y3");
  		         here4=a.getDouble("y4");
  		         here5=a.getDouble("y5");
  		         here6=a.getDouble("y6");
  		         here7=a.getDouble("y7");
  		         here9=a.getDouble("y8");
  		         here10=a.getDouble("y9");
  		         here11=a.getDouble("y10");
  		         here8=a.getDouble("z2");
//  		         for(int j=0;j<3;j++){
  		         if(j<2){
  		   			 Weights[0][j]=here1;
//  		   			}
//  		         for(int j=0;j<3;j++){
  		   			 Weights[1][j]=here2;
//  		   			}
//  		         for(int j=0;j<3;j++){
  		   			 Weights[2][j]=here3;
//  		   			}
//  		         for(int j=0;j<3;j++){
  		   			 Weights[3][j]=here4;
//  		   			}
  		   			 Weights[4][j]=here5;
  		   			 Weights[5][j]=here6;
  		   			 Weights[6][j]=here7;
  		   			Weights[7][j]=here9;
  		   			Weights[8][j]=here10;
  		   			Weights[9][j]=here11;
  		   			BiasWeights[j]=here8;}
  		   			 j++;
  		      }
//  		         while(a.next()){
//  		        	 for(int j=0;j<3;j++){
//  		  	   		   BiasWeights[j]=a.getDouble(14);
//  		  	   		 }
//  		         }
  		         stmt.close();
  			  	 conn.close();
  		     }catch(Exception a)
  		     {
  		         a.printStackTrace();
  		     }
  	  }
/*	  try{  
	         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
	         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection conn=DriverManager.getConnection(strurl);
	         Statement stmt=conn.createStatement();
	         ResultSet a;
	         a=stmt.executeQuery("SELECT * FROM weight ");
	 		
	 		
	      }catch(Exception a)
	     {
	         a.printStackTrace();
	     }*/
  public void CalculateNeuronValues(){
	  double x;
	  if(ParentNeuralLayer!=null){
		  for(int a=0;a<NumberOfNodes;a++){
			  x=0;
			  for(int i=0;i<ParentNeuralLayer.NumberOfNodes;i++){
				  x+=ParentNeuralLayer.NeuronValues[i]*ParentNeuralLayer.Weights[i][a];
			  }
			  x+=ParentNeuralLayer.BiasValues[a]*ParentNeuralLayer.BiasWeights[a];			  
			  
			  if (x <-45) {
			      x = 0;
			    }
			  else if (x > 45) {
			      x = 1;
			    }
			    else {
			      x = 1 / (1 + Math.exp(-x));
			    }  
			  
			  NeuronValues[a]=x;
			  /*if((ChildNeuralLayer==null))
				  NeuronValues[a]=x;
				  
			  else{
				  NeuronValues[a]=1/(1+Math.exp(-x));
				  //System.out.println(NeuronValues[a]);
			      
			  }*/
		  }
	  }
	  else{
		 /* for(int a=0;a<NumberOfNodes;a++)
		  if (NeuronValues[a]<-45) {
			  NeuronValues[a]= 0;
		    }
		  else if (NeuronValues[a]> 45) {
			  NeuronValues[a] = 1;
		    }
		    else {
		    	NeuronValues[a] = 1 / (1 + Math.exp(-NeuronValues[a]));
		    } */
	  }
	  
	  //System.out.println();
  }
  public void CalculateErrors(){
	  double sum;
	  if(ChildNeuralLayer==null){
		  for(int i=0;i<NumberOfNodes;i++){
			  Errors[i]=(DesiredValues[i]-NeuronValues[i])*NeuronValues[i]*(1-NeuronValues[i]);
		  }
	  }
	  else 
		  if(ParentNeuralLayer==null){
			  for(int i=0;i<NumberOfNodes;i++){
				  Errors[i]=0;
			  }
		  }
		  else{
			  for(int i=0;i<NumberOfNodes;i++){
				  sum=0;
				  for(int j=0;j<ChildNeuralLayer.NumberOfNodes;j++){
				     
					  sum+=ChildNeuralLayer.Errors[j]*Weights[i][j];
				  }
				  Errors[i]=sum*NeuronValues[i]*(1-NeuronValues[i]);
			  }
		  }
  }
  public void AdjustWeights(){
	  double dw;
	  if(ChildNeuralLayer!=null){
		  for(int i=0;i<NumberOfNodes;i++){
			  for(int j=0;j<ChildNeuralLayer.NumberOfNodes;j++){
				  dw=LearningRate*ChildNeuralLayer.Errors[j]*NeuronValues[i];
				  if(UseMomentum){
					  Weights[i][j]+=dw+MomentumFactor*WeightChanges[i][j];
					  WeightChanges[i][j]=dw;
				  }
				  else{
					  Weights[i][j]+=dw;
				  }
			  }
		  }
		  for(int j=0;j<ChildNeuralLayer.NumberOfNodes;j++){
			  BiasWeights[j]+=LearningRate*ChildNeuralLayer.Errors[j]*BiasValues[j];
		  }
	  }
  }
}
