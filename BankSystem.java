import java.util.ArrayList;

// Bank class (Has Customers associated with it)
class Bank {
    private String name;
    private ArrayList<Customer> customers;

    // Constructor
    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    // Method to add a customer to the bank
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer " + customer.getName() + " added to " + name);
    }

    // Open a new account for a customer
    public void openAccount(Customer customer, double initialBalance) {
        Account newAccount = new Account(this, initialBalance);
        customer.addAccount(newAccount);
        System.out.println("New account opened for " + customer.getName() + " at " + name);
    }

    // Display all customers
    public void displayCustomers() {
        System.out.println("\nCustomers at " + name + ":");
        for (Customer customer : customers) {
            customer.displayAccounts();
        }
    }
}

// Customer class (Can have multiple accounts in a Bank)
class Customer {
    private String name;
    private ArrayList<Account> accounts;

    // Constructor
    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    // Get customer name
    public String getName() {
        return name;
    }

    // Add an account
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // View all accounts and balances
    public void displayAccounts() {
        System.out.println("\nCustomer: " + name);
        for (Account account : accounts) {
            System.out.println("Account in " + account.getBank().getName() + " - Balance: $" + account.getBalance());
        }
    }
}

// Account class (Linked to a Bank)
class Account {
    private Bank bank;
    private double balance;

    // Constructor
    public Account(Bank bank, double balance) {
        this.bank = bank;
        this.balance = balance;
    }

    // Get bank associated with the account
    public Bank getBank() {
        return bank;
    }

    // Get balance
    public double getBalance() {
        return balance;
    }
}

// Main class to demonstrate Association
public class BankSystem {
    public static void main(String[] args) {
        // Creating a Bank
        Bank bank1 = new Bank("National Bank");
        Bank bank2 = new Bank("City Bank");

        // Creating Customers
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        // Associating Customers with Banks
        bank1.addCustomer(customer1);
        bank1.addCustomer(customer2);
        bank2.addCustomer(customer2);

        // Opening accounts for customers
        bank1.openAccount(customer1, 5000);
        bank1.openAccount(customer2, 3000);
        bank2.openAccount(customer2, 10000);

        // Display all bank customers and their accounts
        bank1.displayCustomers();
        bank2.displayCustomers();
    }
}