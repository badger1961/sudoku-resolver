package org.houseofbadger.sudoku.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractContainerCells {
    private List<AtomicCell> atomicCellList;

    public List<Integer> getUsedNumber() {
        List<AtomicCell> usedCell = this.atomicCellList.stream().filter((c) -> c.getValue() != 0).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        usedCell.stream().forEach((c) -> result.add(c.getValue()));
        return result;
    }

    public List<Integer> getAvailableNumber() {
        List<Integer> usedNumber = this.getUsedNumber();
        List<Integer> allNumber = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        return allNumber.stream().filter(number -> !usedNumber.contains(number)).collect(Collectors.toList());
    }
}
