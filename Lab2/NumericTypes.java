import java.util.Scanner;
/**
	<h1>NumericTypes</h1>
	<p>
	This program demonstrates how numeric types and operators behave in Java.
	
	@author Kristofer Ter-Gabrielyan
	
*/
public class NumericTypes {
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);

		//identifier declarations
		final int NUMBER = 2; // number of scores
		p("Enter your first score: ");
		//int score1 = 100; 
		int score1 = sc.nextInt();
		p("Enter your second score: ");
		//int score2 = 95; 
		int score2 = sc.nextInt();
		final int BOILING_IN_F = 212; // boiling temperature
		
		double fToC; // temperature in Celsius
		double average; // arithmetic average
		String output; // line of output to print out
		int userTemp;
		
		// Find an arithmetic average
		average = (double)(score1 + score2) / (double)NUMBER;
		output = score1 + " and " + score2 + " have an average of " + average;	
		System.out.println(output);
		// Convert Fahrenheit temperatures to Celsius
		fToC = (5.0/9.0) * ((double)BOILING_IN_F - 32.0);
		output = BOILING_IN_F + " in Fahrenheit is " + fToC + " in Celsius.";
		System.out.println(output);
		p("Enter your temperature in fahrenheit: ");
		userTemp = sc.nextInt();
		output = userTemp + " in Celsius is " + ((5.0/9.0) * ((double)userTemp - 32.0));
		p(output);
		System.out.println("Goodbye"); // to show that the program is ended	
	}

	public static void p(Object o){
		System.out.println(o);
	}
}
