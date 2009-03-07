/*
 * deadend.gui.DeadEndGamePanel
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.gui.DeadEndGamePanel is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * deadend.gui.DeadEndGamePanel is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * DeadEndGamePanel.java
 *
 * Created on 2009-3-1, 18:47:21
 */

package deadend.gui;

import java.awt.*;
import javax.swing.*;

import deadend.game.*;
import deadend.roles.Dog;

/**
 *
 * @author Yang JiaJian
 */
public class DeadEndGamePanel extends javax.swing.JPanel {

    /** Creates new form DeadEndGamePanel */
    public DeadEndGamePanel() {
        initComponents();

        this.initGame();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(401, 401));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
    /**
     * The game core
     */
    public DeadEndGame game;
    /**
     * Construct the game entity
     */
    public void initGame(){
        this.game=new DeadEndGame();
        this.game.intialize();
    }

    @Override
    public void paint(Graphics g){

        /**
         * Draw the background
         */
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        /**
         * This block is to draw the grids (the board)
         */
        int numOfX,numOfY;
        numOfX=deadend.game.GameConfigClass.GridX;
        numOfY=deadend.game.GameConfigClass.GridY;

        int unitx,unity;
        unitx=this.getWidth()/numOfX;
        unity=this.getHeight()/numOfY;

        g.setColor(Color.lightGray);
        for(int i=0;i<=numOfX;i++){
            g.drawLine(i*unitx, 0, i*unitx, this.getHeight());
        }
        for(int i=0;i<=numOfX;i++){
            g.drawLine(0, i*unity, this.getWidth(), i*unity);
        }

        /**
         * Draw the door
         */
        g.setColor(Color.green);
        int x,y;
        for(Point d:this.game.door){
            g.fillRect(d.x*unitx, d.y*unity, unitx, unity);
        }
        
        this.drawCat(g);
        this.drawDogs(g);

        this.repaint();
    }

    /**
     * Draw Cat
     * @param g Graphics
     */
    public void drawCat(Graphics g){

        int numOfX,numOfY;
        numOfX=deadend.game.GameConfigClass.GridX;
        numOfY=deadend.game.GameConfigClass.GridY;

        int unitx,unity;
        unitx=this.getWidth()/numOfX;
        unity=this.getHeight()/numOfY;

        g.setColor(Color.cyan);

        int x,y;
        x=this.game.player.getPosition().x;
        y=this.game.player.getPosition().y;

        g.fillOval(x*unitx, y*unity, unitx, unity);
    }
    /**
     * Draw the dog
     * @param g Graphics
     */
    public void drawDogs(Graphics g){
        if(this.game.dogs.dogTeam.isEmpty()){return;}
        int numOfX,numOfY;
        numOfX=deadend.game.GameConfigClass.GridX;
        numOfY=deadend.game.GameConfigClass.GridY;

        int unitx,unity;
        unitx=this.getWidth()/numOfX;
        unity=this.getHeight()/numOfY;

        g.setColor(Color.orange);

        int x,y;
        for(Dog d:this.game.dogs.dogTeam){
            x=d.getPosition().x;
            y=d.getPosition().y;
            g.fillOval(x*unitx, y*unity, unitx, unity);
        }

    }
    /**
     * call Reset logic of the game
     */
    public void reset(){
        this.game.reset();
    }

    /**
     * autorun logic
     * @param num integer indicates the number of autorun
     */
    public void autoRun(int num){
    }
}
