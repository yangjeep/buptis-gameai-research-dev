package testCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class NeuralNetwork {
	static double here1,here2,here3,here4,here5,here6,here9,here10,here11,here12,here13,here14,here15,here16,here8;
	static int here7;
	static String b=new String();
	static double[] desiredvalue=new double[3];
	static NeuralNetwork DogAct=new NeuralNetwork();
	static NeuralNetwork DogAct2=new NeuralNetwork();
	static NeuralNetwork DogAct3=new NeuralNetwork();
    static NeuralNetworkLayer InputLayer=new NeuralNetworkLayer();
    static NeuralNetworkLayer HiddenLayer=new NeuralNetworkLayer();
    static NeuralNetworkLayer OutputLayer=new NeuralNetworkLayer();
    static NeuralNetwork Brain =new NeuralNetwork();
  public void Initialize(int nNodesInput,int nNodesHidden,int nNodesOutput){
	  InputLayer.NumberOfNodes=nNodesInput;
	  HiddenLayer.NumberOfNodes=nNodesHidden;
	  OutputLayer.NumberOfNodes=nNodesOutput;
	  InputLayer.Initialize(nNodesInput, HiddenLayer, null);
	  InputLayer.RandomizeWeights();	  
	  HiddenLayer.Initialize(nNodesHidden,OutputLayer , InputLayer);
	  HiddenLayer.RandomizeWeights();	 
	  OutputLayer.Initialize(nNodesOutput, null, HiddenLayer);
      
  }
 public void Initializeneural(int nNodesInput,int nNodesHidden,int nNodesOutput){
	  InputLayer.NumberOfNodes=nNodesInput;
	  HiddenLayer.NumberOfNodes=nNodesHidden;
	  OutputLayer.NumberOfNodes=nNodesOutput;
	  InputLayer.Initialize(nNodesInput, HiddenLayer, null);
	  //InputLayer.RandomizeWeightsneural1();	  
	  HiddenLayer.Initialize(nNodesHidden,OutputLayer , InputLayer);
	  //HiddenLayer.RandomizeWeightsneural2();	 
	  OutputLayer.Initialize(nNodesOutput, null, HiddenLayer);     
  }
  public void InitializeLRUD(int nNodesInput,int nNodesHidden,int nNodesOutput){
	  InputLayer.NumberOfNodes=nNodesInput;
	  HiddenLayer.NumberOfNodes=nNodesHidden;
	  OutputLayer.NumberOfNodes=nNodesOutput;
	  InputLayer.Initialize(nNodesInput, HiddenLayer, null);
	  InputLayer.LRUDWeights1();	  
	  HiddenLayer.Initialize(nNodesHidden,OutputLayer , InputLayer);
	  HiddenLayer.LRUDWeights2();	 
	  OutputLayer.Initialize(nNodesOutput, null, HiddenLayer);     
  }
  public void InitializeLR(int nNodesInput,int nNodesHidden,int nNodesOutput){
	  InputLayer.NumberOfNodes=nNodesInput;
	  HiddenLayer.NumberOfNodes=nNodesHidden;
	  OutputLayer.NumberOfNodes=nNodesOutput;
	  InputLayer.Initialize(nNodesInput, HiddenLayer, null);
	  InputLayer.LRWeights1();	  
	  HiddenLayer.Initialize(nNodesHidden,OutputLayer , InputLayer);
	  HiddenLayer.LRWeights2();	 
	  OutputLayer.Initialize(nNodesOutput, null, HiddenLayer);     
  }
  public void InitializeNo1(int nNodesInput,int nNodesHidden,int nNodesOutput){
	  InputLayer.NumberOfNodes=nNodesInput;
	  HiddenLayer.NumberOfNodes=nNodesHidden;
	  OutputLayer.NumberOfNodes=nNodesOutput;
	  InputLayer.Initialize(nNodesInput, HiddenLayer, null);
	  InputLayer.No1_1();	  
	  HiddenLayer.Initialize(nNodesHidden,OutputLayer , InputLayer);
	  HiddenLayer.No1_2();	 
	  OutputLayer.Initialize(nNodesOutput, null, HiddenLayer);     
  }
  public void InitializeNo2(int nNodesInput,int nNodesHidden,int nNodesOutput){
	  InputLayer.NumberOfNodes=nNodesInput;
	  HiddenLayer.NumberOfNodes=nNodesHidden;
	  OutputLayer.NumberOfNodes=nNodesOutput;
	  InputLayer.Initialize(nNodesInput, HiddenLayer, null);
	  InputLayer.No2_1();	  
	  HiddenLayer.Initialize(nNodesHidden,OutputLayer , InputLayer);
	  HiddenLayer.No2_2();	 
	  OutputLayer.Initialize(nNodesOutput, null, HiddenLayer);     
  }
  public void InitializeUD(int nNodesInput,int nNodesHidden,int nNodesOutput){
	  InputLayer.NumberOfNodes=nNodesInput;
	  HiddenLayer.NumberOfNodes=nNodesHidden;
	  OutputLayer.NumberOfNodes=nNodesOutput;
	  InputLayer.Initialize(nNodesInput, HiddenLayer, null);
	  InputLayer.UDWeights1();	  
	  HiddenLayer.Initialize(nNodesHidden,OutputLayer , InputLayer);
	  HiddenLayer.UDWeights2();	 
	  OutputLayer.Initialize(nNodesOutput, null, HiddenLayer);     
  }
  public void InitializeDog(int nNodesInput,int nNodesHidden,int nNodesOutput){
	  InputLayer.NumberOfNodes=nNodesInput;
	  HiddenLayer.NumberOfNodes=nNodesHidden;
	  OutputLayer.NumberOfNodes=nNodesOutput;
	  InputLayer.Initialize(nNodesInput, HiddenLayer, null);
	  InputLayer.RandomizeWeightsDog1();	  
	  HiddenLayer.Initialize(nNodesHidden,OutputLayer , InputLayer);
	  HiddenLayer.RandomizeWeightsDog2();	 
	  OutputLayer.Initialize(nNodesOutput, null, HiddenLayer);
      
  }
  public void InitializeDog2(int nNodesInput,int nNodesHidden,int nNodesOutput){
	  InputLayer.NumberOfNodes=nNodesInput;
	  HiddenLayer.NumberOfNodes=nNodesHidden;
	  OutputLayer.NumberOfNodes=nNodesOutput;
	  InputLayer.Initialize(nNodesInput, HiddenLayer, null);
	  //InputLayer.RandomizeWeightsDog3();	  
	  HiddenLayer.Initialize(nNodesHidden,OutputLayer , InputLayer);
	  //HiddenLayer.RandomizeWeightsDog4();	 
	  OutputLayer.Initialize(nNodesOutput, null, HiddenLayer);
      
  }
  public void InitializeDog3(int nNodesInput,int nNodesHidden,int nNodesOutput){
	  InputLayer.NumberOfNodes=nNodesInput;
	  HiddenLayer.NumberOfNodes=nNodesHidden;
	  OutputLayer.NumberOfNodes=nNodesOutput;
	  InputLayer.Initialize(nNodesInput, HiddenLayer, null);
	  //InputLayer.RandomizeWeightsDog5();	  
	  HiddenLayer.Initialize(nNodesHidden,OutputLayer , InputLayer);
	  //HiddenLayer.RandomizeWeightsDog6();	 
	  OutputLayer.Initialize(nNodesOutput, null, HiddenLayer);
      
  }
  public void SetInput(int i,double value){
	  if((i<InputLayer.NumberOfNodes)){
		  InputLayer.NeuronValues[i]=value;
	  }
  }
  public double GetOutput(int i){
	  if((i>=0)&&(i<OutputLayer.NumberOfNodes)){
		  return OutputLayer.NeuronValues[i];
	  }
	  return (double ) 0;
  }
  public void SetDesiredOutput(int i,double value){
	  if((i>=0)&&(i<OutputLayer.NumberOfNodes)){
		  OutputLayer.DesiredValues[i]=value;
	  }
  }
  public void FeedForward(){
	  InputLayer.CalculateNeuronValues();
	  HiddenLayer.CalculateNeuronValues();
	  OutputLayer.CalculateNeuronValues();
  }
  public void BackPropagate(){
	  OutputLayer.CalculateErrors();
	  HiddenLayer.CalculateErrors();
	  HiddenLayer.AdjustWeights();
	  InputLayer.AdjustWeights();
  }
  public int GetMaxOutputID(){
	  int id;
	  double maxval;
	  maxval=OutputLayer.NeuronValues[0];
	  id=0;
	  for(int i=0;i<OutputLayer.NumberOfNodes;i++){
		  if(OutputLayer.NeuronValues[i]>maxval){
			  maxval=OutputLayer.NeuronValues[i];
			  id=i;
		  }
	  }
	  //System.out.println("id="+id);
	  return id;
  }
  public int GetMaxOutputID2(int begin,int end){
	  int id=0;
	  double maxval;
	  maxval=OutputLayer.NeuronValues[begin];
	  id=begin;
	  for(int i=begin;i<end;i++){
		  if(OutputLayer.NeuronValues[i]>maxval){
			  maxval=OutputLayer.NeuronValues[i];
			  id=i;
		  }
	 }
	  return id;
  }
  public void SetLearningRate(double rate){
	  InputLayer.LearningRate=rate;
	  HiddenLayer.LearningRate=rate;
	  OutputLayer.LearningRate=rate;
  }
  public void SetLinearOutput(boolean useLinear){
	  InputLayer.LinearOutPut=useLinear;
	  HiddenLayer.LinearOutPut=useLinear;
	  OutputLayer.LinearOutPut=useLinear;
  }
  public void SetMomentum(boolean useMomentum,double factor){
	  InputLayer.UseMomentum=useMomentum;
	  HiddenLayer.UseMomentum=useMomentum;
	  OutputLayer.UseMomentum=useMomentum;
	  InputLayer.MomentumFactor=factor;
	  HiddenLayer.MomentumFactor=factor;
	  OutputLayer.MomentumFactor=factor;
  }
  public double CalculateError(){
	  double error=0;
	  for(int i=0;i<OutputLayer.NumberOfNodes;i++){
		  error+=Math.pow(OutputLayer.NeuronValues[i]-OutputLayer.DesiredValues[i], 2);
	  }
	  error=error/OutputLayer.NumberOfNodes;
	  return error;
  }
  public static void main(String args[]){
	  
	  double f=0;
	  double f2=0;
	  int conall=0;
	  int con=0;int con2=0;
	  int conturn=0;
	  double max=0;
	  double max2=0;
	  
      Brain.Initialize(1, 2, 2);
      Brain.SetLearningRate(0.2);
	  Brain.SetMomentum(true,0.9);
      while(f<=0.9){
		 Brain.TrainTheBrain();
	  try{  
		  String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\My Java Projects\\sseProj\\dev\\DeadEndGoogleSVN\\DeadEndGoogleSVN\\db\\ann\\090229data.mdb";
	         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection conn=DriverManager.getConnection(strurl);
	         Statement stmt=conn.createStatement();
	         ResultSet a;
	 		 a=stmt.executeQuery("SELECT * FROM haha1 ");	 		 
	 		while(a.next()){	 			
				here9=a.getDouble(8);
				here7=a.getInt("way1");
				Brain.SetInput(0,here9/99.844);				
	            Brain.FeedForward();
	           if(here7==0&&Brain.GetMaxOutputID()==0){
	        	   con++;
	        	}
	           if(here7==2&&Brain.GetMaxOutputID()==1){
	        	   con++;
	        	}
	           conall++;
	         }
	 		f=(double)con/conall;
	 		
	  if(f>max){
	    max=f;
	    System.out.println("f is"+max*100+",");
	    
	   }
	  
	  conturn++;
	  con=0;
	  
	  conall=0;
	  stmt.close();
	  conn.close();
	 }catch(Exception a)
     {
         a.printStackTrace();
     }
	  }
	  try{
	        String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm.mdb";
	        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        Connection conn=DriverManager.getConnection(strurl);
	        Statement stmt=conn.createStatement();	        
	        stmt.executeUpdate("CREATE TABLE LR11(x1 double null)");        
	        for(int i=0;i<InputLayer.NumberOfNodes;i++)
	    	    for(int j=0;j<HiddenLayer.NumberOfNodes;j++)
	        stmt.executeUpdate("INSERT INTO LR11(x1) VALUES ('"+InputLayer.Weights[i][j]+"')");	        	        
	        stmt.executeUpdate("CREATE TABLE LR22(x1 double null)");
	        for(int i=0;i<HiddenLayer.NumberOfNodes;i++)
	    	    for(int j=0;j<OutputLayer.NumberOfNodes;j++)
	    	    	stmt.executeUpdate("INSERT INTO LR22(x1) VALUES ('"+HiddenLayer.Weights[i][j]+"')");	
	        stmt.executeUpdate("CREATE TABLE LR33(x1 double null)");
	        for(int i=0;i<HiddenLayer.NumberOfNodes;i++)
	        	 stmt.executeUpdate("INSERT INTO LR33(x1) VALUES ('"+InputLayer.BiasWeights[i]+"')");
	        stmt.executeUpdate("CREATE TABLE LR44(x1 double null)");
	        for(int i=0;i<OutputLayer.NumberOfNodes;i++)
	        	stmt.executeUpdate("INSERT INTO LR44(x1) VALUES ('"+HiddenLayer.BiasWeights[i]+"')");
	        stmt.close();
	        conn.close();
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	        }
  }
  public void TrainTheBrain(){
	double error=1;
	int c=0;
	try{  
         String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm2.mdb";
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         Connection conn=DriverManager.getConnection(strurl);
         Statement stmt=conn.createStatement();
         ResultSet a;
 		 a=stmt.executeQuery("SELECT * FROM haha1 ");
	while((error>0.05)&&(c<50000)){
		error=0;
		c++;
		while(a.next()){
			here9=a.getDouble(8);
			here7=a.getInt("way1");
			Brain.SetInput(0,here9/99.844);
			if(here7==0){	
			Brain.SetDesiredOutput(0, 0.9);
			Brain.SetDesiredOutput(1, 0.1);
			}
			if(here7==2){
			    Brain.SetDesiredOutput(0, 0.1);
				Brain.SetDesiredOutput(1, 0.9);
				}
			Brain.FeedForward();
			error+=Brain.CalculateError();
			Brain.BackPropagate();
		}
		error=error/24;
	}
	  stmt.close();
	  conn.close();
	 }catch(Exception a)
     {
         a.printStackTrace();
     }
  }
  public void printweight(){
	  char result='A';
	  int con=0;
	  int conall=0;
	  double f=0;
	  double max=0;
	  try{  
		 String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\dm3.mdb";
	         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection conn=DriverManager.getConnection(strurl);
	         Statement stmt=conn.createStatement();
	         ResultSet a;
	 		 a=stmt.executeQuery("SELECT * FROM haha1 ");
	 		while(a.next()){
	 			here1=a.getDouble(1)/500;
				here2=a.getDouble(2)/500;
				here3=a.getDouble(3)/500;
				here4=a.getDouble(4)/500;
				here5=a.getDouble(5)/15.5;
				here6=a.getDouble(6)/15.5;
				b=a.getString(9);
				Brain.SetInput(0,here1);
				Brain.SetInput(1,here2);
				Brain.SetInput(2,here3);
				Brain.SetInput(3,here4);
				Brain.SetInput(4,here5);
				Brain.SetInput(5,here6);
				Brain.SetInput(6,here7);
				Brain.SetInput(7,here8);
	            Brain.FeedForward();
	           switch(Brain.GetMaxOutputID()){
	                case 0:/*System.out.println("A");*/result='A';break;
	                case 1:/*System.out.println("B");*/result='B';break;
	                case 2:/*System.out.println("C");*/result='C';break;
	            }
	           //System.out.println(b+"------"+result);
	           if(b.charAt(0)==result){
	        	   con++;
	        	   //System.out.println(b+"------"+result);
	        	}
	           conall++;
	           //System.out.println(b+"------"+result);
	        }
	 		f=(double)con/conall;
	  if(f>max){
	    max=f;
	    System.out.println(max*100);}
	  stmt.close();
	  conn.close();
	 }catch(Exception a)
     {
         a.printStackTrace();
     }
  }
}
