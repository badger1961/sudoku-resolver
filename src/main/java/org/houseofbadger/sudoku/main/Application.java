package org.houseofbadger.sudoku.main;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger logger= LoggerFactory.getLogger(Application.class);
    public void initialize() {
        logger.debug("Start sudoku resolver application initialization");
        logger.debug("End sudoku resolver application initialization");
    }

    public void loadInputTable(File dataFile) {
        logger.debug("Start Loading input data for sudoku resolver application");
        logger.debug("End Loading input data for sudoku resolver application");
    }

    public void findSolution() {
        logger.debug("Start Resolving");
        logger.debug("End Resolving");
    }
    

}
