import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Pile {
	public static Random rand = new Random();

	private ArrayList<Card> cards;

	public Pile() {
		this.cards = new ArrayList<Card>();
	}

	public Card popCard() {
		return this.cards.remove(0);
	}

	public void addCard(Card card) {
		this.cards.add(card);
	}

	public boolean isEmpty() {
		return this.cards.isEmpty();
	}

	public void addDeck(Deck deck) {
		for (Card card : deck.getCards()) {
			this.cards.add(card);
		}
	}

	public void addPile(Pile oldPile) {
		while (!oldPile.isEmpty()) {
	 		this.cards.add(oldPile.popCard());
		}
	}

	public void clear() {
		this.cards = new ArrayList<Card>();
	}

	public int size() {
		return this.cards.size();
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void shufflePile() {
		Collections.shuffle(cards);
	}
	
	public void shufflesPiles(Pile cards1) {
	    for (int i = cards1.size() - 1; i > 0; i--) {
	      int index = rand.nextInt(i + 1);
	      // Simple swap
	      Card temp = cards1.get(index);
	      cards1.set(index, cards1.get(i));
	      cards1.set(i, temp);
	    }
	  }

	private Card set(int index, Card card) {
		return cards.set(index, card);
		
	}

	private Card get(int index2) {
		return cards.get(index2);
	}

	@Override
	public String toString() {
		String str = "";
		for (Card card : this.cards) {
			str += card + ", ";
		}
		return str;
	}

	
}
