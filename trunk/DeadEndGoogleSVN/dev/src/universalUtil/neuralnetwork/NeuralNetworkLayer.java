/*
 * universalUtil.neuralnetwork.NeuralNetworkLayer
 * Copyright (C) Yang JiaJian 2009 <yangjeep@gmail.com>
 * universalUtil.neuralnetwork.NeuralNetworkLayer is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * universalUtil.neuralnetwork.NeuralNetworkLayer is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package universalUtil.neuralnetwork;

/**
 * The class NeuralNetworkLayer implements the universal layer functions used in 
 * Multi-layer Foward feedback neural network
 * Its responsibility is to process the neural nodes in the same layer
 *
 * @author Yang JiaJian
 * @see AI for Game Developers Chapter 14
 */
public class NeuralNetworkLayer {
    /**
     * Stores the number of nodes in the entity layer
     */
    public int NumberOfNodes;
    /**
     * The number of nodes of the next layer
     */
    public int NumberOfChildNodes;
    /**
     * The number of nodes of the upper layer
     */
    public int NumberOfParentNodes;
    /**
     * The 2-dimesional weights connecting the upper and lower layer
     */
    public double[][] Weights;
    /**
     * The correction unit to adjust the weights dynamically
     */
    public double[][] WeightChanges;
    /**
     * The activation value of the nodes
     */
    public double[] NeuronValues;
    /**
     * The target value to calculate the error
     */
    public double[] DesiredValues;
    /**
     * Stores the erros related to the nodes
     */
    public double[] Errors;
    /**
     * Stores the bias weights of the nodes
     */
    public double[] BiasWeights;
    /**
     * Stores the bias values of each nodes
     */
    public double[] BiasValues;
    /**
     * Used to calculate the correction of weights
     */
    public double LearningRate;

    /**
     * True if the nodes uses linear activation function
     * False if the nodes uses Logistic activation function
     * The default value is false
     */
    public boolean LinearOutput;
    /**
     * Indicates wether to use momentum when adjusting weights
     * Default value is false
     */
    public boolean UseMomentum;
    /**
     * If the UseMomentum is true the momentum factor will be used to
     * Store momentum value
     */
    public double MomentumFactor;

    NeuralNetworkLayer ParentLayer;
    NeuralNetworkLayer ChildLayer;

    /**
     * The constructor of the universal layer
     */
    public NeuralNetworkLayer() {
        /**
         * @See page 286
         */
        this.ParentLayer=null;
        this.ChildLayer=null;
        this.LinearOutput=false;
        this.UseMomentum=false;
        this.MomentumFactor=0.9;
    }

    /**
     * Do the initialization work mainly
     *
     * @param NumNodes number of nodes
     * @param parent refernece of parent layer
     * @param child reference of child layer
     * @see book page 286
     */
    public void Initialize(int NumNodes,
            NeuralNetworkLayer parent,NeuralNetworkLayer child){

        this.NeuronValues=new double[this.NumberOfNodes];
        this.DesiredValues=new double[this.NumberOfNodes];
        this.Errors=new double[this.NumberOfNodes];

        if(parent!=null){
            this.ParentLayer=parent;
        }

        if(child!=null){
            this.ChildLayer=child;

            this.Weights=new double[this.NumberOfNodes][];
            this.WeightChanges=new double[this.NumberOfNodes][];

            for(int i=0;i<this.NumberOfNodes;i++){
                this.Weights[i]=new double[this.NumberOfChildNodes];
                this.WeightChanges[i]=new double[this.NumberOfChildNodes];
            }

            this.BiasValues=new double[this.NumberOfChildNodes];
            this.BiasWeights=new double[this.NumberOfChildNodes];
        }else{
            this.Weights=null;
            this.WeightChanges=null;
            this.BiasValues=null;
            this.BiasWeights=null;
        }

        for(int i=0;i<this.NumberOfNodes;i++){
            this.NeuronValues[i]=0;
            this.DesiredValues[i]=0;
            this.Errors[i]=0;

            if(this.ChildLayer!=null){
                for(int j=0;j<this.NumberOfChildNodes;j++){
                    this.Weights[i][j]=0;
                    this.WeightChanges[i][j]=0;
                }
            }
        }

        if(this.ChildLayer!=null){
            for(int j=0;j<this.NumberOfChildNodes;j++){
                this.BiasValues[j]=0;
                this.BiasWeights[j]=0;
            }
        }
    }

