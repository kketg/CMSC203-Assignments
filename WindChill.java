import java.util.Scanner;
import java.lang.Math;
public class WindChill {
	public static void main(String[] args) {
		p("\nWind Chill Calculator");
		p("--------------------------------");
		Scanner sc = new Scanner(System.in);
		double temp = -46;
		double windSpeed = 0;
		while (!(temp <= 40 && temp >= -45)) {
			p("Enter a temperature between -45 and 40 Fahrenheit: ");
			temp = sc.nextDouble();
		}
		while (!(windSpeed <= 60 && windSpeed >= 5)) {
			p("Enter the wind speed between 5 and 60 mph: ");
			windSpeed = sc.nextDouble();
		}
		sc.close();
		p("\nTemperature: " + temp + "°F\nWind Speed: " + windSpeed + " mph");

		double chill = 35.74 + (0.6215 * temp) - (35.75 * Math.pow(windSpeed, 0.16))
				+ ((0.4275 * temp) * Math.pow(windSpeed, 0.16));
		p("\nWind Chill: " + chill + "°F");
		p("--------------------------------");
		p("Programmer: Kristofer Ter-Gabrielyan");
	}
	public static void p(Object o){
	    System.out.println(o);
	}
}
