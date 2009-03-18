/*
 * universalUtil.neuralnetwork.NeuralNetworkLayerTest
 * Copyright (C) Yang JiaJian 2009 <yangjeep@gmail.com>
 * universalUtil.neuralnetwork.NeuralNetworkLayerTest is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * universalUtil.neuralnetwork.NeuralNetworkLayerTest is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package universalUtil.neuralnetwork;

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
public class NeuralNetworkLayerTest {

    public NeuralNetworkLayerTest() {
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
     * Test of Initialize method, of class NeuralNetworkLayer.
     */
    @Test
    public void testInitialize() {
        System.out.println("Initialize");
        int NumNodes = 0;
        NeuralNetworkLayer parent = null;
        NeuralNetworkLayer child = null;
        NeuralNetworkLayer instance = new NeuralNetworkLayer();
        instance.Initialize(NumNodes, parent, child);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CleanUp method, of class NeuralNetworkLayer.
     */
    @Test
    public void testCleanUp() {
        System.out.println("CleanUp");
        NeuralNetworkLayer instance = new NeuralNetworkLayer();
        instance.CleanUp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RandomizeWeights method, of class NeuralNetworkLayer.
     */
    @Test
    public void testRandomizeWeights() {
        System.out.println("RandomizeWeights");
        NeuralNetworkLayer instance = new NeuralNetworkLayer();
        instance.RandomizeWeights();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CalculateErrors method, of class NeuralNetworkLayer.
     */
    @Test
    public void testCalculateErrors() {
        System.out.println("CalculateErrors");
        NeuralNetworkLayer instance = new NeuralNetworkLayer();
        instance.CalculateErrors();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AdjustWeights method, of class NeuralNetworkLayer.
     */
    @Test
    public void testAdjustWeights() {
        System.out.println("AdjustWeights");
        NeuralNetworkLayer instance = new NeuralNetworkLayer();
        instance.AdjustWeights();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CalculateNeuralValues method, of class NeuralNetworkLayer.
     */
    @Test
    public void testCalculateNeuralValues() {
        System.out.println("CalculateNeuralValues");
        NeuralNetworkLayer instance = new NeuralNetworkLayer();
        instance.CalculateNeuralValues();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}