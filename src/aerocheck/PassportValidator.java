package aerocheck;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PassportValidator {
    public boolean validatePassportNumber(String passportNumber) {
        if (passportNumber == null || passportNumber.trim().isEmpty()) {
            System.out.println("Passport number is required.");
            return false;
        }
        return true;
    }

    public boolean validateCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            System.out.println("Country is required.");
            return false;
        }
        return true;
    }

    public boolean validateExpiryDate(String expiryDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date expiryDateObj = dateFormat.parse(expiryDate);
            Date currentDate = new Date(); // Get current date
            if (expiryDateObj.before(currentDate)) {
                System.out.println("Passport has expired!");
                return false;
            }
        } catch (ParseException e) {
            System.out.println("Invalid date. Follow the format dd/mm/yyyy.");
            return false;
        }
        return true;
    }

    public boolean validateIssuingCountry(String issuingCountry) {
        if (issuingCountry == null || issuingCountry.trim().isEmpty()) {
            System.out.println("Issuing country is required.");
            return false;
        }
        return true;
    }
}
