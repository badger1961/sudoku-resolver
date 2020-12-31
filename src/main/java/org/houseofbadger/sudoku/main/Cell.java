package org.houseofbadger.sudoku.main;

public class Cell {
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value < 1) {

        }
        if (value > 9) {

        }
        this.value = value;
    }

    private int value;
    private int [] possibleValues;


}
