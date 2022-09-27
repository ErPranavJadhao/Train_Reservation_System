package com.train.booking;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class TrainMain {
    public static void main(String[] args) {
    	System.out.println("Now searching for trains....");
		TrainService.searchTrainBetweenStation("Pune", "Akola", LocalDate.now(),50);
		
		BankOfIndiaAccount b=new BankOfIndiaAccount();
		b.setAccountBalance(01234);
		b.setAccountBalance(25000);
		
		Passenger p=new Passenger(101, "PranavJ", 25, b);
		Passenger p1=new Passenger(102, "Sam", 28, b);
		Passenger p2=new Passenger(103, "Smith", 35, b);
	
		int initialBalance=b.getAccountBalance();
		List<Passenger>passengerList=new LinkedList<>();
		passengerList.add(p);
		passengerList.add(p1);
		passengerList.add(p2);
		
		System.out.println("Now booking tickets for 3 passenger in train number 11039");
		
		TrainService.bookTickets(11039, passengerList);
		
		System.out.println("Now printing the ticket details......");
		
		TicketService.showTicketDetails(1);
		
		System.out.println("\n\n");

		TrainService.searchTrainBetweenStation("Pune", "Akola", LocalDate.now(),50);
		
		int balanceAfterBookingTickets=b.getAccountBalance();
		
		System.out.println("Initial balance="+initialBalance);
		System.out.println("Balance after booking="+balanceAfterBookingTickets);
	}
}
