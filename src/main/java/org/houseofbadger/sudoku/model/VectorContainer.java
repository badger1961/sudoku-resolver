package org.houseofbadger.sudoku.model;

import java.util.ArrayList;
import java.util.List;

public class VectorContainer {
    private final int idx;
    private final int vectorSize;
    private final ContainerCellUtils containerCellUtils;
    private final List<AtomicCell> atomicCellsList;
    
    
    public VectorContainer(int idx, List<List<AtomicCell>> vectorData) {
        this.idx = idx;
        this.vectorSize = vectorData.size();
        List<AtomicCell> buff = vectorData.get(idx);
        this.containerCellUtils = new ContainerCellUtils(buff);
        this.atomicCellsList = buff;
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
