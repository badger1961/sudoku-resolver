package org.houseofbadger.sudoku.model;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class ContainerCells_1xNTest {

    @Test
    public void testGetAtomicCell() {
        ContainerCells_1xN containerCells1xN = new ContainerCells_1xN(2);
        AtomicCell actual = containerCells1xN.getAtomicCell(1);
        Assert.assertEquals(actual.getValue(), 0);
        Assert.assertEquals(actual.getXPos(), 1);
        Assert.assertEquals(actual.getYPos(), 2);
    }

    @Test
    public void testGetValueAtomicCell() {
        ContainerCells_1xN containerCells1xN = new ContainerCells_1xN(2);
        AtomicCell actual = containerCells1xN.getAtomicCell(2);
        Assert.assertEquals(actual.getValue(), 0);
    }

    @Test
    public void testSetValueAtomicCell() {
        ContainerCells_1xN containerCells1xN = new ContainerCells_1xN(2);
        AtomicCell actual = containerCells1xN.getAtomicCell(2);
        containerCells1xN.setValueAtomicCell(2, 5);
        int actualValue = containerCells1xN.getAtomicCell(2).getValue();
        Assert.assertEquals(5, actualValue);
    }

    @Test
    public void testGetPossibleValueAtomicCell() {
        ContainerCells_1xN containerCells1xN = new ContainerCells_1xN(2);
        List<Integer> result = containerCells1xN.getPossibleValueAtomicCell(2);
        List<Integer> expected  = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testResetPossibleValueAtomicCell() {
        ContainerCells_1xN containerCells1xN = new ContainerCells_1xN(2);
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
        ContainerCells_1xN containerCells1xN = new ContainerCells_1xN(2);
        containerCells1xN.setValueAtomicCell(0,5);
        containerCells1xN.setValueAtomicCell(1,6);
        containerCells1xN.setValueAtomicCell(2,7);
        List<Integer> actual = containerCells1xN.getUsedNumber();
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(5,6,7));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetAvailableNumber() {
        ContainerCells_1xN containerCells1xN = new ContainerCells_1xN(2);
        containerCells1xN.setValueAtomicCell(0,5);
        containerCells1xN.setValueAtomicCell(1,6);
        containerCells1xN.setValueAtomicCell(2,7);
        List<Integer> actual = containerCells1xN.getAvailableNumber();
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,2,3,4,8,9));
        Assert.assertEquals(actual, expected);
    }
}