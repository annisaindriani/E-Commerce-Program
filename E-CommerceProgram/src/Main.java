import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<Order> listOrder = new ArrayList<>();

	public void cls() {
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
	}

	// Function to create a new order and store it in the arraylist
	public void addOrder() {
		String name;
		String category;
		String ID = null;
		int price = 0;
		String type;
		int portion = 0;
		int packCost = 0;
		int shipCost = 0;
		int distance = 0;
		String insurance = null;
		int insuranceCost = 0;
		int qty = 0;
		int weight = 0;

		System.out.println("Add New Order\n");

		// Ask user to input the category of order
		while (true) {
			System.out.print("Input the category of your order [Food | Furniture | " + "Clothes | Electronics]: ");
			category = scan.nextLine();

			if (category.equals("Food") || category.equals("Furniture") || category.equals("Clothes")
					|| category.equals("Electronics"))
				break;
		}

		// If the category is food, ask user to input the distance in km. [Example : 3]
		// Validate if the distance within the range, if not then can't process the
		// order
		if (category.equals("Food")) {
			while (true) {
				System.out.print("Input your distance [in km]: ");
				distance = scan.nextInt();
				scan.nextLine();

				if (distance >= 1)
					break;
			}

			if (distance > 5) {
				System.out.println("The distance is too far, we're unable to process your order");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				return;
			}
		}

		// Ask user to input the order
		while (true) {
			System.out.print("Input your order [5-20 characters]: ");
			name = scan.nextLine();

			if (name.length() >= 5 && name.length() <= 20)
				break;
		}

		// Ask user to input the base price
		while (true) {
			System.out.print("Input the base price [> 0]: ");
			price = scan.nextInt();
			scan.nextLine();

			if (price > 0)
				break;
		}

		if (category.equals("Food")) {

			// Ask user to input whether it's food or drink
			while (true) {
				System.out.print("Input the type of foods [Food | Drink]: ");
				type = scan.nextLine();

				if (type.equals("Food") || type.equals("Drink"))
					break;
			}

			// Ask user to input how many portion
			while (true) {
				System.out.print("Input the portion of your order [> 0]: ");
				portion = scan.nextInt();
				scan.nextLine();

				if (portion > 0)
					break;
			}

			// Set the packaging cost based on the criteria
			if (type.equals("Food")) {
				packCost = portion * 5000;
			} else if (type.equals("Drink")) {
				packCost = portion * 2000;
			}

			// Set the shipping cost to 15000 for each order in the food category
			shipCost = 15000;

			// Calculate the price + packaging cost and set to the initial price
			price = (price * portion) + packCost;

			Order newOrder = new Food(name, category, ID, price, shipCost, type, portion, packCost);

			// Set the order ID
			newOrder.generateID();

			// Store in the array list
			listOrder.add(newOrder);

		} else if (category.equals("Furniture")) {

			// Ask user to input the quantity
			while (true) {
				System.out.print("Input the quantity [> 0]: ");
				qty = scan.nextInt();
				scan.nextLine();

				if (qty > 0)
					break;
			}

			// Ask user to input the weight (per quantity, not total weight)
			while (true) {
				System.out.print("Input the weight per quantity [in kg]: ");
				weight = scan.nextInt();
				scan.nextLine();

				if (weight > 0)
					break;
			}

			weight = qty * weight;

			// Ask user whether to add insurance or not
			while (true) {
				System.out.print("Do you want to add insurance [Yes | No]: ");
				insurance = scan.nextLine();

				if (insurance.equals("Yes") || insurance.equals("No"))
					break;
			}

			// Set the insurance cost and packaging cost based on the criteria
			if (weight < 10) {
				packCost = 25000;

				if (insurance.equals("Yes")) {
					insuranceCost = (int) (price * 0.1);
				}

			} else {
				packCost = 50000;

				if (insurance.equals("Yes")) {
					insuranceCost = (int) (price * 0.2);
				}
			}

			// Calculate the price + packaging cost and set to the initial price
			price = (price * qty) + packCost + insuranceCost;

			Order newOrder = new Furniture(name, category, ID, price, shipCost, qty, weight, insuranceCost, packCost);

			// Set the order ID
			newOrder.generateID();

			// Set the shipping cost
			((Furniture) newOrder).calculateShippingCost();

			// Store in the array list
			listOrder.add(newOrder);

		} else if (category.equals("Clothes")) {

			// Ask user to input the quantity
			while (true) {
				System.out.print("Input the quantity [> 0]: ");
				qty = scan.nextInt();
				scan.nextLine();

				if (qty > 0)
					break;
			}

			// Ask user to input the weight (total weight)
			while (true) {
				System.out.print("Input total weight of your order [in kg]: ");
				weight = scan.nextInt();
				scan.nextLine();

				if (weight > 0)
					break;
			}

			// Set the packaging cost based on the criteria
			if (weight < 3) {
				packCost = 5000;
			} else {
				packCost = 10000;
			}

			// Calculate the price + packaging cost and set to the initial price
			price = (price * qty) + packCost;

			Order newOrder = new Clothes(name, category, ID, price, shipCost, qty, weight, packCost);

			// Set the order ID
			newOrder.generateID();

			// Set the shipping cost
			((Clothes) newOrder).calculateShippingCost();

			// Store in the array list
			listOrder.add(newOrder);

		} else if (category.equals("Electronics")) {

			// Ask user to input the quantity
			while (true) {
				System.out.print("Input the quantity [> 0]: ");
				qty = scan.nextInt();
				scan.nextLine();

				if (qty > 0)
					break;
			}

			// Ask user to input the weight (per quantity, not total weight)
			while (true) {
				System.out.print("Input the weight per quantity [in kg]: ");
				weight = scan.nextInt();
				scan.nextLine();

				if (weight > 0)
					break;
			}

			weight = qty * weight;

			// Ask user whether to add insurance or not
			while (true) {
				System.out.print("Do you want to add insurance [Yes | No]: ");
				insurance = scan.nextLine();

				if (insurance.equals("Yes") || insurance.equals("No"))
					break;
			}

			// Set the insurance cost based on the criteria
			if(insurance.equals("Yes")) {
				if(price < 5000000) {
					insuranceCost = (int) (price * 0.15);
				} else {
					insuranceCost = (int) (price * 0.25);
				}
			} 
			
			// Set the packaging cost based on the criteria
			if(weight < 3) {
				packCost = 50000;
			} else {
				packCost = 100000;
			}

			// Calculate the price + packaging cost and set to the initial price
			price = (price * qty) + packCost + insuranceCost;

			Order newOrder = new Electronics(name, category, ID, price, shipCost, qty, weight, insuranceCost, packCost);

			// Set the order ID
			newOrder.generateID();

			// Set the shipping cost
			((Electronics) newOrder).calculateShippingCost();

			// Store in the array list
			listOrder.add(newOrder);

		}

		System.out.println("\nSuccessfully add a new order");
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}

	// Function to view all orders
	public void viewOrder() {
		System.out.println("View All Order\n");

		if (listOrder.isEmpty()) {
			System.out.println("List order is empty");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			return;
		}
		
		System.out.println("=============================================================================="
				+ "===============================");
		System.out.printf("| %-3s | %-10s | %-22s | %-14s | %-14s | %-14s | %-10s |\n", "No", "Order ID", "Order Name",
				"Price", "Shipping Cost", "Total Price", "Insurance");
		System.out.println("=============================================================================="
				+ "===============================");
		
		int index = 0;
		for (Order order : listOrder) {
			index++;

			if (order instanceof Food) {
				System.out.printf("| %-3d | %-10s | %-22s | %-14d | %-14d | %-14d | %-10s |\n", index, order.getID(),
						order.getName(), order.getPrice(), order.getShipCost(), order.calculateTotalPrice(), "No");
			}

			if (order instanceof Furniture) {
				String insurance = null;

				if (((Furniture) order).getInsuranceCost() == 0) {
					insurance = "No";
				} else {
					insurance = "Yes";
				}

				System.out.printf("| %-3d | %-10s | %-22s | %-14d | %-14d | %-14d | %-10s |\n", index, order.getID(),
						order.getName(), order.getPrice(), order.getShipCost(), order.calculateTotalPrice(), insurance);
			}

			if (order instanceof Clothes) {
				System.out.printf("| %-3d | %-10s | %-22s | %-14d | %-14d | %-14d | %-10s |\n", index, order.getID(),
						order.getName(), order.getPrice(), order.getShipCost(), order.calculateTotalPrice(), "No");
			}
			
			if (order instanceof Electronics) {
				String insurance = null;

				if (((Electronics) order).getInsuranceCost() == 0) {
					insurance = "No";
				} else {
					insurance = "Yes";
				}

				System.out.printf("| %-3d | %-10s | %-22s | %-14d | %-14d | %-14d | %-10s |\n", index, order.getID(),
						order.getName(), order.getPrice(), order.getShipCost(), order.calculateTotalPrice(), insurance);
			}
		}
		
		System.out.println("=============================================================================="
				+ "===============================");
		
		System.out.println("*** Please note that the initial price changes after adding other costs"
				+ " (packing fees, insurance fees if any)");
		
		System.out.println("\nPress enter to continue...");
		scan.nextLine();

	}
	
	// Function to view detail order
	public int detailOrder(String findID, int temp) {
		System.out.println();
		
		temp = 0;
		for (Order order : listOrder) {
			temp++;
			if(order.getID().equals(findID)) {
				if(order instanceof Food) {
					int price = (order.getPrice()-((Food) order).getPackCost())/((Food) order).getPortion();
					System.out.println("Order Category      : " + order.getCategory());
					System.out.println("Order ID            : " + order.getID());
					System.out.println("Order Name   	    : " + order.getName());
					System.out.println("Base Price          : " + price);
					System.out.println("Total Portions      : " + ((Food) order).getPortion());
					System.out.println("Total Packaging Fee : " + ((Food) order).getPackCost());
					System.out.println("Total Shipping Fee  : " + order.getShipCost());
					System.out.println("Total Price         : " + order.calculateTotalPrice());
					
				} else if(order instanceof Furniture) {
					int price = (order.getPrice()-((Furniture) order).getPackCost()-((Furniture) order).getInsuranceCost())/((Furniture) order).getQty();
					System.out.println("Order Category      : " + order.getCategory());
					System.out.println("Order ID            : " + order.getID());
					System.out.println("Order Name   	    : " + order.getName());
					System.out.println("Base Price          : " + price);
					System.out.println("Total Quantity      : " + ((Furniture) order).getQty());
					System.out.println("Total Packaging Fee : " + ((Furniture) order).getPackCost());
					System.out.println("Total Insurance Fee : " + ((Furniture) order).getInsuranceCost());
					System.out.println("Total Shipping Fee  : " + order.getShipCost());
					System.out.println("Total Price         : " + order.calculateTotalPrice());
					
				} else if(order instanceof Electronics) {
					int price = (order.getPrice()-((Electronics) order).getPackCost()-((Electronics) order).getInsuranceCost())/((Electronics) order).getQty();
					System.out.println("Order Category      : " + order.getCategory());
					System.out.println("Order ID            : " + order.getID());
					System.out.println("Order Name   	    : " + order.getName());
					System.out.println("Base Price          : " + price);
					System.out.println("Total Quantity      : " + ((Electronics) order).getQty());
					System.out.println("Total Packaging Fee : " + ((Electronics) order).getPackCost());
					System.out.println("Total Insurance Fee : " + ((Electronics) order).getInsuranceCost());
					System.out.println("Total Shipping Fee  : " + order.getShipCost());
					System.out.println("Total Price         : " + order.calculateTotalPrice());
				
				} else if(order instanceof Clothes) {
					int price = (order.getPrice()-((Clothes) order).getPackCost())/((Clothes) order).getQty();
					System.out.println("Order Category      : " + order.getCategory());
					System.out.println("Order ID            : " + order.getID());
					System.out.println("Order Name   	    : " + order.getName());
					System.out.println("Base Price          : " + price);
					System.out.println("Total Quantity      : " + ((Clothes) order).getQty());
					System.out.println("Total Packaging Fee : " + ((Clothes) order).getPackCost());
					System.out.println("Total Shipping Fee  : " + order.getShipCost());
					System.out.println("Total Price         : " + order.calculateTotalPrice());
				
				}
					
				return 1;
			}
		}
		
		return 0;
	}

	// Function to cancel order
	public void cancelOrder() {
		System.out.println("Cancel order\n");
		
		String findID;
		int temp = 0;
		
		// Ask user to input order ID they want to cancel
		System.out.print("Input order ID: ");
		findID = scan.nextLine();
		
		// Call function viewOrder to check order and show the details
		if(detailOrder(findID, temp) == 1) {
			
			String choice;
			while(true) {
				System.out.print("\nAre you sure you want to cancel this order [Yes | No]: ");
				choice = scan.nextLine();
				
				if(choice.equals("Yes") || choice.equals("No"))
					break;
			}
			
			if(choice.equals("Yes")) {
				for(int i=0; i<listOrder.size(); i++) {
					if(listOrder.get(i).getID().equals(findID)) {
						listOrder.remove(i);
					}
				}
				
				System.out.println("\nSuccessfully canceled order " + findID);
				System.out.println("Press enter to continue...");
				scan.nextLine();
				
			} else {
				System.out.println("\nNot successfully canceled order " + findID);
				System.out.println("Press enter to continue...");
				scan.nextLine();
			}
			
		} else {
			System.out.println("Order ID " + findID + " is not found");
			System.out.println("Press enter to continue...");
			scan.nextLine();
		}
		
	}

	public Main() {
		while (true) {
			cls();
			System.out.println("List Order E-Commerce Program");
			System.out.println("1. Add new order");
			System.out.println("2. View all order");
			System.out.println("3. Cancel order");
			System.out.println("4. Exit");
			System.out.print("Choose >> ");

			int menu = scan.nextInt();
			scan.nextLine();

			int flag = 0;
			switch (menu) {
			case 1:
				cls();
				addOrder();
				break;
			case 2:
				cls();
				viewOrder();
				break;
			case 3:
				cls();
				cancelOrder();
				break;
			case 4:
				cls();
				System.out.println("Thank you for using this program. Have a nice day");
				flag = 1;
				break;
			default:
				break;
			}

			if (flag == 1)
				break;
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
