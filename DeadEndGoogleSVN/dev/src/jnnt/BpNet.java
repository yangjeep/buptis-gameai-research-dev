/*
 * jnnt.BpNet
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * jnnt.BpNet is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * jnnt.BpNet is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package jnnt;
import java.util.Random;
/**
 *
 * @author Yang JiaJian
 */
public class BpNet extends Object {

  int inNum;  //����ӵ���
  int hideNum;//�����ӵ���
  int outNum;  //���ӵ���

  Random R;
  int epochs;

  double x[]; //������
  double x1[];//�����ӵ�״ֵ̬
  double x2[];//���ӵ�״ֵ̬

  double o1[];
  double o2[];
  double w[][];//�����ӵ�Ȩֵ
  double w1[][];//���ӵ�Ȩֵ
  double rate_w; //Ȩֵѧϰ�ʣ������-������)
  double rate_w1;//Ȩֵѧϰ�� (������-����)
  double rate_b1;//�����㷧ֵѧϰ��
  double rate_b2;//���㷧ֵѧϰ��
  double b1[];//�����ӵ㷧ֵ
  double b2[];//���ӵ㷧ֵ
  double pp[];
  double qq[];
  double yd[];
  double e;
  double in_rate;//�����һ������ϵ��



  public BpNet(int inNum,int hideNum,int outNum) {
  R=new Random();
  this.epochs=500;
  this.inNum=inNum;
  this.hideNum=hideNum;
  this.outNum=outNum;
  x=new double[inNum]; //������
  x1=new double[hideNum];//�����ӵ�״ֵ̬
  x2=new double[outNum];//���ӵ�״ֵ̬

  o1=new double[hideNum];
  o2=new double[outNum];
  w=new double[inNum][hideNum];//�����ӵ�Ȩֵ
  w1=new double[hideNum][outNum];//���ӵ�Ȩֵ
  b1=new double[hideNum];//�����ӵ㷧ֵ
  b2=new double[outNum];//���ӵ㷧ֵ
  pp=new double[hideNum];
  qq=new double[outNum];
  yd=new double[outNum];

  for (int i=0;i<inNum;i++)
      for (int j=0;j<hideNum;j++)
      w[i][j]=R.nextDouble();
  for (int i=0;i<hideNum;i++)
      for (int j=0;j<outNum;j++)
      w1[i][j]=R.nextDouble();

  rate_w=0.05;//Ȩֵѧϰ�ʣ������-������)
  rate_w1=0.05;//Ȩֵѧϰ�� (������-����)
  rate_b1=0.05;//�����㷧ֵѧϰ��
  rate_b2=0.05;//���㷧ֵѧϰ��
  e=0.0;
  in_rate=1.0;//�����һ��ϵ��


  }


  /**********************************/
  /*****BP�񾭿������㷨ѵw����*****/
  public void train(double p[][],double t[][],int samplenum){

  e=0.0;
  double pmax=0.0;
  for (int isamp=0;isamp<samplenum;isamp++){
      for (int i=0;i<inNum;i++)
          {if (Math.abs(p[isamp][i])>pmax)
              pmax=Math.abs(p[isamp][i]);
          }
      for (int j=0;j<outNum;j++)
          {if (Math.abs(t[isamp][j])>pmax)
              pmax=Math.abs(t[isamp][j]);
          }
      }//end for isamp


  in_rate=pmax;



  for(int isamp=0;isamp<samplenum;isamp++)//ѭ��ѵwһ����
  {
  for(int i=0;i<inNum;i++)
    x[i]=p[isamp][i]/in_rate;
  for(int i=0;i<outNum;i++)
    yd[i]=t[isamp][i]/in_rate;

  //����ÿ��������������׼


  for(int j=0;j<hideNum;j++)
   {o1[j]=0.0;
    for(int i=0;i<inNum;i++)
      o1[j]=o1[j]+w[i][j]*x[i];
    x1[j]=1.0/(1.+Math.exp(-o1[j]-b1[j]));
   }


 for(int k=0;k<outNum;k++)
   {o2[k]=0.0;
    for(int j=0;j<hideNum;j++)
      o2[k]=o2[k]+w1[j][k]*x1[j];
    x2[k]=1.0/(1.0+Math.exp(-o2[k]-b2[k]));
    //x2[k]=o2[k]-b2[k];
   }

    //System.out.println("ok1");
 for(int k=0;k<outNum;k++)
   {qq[k]=(yd[k]-x2[k])*x2[k]*(1.-x2[k]);
    //qq[k]=(yd[k]-x2[k]);
    e+=Math.abs(yd[k]-x2[k])*Math.abs(yd[k]-x2[k]);//������
    for(int j=0;j<hideNum;j++)
    w1[j][k]=w1[j][k]+rate_w1*qq[k]*x1[j];
   }



 for(int j=0;j<hideNum;j++)
   {
    pp[j]=0.0;
    for(int k=0;k<outNum;k++)
      pp[j]=pp[j]+qq[k]*w1[j][k];
    pp[j]=pp[j]*x1[j]*(1.-x1[j]);
    for(int i=0;i<inNum;i++)
       w[i][j]=w[i][j]+rate_w*pp[j]*x[i];
    }

 for(int k=0;k<outNum;k++)
   b2[k]=b2[k]+rate_b2*qq[k];
 for(int j=0;j<hideNum;j++)
   b1[j]=b1[j]+rate_b1*pp[j];


   }//end isamp��ѭ��
  e=Math.sqrt(e);

 }//end train
 /***************************************/
  /*****BP�񾭿������㷨ģ����㺯��*****/
 public double[] sim(double psim[]){


  for(int i=0;i<inNum;i++)
    x[i]=psim[i]/in_rate;

  for(int j=0;j<hideNum;j++)
   {o1[j]=0.0;
    for(int i=0;i<inNum;i++)
      o1[j]=o1[j]+w[i][j]*x[i];
    x1[j]=1.0/(1.+Math.exp(-o1[j]-b1[j]));
   }
 for(int k=0;k<outNum;k++)
   {o2[k]=0.0;
    for(int j=0;j<hideNum;j++)
       o2[k]=o2[k]+w1[j][k]*x1[j];
    x2[k]=1.0/(1.0+Math.exp(-o2[k]-b2[k]));
    //x2[k]=o2[k]-b2[k];
    x2[k]=in_rate*x2[k];

   }


 return x2;
} //end sim

}
