package com.company;


public class Main {

    public static void main(String[] args) {
	MockData.LoadCustomersAndAccounts();

    var Customers = MockData.Customers;


    Bank b1 = new Bank("Wallenbergs grovslakt och bank");
    var c1 = new Customer(19880622L, "Pelle Plutt");
    var c2 = new Customer(19851212L, "Anna Panna");
    var c3 = new Customer(20000101L, "Peepo Poopo");
    c1.addAccount(c1.getPNr());
    c2.addAccount(c2.getPNr());
    c3.addAccount(c3.getPNr());
    b1.AddCustomer(c1.getPNr(),c1.getFullName());
    b1.AddCustomer(c2.getPNr(), c2.getFullName());
    b1.AddCustomer(c3.getPNr(), c3.getFullName());

    var customerInfo = b1.GetCustomer(19880622L);

    System.out.println(customerInfo);


    }
}







