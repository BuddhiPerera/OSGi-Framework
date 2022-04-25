package package_com.sliit.mtit.osgi.hotelbeveragepulisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BeveragePublishImpl implements BeveragePublish {

	ArrayList<BevarageDetails> b = new ArrayList<BevarageDetails>();

	@Override
	public ArrayList<BevarageDetails> displayBeverage() {
		boolean x = false;
		String y = "Y";

		do {
			BevarageDetails bh = getbev();
			b.add(bh);
			Scanner sc = new Scanner(System.in);
			System.out.println("Do You want add Another Bottle?");
			y = sc.next();
		} while (!(y.equals("N")));
		return b;
	}// End Method

	BevarageDetails getbev() {
		int amount = 0;
		String bev = "";
		HashMap<Integer, String> type = new HashMap<Integer, String>();// Hash Map to Store beverage data

		type.put(1, "B Visky Rs: 2000.00"); // Add Data To HashMap
		type.put(2, "A visky Rs: 3000.00");
		type.put(3, "C Visky RS: 5000.00");
		type.put(4, "D Visky Rs: 6880.00");
		System.out.println();

		System.out.println("------------Select Beverage Plan-------------"); // Print Beverage Plan to Select
		System.out.println(type.get(1) + " = 1");
		System.out.println(type.get(2) + " = 2");
		System.out.println(type.get(3) + " = 3");
		System.out.println(type.get(4) + " = 4");
		System.out.println("\n**********************************");
		System.out.println();

		String conBuy = "N";
		while (conBuy.equalsIgnoreCase("N")) {// Run while Meal In the Cart

			System.out.print("Enter Beverage Number :");
			@SuppressWarnings("resource")
			Scanner optionKey = new Scanner(System.in);
			int selector = optionKey.nextInt();

			HashMap<Integer, Integer> price = new HashMap<Integer, Integer>();// HashMap to Store Beverage Price
			price.put(1, 1000); // Add Prices to HashMap
			price.put(2, 3000);
			price.put(3, 5000);
			price.put(4, 6880);

			switch (selector) { // Switch to select Meal

			case 1:
				amount = amount + (Integer) price.get(1);
				bev = type.get(1) + "";
				System.out.println("Beverage Price RS : " + price.get(1));
				break;

			case 2:
				amount = amount + (Integer) price.get(2);
				bev = type.get(2) + "";
				System.out.println("Beverage Price RS : " + price.get(2));
				break;

			case 3:
				amount = amount + (Integer) price.get(3);
				bev = type.get(3) + "";
				System.out.println("Beverage Price RS : " + price.get(3));
				break;

			case 4:
				amount = amount + (Integer) price.get(4);
				bev = type.get(4) + "";
				System.out.println("Beverage Price RS : " + price.get(4));
				break;

			default:
				System.out.println("Invalid Beverage Id. Please enter valid number");
				continue;
			}// End Switch

			System.out.print("Confirm Beverage? (Y/N):");// Confirmation
			@SuppressWarnings("resource")
			Scanner contuBUY = new Scanner(System.in);
			String answer = contuBUY.next();
			if (answer.equals("Y") || answer.equals("y")) { // Change conBuy to stop While loop After Select beverage
				conBuy = answer;
			}
		} // End While

		return new BevarageDetails(conBuy, bev, amount); // Return New beverage Detail Object (array list)
	}
}
