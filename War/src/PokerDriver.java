import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class PokerDriver {

	public PersonData player1 = new PersonData("player", 0, "", null);
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
	public static int count = 1;	
	public static int botAmount = 0;
	public static int preBet = 0;
	public static int preChoice = 0;
	public static String pHighH = "";
	public static String b1HighH = "";
	public static String b2HighH = "";
	public static String b3HighH = "";
	public static String b4HighH = "";
	public static String b5HighH = "";
	public static String b6HighH = "";
	public static String b7HighH = "";
	public static String b8HighH = "";
	public static String b9HighH = "";
	public static String b10HighH = "";
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
	public static Card high;  
	public static Card highP;
	public static Card high1;
	public static Card high2;
	public static Card high3;
	public static Card high4;
	public static Card high5;
	public static Card high6;
	public static Card high7;
	public static Card high8;
	public static Card high9;
	public static Card high10;
	public static void main(String[] args) {
		int choice = 0;
		char again = 'y';
		// TODO add file writer and reader for high-score
		int bet = 0;

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
				pStartingBet(bet, pAtT);
			} else {
				bStartingBet(bet, pAtT);
			}
			System.out.println(pot);
			System.out.println(playerPoints);

			betting(choice, bet, again, pAtT);
			if (choice == 1) continue;
			if (choice != 3) preChoice = 4;
			for(int i = 0; i < 3; i++) {
			table.addCard(left.popCard());
			}
			betting(choice, bet, again, pAtT);
			if (choice == 1) continue;
			table.addCard(left.popCard());
			betting(choice, bet, again, pAtT);
			if (choice == 1) continue;
			table.addCard(left.popCard());
			
			System.out.println(table);
			
			System.out.println(player);
			
			System.out.println();
//			checkPair(player);
			checkHand(pAtT);
			System.out.println(highP);
			
			count++;
			if (count == botAmount+1) {
				lilB = 0;
				count = 2;
			}
			reset(pAtT);
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
		preBet = bet2;
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

	public static void betting(int choice, int bet, char again, ArrayList<String> pAtT) {
		boolean got = true;
		int n = pAtT.size();
		for (int i = 0; i < n; i++) {
			got = true;
			while (got) {
				if (pAtT.get(i).equals("player")) {
					System.out.println("Choose \n1. fold \n2. call \n3. raise \n4. check");
					choice = input.nextInt();
				} else {
					choice = rand.nextInt(4) + 1;
				}
				switch (choice) {
				case 1:
					if (pAtT.get(i).equals("player")) {
					System.out.println("Play another round?");
					again = input.next().charAt(0);
					}
					pAtT.remove(i);
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
						System.out.println("Pick another option.");
					}
					break;
				default:
					System.out.println("error");
					break;
				}
			}
		}
	}
	
	public static void checkPair(Pile hand) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.sortByRank(checkPile);
		for (int i = 0; i < 6; i++) {
			if (i == 0) {
				if (checkPile.get(i).onePair(checkPile.get(i+1))) {
					c1P = true;
				}
			}
		}
	}
	
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
				System.out.println("" + checkPile.get(i) + checkPile.get(i+1) + checkPile.get(i+2) + checkPile.get(i+3) + checkPile.get(i+4));
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
				System.out.println("" + checkPile.get(i) + checkPile.get(i+1) + checkPile.get(i+2) + checkPile.get(i+3) + checkPile.get(i+4));
				cSF = true;
				high = checkPile.get(i+4);
			}
		}
		System.out.println("false");
	}
	
	public static void checkFourOfAKind(Pile hand) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.sortByRank(checkPile);
		for (int i = 0; i < 4; i++) {
			if (checkPile.get(i).fourOfAKind(checkPile.get(i+1), checkPile.get(i+2), checkPile.get(i+3))) {
				System.out.println("" + checkPile.get(i) + checkPile.get(i+1) + checkPile.get(i+2) + checkPile.get(i+3));
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
				System.out.println("" + checkPile.get(i) + checkPile.get(i+1) + checkPile.get(i+2));
				high = checkPile.get(i);
				c3K = true;
			}
		}
	}	
	
	public static void reset(ArrayList<String> pAtT) {
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
		pAtT.clear();
	}
	
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
 	
 	
	public static void checkHand(ArrayList<String> pAtT) {
 		int n = pAtT.size();
 		for (int i = 0; i < n; i++) {
 			if (pAtT.get(i).equals("player")) {
 				player.sortByRank(player);
 		 		highP = player.get(1);
 				checkPair(player);
 				if (c1P) { 
 					pHighH = "Pair";
 				 }
 				checkTwoPairs(player);
 				if (c2P) {
 					highP = high; 
 					pHighH = "2Ps";
 				 }
 				checkThreeOfAKind(player);
 				if (c3K) {
 					highP = high; 
 					pHighH = "3OAK";
 				 }
 				checkStraight(player);
 				if (cS) {
  					highP = high; 
  					pHighH = "Straight";
  				 } 
 				checkFlush(player);
 				if (cF) {
  					highP = high; 
  					pHighH = "Flush";
  				 }
 				checkFullHouse(player);
 				if (cFH) {
  					highP = high; 
  					pHighH = "FH";
  				 }
 				checkFourOfAKind(player);
 				 if (c4K) {
  					highP = high; 
  					pHighH = "4OAK";
  				 }
 				checkStraightFlush(player);
 				 if (cSF) {
 					highP = high; 
 					pHighH = "SF";
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b1")) {
 				b1.sortByRank(b1);
 		 		high1 = b1.get(1);
 				checkPair(b1);
 				if (c1P) { 
 					b1HighH = "Pair";
 				 }
 				checkTwoPairs(b1);
 				if (c2P) {
 					high1 = high; 
 					b1HighH = "2Ps";
 				 }
 				checkThreeOfAKind(b1);
 				if (c3K) {
 					high1 = high; 
 					b1HighH = "3OAK";
 				 }
 				checkStraight(b1);
 				if (cS) {
 					high1 = high; 
 					b1HighH = "Straight";
  				 } 
 				checkFlush(b1);
 				if (cF) {
 					high1 = high; 
 					b1HighH = "Flush";
  				 }
 				checkFullHouse(b1);
 				if (cFH) {
 					high1 = high; 
 					b1HighH = "FH";
  				 }
 				checkFourOfAKind(b1);
 				 if (c4K) {
 					high1 = high;
 					b1HighH = "4OAK";
  				 }
 				checkStraightFlush(b1);
 				 if (cSF) {
 					high1 = high; 
 					b1HighH = "SF";
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b2")) {
 				b2.sortByRank(b2);
 		 		high2 = b2.get(1);
 				checkPair(b2);
 				if (c1P) {
 					b2HighH = "Pair";
 				 }
 				checkTwoPairs(b2);
 				if (c2P) {
 					high2 = high; 
 					b2HighH = "2Ps";
 				 }
 				checkThreeOfAKind(b2);
 				if (c3K) {
 					high2 = high; 
 					b2HighH = "3OAK";
 				 }
 				checkStraight(b2);
 				if (cS) {
 					high2 = high; 
 					b2HighH = "Straight";
  				 } 
 				checkFlush(b2);
 				if (cF) {
 					high2 = high; 
 					b2HighH = "Flush";
  				 }
 				checkFullHouse(b2);
 				if (cFH) {
 					high2 = high; 
 					b2HighH = "FH";
  				 }
 				checkFourOfAKind(b2);
 				 if (c4K) {
 					high2 = high; 
 					b2HighH = "4OAK";
  				 }
 				checkStraightFlush(b2);
 				 if (cSF) {
 					high2 = high; 
 					b2HighH = "SF";
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b3")) {
 				b3.sortByRank(b3);
 		 		high3 = b3.get(1);
 				checkPair(b3);
 				if (c1P) { 
 					b3HighH = "Pair";
 				 }
 				checkTwoPairs(b3);
 				if (c2P) {
 					high3 = high; 
 					b3HighH = "2Ps";
 				 }
 				checkThreeOfAKind(b3);
 				if (c3K) {
 					high3 = high;
 					b3HighH = "3OAK";
 				 }
 				checkStraight(b3);
 				if (cS) {
 					high3 = high; 
 					b3HighH = "Straight";
  				 } 
 				checkFlush(b3);
 				if (cF) {
 					high3 = high;
 					b3HighH = "Flush";
  				 }
 				checkFullHouse(b3);
 				if (cFH) {
 					high3 = high; 
 					b3HighH = "FH";
  				 }
 				checkFourOfAKind(b3);
 				 if (c4K) {
 					high3 = high; 
 					b3HighH = "4OAK";
  				 }
 				checkStraightFlush(b3);
 				 if (cSF) {
 					high3 = high; 
 					b3HighH = "SF";
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b4")) {
 				b4.sortByRank(b4);
 		 		high4 = b4.get(1);
 				checkPair(b4);
 				if (c1P) {
 					b4HighH = "Pair";
 				 }
 				checkTwoPairs(b4);
 				if (c2P) {
 					high4 = high; 
 					b4HighH = "2Ps";
 				 }
 				checkThreeOfAKind(b4);
 				if (c3K) {
 					high4 = high; 
 					b4HighH = "3OAK";
 				 }
 				checkStraight(b4);
 				if (cS) {
 					high4 = high; 
 					b4HighH = "Straight";
  				 } 
 				checkFlush(b4);
 				if (cF) {
 					high4 = high; 
 					b4HighH = "Flush";
 				}
 				checkFullHouse(b4);
 				if (cFH) {
 					high4 = high; 
 					b4HighH = "FH";
  				 }
 				checkFourOfAKind(b4);
 				 if (c4K) {
 					high4 = high; 
 					b4HighH = "4OAK";
  				 }
 				checkStraightFlush(b4);
 				 if (cSF) {
 					high4 = high; 
 					b4HighH = "SF";
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b5")) {
 				b5.sortByRank(b5);
 		 		high5 = b5.get(1);
 				checkPair(b5);
 				if (c1P) {
 					b5HighH = "Pair";
 				 }
 				checkTwoPairs(b5);
 				if (c2P) {
 					high5 = high; 
 					b5HighH = "2Ps";
 				 }
 				checkThreeOfAKind(b5);
 				if (c3K) {
 					high5 = high; 
 					b5HighH = "3OAK";
 				 }
 				checkStraight(b5);
 				if (cS) {
 					high5 = high;
 					b5HighH = "Straight";
  				 } 
 				checkFlush(b5);
 				if (cF) {
 					high5 = high; 
 					b5HighH = "Flush";
  				 }
 				checkFullHouse(b5);
 				if (cFH) {
 					high5 = high;
 					b5HighH = "FH";
  				 }
 				checkFourOfAKind(b5);
 				 if (c4K) {
 					high5 = high; 
 					b5HighH = "4OAK";
  				 }
 				checkStraightFlush(b5);
 				 if (cSF) {
 					high5 = high;
 					b5HighH = "SF";
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b6")) {
 				b6.sortByRank(b6);
 		 		high6 = b6.get(1);
 				checkPair(b6);
 				if (c1P) {
 					b6HighH = "Pair";
 				 }
 				checkTwoPairs(b6);
 				if (c2P) {
 					high6 = high; 
 					b6HighH = "2Ps";
 				 }
 				checkThreeOfAKind(b6);
 				if (c3K) {
 					high6 = high; 
 					b6HighH = "3OAK";
 				 }
 				checkStraight(b6);
 				if (cS) {
 					high6 = high; 
 					b6HighH = "Straight";
  				 } 
 				checkFlush(b6);
 				if (cF) {
 					high6 = high; 
 					b6HighH = "Flush";
  				 }
 				checkFullHouse(b6);
 				if (cFH) {
 					high6 = high; 
 					b6HighH = "FH";
  				 }
 				checkFourOfAKind(b6);
 				 if (c4K) {
 					high6 = high; 
 					b6HighH = "4OAK";
  				 }
 				checkStraightFlush(b6);
 				 if (cSF) {
 					high6 = high; 
 					b6HighH = "SF";
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b7")) {
 				b7.sortByRank(b7);
 		 		high7 = b7.get(1);
 				checkPair(b7);
 				if (c1P) { 
 					b7HighH = "Pair";
 				 }
 				checkTwoPairs(b7);
 				if (c2P) {
 					high7 = high; 
 					b7HighH = "2Ps";
 				 }
 				checkThreeOfAKind(b7);
 				if (c3K) {
 					high7 = high; 
 					b7HighH = "3OAK";
 				 }
 				checkStraight(b7);
 				if (cS) {
 					high7 = high; 
 					b7HighH = "Straight";
  				 } 
 				checkFlush(b7);
 				if (cF) {
 					high7 = high; 
 					b7HighH = "Flush";
  				 }
 				checkFullHouse(b7);
 				if (cFH) {
 					high7 = high; 
 					b7HighH = "FH";
  				 }
 				checkFourOfAKind(b7);
 				 if (c4K) {
 					high7 = high; 
 					b7HighH = "4OAK";
  				 }
 				checkStraightFlush(b7);
 				 if (cSF) {
 					high7 = high; 
 					b7HighH = "SF";
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b8")) {
 				b8.sortByRank(b8);
 		 		high8 = b8.get(1);
 				checkPair(b8);
 				if (c1P) {; 
 					b8HighH = "Pair";
 				 }
 				checkTwoPairs(b8);
 				if (c2P) {
 					high8 = high; 
 					b8HighH = "2Ps";
 				 }
 				checkThreeOfAKind(b8);
 				if (c3K) {
 					high8 = high; 
 					b8HighH = "3OAK";
 				 }
 				checkStraight(b8);
 				if (cS) {
 					high8 = high; 
 					b8HighH = "Straight";
  				 } 
 				checkFlush(b8);
 				if (cF) {
 					high8 = high; 
 					b8HighH = "Flush";
  				 }
 				checkFullHouse(b8);
 				if (cFH) {
 					high8 = high;
 					b8HighH = "FH";
  				 }
 				checkFourOfAKind(b8);
 				 if (c4K) {
 					high8 = high; 
 					b8HighH = "4OAK";
  				 }
 				checkStraightFlush(b8);
 				 if (cSF) {
 					high8 = high; 
 					b8HighH = "SF";
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b9")) {
 				b9.sortByRank(b9);
 		 		high9 = b9.get(1);
 				checkPair(b9);
 				if (c1P) { 
 					b9HighH = "Pair";
 				 }
 				checkTwoPairs(b9);
 				if (c2P) {
 					high9 = high; 
 					b9HighH = "2Ps";
 				 }
 				checkThreeOfAKind(b9);
 				if (c3K) {
 					high9 = high; 
 					b9HighH = "3OAK";
 				 }
 				checkStraight(b9);
 				if (cS) {
 					high9 = high;
 					b9HighH = "Straight";
  				 } 
 				checkFlush(b9);
 				if (cF) {
 					high9 = high; 
 					b9HighH = "Flush";
  				 }
 				checkFullHouse(b9);
 				if (cFH) {
 					high9 = high; 
 					b9HighH = "FH";
  				 }
 				checkFourOfAKind(b9);
 				 if (c4K) {
  					high9 = high; 
  					b9HighH = "4OAK";
  				 }
 				checkStraightFlush(b9);
 				 if (cSF) {
  					high9 = high;
  					b9HighH = "SF";
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b10")) {
 				b10.sortByRank(b10);
 		 		high10 = b10.get(1);
 				checkPair(b10);
 				if (c1P) { 
 					b10HighH = "Pair";
 				 }
 				checkTwoPairs(b10);
 				if (c2P) {
 					high10 = high; 
 					b10HighH = "2Ps";
 				 }
 				checkThreeOfAKind(b10);
 				if (c3K) {
 					high10 = high; 
 					b10HighH = "3OAK";
 				 }
 				checkStraight(b10);
 				if (cS) {
 					high10 = high; 
 					b10HighH = "Straight";
  				 } 
 				checkFlush(b10);
 				if (cF) {
 					high10 = high; 
 					b10HighH = "Flush";
  				 }
 				checkFullHouse(b10);
 				if (cFH) {
 					high10 = high; 
 					b10HighH = "FH";
  				 }
 				checkFourOfAKind(b10);
 				 if (c4K) {
 					high10 = high;
 					b10HighH = "4OAK";
  				 }
 				checkStraightFlush(b10);
 				 if (cSF) {
 					high10 = high; 
 					b10HighH = "SF";
 				 }
 				resetBools();
 			}
 		}
 	}
	
	public static void compareH(String h1, String h2) {
		int int1 = 0;
		int int2 = 0;
		if (h1.equals("Pair")) {
			int1 = 1;
		} else if (h1.equals("2Ps")) {
			int1 = 2;
		} else if (h1.equals("3OAK")) {
			int1 = 3;
		} else if (h1.equals("Straight")) {
			int1 = 4;
		} else if (h1.equals("Flush")) {
			int1 = 5;
		} else if (h1.equals("FH")) {
			int1 = 6;
		} else if (h1.equals("4OAK")) {
			int1 = 7;
		} else if (h1.equals("SF")) {
			int1 = 8;
		}
		if (h2.equals("Pair")) {
			int2 = 1;
		} else if (h2.equals("2Ps")) {
			int2 = 2;
		} else if (h2.equals("3OAK")) {
			int2 = 3;
		} else if (h2.equals("Straight")) {
			int2 = 4;
		} else if (h2.equals("Flush")) {
			int2 = 5;
		} else if (h2.equals("FH")) {
			int2 = 6;
		} else if (h2.equals("4OAK")) {
			int2 = 7;
		} else if (h2.equals("SF")) {
			int2 = 8;
		}
		
	}
}
