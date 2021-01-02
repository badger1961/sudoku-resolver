package org.houseofbadger.sudoku.model;

import java.util.ArrayList;
import java.util.List;

public class MatrixContainer  {
    private final int containerXSize;
    private final int containerYSize;
    private final int xPos;
    private final int yPos;
    private final ContainerCellUtils containerCellUtils;
    private final List<AtomicCell> atomicCellsList;
    
    public MatrixContainer(int xPos, int yPos) {
    	this(xPos, yPos, ContainerConstants.CONTAINER_X_SIZE,ContainerConstants.CONTAINER_Y_SIZE);
    }
    
    public MatrixContainer(int xPos, int yPos, int xSize, int ySize) {
        this.atomicCellsList = new ArrayList<AtomicCell>(9);
        this.containerCellUtils = new ContainerCellUtils(atomicCellsList);
        for (int x = 0; x < ContainerConstants.CONTAINER_X_SIZE; x++) {
            for (int y = 0; y < ContainerConstants.CONTAINER_Y_SIZE; y++) {
                AtomicCell atomicCell = new AtomicCell(x,y, 0);
                this.atomicCellsList.add(atomicCell);
            }
        }
        this.xPos = xPos;
        this.yPos = yPos;
        this.containerXSize = xSize;
        this.containerYSize = ySize;
    }

    public AtomicCell getAtomicCell(int x, int y) {
        AtomicCell cell = this.atomicCellsList.stream().filter((c) -> c.getXPos() == x && c.getYPos() == y).findFirst().get();
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
    	return this.containerCellUtils.getUsedNumber();
    }
    
    public List<Integer> getAvailableNumber() {
    	return this.containerCellUtils.getAvailableNumber();
    }

	public int getContainerXSize() {
		return containerXSize;
	}

	public int getContainerYSize() {
		return containerYSize;
	}

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

}
