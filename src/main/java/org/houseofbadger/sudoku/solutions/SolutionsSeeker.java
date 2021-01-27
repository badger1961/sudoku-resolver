package org.houseofbadger.sudoku.solutions;

import java.util.List;
import java.util.Map;

import org.houseofbadger.sudoku.dataloader.OutputDataWriter;
import org.houseofbadger.sudoku.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SolutionsSeeker {
	private static final Logger logger= LoggerFactory.getLogger(SolutionsSeeker.class);
	


	public void seekGameSolution(final MainGameContainer mainGameContainer) {
		logger.info("Find solution started");
		int iteration = 1;
		while (!mainGameContainer.mainGameContainerCompleted()) {
			logger.info("Iteration : " + iteration );
			this.searchTrivialSolutionForContainer(mainGameContainer);
			this.searchTrivialSolutionForCell(mainGameContainer);
			mainGameContainer.cleanPossibleValue();
			OutputDataWriter outputDataWriter = new OutputDataWriter();
			outputDataWriter.saveMainGameContainer(mainGameContainer, "step-" + iteration + ".txt");
			iteration++;
		}
		logger.info("Find solution ended");
	}

	private void searchTrivialSolutionForContainer(final MainGameContainer mainGameContainer) {
		logger.debug("start finding trivial solutions");
		List<VectorContainer> vectorColumnList = mainGameContainer.getVectorContainerColList();
		List<VectorContainer> vectorRowList = mainGameContainer.getVectorContainerRowList();
		Map<MatrixKey, MatrixContainer> matrixMap = mainGameContainer.getMatrixContainerMap();
		this.findTrivialSolutionForVector(vectorColumnList);
		this.findTrivialSolutionForVector(vectorRowList);
		this.findTrivialSolutionForMatrix(matrixMap);
		logger.debug("end finding trivial solutions");
	}

	private void searchTrivialSolutionForCell(final MainGameContainer mainGameContainer) {
		List<VectorContainer> rowList = mainGameContainer.getVectorContainerRowList();
		List<VectorContainer> colList = mainGameContainer.getVectorContainerRowList();
		Map<MatrixKey, MatrixContainer> matrixContainerMap = mainGameContainer.getMatrixContainerMap();
		this.searchTrivialSolutionForCellInVector(rowList);
		this.searchTrivialSolutionForCellInVector(colList);
		this.searchTrivialSolutionForCellInMatrix(matrixContainerMap);
	}

	private void searchTrivialSolutionForCellInVector(List<VectorContainer> vectorContainerList) {
		for(VectorContainer vector : vectorContainerList ) {
			this.trivialFillCellByPossibleValue(vector.getAtomicCellsList());
		}
	}

	private void searchTrivialSolutionForCellInMatrix(Map<MatrixKey, MatrixContainer> matrixContainerMap) {
		for(MatrixKey key : matrixContainerMap.keySet()) {
			MatrixContainer matrixContainer = matrixContainerMap.get(key);
			this.trivialFillCellByPossibleValue(matrixContainer.getAtomicCellsList());
		}
	}

	private void findTrivialSolutionForVector(final List<VectorContainer> vectorList) {
		for(VectorContainer vector : vectorList) {
			logger.debug(String.valueOf(vector.getAtomicCellsList()));
			List<AtomicCell> emptyCellsList = vector.getEmptyAtomicCellList();
			this.trivialFillEmptyCell(emptyCellsList,vector.getIdx(), vector.getAvailableNumber());
		}
	}

	private void findTrivialSolutionForMatrix(Map<MatrixKey, MatrixContainer> matrixMap) {
		for (MatrixKey key : matrixMap.keySet()) {
			MatrixContainer matrix = matrixMap.get(key);
			logger.debug(String.valueOf(matrix.getAtomicCellsList().toString()));
			List<AtomicCell> emptyCellsList = matrix.getEmptyAtomicCellList();
			this.trivialFillEmptyCell(emptyCellsList, matrix.getIdx(), matrix.getAvailableNumber());
		}
	}

	private void trivialFillEmptyCell(List<AtomicCell> emptyCellsList, String idx, List<Integer> availableNumber) {
		int size = emptyCellsList.size();
		if (size > 1) {
			logger.info("No trivial solutions for verctor with ID : " + idx);
		} else if (size == 0) {
			logger.info("vector with ID is filled: " +  idx);
		} else {
			logger.info("We found trivial solution for ID : " + idx);
			logger.debug(String.valueOf(emptyCellsList));
			AtomicCell emptyCell = emptyCellsList.get(0);
			emptyCell.setValue(availableNumber.get(0));
			logger.debug(String.valueOf(emptyCellsList));
		}
	}

	private void trivialFillCellByPossibleValue(List<AtomicCell> atomicCellsList) {
		for(AtomicCell atomicCell : atomicCellsList) {
			List<Integer> actualPossibleValues = atomicCell.getPossibleValue();
			int possibleValuesListSize = actualPossibleValues.size();
			if (possibleValuesListSize == 0 ) {
				logger.info("This is final cell " + atomicCell.toString());
			} else if (possibleValuesListSize == 1 ){
				logger.info("We found cell for trivial solution : cell " + atomicCell.toString());
				atomicCell.setValue(actualPossibleValues.get(0));
			} else {
				logger.info("This cell is not ready for trivial solution cell : " + atomicCell.toString());
			}
		}
	}
}
