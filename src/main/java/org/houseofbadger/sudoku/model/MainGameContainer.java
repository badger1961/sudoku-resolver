package org.houseofbadger.sudoku.model;

import java.util.List;
import java.util.ArrayList;

public class MainGameContainer {
	private final List<MatrixContainer> matrixContainerList;
	private final List<VectorContainer> vectorContainerRowList;
	private final List<VectorContainer> vectorContainerColList;
	private final int xSize;
	private final int ySize;
	
	public MainGameContainer() {
		this(ContainerConstants.CONTAINER_X_SIZE, ContainerConstants.CONTAINER_Y_SIZE);
	}
	
	public MainGameContainer(int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
		int maxSize = xSize * ySize;
		this.matrixContainerList = new ArrayList<MatrixContainer>(maxSize);
		this.vectorContainerRowList = new ArrayList<VectorContainer>(maxSize);
		this.vectorContainerColList = new ArrayList<VectorContainer>(maxSize);
	}
	
	public void loadInputData() {
		
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

	public int getxSize() {
		return xSize;
	}

	public int getySize() {
		return ySize;
	}
	

}
