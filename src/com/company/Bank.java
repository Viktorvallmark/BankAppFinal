package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {

    //State
    public List<Customer> CustomerList;
    private String BankName;

    //Constructor
    public Bank(String bankName){
        BankName = bankName;
        List<Customer> customerList = new ArrayList<>();
    }
    public Bank(){

    }

    //Behaviour

    public List<String> GetCustomers(){
        List<String> tempList = new ArrayList<>();
        for(var customer : CustomerList){
            tempList.add(String.valueOf(customer));
        }
        return tempList;

    }

    public int getCustomerIndex(long pNr){
        int custIndex = -1;
        for(var customer : CustomerList){
            if(customer.getPNr() == pNr){
                custIndex = CustomerList.indexOf(customer);
            }
        }
    return custIndex;
    }

    public boolean AddCustomer(long pNr, String name){
        for(Customer i : CustomerList){
            if(i.getPNr() != pNr){
                CustomerList.add(new Customer(pNr, name));
                return true;
            }
        }
        return false;
    }

    public List<String> GetCustomer(long pNr){
        List<String> tempList = new ArrayList<>();
        var isTrue = getCustomerIndex(pNr);
        if(isTrue != -1){
            var customer = CustomerList.get(isTrue);
            tempList.add("Customer name:" + customer.getFullName());
            tempList.add("Customer's personal number:"+ String.valueOf(customer.getPNr()));
            tempList.add("Total accounts:" + String.valueOf(customer.getAccountList().size()));
        }else{
            tempList.add("Customer not found!");
        }
        return tempList;
    }

    public boolean ChangeCustomerName(String name, long pNr){
        var custIndex = getCustomerIndex(pNr);
        if(custIndex != -1){
            var customer = CustomerList.get(custIndex);
            var custName = customer.getFullName();
            var custpNr = customer.getPNr();
            var custAccList = customer.getAccountList();
            custName = name;
            Customer customernew = new Customer(custpNr, name);
            return true;
        }else{
            return false;
        }
    }

    public List<Customer> getCustomerList(){
        return CustomerList;
    }

    public List<String> RemoveCustomer(long pNr){
        List<String> temp = new ArrayList<>();
        var isTrue = getCustomerIndex(pNr);
        if(isTrue != -1){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter AccountID:");
            var accID = sc.nextInt();
            var customer = CustomerList.get(isTrue);
            var accIndex = customer.getAccountIndex(accID);
            var accList = customer.getAccountList();
            var acc = accList.get(accIndex);
            var accBalance = acc.getBalance();
            temp.add("Customer name:" + customer.getFullName());
            temp.add("Customer's personal number:"+ String.valueOf(customer.getPNr()));
            temp.add("Total accounts:" + String.valueOf(customer.getAccountList().size()));
            temp.add("Total balance returned to" + pNr + ":" + String.valueOf(accBalance));
            CustomerList.remove(customer);

        }
        return temp;
    }

    public int addAccount(long pNr, int accountId){
        for(Customer i : CustomerList){
            var k = i.getAccountList();
            if(i.getPNr() == pNr){
                Account account = new Account(pNr, accountId);
                k.add(account);
                return accountId;
            }
            }
            return -1;
    }

    public void writeCustomersToTxt(){
        try {
            FileWriter myWriter = new FileWriter("customerinfo.txt");
            myWriter.write(String.valueOf(CustomerList));
            myWriter.close();
            System.out.println("Successfully wrote to file");
        } catch (IOException e) {
            System.out.println("Error occured while writing to file.");
            e.printStackTrace();
        }
    }
}
