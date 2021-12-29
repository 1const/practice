package functions.Tasks.Exercise1;

public class Person {
    private String firstName;
    private String lastName;
    private int passportId;


    public Person() {
        this.firstName = "";
        this.lastName = "";
        this.passportId = 0;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportId = 0;
    }

    public Person(int passportId) {
        this.firstName = "";
        this.lastName = "";
        this.passportId = passportId;
    }

    public Person(String firstName, String lastName, int passportId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportId = passportId;
    }


    public Person(String firstName, String lastName, int passportId, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportId = passportId;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPassportId() {
        return passportId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }


    @Override
    public String toString() {
        return "This Person is " + firstName + " " + lastName;
    }
}
