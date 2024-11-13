
public class Card {

	private final int rank;
	private final int suit;
	private static final String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
			"King", "Ace" };
	private static final String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades"};

	public Card(int rank, int suit) {
		super();
	 	this.rank = rank;
		this.suit = suit;
	}

	public boolean equals(Card that) {
		return this.rank == that.rank && this.suit == that.suit;
	}

	public int compareTo(Card that) {
		if (this.suit < that.suit) {
			return -1;
		}
		if (this.suit > that.suit) {
			return 1;
		}
		if (this.rank < that.rank) {
			return -1;
		}
		if (this.rank > that.rank) {
			return 1;
		}
		return 0;
	}

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		String s = RANKS[this.rank] + " of " + SUITS[this.suit];
		return s;
	}

}
