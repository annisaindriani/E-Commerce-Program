
public class Furniture extends Order implements Transferable {
	private int qty;
	private int weight;
	private int insuranceCost;
	private int packCost;

	public Furniture(String name, String category, String ID, int price, int shipCost, int qty, int weight,
			int insuranceCost, int packCost) {
		super(name, category, ID, price, shipCost);
		this.qty = qty;
		this.weight = weight;
		this.insuranceCost = insuranceCost;
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

	public int getInsuranceCost() {
		return insuranceCost;
	}

	public void setInsuranceCost(int insuranceCost) {
		this.insuranceCost = insuranceCost;
	}

	public int getPackCost() {
		return packCost;
	}

	public void setPackCost(int packCost) {
		this.packCost = packCost;
	}

	@Override
	public void generateID() {
		String orderID = "U";
		
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

	@Override
	public void calculateShippingCost() {
		int shippingCost = this.weight * 10000;
		
		this.setShipCost(shippingCost);
	}

}
