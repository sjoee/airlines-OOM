package aerocheck;

public class SpecialNeeds extends Passenger{
    private String assistanceType;
    
    public SpecialNeeds(int BookingID, String FName, String LName, int gender, String email, String contact, String nationality, String dob, String passportNo, String country, String passportExpiry, String issuingCountry, String assistanceType) {
        super(BookingID, FName, LName, gender, email, contact, nationality, dob, passportNo, country, passportExpiry, issuingCountry);
        this.assistanceType = assistanceType;
    }

    public String getAssistanceType(){
        return assistanceType;
    }

    public void updateAssistanceDetails(String assistanceType) {
        this.assistanceType = assistanceType;
    }

    @Override
    public String toString(){
        String gender;
        if (getGender() == 1)
            gender = "Female";
        else
            gender = "Male";
        
        String str = "\n== Special Needs Check-In Information ==" 
                + "\nBooking ID: " + getBookingID()  
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
                + "\nPassport issuing country: " + getIssuingCountry() + "\n"
                + "\n== Special Needs Assistance =="
                + "\nAssistance requested: " + getAssistanceType();
        return str;
    }
}
