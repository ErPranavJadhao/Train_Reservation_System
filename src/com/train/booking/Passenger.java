package com.train.booking;

public class Passenger {
private int paasengerId;
private String passengerName;
private int age;
private BankOfIndiaAccount bankAccount;
public Passenger() {
	super();
	// TODO Auto-generated constructor stub
}
public Passenger(int paasengerId, String passengerName, int age, BankOfIndiaAccount bankAccount) {
	super();
	this.paasengerId = paasengerId;
	this.passengerName = passengerName;
	this.age = age;
	this.bankAccount = bankAccount;
}
public int getPaasengerId() {
	return paasengerId;
}
public void setPaasengerId(int paasengerId) {
	this.paasengerId = paasengerId;
}
public String getPassengerName() {
	return passengerName;
}
public void setPassengerName(String passengerName) {
	this.passengerName = passengerName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public BankOfIndiaAccount getBankAccount() {
	return bankAccount;
}
public void setBankAccount(BankOfIndiaAccount bankAccount) {
	this.bankAccount = bankAccount;
}

}
