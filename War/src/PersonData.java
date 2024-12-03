
public class PersonData {
	
	private String name;
	private Pile hand;
	private int points;
	private String type;
	private Card high;

	public PersonData(String name, int points, String type, Card high) {
		super();
		this.name = name;
		this.hand = new Pile();
		this.points = points;
		this.type = type;
		this.high = high;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pile getHand() {
		return hand;
	}

	public void addCard(Card card) {
		hand.addCard(card);
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Card getHigh() {
		return high;
	}

	public void setHigh(Card high) {
		this.high = high;
	}
	
	
	
}
