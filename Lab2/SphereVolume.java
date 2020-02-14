import java.util.Scanner;
import java.lang.Math;
/**
*	<h1>SphereVolume</h1>
*	This program calculates the result of the volume formula of a sphere.
*	<p>
*	@author Kristofer Ter-Gabrielyan
*/
public class SphereVolume{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		p("This program calculates the result of the volume formula of a sphere.");
		p("Enter the diameter of the sphere: ");
		double diam = sc.nextDouble();
		double radius = diam/2.0;
		p(radius);
		double volume = (Math.pow(radius,3) * (4.0/3.0) * Math.PI);
		p("The volume is " + volume + "  (" + (volume/Math.PI) + "pi)");
	}
	public static void p(Object o){
		System.out.println(o);
	}
}
