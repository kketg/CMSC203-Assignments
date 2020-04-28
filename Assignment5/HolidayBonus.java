
/**
 * @author Kristofer Ter-Gabrielyan
 *	Calculates bonuses form given data sets
 */
public class HolidayBonus {
	
	//ROWS ARE STORES, COLUMNS ARE CATEGORIES
	
	/**
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @return bonuses array
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other){
		double[] bonuses = new double[data.length];
		for(int i = 0; i < data.length; i++) {
			double bonus = 0;
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j)) {
					bonus += low;
				}else if(data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
					bonus += high;
				}else {
					bonus += other;
				}
			}
			bonuses[i] = bonus;
		}
		return bonuses;
	}
	/**
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @return bonuses total
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double total = 0;
		for(int i = 0; i < data.length; i++) {
			double bonus = 0;
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j)) {
					bonus += low;
				}else if(data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
					bonus += high;
				}else {
					bonus += other;
				}
			}
			total += bonus;
		}
		return total;
	}
	
}
