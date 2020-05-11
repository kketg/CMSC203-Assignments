import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Contains all the methods that handle the ticket classes
 * 
 * @author Kristofer Ter-Gabrielyan
 * 
 */
public class MovieTicketManager implements MovieTicketManagerInterface {

	private NumberFormat currencyformat = NumberFormat.getCurrencyInstance();

	private ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
	@Override
	public ArrayList<String> get3DTickets() {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		for (Ticket t : ticketList) {
			if (t.format == Format.THREE_D) {
				tickets.add(t);
			}
		}
		Ticket temp;
		for (int i = 1; i < tickets.size(); i++) {
			for (int j = i; j > 0; j--) {
				if (tickets.get(j).day < tickets.get(j - 1).day) {
					temp = tickets.get(j);
					tickets.set(j, tickets.get(j - 1));
					tickets.set(j - 1, temp);
				}
			}
		}
		ArrayList<String> strings = new ArrayList<String>();
		for (Ticket t : tickets) {
			strings.add(t.toString());
		}
		return strings;
	}

	@Override
	public int numVisits(int id) {
		int times = 0;
		for(Ticket t : ticketList) {
			if(t.id == id) {
				times++;
			}
		}
		return times;
	}

	@Override
	public int numThisMovie(int id, String movie) {
		int times=0;
		for(Ticket t : ticketList) {
			if(t.id == id) {
				if(t.movieName.equals(movie)) {
					times++;
				}
					
			}
		}
		return times;
	}

	@Override
	public int numMoviesToday(int id, int date) {
		int times=0;
		for(Ticket t : ticketList) {
			if(t.id == id) {
				if(t.day == date) {
					times++;
				}
			}
		}
		return times;
	}

	@Override
	public double addTicket(String movieN, String rating, int d, int t, String f, String type, int id) {

		if (type.equals("Adult")) {
			Adult aTicket = new Adult(movieN, rating, d, t, f);
			ticketList.add(aTicket);
			return aTicket.price;
		} else if (type.equals("Child")) {
			Child cTicket = new Child(movieN, rating, d, t, f);
			ticketList.add(cTicket);
			return cTicket.price;
		} else if (type.equals("MoviePass")) {
			MoviePass mTicket = new MoviePass(movieN, rating, d, t, f, id);
			for (Ticket ti : ticketList) {
				if (ti.id == mTicket.id) {
					mTicket.moviesSeen.put(ti.movieName, ti.day);
				}
			}
			mTicket.price = mTicket.calculateTicketPrice();
			ticketList.add(mTicket);
			return mTicket.price;
		}

		else if (type.equals("Employee")) {
			Employee eTicket = new Employee(movieN, rating, d, t, f, id);
			ticketList.add(eTicket);
			return eTicket.price;
		} else {
			return 0;
		}

	}


	@Override
	public double totalSalesMonth() {
		double sales = 0;
		for(Ticket t : ticketList) {
			sales += t.calculateTicketPrice();
		}
		return sales;
	}

	@Override
	public String monthlySalesReport() {
		double aSales = 0;
		int aCount = 0;
		for(Ticket t : ticketList) {
			if(t.type.equals("Adult")) {
				aSales += t.price;
				aCount++;
			}
		}
		double cSales = 0;
		int cCount = 0;
		for(Ticket t : ticketList) {
			if(t.type.equals("Child")) {
				
				cSales += t.price;
				cCount++;
			}
		}
		double eSales = 0;
		int eCount = 0;
		for(Ticket t : ticketList) {
			if(t.type.equals("Employee")) {
				
				eSales += t.price;
				eCount++;
			}
		}
		double mSales = 0;
		int mCount = 0;
		for(Ticket t : ticketList) {
			if(t.type.equals("MoviePass")) {
				
				mSales += t.price;
				mCount++;
			}
		}
		String returner = "       Monthly Sales Report\n" + "\n"+ "            Sales      Number\n"+ "ADULT      " + currencyformat.format(aSales) + "      " + aCount + "\n"+ "CHILD      " + currencyformat.format(cSales) + "      " + cCount + "\n"+ "EMPLOYEE   " + currencyformat.format(eSales) + "      " + eCount + "\n"+ "MOVIEPASS  " + currencyformat.format(mSales) + "      " + mCount + "\n";
		System.out.println(returner);
		return returner;
	}

	@Override
	public ArrayList<String> getAllTickets() {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		for (Ticket t : ticketList) {
			tickets.add(t);
		}
		Ticket temp;
		for (int i = 1; i < tickets.size(); i++) {
			for (int j = i; j > 0; j--) {
				if (tickets.get(j).day < tickets.get(j - 1).day) {
					temp = tickets.get(j);
					tickets.set(j, tickets.get(j - 1));
					tickets.set(j - 1, temp);
				}
			}
		}
		ArrayList<String> strings = new ArrayList<String>();
		for (Ticket t : tickets) {
			strings.add(t.toString());
		}
		return strings;
	}

	@Override
	public ArrayList<String> getMoviePassTickets() {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		for (Ticket t : ticketList) {
			if (t.type == "MoviePass") {
				tickets.add(t);
			}
		}
		Ticket temp;
		for (int i = 1; i < tickets.size(); i++) {
			for (int j = i; j > 0; j--) {
				if (tickets.get(j).id < tickets.get(j - 1).id) {
					temp = tickets.get(j);
					tickets.set(j, tickets.get(j - 1));
					tickets.set(j - 1, temp);
				}
			}
		}
		ArrayList<String> strings = new ArrayList<String>();
		for (Ticket t : tickets) {
			strings.add(t.toString());
		}
		return strings;
	}

	@Override
	public void readFile(File file) throws FileNotFoundException {
		ArrayList<String> lines = new ArrayList<String>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null) {
				//System.out.println(line);
				lines.add(line);
			}
			reader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		for(String s : lines) {
			Ticket t;
			String[] splits = s.split(":");
			String type = splits[5];
			if(type.equals("Adult")) {
				t = new Adult(splits[0], splits[1],Integer.parseInt(splits[2]), Integer.parseInt(splits[3]), splits[4]);
				ticketList.add(t);
			}
			if(type.equals("Child")) {
				t = new Child(splits[0], splits[1],Integer.parseInt(splits[2]), Integer.parseInt(splits[3]), splits[4]);
				ticketList.add(t);
			}
			if(type.equals("Employee")) {
				t = new Employee(splits[0], splits[1],Integer.parseInt(splits[2]), Integer.parseInt(splits[3]), splits[4], Integer.parseInt(splits[6]));
				ticketList.add(t);
			}
			if(type.equals("MoviePass")) {
				t = new MoviePass(splits[0], splits[1],Integer.parseInt(splits[2]), Integer.parseInt(splits[3]), splits[4], Integer.parseInt(splits[6]));
				ticketList.add(t);
			}
		}
		
		

	}

}
