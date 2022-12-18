
public class Food extends Order {
	private String type;
	private int portion;
	private int packCost;

	public Food(String name, String category, String iD, int price, int shipCost, String type, int portion,
			int packCost) {
		super(name, category, iD, price, shipCost);
		this.type = type;
		this.portion = portion;
		this.packCost = packCost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPortion() {
		return portion;
	}

	public void setPortion(int portion) {
		this.portion = portion;
	}

	public int getPackCost() {
		return packCost;
	}

	public void setPackCost(int packCost) {
		this.packCost = packCost;
	}

	@Override
	public void generateID() {
		String orderID = "F";
		
		for(int i=0; i<3; i++) {
			int number = (int) (Math.random()*(9-0+1)+0);
			orderID += number;
		}
		
		this.setID(orderID);
	}

	@Override
	public int calculateTotalPrice() {
		int totalPrice = this.getPrice() + this.getShipCost();
		
		return totalPrice;
	}

}
