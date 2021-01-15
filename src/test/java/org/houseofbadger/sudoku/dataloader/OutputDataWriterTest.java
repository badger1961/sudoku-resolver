package org.houseofbadger.sudoku.dataloader;

import org.houseofbadger.sudoku.model.AtomicCell;
import org.houseofbadger.sudoku.model.MainGameContainer;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class OutputDataWriterTest {

    @Test
    public void saveMainGameContainerTest() throws IOException  {
        ArrayList<Integer> line1 = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0,0));
        ArrayList<Integer> line2 = new ArrayList<>(Arrays.asList(6,2,1,0,0,0,0,0,0));
        ArrayList<Integer> line3 = new ArrayList<>(Arrays.asList(3,0,9,0,0,0,0,4,0));
        ArrayList<Integer> line4 = new ArrayList<>(Arrays.asList(8,0,0,0,3,4,0,5,0));
        ArrayList<Integer> line5 = new ArrayList<>(Arrays.asList(0,0,0,0,0,5,0,0,2));
        ArrayList<Integer> line6 = new ArrayList<>(Arrays.asList(7,6,0,0,0,2,0,1,0));
        ArrayList<Integer> line7 = new ArrayList<>(Arrays.asList(9,7,6,0,2,0,0,0,1));
        ArrayList<Integer> line8 = new ArrayList<>(Arrays.asList(2,1,0,0,8,0,7,6,5));
        ArrayList<Integer> line9 = new ArrayList<>(Arrays.asList(4,5,8,0,6,1,9,2,3));
        List<List<Integer>> expectedData = new ArrayList<>();
        expectedData.add(line1);
        expectedData.add(line2);
        expectedData.add(line3);
        expectedData.add(line4);
        expectedData.add(line5);
        expectedData.add(line6);
        expectedData.add(line7);
        expectedData.add(line8);
        expectedData.add(line9);

        String dataSetName = "src/test/resources/positive.txt";
        String outputDataSetName = "src/test/resources/output.txt";
        InputDataLoader dataLoader = new InputDataLoader();
        List<List<AtomicCell>> data = dataLoader.loadData(dataSetName, 9);
        MainGameContainer mainGameContainer = new MainGameContainer(data,3,9);
        OutputDataWriter outputDataWriter = new OutputDataWriter();
        outputDataWriter.saveMainGameContainer(mainGameContainer, outputDataSetName);
        byte [] original = Files.readAllBytes(Paths.get(dataSetName));
        byte [] saved = Files.readAllBytes(Paths.get(outputDataSetName));
    }
}