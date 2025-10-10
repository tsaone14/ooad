import java.util.Date;

public class Tester {
    public static void main(String[] args) {
        // Individual customer
        Customer individual = new Individual("C001", "john@example.com", new Date(), "John", "Leatye", "123456789");

        // Company customer
        Customer company = new Company("C002", "info@techsharks.com", new Date(), "Techsharks Ltd.", "REG987654");

        // Create accounts for both customers
        SavingsAccount indivSavings = new SavingsAccount("A001", individual);
        ChequeAccount indivCheque = new ChequeAccount("A002", individual);
        InvestmentAccount indivInvest = new InvestmentAccount("A003", individual);

        SavingsAccount compSavings = new SavingsAccount("B001", company);
        ChequeAccount compCheque = new ChequeAccount("B002", company);
        InvestmentAccount compInvest = new InvestmentAccount("B003", company);

        // Test deposits
        indivSavings.deposit(1000);
        compSavings.deposit(2000);

        // Apply interest
        indivSavings.calculateMonthlyInterest();
        compSavings.calculateMonthlyInterest();

        // Withdraw from both
        indivCheque.deposit(1500);
        indivCheque.withdraw(500);
        compCheque.deposit(2500);
        compCheque.withdraw(1000);

        // Display ownership
        System.out.println("\n=== Customer Associations ===");
        System.out.println("Individual Savings owner: " + indivSavings.getCustomer().getCustomerID());
        System.out.println("Company Savings owner: " + compSavings.getCustomer().getCustomerID());
    }
}