    /**
     * Deal with the rubbish collection work
     */
    public void CleanUp(){
        int i;

        this.NeuronValues=null;
        this.DesiredValues=null;
        this.Errors=null;

        if(this.Weights!=null){
            for(i=0;i<this.NumberOfNodes;i++){
                this.Weights[i]=null;
                this.WeightChanges[i]=null;
            }
            this.Weights=null;
            this.WeightChanges=null;
        }

        if(this.BiasValues!=null)this.BiasValues=null;
        if(this.BiasWeights!=null)this.BiasWeights=null;

    }

    /**
     * Initialize the network to achieve some random value
     */
    public void RandomizeWeights(){
        int i,j;
        int min=0;
        int max=200;
        int number;

        for(i=0;i<this.NumberOfNodes;i++){
            for(j=0;j<this.NumberOfChildNodes;j++){
                number=(int)(Math.random()*(max-min+1)+min);
                if(number>max)number=max;
                if(number<min)number=min;

                this.Weights[i][j]=number/100.0f-1;
            }
        }
        for(j=0;j<this.NumberOfChildNodes;j++){
            number=(int)(Math.random()*(max-min+1)+min);

            if(number>max)number=max;
            if(number<min)number=min;

            this.BiasWeights[j]=number/100.0f-1;
        }
    }

    /**
     * Calculte the errors
     */
    public void CalculateErrors(){
        int i,j;
        double sum;

        if(this.ChildLayer==null)   // Output layer
        {
            for(i=0;i<this.NumberOfNodes;i++){
                this.Errors[i]=(this.DesiredValues[i]-this.NeuronValues[i])
                        *(this.NeuronValues[i])*(1.0f-this.NeuronValues[i]);
            }
        }else if(this.ParentLayer==null)    // Input Layer
        {
            for(i=0;i<this.NumberOfNodes;i++){
                this.Errors[i]=0.0f;
            }
        }
        else // Hidden Layer
        {
            for(i=0;i<this.NumberOfNodes;i++){
                sum=0;
                for(j=0;j<this.NumberOfChildNodes;j++){
                    sum+=this.ChildLayer.Errors[j]*this.Weights[i][j];
                }
                this.Errors[i]=sum*this.NeuronValues[i]*(1.0f-this.NeuronValues[i]);
            }
        }
    }

    /**
     * Calculate the correction of corresponding weights
     */
    public void AdjustWeights(){
       int i,j;
       double dw;

       if(this.ChildLayer!=null){
           for(i=0;i<this.NumberOfNodes;i++){
               for(j=0;j<this.NumberOfChildNodes;j++){
                   dw=this.LearningRate*this.ChildLayer.Errors[j]*this.NeuronValues[i];
                   if(this.UseMomentum){
                       this.Weights[i][j]+=dw+this.MomentumFactor*this.WeightChanges[i][j];
                       this.WeightChanges[i][j]=dw;
                   }else{
                       this.Weights[i][j]+=dw;
                   }
               }
           }
           for(j=0;j<this.NumberOfChildNodes;j++){
               this.BiasWeights[j]+=this.LearningRate*this.ChildLayer.Errors[j]*this.BiasValues[j];
           }
       }
       
    }

    /**
     * Calculate the activation values
     */
    public void CalculateNeuralValues(){
        int i,j;
        double x;

        if(this.ParentLayer!=null){
            for(j=0;j<this.NumberOfNodes;j++){
                x=0;
                for(i=0;i<this.NumberOfParentNodes;i++){
                    x+=this.ParentLayer.NeuronValues[i]*this.ParentLayer.Weights[i][j];
                }
                x+=this.ParentLayer.BiasValues[j]*this.ParentLayer.BiasWeights[j];

                if((this.ChildLayer==null) && this.LinearOutput){
                    this.NeuronValues[j]=x;
                }else{
                    this.NeuronValues[j]=1.0f/(1+Math.exp(-x));
                }

            }
        }
    }


}
