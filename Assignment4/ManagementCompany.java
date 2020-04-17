/**
 * @author Kristofer Ter-Gabrielyan
 *
 */
public class ManagementCompany {
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private Plot plot;

	public ManagementCompany() {
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		name = "";
		taxID = "";
		properties = new Property[MAX_PROPERTY];
	}

	/**
	 * @param otherCompany
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		mgmFeePer = otherCompany.getMgmFeePer();
		name = otherCompany.getName();
		properties = new Property[MAX_PROPERTY];
		for (int i = 0; i < otherCompany.getProperties().length; i++) {
			properties[i] = otherCompany.getProperties()[i];
		}
		taxID = otherCompany.getTaxID();
		plot = otherCompany.getPlot();
	}

	/**
	 * @param name
	 * @param taxID
	 * @param mgmFeePer
	 */
	public ManagementCompany(String name, String taxID, double mgmFeePer) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}

	/**
	 * @param name
	 * @param taxID
	 * @param mgmFeePer
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}

	/**
	 * @param p
	 * @return index of new property
	 */
	public int addProperty(Property p) {
		int index = 0;
		boolean isFull = true;
		for (Property prop : properties) {
			if (prop == null) {
				isFull = false;
			}
		}
		boolean encompasses = false;
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] != null) {
				if (p.getPlot().encompasses(properties[i].getPlot())) {
					encompasses = true;
				}
			}
		}
		if (isFull == true) {
			return -1;
		} else if (p == null) {
			return -2;
		} else if (this.plot.encompasses(p.getPlot()) == false) {
			return -3;
		} else if (encompasses == true) {
			return -4;
		} else {
			Property[] newArr = new Property[properties.length];
			for (int i = 0; i < properties.length; i++) {
				if (properties[i] != null) {
					newArr[i] = properties[i];
				} else {
					index = i;
					break;
				}
			}
			newArr[index] = p;
			properties = new Property[newArr.length];
			for (int i = 0; i < newArr.length; i++) {
				properties[i] = newArr[i];
			}
			return index;
		}

	}

	/**
	 * @param propertyName
	 * @param city
	 * @param rent
	 * @param ownerName
	 * @return index of new property
	 */
	public int addProperty(String propertyName, String city, double rent, String ownerName) {
		Property p = new Property(propertyName, city, rent, ownerName);
		int index = 0;
		boolean isFull = true;
		for (Property prop : properties) {
			if (prop == null) {
				isFull = false;
			}
		}
		boolean encompasses = false;
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] != null) {
				if (p.getPlot().encompasses(properties[i].getPlot())) {
					encompasses = true;
				}
			}
		}
		if (isFull == true) {
			return -1;
		} else if (p == null) {
			return -2;
		} else if (this.plot.encompasses(p.getPlot()) == false) {
			return -3;
		} else if (encompasses == true) {
			return -4;
		} else {
			Property[] newArr = new Property[properties.length];
			for (int i = 0; i < properties.length; i++) {
				if (properties[i] != null) {
					newArr[i] = properties[i];
				} else {
					index = i;
					break;
				}
			}
			newArr[index] = p;
			properties = new Property[newArr.length];
			for (int i = 0; i < newArr.length; i++) {
				properties[i] = newArr[i];
			}
			return index;
		}

	}

	/**
	 * @param propertyName
	 * @param city
	 * @param rent
	 * @param ownerName
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return index of new property
	 */
	public int addProperty(String propertyName, String city, double rent, String ownerName, int x, int y, int width,
			int depth) {
		Property p = new Property(propertyName, city, rent, ownerName, x, y, width, depth);
		int index = 0;
		boolean isFull = true;
		for (Property prop : properties) {
			if (prop == null) {
				isFull = false;
			}
		}
		boolean encompasses = false;
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] != null) {
				if (p.getPlot().encompasses(properties[i].getPlot())) {
					encompasses = true;
				}
			}
		}
		if (isFull == true) {
			return -1;
		} else if (p == null) {
			return -2;
		} else if (this.plot.encompasses(p.getPlot()) == false) {
			return -3;
		} else if (encompasses == true) {
			return -4;
		} else {
			Property[] newArr = new Property[properties.length];
			for (int i = 0; i < properties.length; i++) {
				if (properties[i] != null) {
					newArr[i] = properties[i];
				} else {
					index = i;
					break;
				}
			}
			newArr[index] = p;
			properties = new Property[newArr.length];
			for (int i = 0; i < newArr.length; i++) {
				properties[i] = newArr[i];
			}
			return index;
		}

	}

	/**
	 * @return total rent
	 */
	public double totalRent() {
		double total = 0.0;
		for (int i = 0; i < properties.length; i++) {
			total += properties[i].getRentAmount();
		}
		return total;
	}

	/**
	 * @return index of max rent property
	 */
	private int maxRentPropertyIndex() {
		int index = 0;
		double maxRent = 0;
		for (int i = 0; i < properties.length; i++) {
			if (properties[i].getRentAmount() > maxRent) {
				maxRent = properties[i].getRentAmount();
				index = i;
			}
		}
		return index;
	}

	/**
	 * @return max rent
	 */
	public double maxRentProp() {
		return properties[maxRentPropertyIndex()].getRentAmount();
	}

	public String displayPropertyAtIndex(int i) {
		Property p = properties[i];
		return p.getPropertyName() + "\n" + p.getCity() + "\n" + p.getOwner() + "\n$" + p.getRentAmount();
	}

	/**
	 * @return the mAX_PROPERTY
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	/**
	 * @return the mGMT_WIDTH
	 */
	public int getMGMT_WIDTH() {
		return MGMT_WIDTH;
	}

	/**
	 * @return the mGMT_DEPTH
	 */
	public int getMGMT_DEPTH() {
		return MGMT_DEPTH;
	}

	/**
	 * @return the mgmFeePer
	 */
	public double getMgmFeePer() {
		return mgmFeePer;
	}

	/**
	 * @param mgmFeePer the mgmFeePer to set
	 */
	public void setMgmFeePer(double mgmFeePer) {
		this.mgmFeePer = mgmFeePer;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the properties
	 */
	public Property[] getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(Property[] properties) {
		this.properties = properties;
	}

	/**
	 * @return the taxID
	 */
	public String getTaxID() {
		return taxID;
	}

	/**
	 * @param taxID the taxID to set
	 */
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	/**
	 * @return the plot
	 */
	public Plot getPlot() {
		return plot;
	}

	/**
	 * @param plot the plot to set
	 */
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	/**
	 * @return string form
	 */
	public String toString() {
		String yeet = name + ", taxID: " + taxID;
		for (Property p : properties) {
			if (p != null) {
				yeet = yeet + "\n\n" + p.getPropertyName() + "\n" + p.getCity() + "\n" + p.getOwner() + "\n$"
						+ p.getRentAmount();
			}

		}
		return yeet;
	}

}
