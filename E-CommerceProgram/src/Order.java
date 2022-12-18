
public abstract class Order {
	private String name;
	private String category;
	private String ID;
	private int price;
	private int shipCost;

	public Order(String name, String category, String ID, int price, int shipCost) {
		super();
		this.name = name;
		this.category = category;
		this.ID = ID;
		this.price = price;
		this.shipCost = shipCost;
	}

	public abstract void generateID();

	public abstract int calculateTotalPrice();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getShipCost() {
		return shipCost;
	}

	public void setShipCost(int shipCost) {
		this.shipCost = shipCost;
	}

}
