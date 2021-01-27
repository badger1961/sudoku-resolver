package org.houseofbadger.sudoku.main;

import java.io.File;
import java.util.List;

import org.houseofbadger.sudoku.dataloader.InputDataLoader;
import org.houseofbadger.sudoku.dataloader.OutputDataWriter;
import org.houseofbadger.sudoku.model.AtomicCell;
import org.houseofbadger.sudoku.model.MainGameContainer;
import org.houseofbadger.sudoku.solutions.SolutionsSeeker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger logger= LoggerFactory.getLogger(Application.class);
    public void initialize() {
        logger.debug("Start sudoku resolver application initialization");
        logger.debug("End sudoku resolver application initialization");
    }

    public void run(String dataSetName, String outputDataSetName) {
        logger.debug("Start Loading input data for sudoku resolver application");
        InputDataLoader inputDataLoader = new InputDataLoader();
        List<List<AtomicCell>> dataSet = inputDataLoader.loadData(dataSetName, 9);
        MainGameContainer mainGameContainer = new MainGameContainer(dataSet, 3, 9);
        logger.debug("End Loading input data for sudoku resolver application");
        logger.debug("Start Resolving");
        SolutionsSeeker solutionsSeeker = new SolutionsSeeker();
        solutionsSeeker.seekGameSolution(mainGameContainer);
        logger.debug("End Resolving");
        logger.debug("saving result");
        OutputDataWriter outputDataWriter = new OutputDataWriter();
        outputDataWriter.saveMainGameContainer(mainGameContainer, outputDataSetName);
        logger.debug("end saving");
    }
}
