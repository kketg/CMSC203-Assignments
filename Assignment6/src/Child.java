/**
 * A child ticket
 * 
 * @author Kristofer Ter-Gabrielyan
 * 
 */
public class Child extends Ticket {

	
	@Override
	public double calculateTicketPrice() {
		double p = 0;
		if (super.time < 18) {
			p += 5.75;
		} else {
			p += 10.75;
		}
		if (super.format == Format.IMAX) {
			p += 2;
		}
		if (super.format == Format.THREE_D) {
			p += 1.5;
		}

		p *= 1.096;

		return p;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return -1;
	}
	public Format getFormat() {
		return super.format;
	}

	public Child() {
		super();
	}

	

	public Child(String movieName, String rating, int day, int time, double price, String format) {
		super(movieName, rating, day, time, price, format);
		super.type = this.getClass().getCanonicalName();
		this.price = calculateTicketPrice();
	}

	public Child(String movieName, String rating, int day, int time, String format) {
		super(movieName, rating, day, time, format);
		super.type = this.getClass().getCanonicalName();
		this.price = calculateTicketPrice();
	}
	public Child(String movieName, String rating, int day, int time) {
		super(movieName, rating, day, time);
		super.type = this.getClass().getCanonicalName();
		this.price = calculateTicketPrice();
	}
	
	
}
