import java.util.Date;

public class Individual extends Customer {
    private String firstName;
    private String lastName;
    private String idNumber;

    public Individual(String customerID, String email, Date dateRegistered, String firstName, String lastName, String idNumber) {
        super(customerID, email, dateRegistered);
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public void getCustomerDetails() {
        System.out.println("Customer ID: " + customerID);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Registered: " + dateRegistered);
        System.out.println("ID Number: " + idNumber);
    }
}
