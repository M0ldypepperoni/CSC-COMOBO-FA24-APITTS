import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class PokerDriver {

	public static PersonData player1 = new PersonData("player", 1, 0, 0, null);
	public static PersonData bot1 = new PersonData("b1", 2, 0, 0, null);
	public static PersonData bot2 = new PersonData("b2", 3, 0, 0, null);
	public static PersonData bot3 = new PersonData("b3", 4, 0, 0, null);
  public static PersonData bot4 = new PersonData("b4", 5, 0, 0, null);
  public static PersonData bot5 = new PersonData("b5", 6, 0, 0, null);
  public static PersonData bot6 = new PersonData("b6", 7, 0, 0, null);
  public static PersonData bot7 = new PersonData("b7", 8, 0, 0, null);
  public static PersonData bot8 = new PersonData("b8", 9, 0, 0, null);
  public static PersonData bot9 = new PersonData("b9", 10, 0, 0, null);
  public static PersonData bot10 = new PersonData("b10", 11, 0, 0, null);
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
		
		int bet = 0;
		HighScore current = new HighScore();
		current.readFrom();
		
		Deck deck = new Deck();
		deck.shuffle();
		System.out.println();
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
			System.out.println("Pot: " + pot);
			System.out.println(playerPoints);

			betting(choice, bet, pAtT);
			if (fold == true) continue;
			if (choice != 3) preChoice = 4;
			for(int i = 0; i < 3; i++) {
			table.addCard(left.popCard());
			}
			System.out.println(table);
			System.out.println();
			System.out.println("Pot: " + pot);
			betting(choice, bet, pAtT);
			if (fold == true) continue;
			if (choice != 3) preChoice = 4;
			table.addCard(left.popCard());
			System.out.println(table);
			System.out.println();
			System.out.println("Pot: " + pot);
			betting(choice, bet, pAtT);
			
			if (fold == true) continue;
			table.addCard(left.popCard());
			System.out.println("Pot: " + pot);
			System.out.println();
			System.out.println(table);
			System.out.println();
			System.out.println(player);
			System.out.println();
			checkHand(pAtT);
			System.out.println(highP);
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
		if(playerPoints > current.getHighScore()) {
			current.setHighScore(playerPoints);
			System.out.println("Please enter your initials.");
			current.setIntials(input.next());
			current.writeToFile();
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
//when bots starts the round
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
 				player.checkPair(table, player, c1P, highP);
 				if (c1P) { 
 					combo[i] = 1;
 				 }
 				player.checkTwoPairs(player, table, c2P, highP);
 				if (c2P) { 
 					combo[i] = 2;
 				 }
 				player.checkThreeOfAKind(player, table, c3K, highP);
 				if (c3K) {
 					combo[i] = 3;
 				 }
 				player.checkStraight(player, table, cS, highP);
 				if (cS) {
  					combo[i] = 4;
  				 } 
 				player.checkFlush(player, table, cF, highP);
 				if (cF) {
  					combo[i] = 5;
  				 }
 				player.checkFullHouse(player, table, cFH, highP);
 				if (cFH) {
  					combo[i] = 6;
  				 }
 				player.checkFourOfAKind(player, table, c4K, highP);
 				 if (c4K) {
  					combo[i] = 7;
  				 }
 				player.checkStraightFlush(player, table, cSF, highP);
 				 if (cSF) {
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b1")) {
 				b1.sortByRank(b1);
 		 		high1 = b1.get(1);
 				b1.checkPair(b1, table, c1P, high1);
 				if (c1P) { 
 					combo[i] = 1;
 				 }
 				b1.checkTwoPairs(b1, table, c2P, high1);
 				if (c2P) {
 					combo[i] = 2;
 				 }
 				b1.checkThreeOfAKind(b1, table, c3K, high1);
 				if (c3K) {
 					combo[i] = 3;
 				 }
 				b1.checkStraight(b1, table, cS, high1);
 				if (cS) {
 					combo[i] = 4;
  				 } 
 				b1.checkFlush(b1, table, cF, high1);
 				if (cF) {
 					combo[i] = 5;
  				 }
 				b1.checkFullHouse(b1, table, cFH, high1);
 				if (cFH) { 
 					combo[i] = 6;
  				 }
 				b1.checkFourOfAKind(b1, table, c4K, high1);
 				 if (c4K) {
 					combo[i] = 7;
  				 }
 				b1.checkStraightFlush(b1, table, cSF, high1);
 				 if (cSF) {
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b2")) {
 				b2.sortByRank(b2);
 		 		high2 = b2.get(1);
 				b2.checkPair(b2, table, c1P, high2);
 				if (c1P) {
 					combo[i] = 1;
 				 }
 				b2.checkTwoPairs(b2, table, c2P, high2);
 				if (c2P) {
 					combo[i] = 2;
 				 }
 				b2.checkThreeOfAKind(b2, table, c3K, high2);
 				if (c3K) {
 					combo[i] = 3;
 				 }
 				b2.checkStraight(b2, table, cS, high2);
 				if (cS) {
 					combo[i] = 4;
  				 } 
 				b2.checkFlush(b2, table, cF, high2);
 				if (cF) { 
 					combo[i] = 5;
  				 }
 				b2.checkFullHouse(b2, table, cFH, high2);
 				if (cFH) {
 					combo[i] = 6;
  				 }
 				b2.checkFourOfAKind(b2, table, c4K, high2);
 				 if (c4K) {
 					combo[i] = 7;
  				 }
 				b2.checkStraightFlush(b2, table, cSF, high2);
 				 if (cSF) {
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b3")) {
 				b3.sortByRank(b3);
 		 		high3 = b3.get(1);
 				b3.checkPair(b3, table, c1P, high3);
 				if (c1P) { 
 					combo[i] = 1;
 				 }
 				b3.checkTwoPairs(b3, table, c2P, high3);
 				if (c2P) { 
 					combo[i] = 2;
 				 }
 				b3.checkThreeOfAKind(b3, table, c3K, high3);
 				if (c3K) {
 					combo[i] = 3;
 				 }
 				b3.checkStraight(b3, table, cS, high3);
 				if (cS) {
 					combo[i] = 4;
  				 } 
 				b3.checkFlush(b3, table, cF, high3);
 				if (cF) {
 					combo[i] = 5;
  				 }
 				b3.checkFullHouse(b3, table, cFH, high3);
 				if (cFH) { 
 					combo[i] = 6;
  				 }
 				b3.checkFourOfAKind(b3, table, c4K, high3);
 				 if (c4K) {
 					combo[i] = 7;
  				 }
 				b3.checkStraightFlush(b3, table, cSF, high3);
 				 if (cSF) {
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b4")) {
 				b4.sortByRank(b4);
 		 		high4 = b4.get(1);
 				b4.checkPair(b4, table, c1P, high4);
 				if (c1P) {
 					combo[i] = 1;
 				 }
 				b4.checkTwoPairs(b4, table, c2P, high4);
 				if (c2P) {
 					combo[i] = 2;
 				 }
 				b4.checkThreeOfAKind(b4, table, c3K, high4);
 				if (c3K) {
 					combo[i] = 3;
 				 }
 				b4.checkStraight(b4, table, cS, high4);
 				if (cS) {
 					combo[i] = 4;
  				 } 
 				b4.checkFlush(b4, table, cF, high4);
 				if (cF) {
 					combo[i] = 5;
 				}
 				b4.checkFullHouse(b4, table, cFH, high4);
 				if (cFH) {	 
 					combo[i] = 6;
  				 }
 				b4.checkFourOfAKind(b4, table, c4K, high4);
 				 if (c4K) { 
 					combo[i] = 7;
  				 }
 				b4.checkStraightFlush(b4, table, cSF, high4);
 				 if (cSF) {
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b5")) {
 				b5.sortByRank(b5);
 		 		high5 = b5.get(1);
 				b5.checkPair(b5, table, c1P, high5);
 				if (c1P) {
 					combo[i] = 1;
 				 }
 				b5.checkTwoPairs(b5, table, c2P, high5);
 				if (c2P) { 
 					combo[i] = 2;
 				 }
 				b5.checkThreeOfAKind(b5, table, c3K, high5);
 				if (c3K) {
 					combo[i] = 3;
 				 }
 				b5.checkStraight(b5, table, cS, high5);
 				if (cS) {
 					combo[i] = 4;
  				 } 
 				b5.checkFlush(b5, table, cF, high5);
 				if (cF) {
 					combo[i] = 5;
  				 }
 				b5.checkFullHouse(b5, table, cFH, high5);
 				if (cFH) {
 					combo[i] = 6;
  				 }
 				b5.checkFourOfAKind(b5, table, c4K, high5);
 				 if (c4K) {
 					combo[i] = 7;
  				 }
 				b5.checkStraightFlush(b5, table, cSF, high5);
 				 if (cSF) {
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b6")) {
 				b6.sortByRank(b6);
 		 		high6 = b6.get(1);
 				b6.checkPair(b6, table, c1P, high6);
 				if (c1P) {
 					combo[i] = 1;
 				 }
 				b6.checkTwoPairs(b6, table, c2P, high6);
 				if (c2P) { 
 					combo[i] = 2;
 				 }
 				b6.checkThreeOfAKind(b6, table, c3K, high6);
 				if (c3K) {
 					combo[i] = 3;
 				 }
 				b6.checkStraight(b6, table, cS, high6);
 				if (cS) {
 					combo[i] = 4;
  				 } 
 				b6.checkFlush(b6, table, cF, high6);
 				if (cF) { 
 					combo[i] = 5;
  				 }
 				b6.checkFullHouse(b6, table, cFH, high6);
 				if (cFH) {
 					combo[i] = 6;
  				 }
 				b6.checkFourOfAKind(b6, table, c4K, high6);
 				 if (c4K) {
 					combo[i] = 7;
  				 }
 				b6.checkStraightFlush(b6, table, cSF, high6);
 				 if (cSF) { 
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b7")) {
 				b7.sortByRank(b7);
 		 		high7 = b7.get(1);
 				b7.checkPair(b7, table, c1P, high7);
 				if (c1P) { 
 					combo[i] = 1;
 				 }
 				b7.checkTwoPairs(b7, table, c2P, high7);
 				if (c2P) {
 					combo[i] = 2;
 				 }
 				b7.checkThreeOfAKind(b7, table, c3K, high7);
 				if (c3K) {
 					combo[i] = 3;
 				 }
 				b7.checkStraight(b7, table, cS, high7);
 				if (cS) { 
 					combo[i] = 4;
  				 } 
 				b7.checkFlush(b7, table, cF, high7);
 				if (cF) {
 					combo[i] = 5;
  				 }
 				b7.checkFullHouse(b7, table, cFH, high7);
 				if (cFH) { 
 					combo[i] = 6;
  				 }
 				b7.checkFourOfAKind(b7, table, c4K, high7);
 				 if (c4K) {
 					combo[i] = 7;
  				 }
 				b7.checkStraightFlush(b7, table, cSF, high7);
 				 if (cSF) {
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b8")) {
 				b8.sortByRank(b8);
 		 		high8 = b8.get(1);
 				b8.checkPair(b8, table, c1P, high8);
 				if (c1P) {; 
 					combo[i] = 1;
 				 }
 				b8.checkTwoPairs(b8, table, c2P, high8);
 				if (c2P) {
 					combo[i] = 2;
 				 }
 				b8.checkThreeOfAKind(b8, table, c3K, high8);
 				if (c3K) {
 					combo[i] = 3;
 				 }
 				b8.checkStraight(b8, table, cS, high8);
 				if (cS) { 
 					combo[i] = 4;
  				 } 
 				b8.checkFlush(b8, table, cF, high8);
 				if (cF) {
 					combo[i] = 5;
  				 }
 				b8.checkFullHouse(b8, table, c1P, high8);
 				if (cFH) {
 					combo[i] = 6;
  				 }
 				b8.checkFourOfAKind(b8, table, c4K, high8);
 				 if (c4K) {
 					combo[i] = 7;
  				 }
 				b8.checkStraightFlush(b8, table, cSF, high8);
 				 if (cSF) {
 					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b9")) {
 				b9.sortByRank(b9);
 		 		high9 = b9.get(1);
 				b9.checkPair(b9, table, c1P, high9);
 				if (c1P) { 
 					combo[i] = 1;
 				 }
 				b9.checkTwoPairs(b9, table, c2P, high9);
 				if (c2P) {
 					combo[i] = 2;
 				 }
 				b9.checkThreeOfAKind(b9, table, c3K, high9);
 				if (c3K) {
 					combo[i] = 3;
 				 }
 				b9.checkStraight(b9, table, cS, high9);
 				if (cS) {
 					combo[i] = 4;
  				 } 
 				b9.checkFlush(b9, table, cF, high9);
 				if (cF) {
 					combo[i] = 5;
  				 }
 				b9.checkFullHouse(b9, table, cFH, high9);
 				if (cFH) { 
 					combo[i] = 6;
  				 }
 				b9.checkFourOfAKind(b9, table, c4K, high9);
 				 if (c4K) {
  					combo[i] = 7;
  				 }
 				b9.checkStraightFlush(b9, table, cSF, high9);
 				 if (cSF) {
  					combo[i] = 8;
 				 }
 				resetBools();
 			} if (pAtT.get(i).equals("b10")) {
 				b10.sortByRank(b10);
 		 		high10 = b10.get(1);
 				b10.checkPair(b10, table, c1P, high10);
 				if (c1P) { 
 					combo[i] = 1;
 				 }
 				b10.checkTwoPairs(b10, table, c2P, high10);
 				if (c2P) {
 					combo[i] = 2;
 				 }
 				b10.checkThreeOfAKind(b10, table, c3K, high10);
 				if (c3K) {
 					combo[i] = 3;
 				 }
 				b10.checkStraight(b10, table, cS, high10);
 				if (cS) {
 					combo[i] = 4;
  				 } 
 				b10.checkFlush(b10, table, cF, high10);
 				if (cF) {
 					combo[i] = 5;
  				 }
 				b10.checkFullHouse(b10, table, cFH, high10);
 				if (cFH) { 
 					combo[i] = 6;
  				 }
 				b10.checkFourOfAKind(b10, table, c4K, high10);
 				 if (c4K) {
 					combo[i] = 7;
  				 }
 				b10.checkStraightFlush(b10, table, cSF, high10);
 				 if (cSF) {
 					combo[i] = 8;
 				 }
 				resetBools();
 			}
 		}
 	}
	
//runs through all the checks and assigns high cards
	public static void compareH(ArrayList<String> pAtT) {
		int highest = -1;
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
