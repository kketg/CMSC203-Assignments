/**
 * An adult ticket
 * 
 * @author Kristofer Ter-Gabrielyan
 * 
 */
public class Adult extends Ticket {

	@Override
	public double calculateTicketPrice() {
		double p = 0;
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

		p *= 1.096;

		return p;
	}

	@Override
	public int getId() {
		return -1;
	}

	public Adult() {
		super();
		super.type = this.getClass().getCanonicalName();
		this.price = calculateTicketPrice();
	}

	

	public Adult(String movieName, String rating, int day, int time, double price, String format) {
		super(movieName, rating, day, time, price, format);
		super.type = this.getClass().getCanonicalName();
		this.price = calculateTicketPrice();
	}

	public Adult(String movieName, String rating, int day, int time, String format) {
		super(movieName, rating, day, time, format);
		super.type = this.getClass().getCanonicalName();
		this.price = calculateTicketPrice();
	}


	public Adult(String movieName, String rating, int day, int time) {
		super(movieName, rating, day, time);
		super.type = this.getClass().getCanonicalName();
		this.price = calculateTicketPrice();
	}

}
