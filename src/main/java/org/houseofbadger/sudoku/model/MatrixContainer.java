package org.houseofbadger.sudoku.model;

import java.util.ArrayList;
import java.util.List;

public class MatrixContainer {
	private final int containerRowSize;
	private final int containerColSize;
	private final int columnNumber;
	private final int rowNumber;
	private final ContainerCellUtils containerCellUtils;
	private final List<AtomicCell> atomicCellsList;


	public MatrixContainer(List<List<AtomicCell>> dataSet, int columnNumber, int rowNumber, int colSize, int rowSize) {
		this.columnNumber = columnNumber;
		this.rowNumber = rowNumber;
		this.containerRowSize = rowSize;
		this.containerColSize = colSize;
		this.atomicCellsList = new ArrayList<AtomicCell>(colSize * rowSize);
		this.containerCellUtils = new ContainerCellUtils(atomicCellsList);
		int maxRow = rowNumber + rowSize;
		int maxCol = columnNumber + colSize;
		for (int row = rowNumber; row < maxRow; row++) {
			for (int column = columnNumber; column < maxCol; column++) {
				List<AtomicCell> rowData = dataSet.get(row);
				this.atomicCellsList.add(rowData.get(column));
			}
		}

	}

	public List<AtomicCell> getEmptyAtomocCellList() {
		List<AtomicCell> emptyCellList = this.containerCellUtils.getEmptyAtomocCellList();
		return emptyCellList;
	}

	public List<AtomicCell> getAtomicCellsList() {
		return this.atomicCellsList;
	}

	public AtomicCell getAtomicCell(int x, int y) {
		AtomicCell cell = this.atomicCellsList.stream().filter((c) -> c.getXPos() == x && c.getYPos() == y).findFirst()
				.get();
		return cell;
	}

	public int getValueAtomicCell(int row, int col) {
		AtomicCell cell = this.getAtomicCell(col, row);
		return cell.getValue();
	}

	public void setValueAtomicCell(int row, int col, int value) {
		AtomicCell cell = this.getAtomicCell(col, row);
		cell.setValue(value);
	}

	public List<Integer> getPossibleValueAtomicCell(int col, int row) {
		AtomicCell cell = getAtomicCell(col, row);
		return cell.getPossibleValue();
	}

	public void resetPossibleValueAtomicCell(int x, int y, int value) {
		AtomicCell cell = getAtomicCell(x, y);
		cell.resetPossibleValue(value);
	}

	public void cleanPossibleValue() {
		this.containerCellUtils.cleanPossibleValue();
	}

	public List<Integer> getUsedNumber() {
		return this.containerCellUtils.getUsedNumber();
	}

	public List<Integer> getAvailableNumber() {
		return this.containerCellUtils.getAvailableNumber();
	}

	public int getContainerColSize() {
		return this.containerColSize;
	}

	public int getContainerRowYSize() {
		return this.containerRowSize;
	}

	public String getIdx() {
		String idx = this.rowNumber + " : " +  this.columnNumber;
		return idx;
	}
}
