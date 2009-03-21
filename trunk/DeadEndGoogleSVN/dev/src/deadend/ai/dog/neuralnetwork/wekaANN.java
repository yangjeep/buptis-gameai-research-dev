/*
 * universalUtil.neuralnetwork.wekaANN
 * Copyright (C) Yang JiaJian 2009 <yangjeep@gmail.com>
 * universalUtil.neuralnetwork.wekaANN is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * universalUtil.neuralnetwork.wekaANN is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.ai.dog.neuralnetwork;

/**
 * This class represents the BP neural network
 * There are 3 neural network layer entities: input layer, hidden layer, and output layer
 *
 * @author Yang JiaJian
 */
public class wekaANN {

    /**
     * The input layer of the network
     */
    public wekaANNLayer InputLayer;
    /**
     * The hidden layer of the network
     */
    public wekaANNLayer HiddenLayer;
    /**
     * The output layer of the network
     */
    public wekaANNLayer OutputLayer;

    /**
     * There are three parameters in the initialize function to build a
     * BP-network with 3 layers
     *
     * @param nNodesInput number of input nodes
     * @param nNodesHidden number of hidden nodes
     * @param nNodesOutput number of output nodes
     */
    public void initialize(int nNodesInput,int nNodesHidden,int nNodesOutput){
        // There is sth wrong in the book is the constructor of the layers
        this.InputLayer=new wekaANNLayer();
        this.HiddenLayer=new wekaANNLayer();
        this.OutputLayer=new wekaANNLayer();

        // Input layer
        this.InputLayer.NumberOfNodes=nNodesInput;
        this.InputLayer.NumberOfChildNodes=nNodesHidden;
        this.InputLayer.NumberOfParentNodes=0;
        this.InputLayer.Initialize(nNodesInput, null, this.HiddenLayer);
        //this.InputLayer.RandomizeWeights();

        // Hidden Layer
        this.HiddenLayer.NumberOfNodes=nNodesHidden;
        this.HiddenLayer.NumberOfChildNodes=nNodesOutput;
        this.HiddenLayer.NumberOfParentNodes=nNodesInput;
        this.HiddenLayer.Initialize(nNodesHidden, InputLayer, OutputLayer);
        //this.HiddenLayer.RandomizeWeights();

        // Output Layer
        this.OutputLayer.NumberOfNodes=nNodesOutput;
        this.OutputLayer.NumberOfChildNodes=0;
        this.OutputLayer.NumberOfParentNodes=nNodesHidden;
        this.OutputLayer.Initialize(nNodesOutput, this.HiddenLayer, null);
        //this.OutputLayer.RandomizeWeights();
    }

    /**
     * Call all the layer's clean up
     */
    public void cleanUp(){
        this.InputLayer.CleanUp();
        this.HiddenLayer.CleanUp();
        this.OutputLayer.CleanUp();
    }


    /**
     * Set the value of the input layer
     * Used in executive
     *
     * @param i Number of the input node
     * @param value the input value
     */
    public void setInput(int i,double value){
        if((i>=0) && (i<this.InputLayer.NumberOfNodes)){
            this.InputLayer.NeuronValues[i]=value;
            return;
        }
        System.err.println("Error in setting input");
        return;
    }

    /**
     * Get the output of the network
     *
     * @param i get the output value by ID
     * @return return the output value of the network output
     */
    public double getOutput(int i){
        if((i>=0) && (i<this.InputLayer.NumberOfNodes)){
            return this.OutputLayer.NeuronValues[i];
        }
        System.err.println("Error in retrieving value");
        return 0;
    }

    /**
     * Set up the desired output value
     * @param i index of the output
     * @param value the desired output vlaue
     */
    public void setDesiredOutput(int i,double value){
        if((i>=0) && (i<this.InputLayer.NumberOfNodes)){
            this.OutputLayer.DesiredValues[i]=value;
            return;
        }
        System.err.println("Error in setting Desired Output");
        return;
    }

    /**
     * Generate the output of the network
     */
    public void feedForward(){
        this.InputLayer.CalculateNeuralValues();
        this.HiddenLayer.CalculateNeuralValues();
        this.OutputLayer.CalculateNeuralValues();
    }

    /**
     * Use BP to adjust the value of the network
     */
    public void backPropagate(){
        this.OutputLayer.CalculateErrors();
        this.HiddenLayer.CalculateErrors();
        this.HiddenLayer.AdjustWeights();
        this.InputLayer.AdjustWeights();
    }

    /**
     * Find out the best value
     * @return the ID of the best output
     */
    public int getMAxOutPutID(){
        int i,id;
        double maxval;

        maxval=this.OutputLayer.NeuronValues[0];
        id=0;

        for(i=1;i<this.OutputLayer.NumberOfNodes;i++){
            if(this.OutputLayer.NeuronValues[i]>maxval){
                maxval=this.OutputLayer.NeuronValues[i];
                id=i;
            }
        }
        return id;
    }

    /**
     * Compute the erros
     * @return the error
     */
    public double calculateError(){
        int i;
        double error=0;

        for(i=0;i<this.OutputLayer.NumberOfNodes;i++){
            error+=Math.pow(this.OutputLayer.NeuronValues[i]-this.OutputLayer.DesiredValues[i], 2);
        }
        error=error/this.OutputLayer.NumberOfNodes;
        return error;
    }

    /**
     * Set the learning rate uniformly
     * @param rate the desired learning rate
     */
    public void setLearningRate(double rate){
        this.InputLayer.LearningRate=rate;
        this.HiddenLayer.LearningRate=rate;
        this.OutputLayer.LearningRate=rate;
    }

    /**
     * Set universally if the activation funciton is linear
     * @param useLinear true if use linear, false if use logistic
     */
    public void setLinearOutput(boolean useLinear){
        this.InputLayer.LinearOutput=useLinear;
        this.HiddenLayer.LinearOutput=useLinear;
        this.OutputLayer.LinearOutput=useLinear;
    }

    /**
     * Set the momenmum univesally
     *
     * @param useMomentum true if use the method of momentum
     * @param factor the value of momentum
     */
    public void setMomentum(boolean useMomentum,double factor){

        this.InputLayer.UseMomentum=useMomentum;
        this.HiddenLayer.UseMomentum=useMomentum;
        this.OutputLayer.UseMomentum=useMomentum;

        this.InputLayer.MomentumFactor=factor;
        this.HiddenLayer.MomentumFactor=factor;
        this.OutputLayer.MomentumFactor=factor;
    }

    /**
     * Choose the data source weights/bias
     * @param dbname mdb file name
     */
    public void LoadData(String dbname){
        this.InputLayer.LoadWeights(dbname, "HiddenLayerNodes");
        this.InputLayer.LoadBias(dbname, "HiddenLayerBias");
        this.HiddenLayer.LoadWeights(dbname, "OutputLayerNodes");
        this.HiddenLayer.LoadBias(dbname, "OutputLayerBias");
    }

    /**
     * Write the data into a file
     * @TODO to be implement
     */
    public void dumpData(){
        // @TODO TBD
    }
}
