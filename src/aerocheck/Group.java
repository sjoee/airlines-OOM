package aerocheck;

public class Group extends Passenger{
    private int grpLeadID;
    
    public Group(int BookingID, int grpLeadID, String FName, String LName, int gender, String email, String contact, String nationality, String dob, String passportNo, String country, String passportExpiry, String issuingCountry){
        super(BookingID,FName,LName,gender,email,contact,nationality,dob,passportNo,country,passportExpiry,issuingCountry);
        this.grpLeadID = grpLeadID;
    }
    
    // public Group(){
        
    // }
    
    public int getGrpLeadID() {
        return grpLeadID;
    }

    public void setGrpLeadID(int grpLeadID) {
        this.grpLeadID = grpLeadID;
    }
    
    @Override
    public String toString(){
        String gender;
        if (getGender() == 1)
            gender = "Female";
        else
            gender = "Male";
        
        String str = "\n== Group Check-In Information ==" 
                + "\nBooking ID: " + getBookingID() 
                + "\nGroup Lead ID: " + getGrpLeadID() 
                + "\nFirst Name: " + getFName() 
                + "\nLast Name: " + getLName()
                + "\nGender: " + gender
                + "\nEmail: " + getEmail()
                + "\nContact: " + getContact()
                + "\nNationality: " + getNationality()
                + "\nDate of Birth: " + getDob() + "\n"
                + "\n== Passport Information =="
                + "\nPassport Number: " + getPassportNo()
                + "\nCountry: " + getCountry()
                + "\nPassport Expiry: " + getPassportExpiry()
                + "\nPassport issuing country: " + getIssuingCountry();
        
        return str;
    }
}
