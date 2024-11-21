
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
		if (this.rank == that.rank && and.rank == this.rank) {
			return true;
		}
			return false;
	}
	
	public boolean twoPair(Card that, Card and, Card hat) {
		if ((this.rank == that.rank && hat.rank == and.rank && hat.rank != this.rank) ||
				(this.rank == hat.rank && that.rank == and.rank && that.rank != this.rank) || 
				(this.rank == and.rank && that.rank == hat.rank && that.rank != this.rank)) {
			return true;
		}
			return false;
	}
	
	public boolean fourOfAKind(Card that, Card and, Card other) {
		if (this.rank == that.rank && this.rank == and.rank && this.rank == other.rank) {
			return true;
		}
			return false;
	}
	
	public boolean straight(Card that, Card and, Card other, Card another) {
		if ((this.rank < that.rank && that.rank == (this.rank+1)) && (that.rank < and.rank && and.rank == (that.rank+1)) && 
				(and.rank < other.rank && other.rank == (and.rank+1)) && (other.rank < another.rank && another.rank == (other.rank+1))) {
			return true;
		}
		return false;
	}
	public boolean straightFlush(Card that, Card and, Card other, Card another) {
		if (this.suit == that.suit && that.suit == and.suit && and.suit == other.suit && other.suit == another.suit) {
			if (this.rank < that.rank && that.rank < and.rank && and.rank < other.rank && other.rank < another.rank) {
				return true;
			} else return false;
		}
		return false;
	}
	
	public boolean flush(Card that, Card and, Card other, Card another) {
		if (this.suit == that.suit && that.suit == and.suit && and.suit == other.suit && other.suit == another.suit) {
				return true;
		}
		return false;
	}
	
	public boolean fullHouse(Card that, Card and, Card other, Card another) {
		if ((this.rank == that.rank && this.rank == and.rank && other.rank == another.rank && other.rank != this.rank) || 
				(this.rank == that.rank && this.rank == other.rank && and.rank == another.rank && and.rank != this.rank) ||
				(this.rank == that.rank && this.rank == another.rank && other.rank == and.rank && other.rank != this.rank) || 
				(this.rank == and.rank && this.rank == other.rank && another.rank == that.rank && another.rank != this.rank) || 
				(this.rank == and.rank && this.rank == another.rank && other.rank == that.rank && other.rank != this.rank) || 
				(this.rank == other.rank && this.rank == another.rank && and.rank == that.rank && and.rank != this.rank) ||
				(that.rank == and.rank && that.rank == other.rank && this.rank == another.rank && that.rank != this.rank) ||
				(that.rank == and.rank && that.rank == another.rank && this.rank == other.rank && that.rank != this.rank) ||
				(that.rank == other.rank && that.rank == another.rank && this.rank == and.rank && that.rank != this.rank) ||
				(and.rank == other.rank && and.rank == another.rank && this.rank == that.rank && and.rank != this.rank)) {
			return true;
		}
		return false;
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
