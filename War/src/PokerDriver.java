import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class PokerDriver {

	public PersonData player1 = new PersonData("player", 0, "", null);
	public static int playerPoints = 10000;
	public static int pot = 0;
	public static int lilB = 0;
	public static int b1P = 10000;
	public static int b2P = 10000;
	public static int b3P = 10000;
	public static int b4P = 10000;
	public static int b5P = 10000;
	public static int b6P = 10000;
	public static int b7P = 10000;
	public static int b8P = 10000;
	public static int b9P = 10000;
	public static int b10P = 10000;
	public static int count = 1;	
	public static int botAmount = 0;
	public static int preBet = 0;
	public static int preChoice = 0;
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
	public static boolean cFH = false;
	public static boolean cSF = false;
	public static boolean c1P = false;
	public static boolean c2P = false;
	public static boolean cF = false; 
	public static boolean cS = false;
	public static boolean c4K = false;
	public static boolean c3K = false;
	public static Card high = null;  
	public static Card highP = null;
	public static Card high1 = null;
	public static Card high2 = null;
	public static Card high3 = null;
	public static Card high4 = null;
	public static Card high5 = null;
	public static Card high6 = null;
	public static Card high7 = null;
	public static Card high8 = null;
	public static Card high9 = null;
	public static Card high10 = null;
	public static int[] combo;
	public static boolean fold = false;
	public static char again = 'y';
	
	public static void main(String[] args) {
		int choice = 0;
		// TODO add file writer and reader for high-score
		int bet = 0;

		Deck deck = new Deck();

		deck.shuffle();

		System.out.println("Please enter the amount of bots you want to play against.");
		botAmount = input.nextInt();
		ArrayList<String> pAtT = new ArrayList<>(botAmount + 1);
		combo = new int[botAmount + 1];

		while (again == 'y' || again == 'Y') {

			roundSetup(deck, pAtT);
			
			left.shufflesPiles(left);

			if (count == 1) {
				Collections.shuffle(pAtT);
			} else {
				lilB += 1;
			}
			System.out.println(player);
			if (pAtT.get(lilB).equals("player")) {
				pStartingBet(bet, pAtT);
			} else {
				bStartingBet(bet, pAtT);
			}
			System.out.println(pot);
			System.out.println(playerPoints);

			betting(choice, bet, pAtT);
			if (fold == true) continue;
			if (choice != 3) preChoice = 4;
			for(int i = 0; i < 3; i++) {
			table.addCard(left.popCard());
			}
			System.out.println(table);
			System.out.println();
			System.out.println(pot);
			betting(choice, bet, pAtT);
			if (fold == true) continue;
			table.addCard(left.popCard());
			System.out.println(table);
			System.out.println();
			System.out.println(pot);
			betting(choice, bet, pAtT);
			
			if (fold == true) continue;
			table.addCard(left.popCard());
			System.out.println(pot);
			System.out.println();
			System.out.println(table);
			System.out.println();
			System.out.println(player);
			System.out.println();
			checkHand(pAtT);
			compareH(pAtT);
			count++;
			if (count == botAmount+1) {
				lilB = 0;
				count = 2;
			}
			System.out.println(playerPoints);
			if (playerPoints <= 0) {
				System.out.println("You lost!");
				break;
			}
			
			reset();
			resetBools();
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

	public static void pStartingBet(int bet2, ArrayList<String> pAtT2) {
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
		preBet = bet2;
	}
// when the user starts the round
	public static void bStartingBet(int bet2, ArrayList<String> pAtT2) {
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
		preBet = bet2;
	}
//when bots else starts the round
 	public static void roundSetup(Deck deck, ArrayList<String> pAtT) {

		deck.shuffle();

		switch (botAmount) {
		case 1:
			player.addDeck(deck.subdeck(0, 1));
			b1.addDeck(deck.subdeck(2, 3));
			if (count == 1) {
			pAtT.add("player");
			pAtT.add("b1");
			}
			left.addDeck(deck.subdeck(4, 51));
			break;
		case 2:
			player.addDeck(deck.subdeck(0, 1));
			b1.addDeck(deck.subdeck(2, 3));
			b2.addDeck(deck.subdeck(4, 5));
			if (count == 1) {
			pAtT.add("player");
			pAtT.add("b1");
			pAtT.add("b2");
			}
			left.addDeck(deck.subdeck(6, 51));
			break;
		case 3:
			player.addDeck(deck.subdeck(0, 1));
			b1.addDeck(deck.subdeck(2, 3));
			b2.addDeck(deck.subdeck(4, 5));
			b3.addDeck(deck.subdeck(6, 7));
			if (count == 1) {
			pAtT.add("player");
			pAtT.add("b1");
			pAtT.add("b2");
			pAtT.add("b3");
			}
			left.addDeck(deck.subdeck(8, 51));
			break;
		case 4:
			player.addDeck(deck.subdeck(0, 1));
			b1.addDeck(deck.subdeck(2, 3));
			b2.addDeck(deck.subdeck(4, 5));
			b3.addDeck(deck.subdeck(6, 7));
			b4.addDeck(deck.subdeck(8, 9));
			if (count == 1) {
			pAtT.add("player");
			pAtT.add("b1");
			pAtT.add("b2");
			pAtT.add("b3");
			pAtT.add("b4");
			}
			left.addDeck(deck.subdeck(10, 51));
			break;
		case 5:
			player.addDeck(deck.subdeck(0, 1));
			b1.addDeck(deck.subdeck(2, 3));
			b2.addDeck(deck.subdeck(4, 5));
			b3.addDeck(deck.subdeck(6, 7));
			b4.addDeck(deck.subdeck(8, 9));
			b5.addDeck(deck.subdeck(10, 11));
			if (count == 1) {
			pAtT.add("player");
			pAtT.add("b1");
			pAtT.add("b2");
			pAtT.add("b3");
			pAtT.add("b4");
			pAtT.add("b5");
			}
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
			if (count == 1) {
			pAtT.add("player");
			pAtT.add("b1");
			pAtT.add("b2");
			pAtT.add("b3");
			pAtT.add("b4");
			pAtT.add("b5");
			pAtT.add("b6");
			}
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
			if (count == 1) {
			pAtT.add("player");
			pAtT.add("b1");
			pAtT.add("b2");
			pAtT.add("b3");
			pAtT.add("b4");
			pAtT.add("b5");
			pAtT.add("b6");
			pAtT.add("b7");
			}
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
			if (count == 1) {
			pAtT.add("player");
			pAtT.add("b1");
			pAtT.add("b2");
			pAtT.add("b3");
			pAtT.add("b4");
			pAtT.add("b5");
			pAtT.add("b6");
			pAtT.add("b7");
			pAtT.add("b8");
			}
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
			if (count == 1) {
			pAtT.add("player");
			pAtT.add("b1");
			pAtT.add("b2");
			pAtT.add("b3");
			pAtT.add("b4");
			pAtT.add("b5");
			pAtT.add("b6");
			pAtT.add("b7");
			pAtT.add("b8");
			pAtT.add("b9");
			}
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
			if (count == 1) {
			pAtT.add("player");
			pAtT.add("b1");
			pAtT.add("b2");
			pAtT.add("b3");
			pAtT.add("b4");
			pAtT.add("b5");
			pAtT.add("b6");
			pAtT.add("b7");
			pAtT.add("b8");
			pAtT.add("b9");
			pAtT.add("b10");
			}
			left.addDeck(deck.subdeck(22, 51));
			break;
		default:
			System.out.println("too many ");
			break;
		}
	}
//setups up round based on how what amount is typed in
	public static void betting(int choice, int bet, ArrayList<String> pAtT) {
		boolean got = true;
		int n = pAtT.size();
		int c2 =0;
		for (int i = 0; i < n - c2; i++) {
			got = true;
			while (got) {
				if (pAtT.get(i).equals("player")) {
					System.out.println("Choose \n1. fold \n2. call \n3. raise \n4. check");
					choice = input.nextInt();
				} else {
					choice = rand.nextInt(4-2+1) + 2;
				}
				switch (choice) {
				case 1:
					if (pAtT.get(i).equals("player")) {
						fold = true;
						System.out.println("Play another round?");
						again = input.next().charAt(0);
					}
					pAtT.remove(i);
					c2++;
					got = false;
					break;
				case 2:
					bet = preBet;
					playerPoints -= bet;
					pot += bet;
					preChoice = choice;
					got = false;
					break;
				case 3:
					while (preBet >= bet) {
						if (pAtT.get(i).equals("player")) {
							System.out.println("Must be greater than the current bet:" + preBet + ".");
							bet = input.nextInt();
						} else {
							bet = rand.nextInt(40) + preBet+1;
						}
					}
					preBet = bet;
					preChoice = choice;
					playerPoints -= bet;
					pot += bet;
					got = false;
					break;
				case 4:
					if (preChoice == choice) {
						got = false;
					} else {
						if (pAtT.get(i).equals("player")) {
						System.out.println("Pick another option.");
						}
					}
					break;
				default:
					System.out.println("error");
					break;
				}
			}
		}
	}
/* as it says betting: folding, calling, raising, checking.
 * don't really know how to get bots to fold without breaking the game.
 */
	public static void checkPair(Pile hand) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.sortByRank(checkPile);
		for (int i = 0; i < 6; i++) {
				if (checkPile.get(i).onePair(checkPile.get(i+1))) {
					c1P = true;
			}
		}
	}
//all these methods check for different hand combos
	public static void checkFullHouse(Pile hand) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.sortByRank(checkPile);
		for (int i = 0; i < 5; i++) {
			if (checkPile.get(i).threeOfAKind(checkPile.get(i+1), checkPile.get(i+2))) {
				for (int j = 0; j < 6; j++) {
					if (checkPile.get(j).onePair(checkPile.get(j+1)) && checkPile.get(i) != checkPile.get(j)) {
						cFH = true;
						if (checkPile.getRanked(j) > checkPile.getRanked(i)) {
							high = checkPile.get(j);
						} else { 
							high = checkPile.get(i);
						}
					}
				}
			}	
		}
	}
	
	public static void checkFlush(Pile hand) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.sortBySuit(checkPile);
		for (int i = 0; i < 3; i++) {
			if (checkPile.get(i).flush(checkPile.get(i+1), checkPile.get(i+2), checkPile.get(i+3), checkPile.get(i+4))) {
				cF = true;
				if (checkPile.getRanked(i) > checkPile.getRanked(i+1) && checkPile.getRanked(i) > checkPile.getRanked(i+2) 
						&& checkPile.getRanked(i) > checkPile.getRanked(i+3) && checkPile.getRanked(i) > checkPile.getRanked(i+4)) {
					high = checkPile.get(i);
				} else if (checkPile.getRanked(i+1) > checkPile.getRanked(i) && checkPile.getRanked(i+1) > checkPile.getRanked(i+2) 
						&& checkPile.getRanked(i+1) > checkPile.getRanked(i+3) && checkPile.getRanked(i+1) > checkPile.getRanked(i+4)) {
					high = checkPile.get(i+1);
				} else if (checkPile.getRanked(i+2) > checkPile.getRanked(i) && checkPile.getRanked(i+2) > checkPile.getRanked(i+1) 
						&& checkPile.getRanked(i+2) > checkPile.getRanked(i+3) && checkPile.getRanked(i+2) > checkPile.getRanked(i+4)) {
					high = checkPile.get(i+2);
				} else if (checkPile.getRanked(i+3) > checkPile.getRanked(i) && checkPile.getRanked(i+3) > checkPile.getRanked(i+1) 
						&& checkPile.getRanked(i+3) > checkPile.getRanked(i+2) && checkPile.getRanked(i+3) > checkPile.getRanked(i+4)) {
					high = checkPile.get(i+3);
				} else {
					high = checkPile.get(i+4);
				}
			}		
		}
	}
	
	public static void checkTwoPairs(Pile hand) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.sortByRank(checkPile);
		for (int i = 0; i < 6; i++) {
			if (checkPile.get(i).onePair(checkPile.get(i+1))) {
				for(int j = 0; j < 6; j++) {
					if (checkPile.get(j).onePair(checkPile.get(j+1)) && checkPile.get(i) != checkPile.get(j)) {
						c2P = true;
						if (checkPile.getRanked(j) > checkPile.getRanked(i)) { 
							high = checkPile.get(j);
						} else {
							high = checkPile.get(i);
						}
					}
				}
			}
		}
	}
	
	public static void checkStraight(Pile hand) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.sortByRank(checkPile);
		checkPile.removeDupes(checkPile);
		int n = checkPile.size();
		System.out.println(n);
		for (int i = 0; i <= n-5; i++) {
			if (checkPile.get(i).straight(checkPile.get(i+1), checkPile.get(i+2), checkPile.get(i+3), checkPile.get(i+4))) {
				cS = true;
				high = checkPile.get(i+4);
			}
		}
	}
	
	public static void checkStraightFlush(Pile hand) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.selectionSortP(checkPile);
		checkPile.removeDupes(checkPile);
		int n = checkPile.size();
		System.out.println(n);
		for (int i = 0; i <= n-5; i++) {
			if (checkPile.get(i).straightFlush(checkPile.get(i+1), checkPile.get(i+2), checkPile.get(i+3), checkPile.get(i+4))) {
				cSF = true;
				high = checkPile.get(i+4);
			}
		}
	}
	
	public static void checkFourOfAKind(Pile hand) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.sortByRank(checkPile);
		for (int i = 0; i < 4; i++) {
			if (checkPile.get(i).fourOfAKind(checkPile.get(i+1), checkPile.get(i+2), checkPile.get(i+3))) {
				high = checkPile.get(i);
				c4K = true;
			}
		}
	}
	
	public static void checkThreeOfAKind(Pile hand) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.sortByRank(checkPile);
		for (int i = 0; i < 5; i++) {
			if (checkPile.get(i).threeOfAKind(checkPile.get(i+1), checkPile.get(i+2))) {
				high = checkPile.get(i);
				c3K = true;
			}
		}
	}	
	
	public static void reset() {
		player.clear();
		b1.clear();
		b2.clear();
		b3.clear();
		b4.clear();
		b5.clear();
		b6.clear();
		b7.clear();
		b8.clear();
		b7.clear();
		b8.clear();
		b9.clear();
		b10.clear();
		table.clear();
		left.clear();
		for (int i = 0; i < combo.length; i++) {
			combo[i] = 0;
		}
		if(b1P <= 0) {
			b1P = 10000;
		} if(b2P <= 0) {
			b2P = 10000;
		} if(b3P <= 0) {
			b3P = 10000;
		} if(b4P <= 0) {
			b4P = 10000;
		} if(b5P <= 0) {
			b5P = 10000;
		} if(b6P <= 0) {
			b6P = 10000;
		} if(b7P <= 0) {
			b7P = 10000;
		} if(b8P <= 0) {
			b8P = 10000;
		} if(b9P <= 0) {
			b9P = 10000;
		} if(b10P <= 0) {
			b10P = 10000;
		}
	}
