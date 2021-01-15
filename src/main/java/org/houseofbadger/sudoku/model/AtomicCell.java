package org.houseofbadger.sudoku.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AtomicCell {
    private static final Logger logger = LoggerFactory.getLogger(AtomicCell.class);
    private int value;
    private List<Integer> possibleValues;
    private int xPos;
    private int yPos;
    private boolean isFinal;

    public AtomicCell(int xPos, int yPos, int value) {
        checkValue(value);
        checkPosition(xPos);
        checkPosition(yPos);
        this.value = value;
        this.xPos = xPos;
        this.yPos = yPos;
        if (value != 0) {
            this.isFinal = true;
            this.possibleValues = new ArrayList<>();
        } else {
            this.possibleValues = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
            this.isFinal = false;
        }
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.checkValue(value);
        this.value = value;
    }

    public void resetValue() {
        this.setValue(0);
    }

    public void resetPossibleValue(int value) {
        checkPosition(value);
        this.possibleValues = this.possibleValues.stream().filter(c -> c != value).collect(Collectors.toList());
    }

    public List<Integer> getPossibleValue() {
        return this.possibleValues;
    }

    public int getXPos( ) {
        return this.xPos;
    }

    public int getYPos() {
        return this.yPos;
    }

    private void checkValue(int checked) {
        if (checked < 0 || checked > 9) {
            throw new IllegalArgumentException("Value should be in range 1..9 Actual is " + checked);
        }
    }

    private void checkPosition(int checked) {
        if (checked < 0 || checked > 8) {
            throw new IllegalArgumentException("Position should be in range 0..8 Actual is " + checked);
        }
    }

    @Override
    public String toString() {
        return "AtomicCell{" +
                "value=" + value +
                ", possibleValues=" + possibleValues +
                ", xPos=" + xPos +
                ", yPos=" + yPos +
                ", isFinal=" + isFinal +
                '}';
    }
}
