package com.sliit.mtit.osgi.paymentproducer;

import java.util.Scanner;

public class PaymentServicePublishImpl implements PaymentServicePublish{

	@Override
	public PaymentDetail displayPayment() {// Override method from PaymentServicePublish Interface
		
		PaymentDetail paymentObject = new PaymentDetail();//Create Payment Object From PaymentObject Bean Class
		
		System.out.print("Enter your Credit Card Number : ");// Credit Card Enter

		boolean isvalid = false;
		@SuppressWarnings("resource")
		Scanner num = new Scanner(System.in);
		int cCard = num.nextInt();

		while (!isvalid) {          // While Loop
			String ScardNum = String.valueOf(cCard);
		
			if (ScardNum.length() == 6) { // Condition Check Only 6 digits
			isvalid = true;
		
			} else {
			System.out.println("Invalid Card Number!");
			System.out.print("Re-Enter payment : ");
			cCard = num.nextInt();
			isvalid = false;
			}
		} // End While Loop
		paymentObject.setCardNumber(cCard);//Add card Number to Object
		
		
		 System.out.print("Enter Card Holder's Name : ");  // Card Holder Name Enter

	        @SuppressWarnings("resource")
			Scanner name = new Scanner(System.in);
	        String cCardName = name.next();
	        isvalid = false;
	        while (!isvalid) {            // While Loop

	            if (cCardName.matches("^[a-zA-Z]*$")) { // Regular Expression Check (Only Alphabetic)
	                isvalid = true;
	            } else {
	                System.out.println("Invalid Name!");
	                System.out.print("Re-Enter Card Holder Name : ");
	                cCardName = name.next();
	                isvalid = false;
	            }
	        }// End While Loop
	        paymentObject.setCardHolderName(cCardName);//Add card Holder Name to Object
	        
	        
	        System.out.print("Enter Card Expire Date : ");// Card Expire Date Enter

	        @SuppressWarnings("resource")
			Scanner expdate = new Scanner(System.in);
	        String exp = expdate.next();
	        isvalid = false;
	        while (!isvalid) {      // While Loop
	             
	            if (exp.matches("^((0[1-9])|(1[0-2]))\\/(\\d{2})$")) {// Regular Expression Check Month and Last two digit of year
	                isvalid = true;
	            } else {
	                System.out.println("Invalid Exp Date!");
	                System.out.print("Re-Enter Card Expire Date : ");
	                exp = expdate.next();
	                isvalid = false;
	            }
	        }// End While Loop
	        paymentObject.setDate(exp);//Add card Expire Date to Object
	        
	        
	        System.out.print("Enter Card CVV Number : ");// CVV Number Enter

	        @SuppressWarnings("resource")
			Scanner num3 = new Scanner(System.in);
	        int cvv = num3.nextInt();
	        isvalid = false;
	        while (!isvalid) {		// While Loop
	          
	            String ScardNum = String.valueOf(cvv);
	            if (ScardNum.length() == 3) { // Condition Check Only 3 digits
	                isvalid = true;
	            } else {
	                System.out.println("Invalid Name!");
	                System.out.print("Re-Enter Card CVV Number : ");
	                cvv = num3.nextInt();
	                isvalid = false;
	            }
	        }// End While Loop
	        paymentObject.setCvv(cvv);//Add CVV to Object
	        paymentObject.setValid(isvalid);//Add Validate to Object
	        
	        
	        
	return paymentObject; // Return paymentObject
	}//End displayPayment Method 

}//End Class
