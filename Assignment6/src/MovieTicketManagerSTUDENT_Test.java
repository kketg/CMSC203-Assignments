import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Test cases for the MovieTicketManager
 * 
 * @author Kristofer Ter-Gabrielyan
 * 
 */
class MovieTicketManagerSTUDENT_Test {
	
	MovieTicketManager _m;
	
	@BeforeEach
	void setUp() {
		_m = new MovieTicketManager();
		
		_m.addTicket("Deadpool", "NR", 2, 2, "NONE", "Employee", 12345);
		_m.addTicket("Endgame", "PG13", 3,3,"NONE","MoviePass",33333);
	}
	
	
	
	@AfterEach
	void tearDown() {
		_m = null;
	}
	
	@Test
	public void testNumVisits() {
		//Employee
		assertEquals(1,_m.numVisits(12345));
		_m.addTicket("Solo", "PG13", 2,13,"NONE","Employee",12345);
		assertEquals(2,_m.numVisits(12345));
		_m.addTicket("Solo", "PG13", 2,19,"NONE","Employee",12345);
		assertEquals(3,_m.numVisits(12345));
		
		//MoviePass member
		assertEquals(1,_m.numVisits(33333));
		_m.addTicket("Deadpool", "NR", 2,12,"NONE","MoviePass",33333);
		assertEquals(2,_m.numVisits(33333));
		_m.addTicket("Action Point", "NR", 2,13,"NONE","MoviePass",33333);
		assertEquals(3,_m.numVisits(33333));
	}

	/**
	 * Test the number of times this movie has been viewed
	 * This only applied to those who have id members - Employees or MoviePass members
	 */
	@Test
	public void testNumThisMovie() {
		//Employee
		assertEquals(1,_m.numThisMovie(12345,"Deadpool"));
		_m.addTicket("Solo", "PG13", 2,5,"NONE","Employee",12345);
		assertEquals(1,_m.numThisMovie(12345,"Solo"));
		_m.addTicket("Solo", "PG13", 2,15,"NONE","Employee",12345);
		assertEquals(2,_m.numThisMovie(12345,"Solo"));

		//MoviePass member
		assertEquals(1,_m.numThisMovie(33333,"Endgame"));
		_m.addTicket("Deadpool", "NR", 2,12,"NONE","MoviePass",33333);
		assertEquals(1,_m.numThisMovie(33333,"Deadpool"));
		_m.addTicket("Deadpool", "NR", 2,14,"NONE","MoviePass",33333);
		assertEquals(2,_m.numThisMovie(33333,"Deadpool"));
	}

	/**
	 * Test the number of movies attended on a day
	 * This only applied to those who have id members - Employees or MoviePass members
	 */
	@Test
	public void testNumMoviesToday() {
		//Employee
		assertEquals(1,_m.numMoviesToday(12345,2));
		_m.addTicket("Solo", "PG13", 2,2,"NONE","Employee",12345);
		assertEquals(2,_m.numMoviesToday(12345,2));
		_m.addTicket("Endgame", "PG13", 3,3,"NONE","Employee",12345);
		assertEquals(1,_m.numMoviesToday(12345,3));

		//MoviePass member
		assertEquals(1,_m.numMoviesToday(33333,3));
		_m.addTicket("Deadpool", "NR", 3,3,"NONE","MoviePass",33333);
		assertEquals(2,_m.numMoviesToday(33333,3));
		_m.addTicket("Deadpool", "NR", 6,4,"NONE","MoviePass",33333);
		assertEquals(1,_m.numMoviesToday(33333,6));
	}

	/**
	 * Test adding tickets of the 4 types of tickets
	 */
	@Test
	public void testAddTicket() {
		MovieTicketManager tickets = new MovieTicketManager();
		//adule ticket
		assertEquals(14.80,tickets.addTicket("Endgame", "PG13", 4,15,"IMAX","Adult",0),.01);
		//child ticket
		assertEquals(13.43,tickets.addTicket("Little Mermaid", "G", 5,19,"3D","Child",0),.01);
		//employee ticket - first movie this month
		assertEquals(0.00,tickets.addTicket("Deadpool", "NR", 5,22,"3D","Employee",12345),.01);
		//moviepass ticket - first movie this month	
		assertEquals(9.99,tickets.addTicket("Deadpool", "NR", 5,16,"IMAX","MoviePass",22222),.01);
		//moviepass ticket - second movie this month, different movie, different day
		assertEquals(18.08,tickets.addTicket("Solo", "PG13", 6,19,"IMAX","MoviePass",22222),.01);
	}

	/**
	 * Test the total of tickets sales for the month
	 */
	@Test
	public void testTotalSalesMonth() {
		assertEquals(9.99,_m.totalSalesMonth(),.01);

		//add an employee who has only seen 1 movie - no change
		_m.addTicket("Solo", "PG13", 5,16,"IMAX","Employee",12345);
		assertEquals(9.99,_m.totalSalesMonth(),.01);
		//add a MoviePass member who has seen a movie - no change
		_m.addTicket("Deadpool", "NR", 3,15,"NONE","MoviePass",33333);
		assertEquals(21.50,_m.totalSalesMonth(),.01);
		//add a MoviePass member who has already seen a movie on this date
		_m.addTicket("Deadpool", "NR", 5,20,"NONE","MoviePass",33333);
		assertEquals(36.30,_m.totalSalesMonth(),.01);
		//add a MoviePass member who has not seen a movie this month
		_m.addTicket("Infinity Wars", "PG", 2,14,"NONE","MoviePass",77777);
		assertEquals(46.28,_m.totalSalesMonth(),.01);
	}

