
public class WarDriver {

	public static void main(String[] args) {
		Deck deck = new Deck();

		deck.shuffle();

		Pile p1 = new Pile();
		p1.addDeck(deck.subdeck(0, 25));

		Pile p2 = new Pile();
		p2.addDeck(deck.subdeck(26, 51));

		Pile mid = new Pile();

		while (!p1.isEmpty() && !p2.isEmpty()) {
			Card c1 = p1.popCard();
			Card c2 = p2.popCard();
			System.out.println(c1 + ", " + c2);
			mid.addCard(c1);
			mid.addCard(c2);

			int difference = c1.getRank() - c2.getRank();

			if (difference > 0) {
				p1.addPile(mid);
				System.out.println("P1 wins");
				mid.clear();
			} else if (difference < 0) {
				p2.addPile(mid);
				System.out.println("P2 wins");
				mid.clear();
			} else {
				System.out.println("Tie!");
			}

			p1.shufflePile();
			p2.shufflePile();

		}
		if (p1.isEmpty()) {
			System.out.println("Player 2 Wins!");
		} else {
			System.out.println("Player 1 Wins!");
		}
	}

	public static void printDeck(Card[] cards) {
		for (int i = 0; i < 52; i++) {
			System.out.println(cards[i]);
		}
	}

	public static int search(Card[] cards, Card target) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].equals(target)) {
				return i;
			}
		}
		return -1;
	}

	public static int binarySearch(Card[] cards, Card target) {
		int low = 0;
		int high = cards.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int comp = cards[mid].compareTo(target);

			if (comp == 0) {
				return mid;
			} else if (comp < 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
