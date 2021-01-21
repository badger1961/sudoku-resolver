package org.houseofbadger.sudoku.dataloader;

import org.houseofbadger.sudoku.model.AtomicCell;
import org.houseofbadger.sudoku.model.MainGameContainer;
import org.houseofbadger.sudoku.model.VectorContainer;
import org.houseofbadger.sudoku.solutions.SolutionsSeeker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OutputDataWriter {
    private static final Logger logger= LoggerFactory.getLogger(OutputDataWriter.class);
    List<String> outputContent = new ArrayList<>();
    public void saveMainGameContainer(MainGameContainer mainGameContainer, String outputFileName) {
        int lineSize = mainGameContainer.getLineSize();
        StringBuffer sb = new StringBuffer();
        List<VectorContainer> vectorRowList = mainGameContainer.getVectorContainerRowList();
        for (VectorContainer vectorContainer : vectorRowList) {
            for (int col = 0; col < lineSize; col++) {
                AtomicCell cell = vectorContainer.getAtomicCell(col);
                sb.append(cell.getValue() + ";");
            }
            outputContent.add(sb.toString());
            try {
                Files.write(Paths.get(outputFileName), outputContent);
            } catch (IOException e) {
                logger.error(e.getMessage());
                throw new DataLoaderException(e);
            }

            sb.delete(0, sb.length());
        }
    }
}
