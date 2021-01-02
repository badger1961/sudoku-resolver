package org.houseofbadger.sudoku.dataloader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Test;

public class InputDataLoaderTest {
	
//	0;0;0;0;0;0;0;0;0
//	6;2;1;0;0;0;0;0;0
//	3;0;9;0;0;0;0;4;0
//	8;0;0;0;3;4;0;5;0
//	0;0;0;0;0;5;0;0;2
//	7;6;0;0;0;2;0;1;0
//	9;7;6;0;2;0;0;0;1
//	2;1;0;0;8;0;7;6;5
//	4;5;8;0;6;1;9;2;3	
  @Test
  public void loadInputDataTest() {
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
	  InputDataLoader dataLoader = new InputDataLoader(dataSetName);
	  dataLoader.loadInputData();
	  List<List<Integer>> data = dataLoader.getContent();
	  int i = 0;
	  for (List<Integer> list : data ) {
		  Assert.assertEquals(list, expectedData.get(i));
		  i++;
	  }
  }
  
  @Test(expectedExceptions = DataLoaderException.class)
  public void loadInputDataTest2() {
	  String dataSetName = "src/test/resources/positive2.txt";
	  InputDataLoader dataLoader = new InputDataLoader(dataSetName);
	  dataLoader.loadInputData();
  }
  
  @Test(expectedExceptions = DataLoaderException.class)
  public void loadInputDataTest3() {
	  String dataSetName = "src/test/resources/negative1.txt";
	  InputDataLoader dataLoader = new InputDataLoader(dataSetName);
	  dataLoader.loadInputData();
  }
  
  @Test(expectedExceptions = DataLoaderException.class)
  public void loadInputDataTest4() {
	  String dataSetName = "src/test/resources/negative2.txt";
	  InputDataLoader dataLoader = new InputDataLoader(dataSetName);
	  dataLoader.loadInputData();
  }
  
  @Test(expectedExceptions = DataLoaderException.class)
  public void loadInputDataTest5() {
	  String dataSetName = "src/test/resources/negative3.txt";
	  InputDataLoader dataLoader = new InputDataLoader(dataSetName);
	  dataLoader.loadInputData();
  }
}
