package com.lesson.lab.controller;

import com.lesson.lab.model.Seat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeatBooking {
    // List to store bookings
    private List<Seat> bookedSeatsList;
    // Constructor
    public SeatBooking() {
        // Initialize the list of booked seats
        //  :
        this.bookedSeatsList = new ArrayList<Seat>();

    }
    // Method to add a new seat booking
    public void addNewBooking(String seatNumber) {
        // TODO 2: check if the seat is already booked and not canceled
        for(Seat obj:bookedSeatsList)
        {
            if(obj.getSeatNumber().equals(seatNumber) && obj.isBooked() && !obj.isCanceled())
            {
                System.out.println("seat "+seatNumber+"is already booked not cancelled");
                return;

            }
        }
        Seat s=new Seat(seatNumber);
        s.setBooked(true);
        s.setBookingDate(new Date());
        bookedSeatsList.add(s);
        System.out.println("Booking confirmed for seat: " + seatNumber);
        System.out.println("Booking Date Set: " + s.getBookingDate());


        //  create a new Seat object for the booking,
        // mark the seat as booked,
        // set the current date as the booking date
        //  add the new seat to the bookedSeatsList
        //  confirm the booking to the user
    }
    public void cancelBooking(String seatNumber) {
        for (Seat seat : bookedSeatsList) {
            // Check if the current seat's seatNumber matches the one provided
            if(seat.getSeatNumber().equals(seatNumber) && !seat.isCanceled())
            {
                bookedSeatsList.remove(seat);
            }
            //  If a match is found, remove the seat from the bookedSeatsList and print a confirmation message
            System.out.println("Seat " + seatNumber + " has been successfully cancelled!");
            return;
        }
        System.out.println("Seat  "+seatNumber+" was not booked");
        // : If no matching seat is found, print a message indicating that the seat was not found
    }


    public void updateBooking(String oldSeatNumber, String newSeatNumber) {
        for (Seat seat : bookedSeatsList) {
            if(seat.getSeatNumber().equals(oldSeatNumber) && !seat.isCanceled())
            {
                seat.setBooked(false);
                bookedSeatsList.remove(oldSeatNumber);


                //  check if the seat matches the old seat number
                //  unbook the current seat (set isBooked to false)
                // remove the old seat from the list

                Seat newSeat = new Seat(newSeatNumber);
                newSeat.setBooked(true);
                bookedSeatsList.add(newSeat);
            }


            System.out.println("Seat " + oldSeatNumber + " has been updated to " + newSeatNumber + "!");
            return;
        }
        System.out.println("Seat " + oldSeatNumber + " not found.");
    }
    public void displayBookings() {
        if(bookedSeatsList.isEmpty())
        {
            System.out.println("no seats booked");
            return;
        }

        for(Seat seat:bookedSeatsList)
        {
            if(seat.isBooked())
            {
                System.out.println(seat +" is booked");
            }
        }

        //  check if the bookedSeatsList is empty
        //  iterate through the bookedSeatsList
        //  check if the seat is booked
        //  display the seat number
    }

}


