//resets the piles and hand rank for the beginning rounds 
	public static void resetBools() {
 		cFH = false;
 		c2P = false;
 		c3K = false;
 		c4K = false;
 		cF = false;
 		c1P = false;
 		cS = false;
 		cSF = false;
 	}
//resets the booleans for the combo checks
	public static void checkHand(ArrayList<String> pAtT) {
 		int n = pAtT.size();
 		for (int i = 0; i < n; i++) {
 			if (pAtT.get(i).equals("player")) {
 				player.sortByRank(player);
 		 		highP = player.get(1);
 				checkPair(player);
 				if (c1P) { 
 					combo[i] = 1;
 				 }
 				checkTwoPairs(player);
 				if (c2P) {
 					highP = high; 
 					combo[i] = 2;
 				 }
 				checkThreeOfAKind(player);
 				if (c3K) {
 					highP = high; 
 					combo[i] = 3;
 				 }
 				checkStraight(player);
 				if (cS) {
  					highP = high; 
  					combo[i] = 4;
  				 } 
 				checkFlush(player);
 				if (cF) {
  					highP = high; 
  					combo[i] = 5;
  				 }
 				checkFullHouse(player);
 				if (cFH) {
  					highP = high; 
  					combo[i] = 6;
  				 }
 				checkFourOfAKind(player);
 				 if (c4K) {
  					highP = high; 
  					combo[i] = 7;
  				 }
 				checkStraightFlush(player);
 				 if (cSF) {
 					highP = high; 
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b1")) {
 				b1.sortByRank(b1);
 		 		high1 = b1.get(1);
 				checkPair(b1);
 				if (c1P) { 
 					combo[i] = 1;
 				 }
 				checkTwoPairs(b1);
 				if (c2P) {
 					high1 = high; 
 					combo[i] = 2;
 				 }
 				checkThreeOfAKind(b1);
 				if (c3K) {
 					high1 = high; 
 					combo[i] = 3;
 				 }
 				checkStraight(b1);
 				if (cS) {
 					high1 = high; 
 					combo[i] = 4;
  				 } 
 				checkFlush(b1);
 				if (cF) {
 					high1 = high; 
 					combo[i] = 5;
  				 }
 				checkFullHouse(b1);
 				if (cFH) {
 					high1 = high; 
 					combo[i] = 6;
  				 }
 				checkFourOfAKind(b1);
 				 if (c4K) {
 					high1 = high;
 					combo[i] = 7;
  				 }
 				checkStraightFlush(b1);
 				 if (cSF) {
 					high1 = high; 
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b2")) {
 				b2.sortByRank(b2);
 		 		high2 = b2.get(1);
 				checkPair(b2);
 				if (c1P) {
 					combo[i] = 1;
 				 }
 				checkTwoPairs(b2);
 				if (c2P) {
 					high2 = high; 
 					combo[i] = 2;
 				 }
 				checkThreeOfAKind(b2);
 				if (c3K) {
 					high2 = high; 
 					combo[i] = 3;
 				 }
 				checkStraight(b2);
 				if (cS) {
 					high2 = high; 
 					combo[i] = 4;
  				 } 
 				checkFlush(b2);
 				if (cF) {
 					high2 = high; 
 					combo[i] = 5;
  				 }
 				checkFullHouse(b2);
 				if (cFH) {
 					high2 = high; 
 					combo[i] = 6;
  				 }
 				checkFourOfAKind(b2);
 				 if (c4K) {
 					high2 = high; 
 					combo[i] = 7;
  				 }
 				checkStraightFlush(b2);
 				 if (cSF) {
 					high2 = high; 
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b3")) {
 				b3.sortByRank(b3);
 		 		high3 = b3.get(1);
 				checkPair(b3);
 				if (c1P) { 
 					combo[i] = 1;
 				 }
 				checkTwoPairs(b3);
 				if (c2P) {
 					high3 = high; 
 					combo[i] = 2;
 				 }
 				checkThreeOfAKind(b3);
 				if (c3K) {
 					high3 = high;
 					combo[i] = 3;
 				 }
 				checkStraight(b3);
 				if (cS) {
 					high3 = high; 
 					combo[i] = 4;
  				 } 
 				checkFlush(b3);
 				if (cF) {
 					high3 = high;
 					combo[i] = 5;
  				 }
 				checkFullHouse(b3);
 				if (cFH) {
 					high3 = high; 
 					combo[i] = 6;
  				 }
 				checkFourOfAKind(b3);
 				 if (c4K) {
 					high3 = high; 
 					combo[i] = 7;
  				 }
 				checkStraightFlush(b3);
 				 if (cSF) {
 					high3 = high; 
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b4")) {
 				b4.sortByRank(b4);
 		 		high4 = b4.get(1);
 				checkPair(b4);
 				if (c1P) {
 					combo[i] = 1;
 				 }
 				checkTwoPairs(b4);
 				if (c2P) {
 					high4 = high; 
 					combo[i] = 2;
 				 }
 				checkThreeOfAKind(b4);
 				if (c3K) {
 					high4 = high; 
 					combo[i] = 3;
 				 }
 				checkStraight(b4);
 				if (cS) {
 					high4 = high; 
 					combo[i] = 4;
  				 } 
 				checkFlush(b4);
 				if (cF) {
 					high4 = high; 
 					combo[i] = 5;
 				}
 				checkFullHouse(b4);
 				if (cFH) {
 					high4 = high; 
 					combo[i] = 6;
  				 }
 				checkFourOfAKind(b4);
 				 if (c4K) {
 					high4 = high; 
 					combo[i] = 7;
  				 }
 				checkStraightFlush(b4);
 				 if (cSF) {
 					high4 = high; 
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b5")) {
 				b5.sortByRank(b5);
 		 		high5 = b5.get(1);
 				checkPair(b5);
 				if (c1P) {
 					combo[i] = 1;
 				 }
 				checkTwoPairs(b5);
 				if (c2P) {
 					high5 = high; 
 					combo[i] = 2;
 				 }
 				checkThreeOfAKind(b5);
 				if (c3K) {
 					high5 = high; 
 					combo[i] = 3;
 				 }
 				checkStraight(b5);
 				if (cS) {
 					high5 = high;
 					combo[i] = 4;
  				 } 
 				checkFlush(b5);
 				if (cF) {
 					high5 = high; 
 					combo[i] = 5;
  				 }
 				checkFullHouse(b5);
 				if (cFH) {
 					high5 = high;
 					combo[i] = 6;
  				 }
 				checkFourOfAKind(b5);
 				 if (c4K) {
 					high5 = high; 
 					combo[i] = 7;
  				 }
 				checkStraightFlush(b5);
 				 if (cSF) {
 					high5 = high;
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b6")) {
 				b6.sortByRank(b6);
 		 		high6 = b6.get(1);
 				checkPair(b6);
 				if (c1P) {
 					combo[i] = 1;
 				 }
 				checkTwoPairs(b6);
 				if (c2P) {
 					high6 = high; 
 					combo[i] = 2;
 				 }
 				checkThreeOfAKind(b6);
 				if (c3K) {
 					high6 = high; 
 					combo[i] = 3;
 				 }
 				checkStraight(b6);
 				if (cS) {
 					high6 = high; 
 					combo[i] = 4;
  				 } 
 				checkFlush(b6);
 				if (cF) {
 					high6 = high; 
 					combo[i] = 5;
  				 }
 				checkFullHouse(b6);
 				if (cFH) {
 					high6 = high; 
 					combo[i] = 6;
  				 }
 				checkFourOfAKind(b6);
 				 if (c4K) {
 					high6 = high; 
 					combo[i] = 7;
  				 }
 				checkStraightFlush(b6);
 				 if (cSF) {
 					high6 = high; 
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b7")) {
 				b7.sortByRank(b7);
 		 		high7 = b7.get(1);
 				checkPair(b7);
 				if (c1P) { 
 					combo[i] = 1;
 				 }
 				checkTwoPairs(b7);
 				if (c2P) {
 					high7 = high; 
 					combo[i] = 2;
 				 }
 				checkThreeOfAKind(b7);
 				if (c3K) {
 					high7 = high; 
 					combo[i] = 3;
 				 }
 				checkStraight(b7);
 				if (cS) {
 					high7 = high; 
 					combo[i] = 4;
  				 } 
 				checkFlush(b7);
 				if (cF) {
 					high7 = high; 
 					combo[i] = 5;
  				 }
 				checkFullHouse(b7);
 				if (cFH) {
 					high7 = high; 
 					combo[i] = 6;
  				 }
 				checkFourOfAKind(b7);
 				 if (c4K) {
 					high7 = high; 
 					combo[i] = 7;
  				 }
 				checkStraightFlush(b7);
 				 if (cSF) {
 					high7 = high; 
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b8")) {
 				b8.sortByRank(b8);
 		 		high8 = b8.get(1);
 				checkPair(b8);
 				if (c1P) {; 
 					combo[i] = 1;
 				 }
 				checkTwoPairs(b8);
 				if (c2P) {
 					high8 = high; 
 					combo[i] = 2;
 				 }
 				checkThreeOfAKind(b8);
 				if (c3K) {
 					high8 = high; 
 					combo[i] = 3;
 				 }
 				checkStraight(b8);
 				if (cS) {
 					high8 = high; 
 					combo[i] = 4;
  				 } 
 				checkFlush(b8);
 				if (cF) {
 					high8 = high; 
 					combo[i] = 5;
  				 }
 				checkFullHouse(b8);
 				if (cFH) {
 					high8 = high;
 					combo[i] = 6;
  				 }
 				checkFourOfAKind(b8);
 				 if (c4K) {
 					high8 = high; 
 					combo[i] = 7;
  				 }
 				checkStraightFlush(b8);
 				 if (cSF) {
 					high8 = high; 
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b9")) {
 				b9.sortByRank(b9);
 		 		high9 = b9.get(1);
 				checkPair(b9);
 				if (c1P) { 
 					combo[i] = 1;
 				 }
 				checkTwoPairs(b9);
 				if (c2P) {
 					high9 = high; 
 					combo[i] = 2;
 				 }
 				checkThreeOfAKind(b9);
 				if (c3K) {
 					high9 = high; 
 					combo[i] = 3;
 				 }
 				checkStraight(b9);
 				if (cS) {
 					high9 = high;
 					combo[i] = 4;
  				 } 
 				checkFlush(b9);
 				if (cF) {
 					high9 = high; 
 					combo[i] = 5;
  				 }
 				checkFullHouse(b9);
 				if (cFH) {
 					high9 = high; 
 					combo[i] = 6;
  				 }
 				checkFourOfAKind(b9);
 				 if (c4K) {
  					high9 = high; 
  					combo[i] = 7;
  				 }
 				checkStraightFlush(b9);
 				 if (cSF) {
  					high9 = high;
  					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b10")) {
 				b10.sortByRank(b10);
 		 		high10 = b10.get(1);
 				checkPair(b10);
 				if (c1P) { 
 					combo[i] = 1;
 				 }
 				checkTwoPairs(b10);
 				if (c2P) {
 					high10 = high;
 					combo[i] = 2;
 				 }
 				checkThreeOfAKind(b10);
 				if (c3K) {
 					high10 = high;
 					combo[i] = 3;
 				 }
 				checkStraight(b10);
 				if (cS) {
 					high10 = high; 
 					combo[i] = 4;
  				 } 
 				checkFlush(b10);
 				if (cF) {
 					high10 = high; 
 					combo[i] = 5;
  				 }
 				checkFullHouse(b10);
 				if (cFH) {
 					high10 = high; 
 					combo[i] = 6;
  				 }
 				checkFourOfAKind(b10);
 				 if (c4K) {
 					high10 = high;
 					combo[i] = 7;
  				 }
 				checkStraightFlush(b10);
 				 if (cSF) {
 					high10 = high; 
 					combo[i] = 8;
 				 }
 				resetBools();
 			}
 		}
 	}
//runs through all the checks and assigns high cards
	public static void compareH(ArrayList<String> pAtT) {
		int highest = 0;
		int highest2 = 0;
		String name = "";
		String name2 = "";
		Card hC = null;
		Card hC2 = null;
		int n = pAtT.size();
		for (int i = 0; i < n; i++) {
			if (combo[i] > highest) {
				highest = combo[i];
				name = pAtT.get(i);
				if (name.equals("player")) { 
					hC = highP;
				} if (name.equals("b1")) { 
					hC = high1;
				} if (name.equals("b2")) { 
					hC = high2;
				} if (name.equals("b3")) { 
					hC = high3;
				} if (name.equals("b4")) { 
					hC = high4;
				} if (name.equals("b5")) { 
					hC = high5;
				} if (name.equals("b6")) { 
					hC = high6;
				} if (name.equals("b7")) { 
					hC = high7;
				} if (name.equals("b8")) { 
					hC = high8;
				} if (name.equals("b9")) { 
					hC = high9;
				} if (name.equals("b10")) { 
					hC = high10;
				} 
			}else if (combo[i] == highest && (!name.equals(name2))) {
				//Set way to check which has the highest card amongst the players if combo and highest equal each other.
				highest2 = combo[i];
				name2 = pAtT.get(i);
				if (name2.equals("player")) { 
					hC2 = highP;
				} if (name2.equals("b1")) { 
					hC2 = high1;
				} if (name2.equals("b2")) { 
					hC2 = high2;
				} if (name2.equals("b3")) { 
					hC2 = high3;
				} if (name2.equals("b4")) { 
					hC2 = high4;
				} if (name2.equals("b5")) { 
					hC2 = high5;
				} if (name2.equals("b6")) { 
					hC2 = high6;
				} if (name2.equals("b7")) { 
					hC2 = high7;
				} if (name2.equals("b8")) { 
					hC2 = high8;
				} if (name2.equals("b9")) { 
					hC2 = high9;
				} if (name2.equals("b10")) { 
					hC2 = high10;
				} 
				if (hC2.getRank() > hC.getRank()) {
					highest = highest2;
					name = name2;
					hC = hC2;
				}
			}
		}
		if (highest == highest2 && hC.getRank() == hC2.getRank() && (!name.equals(name2))) {
			System.out.print(name + " tied with " + name2);
			if (name.equals("player")) { 
				playerPoints += pot/2;
			} if (name.equals("b1")) { 
				b1P += pot/2;
			} if (name.equals("b2")) { 
				b2P += pot/2;
			} if (name.equals("b3")) { 
				b3P += pot/2;
			} if (name.equals("b4")) { 
				b4P += pot/2;
			} if (name.equals("b5")) { 
				b5P += pot/2;
			} if (name.equals("b6")) { 
				b6P += pot/2;
			} if (name.equals("b7")) { 
				b7P += pot/2;
			} if (name.equals("b8")) { 
				b8P += pot/2;
			} if (name.equals("b9")) { 
				b9P += pot/2;
			} if (name.equals("b10")) { 
				b10P += pot/2;
			} 
			if (name2.equals("player")) { 
				playerPoints += pot/2;
			} if (name2.equals("b1")) { 
				b1P += pot/2;
			} if (name2.equals("b2")) { 
				b2P += pot/2;
			} if (name2.equals("b3")) { 
				b3P += pot/2;
			} if (name2.equals("b4")) { 
				b4P += pot/2;
			} if (name2.equals("b5")) { 
				b5P += pot/2;
			} if (name2.equals("b6")) { 
				b6P += pot/2;
			} if (name2.equals("b7")) { 
				b7P += pot/2;
			} if (name2.equals("b8")) { 
				b8P += pot/2;
			} if (name2.equals("b9")) { 
				b9P += pot/2;
			} if (name2.equals("b10")) { 
				b10P += pot/2;
			} 
		} else {
			System.out.print(name + " wins");
			if (name.equals("player")) { 
				playerPoints += pot;
			} if (name.equals("b1")) { 
				b1P += pot;
			} if (name.equals("b2")) { 
				b2P += pot;
			} if (name.equals("b3")) { 
				b3P += pot;
			} if (name.equals("b4")) { 
				b4P += pot;
			} if (name.equals("b5")) { 
				b5P += pot;
			} if (name.equals("b6")) { 
				b6P += pot;
			} if (name.equals("b7")) { 
				b7P += pot;
			} if (name.equals("b8")) { 
				b8P += pot;
			} if (name.equals("b9")) { 
				b9P += pot;
			} if (name.equals("b10")) { 
				b10P += pot;
			} 
		}
		if (highest == 0) {
			System.out.println(" by having the highest card: " + hC + "!");
		} else if (highest == 1) {
			System.out.println(" by having one pair!");
		} else if (highest == 2) {
			System.out.println(" by having two pairs!");
		} else if (highest == 3) {
			System.out.println(" by having three of a kind!");
		} else if (highest == 4) {
			System.out.println(" by having a straight!");
		} else if (highest == 5) {
			System.out.println(" by having a flush!");
		} else if (highest == 6) {
			System.out.println(" by having a full house!");
		} else if (highest == 7) {
			System.out.println(" by having four of a kind!");
		} else if (highest == 8) {
			System.out.println(" by having a straight flush!");
		}
		pot = 0;
		
	}
//determines who wins
}
