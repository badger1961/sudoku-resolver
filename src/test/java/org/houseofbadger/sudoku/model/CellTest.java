package org.houseofbadger.sudoku.model;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class CellTest {

    @Test
    public void testGetValue() {
        Cell c = new Cell(0,0, 1);
        int result = c.getValue();
        Assert.assertEquals(1, result);
    }

    @Test
    public void testSetValue() {
        Cell c = new Cell(0,0, 1);
        c.setValue(2);
        int result = c.getValue();
        Assert.assertEquals(2, result);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetValue2() {
        Cell c = new Cell(0,0, -1);
        c.setValue(2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetValue3() {
        Cell c = new Cell(0,0, 20);
        c.setValue(2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructor() {
        Cell c = new Cell(-1,0, 3);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructor2() {
        Cell c = new Cell(0,-1, 3);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructor3() {
        Cell c = new Cell(20,0, 3);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructor4() {
        Cell c = new Cell(0,20, 3);
    }

    @Test
    public void testResetValue() {
        Cell c = new Cell(0,0, 1);
        c.resetValue();
        int result = c.getValue();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testResetPossibleValue() {
        Cell c = new Cell(0,0, 1);
        c.resetPossibleValue(0);
        List<Integer> result = c.getPossibleValue();
        List<Integer> expected  = new ArrayList<Integer>(Arrays.asList(2,3,4,5,6,7,8,9));
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testResetPossibleValue2() {
        Cell c = new Cell(0,0, 1);
        c.resetPossibleValue(4);
        List<Integer> result = c.getPossibleValue();
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,2,3,4,6,7,8,9));
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetPossibleValue() {
        Cell c = new Cell(0,0, 1);
        List<Integer> result = c.getPossibleValue();
        List<Integer>  expected =Arrays.asList(1,2,3,4,5,6,7,8,9);
        Assert.assertEquals(expected, result);
    }
}