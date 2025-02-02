// Parent class: BankAccount
class BankAccount {
    // Public member
    public String accountNumber;

    // Protected member
    protected String accountHolder;

    // Private member
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Public method to get the balance
    public double getBalance() {
        return balance;
    }

    // Public method to modify the balance
    public void setBalance(double balance) {
        if(balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative.");
        }
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate; // Additional property for SavingsAccount

    // Constructor
    public SavingsAccount(String accountNumber, String accountHolder, double initialBalance, double interestRate) {
        super(accountNumber, accountHolder, initialBalance); // Call the parent class constructor
        this.interestRate = interestRate;
    }

    // Method to display savings account details
    public void displaySavingsAccountDetails() {
        displayAccountDetails(); // Call the parent class method to display account details
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    // Method to calculate and apply interest to the balance
    public void applyInterest() {
        double interestAmount = balance * (interestRate / 100);
        balance += interestAmount;
        System.out.println("Interest of $" + interestAmount + " has been applied.");
    }

    // Method to get the interest rate
    public double getInterestRate() {
        return interestRate;
    }
}

// Main class to test the functionality
public class BankAccountManagement {
    public static void main(String[] args) {
        // Create a BankAccount object
        BankAccount account1 = new BankAccount("12345", "Alice", 5000.00);
        
        // Display account details
        account1.displayAccountDetails();
        
        // Modify balance using setter method
        account1.setBalance(5500.00);
        System.out.println("\nUpdated Balance: $" + account1.getBalance());

        // Create a SavingsAccount object
        SavingsAccount savingsAccount1 = new SavingsAccount("67890", "Bob", 10000.00, 5.0);
        
        // Display savings account details
        savingsAccount1.displaySavingsAccountDetails();
        
        // Apply interest to the savings account
        savingsAccount1.applyInterest();
        
        // Display updated savings account details
        savingsAccount1.displaySavingsAccountDetails();
    }
}
