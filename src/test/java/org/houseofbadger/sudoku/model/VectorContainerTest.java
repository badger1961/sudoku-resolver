package org.houseofbadger.sudoku.model;

import org.houseofbadger.sudoku.dataloader.InputDataLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class VectorContainerTest {

    @Test
    public void testGetAtomicCell() {
    	String dataSetName = "src/test/resources/positive.txt";
  	    InputDataLoader dataLoader = new InputDataLoader();
  	    List<List<AtomicCell>> data = dataLoader.loadData(dataSetName, 9);
        VectorContainer containerCells1xN = new VectorContainer(1, data);
        AtomicCell actual = containerCells1xN.getAtomicCell(1);
        Assert.assertEquals(actual.getValue(), 2);
        Assert.assertEquals(actual.getXPos(), 1);
        Assert.assertEquals(actual.getYPos(), 1);
    }

    @Test
    public void testGetPossibleValueAtomicCell() {
    	String dataSetName = "src/test/resources/positive.txt";
  	    InputDataLoader dataLoader = new InputDataLoader();
  	    List<List<AtomicCell>> data = dataLoader.loadData(dataSetName, 9);
        VectorContainer containerCells1xN = new VectorContainer(2, data);
        List<Integer> result = containerCells1xN.getPossibleValueAtomicCell(2);
        List<Integer> expected  = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testResetPossibleValueAtomicCell() {
    	String dataSetName = "src/test/resources/positive.txt";
  	    InputDataLoader dataLoader = new InputDataLoader();
  	    List<List<AtomicCell>> data = dataLoader.loadData(dataSetName, 9);
        VectorContainer containerCells1xN = new VectorContainer(2, data);
        List<Integer> result = containerCells1xN.getPossibleValueAtomicCell(2);
        List<Integer> expected  = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Assert.assertEquals(result, expected);
        containerCells1xN.resetPossibleValueAtomicCell(2, 5);
        List<Integer> result2 = containerCells1xN.getPossibleValueAtomicCell(2);
        List<Integer> expected2  = new ArrayList<Integer>(Arrays.asList(1,2,3,4,6,7,8,9));
        Assert.assertEquals(result2, expected2);
    }

    @Test
    public void testGetUsedNumber() {
    	String dataSetName = "src/test/resources/positive.txt";
  	    InputDataLoader dataLoader = new InputDataLoader();
  	    List<List<AtomicCell>> data = dataLoader.loadData(dataSetName, 9);
        VectorContainer containerCells1xN = new VectorContainer(2, data);
        List<Integer> actual = containerCells1xN.getUsedNumber();
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(3,9,4));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetAvailableNumber() {
    	String dataSetName = "src/test/resources/positive.txt";
  	    InputDataLoader dataLoader = new InputDataLoader();
  	    List<List<AtomicCell>> data = dataLoader.loadData(dataSetName, 9);
        VectorContainer containerCells1xN = new VectorContainer(2, data);
        List<Integer> actual = containerCells1xN.getAvailableNumber();
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,2,5,6,7,8));
        Assert.assertEquals(actual, expected);
    }
}