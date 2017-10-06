package com.demo;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Define interface for Sudoku Puzzle
 * 
 * @author rhu
 *
 */
public interface Sudoku {
	/**
	 * Check whether the content of the file is valid sudoku puzzle
	 * 
	 * @param filePath Path the file path
	 * @return boolean
	 * @throws IOException
	 */
	public boolean isSudoku(Path filePath) throws IOException;
}
