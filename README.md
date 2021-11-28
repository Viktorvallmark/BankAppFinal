# BankAppFinal

*Explanation of the methods*

*Account-class:*

Account-class consists of only getters and setters. Account has two constructors, one where you don't have to initialize a balance and one where you have to. It's so that the customer can immediately transfer money upon the creation of the account or choose to just have it at 0 until future deposits.

*Customer-class:*

* Getters and setters to help update fields in Customer-class.

* public int getAccountIndex(int accountId): Helper function designed to get account with accountId index in the field AccountList. Used throughout the Customer-class.

* public boolean withdrawMoney(long pNr, int accountId, double amount): Accesses an account with accountId belonging to customer pNr and check if amount can be withdrawn from account without overcharging. Uses getBalance() and setBalance() from the Account-class.

* public boolean depositMoney(int accountId, int amount): Accesses an account with accountId and increases the Accounts field Balance with amount. If wrong accountId is written, returns a String that says to the user that the deposit failed.

* public int addAcc(long pNr): This function adds an account to customer pNr and returns the accountId. If it fails it returns -1. This function is used by addAccount in Bank-class to update the field AccountList in customer.

* public String closeAccount(long pNr, int accountId): Closes an account with accountId belonging to pNr. Uses the help function getAccountIndex. Removes the account from field AccountList if pNr is identical to the field PNr and accountId is identical to field AccountID in Account-class.

* public String getAccount(long pNr, int accountId): Produces information about the account accountId beloning to pNr. Returns the information in form of a string.

*Bank-class:*

* public List<String> GetCustomers(): Produces a List<String> with information about all customers belonging to the bank.
  
* public int getCustomerIndex(long pNr): Works similar to getAccountIndex that belongs to the Customer-class. It produces the index that a particular customer occupies in the field CustomerList in Bank.

* public boolean AddCustomer(long pNr, String name): Adds a customer to the bank by updating the field CustomerList in Bank. Checks if CustomerList is empty and if it is, it adds a new Customer with pNr and name. If CustomerList isn't empty, it checks if parameter pNr equals to a pNr already existing in CustomerList. If it does, the function returns false. If pNr doesn't belong to a customer in CustomerList, then it creates a new customer with pNr and name.
  
* public List<String> GetCustomer(long pNr): Produces detailed information about a single customer. Picks the customer with pNr and produces a List<String> with information about name, personal number and total accounts. If parameter pNr doesn't correspong to a customer in the bank's CustomerList, then it returns that the customer doesn't belong to the bank.
  
* public boolean ChangeCustomerName(String name, long pNr): Changes the name of a customer with pNr to name. Uses a setter in setFullName() in Customer-class to update the field.

* public List<String> RemoveCustomer(long pNr): Removes customer with pNr from the bank. Returns information about name, personal number, total accounts the customer had. If any of these accounts had any money in them, it returns it to the customer.
  
* public int addAccount(long pNr): Adds an account to customer pNr. Uses addAcc from Customer-class to update the field AccountList in Customer.
  
public void writeCustomersToTxt(): Writes list of customers in the bank to a .txt-file with name "customerinfo.txt" when called.
  
*Main*
  
 Creates a bank, adds some customers to it, adds an account to the customer with index 0 in bank. Removes the customer from the bank and prints out info about the customer whom was removed. Used this to test if everything worked and finally it actually did!
