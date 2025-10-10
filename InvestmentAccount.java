public class InvestmentAccount extends Account implements Withdrawal {
    public InvestmentAccount(String accountNumber, Customer owner) {
        super(accountNumber, owner);
        this.customer = owner; // association to Customer
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    @Override
    public String getAccountType() {
        return "Investment Account";
    }
}
