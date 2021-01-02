package org.houseofbadger.sudoku.dataloader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.houseofbadger.sudoku.main.Application;
import org.houseofbadger.sudoku.model.ContainerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputDataLoader {
	private final Path inputDataSet;
	private final List<List<Integer>> content;
	private static final Logger logger= LoggerFactory.getLogger(InputDataLoader.class);
	
	public List<List<Integer>> getContent() {
		return content;
	}

	public InputDataLoader(String inputDataSetName) {
		this.inputDataSet = Paths.get(inputDataSetName);
		this.content = new ArrayList<>();
	}
	
	public void loadInputData()  {
		try {
			List<ArrayList<String>> buffer;
			logger.debug("Read Data from " + this.inputDataSet);
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
			
		} catch (IOException e) {
			logger.error("Could not load data from file " + this.inputDataSet);
			logger.error(e.getMessage());
			throw new DataLoaderException(e);
		} catch (NumberFormatException e) {
			logger.error("Data set should contain only numbers : " + this.inputDataSet);
			logger.error(e.getMessage());
			throw new DataLoaderException(e.getMessage());
		}
	}
}
