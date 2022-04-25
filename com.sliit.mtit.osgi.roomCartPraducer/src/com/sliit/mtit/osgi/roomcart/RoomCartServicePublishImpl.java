package com.sliit.mtit.osgi.roomcart;

import java.util.Scanner;

public class RoomCartServicePublishImpl implements RoomCartServicePublish {
	@Override
	public String cartMenu(double tot) {
		System.out.println("Room/s total cost is : Rs." + tot);
		System.out.print("Do you want to Book? (Y/N): ");// Confirmation
		@SuppressWarnings("resource")
		Scanner response = new Scanner(System.in);
		String buy = response.next();
		return buy;
	}
}