package com.company;



public class Account {

    //State
    private long PNr;
    private int AccountID;
    private double Balance;

    //Constructor
    public Account(long pNr, int accountId){
        PNr = pNr;
        AccountID = accountId;
    }
    public Account(long pNr, int accountId, double balance){
        PNr = pNr;
        AccountID = accountId;
        Balance = balance;
    }


    //Behaviour

    public double getBalance() {
        return Balance;
    }

    public int getAccountID() {
        return AccountID;
    }

    public long getPNr() {
        return PNr;
    }
}
