package id.kawahedukasi.tugas5;

/*
3. Lakukan inheritance class User pada class Account yang dimana class Account memiliki attribute tambahan:
- fullName
- email
- phoneNumber
- dob
- pob
*/
public class Account extends User {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String dob;
    private String pob;
    private Address address;    //8. Buatlah composition class Address pada class Account


    // 6. Implementasikan constructor empty attribute  dan full atribute untuk class Account
    public Account() {
        super("Default", "default");
    }

    public Account(String username, String password, String fullName, String email, String phoneNumber, String dob, String pob, Address address) {
        super(username, password);
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.pob = pob;
        this.address = address;
    }

    // 5. Implementasikan getter and setter pada attribute Account
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
