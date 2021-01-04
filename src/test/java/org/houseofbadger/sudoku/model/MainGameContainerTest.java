package org.houseofbadger.sudoku.model;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainGameContainerTest {

  @Test
  public void getMatrixContainerTest1() { 
	  MainGameContainer mainGameContainer = new MainGameContainer(3,9);
	  Map<MatrixKey, MatrixContainer> matrixMap = mainGameContainer.getMatrixContainerMap();
	  MatrixContainer m = matrixMap.get(new MatrixKey(0,0));
	  Assert.assertEquals(0, m.getLeftCornerColumn());
	  Assert.assertEquals(0, m.getLeftCornerLine());
  }
  
  @Test
  public void getMatrixContainerTest2() { 
	  MainGameContainer mainGameContainer = new MainGameContainer(3,9);
	  Map<MatrixKey, MatrixContainer> matrixMap = mainGameContainer.getMatrixContainerMap();
	  MatrixContainer m = matrixMap.get(new MatrixKey(0,3));
	  Assert.assertEquals(0, m.getLeftCornerColumn());
	  Assert.assertEquals(3, m.getLeftCornerLine());
  }
  
  @Test
  public void getMatrixContainerTest3() { 
	  MainGameContainer mainGameContainer = new MainGameContainer(3,9);
	  Map<MatrixKey, MatrixContainer> matrixMap = mainGameContainer.getMatrixContainerMap();
	  MatrixContainer m = matrixMap.get(new MatrixKey(0,6));
	  Assert.assertEquals(0, m.getLeftCornerColumn());
	  Assert.assertEquals(6, m.getLeftCornerLine());
  }
  
  
  @Test
  public void getMatrixContainerTest4() { 
	  MainGameContainer mainGameContainer = new MainGameContainer(3,9);
	  Map<MatrixKey, MatrixContainer> matrixMap = mainGameContainer.getMatrixContainerMap();
	  MatrixContainer m = matrixMap.get(new MatrixKey(3,0));
	  Assert.assertEquals(3, m.getLeftCornerColumn());
	  Assert.assertEquals(0, m.getLeftCornerLine());
  }
  
  @Test
  public void getMatrixContainerTest5() { 
	  MainGameContainer mainGameContainer = new MainGameContainer(3,9);
	  Map<MatrixKey, MatrixContainer> matrixMap = mainGameContainer.getMatrixContainerMap();
	  MatrixContainer m = matrixMap.get(new MatrixKey(3,3));
	  Assert.assertEquals(3, m.getLeftCornerColumn());
	  Assert.assertEquals(3, m.getLeftCornerLine());
  }
  
  @Test
  public void getMatrixContainerTest6() { 
	  MainGameContainer mainGameContainer = new MainGameContainer(3,9);
	  Map<MatrixKey, MatrixContainer> matrixMap = mainGameContainer.getMatrixContainerMap();
	  MatrixContainer m = matrixMap.get(new MatrixKey(3,6));
	  Assert.assertEquals(3, m.getLeftCornerColumn());
	  Assert.assertEquals(6, m.getLeftCornerLine());
  }
  
  @Test
  public void getMatrixContainerTest7() { 
	  MainGameContainer mainGameContainer = new MainGameContainer(3,9);
	  Map<MatrixKey, MatrixContainer> matrixMap = mainGameContainer.getMatrixContainerMap();
	  MatrixContainer m = matrixMap.get(new MatrixKey(6,0));
	  Assert.assertEquals(6, m.getLeftCornerColumn());
	  Assert.assertEquals(0, m.getLeftCornerLine());
  }
  
  @Test
  public void getMatrixContainerTest8() { 
	  MainGameContainer mainGameContainer = new MainGameContainer(3,9);
	  Map<MatrixKey, MatrixContainer> matrixMap = mainGameContainer.getMatrixContainerMap();
	  MatrixContainer m = matrixMap.get(new MatrixKey(6,3));
	  Assert.assertEquals(6, m.getLeftCornerColumn());
	  Assert.assertEquals(3, m.getLeftCornerLine());
  }
  
  @Test
  public void getMatrixContainerTest9() { 
	  MainGameContainer mainGameContainer = new MainGameContainer(3,9);
	  Map<MatrixKey, MatrixContainer> matrixMap = mainGameContainer.getMatrixContainerMap();
	  MatrixContainer m = matrixMap.get(new MatrixKey(6,6));
	  Assert.assertEquals(6, m.getLeftCornerColumn());
	  Assert.assertEquals(6, m.getLeftCornerLine());
  }
}
