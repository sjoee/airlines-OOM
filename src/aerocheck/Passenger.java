package pcheckin;

import java.time.LocalDate;

public class PcheckIn {
    public static void main(String[] args) {
        CustomerInfo p1 = new CustomerInfo("P005", "Taylor Swift", "Cornelia Street", "Taylor1988@gmail.com", "123456", "A019988", LocalDate.of(2026, 5, 15), "USA");
        CustomerInfo p2 = new CustomerInfo("P018", "Lana Del Rey", "Mariner Complex Apartment", "LanaDRey@gmail.com", "010203", "A11232", LocalDate.of(2025, 8, 20), "USA");

        BaggageInfo baggage1 = new BaggageInfo("B001", 18.50, p1.getCustomerID());
        BaggageInfo baggage2 = new BaggageInfo("B002", 17.50, p2.getCustomerID());

        p1.selfCheckIn("38B", baggage1);
        p2.groundHandlingCheckIn("18C", baggage2);
    }
}

