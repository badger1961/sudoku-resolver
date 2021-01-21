package org.houseofbadger.sudoku.model;

import java.util.ArrayList;
import java.util.List;

public class VectorContainer {
    private final int idx;
    private final int vectorSize;
    private final ContainerCellUtils containerCellUtils;
    private final List<AtomicCell> atomicCellsList;

    enum VectorEnum {
    	ROW_MODE,
    	COLUMN_MODE
    }
    
    public VectorContainer(int idx, List<List<AtomicCell>> vectorData, VectorEnum mode) {
        this.idx = idx;
        this.vectorSize = vectorData.size();
        if (mode == VectorEnum.ROW_MODE) {
        	this.atomicCellsList = this.rowVectorContasinerFactory(vectorData);
        } else if (mode == VectorEnum.COLUMN_MODE) {
        	this.atomicCellsList = this.columnVectorContainerFactory(vectorData);
        } else {
        	throw new ContainerException("Invalid mode of vector creation");
        }
        
        this.containerCellUtils = new ContainerCellUtils(this.atomicCellsList );
    }
    
    private List<AtomicCell> rowVectorContasinerFactory(List<List<AtomicCell>> vectorData) {
    	List<AtomicCell> buffer = vectorData.get(this.idx);
    	return buffer;
    }
    
    private List<AtomicCell> columnVectorContainerFactory(List<List<AtomicCell>> vectorData) {
    	List<AtomicCell> buffer = new ArrayList<>();
    	for (int row = 0; row < this.vectorSize; row++) {
    		AtomicCell cell = vectorData.get(row).get(this.idx);
    		buffer.add(cell);
    	}
    	
    	return buffer;
    }

    public void cleanPossibleValue() {
        this.containerCellUtils.cleanPossibleValue();
    }

    public int getIdx() {
		return idx;
	}

	public int getVectorSize() {
		return vectorSize;
	}

	public List<AtomicCell> getAtomicCellsList() {
        return this.atomicCellsList;
    }

	public AtomicCell getAtomicCell(int x) {
        AtomicCell cell = this.atomicCellsList.get(x);
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

    @Override
    public String toString() {
        return "VectorContainer{" +
                "idx=" + idx +
                ", vectorSize=" + vectorSize +
                ", containerCellUtils=" + containerCellUtils +
                ", atomicCellsList=" + atomicCellsList +
                '}';
    }
}
