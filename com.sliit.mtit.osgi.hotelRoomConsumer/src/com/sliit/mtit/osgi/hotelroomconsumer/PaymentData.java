package com.sliit.mtit.osgi.hotelroomconsumer;


public class PaymentData {

	private String roomName;
	private int RoomPrice;
	private int noOfDays;
	private int guestCount;
	private String mealType;
	private int mealPrice;
	
	PaymentData(String roomName, int RoomPrice , int noOfDays, int guestCount , String mealType, int mealPrice){
		this.roomName = roomName;
		this.RoomPrice = RoomPrice;
		this.guestCount= guestCount;
		this.noOfDays = noOfDays;
		this.mealType = mealType;
		this.mealPrice = mealPrice;
	}
	PaymentData(){
	
	}
	
	 public String getRoomName() {
	        return roomName;
	    }
	 
	 public int getMealPrice() {
		 return mealPrice;
	 }
	 
	 public void setMealPrice(int MealPrice) {
		 mealPrice =MealPrice;
	 }

	    public void setRoomName(String roomName) {
	        this.roomName = roomName;
	    }

	    public int getRoomPrice() {
	        return RoomPrice;
	    }

	    public void setRoomPrice(int roomPrice) {
	        RoomPrice = roomPrice;
	    }

	    public int getNoOfDays() {
	        return noOfDays;
	    }

	    public void setNoOfDays(int noOfDays) {
	        this.noOfDays = noOfDays;
	    }

	    public int getGuestCount() {
	        return guestCount;
	    }

	    public void setGuestCount(int guestCount) {
	        this.guestCount = guestCount;
	    }

	    public String getMealType() {
	        return mealType;
	    }

	    public void setMealType(String mealType) {
	        this.mealType = mealType;
	    }
	}


