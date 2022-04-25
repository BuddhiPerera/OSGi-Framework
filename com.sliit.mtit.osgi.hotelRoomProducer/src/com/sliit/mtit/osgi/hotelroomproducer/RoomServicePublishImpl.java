package com.sliit.mtit.osgi.hotelroomproducer;

import java.util.HashMap;
import java.util.Scanner;

public class RoomServicePublishImpl implements RoomServicePublish {

	public RoomServicePublishImpl() {
	}

	public RoomDetail displayRooms() {
		int amount = 0;
		String room = "";
		HashMap<Integer, String> type = new HashMap<Integer, String>();
		type.put(1, "Deluxe Queen Room Rs: 25000.00 ");
		type.put(2, "Deluxe King Room Rs: 30000.00 ");
		type.put(3, "Executive King Room Rs: 35000.00 ");
		type.put(4, "Premier King Room Rs: 45000.00 ");
		type.put(5, "The Radh Premier Suite Rs: 50000.00 ");
		type.put(6, "Garden Suite with Plunge Pool Rs: 65000.00 ");
		System.out.println("Room Service Publisher start");
		System.out.println();
		System.out.println("*****************Welcome to Hotel Jetwing Lighthouse*****************");
		System.out.println("------------Room List-------------------------------");
		System.out.println((String) type.get(1) + " = 1");
		System.out.println((String) type.get(2) + " = 2");
		System.out.println((String) type.get(3) + " = 3");
		System.out.println((String) type.get(4) + " = 4");
		System.out.println((String) type.get(5) + " = 5");
		System.out.println((String) type.get(6) + " = 6");
		System.out.println("\n*****************End Of Room List*****************");
		System.out.println();
		String conBuy = "N";

		while (true) {
			String answer;
			do {
				label22: while (true) {
					if (!conBuy.equalsIgnoreCase("N")) {
						return new RoomDetail(conBuy, room, (double) amount);
					}

					System.out.print("Enter Room Number :");
					@SuppressWarnings("resource")
					Scanner optionKey = new Scanner(System.in);
					int selector = optionKey.nextInt();
					HashMap<Integer, Integer> price = new HashMap<Integer, Integer>();
					price.put(1, 25000);
					price.put(2, 30000);
					price.put(3, 35000);
					price.put(4, 45000);
					price.put(5, 50000);
					price.put(6, 65000);
					switch (selector) {
					case 1:
						amount += (Integer) price.get(1);
						room = (String) type.get(1);
						System.out.println("Room Price RS : " + price.get(1));
						break label22;
					case 2:
						amount += (Integer) price.get(2);
						room = (String) type.get(2);
						System.out.println("Room Price RS : " + price.get(2));
						break label22;
					case 3:
						amount += (Integer) price.get(3);
						room = (String) type.get(3);
						System.out.println("Room Price RS : " + price.get(3));
						break label22;
					case 4:
						amount += (Integer) price.get(4);
						room = (String) type.get(4);
						System.out.println("Room Price RS : " + price.get(4));
						break label22;
					case 5:
						amount += (Integer) price.get(5);
						room = (String) type.get(5);
						System.out.println("Room Price RS : " + price.get(5));
						break label22;
					case 6:
						amount += (Integer) price.get(6);
						room = (String) type.get(6);
						System.out.println("Room Price RS : " + price.get(6));
						break label22;
					default:
						System.out.println("Invalid Room Number. Please enter valid number");
					}
				}

				System.out.print("Do you Want to ADD To Cart? (Y/N):");
				@SuppressWarnings("resource")
				Scanner contuBUY = new Scanner(System.in);
				answer = contuBUY.next();
			} while (!answer.equals("Y") && !answer.equals("y"));

			conBuy = answer;
		}
	}
}
