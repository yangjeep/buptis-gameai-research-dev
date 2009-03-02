/*
 * jnnt.NeuralNetworkApplet
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * jnnt.NeuralNetworkApplet is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * jnnt.NeuralNetworkApplet is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package jnnt;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Properties;

import java.applet.Applet;

/**
 *
 * @author Yang JiaJian
 */
public class NeuralNetworkApplet extends Applet {


  Choice netChoice;
  Choice inNumChoice;
  Choice hideNumChoice;
  Choice outNumChoice;
  Checkbox chkbox_save;
  int task;
  BpNet bpnet;
  RbfNet rbfnet;
  boolean clear;
  int row;
  int left;
  int bottom;
  int top;
  double p1[][];//ѵw������
  double t1[][];//ѵw�����
  double p2[][];//ģ���������
  int inNum;
  int hideNum;
  int outNum;
  int sampleNum;
  int simNum;
  PrintStream ps;
  int epochs;
  TextArea txtarea;

  public void init() {
    left=50;
    top=80;
    bottom=300;
    clear=false;
    row=0;
    epochs=60000;//ѧϰ�������ɵ�

    setLayout(new BorderLayout());
    Panel topPanel=new Panel();

    Panel bottomPanel=new Panel();

    netChoice=new Choice();


    netChoice.addItem("BP network");
    netChoice.addItem("LBG clustering");
    netChoice.addItem("RBF network");

    netChoice.addItemListener(new ItemListener(){
        public void itemStateChanged (ItemEvent event){
        repaint();
        }
    });

    topPanel.add(netChoice);

    Label lab_inNum=new Label("Input Nodes:");
    topPanel.add(lab_inNum);
    inNumChoice=new Choice();
    for (int i=1;i<10;i++)
       inNumChoice.addItem(String.valueOf(i));
    topPanel.add(inNumChoice);

    Label lab_hideNum=new Label("Hiding Nodes:");
    topPanel.add(lab_hideNum);
    hideNumChoice=new Choice();
    for (int i=1;i<10;i++)
       hideNumChoice.addItem(String.valueOf(i));
    hideNumChoice.select("3");
    topPanel.add(hideNumChoice);

   Label lab_outNum=new Label("Output Nodes:");
    topPanel.add(lab_outNum);
    outNumChoice=new Choice();
    for (int i=1;i<20;i++)
       outNumChoice.addItem(String.valueOf(i));
    topPanel.add(outNumChoice);

    Button button_load=new Button("LoadData");
    button_load.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
        task=10;
        repaint();
        }
    });
    topPanel.add(button_load);

    Button button_train=new Button("Train");
    button_train.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            task=1;
            repaint();
        }
    });
    topPanel.add(button_train);

    Button button_sim=new Button("Simulation");
    button_sim.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
        task=2;
        repaint();
        }
    });

    topPanel.add(button_sim);


    Button printButton=new Button("print...");
    printButton.setForeground(Color.black);
   //p.add(printButton);
    printButton.addActionListener(new ActionListener(){
        public void actionPerformed (ActionEvent event){
           printComponents(NeuralNetworkApplet.this);
           }
     });
     topPanel.add(printButton);

    chkbox_save=new Checkbox("save data");
    // bottomPanel.add(chkbox_save);

    add("North",topPanel);
    txtarea=new TextArea(12,105);
    bottomPanel.add(txtarea);
    add("South", bottomPanel);



  }

  public void paint(Graphics g){
  setBackground(Color.white);
   switch (task)
   {
      case 1:if (netChoice.getSelectedItem()=="BP network")
                 drawBpTrain(g);
             else if  (netChoice.getSelectedItem()=="LBG clustering")
                 drawLBG(g);
             else if  (netChoice.getSelectedItem()=="RBF network")
                 drawRbfTrain(g);
             break;
      case 2:if (netChoice.getSelectedItem()=="BP network")
                 drawBpSim(g);
             else if  (netChoice.getSelectedItem()=="RBF network")
                 drawRbfSim(g);
             break;
      case 10:loadData(g);
             break;

    }//end switch
    task=0;
  }

