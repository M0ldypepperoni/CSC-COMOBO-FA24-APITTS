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
	
	@Override
	public String toString() {
		String str = "";
		for (Card card : this.cards) {
			str +=  card + ", ";
		}
		return str;
	}
}
