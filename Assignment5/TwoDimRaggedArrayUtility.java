import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @author Kristofer Ter-Gabrielyan
 *	Utility class for working with 2d arrays
 */
public class TwoDimRaggedArrayUtility {
	/**
	 * @param data
	 * @return average of values
	 */
	public static double getAverage(double[][] data) {
		double sum = 0;
		int amount = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				sum += data[i][j];
				amount++;
			}
		}
		return sum / amount;
	}

	/**
	 * @param data
	 * @param col
	 * @return total in col
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > col) {
				total += data[i][col];
			}
		}
		return total;
	}

	/**
	 * @param data
	 * @return highest in data
	 */
	public static double getHighestInArray(double[][] data) {
		double highest = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] > highest) {
					highest = data[i][j];
				}
			}
		}
		return highest;
	}

	/**
	 * @param data
	 * @param col
	 * @return highest in col
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > col) {
				if (data[i][col] > highest) {
					highest = data[i][col];
				}
			}

		}
		return highest;
	}

	/**
	 * @param data
	 * @param col
	 * @return index of highest in col
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highest = 0;
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > col) {
				if (data[i][col] > highest) {
					highest = data[i][col];
					index = i;
				}
			}

		}
		return index;
	}

	/**
	 * @param data
	 * @param row
	 * @return highest in row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highest = 0;
		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] > highest) {
				highest = data[row][i];
			}

		}
		return highest;
	}

	/**
	 * @param data
	 * @param row
	 * @return index of highest row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highest = 0;
		int index = 0;
		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] > highest) {
				highest = data[row][i];
				index = i;
			}

		}
		return index;
	}

	/**
	 * @param data
	 * @return lowest value in data
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest = 999999999999.0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] < lowest) {
					lowest = data[i][j];
				}
			}
		}
		return lowest;
	}

	/**
	 * @param data
	 * @param col
	 * @return lowest in col
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = 999999999999.0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > col) {
				if (data[i][col] < lowest) {
					lowest = data[i][col];
				}
			}

		}
		return lowest;
	}

	/**
	 * @param data
	 * @param col
	 * @return index of lowest in col
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowest = 999999999999.0;
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > col) {
				if (data[i][col] < lowest) {
					lowest = data[i][col];
					index = i;
				}
			}

		}
		return index;
	}

	/**
	 * @param data
	 * @param row
	 * @return lowest in row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = 999999999999.0;
		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] < lowest) {
				lowest = data[row][i];
			}

		}
		return lowest;
	}

	/**
	 * @param data
	 * @param row
	 * @return index of lowest in row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowest = 999999999999.0;
		int index = 0;
		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] < lowest) {
				lowest = data[row][i];
				index = i;
			}

		}
		return index;
	}

	/**
	 * @param data
	 * @param row
	 * @return total of row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double total = 0;
		for (int i = 0; i < data[row].length; i++) {
			total += data[row][i];
		}
		return total;
	}
	/**
	 * @param data
	 * @return total of data
	 */
	public static double getTotal(double[][] data) {
		double total = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				total += data[i][j];
			}
		}
		return total;
	}
	/**
	 * @param file
	 * @return data in file
	 */
	public static double[][] readFile(File file){
		Scanner sc;
		
		try {
			sc = new Scanner(file);
			FileReader fr = new FileReader(file);
			BufferedReader textReader = new BufferedReader(fr);
			int rows=0;
			String currentRow;
			while((currentRow = textReader.readLine()) != null) {
				rows++;
			}
			
			double[][] array = new double[rows][];
			fr = new FileReader(file);
			textReader = new BufferedReader(fr);
			
			for(int i = 0; i < array.length;i++) {
				String columnArray[] = textReader.readLine().split(" ");
				array[i] = new double[columnArray.length];
				for(int j = 0; j < columnArray.length; j++) {
					array[i][j] = Double.parseDouble(columnArray[j]);
				}
			}
			fr.close();
			textReader.close();
			sc.close();
			
			return array;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("COULDN'T READ FILE");
			return null;
		}
		
	}
	/**
	 * @param data
	 * @param outputFile
	 */
	public static void writeToFile(double[][] data, File outputFile) {
		FileWriter wr;
		try {
			wr = new FileWriter(outputFile);
			for(int i = 0; i < data.length; i++) {
				for(int j = 0; j < data[i].length;j++) {
					wr.append(String.valueOf(data[i][j]) + " ");
				}
				wr.append("\n");
			}
			wr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("COULDN'T GET FILE");
		}
		
	}

}
