/**
 * @author Kristofer Ter-Gabrielyan
 *
 */
public class Property {
	private String city, owner, propertyName;
	private double rentAmount;
	private Plot plot;

	public Property() {
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0;
		plot = new Plot();
	}

	public Property(Property p) {
		this.city = p.getCity();
		this.owner = p.getOwner();
		this.propertyName = p.getPropertyName();
		this.rentAmount = p.getRentAmount();
		this.plot = p.getPlot();
	}

	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		plot = new Plot();
	}

	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width,
			int depth) {
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		plot = new Plot(x, y, width, depth);
	}

	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return property name
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * @param propertyName
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * @return rent
	 */
	public double getRentAmount() {
		return rentAmount;
	}

	/**
	 * @param rentAmount
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	/**
	 * @return plot
	 */
	public Plot getPlot() {
		return plot;
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public void setPlot(int x, int y, int width, int depth) {
		plot.setX(x);
		plot.setY(y);
		plot.setWidth(width);
		plot.setDepth(depth);
	}

	/**
	 * @return string form
	 */
	public String toString() {
		return propertyName + " is in " + city + ", owned by " + owner + ". The rent is $" + rentAmount + ". \n Plot: "
				+ plot.toString();
	}

}
