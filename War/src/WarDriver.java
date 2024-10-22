
public class WarDriver {

	public static void main(String[] args) {
		Card[] cards = new Card[52];
		
		Deck deck = new Deck();
		
		//deck.print();
		 
		deck.shuffle();
		Deck p1Deck = deck.subdeck(0, 25);
		Deck p2Deck = deck.subdeck(26, 51);
		//deck.print();
		//
		p1Deck.selectionSort();
		//deck.print();
		p1Deck.print();
//		System.out.println(cards[25]);
//		Card target = new Card(12, 3);
//		System.out.println(search(cards, target));
//	
//		System.out.println(binarySearch(cards, target));
	}
	
	public static void printDeck(Card[] cards) {
		for (int i = 0; i < 52; i++) {
			System.out.println(cards[i]);
		}
	}
	
	public static int search(Card[] cards, Card target) {
		for(int i = 0; i < cards.length; i++) {
			if(cards[i].equals(target)) {
				return i;
			}
		}
		return -1;
	}
	
	public static int binarySearch(Card[] cards, Card target) {
		int low = 0;
		int high = cards.length - 1;
		while (low <= high) {
			int mid = (low + high)/2;
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
