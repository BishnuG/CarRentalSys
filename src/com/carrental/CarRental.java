package com.carrental;

import java.util.Random;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CarRental {

	String pickUpDate;
	String dropOffDate;
	String pickUpTime;
	String pickUpLocation;
	String dropOffLocation;

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

	public String getDropOffDate() {
		return dropOffDate;
	}

	public void setDropOffDate(String dropOffDate) {
		this.dropOffDate = dropOffDate;
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

	public void exploreCars(String[] cars, int[] perKmRates) {
		int rnd1 = new Random().nextInt(cars.length);
		int rnd2 = new Random().nextInt(cars.length);
		int secondRandomNumber = rnd2;
		while (rnd1 == secondRandomNumber) {
			secondRandomNumber = new Random().nextInt(cars.length);
		}
		System.out.println("Select any car");
		System.out.println("1. " + cars[rnd1] + " perkm rate is: " + perKmRates[rnd1]);
		System.out.println("2. " + cars[secondRandomNumber] + " perkm rate is: " + perKmRates[secondRandomNumber]);
		carOptions[0] = cars[rnd1];
		carOptions[1] = cars[secondRandomNumber];
	}

	public String fetchCarBySelectedOption(int carOption) {
		String selectedCar = carOptions[carOption - 1];
		return selectedCar;
	}

//	public int finalPriceBilling(String[] cars, int[] rates, int carOption) {
//		int selectedIndex = 0;
//		String selectedCar = fetchCarBySelectedOption(carOption);
//		for (int i = 0; i < cars.length; i++) {
//			if (selectedCar.equalsIgnoreCase(cars[i])) {
//				selectedIndex = i;
//				break;
//			}
//		}
//
//		int selectedCarRate = rates[selectedIndex];
//		String pickUpDate = getPickUpDate();
//		String dropOffDate = getPickUpDate();
//
//		LocalDate pickDate = LocalDate.parse(pickUpDate);
//		LocalDate dropDate = LocalDate.parse(dropOffDate);
//
//		long noOfDaysBetween = ChronoUnit.DAYS.between(pickDate, dropDate);
//		int days = (int) noOfDaysBetween;
//		int finalPrice = days * 250 * selectedCarRate;
//		finalPrice = finalPrice + (finalPrice * 5) / 100;
//		//Integer.toString(finalPrice);
//		return finalPrice;
//	}
	
	public void finalPriceBilling(String[] cars, int[] rates, int carOption) {
		int selectedIndex = 0;
		String selectedCar = fetchCarBySelectedOption(carOption);
		for (int i = 0; i < cars.length; i++) {
			if (selectedCar.equalsIgnoreCase(cars[i])) {
				selectedIndex = i;
				break;
			}
		}

		int selectedCarRate = rates[selectedIndex];
		String pickUpDate = getPickUpDate();
		String dropOffDate = getDropOffDate();

		LocalDate pickDate = LocalDate.parse(pickUpDate);
		LocalDate dropDate = LocalDate.parse(dropOffDate);

		long noOfDaysBetween = ChronoUnit.DAYS.between(pickDate, dropDate);
		int days = (int) noOfDaysBetween;
		int finalPrice = days * 250 * selectedCarRate;
		finalPrice = finalPrice + (finalPrice * 5) / 100;
//		System.out.println("pickUpDate: " +pickUpDate);
//		System.out.println("dropOffDate: " +dropOffDate);
//		System.out.println("selectedCarRate: " +selectedCarRate);
//		System.out.println("noOfDaysBetween: " +noOfDaysBetween);
//		System.out.println("finalPrice: " +finalPrice);
		
		System.out.println("*** Booking Details ***");
		System.out.println("Pick up location: " + getPickUpLocation());
		System.out.println("Drop off location: " + getDropOffLocation());
		System.out.println("Pick up date: " + pickUpDate);
		System.out.println("Drop off date: " + getDropOffDate());
		System.out.println("Pick up time: " + getPickUpTime());
		System.out.println("Car: " + selectedCar);
		System.out.println("Final billing price: " + finalPrice);
		
	}

	public String getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public String getDropOffLocation() {
		return dropOffLocation;
	}

	public void setDropOffLocation(String dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
	}

//	public void bookingDetails(String[] bookingDetails) {
//		System.out.println("*** Booking Details ***");
//		System.out.println("Pick up location: " + bookingDetails[0]);
//		System.out.println("Drop off location: " + bookingDetails[1]);
//		System.out.println("Pick up date: " + bookingDetails[2]);
//		System.out.println("Pick up time: " + bookingDetails[3]);
//		System.out.println("Car: " + selectedCar);
//		System.out.println("Final billing price: " + bookingDetails[5]);
//	}

}
