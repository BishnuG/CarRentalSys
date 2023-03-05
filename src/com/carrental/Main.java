package com.carrental;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

//    	When customer select the cab type. Then we need to display the per km rate for the cab. 
//    	( Km wise rate for each type cab we need to store somewhere). Assuming when any customer 
//    	book cab means minimum 250 km charge needs to pay. Add 5% tax on top of that and calculate 
//    	the final price of billing.
//
//    	Ex- 
//    	Cars [Baleno, jeep, Alto, innova]
//    	     Kmrate  [12, 15, 11, 17]

		String cities[] = { "Kathmandu", "Butwal", "Pokhara", "Nepalgunj", "Biratnagar" };
		String cars[] = { "Totota", "Tesla", "Honda", "Nissan", "Lexas", "BMW" };
		int perKmRates[] = { 15, 18, 12, 12, 16, 20 };
		String bookingDetails[] = new String[6];

		Scanner sc = new Scanner(System.in);

		CarRental cr = new CarRental();

		System.out.println("Enter pick up location");
		String pickUpLocation = sc.next();
		cr.setPickUpLocation(pickUpLocation);

		System.out.println("Enter drop off location");
		String dropOffLocation = sc.next();
		cr.setDropOffLocation(dropOffLocation);

		if (cr.sourceDestinationMatch(cities, pickUpLocation, dropOffLocation)) {
			System.out.println("Pick up and drop off location can't be same");
		} else {
			if (cr.sourceIsValid(cities, pickUpLocation) && cr.destinationIsValid(cities, dropOffLocation)) {
				System.out.println("Enter pick up date");
				String pickUpDate = sc.next();
				cr.setPickUpDate(pickUpDate);

				System.out.println("Enter drop off date");
				String dropOffDate = sc.next();
				cr.setDropOffDate(dropOffDate);

				System.out.println("Enter pick up time");
				String pickUpTime = sc.next();
				cr.setPickUpTime(pickUpTime);

				cr.exploreCars(cars, perKmRates);

				int carOption = sc.nextInt();

				bookingDetails[0] = pickUpLocation;
				bookingDetails[1] = dropOffLocation;
				bookingDetails[2] = pickUpDate;
				bookingDetails[3] = pickUpTime;
				bookingDetails[4] = cr.fetchCarBySelectedOption(carOption);
				bookingDetails[5] = cr.finalPriceBillingTest(cars, perKmRates, carOption);

				cr.bookingDetails(bookingDetails);

			} else {
				System.out.println("Invalid pick up or drop off location !");
			}

		}

	}

}
