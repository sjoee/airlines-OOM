package aerocheck;

public class Passenger {
    private int BookingID, gender;
    private String FName, LName, email, contact, nationality, dob, passportNo,country,passportExpiry,issuingCountry;
    
    public Passenger(int BookingID, String FName, String LName, int gender, String email, String contact, String nationality, String dob, String passportNo, String country, String passportExpiry, String issuingCountry){
        this.BookingID = BookingID;
        this.gender = gender;
        this.FName = FName;
        this.LName = LName;
        this.email = email;
        this.contact = contact;
        this.nationality = nationality;
        this.dob = dob;
        this.passportNo = passportNo;
        this.country = country;
        this.passportExpiry = passportExpiry;
        this.issuingCountry = issuingCountry;
    }
    
    public Passenger(int bookingId2, String fName2, String lName2, int gender2, String email2, String contact2, String nationality2, String dob2, String passportNo2, String country2, String passportExpiry2, String issuingCountry2, String assistanceType){
        
    }
    
    public int getBookingID() {
        return BookingID;
    }

    public void setBookingID(int BookingID) {
        this.BookingID = BookingID;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
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
}
