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
        wekaANNLayer parent = null;
        wekaANNLayer child = null;
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
    public void testLoadWeights() {
        System.out.println("LoadWeights");
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
            instance.LoadWeights(tableName);
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
    public void testLoadBias() {
        System.out.println("LoadBias");
        String tableName = "";
        wekaANNLayer instance = new wekaANNLayer();
        instance.LoadBias(tableName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Initialize method, of class wekaANNLayer.
     */
    @Test
    public void testInitialize_3args() {
        System.out.println("Initialize");
        int NumNodes = 0;
        wekaANNLayer parent = null;
        wekaANNLayer child = null;
        wekaANNLayer instance = new wekaANNLayer();
        instance.Initialize(NumNodes, parent, child);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CleanUp method, of class wekaANNLayer.
     */
    @Test
    public void testCleanUp1() {
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
    public void testRandomizeWeights1() {
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
    public void testCalculateErrors1() {
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
    public void testAdjustWeights1() {
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
    public void testCalculateNeuralValues1() {
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
    public void testLoadWeights_String() {
        System.out.println("LoadWeights");
        String tableName = "";
        wekaANNLayer instance = new wekaANNLayer();
        instance.LoadWeights(tableName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of LoadBias method, of class wekaANNLayer.
     */
    @Test
    public void testLoadBias_String() {
        System.out.println("LoadBias");
        String tableName = "";
        wekaANNLayer instance = new wekaANNLayer();
        instance.LoadBias(tableName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}