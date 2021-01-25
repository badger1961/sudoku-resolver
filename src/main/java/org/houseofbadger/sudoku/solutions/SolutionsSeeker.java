package org.houseofbadger.sudoku.solutions;

import java.util.List;
import java.util.Map;

import org.houseofbadger.sudoku.dataloader.OutputDataWriter;
import org.houseofbadger.sudoku.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SolutionsSeeker {
	private static final Logger logger= LoggerFactory.getLogger(SolutionsSeeker.class);
	
	public void trivialSolutionSeeker(final MainGameContainer mainGameContainer) {
		logger.debug("start finding trivial solutions");
		List<VectorContainer> vectorColumnList = mainGameContainer.getVectorContainerColList();
		List<VectorContainer> vectorRowList = mainGameContainer.getVectorContainerRowList();
		Map<MatrixKey, MatrixContainer> matrixMap = mainGameContainer.getMatrixContainerMap();
		this.findTrivialSolutionForVector(vectorColumnList);
		this.findTrivialSolutionForVector(vectorRowList);
		this.findTrivialSolutionForMatrix(matrixMap);
		logger.debug("end finding trivial solutions");
	}

	public void trivialPossibleValueSeeker(final MainGameContainer mainGameContainer) {

	}

	public void seekGameSolution(final MainGameContainer mainGameContainer) {
		logger.info("Find solution started");
		int iteration = 1;
		while (!mainGameContainer.mainGameContainerCompleted()) {
			logger.info("Iteration : " + iteration );
			this.trivialSolutionSeeker(mainGameContainer);
			mainGameContainer.cleanPossibleValue();
			OutputDataWriter outputDataWriter = new OutputDataWriter();
			outputDataWriter.saveMainGameContainer(mainGameContainer, "step-" + iteration + ".txt");
			iteration++;
		}
		logger.info("Find solution ended");
	}

	private void trivialPossibleValueInVectorSeeker(List<VectorContainer> vectorContainerList) {
		for(VectorContainer vector : vectorContainerList ) {
			var trivialCellsList = vector.getCellWithTrivialPossibleValues();
			for (AtomicCell cell : trivialCellsList) {
				int possibleValue = cell.getPossibleValue().get(0);
				cell.setValue(possibleValue);
			}
		}
	}

	private void trivialPossibleValueInMatrixSeeker(Map<MatrixKey, MatrixContainer> matrixMap) {
		for ( MatrixKey key : matrixMap.keySet()) {
			MatrixContainer matrixContainer = matrixMap.get(key);
		}
	}

	private void findTrivialSolutionForVector(final List<VectorContainer> vectorList) {
		for(VectorContainer vector : vectorList) {
			List<AtomicCell> emptyCellsList = vector.getEmptyAtomicCellList();
			this.trivialFillEmptyCell(emptyCellsList,vector.getIdx(), vector.getAvailableNumber());
		}
	}

	private void findTrivialSolutionForMatrix(Map<MatrixKey, MatrixContainer> matrixMap) {
		for (MatrixKey key : matrixMap.keySet()) {
			MatrixContainer matrix = matrixMap.get(key);
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
			AtomicCell emptyCell = emptyCellsList.get(0);
			emptyCell.setValue(availableNumber.get(0));
		}
	}
}