public void drawBpTrain(Graphics g){

  int time=1000;
  double etime=1000.0;
  //g.drawString(netChoice.getSelectedItem(),300,300);
  // double p1[][]={{0.1},{0.2},{0.3},{0.4},{0.5}};
  // double t1[][]={{0.12},{0.22},{0.32},{0.42},{0.52}};
  bpnet=new BpNet(Integer.parseInt(inNumChoice.getSelectedItem()),Integer.parseInt(hideNumChoice.getSelectedItem()),Integer.parseInt(outNumChoice.getSelectedItem()));
   //bpnet=new BpNet(2,3,1);
  //��������������

   g.setColor(getBackground());
   g.fillRect(0,0,left,bottom);
   g.setColor(getForeground());
  g.drawLine(left,bottom,left+1000,bottom);
  g.drawLine(left,bottom,left,0);


  for (int i=0;i<epochs;i++)
  {
     bpnet.train(p1,t1,sampleNum);

      if (i==0)
     { //System.out.println(String.valueOf(bpnet.e));
       etime=(int)(150/bpnet.e);
       //System.out.println(String.valueOf(etime));
        for (int m=0;m<=bottom/20-3;m++)
          {
           g.drawLine(left,bottom-20*m,left-3,bottom-20*m);
           g.drawString(String.valueOf((int)(m*20/etime*1000)/1000.0),left-30,bottom-20*m);
           }
     }

     if ((i/100)*100==i)
        g.setColor(Color.blue);
        g.drawLine(left+i/100,bottom-(int)(bpnet.e*etime),left+i/100,bottom-(int)(bpnet.e*etime)-1);
        if ((i/10000)*10000==i){
        g.setColor(Color.black);
        g.drawLine(left+i/100,bottom,left+i/100,bottom+3);
        g.drawString(String.valueOf(i),left+i/100,bottom+15);
        }
   }

        txtarea.appendText("-----------------------------------\n");
        txtarea.appendText("BpNet\n");
        txtarea.appendText("-----------------------------------\n");
        txtarea.appendText("inNum:"+String.valueOf(bpnet.inNum)+"\n");
        txtarea.appendText("hideNum:"+String.valueOf(bpnet.hideNum)+"\n");
        txtarea.appendText("outNum:"+String.valueOf(bpnet.outNum)+"\n");
        txtarea.appendText("in_rate:"+String.valueOf(bpnet.in_rate)+"\n");

        txtarea.appendText("w\n");
        for (int i=0;i<bpnet.inNum;i++)
            for (int j=0;j<bpnet.hideNum;j++)
                  txtarea.appendText("w("+String.valueOf(i)+","+String.valueOf(j)+")"+String.valueOf(bpnet.w[i][j])+"\n");
        txtarea.appendText("w1\n");
        for (int i=0;i<bpnet.hideNum;i++)
            for (int j=0;j<bpnet.outNum;j++)
                  txtarea.appendText("w1("+String.valueOf(i)+","+String.valueOf(j)+")"+String.valueOf(bpnet.w1[i][j])+"\n");
        txtarea.appendText("b1\n");
        for (int i=0;i<bpnet.hideNum;i++)
             txtarea.appendText("b1("+String.valueOf(i)+")"+String.valueOf(bpnet.b1[i])+"\n");
        txtarea.appendText("b2\n");
        for (int i=0;i<bpnet.outNum;i++)
             txtarea.appendText("b2("+String.valueOf(i)+")"+String.valueOf(bpnet.b2[i])+"\n");
        txtarea.appendText("-----------------------------------\n");


   if (chkbox_save.getState())
   { try{
        ps=null;
        //ps=new PrintStream(new FileOutputStream(getCodeBase()+"nnsave.txt"));
        ps=new PrintStream(new FileOutputStream("nnsave.txt"));
        ps.println("-----------------------------------");
        ps.println("BpNet");
        ps.println("-----------------------------------");
        ps.println("inNum:"+String.valueOf(bpnet.inNum));
        ps.println("hideNum:"+String.valueOf(bpnet.hideNum));
        ps.println("outNum:"+String.valueOf(bpnet.outNum));
        ps.println("w");
        for (int i=0;i<bpnet.inNum;i++)
            for (int j=0;j<bpnet.hideNum;j++)
                 ps.println("w("+String.valueOf(i)+","+String.valueOf(j)+")"+String.valueOf(bpnet.w[i][j]));
        ps.println("w1");
        for (int i=0;i<bpnet.hideNum;i++)
            for (int j=0;j<bpnet.outNum;j++)
                 ps.println("w1("+String.valueOf(i)+","+String.valueOf(j)+")"+String.valueOf(bpnet.w1[i][j]));
        ps.println("b1");
        for (int i=0;i<bpnet.hideNum;i++)
            ps.println("b1("+String.valueOf(i)+")"+String.valueOf(bpnet.b1[i]));
        ps.println("b2");
        for (int i=0;i<bpnet.outNum;i++)
            ps.println("b2("+String.valueOf(i)+")"+String.valueOf(bpnet.b2[i]));
         ps.println("-----------------------------------");


     }
     catch(Exception e){}

    }//end if


}//end drawbptarin

