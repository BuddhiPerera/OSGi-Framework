package com.sliit.mtit.osgi.paymentproducer;

public class PaymentDetail {
	private int cardNumber;
	  private String cardHolderName;
	  private String date;
	  private int cvv;
	  private boolean valid;

	    public PaymentDetail() {// No Argument Constructor
	    }

	    public PaymentDetail(int cardNumber, String cardHolderName, String date, int cvv,boolean valid) { // Full Argument Constructor
	        this.cardNumber = cardNumber;
	        this.cardHolderName = cardHolderName;
	        this.date = date;
	        this.valid = valid;
	        this.cvv = cvv;
	    }

	    public int getCardNumber() {
	        return cardNumber;
	    }

	    public void setCardNumber(int cardNumber) {
	        this.cardNumber = cardNumber;
	    }
	    public boolean isValid() {
	        return valid;
	    }

	    public void setValid(boolean valid) {
	        this.valid = valid;
	    }

	    public String getCardHolderName() {
	        return cardHolderName;
	    }

	    public void setCardHolderName(String cardHolderName) {
	        this.cardHolderName = cardHolderName;
	    }

	    public String getDate() {
	        return date;
	    }

	    public void setDate(String date) {
	        this.date = date;
	    }

	    public int getCvv() {
	        return cvv;
	    }

	    public void setCvv(int cvv) {
	        this.cvv = cvv;
	    }
}
