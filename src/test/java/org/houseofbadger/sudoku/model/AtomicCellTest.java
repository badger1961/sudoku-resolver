package org.houseofbadger.sudoku.model;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AtomicCellTest {

    @Test
    public void testGetValue() {
        AtomicCell c = new AtomicCell(0,0, 1);
        int result = c.getValue();
        Assert.assertEquals(1, result);
    }

    @Test
    public void testSetValue() {
        AtomicCell c = new AtomicCell(0,0, 1);
        c.setValue(2);
        int result = c.getValue();
        Assert.assertEquals(2, result);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetValue2() {
        AtomicCell c = new AtomicCell(0,0, -1);
        c.setValue(2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetValue3() {
        AtomicCell c = new AtomicCell(0,0, 20);
        c.setValue(2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructor() {
        AtomicCell c = new AtomicCell(-1,0, 3);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructor2() {
        AtomicCell c = new AtomicCell(0,-1, 3);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructor3() {
        AtomicCell c = new AtomicCell(20,0, 3);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructor4() {
        AtomicCell c = new AtomicCell(0,20, 3);
    }

    @Test
    public void testResetValue() {
        AtomicCell c = new AtomicCell(0,0, 1);
        c.resetValue();
        int result = c.getValue();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testResetPossibleValue() {
        AtomicCell c = new AtomicCell(0,0, 1);
        c.resetPossibleValue(Integer.valueOf(1));
        List<Integer> result = c.getPossibleValue();
        List<Integer> expected  = new ArrayList<Integer>(Arrays.asList(2,3,4,5,6,7,8,9));
        Assert.assertEquals(expected, result);
        c.resetPossibleValue(Integer.valueOf(7));
        List<Integer> result2 = c.getPossibleValue();
        List<Integer> expected2  = new ArrayList<Integer>(Arrays.asList(2,3,4,5,6,8,9));
        Assert.assertEquals(expected2, result2);
    }


    @Test
    public void testGetPossibleValue() {
        AtomicCell c = new AtomicCell(0,0, 1);
        List<Integer> result = c.getPossibleValue();
        List<Integer>  expected =Arrays.asList(1,2,3,4,5,6,7,8,9);
        Assert.assertEquals(expected, result);
    }
}