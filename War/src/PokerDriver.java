import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class PokerDriver {
	private static int playerPoints = 1000;
	private static int pot = 0;
	private static int lilB = 0;
	private static int bigB = 1;
	private static int botP = 1000;
	private static int b1P = 1000;
	private static int b2P = 1000;
	private static int b3P = 1000;
	private static int b4P = 1000;
	private static int b5P = 1000;
	private static int b6P = 1000;
	private static int b7P = 1000;
	private static int b8P = 1000;
	private static int b9P = 1000;
	private static int b10P = 1000;
	 
	public static void main(String[] args) {
		Random rand = new Random();
		int count = 1;
		char again = 'y';
		// array for points maybe?
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
		int bet = 0;
		int botAmount = 0;

		Deck deck = new Deck();

		deck.shuffle();

		System.out.println("Please enter the amount of bots you want to play against.");
		botAmount = input.nextInt();
		ArrayList<String> pAtT = new ArrayList<>(botAmount + 1);
		
		while (again == 'y' || again == 'Y') {
			
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
			left.shufflePile();
			if (count == 1) {
// for little and big blind use rand int for if and else move left one
				Collections.shuffle(pAtT);
			} else {
				lilB += 1;
				bigB += 1;
			}
			if (pAtT.get(lilB).equals("player")) {
				System.out.println("Choose starting bet: \n1. 1 \n2. 4 \n3. 10");
				bet = input.nextInt();
				switch (bet) {
				case 1:
					playerPoints -= 1;
					pot += 1;					
					bet = 2;
					break;
				case 2:					
					playerPoints -= 4;
					pot += 4;
					bet = 8;
					break;
				case 3:
					playerPoints -= 10;
					pot += 10;
					bet = 15;
					break;
				default:
						System.out.println("Only pick 1 - 3");
				}
				if(pAtT.get(bigB).equals("b1")) {
					b1P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b2")) {
					b2P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b3")) {
					b3P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b4")) {
					b4P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b5")) {
					b5P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b6")) {
					b6P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b7")) {
					b7P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b8")) {
					b8P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b9")) {
					b9P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b10")) {
					b10P -= bet;
					pot += bet;
				} 
			}else {
				bet = rand.nextInt(3) + 1;
				switch (bet) {
				case 1:
					playerPoints -= 1;
					pot += 1;					
					bet = 2;
					break;
				case 2:					
					playerPoints -= 4;
					pot += 4;
					bet = 8;
					break;
				case 3:
					playerPoints -= 10;
					pot += 10;
					bet = 15;
					break;
				default:
						System.out.println("Only pick 1 - 3");
				}
				if(pAtT.get(bigB).equals("b1")) {
					b1P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b2")) {
					b2P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b3")) {
					b3P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b4")) {
					b4P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b5")) {
					b5P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b6")) {
					b6P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b7")) {
					b7P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b8")) {
					b8P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b9")) {
					b9P -= bet;
					pot += bet;
				} else if(pAtT.get(bigB).equals("b10")) {
					b10P -= bet;
					pot += bet;
				} 
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
	public void pStartingBet(Scanner input, int bet2) {
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
		if(pAtT.get(bigB).equals("b1")) {
			b1P -= bet;
			pot += bet;
		} else if(pAtT.get(bigB).equals("b2")) {
			b2P -= bet;
			pot += bet;
		} else if(pAtT.get(bigB).equals("b3")) {
			b3P -= bet;
			pot += bet;
		} else if(pAtT.get(bigB).equals("b4")) {
			b4P -= bet;
			pot += bet;
		} else if(pAtT.get(bigB).equals("b5")) {
			b5P -= bet;
			pot += bet;
		} else if(pAtT.get(bigB).equals("b6")) {
			b6P -= bet;
			pot += bet;
		} else if(pAtT.get(bigB).equals("b7")) {
			b7P -= bet;
			pot += bet;
		} else if(pAtT.get(bigB).equals("b8")) {
			b8P -= bet;
			pot += bet;
		} else if(pAtT.get(bigB).equals("b9")) {
			b9P -= bet;
			pot += bet;
		} else if(pAtT.get(bigB).equals("b10")) {
			b10P -= bet;
			pot += bet;
		} 
	}
	}

