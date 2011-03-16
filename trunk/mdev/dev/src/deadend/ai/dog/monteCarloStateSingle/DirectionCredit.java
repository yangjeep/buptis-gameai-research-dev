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

package deadend.ai.dog.monteCarloStateSingle;

import deadend.globalenum.*;

import java.util.*;
/**
 *
 * @author Yang JiaJian
 */
public class DirectionCredit {

    ArrayList<Integer> credit;
    ArrayList<Integer> dcredit;
    /**
     *
     */
    public DirectionCredit(){
        credit=new ArrayList<Integer>(4);
        dcredit=new ArrayList<Integer>(4);
        for(int i=1;i<=4;i++){
            credit.add(0);
            dcredit.add(0);
        }

    }

    MSimGame game;
    /**
     *
     * @param game
     */
    public DirectionCredit(MSimGame game){
        this.game=game;
        credit=new ArrayList<Integer>(4);
        dcredit=new ArrayList<Integer>(4);
        for(int i=1;i<=4;i++){
            credit.add(0);
            dcredit.add(0);
        }
    }


    /**
     *
     * @param d
     */
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
    * @param d
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

   /**
    * @param d
    * @deprecated
    */
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

    /**
     *
     * @param d
     * @param result
     */
    public void autoAddCredit(Directions d, GameResults result){
        int incr=0;
        if(result==GameResults.DogWin)incr=1;
        else if(result==GameResults.Draw)incr=0;
        else if(result==GameResults.CatWin)incr=0;

        int k=0;
        if(d==Directions.Down){
            k=this.credit.get(0);
            k+=incr;
            this.credit.set(0, k);
        }
        if(d==Directions.Up){
            k=this.credit.get(1);
            k+=incr;
            this.credit.set(1, k);
        }
        if(d==Directions.Left){
            k=this.credit.get(2);
            k+=incr;
            this.credit.set(2, k);
        }
        if(d==Directions.Right){
            k=this.credit.get(3);
            k+=incr;
            this.credit.set(3, k);
        }
        
    }

    /**
     *
     * @param thispos
     * @param catpos
     * @return
     */
    public Directions findBest(java.awt.Point thispos,java.awt.Point catpos){
        int k=0;
        k=this.credit.get(0);
        int t=-1;
        boolean judged=false;
        for(int i=0;i<this.credit.size();i++){
            if(this.credit.get(i)>=k){
                judged=true;
                t=i;
                k=this.credit.get(i);
            }
            System.out.print(" "+this.credit.get(i));
        }
        System.out.println();
        System.out.println("k="+k);

        Random rand=new Random();
        if(k>0){
            if(t==0 || t==-1)return Directions.Down;
            else if(t==1)return Directions.Up;
            else if(t==2)return Directions.Left;
            else return Directions.Right;
        }else{
            System.out.println("no choice");
            MDog dog=new MDog(thispos);
            return dog.strategies.get(new Random().nextInt(dog.strategies.size())).nextDir(game, thispos);
        }
        
        //return Directions.Still;
    }
}
