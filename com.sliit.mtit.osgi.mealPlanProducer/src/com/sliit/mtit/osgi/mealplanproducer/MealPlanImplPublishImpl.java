package com.sliit.mtit.osgi.mealplanproducer;

import java.util.HashMap;
import java.util.Scanner;

public class MealPlanImplPublishImpl implements MealPlanPublish { // Class Implement MealPlanPublish Interface

	@Override
	public MealDetails displayMeals() { // Start displayMeals method override from MealPlan Interface
		int amount = 0;
		String meal = "";
		HashMap<Integer, String> type = new HashMap<Integer, String>();//Hash Map to Store Meal Plan
		
		type.put(1, "Breakfast Only Rs: 1000.00");  // Add Data To HashMap
		type.put(2, "Lunch and Breakfast Only Rs: 3000.00");
		type.put(3, "Full Board Rs: 5000.00");
		type.put(4, "Without Meal Rs:0.00");
		System.out.println();
		
		System.out.println("------------Select Meal Plan-------------"); //Print Meal Plan to Select
		System.out.println(type.get(1)+" = 1");
		System.out.println(type.get(2)+" = 2");
		System.out.println(type.get(3)+" = 3");
		System.out.println(type.get(4)+" = 4");
		System.out.println("\n**********************************");
		System.out.println();
		
		String conBuy = "N";
		while (conBuy.equalsIgnoreCase("N")) {// Run while Meal In the Cart

			System.out.print("Enter Meal Number :");
			@SuppressWarnings("resource")
			Scanner optionKey = new Scanner(System.in);
			int selector = optionKey.nextInt();

			 HashMap<Integer, Integer> price = new HashMap<Integer, Integer>();// HashMap to Store Meal Price
			price.put(1, 1000); // Add Prices to HashMap
			price.put(2, 3000);
			price.put(3, 5000);
			price.put(4, 0);


		switch (selector) { //Switch to select Meal

			case 1:
				amount = amount + (Integer)price.get(1);
				meal = type.get(1)+"";
				System.out.println("Meal Price RS : "+ price.get(1));
				break;

			case 2:
				amount = amount + (Integer)price.get(2);
				meal = type.get(2)+"";
				System.out.println("Meal Price RS : "+ price.get(2));
				break;

			case 3:
				amount = amount + (Integer)price.get(3);
				meal = type.get(3)+"";
				System.out.println("Meal Price RS : "+ price.get(3));
				break;

			case 4:
				amount = amount + (Integer)price.get(4);
				meal = type.get(4)+"";
				System.out.println("Meal Price RS : "+ price.get(4));
				break;
		

			default:
				System.out.println("Invalid Meal Id. Please enter valid number");
				continue;
		}//End Switch
		 
		System.out.print("Confirm Meal? (Y/N):");//Confirmation
		@SuppressWarnings("resource")
		Scanner contuBUY = new Scanner(System.in);
		String answer = contuBUY.next();
			if(answer.equals("Y") || answer.equals("y")) { // Change conBuy to stop While loop After Select Meal
				conBuy = answer;
			}
		}//End While
		
		return new MealDetails(conBuy,meal, amount); // Return New Meal Detail Object
		}// End Method

	}//End  class
