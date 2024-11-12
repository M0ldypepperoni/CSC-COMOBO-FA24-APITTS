
public class PokerDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deck deck = new Deck();
		deck.shuffle();
		
	}
	 public static void printCard(String rank, String suit) {
	        System.out.println("┌─────────┐");
	        System.out.println("│" + rank + "        │");
	        System.out.println("│         │");
	        System.out.println("│    " + suit + "    │");
	        System.out.println("│         │");
	        System.out.println("│        " + rank + "│");
	        System.out.println("└─────────┘");
	 }
}