public void drawBpSim(Graphics g){
     double p21[]=new double[inNum];
     double t2[]=new double[outNum];

    if (chkbox_save.getState())
   { try{
        ps=null;
        //ps=new PrintStream(new FileOutputStream(getCodeBase()+"nnsave.txt"));
        ps=new PrintStream(new FileOutputStream("nnsave.txt"));
        ps.println("-------------------------------");
        ps.println("BpNet Simulation Results:");
        ps.println("-------------------------------");
         }
     catch(Exception e){}
   }

    txtarea.appendText("-------------------------------\n");
    txtarea.appendText("BpNet Simulation Results:\n");
    txtarea.appendText("-------------------------------\n");


   for (int n=0;n<simNum;n++){

     for(int i=0;i<inNum;i++)
        p21[i]=p2[n][i];
     if (row>10)
     {
        row=0;
        cleartext(g);
     }
     t2=bpnet.sim(p21);
     row++;
     //g.drawString("inputValue:",left,bottom+20+row*20);
     txtarea.appendText("inputvalue:\n");
     for(int i=0;i<bpnet.inNum;i++)
        //g.drawString(String.valueOf(p21[i]),left+100+80*i,bottom+20+row*20);
        txtarea.appendText(String.valueOf(p21[i])+"\n");
     row++;
     //g.drawString("outputValue:",left,bottom+20+row*20);
     txtarea.appendText("outputvalue:\n");
     for(int i=0;i<bpnet.outNum;i++)
        //g.drawString(String.valueOf(t2[i]),left+100+80*i,bottom+20+row*20);
        txtarea.appendText(String.valueOf(t2[i])+"\n");

   if (chkbox_save.getState())
   { try{
        ps.println("input:");
        for(int i=0;i<bpnet.inNum;i++)
                ps.println(String.valueOf(p21[i]));
        ps.println("output:");
        for(int i=0;i<bpnet.outNum;i++)
                ps.println(String.valueOf(t2[i]));
         }
     catch(Exception e){}
   }

     }//end for n
   }//end drawbpsim

