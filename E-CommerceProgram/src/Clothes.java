
public class Clothes extends Order implements Transferable {
	private int qty;
	private int weight;
	private int packCost;

	public Clothes(String name, String category, String ID, int price, int shipCost, int qty, int weight,
			int packCost) {
		super(name, category, ID, price, shipCost);
		this.qty = qty;
		this.weight = weight;
		this.packCost = packCost;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPackCost() {
		return packCost;
	}

	public void setPackCost(int packCost) {
		this.packCost = packCost;
	}

	@Override
	public void calculateShippingCost() {
		int shippingCost = this.weight * 10000;
		
		this.setShipCost(shippingCost);
		
	}

	@Override
	public void generateID() {
		String orderID = "C";
		
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
