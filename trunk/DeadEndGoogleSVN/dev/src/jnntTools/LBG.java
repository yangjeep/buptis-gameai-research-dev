package jnntTools;



public class LBG extends Object {

  double c[][];//����
  int indexc[];
  int indext[];
  double d[];//���루��)


  public LBG(double t[][],int N) {

  double e=0.001;
  double td0=0;//�ϴ�����
  double td;//��������
  double d0=999999.9;
  double s,s1;
  boolean notend=true;

  c=new double[N][t[0].length];//��������
  indexc=new int[N];//��������
  indext=new int[t.length];//ȷ����t�ķ���
  d=new double[N];//�������

  for (int i=0;i<N;i++)
  {
      indexc[i]=i;          //ȷ����ʼ����Ϊ��1-N
      for(int j=0;j<t[0].length;j++)
         c[i][j]=t[indexc[i]][j];
  }

  
  while (notend){
  //����fȦ
  for (int i=0;i<t.length;i++)//�������
  { d0=9999999.9;
    for (int j=0;j<N;j++)//������
    {s=0.0;
     for (int k=0;k<t[0].length;k++)
          s+=(t[i][k]-c[j][k])*(t[i][k]-c[j][k]);
     s=Math.sqrt(s);
     if (s<d0){
        d0=s;
        indext[i]=j;}

     } //end for j
  }//end for i


  //���µ�����
  for (int i=0;i<N;i++)
    {d[i]=999999.0;
     s=0;

     for (int j=0;j<t.length;j++)
         if (indext[j]==i)
          {d0=0.0;
          for (int k=0;k<t.length;k++)
             {if ((indext[k]==i)&&(j!=k))
              //if (indext[k]==i)
                    { s=0;
                      for (int l=0;l<t[0].length;l++)
                           s+=(t[j][l]-t[k][l])*(t[j][l]-t[k][l]);
                      s=Math.sqrt(s);
                    }
             }//end for k


          d0+=s;
          if (d0==0.0)
             d0=1.0;
          //if ((d0<d[i])&&(d0!=0.0)){
          if (d0<d[i]){

             d[i]=d0;

             indexc[i]=j;
              for(int m=0;m<t[0].length;m++)
                   c[i][m]=t[indexc[i]][m];
          }
          }//end for j
     
     }//end i

 //��������
 td=0;
 for (int i=0;i<N;i++)
     td+=d[i];
 if (Math.abs(td-td0)<e)
    notend=false;
    else
    td0=td;

    }//end while

  }//end LBG

  public double[][] getc(){
   return this.c;
   }

  public double[] getd(){
   return this.d;
   }

   
}