	/**
	 * The 3D tickets sold this month in chronological order by day
	 */
	@Test
	public void testGet3DTickets() {
		_m.addTicket("Frozen 2", "PG", 4, 12, "3D", "Adult", 0);
		_m.addTicket("Solo", "PG13", 5, 17, "3D", "Employee", 12345);
		_m.addTicket("The Force Awakens", "PG13", 6, 18, "3D", "MoviePass", 33333);
		ArrayList<String> result = _m.get3DTickets();
		assertTrue(result.get(0).contains("Frozen 2"));
		assertTrue(result.get(1).contains("Solo"));
		assertTrue(result.get(2).contains("The Force Awakens"));
		_m.addTicket("Onward", "PG", 8,14,"3D","Child",0);
		_m.addTicket("Rise of Skywalker", "PG13", 12,18,"3D","MoviePass",33333);
		result = _m.get3DTickets();
		assertTrue(result.get(0).contains("Frozen 2"));
		assertTrue(result.get(1).contains("Solo"));
		assertTrue(result.get(2).contains("The Force Awakens"));
		assertTrue(result.get(3).contains("Onward"));
		assertTrue(result.get(4).contains("Rise of Skywalker"));
		
	}

	/**
	 * All tickets sold this month in chronological order by day
	 * You don't need to worry about ordering within the day
	 */
	@Test
	public void testGetAllTickets() {
		ArrayList<String> result = _m.getAllTickets();
		for(String s : result) {
			System.out.println(s);
		}
		assertTrue(result.get(0).contains("Day: 2"));
		assertTrue(result.get(1).contains("Day: 3"));
		assertTrue(result.get(0).contains("Price: $0.0"));
		assertTrue(result.get(1).contains("Price: $9.99"));
		assertTrue(result.get(0).contains("Movie: Deadpool"));
		assertTrue(result.get(1).contains("Movie: Endgame"));
		
	}

	/**
	 * The MoviePass tickets sold this month in order by MoviePass id
	 */
	@Test
	public void testGetMoviePassTickets() {
		ArrayList<String> result = _m.getMoviePassTickets();
		assertTrue(result.get(0).contains("33333"));
		_m.addTicket("Frozen 2", "PG", 6,14,"3D","MoviePass",44444);
		_m.addTicket("Rise of Skywalker", "PG13", 7,17,"3D","MoviePass",55555);
		result = _m.getMoviePassTickets();
		assertTrue(result.get(0).contains("33333"));
		assertTrue(result.get(1).contains("44444"));
		assertTrue(result.get(2).contains("55555"));

	}

	/**
	 * The monthly sales report
	 */
	@Test
	public void testMonthlySalesReport(){
		_m.addTicket("Solo", "PG13", 5, 19, "IMAX", "Adult", 0);
		_m.addTicket("Frozen 2", "PG", 6, 15, "NONE", "Child", 0);
		_m.addTicket("Rise of Skywalker", "PG13", 8, 18, "IMAX", "Adult", 0);
		String result = _m.monthlySalesReport();
		Scanner scan = new Scanner(result);
		assertTrue(scan.nextLine().contains("Monthly Sales Report"));
		scan.nextLine();
		assertTrue(scan.nextLine().contains("Sales"));
		String line = scan.nextLine(); 
		assertTrue(line.contains("ADULT"));
		assertTrue(line.contains("36.17"));
		assertTrue(line.contains("2"));
		line = scan.nextLine(); //Child line
		assertTrue(line.contains("CHILD"));
		assertTrue(line.contains("$6.30"));
		assertTrue(line.contains("1"));
		line = scan.nextLine(); //Employee line
		assertTrue(line.contains("EMPLOYEE"));
		assertTrue(line.contains("0.00"));
		assertTrue(line.contains("1"));
		line = scan.nextLine(); //Employee line
		assertTrue(line.contains("MOVIEPASS"));
		assertTrue(line.contains("$9.99"));
		assertTrue(line.contains("1"));
		
	}
	
	/**
	 * Test readin from a file
	 * @throws FileNotFoundException when file is not found
	 */
	@Test
	public void testReadFile() throws FileNotFoundException {
		_m = null;
		_m = new MovieTicketManager();
		PrintWriter testMovie = null;
		try {
			testMovie = new PrintWriter("studentTest.txt"); 
			testMovie.println("Deadpool:NR:4:5:NONE:Adult:0");
			testMovie.println("Joker:R:4:8:NONE:Employee:14634");
			testMovie.println("Frozen 2:PG:4:13:NONE:Child:0");
			testMovie.println("Solo:PG13:4:15:NONE:MoviePass:23456");
			testMovie.println("Endgame:PG13:4:18:NONE:MoviePass:23456");
			testMovie.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		_m.readFile(new File("studentTest.txt"));
		ArrayList<String> tickets = _m.getAllTickets();
		for(String s : tickets) {
			System.out.println(s);
		}
		assertTrue(tickets.get(0).contains("Deadpool"));
		assertTrue(tickets.get(1).contains("Joker"));
		assertTrue(tickets.get(2).contains("Frozen 2"));
		assertTrue(tickets.get(3).contains("Solo"));
		assertTrue(tickets.get(4).contains("Endgame"));
		
	}

}
