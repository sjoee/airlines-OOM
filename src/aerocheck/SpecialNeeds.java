package aerocheck;

public class SpecialNeeds extends Passenger{
    private String assistanceType;
    
    public SpecialNeeds(int bookingId, String fName, String lName, int gender, String contact, String nationality, String dob, String passportNo, String country, String passportExpiry, String issuingCountry, String assistanceType) {
        super(bookingId, fName, lName, gender, contact, nationality, dob, passportNo, country, passportExpiry, issuingCountry, assistanceType);
        this.assistanceType = assistanceType;
    }

    public String getAssistanceType(){
        return assistanceType;
    }

    public void requestAssistance() {
        // Logic to request special assistance
        System.out.println(getFName() + " " + getLName() + " has requested assistance: " + assistanceType);
    }

    public void updateAssistanceDetails(String assistanceType) {
        this.assistanceType = assistanceType;
    }

    @Override
    public String toString(){
        return super.toString() + "\nAssistance Type: " + assistanceType;
    }
}
