package bytehala;

/**
 * 
 * @author Lemuel Dulfo
 *
 */
public class Runner {
	
	public static void main(String[] args) {
		int[][] field = {
				{4, 8, 7, 3},
				{2, 5, 9, 3},
				{6, 3, 2, 5},
				{4, 4, 1, 6}
		};
		Skiing s = new Skiing(4, 4, field);
		s.solve();
		System.out.println(s.getLongestRide() + " " + s.getHighestDrop());
	}

}
