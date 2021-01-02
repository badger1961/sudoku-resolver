package org.houseofbadger.sudoku.model;

import java.nio.file.Path;
import java.nio.file.Paths;

public class InputGameDataLoader {
	private final Path inputDataSet;
	
	public InputGameDataLoader(String inputDataSetName) {
		this.inputDataSet = Paths.get(inputDataSetName);
	}
	
	public void loadInputData() {
				
	}

	public Path getInputDataSet() {
		return inputDataSet;
	}
}
