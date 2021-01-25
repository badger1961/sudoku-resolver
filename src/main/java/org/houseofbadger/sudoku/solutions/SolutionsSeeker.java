package org.houseofbadger.sudoku.solutions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		this.checkVectorForTrivialSolution(vectorColumnList);
		this.checkVectorForTrivialSolution(vectorRowList);
		this.checkMatrixForTrivialSolution(matrixMap);
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

	}
	private void checkVectorForTrivialSolution(final List<VectorContainer> vectorList) {
		for(VectorContainer vector : vectorList) {
			vector.checkVectorForTrivialSolution();
		}
	}

	private void checkMatrixForTrivialSolution(Map<MatrixKey, MatrixContainer> matrixMap) {
		for (MatrixKey key : matrixMap.keySet()) {
			MatrixContainer matrix = matrixMap.get(key);
			List<Integer> possibleValueList = matrix.getAvailableNumber();
			matrix.checkMatrixForTrivialSolution();
		}
	}
}
