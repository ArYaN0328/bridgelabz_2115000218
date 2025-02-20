
import java.util.*;
public class BankingSystem {
// HashMap to store account numbers and balances
private Map<Integer, Double> customerAccounts = new HashMap<>();
// TreeMap to sort customers by balance
private TreeMap<Double, Integer> sortedByBalance = new TreeMap<>();
// Queue to handle withdrawal requests
private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();
// Method to add a new account
39
public void addAccount(int accountNumber, double initialBalance) {
customerAccounts.put(accountNumber, initialBalance);
sortedByBalance.put(initialBalance, accountNumber);
}
// Method to deposit money into an account
public void deposit(int accountNumber, double amount) {
if (customerAccounts.containsKey(accountNumber)) {
double currentBalance = customerAccounts.get(accountNumber);
sortedByBalance.remove(currentBalance); // Remove old balance from
TreeMap
double newBalance = currentBalance + amount;
customerAccounts.put(accountNumber, newBalance);
sortedByBalance.put(newBalance, accountNumber); // Add updated
balance to TreeMap
System.out.println("Deposited $" + amount + " into account " +
accountNumber);
} else {
System.out.println("Account not found: " + accountNumber);
}
}
// Method to process withdrawal requests
40
public void processWithdrawals() {
while (!withdrawalQueue.isEmpty()) {
WithdrawalRequest request = withdrawalQueue.poll();
int accountNumber = request.getAccountNumber();
double amount = request.getAmount();
if (customerAccounts.containsKey(accountNumber)) {
double currentBalance = customerAccounts.get(accountNumber);
if (currentBalance >= amount) {
sortedByBalance.remove(currentBalance); // Remove old
balance
double newBalance = currentBalance - amount;
customerAccounts.put(accountNumber, newBalance);
sortedByBalance.put(newBalance, accountNumber); // Update
balance in TreeMap
System.out.println("Withdrawal of $" + amount + " processed
for account " + accountNumber);
} else {
System.out.println("Insufficient balance for account " +
accountNumber);
}
} else {
System.out.println("Account not found: " + accountNumber);
}
41
}
}
// Method to add a withdrawal request to the queue
public void requestWithdrawal(int accountNumber, double amount) {
withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
System.out.println("Withdrawal request of $" + amount + " added for
account " + accountNumber);
}
// Method to display all customers sorted by balance
public void displayCustomersSortedByBalance() {
System.out.println("Customers sorted by balance:");
for (Map.Entry<Double, Integer> entry : sortedByBalance.entrySet()) {
System.out.println("Account Number: " + entry.getValue() + ",
Balance: $" + entry.getKey());
}
}
// Inner class to represent a withdrawal request
private static class WithdrawalRequest {
private final int accountNumber;
42
private final double amount;
public WithdrawalRequest(int accountNumber, double amount) {
this.accountNumber = accountNumber;
this.amount = amount;
}
public int getAccountNumber() {
return accountNumber;
}
public double getAmount() {
return amount;
}
}
// Main method to test the Banking System
public static void main(String[] args) {
BankingSystem bank = new BankingSystem();
// Adding accounts
bank.addAccount(101, 1000.0);
bank.addAccount(102, 1500.0);
43
bank.addAccount(103, 500.0);
// Depositing money
bank.deposit(101, 200.0);
bank.deposit(102, 300.0);
// Requesting withdrawals
bank.requestWithdrawal(101, 500.0);
bank.requestWithdrawal(103, 1000.0); // Should fail due to insufficient
balance
bank.requestWithdrawal(102, 800.0);
// Processing withdrawals
bank.processWithdrawals();
// Displaying customers sorted by balance
bank.displayCustomersSortedByBalance();
}
}

