package org.houseofbadger.sudoku.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;

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
		this.vectorContainerRowList = this.initVectorContainerList(gameDataSet, lineSize);
		this.vectorContainerColList = this.initVectorContainerList(gameDataSet, lineSize);
		this.matrixContainerMap = this.initMatrixontainerList(matrixSize);
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

	private List<VectorContainer> initVectorContainerList(List<List<AtomicCell>> dataSet, int vectorSize) {
		List<VectorContainer> vectorContainerColList = new ArrayList<VectorContainer>(vectorSize);
		for (int i = 0; i < ContainerConstants.CONTAINER_LINE_SIZE; i++) {
			VectorContainer vector = new VectorContainer(i, dataSet);
			vectorContainerColList.add(vector);
		}
		
		return vectorContainerColList;
	}
	
	private Map<MatrixKey, MatrixContainer> initMatrixontainerList(int matrixSize) {
		Map<MatrixKey, MatrixContainer> matrixContainerMap = new HashMap<>();
		
		
		return matrixContainerMap;
	}

}
