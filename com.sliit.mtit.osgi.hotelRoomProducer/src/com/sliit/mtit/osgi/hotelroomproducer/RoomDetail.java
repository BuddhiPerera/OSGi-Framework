package com.sliit.mtit.osgi.hotelroomproducer;

public class RoomDetail {
	private String respons;
	private String room;
	private double price;

	public RoomDetail() {
	}

	public RoomDetail(String respons, String room, double price) {
		this.respons = respons;
		this.room = room;
		this.price = price;
	}

	public String getRespons() {
		return this.respons;
	}

	public void setRespons(String respons) {
		this.respons = respons;
	}

	public String getRoom() {
		return this.room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
