/**
*	MovieDriver
*	Driver for the movie class
*	@author Kristofer Ter-Gabrielyan
*/
public class MovieDriver{
	public static void main(String[] args){
		boolean continueLoop = true;
		while(continueLoop){
			Scanner sc = new Scanner(System.in);
			Movie movie = new Movie();
			p("Enter the title of the movie: ");
			String title = sc.nextLine();
			movie.setTitle(title);
			p("Enter the movie's rating: ");
			String rating = sc.nextLine();
			movie.setRating(rating);
			p("Enter the number of tickets sold: ");
			int tickets = sc.nextInt();
			movie.setSoldTickets(tickets);
			p(movie.toString());
			p("Would you like to continue? (Y/N)");
			String next = sc.next();
			if(next.equalsIgnoreCase("y")){
				continueLoop = true;
			}else{
				continueLoop = false;
			}
		}
		
	}
	public static void p(Object o){
		System.out.println(o);
	}
}
