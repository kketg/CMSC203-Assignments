import java.util.Scanner;
import java.lang.Math;
public class WindChill {
	public static void main(String[] args) {
		System.out.println("\nWind Chill Calculator");
		System.out.println("--------------------------------");
		Scanner sc = new Scanner(System.in);
		double temp = -46;
		double windSpeed = 0;
		while (!(temp <= 40 && temp >= -45)) {
			System.out.println("Enter a temperature between -45 and 40 Fahrenheit: ");
			temp = sc.nextDouble();
		}
		while (!(windSpeed <= 60 && windSpeed >= 5)) {
			System.out.println("Enter the wind speed between 5 and 60 mph: ");
			windSpeed = sc.nextDouble();
		}
		sc.close();
		System.out.println("\nTemperature: " + temp + "°F\nWind Speed: " + windSpeed + " mph");

		double chill = 35.74 + (0.6215 * temp) - (35.75 * Math.pow(windSpeed, 0.16))
				+ ((0.4275 * temp) * Math.pow(windSpeed, 0.16));
		System.out.println("\nWind Chill: " + chill + "°F");
		System.out.println("--------------------------------");
		System.out.println("Programmer: Kristofer Ter-Gabrielyan");
	}
}
