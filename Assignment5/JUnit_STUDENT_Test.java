import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

public class JUnit_STUDENT_Test {
	//STUDENT fill in dataSetSTUDENTSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT = null;
	private double[][] dataSetSTUDENT2 = null;
	
	private File inputFile,inputFile2, outputFile, outputFile2;

	@Before
	public void setUp() throws Exception {
		inputFile = new File("res/TestIn.txt");
		inputFile2 = new File("res/TestIn2.txt");
		outputFile = new File("res/TestOut.txt");
		outputFile2 = new File("res/TestOut2.txt");
		dataSetSTUDENT = TwoDimRaggedArrayUtility.readFile(inputFile);
		dataSetSTUDENT2 = TwoDimRaggedArrayUtility.readFile(inputFile2);
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		dataSetSTUDENT2 = null;
		inputFile = inputFile2 = outputFile = outputFile2 = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(45, TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT), 0.001);	
		assertEquals(121, TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT2), 0.001);	
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(5, TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT),0.001);
		assertEquals(9.308, TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT2),0.001);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(9, TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 1),0.001);
		assertEquals(10, TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT2, 1),0.001);
	}
	/**
	 * Student Test getHighestInRow method
	 * Return the highest element of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetHighestInRow() {
		assertEquals(5, TwoDimRaggedArrayUtility.getHighestInRow(dataSetSTUDENT, 1),0.001);
		assertEquals(34, TwoDimRaggedArrayUtility.getHighestInRow(dataSetSTUDENT2, 2),0.001);
	}
	/**
	 * Student Test getLowestInRow method
	 * Return the lowest element of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetLowestInRow() {
		assertEquals(6, TwoDimRaggedArrayUtility.getLowestInRow(dataSetSTUDENT, 2),0.001);
		assertEquals(4, TwoDimRaggedArrayUtility.getLowestInRow(dataSetSTUDENT2, 2),0.001);
	}
	/**
	 * Student Test getHighestInColumn method
	 * Return the highest element of the column.
	 * 
	 */
	@Test
	public void testGetHighestInColumn() {
		assertEquals(7, TwoDimRaggedArrayUtility.getHighestInColumn(dataSetSTUDENT, 1),0.001);
		assertEquals(7, TwoDimRaggedArrayUtility.getHighestInColumn(dataSetSTUDENT2, 1),0.001);
	}
	/**
	 * Student Test getLowestInColumn method
	 * Return the lowest element of the column.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetLowestInColumn() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumn(dataSetSTUDENT, 0),0.001);
		assertEquals(5, TwoDimRaggedArrayUtility.getLowestInColumn(dataSetSTUDENT2, 2),0.001);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(11, TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 2), 0.001);
		assertEquals(46, TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT2, 2), 0.001);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(9, TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),0.001);
		assertEquals(9, TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),0.001);
	}
	
	/**
	 * Student Test getLowestInArray method
	 * Return the smallest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetLowestInArray() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInArray(dataSetSTUDENT),0.001);
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInArray(dataSetSTUDENT2),0.001);
	}

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() {
		TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT, outputFile);	
		assertArrayEquals(dataSetSTUDENT,TwoDimRaggedArrayUtility.readFile(outputFile));
		TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT2, outputFile2);	
		assertArrayEquals(dataSetSTUDENT2,TwoDimRaggedArrayUtility.readFile(outputFile2));
	}

}
