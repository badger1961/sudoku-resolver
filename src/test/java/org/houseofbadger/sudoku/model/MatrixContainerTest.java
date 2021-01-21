package org.houseofbadger.sudoku.model;

import org.houseofbadger.sudoku.dataloader.InputDataLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixContainerTest {

    @Test
    public void testGetAtomicCell() {
    	String dataSetName = "src/test/resources/positive.txt";
  	    InputDataLoader dataLoader = new InputDataLoader();
  	    List<List<AtomicCell>> data = dataLoader.loadData(dataSetName, 9);
        MatrixContainer matrix = new MatrixContainer(data,0,0,3,3);
        AtomicCell cell = matrix.getAtomicCell(0,0);
        Assert.assertEquals(cell.getValue(), 0);
        Assert.assertEquals(cell.getXPos(), 0);
        Assert.assertEquals(cell.getYPos(), 0);
        AtomicCell actual = matrix.getAtomicCell(2,2);
        Assert.assertEquals(actual.getValue(), 9);
        Assert.assertEquals(actual.getXPos(), 2);
        Assert.assertEquals(actual.getYPos(), 2);
    }

    @Test
    public void testGetValueAtomicCell() {
    	String dataSetName = "src/test/resources/positive.txt";
  	    InputDataLoader dataLoader = new InputDataLoader();
  	    List<List<AtomicCell>> data = dataLoader.loadData(dataSetName, 9);
        MatrixContainer containerCellsNxN = new MatrixContainer(data,0,0,3,3);
        AtomicCell actual = containerCellsNxN.getAtomicCell(2,2);
        Assert.assertEquals(actual.getValue(), 9);
    }

    @Test
    public void testSetValueAtomicCell() {
    	String dataSetName = "src/test/resources/positive.txt";
  	    InputDataLoader dataLoader = new InputDataLoader();
  	    List<List<AtomicCell>> data = dataLoader.loadData(dataSetName, 9);
        MatrixContainer containerCellsNxN = new MatrixContainer(data,0,0,3,3);
        AtomicCell actual = containerCellsNxN.getAtomicCell(0,0);
        containerCellsNxN.setValueAtomicCell(0,0, 5);
        int actualValue = containerCellsNxN.getAtomicCell(0,0).getValue();
        Assert.assertEquals(5, actualValue);
    }

    @Test
    public void testGetPossibleValueAtomicCell() {
    	String dataSetName = "src/test/resources/positive.txt";
  	    InputDataLoader dataLoader = new InputDataLoader();
  	    List<List<AtomicCell>> data = dataLoader.loadData(dataSetName, 9);
        MatrixContainer containerCellsNxN = new MatrixContainer(data,0,0,3,3);
        List<Integer> result = containerCellsNxN.getPossibleValueAtomicCell(0,0);
        List<Integer> expected  = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testResetPossibleValueAtomicCell() {
    	String dataSetName = "src/test/resources/positive.txt";
  	    InputDataLoader dataLoader = new InputDataLoader();
  	    List<List<AtomicCell>> data = dataLoader.loadData(dataSetName, 9);
        MatrixContainer containerCellsNxN = new MatrixContainer(data,0,0,3,3);
        List<Integer> result = containerCellsNxN.getPossibleValueAtomicCell(0,0);
        List<Integer> expected  = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Assert.assertEquals(result, expected);
        containerCellsNxN.resetPossibleValueAtomicCell(0,0, 5);
        List<Integer> result2 = containerCellsNxN.getPossibleValueAtomicCell(0,0);
        List<Integer> expected2  = new ArrayList<Integer>(Arrays.asList(1,2,3,4,6,7,8,9));
        Assert.assertEquals(result2, expected2);
    }

    @Test
    public void testGetUsedNumber() {
    	String dataSetName = "src/test/resources/positive.txt";
  	    InputDataLoader dataLoader = new InputDataLoader();
  	    List<List<AtomicCell>> data = dataLoader.loadData(dataSetName, 9);
        MatrixContainer containerCellsNxN = new MatrixContainer(data,0,0,3,3);
        List<Integer> actual = containerCellsNxN.getUsedNumber();
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(6,2,1,3,9));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetAvailableNumber() {
    	String dataSetName = "src/test/resources/positive.txt";
  	    InputDataLoader dataLoader = new InputDataLoader();
  	    List<List<AtomicCell>> data = dataLoader.loadData(dataSetName, 9);
        MatrixContainer containerCellsNxN = new MatrixContainer(data,0,0,3,3);
        List<Integer> actual = containerCellsNxN.getAvailableNumber();
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(4,5,7,8));
        Assert.assertEquals(actual, expected);
    }
}