public void drawRbfTrain(Graphics g){

  int time=1000;
  double etime=100.0;
   rbfnet=null;
   rbfnet=new RbfNet(Integer.parseInt(inNumChoice.getSelectedItem()),Integer.parseInt(hideNumChoice.getSelectedItem()),Integer.parseInt(outNumChoice.getSelectedItem()),p1);
  inNum=Integer.parseInt(inNumChoice.getSelectedItem());
  hideNum=Integer.parseInt(hideNumChoice.getSelectedItem());
  outNum=Integer.parseInt(outNumChoice.getSelectedItem());

 g.setColor(getBackground());
 g.fillRect(0,0,left,bottom);
 g.setColor(getForeground());
  //��������������

  g.drawLine(left,bottom,left+1000,bottom);
  g.drawLine(left,bottom,left,0);

  for (int i=0;i<epochs;i++)
  {
     rbfnet.train(p1,t1,sampleNum);

     if (i==0)
     { System.out.println(String.valueOf(rbfnet.e));
       etime=(int)(150/rbfnet.e);
       System.out.println(String.valueOf(etime));
        for (int m=0;m<=bottom/20-3;m++)
          {
           g.drawLine(left,bottom-20*m,left-3,bottom-20*m);
           g.drawString(String.valueOf((int)(m*20/etime*1000)/1000.0),left-30,bottom-20*m);
           }
     }

     //System.out.println(String.valueOf(rbfnet.e));
     if ((i/100)*100==i)
        g.setColor(Color.blue);
        g.drawLine(left+i/100,bottom-(int)(rbfnet.e*etime),left+i/100,bottom-(int)(rbfnet.e*etime)-1);
        if ((i/10000)*10000==i){
        g.setColor(Color.black);
        g.drawLine(left+i/100,bottom,left+i/100,bottom+3);
        g.drawString(String.valueOf(i),left+i/100,bottom+15);
        }
   }
   //System.out.println(String.valueOf(rbfnet.e));
        txtarea.appendText("-----------------------------------\n");
        txtarea.appendText("RbfNet\n");
        txtarea.appendText("-----------------------------------\n");
        txtarea.appendText("inNum:"+String.valueOf(rbfnet.inNum)+"\n");
        txtarea.appendText("hideNum:"+String.valueOf(rbfnet.hideNum)+"\n");
        txtarea.appendText("outNum:"+String.valueOf(rbfnet.outNum)+"\n");
        txtarea.appendText("c"+"\n");
        for (int i=0;i<rbfnet.hideNum;i++)
            for (int j=0;j<rbfnet.inNum;j++)
                 txtarea.appendText("c("+String.valueOf(i)+","+String.valueOf(j)+")"+String.valueOf(rbfnet.c[i][j])+"\n");
        txtarea.appendText("d\n");
        for (int i=0;i<rbfnet.hideNum;i++)
            txtarea.appendText("d("+String.valueOf(i)+")"+String.valueOf(rbfnet.d[i])+"\n");

        txtarea.appendText("w1\n");
        for (int i=0;i<rbfnet.hideNum;i++)
            for (int j=0;j<rbfnet.outNum;j++)
                 txtarea.appendText("w1("+String.valueOf(i)+","+String.valueOf(j)+")"+String.valueOf(rbfnet.w1[i][j])+"\n");
            txtarea.appendText("-----------------------------------\n");

    if (chkbox_save.getState())
   { try{
        ps=null;
        //ps=new PrintStream(new FileOutputStream(getCodeBase()+"nnsave.txt"));
        ps=new PrintStream(new FileOutputStream("nnsave.txt"));
        ps.println("-----------------------------------");
        ps.println("RbfNet");
        ps.println("-----------------------------------");
        ps.println("inNum:"+String.valueOf(rbfnet.inNum));
        ps.println("hideNum:"+String.valueOf(rbfnet.hideNum));
        ps.println("outNum:"+String.valueOf(rbfnet.outNum));
        ps.println("c");
        for (int i=0;i<rbfnet.hideNum;i++)
            for (int j=0;j<rbfnet.inNum;j++)
                 ps.println("c("+String.valueOf(i)+","+String.valueOf(j)+")"+String.valueOf(rbfnet.c[i][j]));
        ps.println("d");
        for (int i=0;i<rbfnet.hideNum;i++)
            ps.println("d("+String.valueOf(i)+")"+String.valueOf(rbfnet.d[i]));

        ps.println("w1");
        for (int i=0;i<rbfnet.hideNum;i++)
            for (int j=0;j<rbfnet.outNum;j++)
                 ps.println("w1("+String.valueOf(i)+","+String.valueOf(j)+")"+String.valueOf(rbfnet.w1[i][j]));
            ps.println("-----------------------------------");


     }
     catch(Exception e){}
   }//end if


}//end drawRbftarin

