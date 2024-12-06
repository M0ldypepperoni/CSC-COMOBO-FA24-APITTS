
public class PersonData {
	
	private String name;
	private Pile hand;
	private int order;
	private int points;
	private int type;
	private Card high;

	
	
	public PersonData() {
		super();
		this.name = "";
		this.order = 0;
		this.points = 0;
		this.type = 0;
		this.high = null;
	}

	public PersonData(String name, int order, int points, int type, Card high) {
		super();
		this.name = name;
		this.order = order;
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

	
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public void setHand(Pile hand) {
		this.hand = hand;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Card getHigh() {
		return high;
	}

	public void setHigh(Card high) {
		this.high = high;
	}
	
	
	
}
