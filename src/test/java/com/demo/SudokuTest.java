package com.demo;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

public class SudokuTest {
	protected Sudoku sudoku = new SudokuPuzzle();

	/**
	 * Test the text file contains the content that is valid sudoku puzzle
	 */
	@Test
	public void testIsSudokuTrue() {
		try {
			Path path = Paths.get(Sudoku.class.getClassLoader().getResource("input_sudoku.txt").toURI());
			boolean isValid = sudoku.isSudoku(path);
			Assert.assertTrue(isValid);
		} catch(Exception e) {
			Assert.fail("TestCase testIsSudokuTrue, unexpected exception: " + e.getMessage());
		}
	}

	/**
	 * Test the text file contains the content that is invalid sudoku puzzle
	 */
	@Test
	public void testIsSudokuFalse() {
		try {
			Path path = Paths.get(Sudoku.class.getClassLoader().getResource("input_sudoku_invalid.txt").toURI());
			boolean isValid = sudoku.isSudoku(path);
			Assert.assertFalse(isValid);
		} catch(Exception e) {
			Assert.fail("TestCase testIsSudokuTrue, unexpected exception: " + e.getMessage());
		}
	}
	
	/**
	 * Test the text file contains the content that include non-numeric characters.
	 */
	@Test
	public void testIsSudokuFalseNonNumberic() {
		try {
			Path path = Paths.get(Sudoku.class.getClassLoader().getResource("input_sudoku_non_numeric.txt").toURI());
			boolean isValid = sudoku.isSudoku(path);
			Assert.assertFalse(isValid);
		} catch(Exception e) {
			Assert.fail("TestCase testIsSudokuTrue, unexpected exception: " + e.getMessage());
		}
	}
}
