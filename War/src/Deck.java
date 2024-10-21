import java.util.Random;

public class Deck {
	private static Random rand = new Random();
	private Card[] cards;
	public Deck() {
		this.cards = new Card[52];
		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 0; rank < 13; rank++) {
				cards[index] = new Card(rank, suit);
				index ++;
			}
		}
	}
	
	public Deck(int n) {
		this.cards = new Card[n];
	}
	
	public Card[] getCards() {
		return this.cards;
	}
	
	public void shuffle() {
		for (int i =0; i < cards.length; i++) {
			int num = randomInt(i, cards.length );
			swapCards(i, num);
		}
	}
	
	private static int randomInt(int low, int high) {
		int num = rand.nextInt(high - low) + low;
		return num;
	}
	
	private void swapCards(int i, int j) {
		Card temp = cards[i];
		cards[i] = cards[j];
		cards[j] = temp;
	}
	
	public void print() {
		for (Card card : this.cards) {
			System.out.println(card);
		}
	}
}
