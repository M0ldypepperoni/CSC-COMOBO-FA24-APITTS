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

	public void addPiled(Pile oldPile) {
		for (Card card : oldPile.getCards()) {
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
	
	private int pileLowest(Pile cards, int low, int high) {
		int lowest = low;
		for (int i = low; i < high; i++) {
			if (cards.get(i).compareTo(cards.get(lowest)) < 0) {
				lowest = i;
			}
		}
		return lowest;
	}
	
	private void swapCards(Pile cards, int i, int j) {
		Card temp = cards.get(i);
		cards.set(i, cards.get(j));
		cards.set(j, temp);
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
	
	public void selectionSortP(Pile cards) {
		int n = cards.size();
		// find the lowest card at or to the right of i
		for (int i = 0; i < n; i++) {
			int lowest = pileLowest(cards, i, n);
			swapCards(cards, i, lowest);
		}
		// swap that card wit h the card at i
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
	
	public void removeDupes(Pile cards) {
		int n = cards.size()-1;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (cards.getRanked(i) == cards.getRanked(i+1)) {
				count++;
			}
		}
		n -= count;
		for (int i = 0; i < n; i++) {
			if (cards.getRanked(i) == cards.getRanked(i+1)) {
				cards.remove(i+1);
			}
		}
		
	}

	public Card remove(int index) {
		return cards.remove(index);
	}
	
	public int getSuit(int index) {
		return cards.get(index).getSuit();
	}

	private Card set(int index, Card card) {
		return cards.set(index, card);
		
	}

	public Card get(int index2) {
		return cards.get(index2);
	}
	
	public void checkPair(Pile hand, Pile table, boolean c1P, Card high) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.sortByRank(checkPile);
		for (int i = 0; i < 6; i++) {
				if (checkPile.get(i).onePair(checkPile.get(i+1))) {
					c1P = true;
					high = checkPile.get(i);
			}
		}
	}
	
	public void checkTwoPairs(Pile hand, Pile table, boolean c2P, Card high) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.sortByRank(checkPile);
		for (int i = 0; i < 6; i++) {
			if (checkPile.get(i).onePair(checkPile.get(i+1))) {
				for(int j = 0; j < 6; j++) {
					if (checkPile.get(j).onePair(checkPile.get(j+1)) && checkPile.get(i) != checkPile.get(j)) {
						c2P = true;
						if (checkPile.getRanked(j) > checkPile.getRanked(i)) { 
							high = checkPile.get(j);
						} else {
							high = checkPile.get(i);
						}
					}
				}
			}
		}
	}
	
	public void checkThreeOfAKind(Pile hand, Pile table, boolean c3K, Card high) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.sortByRank(checkPile);
		for (int i = 0; i < 5; i++) {
			if (checkPile.get(i).threeOfAKind(checkPile.get(i+1), checkPile.get(i+2))) {
				high = checkPile.get(i);
				c3K = true;
			}
		}
	}	
	
	public void checkStraight(Pile hand, Pile table, boolean cS, Card high) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.sortByRank(checkPile);
		checkPile.removeDupes(checkPile);
		int n = checkPile.size();
		for (int i = 0; i <= n-5; i++) {
			if (checkPile.get(i).straight(checkPile.get(i+1), checkPile.get(i+2), checkPile.get(i+3), checkPile.get(i+4))) {
				cS = true;
				high = checkPile.get(i+4);
			}
		}
	}
	
	public void checkFlush(Pile hand, Pile table, boolean cF, Card high) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.sortBySuit(checkPile);
		for (int i = 0; i < 3; i++) {
			if (checkPile.get(i).flush(checkPile.get(i+1), checkPile.get(i+2), checkPile.get(i+3), checkPile.get(i+4))) {
				cF = true;
				if (checkPile.getRanked(i) > checkPile.getRanked(i+1) && checkPile.getRanked(i) > checkPile.getRanked(i+2) 
						&& checkPile.getRanked(i) > checkPile.getRanked(i+3) && checkPile.getRanked(i) > checkPile.getRanked(i+4)) {
					high = checkPile.get(i);
				} else if (checkPile.getRanked(i+1) > checkPile.getRanked(i) && checkPile.getRanked(i+1) > checkPile.getRanked(i+2) 
						&& checkPile.getRanked(i+1) > checkPile.getRanked(i+3) && checkPile.getRanked(i+1) > checkPile.getRanked(i+4)) {
					high = checkPile.get(i+1);
				} else if (checkPile.getRanked(i+2) > checkPile.getRanked(i) && checkPile.getRanked(i+2) > checkPile.getRanked(i+1) 
						&& checkPile.getRanked(i+2) > checkPile.getRanked(i+3) && checkPile.getRanked(i+2) > checkPile.getRanked(i+4)) {
					high = checkPile.get(i+2);
				} else if (checkPile.getRanked(i+3) > checkPile.getRanked(i) && checkPile.getRanked(i+3) > checkPile.getRanked(i+1) 
						&& checkPile.getRanked(i+3) > checkPile.getRanked(i+2) && checkPile.getRanked(i+3) > checkPile.getRanked(i+4)) {
					high = checkPile.get(i+3);
				} else {
					high = checkPile.get(i+4);
				}
			}		
		}
	}
	
	public void checkFullHouse(Pile hand, Pile table, boolean cFH, Card high) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.sortByRank(checkPile);
		for (int i = 0; i < 5; i++) {
			if (checkPile.get(i).threeOfAKind(checkPile.get(i+1), checkPile.get(i+2))) {
				for (int j = 0; j < 6; j++) {
					if (checkPile.get(j).onePair(checkPile.get(j+1)) && checkPile.get(i) != checkPile.get(j)) {
						cFH = true;
						if (checkPile.getRanked(j) > checkPile.getRanked(i)) {
							high = checkPile.get(j);
						} else { 
							high = checkPile.get(i);
						}
					}
				}
			}	
		}
	}

	public void checkFourOfAKind(Pile hand, Pile table, boolean c4K, Card high) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.sortByRank(checkPile);
		for (int i = 0; i < 4; i++) {
			if (checkPile.get(i).fourOfAKind(checkPile.get(i+1), checkPile.get(i+2), checkPile.get(i+3))) {
				high = checkPile.get(i);
				c4K = true;
			}
		}
	}
	
	public void checkStraightFlush(Pile hand, Pile table, boolean cSF, Card high) {
		Pile checkPile = new Pile();
		checkPile.addPiled(hand);
		checkPile.addPiled(table);
		checkPile.selectionSortP(checkPile);
		checkPile.removeDupes(checkPile);
		int n = checkPile.size();
		for (int i = 0; i <= n-5; i++) {
			if (checkPile.get(i).straightFlush(checkPile.get(i+1), checkPile.get(i+2), checkPile.get(i+3), checkPile.get(i+4))) {
				cSF = true;
				high = checkPile.get(i+4);
			}
		}
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
