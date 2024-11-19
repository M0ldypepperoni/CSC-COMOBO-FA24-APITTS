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
	
	public int getRanked(int index) {
		return cards.get(index).getRank();
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
	
	public void sortByRank(Pile cards) {
		int n = cards.size();
		for(int i = 0;i < n; i++){
		    for(int j=0;j < n - 1; j++){
		       if(cards.getRanked(j) > cards.getRanked(j+1)){
		            Card temp = cards.get(j);
		            cards.set(j, cards.get(j+1));
		            cards.set(j+1,temp);
		        }
		   }
		}
	}
	
	public void sortBySuit(Pile cards) {
		int n = cards.size();
		for(int i = 0;i < n; i++){
		    for(int j=0;j < n - 1; j++){
		       if(cards.getSuit(j) > cards.getSuit(j+1)){
		            Card temp = cards.get(j);
		            cards.set(j, cards.get(j+1));
		            cards.set(j+1,temp);
		      }
		   }
		}
	}

	public int getSuit(int index) {
		// TODO Auto-generated method stub
		return cards.get(index).getSuit();
	}

	private Card set(int index, Card card) {
		return cards.set(index, card);
		
	}

	public Card get(int index2) {
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
