package org.houseofbadger.sudoku.main;

import java.io.File;
import java.util.List;

import org.houseofbadger.sudoku.dataloader.InputDataLoader;
import org.houseofbadger.sudoku.model.AtomicCell;
import org.houseofbadger.sudoku.model.MainGameContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger logger= LoggerFactory.getLogger(Application.class);
    public void initialize() {
        logger.debug("Start sudoku resolver application initialization");
        logger.debug("End sudoku resolver application initialization");
    }

    public void run(File dataFile) {
        logger.debug("Start Loading input data for sudoku resolver application");
        InputDataLoader inputDataLoader = new InputDataLoader();
        List<List<AtomicCell>> dataSet = inputDataLoader.loadData("src/test/resources/positive.txt", 9);
        MainGameContainer mainGameContainer = new MainGameContainer(dataSet, 3, 9);
        logger.debug("End Loading input data for sudoku resolver application");
        logger.debug("Start Resolving");
        logger.debug("End Resolving");
    }
}
