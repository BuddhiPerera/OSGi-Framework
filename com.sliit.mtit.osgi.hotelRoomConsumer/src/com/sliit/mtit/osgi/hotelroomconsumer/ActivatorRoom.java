package com.sliit.mtit.osgi.hotelroomconsumer;



import com.sliit.mtit.osgi.hotelbevarageconsumor.ActivatorBev;
import com.sliit.mtit.osgi.hotelbevarageconsumor.BeverageConsumor;
import com.sliit.mtit.osgi.hotelmealconsumor.ActivatorMeal;
import com.sliit.mtit.osgi.hotelmealconsumor.MealPlanConsumor;
import com.sliit.mtit.osgi.hotelpaymentconsumor.ActivatorPayment;
import com.sliit.mtit.osgi.hotelpaymentconsumor.PaymentConsumor;
import com.sliit.mtit.osgi.hotelroomcartconsumer.ActivatorCart;
import com.sliit.mtit.osgi.hotelroomcartconsumer.RoomCartServiceConsumer;
import com.sliit.mtit.osgi.hotelroomproducer.RoomDetail;
import com.sliit.mtit.osgi.hotelroomproducer.RoomServicePublish;
import com.sliit.mtit.osgi.hotelroomproducer.RoomServicePublishImpl;
import com.sliit.mtit.osgi.mealplanproducer.MealDetails;
import com.sliit.mtit.osgi.paymentproducer.PaymentDetail;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import package_com.sliit.mtit.osgi.hotelbeveragepulisher.BevarageDetails;

public class ActivatorRoom implements BundleActivator {
	ServiceRegistration serviceRegisterer;
	ServiceReference<?> serviceReference, serviceReference1;
	private String value = "";
	private String type = "";
	private double price = 0;
	private int guc = 0;
	private double Lprice = 0;
	private String mealValue = "";
	private String mealype = "";
	private List<PaymentData> buy = new ArrayList<PaymentData>(); // List to Store Payment Data List
	private double mealPrice = 0;
	private int guestCount = 0;
	private int daysCount = 0;
	private boolean liq = true;
	private int dayCounts = 0;


	public void start(BundleContext context) throws Exception {
		boolean run = true;
		while (run) {
			displyRooms(context);// Call Room Service Publish

			if ("Y".equalsIgnoreCase(value)) { // If Add to cart Yes
				RoomCartServiceConsumer a = new ActivatorCart();
				a.start(context);
				String cartRes = a.cartMenu(price); // Call Method cartMenu to confirm Book

				if (cartRes.equals("Y") || cartRes.equals("y")) { // If Booking confirmed
					checkData(context); // Call method to Create Payment Object For each Room Checkout
					boolean q = false;

					while (q != true) {// While Condition is false add Rooms

						System.out.println("Do You want add Another Room to the Cart?");
						Scanner response = new Scanner(System.in);
						String f = response.next();

						if (f.equals("Y") || f.equals("y")) { // If True. Add another Room
							displyRooms(context); // Display Room Details to add another Room
							a.start(context);
							cartRes = a.cartMenu(price); // Call Method cartMenu to confirm Book
							if (cartRes.equals("Y") || cartRes.equals("y")) {
								checkData(context); // Again Call method checkData to Create Payment Object For each
													// Room Checkout
							}
						} else { // If False. Exit While Loop

							q = true;
						}
					}
					Scanner sc =  new Scanner(System.in);
					System.out.println("Do You want add Liquor?");
					String f3 = sc.next();
					ArrayList<BevarageDetails> bevarageDetails = null ;
					if(f3.equals("Y") || f3.equals("y")) {
					BeverageConsumor b = new ActivatorBev();
					b.start(context);
					bevarageDetails = b.displyBev(context);// Call Beverage  Publisher
					
					for (BevarageDetails bevarageDetails2 : bevarageDetails) {
						 Lprice = Lprice + bevarageDetails2.getAmount();
					} 
			
					}if(f3.equals("N") || f3.equals("n"))  {
						liq = false;
					} 
					 
					 
					System.out.println("***************** Check-Out Details *****************");
					int count = 0;
					double price = 0;
					int totMel = 0;
				
					for (PaymentData pa : buy) { // Retrieve All data from Payment Data List<>
						System.out.println("Room Type: " + pa.getRoomName() + " || Room Price: " + pa.getRoomPrice()
								+ "\nNo of Days " + pa.getNoOfDays() + " || Meal Type " + pa.getMealType()
								+ " || Guest Count " + pa.getGuestCount());

						totMel = totMel + (pa.getNoOfDays() * pa.getGuestCount()) * pa.getMealPrice(); // Total Price
																										// for meal
						System.out.println();

						count++; // Room Count
						price = price + pa.getRoomPrice(); // Total Room Price
					}
					
					if(liq) {
						System.out.println("-------- Liquor Bill ----------");
					for (BevarageDetails bevarageDetails2 : bevarageDetails) {
						System.out.println("Liquor Type: " + bevarageDetails2.getBev()+ " || Liquor Price "+bevarageDetails2.getAmount());
					}
					System.out.println();
					}
					System.out.println("-----------------------------------------------------");
					System.out.println("Total Rooms : " + count + " || Total Price : " + price);
					System.out.println("Total Meal Price (No Of Guest * Days ) Meal Price) = " + totMel);

					System.out.println("Final Bill " + (price + totMel + Lprice));
					System.out.println("****************************************************");

					PaymentConsumor paymentService = new ActivatorPayment();
					paymentService.start(context);
					PaymentDetail paymentData = paymentService.displayPayment(); // Call Method cartMenu to confirm Book
					System.out.println("Payment Details are " + paymentData.isValid());

					System.out.println("----------- Payment Data ---------- ");
					System.out.println("Card Number : " + paymentData.getCardNumber() + "      Card Holder : "
							+ paymentData.getCardHolderName());
					System.out.println(
							"Card Exp-Date : " + paymentData.getDate() + "      Card CVV : " + paymentData.getCvv());

					System.out.println("Confirm Payment ?(Y/N)");
					Scanner res = new Scanner(System.in);
					String f1 = res.next();

					if (paymentData.isValid() == true && (f1.equals("Y") || f1.equals("y"))) {
						System.out.println("Payment Successfull.");
						System.out.println("Good Byee! Come Again..");
						System.out.println();
						System.out.println();
					}
				}
			}
			System.out.println("Do you want to quit ? (Y/N)");
			Scanner qtsc = new Scanner(System.in);
			String qt = qtsc.next();
			buy = null;
			if (qt.equalsIgnoreCase("Y")) {
				System.out.println("Have a nice day !");
				run = false;
			}
		} // End While
	}// End start Method


