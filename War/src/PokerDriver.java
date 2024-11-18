import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class PokerDriver {

	public static int playerPoints = 1000;
	public static int pot = 0;
	public static int lilB = 0;
	public static int botP = 1000;
	public static int b1P = 1000;
	public static int b2P = 1000;
	public static int b3P = 1000;
	public static int b4P = 1000;
	public static int b5P = 1000;
	public static int b6P = 1000;
	public static int b7P = 1000;
	public static int b8P = 1000;
	public static int b9P = 1000;
	public static int b10P = 1000;
	public static int botAmount = 0;
	public static Random rand = new Random();
	public static Scanner input = new Scanner(System.in);
	public static Pile player = new Pile();
	public static Pile b1 = new Pile();
	public static Pile b2 = new Pile();
	public static Pile b3 = new Pile();
	public static Pile b4 = new Pile();
	public static Pile b5 = new Pile();
	public static Pile b6 = new Pile();
	public static Pile b7 = new Pile();
	public static Pile b8 = new Pile();
	public static Pile b9 = new Pile();
	public static Pile b10 = new Pile();
	public static Pile left = new Pile();
	public static Pile table = new Pile();
	public static int count = 1;

	public static void main(String[] args) {
		int choice = 0;
		char again = 'y';
		// array for points maybe?
		// TODO add file writer and reader for high-score
		int bet = 0;
		int preBet = 0;

		Deck deck = new Deck();

		deck.shuffle();

		System.out.println("Please enter the amount of bots you want to play against.");
		botAmount = input.nextInt();
		ArrayList<String> pAtT = new ArrayList<>(botAmount + 1);

		while (again == 'y' || again == 'Y') {

			roundSetup(deck, pAtT);
			
			left.shufflesPiles(left);

			if (count == 1) {
				Collections.shuffle(pAtT);
			} else {
				lilB += 1;
			}
			if (pAtT.get(lilB).equals("player")) {
				pStartingBet(bet, preBet, pAtT);
			} else {
				bStartingBet(bet, preBet, pAtT);
			}
			System.out.println(pot);
			System.out.println(playerPoints);

			betting(choice, bet, preBet, again);
			if (choice == 1) continue;
			
			for(int i = 0; i < 3; i++) {
			table.addCard(left.popCard());
			}
			betting(choice, bet, preBet, again);
			if (choice == 1) continue;
			table.addCard(left.popCard());
			betting(choice, bet, preBet, again);
			if (choice == 1) continue;
			table.addCard(left.popCard());
			int test = table.size();
			
			System.out.println(table);
			System.out.println();
			table.sortPiles(table);
			System.out.println(table);
			
			System.out.println(player);
			
			System.out.println(checkPair(player, table));
			System.out.println(test);
			System.out.println(player.size());
			count++;

			System.out.println("Play again?");
			again = input.next().charAt(0);
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

	public static void pStartingBet(int bet2, int preBet2, ArrayList<String> pAtT2) {
		System.out.println("Choose starting bet: \n1. 1 \n2. 4 \n3. 10");
		bet2 = input.nextInt();
		switch (bet2) {
		case 1:
			playerPoints -= 1;
			pot += 1;
			bet2 = 2;
			break;
		case 2:
			playerPoints -= 4;
			pot += 4;
			bet2 = 8;
			break;
		case 3:
			playerPoints -= 10;
			pot += 10;
			bet2 = 15;
			break;
		default:
			System.out.println("Only pick 1 - 3");
		}
		if (pAtT2.get(lilB+1).equals("b1")) {
			b1P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b2")) {
			b2P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b3")) {
			b3P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b4")) {
			b4P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b5")) {
			b5P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b6")) {
			b6P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b7")) {
			b7P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b8")) {
			b8P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b9")) {
			b9P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b10")) {
			b10P -= bet2;
		}
		pot += bet2;
		preBet2 = bet2;
	}

	public static void bStartingBet(int bet2, int preBet2, ArrayList<String> pAtT2) {
		bet2 = rand.nextInt(3) + 1;
		if (pAtT2.get(lilB).equals("b1")) {
			switch (bet2) {
			case 1:
				b1P -= 1;
				pot += 1;
				bet2 = 2;
				break;
			case 2:
				b1P -= 4;
				pot += 4;
				bet2 = 8;
				break;
			case 3:
				b1P -= 10;
				pot += 10;
				bet2 = 15;
				break;
			default:
				System.out.println("Only pick 1 - 3");
			}
		} else if (pAtT2.get(lilB).equals("b2")) {
			switch (bet2) {
			case 1:
				b2P -= 1;
				pot += 1;
				bet2 = 2;
				break;
			case 2:
				b2P -= 4;
				pot += 4;
				bet2 = 8;
				break;
			case 3:
				b2P -= 10;
				pot += 10;
				bet2 = 15;
				break;
			default:
				System.out.println("Only pick 1 - 3");
			}
		} else if (pAtT2.get(lilB).equals("b3")) {
			switch (bet2) {
			case 1:
				b3P -= 1;
				pot += 1;
				bet2 = 2;
				break;
			case 2:
				b3P -= 4;
				pot += 4;
				bet2 = 8;
				break;
			case 3:
				b3P -= 10;
				pot += 10;
				bet2 = 15;
				break;
			default:
				System.out.println("Only pick 1 - 3");
			}
		} else if (pAtT2.get(lilB).equals("b4")) {
			switch (bet2) {
			case 1:
				b4P -= 1;
				pot += 1;
				bet2 = 2;
				break;
			case 2:
				b4P -= 4;
				pot += 4;
				bet2 = 8;
				break;
			case 3:
				b4P -= 10;
				pot += 10;
				bet2 = 15;
				break;
			default:
				System.out.println("Only pick 1 - 3");
			}
		} else if (pAtT2.get(lilB).equals("b5")) {
			switch (bet2) {
			case 1:
				b5P -= 1;
				pot += 1;
				bet2 = 2;
				break;
			case 2:
				b5P -= 4;
				pot += 4;
				bet2 = 8;
				break;
			case 3:
				b5P -= 10;
				pot += 10;
				bet2 = 15;
				break;
			default:
				System.out.println("Only pick 1 - 3");
			}
		} else if (pAtT2.get(lilB).equals("b6")) {
			switch (bet2) {
			case 1:
				b6P -= 1;
				pot += 1;
				bet2 = 2;
				break;
			case 2:
				b6P -= 4;
				pot += 4;
				bet2 = 8;
				break;
			case 3:
				b6P -= 10;
				pot += 10;
				bet2 = 15;
				break;
			default:
				System.out.println("Only pick 1 - 3");
			}

		} else if (pAtT2.get(lilB).equals("b7")) {
			switch (bet2) {
			case 1:
				b7P -= 1;
				pot += 1;
				bet2 = 2;
				break;
			case 2:
				b7P -= 4;
				pot += 4;
				bet2 = 8;
				break;
			case 3:
				b7P -= 10;
				pot += 10;
				bet2 = 15;
				break;
			default:
				System.out.println("Only pick 1 - 3");
			}
		} else if (pAtT2.get(lilB).equals("b8")) {
			switch (bet2) {
			case 1:
				b8P -= 1;
				pot += 1;
				bet2 = 2;
				break;
			case 2:
				b8P -= 4;
				pot += 4;
				bet2 = 8;
				break;
			case 3:
				b8P -= 10;
				pot += 10;
				bet2 = 15;
				break;
			default:
				System.out.println("Only pick 1 - 3");
			}
		} else if (pAtT2.get(lilB).equals("b9")) {
			switch (bet2) {
			case 1:
				b9P -= 1;
				pot += 1;
				bet2 = 2;
				break;
			case 2:
				b9P -= 4;
				pot += 4;
				bet2 = 8;
				break;
			case 3:
				b9P -= 10;
				pot += 10;
				bet2 = 15;
				break;
			default:
				System.out.println("Only pick 1 - 3");
			}
		} else if (pAtT2.get(lilB).equals("b10")) {
			switch (bet2) {
			case 1:
				b10P -= 1;
				pot += 1;
				bet2 = 2;
				break;
			case 2:
				b10P -= 4;
				pot += 4;
				bet2 = 8;
				break;
			case 3:
				b10P -= 10;
				pot += 10;
				bet2 = 15;
				break;
			default:
				System.out.println("Only pick 1 - 3");
			}
		}
		if (pAtT2.get(lilB+1).equals("player")) {
			playerPoints -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b1")) {
			b1P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b2")) {
			b2P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b3")) {
			b3P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b4")) {
			b4P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b5")) {
			b5P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b6")) {
			b6P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b7")) {
			b7P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b8")) {
			b8P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b9")) {
			b9P -= bet2;
		} else if (pAtT2.get(lilB+1).equals("b10")) {
			b10P -= bet2;
		}
		pot += bet2;
		preBet2 = bet2;
	}

	public static void roundSetup(Deck deck, ArrayList<String> pAtT) {

		deck.shuffle();

		switch (botAmount) {
		case 1:
			player.addDeck(deck.subdeck(0, 1));
			b1.addDeck(deck.subdeck(2, 3));
			pAtT.add("player");
			pAtT.add("b1");
			left.addDeck(deck.subdeck(4, 51));
			break;
		case 2:
			player.addDeck(deck.subdeck(0, 1));
			b1.addDeck(deck.subdeck(2, 3));
			b2.addDeck(deck.subdeck(4, 5));
			pAtT.add("player");
			pAtT.add("b1");
			pAtT.add("b2");
			left.addDeck(deck.subdeck(6, 51));
			break;
		case 3:
			player.addDeck(deck.subdeck(0, 1));
			b1.addDeck(deck.subdeck(2, 3));
			b2.addDeck(deck.subdeck(4, 5));
			b3.addDeck(deck.subdeck(6, 7));
			pAtT.add("player");
			pAtT.add("b1");
			pAtT.add("b2");
			pAtT.add("b3");
			left.addDeck(deck.subdeck(8, 51));
			break;
		case 4:
			player.addDeck(deck.subdeck(0, 1));
			b1.addDeck(deck.subdeck(2, 3));
			b2.addDeck(deck.subdeck(4, 5));
			b3.addDeck(deck.subdeck(6, 7));
			b4.addDeck(deck.subdeck(8, 9));
			pAtT.add("player");
			pAtT.add("b1");
			pAtT.add("b2");
			pAtT.add("b3");
			pAtT.add("b4");
			left.addDeck(deck.subdeck(10, 51));
			break;
		case 5:
			player.addDeck(deck.subdeck(0, 1));
			b1.addDeck(deck.subdeck(2, 3));
			b2.addDeck(deck.subdeck(4, 5));
			b3.addDeck(deck.subdeck(6, 7));
			b4.addDeck(deck.subdeck(8, 9));
			b5.addDeck(deck.subdeck(10, 11));
			pAtT.add("player");
			pAtT.add("b1");
			pAtT.add("b2");
			pAtT.add("b3");
			pAtT.add("b4");
			pAtT.add("b5");
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
			pAtT.add("player");
			pAtT.add("b1");
			pAtT.add("b2");
			pAtT.add("b3");
			pAtT.add("b4");
			pAtT.add("b5");
			pAtT.add("b6");
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
			pAtT.add("player");
			pAtT.add("b1");
			pAtT.add("b2");
			pAtT.add("b3");
			pAtT.add("b4");
			pAtT.add("b5");
			pAtT.add("b6");
			pAtT.add("b7");
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
			pAtT.add("player");
			pAtT.add("bot_1");
			pAtT.add("bot_2");
			pAtT.add("b3");
			pAtT.add("b4");
			pAtT.add("b5");
			pAtT.add("b6");
			pAtT.add("b7");
			pAtT.add("b8");
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
			pAtT.add("player");
			pAtT.add("bot_1");
			pAtT.add("bot_2");
			pAtT.add("b3");
			pAtT.add("b4");
			pAtT.add("b5");
			pAtT.add("b6");
			pAtT.add("b7");
			pAtT.add("b8");
			pAtT.add("b9");
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
			pAtT.add("player");
			pAtT.add("bot_1");
			pAtT.add("bot_2");
			pAtT.add("b3");
			pAtT.add("b4");
			pAtT.add("b5");
			pAtT.add("b6");
			pAtT.add("b7");
			pAtT.add("b8");
			pAtT.add("b9");
			pAtT.add("b10");
			left.addDeck(deck.subdeck(22, 51));
			break;
		default:
			System.out.println("too many ");
			break;
		}
	}

	public static void betting(int choice, int bet, int preBet, char again) {

		System.out.println("Chose \n1. fold \n2. call \n3. raise");
		choice = input.nextInt();

		switch (choice) {
		case 1:
			System.out.println("Play another round?");
			again = input.next().charAt(0);
		case 2:
			bet = preBet;
			playerPoints -= bet;
			pot += bet;
			break;
		case 3:
			System.out.println("Must be greater than the current bet:" + preBet + ".");
			bet = input.nextInt();
			playerPoints -= bet;
			pot += bet;
			break;
		default:
			System.out.println("error");
			break;
		}
	}
	
	public static boolean checkPair(Pile hand, Pile commune) {
		boolean check = false;
		for (int i = 0; i < 5; i++) {
			if (i == 0) {
				if (hand.get(0).onePair(player.get(1))) {
					check = true;
				}
			}
			if (hand.get(0).onePair(commune.get(i))) {
				check = true;
			}	
			if (hand.get(1).onePair(commune.get(i))) {
				check = true;
			}
		}
		return check;
	}
}
