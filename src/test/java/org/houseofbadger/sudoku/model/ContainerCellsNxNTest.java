package org.houseofbadger.sudoku.model;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContainerCellsNxNTest {

    @Test
    public void testGetAtomicCell() {
        MatrixContainer containerCellsNxN = new MatrixContainer(0,0);
        AtomicCell actual = containerCellsNxN.getAtomicCell(0,0);
        Assert.assertEquals(actual.getValue(), 0);
        Assert.assertEquals(actual.getXPos(), 0);
        Assert.assertEquals(actual.getYPos(), 0);
    }

    @Test
    public void testGetValueAtomicCell() {
        MatrixContainer containerCellsNxN = new MatrixContainer(0,0);
        AtomicCell actual = containerCellsNxN.getAtomicCell(0,0);
        Assert.assertEquals(actual.getValue(), 0);
    }

    @Test
    public void testSetValueAtomicCell() {
        MatrixContainer containerCellsNxN = new MatrixContainer(0,0);
        AtomicCell actual = containerCellsNxN.getAtomicCell(0,0);
        containerCellsNxN.setValueAtomicCell(0,0, 5);
        int actualValue = containerCellsNxN.getAtomicCell(0,0).getValue();
        Assert.assertEquals(5, actualValue);
    }

    @Test
    public void testGetPossibleValueAtomicCell() {
        MatrixContainer containerCellsNxN = new MatrixContainer(0,0);
        List<Integer> result = containerCellsNxN.getPossibleValueAtomicCell(0,0);
        List<Integer> expected  = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testResetPossibleValueAtomicCell() {
        MatrixContainer containerCellsNxN = new MatrixContainer(0,0);
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
        MatrixContainer containerCellsNxN = new MatrixContainer(0,0);
        containerCellsNxN.setValueAtomicCell(0,0,5);
        containerCellsNxN.setValueAtomicCell(1,1,6);
        containerCellsNxN.setValueAtomicCell(2,2,7);
        List<Integer> actual = containerCellsNxN.getUsedNumber();
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(5,6,7));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetAvailableNumber() {
        MatrixContainer containerCellsNxN = new MatrixContainer(0,0);
        containerCellsNxN.setValueAtomicCell(0,0,5);
        containerCellsNxN.setValueAtomicCell(1,1,6);
        containerCellsNxN.setValueAtomicCell(2,2,7);
        List<Integer> actual = containerCellsNxN.getAvailableNumber();
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,2,3,4,8,9));
        Assert.assertEquals(actual, expected);
    }
}