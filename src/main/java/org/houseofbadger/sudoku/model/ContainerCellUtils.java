package org.houseofbadger.sudoku.model;

import org.houseofbadger.sudoku.solutions.SolutionsSeeker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContainerCellUtils {
    private final List<AtomicCell> atomicCellList;
    private static final Logger logger= LoggerFactory.getLogger(ContainerCellUtils.class);
    
    public ContainerCellUtils(List<AtomicCell> atomicCellList) {
    	this.atomicCellList = atomicCellList;
    }

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

    public void cleanPossibleValue() {
        List<Integer> usedNumber = this.getUsedNumber();
        for (AtomicCell atomicCell : this.atomicCellList) {
            if (atomicCell.getPossibleValue().size() == 0) {
                continue;
            }

            List<Integer> possibleNumber = atomicCell.getPossibleValue();
            possibleNumber.removeAll(usedNumber);
        }
    }

    public boolean makeTrivialSolution(List<Integer> possibleValueList) {
        List<AtomicCell> emptyCellList = this.atomicCellList.stream().filter( c -> c.getValue() == 0).collect(Collectors.toList());
        if (emptyCellList.size() == 0) {
            logger.info("Given line or column or minimatrix is completed");
            return false;
        }

        AtomicCell emptyCell = emptyCellList.get(0);
        if (emptyCellList.size() == 1) {
            emptyCell.setValue(possibleValueList.get(0));
        }

        return true;
    }

}
