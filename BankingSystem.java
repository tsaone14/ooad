package bankingsystem;
import java.util.Date;
import bankingsystem.customers.*;
import bankingsystem.accounts.*;

public class BankingSystem {
    public static void main(String[] args) {
        Individual cathy = new Individual("cathy@email.com", new Date(), "Cathy", "Makoba", "BW12345");
        SavingsAccount sa = new SavingsAccount("S001", cathy);

        cathy.addAccount(sa);
        sa.deposit(2000);
        sa.calculateMonthlyInterest();
        sa.getAccountDetails();
        cathy.getCustomerDetails();
    }
}
