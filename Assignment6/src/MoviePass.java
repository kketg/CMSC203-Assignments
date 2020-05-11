import java.util.ArrayList;
import java.util.Hashtable;
/**
 * A MoviePass ticket
 * 
 * @author Kristofer Ter-Gabrielyan
 * 
 */
public class MoviePass extends Ticket {


	//Name : day
	Hashtable<String, Integer> moviesSeen = new Hashtable<String, Integer>();
	
	@Override
	public double calculateTicketPrice() {
		double p = 0;
		boolean met = false;
		if(moviesSeen.containsKey(super.movieName)) {
			met = true;
		}
		if(moviesSeen.containsValue(super.day)) {
			met = true;
		}
			
		if(super.format != Format.NONE) {
			met = true;
		}	
		
		if(met) {
			if(moviesSeen.size() > 0) {
				if (super.time < 18) {
					p = 10.50;
				} else {
					p = 13.50;
				}
				if (super.format == Format.IMAX) {
					p += 3;
				}
				if (super.format == Format.THREE_D) {
					p += 2.5;
				}
				p *= 1.096;
			}else{
				p = 9.99;
			}
			
		}else {
			if(moviesSeen.size() > 0) {
				p = 0.00;
			}else {
				p = 9.99;
			}
		}
		
		
		return p;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return super.id;
	}

	public MoviePass() {
		super();
		super.type = this.getClass().getCanonicalName();
	}

	public MoviePass(String movieName, String rating, int day, int time, double price, String format) {
		super(movieName, rating, day, time, price, format);
		super.type = this.getClass().getCanonicalName();
	}
	public MoviePass(String movieName, String rating, int day, int time, String format, int id) {
		super(movieName, rating, day, time, format, id);
		super.type = this.getClass().getCanonicalName();
	}

	public MoviePass(String movieName, String rating, int day, int time, String format) {
		super(movieName, rating, day, time, format);
		super.type = this.getClass().getCanonicalName();
	}

	public MoviePass(String movieName, String rating, int day, int time) {
		super(movieName, rating, day, time);
		super.type = this.getClass().getCanonicalName();
	}
	
	@Override
	public String toString() {
		if(format != Format.NONE)
			return type.toUpperCase() + "-" + id + " " + format + "  Movie: " + movieName + " Rating: " + rating + " Day: " + day + " Time: " + time + " Price: $" + price;
		else
			return type.toUpperCase() + "-" + id + "  Movie: " + movieName + " Rating: " + rating + " Day: " + day + " Time: " + time + " Price: $" + price;
	}

	
}
