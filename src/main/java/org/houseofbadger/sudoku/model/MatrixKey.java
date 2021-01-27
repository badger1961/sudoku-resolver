package org.houseofbadger.sudoku.model;

public final class MatrixKey {
	final int leftLine;
	final int leftColumn;
	
	public MatrixKey(int column, int line) {
		this.leftLine = line;
		this.leftColumn = column;
	}

	public int getLeftLine() {
		return leftLine;
	}

	public int getLeftColumn() {
		return leftColumn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + leftColumn;
		result = prime * result + leftLine;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatrixKey other = (MatrixKey) obj;
		if (leftColumn != other.leftColumn)
			return false;
		if (leftLine != other.leftLine)
			return false;
		return true;
	}
}
