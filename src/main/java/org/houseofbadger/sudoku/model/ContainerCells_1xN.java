package org.houseofbadger.sudoku.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContainerCells_1xN extends AbstractContainerCells{
    private List<AtomicCell> atomicCellList;
    private int idx;
    public ContainerCells_1xN(int idx) {
        this.idx = idx;
        this.atomicCellList = new ArrayList<>(9);
        for (int x = 0; x < ContainerConstants.CONTAINER_LINE_SIZE; x++) {
                AtomicCell atomicCell = new AtomicCell(x, idx, 0);
                this.atomicCellList.add(atomicCell);
        }
    }

    public AtomicCell getAtomicCell(int x) {
        AtomicCell cell = this.atomicCellList.stream().filter((c) -> c.getXPos() == x ).findFirst().get();
        return  cell;
    }

    public int getValueAtomicCell(int x) {
        AtomicCell cell = this.getAtomicCell(x);
        return cell.getValue();
    }

    public void setValueAtomicCell(int x, int value) {
        AtomicCell cell = this.getAtomicCell(x);
        cell.setValue(value);
    }

    public List<Integer> getPossibleValueAtomicCell(int x) {
        AtomicCell cell = getAtomicCell(x);
        return cell.getPossibleValue();
    }

    public void resetPossibleValueAtomicCell(int x, int value) {
        AtomicCell cell = getAtomicCell(x);
        cell.resetPossibleValue(value);
    }
}
