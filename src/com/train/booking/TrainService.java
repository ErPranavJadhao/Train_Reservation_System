package com.train.booking;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class TrainService {
	
private static List<Train> allTrains=new LinkedList<>();

static {
	allTrains.add(new Train(12113,"Garib-Rath","Pune","Nagpur",350,1800,LocalDate.now()));
	allTrains.add(new Train(12129,"Howrah Azad Hind SF","Pune","Nagpur",150,1605,LocalDate.now()));
	allTrains.add(new Train(12221,"Howrah AC Duronto","Pune","Nagpur",50,3445,LocalDate.now()));
	allTrains.add(new Train(11039,"Maharastra Express","Pune","Akola",450,1590,LocalDate.now()));
	allTrains.add(new Train(20821,"Humsafar Express","Akola","Pune",750,1485,LocalDate.now()));
	allTrains.add(new Train(22845,"Pune SF Express","Nagpur","Pune",35,2905,LocalDate.now()));

}

public TrainService() {
	super();
	
}
public static Train findTrain(long trainNumber) {
	Train temp=null;
	for(Train t:allTrains) {
		if(t.getTrainNumber()==trainNumber) {
			temp=t;
			break;
		}
	}
	return temp;
}
public static void searchTrainBetweenStation(String fromStation,String toStation,LocalDate doj,int numOfSeats) {
	List<Train> searchTrainList=new LinkedList<>();
	for(Train t:allTrains) {
		if(t.getFromStation().equals(fromStation) &&
				t.getToStation().equals(toStation) &&
				t.getDoj().equals(doj) &&
				t.getSeatAvailable() >numOfSeats) {
		   searchTrainList.add(t);	
		}
	}
	if(searchTrainList.size()==0) {
		System.out.println("Sorry,no Matching trains available for the search criteria...");
	}else {
		System.out.println("Tr.No\tTrain Name\tFrom Station\tTo Station\tDoj\tSeats Available\tFare");
		System.out.println();
		for(Train t: searchTrainList) {
		System.out.printf("%5d%20s%15s%15s%12s%4d%5d\n",t.getTrainNumber(),t.getTrainName(),t.getFromStation(),t.getToStation(),t.getDoj(),t.getSeatAvailable(),t.getFare());
		System.out.printf("%5d%20s%15s%15s%12s%4d%5d\n",11039,"Maharastra Express","Pune","Akola","LocalDate.now()",450,1590);
	}
}   


}
public static void bookTickets(long trainNumber,List<Passenger> passengerList) {
	// step 1: We need to subtract the train fare for all passenger together form the bank account object.
	int numOfSeats=passengerList.size();
	//Passenger tempPassenger=passengerList.get(0);
	//BankOfIndiaAccount account=tempPassenger.getBankAccount();
	
	BankOfIndiaAccount account=passengerList.get(0).getBankAccount();
	Train tempTrain=findTrain(trainNumber);
	int fare=tempTrain.getFare();
	int totalFare=fare*numOfSeats;
	account.withdraw(totalFare);
	
	// step 2: We need to subtract the number of seats that are being booked, form the actual available no of tickets.
	
	tempTrain.setSeatAvailable(tempTrain.getSeatAvailable()-numOfSeats);
	
	// step 3: We need to add one entry into tickets collection.
	TicketService.addNewTicket(trainNumber,passengerList);
	
}
}






