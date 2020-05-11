import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Test cases for Adult ticket type
 * 
 * @author Kristofer Ter-Gabrielyan
 * 
 */
class AdultTest {

	Adult a1;
	Adult a2;
	Adult a3;
	Adult a4;
	Adult a5;
	
	@BeforeEach
	void setUp() throws Exception {
		a1 = new Adult("Rise of Skywalker","PG13",6,19, "NONE");
		a2 = new Adult("Avengers: Endgame","PG13",5,12, "IMAX");
		a3 = new Adult("Onward","PG",5,14, "NONE");
		a4 = new Adult("Parasite","R",7,20, "NONE");
		a5 = new Adult("Joker","R",10,22, "NONE");
		
	}

	@AfterEach
	void tearDown() throws Exception {
		a1=a2=a3=a4=a5=null;
	}

	@Test
	void test() {
		assertEquals(14.80, a1.calculateTicketPrice(), .01);
		assertEquals(14.80, a2.calculateTicketPrice(), .01);
		assertEquals(11.51, a3.calculateTicketPrice(), .01);
		assertEquals(14.80, a4.calculateTicketPrice(), .01);
		assertEquals(14.80, a5.calculateTicketPrice(), .01);
	}

}
