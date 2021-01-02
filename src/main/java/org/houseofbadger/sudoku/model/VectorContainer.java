package org.houseofbadger.sudoku.model;

import java.util.ArrayList;
import java.util.List;

public class VectorContainer {
    private final int idx;
    private final int vectorSize;
    private final ContainerCellUtils containerCellUtils;
    private final List<AtomicCell> atomicCellsList;
    
    public VectorContainer(int idx) {
    	this(idx,9);
    }
    
    public VectorContainer(int idx, int vectorSize) {
        this.idx = idx;
        this.vectorSize = vectorSize;
        this.atomicCellsList = new ArrayList<>(9);
        this.containerCellUtils = new ContainerCellUtils(this.atomicCellsList);
        
        for (int x = 0; x < ContainerConstants.CONTAINER_LINE_SIZE; x++) {
                AtomicCell atomicCell = new AtomicCell(x, idx, 0);
                this.atomicCellsList.add(atomicCell);
        }
    }

    public int getIdx() {
		return idx;
	}

	public int getVectorSize() {
		return vectorSize;
	}

	public AtomicCell getAtomicCell(int x) {
        AtomicCell cell = this.atomicCellsList.stream().filter((c) -> c.getXPos() == x ).findFirst().get();
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
    
    public List<Integer> getUsedNumber() {
    	return this.containerCellUtils.getUsedNumber();
    }
    
    public List<Integer> getAvailableNumber() {
    	return this.containerCellUtils.getAvailableNumber();
    }
}
