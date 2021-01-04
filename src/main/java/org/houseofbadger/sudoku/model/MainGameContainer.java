package org.houseofbadger.sudoku.model;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class MainGameContainer {
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
	
	public MainGameContainer() {
		this(ContainerConstants.CONTAINER_X_SIZE, ContainerConstants.CONTAINER_Y_SIZE);
	}
	
	public MainGameContainer(int matrixSize, int lineSize) {
		this.matrixContainerMap = this.initMatrixontainerList(matrixSize);
		this.vectorContainerRowList = this.initVectorContainerList(lineSize);
		this.vectorContainerColList = this.initVectorContainerList(lineSize);
		this.matrixSize = matrixSize;
		this.lineSize = lineSize;
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

	private List<VectorContainer> initVectorContainerList(int vectorSize) {
		List<VectorContainer> vectorContainerColList = new ArrayList<VectorContainer>(vectorSize);
		for (int i = 0; i < ContainerConstants.CONTAINER_LINE_SIZE; i++) {
			VectorContainer vector = new VectorContainer(i);
			vectorContainerColList.add(vector);
		}
		
		return vectorContainerColList;
	}
	
	private Map<MatrixKey, MatrixContainer> initMatrixontainerList(int matrixSize) {
		Map<MatrixKey, MatrixContainer> matrixContainerMap = new HashMap<>();
		for (int i = 0; i < ContainerConstants.CONTAINER_LINE_SIZE; i = i + this.matrixSize) {
			for (int j = 0; j < ContainerConstants.CONTAINER_Y_SIZE; j = j + this.matrixSize) {
				MatrixContainer matrix = new MatrixContainer(i,j);
				matrixContainerMap.put(new MatrixKey(i,j), matrix);
			}
		}
		
		return matrixContainerMap;
	}

}
