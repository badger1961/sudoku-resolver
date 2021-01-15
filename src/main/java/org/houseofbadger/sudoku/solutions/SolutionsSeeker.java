package org.houseofbadger.sudoku.solutions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		this.checkLine(vectorColumnList, mainGameContainer.getLineSize());
		this.checkLine(vectorRowList, mainGameContainer.getLineSize());
		this.checkMatrix(matrixMap, mainGameContainer.getMatrixSize());
		logger.debug("end finding trivial solutions");
	}

	private void checkLine(final List<VectorContainer> vectorList, int lineSize) {
		for(VectorContainer vector : vectorList) {
			List<AtomicCell> emptyCell = vector.getAtomicCellsList().stream().filter( c -> c.getValue() == 0).collect(Collectors.toList());
			if (emptyCell.size() == 1) {
				List<Integer> possibleValueList = vector.getAvailableNumber();
				emptyCell.get(0).setValue(possibleValueList.get(0));
				logger.debug(vector.toString());
			}
		}
	}

	private void checkMatrix(Map<MatrixKey, MatrixContainer> matrixMap, int matrixSize) {

	}

}
