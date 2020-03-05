import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Birthday Class Driver for the toy class, creates toy objects based on given
 * information about a child and calculates the total order
 * 
 * @author Kristofer Ter-Gabrielyan
 */

class Birthday {
 
	public static void main(String[] args) {

		// sets up decimal formatting, initializes toy List, and and random class for
		// later use
		DecimalFormat dollar = new DecimalFormat("#,##0.00");
		ArrayList<Toy> toys = new ArrayList<Toy>();
		Random rand = new Random();
		// Declares the main dowhile loop value
		boolean done = false;
		// declares variable to store child name
		String childName = "";
		System.out.println("******************BIRTHDAY GIFTS******************");
		// Shows welcome message
		JOptionPane.showMessageDialog(null, "Welcome to the Toy Company!");
		do {
			// Prompts for child name
			childName = JOptionPane.showInputDialog("Enter the child's name");
			// Prompts for child age
			int age = Integer.parseInt(JOptionPane.showInputDialog("Enter the child's age"));
			// Prompts for toy type
			String toyName = JOptionPane.showInputDialog("Choose a toy: a plushie, blocks, or a book");
			// Initializes new toy object with the given values
			Toy toy = new Toy(toyName, age);

			// Checks if the toy is age appropriate, and if so, whether or not the user
			// wants to cancel the order.
			boolean cancel = false;
			if (toy.ageOK() != true) {

				boolean answered = false;
				do {
					String canc = JOptionPane.showInputDialog(
							"This toy is not age appropriate. Would you like to cancel the order? (Yes/No)");
					if (canc.equalsIgnoreCase("yes")) {
						cancel = true;
						answered = true;
					} else if (canc.equalsIgnoreCase("no")) {
						cancel = false;
						answered = true;
					} else {
						answered = false;
					}
				} while (answered != true);
			}
			if (cancel != true) {
				// Prompts to add card and balloon to order
				String card = JOptionPane.showInputDialog("Would you like to add a card to the order? (Yes/No)");
				toy.addCard(card);
				String balloon = JOptionPane.showInputDialog("Would you like to add a balloon to the order? (Yes/No)");
				toy.addBalloon(balloon);

				// Adds the toy object to the order list
				toys.add(toy);

				// Prints out the details of the toy object
				System.out.println("The gift for " + childName + toy.toString());

				// Prompts to add another toy to the order
				String another = JOptionPane
						.showInputDialog("Would you like to add another toy to the order? (Yes/No)");
				if (another.equalsIgnoreCase("yes")) {
					continue;
				} else {
					done = true;
					break;
				}
			}

		} while (done != true);

		// calculates and formats order total
		double orderTotal = 0;
		for (Toy t : toys) {
			orderTotal += t.getCost();
		}

		// Prints final details
		System.out.println("The total cost of your order is $" + dollar.format(orderTotal));
		System.out.println("Your order number is " + rand.nextInt(10) + "" + rand.nextInt(10) + "" + rand.nextInt(10) + ""
				+ rand.nextInt(10) + "" + rand.nextInt(10));
		System.out.println("**************************************************");
		System.out.println("Programmer: Kristofer Ter-Gabrielyan");
	}
}