public void drawRbfSim(Graphics g){
     double p21[]=new double[inNum];
     double t2[]=new double[outNum];

      if (chkbox_save.getState())
   { try{
        ps=null;
        //ps=new PrintStream(new FileOutputStream(getCodeBase()+"nnsave.txt"));
        ps=new PrintStream(new FileOutputStream("nnsave.txt"));
        ps.println("-------------------------------");
        ps.println("RbfNet Simulation Results:");
        ps.println("-------------------------------");
         }
     catch(Exception e){}
   }

    txtarea.appendText("-------------------------------\n");
    txtarea.appendText("RbfNet Simulation Results:\n");
    txtarea.appendText("-------------------------------\n");


     for (int n=0;n<simNum;n++){

     for(int i=0;i<inNum;i++)
        p21[i]=p2[n][i];
     if (row>10)
     {
        row=0;
        cleartext(g);
     }
     t2=rbfnet.sim(p21);
     row++;
     //g.drawString("inputValue:",left,bottom+20+row*20);
     txtarea.appendText("inputvalue:\n");
     for(int i=0;i<rbfnet.inNum;i++)
        //g.drawString(String.valueOf(p21[i]),left+100+80*i,bottom+20+row*20);
        txtarea.appendText(String.valueOf(p21[i])+"\n");
     row++;
     //g.drawString("outputValue:",left,bottom+20+row*20);
     txtarea.appendText("outputvalue:\n");
     for(int i=0;i<rbfnet.outNum;i++)
        //g.drawString(String.valueOf(t2[i]),left+100+80*i,bottom+20+row*20);
        txtarea.appendText(String.valueOf(t2[i])+"\n");
   if (chkbox_save.getState())//��ӡ���
   { try{
        ps.println("input:");
        for(int i=0;i<rbfnet.inNum;i++)
                ps.println(String.valueOf(p21[i]));
        ps.println("output:");
        for(int i=0;i<rbfnet.outNum;i++)
                ps.println(String.valueOf(t2[i]));
         }
     catch(Exception e){}
   }

     }//end for n
   }//end drawRbfsim


public void drawLBG(Graphics g){
    clearall(g);
    LBG lbg=new LBG(p1,hideNum);


    txtarea.appendText("-------------------------------\n");
    txtarea.appendText("LBG clustering Results:\n");
    txtarea.appendText("-------------------------------\n");

    for (int i=0;i<p1.length;i++)
    {  // g.drawString("{",left,top+20*i);
        txtarea.appendText("{");
        for (int j=0;j<inNum;j++)
            {  if (j>0)
                   //g.drawString(",",left+10+j*50,top+20*i);
                   txtarea.appendText(",");
               //g.drawString(String.valueOf(p1[i][j]),left+15+j*50,top+20*i);
               txtarea.appendText(String.valueOf(p1[i][j]));
            }
        //g.drawString("}",left+50*inNum+25,top+20*i);
        txtarea.appendText("}");
        //g.drawString(String.valueOf(lbg.indext[i]),left+40+50*inNum,top+20*i);
        txtarea.appendText(String.valueOf(lbg.indext[i])+"\n");
    }//end for i
    }

