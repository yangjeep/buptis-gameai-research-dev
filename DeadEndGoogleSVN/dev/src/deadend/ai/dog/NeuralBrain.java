/*
 * deadend.ai.dog.NeuralBrain
 * Copyright (C) Yang JiaJian 2009 <yangjeep@gmail.com>
 * deadend.ai.dog.NeuralBrain is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.dog.NeuralBrain is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.ai.dog;

import java.util.ArrayList;

import deadend.game.DeadEndGame;
import deadend.ai.dog.neuralnetwork.*;
import universalUtil.neuralnetwork.*;

/**
 *
 * @author Yang JiaJian
 */
public class NeuralBrain extends TeamBrainFound{

    NeuralNetwork TheBrain;

    private DeadEndGame game;

    public NeuralBrain(DeadEndGame game){
        this.game=game;

        
    }
    @Override
    public void compute(){
        
    }
    @Override
    public String getName(){
        return "ANN";
    }
}
