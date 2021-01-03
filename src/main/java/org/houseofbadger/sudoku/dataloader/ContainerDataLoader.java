package org.houseofbadger.sudoku.dataloader;

import java.util.List;

import org.houseofbadger.sudoku.model.AtomicCell;
import org.houseofbadger.sudoku.model.ContainerConstants;
import org.houseofbadger.sudoku.model.MainGameContainer;
import org.houseofbadger.sudoku.model.MatrixContainer;
import org.houseofbadger.sudoku.model.VectorContainer;

public class ContainerDataLoader {
	
	public void loadData(final MainGameContainer mainContainer, String inputDataPath) {
		final InputDataLoader inputDataLoader = new InputDataLoader(inputDataPath);
		inputDataLoader.loadInputData();
		List<List<Integer>> inputData = inputDataLoader.getContent();
		List<VectorContainer> rowList = mainContainer.getVectorContainerRowList();
		List<VectorContainer> colList = mainContainer.getVectorContainerColList();
		List<MatrixContainer> matrixList = mainContainer.getMatrixContainerList();
 		this.loadDataToRows(inputData, rowList, mainContainer.getLineSize());
		this.loadDataToCols(inputData, colList, mainContainer.getLineSize());
		this.loadDataToMatrix(inputData, matrixList);
	}

	private void loadDataToRows(List<List<Integer>> inputData, List<VectorContainer> rowList, int lineSize) {
		for (int i = 0; i < lineSize; i++) {
			List<Integer> dataRow = inputData.get(i);
			VectorContainer row = rowList.get(i);
			for (int j = 0; j < lineSize; j++) {
				row.setValueAtomicCell(i, dataRow.get(j));
			}
		}
	}
	
	private void loadDataToCols(List<List<Integer>> inputData, List<VectorContainer> colList, int lineSize) {
		for (int i = 0; i < lineSize; i++) {
			VectorContainer column = colList.get(i);
			for (int j = 0; j < lineSize; j++) {
				List<Integer> dataRow = inputData.get(j);
				column.setValueAtomicCell(j, dataRow.get(j));
			}
		}
	}
	
	private void loadDataToMatrix(List<List<Integer>> inputData, List<MatrixContainer> colList) {
		
	}
	
}
