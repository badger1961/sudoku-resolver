package org.houseofbadger.sudoku.dataloader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.houseofbadger.sudoku.model.AtomicCell;
import org.houseofbadger.sudoku.model.ContainerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputDataLoader {
	private static final Logger logger = LoggerFactory.getLogger(InputDataLoader.class);
	
	
	public List<List<AtomicCell>> loadData(final String inputDataSetName, final int matrixSize) {
		List<List<AtomicCell>> matrixContent = new ArrayList<>();
		List<List<Integer>> inputData = this.loadInputDataSet(inputDataSetName);
		for (int row = 0; row <  matrixSize; row++) {
			List<Integer> rowInputData = inputData.get(row);
			List<AtomicCell> rowData = new ArrayList<>();
			for (int column = 0; column < matrixSize; column++ ) {
				AtomicCell cell = new AtomicCell(column, row, rowInputData.get(column));
				rowData.add(cell);
			}
			
			matrixContent.add(rowData);
		}
		
		return matrixContent;
	}
	
	private List<List<Integer>> loadInputDataSet(final String inputDataSetName)  {
		Path inputDataSet = Paths.get(inputDataSetName);
		List<List<Integer>> content = new ArrayList<>();
		try {
			List<ArrayList<String>> buffer;
			logger.debug("Read Data from " + inputDataSet);
			List<String> dataSetContent = Files.readAllLines(inputDataSet);
			if (dataSetContent.size() != ContainerConstants.CONTAINER_LINE_MAX) {
				throw new DataLoaderException("Input data should contain 9 lines");
			}
			
			buffer = dataSetContent.stream().map(line -> new ArrayList<>(Arrays.asList(line.split(LoaderConstant.DATA_LOADER_LINE_DELIMETER)))).collect(Collectors.toList());
			
			for (List<String> numberList : buffer ) {
				content.add(numberList.stream().map(numStr -> Integer.valueOf(numStr)).collect(Collectors.toList()));
			}
			
			List<List<Integer>> badList;
			badList = content.stream().filter(list -> list.size() != ContainerConstants.CONTAINER_LINE_SIZE).collect(Collectors.toList());
			
			if (badList.size() != 0) {
				throw new DataLoaderException("Each line should contain 9 numbers");
			}
			
			return content;
			
		} catch (IOException e) {
			logger.error("Could not load data from file " + inputDataSetName);
			logger.error(e.getMessage());
			throw new DataLoaderException(e);
		} catch (NumberFormatException e) {
			logger.error("Data set should contain only numbers : " + inputDataSetName);
			logger.error(e.getMessage());
			throw new DataLoaderException(e.getMessage());
		}
	}
	
}
