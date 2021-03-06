package org.houseofbadger.sudoku.model;

import org.houseofbadger.sudoku.solutions.SolutionsSeeker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VectorContainer {
    private static final Logger logger = LoggerFactory.getLogger(VectorContainer.class);
    private final int idx;
    private final int vectorSize;
    private final ContainerCellUtils containerCellUtils;
    private final List<AtomicCell> atomicCellsList;
    private final VectorEnum vectorEnum;

    enum VectorEnum {
        ROW_MODE,
        COLUMN_MODE
    }

    public VectorContainer(int idx, List<List<AtomicCell>> vectorData, VectorEnum mode) {
        this.idx = idx;
        this.vectorSize = vectorData.size();
        if (mode == VectorEnum.ROW_MODE) {
            this.atomicCellsList = this.rowVectorContainerFactory(vectorData);
        } else if (mode == VectorEnum.COLUMN_MODE) {
            this.atomicCellsList = this.columnVectorContainerFactory(vectorData);
        } else {
            throw new ContainerException("Invalid mode of vector creation");
        }

        this.vectorEnum = mode;
        this.containerCellUtils = new ContainerCellUtils(this.atomicCellsList);
    }

    public List<AtomicCell> getEmptyAtomicCellList() {
        List<AtomicCell> emptyCellList = this.containerCellUtils.getEmptyAtomicCellList();
        return emptyCellList;
    }

    public List<AtomicCell> getCellWithTrivialPossibleValues() {
        var trivialAtomicList = this.containerCellUtils.getCellWithTrivialPossibleValues();
        return trivialAtomicList;
    }

    public void cleanPossibleValue() {
        this.containerCellUtils.cleanPossibleValue();
    }

    public String getIdx() {
        if (this.vectorEnum == VectorEnum.ROW_MODE) {
            return "Row : " + idx;
        } else if (this.vectorEnum == VectorEnum.COLUMN_MODE) {
            return "Column : " + idx;
        } else {
            logger.error("Hmm ... Strange mode should be row or column");
            return "Unknown";
        }
    }

    public int getVectorSize() {
        return vectorSize;
    }

    public List<AtomicCell> getAtomicCellsList() {
        return this.atomicCellsList;
    }

    public AtomicCell getAtomicCell(int x) {
        AtomicCell cell = this.atomicCellsList.get(x);
        return cell;
    }

    public int getValueAtomicCell(int x) {
        AtomicCell cell = this.getAtomicCell(x);
        return cell.getValue();
    }

    public List<Integer> getPossibleValueAtomicCell(int x) {
        AtomicCell cell = getAtomicCell(x);
        return cell.getPossibleValue();
    }

    public void resetPossibleValueAtomicCell(int x, int value) {
        AtomicCell cell = getAtomicCell(x);
        cell.resetPossibleValue(value);
    }

    public List<Integer> getUsedNumber() {
        return this.containerCellUtils.getUsedNumber();
    }

    public List<Integer> getAvailableNumber() {
        return this.containerCellUtils.getAvailableNumber();
    }


    @Override
    public String toString() {
        return "VectorContainer{" +
                "idx=" + idx +
                ", vectorSize=" + vectorSize +
                ", containerCellUtils=" + containerCellUtils +
                ", atomicCellsList=" + atomicCellsList +
                '}';
    }

    private List<AtomicCell> rowVectorContainerFactory(List<List<AtomicCell>> vectorData) {
        List<AtomicCell> buffer = vectorData.get(this.idx);
        return buffer;
    }

    private List<AtomicCell> columnVectorContainerFactory(List<List<AtomicCell>> vectorData) {
        List<AtomicCell> buffer = new ArrayList<>();
        for (int row = 0; row < this.vectorSize; row++) {
            AtomicCell cell = vectorData.get(row).get(this.idx);
            buffer.add(cell);
        }

        return buffer;
    }
}
