/**
 * An employee ticket
 * 
 * @author Kristofer Ter-Gabrielyan
 * 
 */
public class Employee extends Ticket {
	
	int timesWatched = 0;
	
	@Override
	public double calculateTicketPrice() {
		double p = 0;
		if(timesWatched >= 2) {
			if (super.time < 18) {
				p += 10.50;
			} else {
				p += 13.50;
			}
			if (super.format == Format.IMAX) {
				p += 3;
			}
			if (super.format == Format.THREE_D) {
				p += 2.5;
			}
			
			p/=2;

			p *= 1.096;
		}
		return p;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Employee() {
		super();
		super.type = this.getClass().getCanonicalName();
		this.price = calculateTicketPrice();
	}

	

	public Employee(String movieName, String rating, int day, int time, String format, int id, int timesWatched) {
		super(movieName, rating, day, time, format, id);
		this.timesWatched = timesWatched;
		super.type = this.getClass().getCanonicalName();
		this.price = calculateTicketPrice();
	}
	public Employee(String movieName, String rating, int day, int time, String format, int id) {
		super(movieName, rating, day, time, format, id);
		super.type = this.getClass().getCanonicalName();
		this.price = calculateTicketPrice();
	}

	public Employee(String movieName, String rating, int day, int time, String format) {
		super(movieName, rating, day, time, format);
		super.type = this.getClass().getCanonicalName();
		this.price = calculateTicketPrice();
	}

	public Employee(String movieName, String rating, int day, int time) {
		super(movieName, rating, day, time);
		super.type = this.getClass().getCanonicalName();
		this.price = calculateTicketPrice();
	}
	
	@Override
	public String toString() {
		if(format != Format.NONE)
			return type.toUpperCase() + "-" + id + " " + format + "  Movie: " + movieName + " Rating: " + rating + " Day: " + day + " Time: " + time + " Price: $" + price;
		else
			return type.toUpperCase() + "-" + id + "  Movie: " + movieName + " Rating: " + rating + " Day: " + day + " Time: " + time + " Price: $" + price;
	}

	

}