public void loadData(Graphics g){//��ȡѧϰ���

    //Frame f=new Frame("file open");
    //FileDialog fd=new FileDialog(f,"File Open");
    //fd.show();

    clearall(g);
    row=0;
    String str_p1="";
    String str_t1="";
    String str_p2="";
    try
    {URL filedata=null;
     DataInputStream dis=null;
     //System.out.println(getCodeBase()+"nndata.txt");
     filedata=new URL(getCodeBase()+"nndata.txt");
     //filedata=new URL(getCodeBase()+fd.getFile());
     dis=new DataInputStream(filedata.openStream());
     String line=dis.readLine();

     row++;
     simNum=1;
     while(line!=null)
       { //System.out.println(line);

         if (line.indexOf("inNum:")>=0)
           inNum=Integer.parseInt(line.substring(line.indexOf("inNum:")+6)); //�õ�����ӵ���
         if (line.indexOf("hideNum:")>=0)
           hideNum=Integer.parseInt(line.substring(line.indexOf("hideNum:")+8));  //�õ������ӵ���
         if (line.indexOf("outNum:")>=0)
           outNum=Integer.parseInt(line.substring(line.indexOf("outNum:")+7)); //�õ����ӵ���
         if (line.indexOf("sampleNum:")>=0)
           sampleNum=Integer.parseInt(line.substring(line.indexOf("sampleNum:")+10)); //�õ�ѧϰ����
         if (line.indexOf("simNum:")>=0)
           simNum=Integer.parseInt(line.substring(line.indexOf("simNum:")+7)); //�õ���������

         if (line.indexOf("p1:")>=0)
           str_p1+=line.substring(line.indexOf("p1:")+3);
         if (line.indexOf("t1:")>=0)
           str_t1+=line.substring(line.indexOf("t1:")+3);
         if (line.indexOf("p2:")>=0)
           str_p2+=line.substring(line.indexOf("p2:")+3);
        //cleartext(g);
        //g.drawString(line,left,bottom+20+row*20);
        txtarea.appendText(line+"\n");
        row++;
        line=dis.readLine();
       }//end while
      inNumChoice.select(String.valueOf(inNum));
      hideNumChoice.select(String.valueOf(hideNum));
      outNumChoice.select(String.valueOf(outNum));

     p1=new double[sampleNum][inNum];
     t1=new double[sampleNum][outNum];
     p2=new double[simNum][inNum];

     p1=readarray(sampleNum,inNum,str_p1);  //��ȡ���������
     System.out.println(str_p1);
     //for(int i=0;i<sampleNum;i++)
       // for(int j=0;j<inNum;j++)
        //System.out.println(String.valueOf(p1[i][j]));
     t1=readarray(sampleNum,outNum,str_t1); //��ȡ��������

     p2=readarray(simNum,inNum,str_p2);     //��ȡ���������


     }//end try
     catch(Exception e){System.out.println(e.getMessage());}



     }//end loadData

public void update(Graphics g){

    paint(g);

    }//end update

//��ȡ��ݵ�����ĺ���
public double[][] readarray(int r,int c,String str_array){
String str_flow=str_array;
String str_num="";
double array[][]=new double[r][c];
for(int i=0;i<r;i++)
    for(int j=0;j<c;j++)
        {    while ((str_flow.charAt(0)=='{' )||(str_flow.charAt(0)==',' )||(str_flow.charAt(0)=='}' ))
                   str_flow=str_flow.substring(1);
             str_num="";
             while ((str_flow.charAt(0)!='{' )&&(str_flow.charAt(0)!=',' )&&(str_flow.charAt(0)!='}' ))
                   {str_num+=str_flow.substring(0,1);
                    str_flow=str_flow.substring(1);
                    }
             array[i][j]=Double.valueOf(str_num).doubleValue();
             //System.out.println(String.valueOf(array[i][j]));
         }//end for

return array;
}//end readdarray

public void cleartext(Graphics g)
{
 g.setColor(getBackground());
 g.fillRect(0,bottom+20,this.size().width,this.size().height);
 g.setColor(getForeground());
}

public void clearall(Graphics g)
{
 g.setColor(getBackground());
 g.fillRect(0,0,this.size().width,this.size().height);
g.setColor(getForeground());
}

static Frame getFrame (Component c) {
       while ((c=c.getParent())!=null) {
           if (c instanceof Frame)
               return (Frame) c;
       }
       return null;
 }

static void printComponents (Component c) {   //��ӡͼ�ν��
       Toolkit  tk=Toolkit.getDefaultToolkit();
       Frame frame=getFrame(c);
       Properties props=new Properties();

       props.put("awt.print.printer","durange");
       props.put("awt.print.numCopies","2");

       if (tk!=null) {
          String name=c.getName()+"print job";
          PrintJob pj=tk.getPrintJob(frame,name,props);

          if (pj!=null) {
             Graphics pg=pj.getGraphics();

             if(pg!=null){
               try{
                  c.printAll(pg);
                  }
                  finally{
                    pg.dispose();
                   }
               }

               pj.end();
             }
             System.out.println(props);
          }
       }
}
