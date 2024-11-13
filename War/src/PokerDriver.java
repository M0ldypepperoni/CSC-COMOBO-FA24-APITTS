import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PokerDriver {

	public static void main(String[] args) {
		Random rand = new Random();
		int count = 1;
		char again = 'y';
		// TODO add file writer and reader for high-score
		Scanner input = new Scanner(System.in);
		Pile player = new Pile();
		Pile b1 = new Pile();
		Pile b2 = new Pile();
		Pile b3 = new Pile();
		Pile b4 = new Pile();
		Pile b5 = new Pile();
		Pile b6 = new Pile();
		Pile b7 = new Pile();
		Pile b8 = new Pile();
		Pile b9 = new Pile();
		Pile b10 = new Pile();
		Pile left = new Pile();
		int botP = 1000;
		int playerPoints = 1000;
		int botAmount = 0;

		Deck deck = new Deck();

		deck.shuffle();

		System.out.println("Please enter the amount of bots you want to play against.");
		botAmount = input.nextInt();
		ArrayList<ArrayList<Card>> piles = new ArrayList<ArrayList<Card>>(botAmount);
// TODO add piles in switch statement to piles
		while (again == 'y' || again == 'Y') {
			switch (botAmount) {
			case 1:
				player.addDeck(deck.subdeck(0, 1));
				b1.addDeck(deck.subdeck(2, 3));
				left.addDeck(deck.subdeck(4, 51));
				break;
			case 2:
				player.addDeck(deck.subdeck(0, 1));
				b1.addDeck(deck.subdeck(2, 3));
				b2.addDeck(deck.subdeck(4, 5));
				left.addDeck(deck.subdeck(6, 51));
				break;
			case 3:
				player.addDeck(deck.subdeck(0, 1));
				b1.addDeck(deck.subdeck(2, 3));
				b2.addDeck(deck.subdeck(4, 5));
				b3.addDeck(deck.subdeck(6, 7));
				left.addDeck(deck.subdeck(8, 51));
				break;
			case 4:
				player.addDeck(deck.subdeck(0, 1));
				b1.addDeck(deck.subdeck(2, 3));
				b2.addDeck(deck.subdeck(4, 5));
				b3.addDeck(deck.subdeck(6, 7));
				b4.addDeck(deck.subdeck(8, 9));
				left.addDeck(deck.subdeck(10, 51));
				break;
			case 5:
				player.addDeck(deck.subdeck(0, 1));
				b1.addDeck(deck.subdeck(2, 3));
				b2.addDeck(deck.subdeck(4, 5));
				b3.addDeck(deck.subdeck(6, 7));
				b4.addDeck(deck.subdeck(8, 9));
				b5.addDeck(deck.subdeck(10, 11));
				left.addDeck(deck.subdeck(12, 51));
				break;
			case 6:
				player.addDeck(deck.subdeck(0, 1));
				b1.addDeck(deck.subdeck(2, 3));
				b2.addDeck(deck.subdeck(4, 5));
				b3.addDeck(deck.subdeck(6, 7));
				b4.addDeck(deck.subdeck(8, 9));
				b5.addDeck(deck.subdeck(10, 11));
				b6.addDeck(deck.subdeck(12, 13));
				left.addDeck(deck.subdeck(14, 51));
				break;
			case 7:
				player.addDeck(deck.subdeck(0, 1));
				b1.addDeck(deck.subdeck(2, 3));
				b2.addDeck(deck.subdeck(4, 5));
				b3.addDeck(deck.subdeck(6, 7));
				b4.addDeck(deck.subdeck(8, 9));
				b5.addDeck(deck.subdeck(10, 11));
				b6.addDeck(deck.subdeck(12, 13));
				b7.addDeck(deck.subdeck(14, 15));
				left.addDeck(deck.subdeck(16, 51));
				break;
			case 8:
				player.addDeck(deck.subdeck(0, 1));
				b1.addDeck(deck.subdeck(2, 3));
				b2.addDeck(deck.subdeck(4, 5));
				b3.addDeck(deck.subdeck(6, 7));
				b4.addDeck(deck.subdeck(8, 9));
				b5.addDeck(deck.subdeck(10, 11));
				b6.addDeck(deck.subdeck(12, 13));
				b7.addDeck(deck.subdeck(14, 15));
				b8.addDeck(deck.subdeck(16, 17));
				left.addDeck(deck.subdeck(18, 51));
				break;
			case 9:
				player.addDeck(deck.subdeck(0, 1));
				b1.addDeck(deck.subdeck(2, 3));
				b2.addDeck(deck.subdeck(4, 5));
				b3.addDeck(deck.subdeck(6, 7));
				b4.addDeck(deck.subdeck(8, 9));
				b5.addDeck(deck.subdeck(10, 11));
				b6.addDeck(deck.subdeck(12, 13));
				b7.addDeck(deck.subdeck(14, 15));
				b8.addDeck(deck.subdeck(16, 17));
				b9.addDeck(deck.subdeck(18, 19));
				left.addDeck(deck.subdeck(20, 51));
				break;
			case 10:
				player.addDeck(deck.subdeck(0, 1));
				b1.addDeck(deck.subdeck(2, 3));
				b2.addDeck(deck.subdeck(4, 5));
				b3.addDeck(deck.subdeck(6, 7));
				b4.addDeck(deck.subdeck(8, 9));
				b5.addDeck(deck.subdeck(10, 11));
				b6.addDeck(deck.subdeck(12, 13));
				b7.addDeck(deck.subdeck(14, 15));
				b8.addDeck(deck.subdeck(16, 17));
				b9.addDeck(deck.subdeck(18, 19));
				b10.addDeck(deck.subdeck(20, 21));
				left.addDeck(deck.subdeck(22, 51));
				break;
			default:
				System.out.println("too many");
				break;
			}

			left.shufflePile();
			if (count == 1) {
// TODO for little and big blind use rand int for if and else move left one
			} else {

			}
		}
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
