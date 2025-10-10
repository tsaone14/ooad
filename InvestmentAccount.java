package bankingsystem.accounts;
import bankingsystem.interfaces.InterestBearing;
import bankingsystem.interfaces.Withdraw;
import bankingsystem.customer.owner;

public class InvestmentAccount extends Account implements InterestBearing, Withdraw {
    private static final double MONTHLY_INTEREST_RATE = 0.05;
    private static final double MIN_DEPOSIT = 500.00;

    public InvestmentAccount(String accountNumber, Customer customer) {
        super(accountNumber, "Investment", customer);
    }

    @Override
    public void deposit(double amount) {
        if (amount >= MIN_DEPOSIT) {
            balance += amount;
            System.out.println("Deposited " + amount + " into Investment Account.");
        } else {
            System.out.println("Minimum deposit is " + MIN_DEPOSIT);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Investment Account.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public void calculateMonthlyInterest() {
        double interest = balance * MONTHLY_INTEREST_RATE;
        balance += interest;
        System.out.println("Investment Account interest added: " + interest);
    }
}
