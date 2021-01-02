package org.houseofbadger.sudoku.dataloader;

public class DataLoaderException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8705562793833183815L;

	public DataLoaderException(Throwable t) {
		super(t);
	}
	
	public DataLoaderException(String message) {
		super(message);
	}
}
