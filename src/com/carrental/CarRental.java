package com.carrental;

import java.util.Random;

public class CarRental {

	String pickUpDate;
	String pickUpTime;

	public String getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(String pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public String getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(String pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	public boolean sourceDestinationMatch(String[] cities, String source, String destination) {
		boolean flag = true;
		for (String city : cities) {
			if (city.equalsIgnoreCase(source) && source.equalsIgnoreCase(destination)) {
				flag = true;
				break;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	public boolean sourceIsValid(String[] cities, String source) {
		boolean flag = true;
		for (String city : cities) {
			if (city.equalsIgnoreCase(source)) {
				flag = true;
				break;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	public boolean destinationIsValid(String[] cities, String destination) {
		boolean flag = true;
		for (String city : cities) {
			if (city.equalsIgnoreCase(destination)) {
				flag = true;
				break;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	String carOptions[] = new String[2];

	public void exploreCars(String[] cars) {
		int rnd1 = new Random().nextInt(cars.length);
		int rnd2 = new Random().nextInt(cars.length);
		System.out.println("Select any car");
		System.out.println("1. " + cars[rnd1]);
		System.out.println("2. " + cars[rnd2]);
		carOptions[0] = cars[rnd1];
		carOptions[1] = cars[rnd2];
	}

	public String fetchCarBySelectedOption(int carOption) {
		String selectedCar = carOptions[carOption - 1];
		return selectedCar;
	}

	public void bookingDetails(String[] bookingDetails) {
		System.out.println("*** Booking Details ***");
		System.out.println("Pick up location: " + bookingDetails[0]);
		System.out.println("Drop off location: " + bookingDetails[1]);
		System.out.println("Pick up date: " + bookingDetails[2]);
		System.out.println("Pick up time: " + bookingDetails[3]);
		System.out.println("Car: " + bookingDetails[4]);
	}

}

