package org.houseofbadger.sudoku.model;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainGameContainerTest {

  @Test
  public void getMatrixContainerTest() { 
	  MainGameContainer mainGameContainer = new MainGameContainer();
	  Map<MatrixKey, MatrixContainer> matrixMap = mainGameContainer.getMatrixContainerMap();
	  MatrixContainer m = matrixMap.get(new MatrixKey(0,0));
	  Assert.assertEquals(0, m.getLeftCornerColumn());
	  Assert.assertEquals(0, m.getLeftCornerLine());
  }
}
