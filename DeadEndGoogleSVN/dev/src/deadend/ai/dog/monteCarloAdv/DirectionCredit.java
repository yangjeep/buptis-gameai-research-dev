/*
 * deadend.ai.monteCarlo.DirectionCredit
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.ai.monteCarlo.DirectionCredit is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.monteCarlo.DirectionCredit is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.ai.dog.monteCarloAdv;

import deadend.globalenum.Directions;

import java.util.*;
/**
 *
 * @author Yang JiaJian
 */
public class DirectionCredit {

    ArrayList<Integer> credit;
    
    public DirectionCredit(){
        credit=new ArrayList<Integer>(4);
        for(int i=1;i<=4;i++){
            credit.add(0);
        }
    }


    public void addCredit(Directions d){
        //System.out.println(d.toString());
        int k=0;
        if(d==Directions.Down){
            k=this.credit.get(0);
            k+=1;
            this.credit.set(0, k);
        }
        if(d==Directions.Up){
            k=this.credit.get(1);
            k+=1;
            this.credit.set(1, k);
        }
        if(d==Directions.Left){
            k=this.credit.get(2);
            k+=1;
            this.credit.set(2, k);
        }
        if(d==Directions.Right){
            k=this.credit.get(3);
            k+=1;
            this.credit.set(3, k);
        }
    }

   /**
    * @deprecated 
    */
   public void addDrawCredit(Directions d){
        //System.out.println(d.toString());
        int k=0;
        if(d==Directions.Down){
            k=this.credit.get(0);
            k++;
            this.credit.set(0, k);
        }
        if(d==Directions.Up){
            k=this.credit.get(1);
            k++;
            this.credit.set(1, k);
        }
        if(d==Directions.Left){
            k=this.credit.get(2);
            k++;
            this.credit.set(2, k);
        }
        if(d==Directions.Right){
            k=this.credit.get(3);
            k++;
            this.credit.set(3, k);
        }
    }

    public void subCredit(Directions d){
        //System.out.println(d.toString());
        int k=0;
        if(d==Directions.Down){
            k=this.credit.get(0);
            k--;
            this.credit.set(0, k);
        }
        if(d==Directions.Up){
            k=this.credit.get(1);
            k--;
            this.credit.set(1, k);
        }
        if(d==Directions.Left){
            k=this.credit.get(2);
            k--;
            this.credit.set(2, k);
        }
        if(d==Directions.Right){
            k=this.credit.get(3);
            k--;
            this.credit.set(3, k);
        }
    }

    public Directions findBest(java.awt.Point thispos,java.awt.Point catpos){
        int k=this.credit.get(0);
        int t=-1;
        boolean judged=false;
        for(int i=0;i<this.credit.size();i++){
            if(this.credit.get(i)>k){
                judged=true;
                t=i;
                k=this.credit.get(i);
            }
            System.out.print(" "+this.credit.get(i));
        }
        System.out.println();
        System.out.println("k="+k);
        if(k>0){
            if(t==0 || t==-1)return Directions.Down;
            if(t==1)return Directions.Up;
            if(t==2)return Directions.Left;
            if(t==3)return Directions.Right;
        }else{
            
            int x,y;
            int cx,cy;

            x=thispos.x;
            y=thispos.y;

            cx=catpos.x;
            cy=catpos.y;

            java.util.Random rand=new java.util.Random();
            if(rand.nextBoolean()){
                if(cx>x)return Directions.Right;
                else return Directions.Left;
            }else{
                if(cy>y)return Directions.Down;
                else return Directions.Up;
            }
        }
        return null;
    }
}
