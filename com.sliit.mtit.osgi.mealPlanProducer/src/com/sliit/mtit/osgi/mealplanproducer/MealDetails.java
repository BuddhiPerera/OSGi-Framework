package com.sliit.mtit.osgi.mealplanproducer;

public class MealDetails { // Java Bean Class
	private String response;
	private String meal;
	private double price;

	public MealDetails(String response, String meal, double price) {
		this.response = response;
		this.meal = meal;
		this.price = price;
	}

	public MealDetails() {
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
