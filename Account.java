
import java.util.Date;
import bankingsystem.customer.owner;

public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected String accountType;
    protected Date dateCreated;
    protected Customer owner;

    public Account(String accountNumber, String accountType, Customer owner ) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.owner = owner;
        this.dateCreated = new Date();
        this.balance = 0.0;
    }

    public abstract void deposit(double amount);

    public double getBalance() {
        return balance;
    }

    public void getAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
        System.out.println("Date Created: " + dateCreated);
    }
}
