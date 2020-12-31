package org.houseofbadger.sudoku.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContainerCells_NxN {
    private List<AtomicCell> atomicCellList;
    private int containerXSize;
    private int containerYSize;
    public ContainerCells_NxN() {
        this.atomicCellList = new ArrayList<>(9);
        for (int x = 0; x < ContainerConstants.CONTAINER_X_SIZE; x++) {
            for (int y = 0; y < ContainerConstants.CONTAINER_Y_SIZE; y++) {
                AtomicCell atomicCell = new AtomicCell(x,y, 0);
                this.atomicCellList.add(atomicCell);
            }
        }
    }

    public AtomicCell getAtomicCell(int x, int y) {
        AtomicCell cell = this.atomicCellList.stream().filter((c) -> c.getXPos() == x && c.getYPos() == y).findFirst().get();
        return  cell;
    }

    public int getValueAtomicCell(int x, int y) {
        AtomicCell cell = this.getAtomicCell(x, y);
        return cell.getValue();
    }

    public void setValueAtomicCell(int x, int y, int value) {
        AtomicCell cell = this.getAtomicCell(x, y);
        cell.setValue(value);
    }

    public List<Integer> getPossibleValueAtomicCell(int x, int y) {
        AtomicCell cell = getAtomicCell(x,y);
        return cell.getPossibleValue();
    }

    public void resetPossibleValueAtomicCell(int x, int y, int value) {
        AtomicCell cell = getAtomicCell(x,y);
        cell.resetPossibleValue(value);
    }

    public List<Integer> getUsedNumber() {
        List<AtomicCell> usedCell = this.atomicCellList.stream().filter((c) -> c.getValue() != 0).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        usedCell.stream().forEach((c) -> result.add(c.getValue()));
        return result;
    }

    public List<Integer> getAvailableNumber() {
        List<Integer> usedNumber = this.getUsedNumber();
        List<Integer> allNumber = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        return allNumber.stream().filter(number -> !usedNumber.contains(number)).collect(Collectors.toList());
    }
}
