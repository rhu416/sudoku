package com.demo;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * SudokuPuzzle, an implementation the interface Sudoku to check
 * the file content is valid sudoku puzzle.
 * 
 * @author rhu
 *
 */
public class SudokuPuzzle implements Sudoku {

	/**
	 * Check whether the content of the file is valid sudoku puzzle
	 * 
	 * @param filePath Path the file path
	 * @return boolean
	 * @throws IOException
	 */
	@Override
	public boolean isSudoku(Path filePath) throws IOException {
		if (filePath == null) {
			return false;
		}


		// read content from file into stream
		try (Stream<String> lines = Files.lines(filePath, Charset.defaultCharset())) {

			// load the content of text file into buffer, a matrix of integer.
			List<List<Integer>> matrix = lines.filter( s -> !s.trim().isEmpty())
					.map( s -> Pattern.compile("").splitAsStream(s).map(Integer::valueOf).collect(toList()) ) // convert each line into List of Integer
					.collect(toList());
			
			int len = matrix.size();
			if (len == 0) {
				return false;
			}


			// Create a sorted number string of Sudoku line based on how many line in the text file
			// such as "123456789"
			StringBuilder sb = new StringBuilder();
			for (int i=1; i < len + 1; i++) {
				sb.append(i);
			}
			final String rangeStr = sb.toString();


			// Check each row 
			Optional<Boolean> isValid = matrix.stream()
				.map(intList -> {
					StringBuilder strb = new StringBuilder();
					for (Integer i : intList) {
						strb.append(i);
					}
					System.out.println("before sorted, row: " + strb.toString());
					Optional<String> ostr = intList.stream().sorted().map(String::valueOf).reduce( (a, b) -> a + b );
					if (ostr.isPresent()) {
						System.out.println("after sorted row: " + ostr.get());
						if (rangeStr.equals(ostr.get())) {
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}
				}).reduce( (a, b) -> a && b );

			if (isValid.isPresent()) {
				if (!isValid.get()) {
					return false;
				}
			} else {
				return false;
			}


			// Check each column
			for (int idx1 = 0; idx1 < len; idx1++) {
				List<Integer> list = new ArrayList<>();
				for (int idx2 = 0; idx2 < len; idx2++) {
					list.add(matrix.get(idx2).get(idx1));
				}

				StringBuilder strb = new StringBuilder();
				for (Integer i : list) {
					strb.append(i);
				}
				System.out.println("before sort column " + idx1 + ": " + strb.toString());

				Optional<String> ostr = list.stream().sorted().map(String::valueOf).reduce( (a, b) -> a + b);
				if (ostr.isPresent()) {
					System.out.println("after sort column " + idx1 + ": " + ostr.get());
					if (!rangeStr.equals(ostr.get())) {
						return false;
					}
				} else {
					return false;
				}
			}
		} catch(NumberFormatException ne) {
			System.out.println("File contain invalid number string");
			return false;
		} catch(IOException ioe) {
			System.out.println("Failed to read file: " + filePath.getFileName().toString());
			throw ioe;
		}
		return true;
	}

}
