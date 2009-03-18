/*
 * deadend.ai.dog.neuralnetwork.wekaANNTest
 * Copyright (C) Yang JiaJian 2009 <yangjeep@gmail.com>
 * deadend.ai.dog.neuralnetwork.wekaANNTest is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * deadend.ai.dog.neuralnetwork.wekaANNTest is distributed in the hope that it will be useful, but
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
public class wekaANNTest {

    public wekaANNTest() {
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
     * Test of initialize method, of class wekaANN.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        int nNodesInput = 0;
        int nNodesHidden = 0;
        int nNodesOutput = 0;
        wekaANN instance = new wekaANN();
        instance.initialize(nNodesInput, nNodesHidden, nNodesOutput);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cleanUp method, of class wekaANN.
     */
    @Test
    public void testCleanUp() {
        System.out.println("cleanUp");
        wekaANN instance = new wekaANN();
        instance.cleanUp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInput method, of class wekaANN.
     */
    @Test
    public void testSetInput() {
        System.out.println("setInput");
        int i = 0;
        double value = 0.0;
        wekaANN instance = new wekaANN();
        instance.setInput(i, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOutput method, of class wekaANN.
     */
    @Test
    public void testGetOutput() {
        System.out.println("getOutput");
        int i = 0;
        wekaANN instance = new wekaANN();
        double expResult = 0.0;
        double result = instance.getOutput(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDesiredOutput method, of class wekaANN.
     */
    @Test
    public void testSetDesiredOutput() {
        System.out.println("setDesiredOutput");
        int i = 0;
        double value = 0.0;
        wekaANN instance = new wekaANN();
        instance.setDesiredOutput(i, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of feedForward method, of class wekaANN.
     */
    @Test
    public void testFeedForward() {
        System.out.println("feedForward");
        wekaANN instance = new wekaANN();
        instance.feedForward();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of backPropagate method, of class wekaANN.
     */
    @Test
    public void testBackPropagate() {
        System.out.println("backPropagate");
        wekaANN instance = new wekaANN();
        instance.backPropagate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMAxOutPutID method, of class wekaANN.
     */
    @Test
    public void testGetMAxOutPutID() {
        System.out.println("getMAxOutPutID");
        wekaANN instance = new wekaANN();
        int expResult = 0;
        int result = instance.getMAxOutPutID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateError method, of class wekaANN.
     */
    @Test
    public void testCalculateError() {
        System.out.println("calculateError");
        wekaANN instance = new wekaANN();
        double expResult = 0.0;
        double result = instance.calculateError();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLearningRate method, of class wekaANN.
     */
    @Test
    public void testSetLearningRate() {
        System.out.println("setLearningRate");
        double rate = 0.0;
        wekaANN instance = new wekaANN();
        instance.setLearningRate(rate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLinearOutput method, of class wekaANN.
     */
    @Test
    public void testSetLinearOutput() {
        System.out.println("setLinearOutput");
        boolean useLinear = false;
        wekaANN instance = new wekaANN();
        instance.setLinearOutput(useLinear);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMomentum method, of class wekaANN.
     */
    @Test
    public void testSetMomentum() {
        System.out.println("setMomentum");
        boolean useMomentum = false;
        double factor = 0.0;
        wekaANN instance = new wekaANN();
        instance.setMomentum(useMomentum, factor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dumpData method, of class wekaANN.
     */
    @Test
    public void testDumpData() {
        System.out.println("dumpData");
        wekaANN instance = new wekaANN();
        instance.dumpData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}