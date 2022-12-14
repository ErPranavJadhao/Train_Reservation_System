package com.train.booking;

import java.util.LinkedList;
import java.util.List;

public class TicketService {
	private static List<Ticket> allTickets=new LinkedList<>();

	public static void addNewTicket(long trainNumber,List<Passenger>passengerList) {
		int pnr=allTickets.size()+1;
		Train bookedTrain=TrainService.findTrain(trainNumber);
		allTickets.add(new Ticket(pnr, bookedTrain, passengerList));
		System.out.println("Tickets booked successfully......");
	}
	
	public static void showTicketDetails(int pnr) {
		Ticket tempTicket=null;
		for(Ticket t:allTickets) {
			if(t.getPnr()==pnr) {
				tempTicket=t;
				break;
			}
		}
		Train tempTrain=tempTicket.getBookedTrain();
		List<Passenger> passengerList=tempTicket.getPassengerList();
		int totalFare=tempTrain.getFare()* passengerList.size();
		
		System.out.println(".....Your Booking Details.....");
		System.out.println("PNR=>"+tempTicket.getPnr()+"  Tr.No"+tempTrain.getTrainNumber());
		System.out.println("Train Name:-"+ tempTrain.getTrainName());
		System.out.println("Form Station:-"+tempTrain.getFromStation()+"  To Station:-"+tempTrain.getToStation());
		System.out.println("DOJ:-"+tempTrain.getDoj());
		System.out.println("Fare:-"+tempTrain.getFare());
		System.out.println("Total Fare:-"+ totalFare);
		System.out.println("\nPassenger info below\n");
		
		System.out.println("Passenger Name       Age");
		for(Passenger p:passengerList) {
			System.out.println(p.getPassengerName()+"t"+p.getAge());
		}
		System.out.println("...............................");
	}
}
