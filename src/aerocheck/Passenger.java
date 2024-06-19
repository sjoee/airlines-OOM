package aerocheck;

*// initialization*//
public class Passenger {
    private int BookingID;
    private Gneder gender;
    private String firstName, lastName, email, contact, nationality, dateOfBirth, passportNo,country,passportExpiry,issuingCountry;
    
    public enum Gender{
    MALE , FEMALE
    }

    
    public Passenger(int bookingID, String firstName, String lastName, int gender, String email, String contact, String nationality, String dateOfBirth, String passportNumber, String country, String passportExpiry, String issuingCountry){
        this.bookingID = bookingID;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contact = contact;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.passportNo = passportNumber;
        this.country = country;
        this.passportExpiry = passportExpiry;
        this.issuingCountry = issuingCountry;
    }
    
*// getter and setter method*//  
  
    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public void setLName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDateofBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateofBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassportExpiry() {
        return passportExpiry;
    }

    public void setPassportExpiry(String passportExpiry) {
        this.passportExpiry = passportExpiry;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }

    public void setIssuingCountry(String issuingCountry) {
        this.issuingCountry = issuingCountry;
    }
  
  
    @Override
    public String toString(){
        return = "\n== Passenger Check-In Information ==" 
                + "\nBooking ID: " + BookingID +
                 "\nFirst Name: " + firstName +
                 "\nLast Name: " + lastName +
                 "\nGender: " + (gender == Gender.FEMALE? "Female" : "Male") +
                 "\nEmail: " + email +
                 "\nContact: " + contact +
                 "\nNationality: " + nationality +
                 "\nDate of Birth: " + dateOfBirth +
                 "\n\n== Passport Information Display Here ==" +
                 "\nPassport Number: " + passportNumber +
                 "\nCountry: " + country +
                 "\nPassport Expiry: " + passportExpiry +
                 "\nPassport issuing country: " + issuingCountry;
    }
}
