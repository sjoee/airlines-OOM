package aerocheck;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.InputMismatchException;

public class UserInputHandler {
    private Scanner scanner;
    
    public UserInputHandler() {
        this.scanner = new Scanner(System.in);
    }
    
    // Not applicable to group check ins
    public int getBookingID(){
        boolean validInt = false; // reset value
        int bookingID = 0;
        while(!validInt){ // validate integer value
            System.out.print("Booking ID: ");
            try{
                if (scanner.hasNextInt()){
                    bookingID = scanner.nextInt();
                    validInt = true;
                    scanner.nextLine(); // Consume the newline character left by nextInt()
                }else{
                    System.out.println("Invalid input, please enter numericals.");
                    validInt = false;
                    scanner.nextLine(); // Consume invalid input
                }
            }catch(InputMismatchException ex){
                System.out.println("Invalid input, please enter numericals.");
                validInt = false;
                scanner.nextLine(); // Consume invalid input
            }
        }
        return bookingID;
    }
    
    public String getFName() {
        String FName;
        while (true) {
            System.out.print("First Name: ");
            FName = scanner.nextLine();
            if (!FName.trim().isEmpty()) {
                break;
            } else {
                System.out.println("First Name cannot be empty. Please try again.");
            }
        }
        return FName;
    }
    public String getLName() {
        String LName;
        while (true) {
            System.out.print("Last Name: ");
            LName = scanner.nextLine();
            if (!LName.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Last Name cannot be empty. Please try again.");
            }
        }
        return LName;
    }
    public String getEmail() {
        String email;
        while (true) {
            System.out.print("Email: ");
            email = scanner.nextLine();
            if (!email.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Email cannot be empty. Please try again.");
            }
        }
        return email;
    }
    public String getContact() {
        String contact;
        while (true) {
            System.out.print("Telephone Number: ");
            contact = scanner.nextLine();
            if (!contact.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Telephone Number cannot be empty. Please try again.");
            }
        }
        return contact;
    }
    public String getNationality() {
        String nationality;
        while (true) {
            System.out.print("Nationality: ");
            nationality = scanner.nextLine();
            if (!nationality.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Nationality cannot be empty. Please try again.");
            }
        }
        return nationality;
    }
    public int getGender(){
        boolean validInt = false;
        int gender = 0;
        while(!validInt){
            System.out.println("\n== Personal Details ==");
            System.out.println("Gender: ");
            System.out.println("1. Female");
            System.out.println("2. Male");
            System.out.print("Pick: ");
            try{
                if (scanner.hasNextInt()){
                    gender = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character left by nextInt()
                    switch (gender){
                        case 1:
                            validInt = true;
                            break;
                        case 2:
                            validInt = true;
                            break;
                        default:
                            System.out.println("Invalid input, enter 1 or 2.");
                            validInt = false;
                            break;
                    }
                }else{
                    System.out.println("Invalid input, please enter 1 or 2.");
                    validInt = false;
                    scanner.nextLine(); // Consume invalid input
                }
            }catch(InputMismatchException ex){
                System.out.println("Invalid input, please enter 1 or 2.");
                validInt = false;
                scanner.nextLine(); // Consume invalid input
            }
        }
        return gender;
    }
    public String getDob(){
        boolean valid = false;
        String dob = null;
        // Validate date format
        while(!valid){
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            try{
                System.out.println("Date of Birth (dd/mm/yyyy): ");
                dob = scanner.nextLine();
                dateFormat.parse(dob);
                valid = true;
            }
            catch(ParseException e){
                System.out.println("Invalid date format! Follow the format (dd/mm/yyyy).");
            }
        }
        return dob;
    }
}
