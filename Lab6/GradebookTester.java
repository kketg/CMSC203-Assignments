import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {

	GradeBook gb1;
	GradeBook gb2;
	
	@BeforeEach
	void setUp() throws Exception {
		gb1 = new GradeBook(5);
		gb2 = new GradeBook(5);
		gb1.addScore(7);
		gb1.addScore(15);
		gb2.addScore(28);
		gb2.addScore(3);
		gb2.addScore(31);
	}

	@AfterEach
	void tearDown() throws Exception {
		gb1 = null;
		gb2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(gb1.toString().equals("7.0 15.0 "));
		assertTrue(gb2.toString().equals("28.0 3.0 31.0 "));
		assertEquals(2,gb1.getScoresSize());
		assertEquals(3,gb2.getScoresSize());
	}

	@Test
	void testSum() {
		assertEquals(22.0, gb1.sum());
		assertEquals(62.0, gb2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(7.0, gb1.minimum());
		assertEquals(3.0, gb2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(15.0, gb1.finalScore());
		assertEquals(59.0, gb2.finalScore());
	}


}
