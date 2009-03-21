/*
 * deadend.ai.dog.neuralnetwork.wekaANNLayerTest
 * Copyright (C) Yang JiaJian 2009 <yangjeep@gmail.com>
 * deadend.ai.dog.neuralnetwork.wekaANNLayerTest is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.dog.neuralnetwork.wekaANNLayerTest is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package deadend.ai.dog.neuralnetwork;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yang JiaJian
 */
public class wekaANNLayerTest {

    public wekaANNLayerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of Initialize method, of class wekaANNLayer.
     */
    @Test
    public void testInitialize() {
        System.out.println("Initialize");
        int NumNodes = 0;
        wekaANNLayer parent = new wekaANNLayer();
        wekaANNLayer child = new wekaANNLayer();
        wekaANNLayer instance = new wekaANNLayer();
        instance.Initialize(NumNodes, parent, child);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CleanUp method, of class wekaANNLayer.
     */
    @Test
    public void testCleanUp() {
        System.out.println("CleanUp");
        wekaANNLayer instance = new wekaANNLayer();
        instance.CleanUp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RandomizeWeights method, of class wekaANNLayer.
     */
    @Test
    public void testRandomizeWeights() {
        System.out.println("RandomizeWeights");
        wekaANNLayer instance = new wekaANNLayer();
        instance.RandomizeWeights();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CalculateErrors method, of class wekaANNLayer.
     */
    @Test
    public void testCalculateErrors() {
        System.out.println("CalculateErrors");
        wekaANNLayer instance = new wekaANNLayer();
        instance.CalculateErrors();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AdjustWeights method, of class wekaANNLayer.
     */
    @Test
    public void testAdjustWeights() {
        System.out.println("AdjustWeights");
        wekaANNLayer instance = new wekaANNLayer();
        instance.AdjustWeights();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CalculateNeuralValues method, of class wekaANNLayer.
     */
    @Test
    public void testCalculateNeuralValues() {
        System.out.println("CalculateNeuralValues");
        wekaANNLayer instance = new wekaANNLayer();
        
        instance.CalculateNeuralValues();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of LoadWeights method, of class wekaANNLayer.
     */
    @Test
    public void testLoadWeightsHidden() {
        System.out.println("LoadWeights on hidden layer");
        String tableName = "HiddenLayerNodes";
        wekaANNLayer instance = new wekaANNLayer();
        try{
            instance.NumberOfChildNodes=4;
            instance.NumberOfNodes=6;
            instance.NumberOfParentNodes=9;
            instance.Weights=new double[instance.NumberOfNodes][];
            for(int i=0;i<instance.NumberOfNodes;i++){
                instance.Weights[i]=new double[instance.NumberOfParentNodes];
            }
            String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" +
                          "DBQ=E:\\My Java Projects\\sseProj\\dev\\DeadEndGoogleSVN\\DeadEndGoogleSVN\\" +
                          "db\\ann\\090229data.mdb";
            instance.LoadWeights(strurl,tableName);
        }
        catch(Exception e){

            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

        /**
     * Test of LoadWeights method, of class wekaANNLayer.
     */
    @Test
    public void testLoadWeightsOut() {
        System.out.println("LoadWeights on output layer");
        String tableName = "OutputLayerNodes";
        wekaANNLayer instance = new wekaANNLayer();
        try{
            instance.NumberOfChildNodes=0;
            instance.NumberOfNodes=4;
            instance.NumberOfParentNodes=6;
            instance.Weights=new double[instance.NumberOfNodes][];
            for(int i=0;i<instance.NumberOfNodes;i++){
                instance.Weights[i]=new double[instance.NumberOfParentNodes];
            }
            String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" +
                          "DBQ=E:\\My Java Projects\\sseProj\\dev\\DeadEndGoogleSVN\\DeadEndGoogleSVN\\" +
                          "db\\ann\\090229data.mdb";
            instance.LoadWeights(strurl,tableName);
        }
        catch(Exception e){

            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of LoadBias method, of class wekaANNLayer.
     */
    @Test
    public void testLoadBiasOut() {
        System.out.println("LoadBias on output layer");
        String tableName = "OutputLayerBias";
        wekaANNLayer instance = new wekaANNLayer();
        try{
            instance.NumberOfChildNodes=0;
            instance.NumberOfNodes=4;
            instance.NumberOfParentNodes=6;
            instance.BiasValues=new double[instance.NumberOfNodes];
            String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" +
                          "DBQ=E:\\My Java Projects\\sseProj\\dev\\DeadEndGoogleSVN\\DeadEndGoogleSVN\\" +
                          "db\\ann\\090229data.mdb";
            instance.LoadBias(strurl,tableName);
        }catch(Exception e){
            fail("The test case is a prototype.");
        }
    }
    /**
     * Test of LoadBias method, of class wekaANNLayer.
     */
    @Test
    public void testLoadBiasHidden() {
        System.out.println("LoadBias on hidden layer");
        String tableName = "HiddenLayerBias";
        wekaANNLayer instance = new wekaANNLayer();
        try{
            instance.NumberOfChildNodes=4;
            instance.NumberOfNodes=6;
            instance.NumberOfParentNodes=9;
            instance.BiasValues=new double[instance.NumberOfNodes];
            String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" +
                          "DBQ=E:\\My Java Projects\\sseProj\\dev\\DeadEndGoogleSVN\\DeadEndGoogleSVN\\" +
                          "db\\ann\\090229data.mdb";
            instance.LoadBias(strurl,tableName);
        }catch(Exception e){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of LoadWeights method, of class wekaANNLayer.
     */
    @Test
    public void testLoadWeightsHiddenDogs() {
        System.out.println("LoadWeights on hidden layer");
        String tableName = "HiddenLayerNodes";
        wekaANNLayer instance = new wekaANNLayer();
        try{
            instance.NumberOfChildNodes=4;
            instance.NumberOfNodes=6;
            instance.NumberOfParentNodes=9;
            instance.Weights=new double[instance.NumberOfNodes][];
            for(int i=0;i<instance.NumberOfNodes;i++){
                instance.Weights[i]=new double[instance.NumberOfParentNodes];
            }
            for(int i=1;i<=2;i++){
                String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" +
                          "DBQ=E:\\My Java Projects\\sseProj\\dev\\DeadEndGoogleSVN\\DeadEndGoogleSVN\\" +
                          "db\\ann\\090229dog"+i+".mdb";
                instance.LoadWeights(strurl,tableName);
            }

        }
        catch(Exception e){

            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

        /**
     * Test of LoadWeights method, of class wekaANNLayer.
     */
    @Test
    public void testLoadWeightsOutDogs() {
        System.out.println("LoadWeights on output layer");
        String tableName = "OutputLayerNodes";
        wekaANNLayer instance = new wekaANNLayer();
        try{
            instance.NumberOfChildNodes=0;
            instance.NumberOfNodes=4;
            instance.NumberOfParentNodes=6;
            instance.Weights=new double[instance.NumberOfNodes][];
            for(int i=0;i<instance.NumberOfNodes;i++){
                instance.Weights[i]=new double[instance.NumberOfParentNodes];
            }
            for(int i=1;i<=2;i++){
                String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" +
                          "DBQ=E:\\My Java Projects\\sseProj\\dev\\DeadEndGoogleSVN\\DeadEndGoogleSVN\\" +
                          "db\\ann\\090229dog"+i+".mdb";
                instance.LoadWeights(strurl,tableName);
            }
        }
        catch(Exception e){

            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of LoadBias method, of class wekaANNLayer.
     */
    @Test
    public void testLoadBiasOutDogs() {
        System.out.println("LoadBias on output layer");
        String tableName = "OutputLayerBias";
        wekaANNLayer instance = new wekaANNLayer();
        try{
            instance.NumberOfChildNodes=0;
            instance.NumberOfNodes=4;
            instance.NumberOfParentNodes=6;
            instance.BiasValues=new double[instance.NumberOfNodes];
            for(int i=1;i<=2;i++){
                String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" +
                          "DBQ=E:\\My Java Projects\\sseProj\\dev\\DeadEndGoogleSVN\\DeadEndGoogleSVN\\" +
                          "db\\ann\\090229dog"+i+".mdb";
                instance.LoadBias(strurl,tableName);
            }
        }catch(Exception e){
            fail("The test case is a prototype.");
        }
    }
    /**
     * Test of LoadBias method, of class wekaANNLayer.
     */
    @Test
    public void testLoadBiasHiddenDogs() {
        System.out.println("LoadBias on hidden layer");
        String tableName = "HiddenLayerBias";
        wekaANNLayer instance = new wekaANNLayer();
        try{
            instance.NumberOfChildNodes=4;
            instance.NumberOfNodes=6;
            instance.NumberOfParentNodes=9;
            instance.BiasValues=new double[instance.NumberOfNodes];
            for(int i=1;i<=2;i++){
                String strurl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" +
                          "DBQ=E:\\My Java Projects\\sseProj\\dev\\DeadEndGoogleSVN\\DeadEndGoogleSVN\\" +
                          "db\\ann\\090229dog"+i+".mdb";
                instance.LoadBias(strurl,tableName);
            }
        }catch(Exception e){
            fail("The test case is a prototype.");
        }
    }
}