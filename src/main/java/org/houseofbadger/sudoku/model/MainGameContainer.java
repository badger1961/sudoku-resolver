package org.houseofbadger.sudoku.model;

import java.util.List;
import java.util.ArrayList;

public class MainGameContainer {
	private final List<MatrixContainer> matrixContainerList;
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
		this.matrixContainerList = this.initMatrixontainerList(matrixSize);
		this.vectorContainerRowList = this.initVectorContainerList(lineSize);
		this.vectorContainerColList = this.initVectorContainerList(lineSize);
		this.matrixSize = matrixSize;
		this.lineSize = lineSize;
	}
	
	public List<MatrixContainer> getMatrixContainerList() {
		return matrixContainerList;
	}

	public List<VectorContainer> getVectorContainerRowList() {
		return vectorContainerRowList;
	}

	public List<VectorContainer> getVectorContainerColList() {
		return vectorContainerColList;
	}

	private List<VectorContainer> initVectorContainerList(int vectorSize) {
		List<VectorContainer> vectorContainerColList = new ArrayList<VectorContainer>(vectorSize);
		for (int i = 0; i < ContainerConstants.CONTAINER_LINE_SIZE; i++) {
			VectorContainer vector = new VectorContainer(i);
			vectorContainerColList.add(vector);
		}
		
		return vectorContainerColList;
	}
	
	private List<MatrixContainer> initMatrixontainerList(int matrixSize) {
		List<MatrixContainer> matrixContainerList = new ArrayList<MatrixContainer>(matrixSize * matrixSize);
		for (int i = 0, j = 0; i < ContainerConstants.CONTAINER_LINE_SIZE; i++, j++) {
			MatrixContainer matrix = new MatrixContainer(i,j);
			matrixContainerList.add(matrix);
		}
		
		return matrixContainerList;
	}

}
