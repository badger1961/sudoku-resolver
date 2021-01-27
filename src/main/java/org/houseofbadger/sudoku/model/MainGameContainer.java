package org.houseofbadger.sudoku.model;

import java.util.List;
import java.util.Map;

import org.houseofbadger.sudoku.model.VectorContainer.VectorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class MainGameContainer {
	private static final Logger logger= LoggerFactory.getLogger(MainGameContainer.class);
	private final Map<MatrixKey, MatrixContainer> matrixContainerMap;
	private final List<VectorContainer> vectorContainerRowList;
	private final List<VectorContainer> vectorContainerColList;
	private final int matrixSize;
	private final int lineSize;
	
	public int getMatrixSize() {
		return this.matrixSize;
	}
	
	public int getLineSize() {
		return this.lineSize;
	}
	
	
	public MainGameContainer(List<List<AtomicCell>> gameDataSet, int matrixSize, int lineSize) {
		this.matrixSize = matrixSize;
		this.lineSize = lineSize;
		this.vectorContainerRowList = this.initVectorContainerList(gameDataSet, lineSize, VectorEnum.ROW_MODE);
		this.vectorContainerColList = this.initVectorContainerList(gameDataSet, lineSize, VectorEnum.COLUMN_MODE);
		this.matrixContainerMap = this.initMatrixontainerList(gameDataSet, lineSize);
	}
	
	public Map<MatrixKey, MatrixContainer> getMatrixContainerMap() {
		return matrixContainerMap;
	}

	public List<VectorContainer> getVectorContainerRowList() {
		return vectorContainerRowList;
	}

	public List<VectorContainer> getVectorContainerColList() {
		return vectorContainerColList;
	}
	
	public MatrixContainer getMatrixContainer(int leftUpperLine, int leftUpperRow) {
		return this.matrixContainerMap.get(new MatrixKey(leftUpperLine, leftUpperRow));
	}

	public void cleanPossibleValue() {
		this.vectorContainerColList.stream().forEach(v -> v.cleanPossibleValue());
		this.vectorContainerRowList.stream().forEach(v -> v.cleanPossibleValue());
		matrixContainerMap.keySet().stream().forEach(key -> this.matrixContainerMap.get(key).cleanPossibleValue());
	}

	public boolean mainGameContainerCompleted() {
		List<VectorContainer> completedVector =  this.vectorContainerRowList.stream().filter(v -> v.getAvailableNumber().size() == 0).collect(Collectors.toList());
		int completedLinesNumber = completedVector.size();
		logger.debug("Completed lines : " + completedLinesNumber);
		if (completedLinesNumber == ContainerConstants.CONTAINER_LINE_MAX) {
			logger.debug("Game completed");
			return true;
		} else {
			logger.debug("Continue game");
			return false;
		}
	}

	private List<VectorContainer> initVectorContainerList(List<List<AtomicCell>> dataSet, int vectorSize, VectorEnum mode) {
		List<VectorContainer> vectorContainerColList = new ArrayList<VectorContainer>(vectorSize);
		for (int i = 0; i < ContainerConstants.CONTAINER_LINE_SIZE; i++) {
			VectorContainer vector = new VectorContainer(i, dataSet, mode);
			vectorContainerColList.add(vector);
		}
		
		return vectorContainerColList;
	}
	
	private Map<MatrixKey, MatrixContainer> initMatrixontainerList(List<List<AtomicCell>> dataSet, int matrixSize) {
		Map<MatrixKey, MatrixContainer> matrixContainerMap = new HashMap<>();
		for (int row = 0; row < this.lineSize; row += this.matrixSize) {
			for (int column = 0; column < this.lineSize; column += this.matrixSize) {
				MatrixContainer matrixContainer = new  MatrixContainer(dataSet, row, column, this.matrixSize, this.matrixSize);
				matrixContainerMap.put(new MatrixKey(row,column), matrixContainer);
			}
		}
		
		return matrixContainerMap;
	}



}
