
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
	
	public boolean onePair(Card that) {
		return this.rank == that.rank;
	}
	
	public boolean threeOfAKind(Card that, Card and) {
		boolean aGiraffe;
		if (this.rank == that.rank && and.rank == this.rank) {
			aGiraffe = true;
		} else {
			aGiraffe = false;
		}
		return aGiraffe;
	}
	
	public boolean twoPair(Card that, Card and, Card hat) {
		boolean axolotl;
		if ((this.rank == that.rank && hat.rank == and.rank && hat.rank != this.rank) ||
				(this.rank == hat.rank && that.rank == and.rank && that.rank != this.rank) || 
				(this.rank == and.rank && that.rank == hat.rank && that.rank != this.rank)) {
			axolotl = true;
		} else { 
			axolotl = false;
		}
		return axolotl;
	}
	
	public boolean fourOfAKind(Card that, Card and, Card hat) {
		boolean aHorse;
		if (this.rank == that.rank && this.rank == and.rank && this.rank == hat.rank) {
			aHorse = true;
		} else {
			aHorse = false;
		}
		return aHorse;
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