	private void checkData(BundleContext context) {
		PaymentData p = new PaymentData(); // Create PaymentData Object

		boolean isvalid1 = false;

		p.setRoomName(type);// Add Room Type to PaymentData Object

		System.out.println("Guest Count?");
		Scanner expdate = new Scanner(System.in);
		guc = expdate.nextInt();

		isvalid1 = false;
		while (!isvalid1) {
			String guc1 = guc + "";
			if (guc1.matches("^[0-9]")) { // Regular Expression Number between 0 - 9
				isvalid1 = true;
			} else {
				System.out.println("Invalid Guest Count!");
				System.out.print("Re-Enter Guest Count: ");
				guc = expdate.nextInt();
				isvalid1 = false;
			}
		}
		p.setGuestCount(guc); // Add Guest Count to PaymentData Object

		System.out.println("Day Count?");
		Scanner dayCount = new Scanner(System.in);
		dayCounts = dayCount.nextInt();
		isvalid1 = false;
		while (!isvalid1) {
			String guc1 = dayCounts + "";
			if (guc1.matches("^[0-9]")) {// Regular Expression Number between 0 - 9
				isvalid1 = true;
			} else {
				System.out.println("Invalid Day Count!");
				System.out.print("Re-Enter Day Count: ");
				dayCounts = dayCount.nextInt();
				isvalid1 = false;
			}
		}
		p.setNoOfDays(dayCounts); // Add Day Count to PaymentData Object

		MealPlanConsumor aa = new ActivatorMeal();
		aa.start(context);
		MealDetails meal = aa.displyMeals(context);// Call Meal Plan Publisher
		mealValue = meal.getResponse();
		p.setMealType(meal.getMeal()); // Add Meal type PaymentData Object
		p.setMealPrice((int) meal.getPrice());// Add Meal Price to PaymentData Object

		p.setRoomPrice((int) price);// Add Room Price to PaymentData Object
		buy.add(p);// Add PaymentData Object to List

	}// End checkData Method


	private void displyRooms(BundleContext context) {
		RoomDetail respons;
		RoomServicePublish roomService = new RoomServicePublishImpl();
		serviceRegisterer = context.registerService(RoomServicePublish.class.getName(),roomService,null);
	
		respons = roomService.displayRooms();// Call Method displayRooms() to Display Room Menu
		value = respons.getRespons(); // Add cart Yes or No
		type = respons.getRoom(); // Room Type
		price = respons.getPrice(); // Room Price
	}
	
	private void displyBeverage(BundleContext context) {

	}

	public void stop(BundleContext context) throws Exception {

	}

}
