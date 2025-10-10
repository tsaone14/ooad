package bankingsystem.accounts;
import bankingsystem.interfaces.InterestBearing;
import bankingsystem.customers.owner;
import bankingsystem.customers.Company;

public class SavingsAccount extends Account implements InterestBearing {
    private static final double INDIVIDUAL_INTEREST_RATE = 0.025;
    private static final double COMPANY_INTEREST_RATE = 0.075;

    public SavingsAccount(String accountNumber, Customer customer) {
        super(accountNumber, "Savings", customer);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " into Savings Account.");
    }

    @Override
    public void calculateMonthlyInterest() {
        double interest = balance * 0.02;
        balance += interest;
        System.out.println("Monthly interest added: " + interest);
    }
}
