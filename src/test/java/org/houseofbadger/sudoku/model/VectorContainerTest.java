package org.houseofbadger.sudoku.model;

import org.houseofbadger.sudoku.dataloader.InputDataLoader;
import org.houseofbadger.sudoku.model.VectorContainer.VectorEnum;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class VectorContainerTest {

    @Test
    public void testGetAtomicCell() {
    	String dataSetName = "src/test/resources/positive.txt";
  	    InputDataLoader dataLoader = new InputDataLoader();
  	    List<List<AtomicCell>> data = dataLoader.loadData(dataSetName, 9);
        VectorContainer vector = new VectorContainer(1, data, VectorEnum.ROW_MODE);
        List<Integer> actual = new ArrayList<>();
        List<Integer> expected =new ArrayList<>(Arrays.asList(6,2,1,0,0,0,0,0,0));
        for (int i = 0; i < vector.getVectorSize(); i++) {
        	actual.add(vector.getAtomicCell(i).getValue());
        }
        Assert.assertEquals(actual, expected);
    }
    
    @Test
    public void testGetAtomicCell2() {
    	String dataSetName = "src/test/resources/positive.txt";
  	    InputDataLoader dataLoader = new InputDataLoader();
  	    List<List<AtomicCell>> data = dataLoader.loadData(dataSetName, 9);
        VectorContainer vector = new VectorContainer(1, data, VectorEnum.COLUMN_MODE);
        List<Integer> actual = new ArrayList<>();
        List<Integer> expected =new ArrayList<>(Arrays.asList(0,2,0,0,0,6,7,1,5));
        for (int i = 0; i < vector.getVectorSize(); i++) {
        	actual.add(vector.getAtomicCell(i).getValue());
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCleanPossibleValue() {
        String dataSetName = "src/test/resources/positive.txt";
        InputDataLoader dataLoader = new InputDataLoader();
        List<List<AtomicCell>> data = dataLoader.loadData(dataSetName, 9);
        VectorContainer vector = new VectorContainer(1, data, VectorEnum.ROW_MODE);
        List<Integer> expected =new ArrayList<>(Arrays.asList(3,4,5,7,8,9));
        vector.cleanPossibleValue();
        AtomicCell cell = vector.getAtomicCell(3);
        List<Integer> actual = cell.getPossibleValue();
        Assert.assertEquals(actual,expected);
    }
}