package com.carrental;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String cities[] = { "Kathmandu", "Butwal", "Pokhara", "Nepalgunj", "Biratnagar" };
        String cars[] = { "Totota", "Tesla", "Honda", "Nissan", "Lexas", "BMW" };
        String bookingDetails[] = new String[5];

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter pick up location");
        String pickUpLocation = sc.next();

        System.out.println("Enter drop off location");
        String dropOffLocation = sc.next();

        CarRental cr = new CarRental();
        if (cr.sourceDestinationMatch(cities, pickUpLocation, dropOffLocation)) {
            System.out.println("Pick up and drop off location can't be same");
        } else {
            if (cr.sourceIsValid(cities, pickUpLocation) && cr.destinationIsValid(cities, dropOffLocation)) {
                System.out.println("Enter pick up date");
                String pickUpDate = sc.next();
                cr.setPickUpDate(pickUpDate);

                System.out.println("Enter pick up time");
                String pickUpTime = sc.next();
                cr.setPickUpTime(pickUpTime);

                cr.exploreCars(cars);

                int carOption = sc.nextInt();

                bookingDetails[0] = pickUpLocation;
                bookingDetails[1] = dropOffLocation;
                bookingDetails[2] = pickUpDate;
                bookingDetails[3] = pickUpTime;
                bookingDetails[4] = cr.fetchCarBySelectedOption(carOption);

                cr.bookingDetails(bookingDetails);
            } else {
                System.out.println("Invalid pick up or drop off location !");
            }

        }

    }

}

