
/**
 * Base superclass for all the ticket types
 * 
 * @author Kristofer Ter-Gabrielyan
 * 
 */
public abstract class Ticket {
	
	protected Format format;
	
	protected String movieName;
	protected String rating;
	protected int day;
	protected int time;
	protected double price;
	protected String type;
	protected int id = 0;
	
	public abstract double calculateTicketPrice();
	
	/**
	 * @return the id
	 */
	public abstract int getId();
	/**
	 * @return the string form
	 */
	public String toString() {
		if(format != Format.NONE)
			return type.toUpperCase() + " " + format + "  Movie: " + movieName + " Rating: " + rating + " Day: " + day + " Time: " + time + " Price: $" + price;
		else
			return type.toUpperCase() + "  Movie: " + movieName + " Rating: " + rating + " Day: " + day + " Time: " + time + " Price: $" + price;
	}

	/**
	 * @return the format
	 */
	public Format getFormat() {
		return format;
	}

	/**
	 * @param the format to set
	 */
	public void setFormat(Format format) {
		this.format = format;
	}
	
	public Ticket() {
		format = Format.NONE;
		movieName = "";
		rating = "";
		day = 0;
		time = 0;
		price = 0.0;
	}

	public Ticket(String movieName, String rating, int day, int time) {
		this.movieName = movieName;
		this.rating = rating;
		this.day = day;
		this.time = time;
		
	}
	public Ticket(String movieName, String rating, int day, int time, String format) {
		if(format.equals("3D")) {
			this.format = Format.THREE_D;
		}else {
			this.format = Format.valueOf(format);
		}
		
		this.movieName = movieName;
		this.rating = rating;
		this.day = day;
		this.time = time;
	}
	public Ticket(String movieName, String rating, int day, int time, double price,String format) {
		if(format.equals("3D")) {
			this.format = Format.THREE_D;
		}else {
			this.format = Format.valueOf(format);
		}
		this.movieName = movieName;
		this.rating = rating;
		this.day = day;
		this.time = time;
		this.price = price;
	}
	public Ticket(String movieName, String rating, int day, int time, String format, int id) {
		if(format.equals("3D")) {
			this.format = Format.THREE_D;
		}else {
			this.format = Format.valueOf(format);
		}
		this.id = id;
		this.movieName = movieName;
		this.rating = rating;
		this.day = day;
		this.time = time;
	}
	
	
	
	
	
	
}
