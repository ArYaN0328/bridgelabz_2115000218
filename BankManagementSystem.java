
// Superclass: BankAccount
class BankAccount {
    protected String accountNumber;
    protected double balance;
    
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber + ", Balance: $" + balance);
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;
    
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: Savings, Interest Rate: " + interestRate + "%");
    }
}

// Subclass: CheckingAccount
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;
    
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: Checking, Withdrawal Limit: $" + withdrawalLimit);
    }
}

// Subclass: FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    private int depositTerm;
    
    public FixedDepositAccount(String accountNumber, double balance, int depositTerm) {
        super(accountNumber, balance);
        this.depositTerm = depositTerm;
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: Fixed Deposit, Deposit Term: " + depositTerm + " months");
    }
}

// Main class to test the implementation
public class BankManagementSystem {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("SA123", 5000, 2.5);
        BankAccount checking = new CheckingAccount("CA456", 3000, 1000);
        BankAccount fixedDeposit = new FixedDepositAccount("FD789", 10000, 12);
        
        savings.displayDetails();
        System.out.println();
        checking.displayDetails();
        System.out.println();
        fixedDeposit.displayDetails();
    }
}

