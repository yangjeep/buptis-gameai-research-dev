/*
 * deadend.gui.DeadEndControlPanel
 * Copyright (C) Yang JiaJian 2009 <Yang JiaJian>
 * deadend.gui.DeadEndControlPanel is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * deadend.gui.DeadEndControlPanel is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * DeadEndControlPanel.java
 *
 * Created on 2009-3-1, 19:52:45
 */

package deadend.gui;

import deadend.game.*;
/**
 *
 * @author Yang JiaJian
 */
public class DeadEndControlPanel extends javax.swing.JPanel {
DeadEndGamePanel gamePanel;
    public DeadEndControlPanel() {
        initComponents();
    }
    /**
     * Creates new form DeadEndControlPanel
     * @param game the game
     */
    public DeadEndControlPanel(DeadEndGame game,DeadEndGamePanel gamePanel) {
        initComponents();
        this.game=game;
        this.gamePanel=gamePanel;
        this.setDogStrategy();
    }

    /**
     * Initilize the game
     * @param game the game
     */
    public void initGame(DeadEndGame game,DeadEndGamePanel gamePanel){
        this.game=game;
        this.gamePanel=gamePanel;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        StartButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        autoRunButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        resumeButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        PulseButton = new javax.swing.JButton();
        autoRunStop = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setMinimumSize(new java.awt.Dimension(420, 120));
        setPreferredSize(new java.awt.Dimension(420, 120));

        StartButton.setText("Start");
        StartButton.addActionListener(formListener);

        jTextField1.setText("50");
        jTextField1.addActionListener(formListener);

        jLabel1.setText("AutoRun");

        autoRunButton.setText("AutoRun");
        autoRunButton.addActionListener(formListener);

        resetButton.setText("Reset");
        resetButton.addActionListener(formListener);

        resumeButton.setText("Resume");
        resumeButton.setEnabled(false);
        resumeButton.addActionListener(formListener);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ZigZag", "BasicFSM", "CounterStrike" }));
        jComboBox1.addItemListener(formListener);

        jLabel2.setText("Cat");

        jLabel3.setText("Dog");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MonteCarloAdvSingle", "MonteCarloAdv" }));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MonteCarloAdv", "AdvANN-Basic-Win", "AdvANN-ZigZag-Win", "AdvANN-CS-Win", "MonteCarloState", "MonteCarlo", "AdvANN-Basic", "AdvANN-ZigZag", "AdvANN-CS", "ANN-Basic-Win", "ANN-ZigZag-Win", "ANN-CS-Win", "ANN-Basic", "ANN-ZigZag", "ANN-CS" }));
        jComboBox2.addItemListener(formListener);

        PulseButton.setText("Pulse");
        PulseButton.setEnabled(false);
        PulseButton.addActionListener(formListener);

        autoRunStop.setText("StopAuto");
        autoRunStop.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, 203, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoRunButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoRunStop)
                        .addGap(12, 12, 12)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, 0, 138, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PulseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                            .addComponent(resumeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(autoRunButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(autoRunStop))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(StartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PulseButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resetButton)
                            .addComponent(resumeButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1)
                    .addComponent(jComboBox2)
                    .addComponent(jLabel3))
                .addGap(49, 49, 49))
        );
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.ItemListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == StartButton) {
                DeadEndControlPanel.this.StartButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jTextField1) {
                DeadEndControlPanel.this.jTextField1ActionPerformed(evt);
            }
            else if (evt.getSource() == autoRunButton) {
                DeadEndControlPanel.this.autoRunButtonActionPerformed(evt);
            }
            else if (evt.getSource() == resetButton) {
                DeadEndControlPanel.this.resetButtonActionPerformed(evt);
            }
            else if (evt.getSource() == resumeButton) {
                DeadEndControlPanel.this.resumeButtonActionPerformed(evt);
            }
            else if (evt.getSource() == PulseButton) {
                DeadEndControlPanel.this.PulseButtonActionPerformed(evt);
            }
        }

        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            if (evt.getSource() == jComboBox1) {
                DeadEndControlPanel.this.jComboBox1ItemStateChanged(evt);
            }
            else if (evt.getSource() == jComboBox2) {
                DeadEndControlPanel.this.jComboBox2ItemStateChanged(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void resumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeButtonActionPerformed
        // add your handling code here:
        this.game.ResumeGame();
    }//GEN-LAST:event_resumeButtonActionPerformed

    private void autoRunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoRunButtonActionPerformed
        // add your handling code here:
        if(!this.game.isAutoRun){
            String ms=this.jTextField1.getText();
        int times=50;
        try{
            times=Integer.parseInt(ms);
        }catch(Exception e){
            System.err.println(e.toString());
        }
        this.game.initAutoRun(times);
        this.game.autoRun(this.gamePanel);
        }
        
}//GEN-LAST:event_autoRunButtonActionPerformed

    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButtonActionPerformed
        // Start a game
        this.game.StartAGame();
    }//GEN-LAST:event_StartButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // reset game
        this.game.reset();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // change the autorun times
        String ms=this.jTextField1.getText();
        int times=50;
        try{
            times=Integer.parseInt(ms);
        }catch(Exception e){
            System.err.println(e.toString());
        }
        this.game.initAutoRun(times);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void PulseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PulseButtonActionPerformed
        // pause the game
        this.game.PulseGame();
    }//GEN-LAST:event_PulseButtonActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // Change the strategy
        String str=this.jComboBox1.getSelectedItem().toString();
        if(str.equalsIgnoreCase("ZigZag")){
            this.game.player.setStrategy(new deadend.ai.cat.CatZigzagFSM());
        }
        if(str.equalsIgnoreCase("BasicFSM")){
            this.game.player.setStrategy(new deadend.ai.cat.CatBasicFSM());
        }
        if(str.equalsIgnoreCase("CounterStrike")){
            this.game.player.setStrategy(new deadend.ai.cat.CatAppealFSM());
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        String str=this.jComboBox2.getSelectedItem().toString();

        if(str.equalsIgnoreCase("MonteCarloAdvSingle")){
            this.game.dogs.setStrategy(new deadend.ai.dog.MCAdvSingleBrain(game,
                    deadend.game.GameConfigClass.ComputingTimeLimit));
        }

        if(str.equalsIgnoreCase("MonteCarlo")){
            this.game.dogs.setStrategy(new deadend.ai.dog.DogTeamBrain(game,
                    deadend.game.GameConfigClass.ComputingTimeLimit));
        }

        if(str.equalsIgnoreCase("MonteCarloAdv")){
            this.game.dogs.setStrategy(new deadend.ai.dog.MCAdvBrain(game,
                    deadend.game.GameConfigClass.ComputingTimeLimit));
        
        if(str.equalsIgnoreCase("MonteCarloAdv")){
            this.game.dogs.setStrategy(new deadend.ai.dog.MCTeamBrain(game,
                    deadend.game.GameConfigClass.ComputingTimeLimit));
        }

        if(str.equalsIgnoreCase("MonteCarloState")){
            this.game.dogs.setStrategy(new deadend.ai.dog.MCStateBrain(game,
                    deadend.game.GameConfigClass.ComputingTimeLimit));
        }

        if(str.equalsIgnoreCase("ANN-Basic")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,1,false));
        }
        if(str.equalsIgnoreCase("ANN-ZigZag")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,2,false));
        }
        if(str.equalsIgnoreCase("ANN-CS")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,3,false));
        }
        if(str.equalsIgnoreCase("ANN-Basic-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,1,true));
        }
        if(str.equalsIgnoreCase("ANN-ZigZag-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,2,true));
        }
        if(str.equalsIgnoreCase("ANN-CS-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,3,true));
        }

        if(str.equalsIgnoreCase("AdvANN-Basic")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,1,false));
        }
        if(str.equalsIgnoreCase("AdvANN-ZigZag")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,2,false));
        }
        if(str.equalsIgnoreCase("AdvANN-CS")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,3,false));
        }
        if(str.equalsIgnoreCase("AdvANN-Basic-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,1,true));
        }
        if(str.equalsIgnoreCase("AdvANN-ZigZag-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,2,true));
        }
        if(str.equalsIgnoreCase("AdvANN-CS-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,3,true));
        }

        if(str.equalsIgnoreCase("MonteCarloState")){
            this.game.dogs.setStrategy(new deadend.ai.dog.MCStateTeamBrain(game,
                    deadend.game.GameConfigClass.ComputingTimeLimit));
        }

        if(str.equalsIgnoreCase("ANN-Basic")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,1,false));
        }
        if(str.equalsIgnoreCase("ANN-ZigZag")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,2,false));
        }
        if(str.equalsIgnoreCase("ANN-CS")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,3,false));
        }
        if(str.equalsIgnoreCase("ANN-Basic-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,1,true));
        }
        if(str.equalsIgnoreCase("ANN-ZigZag-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,2,true));
        }
        if(str.equalsIgnoreCase("ANN-CS-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,3,true));
        }

        if(str.equalsIgnoreCase("AdvANN-Basic")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,1,false));
        }
        if(str.equalsIgnoreCase("AdvANN-ZigZag")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,2,false));
        }
        if(str.equalsIgnoreCase("AdvANN-CS")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,3,false));
        }
        if(str.equalsIgnoreCase("AdvANN-Basic-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,1,true));
        }
        if(str.equalsIgnoreCase("AdvANN-ZigZag-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,2,true));
        }
        if(str.equalsIgnoreCase("AdvANN-CS-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,3,true));
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PulseButton;
    private javax.swing.JButton StartButton;
    private javax.swing.JButton autoRunButton;
    private javax.swing.JButton autoRunStop;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton resumeButton;
    // End of variables declaration//GEN-END:variables

    private DeadEndGame game;

    public void update(){
        this.jProgressBar1.setValue(game.step/game.LimitStep);
        if(this.game.isGameEnd){
            this.StartButton.setEnabled(true);
            this.PulseButton.setEnabled(false);
        }
        else{
            this.StartButton.setEnabled(false);
            this.PulseButton.setEnabled(true);
        }
        
        if(this.game.isPaused){
            this.PulseButton.setEnabled(false);
            this.resumeButton.setEnabled(true);
        }else{
            this.PulseButton.setEnabled(true);
            this.resumeButton.setEnabled(false);
        }

        if(this.game.isAutoRun){
            this.StartButton.setEnabled(false);
            this.PulseButton.setEnabled(false);
            this.resumeButton.setEnabled(false);
            this.resetButton.setEnabled(false);
            this.autoRunButton.setEnabled(false);
            this.autoRunStop.setEnabled(true);
        }
        if(!this.game.isAutoRun){
            this.autoRunButton.setEnabled(true);
            this.autoRunStop.setEnabled(false);
        }
    }
    @Override
    public void paintComponent(java.awt.Graphics g){
        this.repaint();
    }

    public void setDogStrategy(){
        String str=this.jComboBox2.getSelectedItem().toString();
        if(str.equalsIgnoreCase("MonteCarlo")){
            this.game.dogs.setStrategy(new deadend.ai.dog.DogTeamBrain(game,
                    deadend.game.GameConfigClass.ComputingTimeLimit));
        }

        if(str.equalsIgnoreCase("MonteCarloAdv")){
            this.game.dogs.setStrategy(new deadend.ai.dog.MCAdvBrain(game,
                    deadend.game.GameConfigClass.ComputingTimeLimit));
        }

        if(str.equalsIgnoreCase("MonteCarloState")){
            this.game.dogs.setStrategy(new deadend.ai.dog.MCStateBrain(game,
                    deadend.game.GameConfigClass.ComputingTimeLimit));
        }

        if(str.equalsIgnoreCase("ANN-Basic")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,1,false));
        }
        if(str.equalsIgnoreCase("ANN-ZigZag")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,2,false));
        }
        if(str.equalsIgnoreCase("ANN-CS")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,3,false));
        }
        if(str.equalsIgnoreCase("ANN-Basic-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,1,true));
        }
        if(str.equalsIgnoreCase("ANN-ZigZag-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,2,true));
        }
        if(str.equalsIgnoreCase("ANN-CS-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrain(game,3,true));
        }

        if(str.equalsIgnoreCase("AdvANN-Basic")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,1,false));
        }
        if(str.equalsIgnoreCase("AdvANN-ZigZag")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,2,false));
        }
        if(str.equalsIgnoreCase("AdvANN-CS")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,3,false));
        }
        if(str.equalsIgnoreCase("AdvANN-Basic-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,1,true));
        }
        if(str.equalsIgnoreCase("AdvANN-ZigZag-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,2,true));
        }
        if(str.equalsIgnoreCase("AdvANN-CS-Win")){
            this.game.dogs.setStrategy(new deadend.ai.dog.NeuralBrainAdv(game,3,true));
        }
    }
    public void setCatStrategy(){
        String str=this.jComboBox1.getSelectedItem().toString();
        if(str.equalsIgnoreCase("ZigZag")){
            this.game.player.setStrategy(new deadend.ai.cat.CatZigzagFSM());
        }
        if(str.equalsIgnoreCase("BasicFSM")){
            this.game.player.setStrategy(new deadend.ai.cat.CatBasicFSM());
        }
        if(str.equalsIgnoreCase("CounterStrike")){
            this.game.player.setStrategy(new deadend.ai.cat.CatAppealFSM());
        }
    }
}
}
