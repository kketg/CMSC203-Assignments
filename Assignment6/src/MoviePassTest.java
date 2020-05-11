import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Test cases for the MoviePass ticket type
 * 
 * @author Kristofer Ter-Gabrielyan
 * 
 */
class MoviePassTest {
	
	private MovieTicketManager _m;

	
	@BeforeEach
	public void setUp() throws Exception {
		_m = new MovieTicketManager();
	}

	

	@Test
	public void test() {
		assertEquals(9.99,_m.addTicket("Deadpool", "NR", 5, 13, "NONE", "MoviePass", 12345),.01);
		assertEquals(9.99,_m.addTicket("Action Point", "NR", 2,12,"3D","MoviePass", 23456),.01);
		assertEquals(18.08,_m.addTicket("Adrift", "PG13", 3,19,"IMAX","MoviePass",12345),.01);
		assertEquals(9.99,_m.addTicket("Book Club", "PG13", 1,20,"IMAX","MoviePass",45678),.01);
		assertEquals(0.00,_m.addTicket("Life of the Party", "PG13", 3,21,"NONE","MoviePass",23456),.01);
	}
	@AfterEach
	public void tearDown() throws Exception {
		_m = null;
	}

}
