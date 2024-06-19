package aerocheck;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AeroCheck {
    static int bookingID, grpLeadBookingID, gender;
    static String FName, LName, grpLeadEmail, grpLeadContact, nationality, dob, passportNo, country, passportExpiry, issuingCountry, assistanceType, email, fName, lName, contact;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        boolean validInteger = false;
        while (!valid || validInteger) {
            while (!valid || validInteger){
                validInteger = false; // reset value to false to prevent looping
                // Display check-in method
                System.out.println("== Check-in Method ==");
                System.out.println("1. Counter");
                System.out.println("2. Kiosk");
                System.out.println("3. Exit");
                System.out.print("Pick: ");

                if(scanner.hasNextInt()) {
                    int checkInMethod = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character left by nextInt()

                    switch (checkInMethod) {
                        case 1:
                            valid = true;
                            handleCheckIn(scanner, "Counter");
                            break;
                        case 2:
                            valid = true;
                            handleCheckIn(scanner, "Kiosk");
                            break;
                        case 3:
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice. Pick 1 or 2.");
                            valid = false;
                            break;
                    }
                } else {
                    System.out.println("Invalid choice. Pick 1 or 2.");
                    valid = false;
                    scanner.nextLine(); // Consume invalid input
                }
            }
            while(!validInteger){
                System.out.println("\nDo you want to continue checking in?\n1. Yes\n2. No");
                System.out.print("Pick: ");
                try{
                    if (scanner.hasNextInt()){
                        int answer = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character left by nextInt()
                        switch (answer) {
                            case 1:
                                validInteger = true;
                                break;
                            case 2:
                                System.exit(0);
                            default:
                                System.out.println("Invalid number, input 1 or 2.");
                                validInteger = false;
                                break;
                        }
                    }else{
                        System.out.println("Invalid number, input 1 or 2.");
                        validInteger = false;
                        scanner.nextLine(); // Consume invalid input
                    }
                }catch(InputMismatchException ex){
                    System.out.println("Invalid number, input 1 or 2.");
                    validInteger = false;
                    scanner.nextLine(); // Consume invalid input
                }
            }
        }
    }
    
    private static void handleCheckIn(Scanner scanner, String method) {
        boolean valid = false;
        ArrayList<Group> members = new ArrayList<>();
        
        while (!valid) {
            System.out.println("== Check-in ==");
            System.out.println("1. Passenger Check-in");
            System.out.println("2. Group Check-in");
            System.out.println("3. Special Needs Assistance");
            System.out.println("4. Baggage Handling");
            System.out.println("5. Exit");
            System.out.print("Pick: ");
            
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character left by nextInt()
                valid = true;
                
                switch (choice) {
                    case 1:
                        System.out.println("Passenger Check-in not implemented yet.");
                        break;
                    case 2:
                        gatherGrpLeadInfo(scanner);
                        Group group = gatherPassportInfo(scanner);
                        members.add(group);
                        boardingPass("Group Lead");
                        
                        gatherGrpMemberInfo(scanner, members);
                        // Display all group info
                        for(Group member:members){
                            System.out.println(member);
                        }
                        if (method == "Counter"){
                            System.out.println("\n=============================================");
                            System.out.println("Group has successfully checked in via Counter");
                            System.out.println("=============================================");
                        } else if (method == "Kiosk"){
                            System.out.println("\n=============================================");
                            System.out.println("Group has successfully checked in via Kiosk");
                            System.out.println("=============================================");
                        }
                        break;
                    case 3:
                        //EDIT HEREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
                        gatherSNeedsInfo(scanner);

                        SpecialNeeds specialNeeds = SpecialgatherPassportInfo(scanner);
                        System.out.println(specialNeeds);
                        
                        if (method == "Counter"){
                            System.out.println("\n=============================================");
                            System.out.println("Passenger has successfully checked in via Counter");
                            System.out.println("=============================================");
                        } else if (method == "Kiosk"){
                            System.out.println("\n=============================================");
                            System.out.println("Passenger has successfully checked in via Kiosk");
                            System.out.println("=============================================");
                        }
                        break;
                    case 4:
                        baggageHandling(scanner,method);
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice.");
                        valid = false;
                        break;
                }
            } else {
                System.out.println("Incorrect input. Please enter a number!");
                scanner.nextLine(); // Consume invalid input
                valid = false;
            }
        }
    }

    //PASSENGER CHECK-IN [CASE 1]
// initialization//

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
    
// getter and setter method//  
  
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

    //GROUP LEADER CHECK-IN HERE [CASE 2]
    private static void gatherGrpLeadInfo(Scanner scanner){
        UserInputHandler handle = new UserInputHandler();
        boolean validInt, confirm = false; // Confirm info or edit info
        int answer;
        // Display questionaires for grp representative
        while(!confirm){
            System.out.println("\n== Enter Group Representative Information ==");
            validInt = false; // reset value
            while(!validInt){ // validate integer value
                System.out.print("Booking ID: ");
                try{
                    if (scanner.hasNextInt()){
                        grpLeadBookingID = scanner.nextInt();
                        bookingID = grpLeadBookingID;
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
            FName = handle.getFName();
            LName = handle.getLName();
            grpLeadEmail = handle.getEmail();
            grpLeadContact = handle.getContact();

            // Display entered information
            System.out.println("\n== Group Representative Information ==");
            System.out.println("Booking ID: " + grpLeadBookingID);
            System.out.println("First Name: " + FName);
            System.out.println("Last Name: " + LName);
            System.out.println("Email: " + grpLeadEmail);
            System.out.println("Telephone Number: " + grpLeadContact);

            validInt = false; // reset value
            while(!validInt){
                System.out.println("\nIs the above infomation correct or do you want to make changes?");
                System.out.println("1. Confirm");
                System.out.println("2. Edit");
                System.out.print("Pick: ");
                try{
                    if (scanner.hasNextInt()){
                        answer = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character left by nextInt()

                        switch(answer){
                            case 1:
                                confirm = true;
                                validInt = true;
                                break;
                            case 2:
                                confirm = false;
                                validInt = true;
                                break;
                            default:
                                System.out.println("Invalid input, please enter 1 or 2.");
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
        }
        
        // Display questionaires for personal information
        confirm = false;
        while(!confirm){
            System.out.println("\n== Required Information ==");
            nationality = handle.getNationality();
            gender = handle.getGender();
            dob = handle.getDob();

            System.out.println("\n== Personal Details ==");
            System.out.println("Nationality: " + nationality);
            System.out.print("Gender: ");
            if (gender == 1){
                System.out.print("Female");
            } else {
                System.out.print("Male");
            }
            System.out.println("\nDate of Birth (dd/mm/yyyy): " + dob);

            validInt = false; // reset value
            while(!validInt){
                System.out.println("\nIs the above infomation correct or do you want to make changes?");
                System.out.println("1. Confirm");
                System.out.println("2. Edit");
                System.out.print("Pick: ");
                try{
                    if (scanner.hasNextInt()){
                        answer = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character left by nextInt()

                        switch(answer){
                            case 1:
                                confirm = true;
                                validInt = true;
                                break;
                            case 2:
                                confirm = false;
                                validInt = true;
                                break;
                            default:
                                System.out.println("Invalid input, please enter 1 or 2.");
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
        }
    } //GROUP LEADER CHECK-IN ENDS
    
    // GENERATR BOARDING PASS
    private static void boardingPass(String role){
        Scanner scanner = new Scanner(System.in);
        UserInputHandler handle = new UserInputHandler();
        String seatNo;
        int flightNo;
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String today = date.format(formatter);
        
        LocalTime time = LocalTime.now();
        DateTimeFormatter timeF = DateTimeFormatter.ofPattern("hh:mm a");
        String formattedTime = time.format(timeF);
        
        if (role == "Group Lead" || role == "Group Member"){
            System.out.println("== Enter Seat Information ==");
            seatNo = handle.getSeatNo();
            flightNo = handle.getFlightNo();

            System.out.println("\n====================");
            System.out.println("== BOARDING PASS ==");
            System.out.println("====================");
            System.out.println("Booking ID: " + bookingID);
            System.out.println("\nFLIGHT INFORMATION");
            System.out.println("Flight Number: " + flightNo);
            System.out.println("---------------------");
            System.out.println("Seat Number: " + seatNo);
            System.out.println("Date: " + today);
            System.out.println("Time: " + formattedTime);
            System.out.println("---------------------");
            System.out.println("PASSENGER INFORMATION");
            System.out.println("Passenger Name: " + FName + " " + LName);
            System.out.print("Gender: ");
            if (gender == 1)
                System.out.print("F");
            else
                System.out.print("M");
            System.out.println("\nPhone Number: " + grpLeadContact);
            System.out.println("Email: " + grpLeadEmail);
            System.out.println("====================");
        }
        else if (role == "Passenger"){
            System.out.println("== Enter Seat Information ==");
            seatNo = handle.getSeatNo();
            flightNo = handle.getFlightNo();

            System.out.println("\n====================");
            System.out.println("== BOARDING PASS ==");
            System.out.println("====================");
            System.out.println("Booking ID: " + bookingID);
            System.out.println("\nFLIGHT INFORMATION");
            System.out.println("Flight Number: " + flightNo);
            System.out.println("---------------------");
            System.out.println("Seat Number: " + seatNo);
            System.out.println("Date: " + today);
            System.out.println("Time: " + formattedTime);
            System.out.println("---------------------");
            System.out.println("PASSENGER INFORMATION");
            System.out.println("Passenger Name: " + FName + " " + LName);
            System.out.println("Gender: ");
            if (gender == 1)
                System.out.print("F");
            else
                System.out.print("M");
            System.out.println("\nPhone Number: " + contact);
            System.out.println("Email: " + email);
            System.out.println("====================");
        }
        
        boolean validInt = false;
        while(!validInt){
            System.out.println("\nDo you want to print boarding pass or access via mobile device?");
            System.out.println("1. Print");
            System.out.println("2. Mobile Device");
            System.out.print("Pick: ");
            try{
                if (scanner.hasNextInt()){
                    int answer = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character left by nextInt()

                    switch(answer){
                        case 1:
                            System.out.print("\nPrinting");
                            for (int i = 0;i < 20;i++) {
                                 try {
                                    System.out.print(".");
                                     TimeUnit.SECONDS.sleep(1);
                                 }catch (InterruptedException e) {
                                   e.printStackTrace();
                                 } if (i == 3) {
                                     System.out.println("\nPrinting completed!");
                                     break;
                                 }
                            }
                            validInt = true;
                            break;
                        case 2:
                            System.out.println("\nBoarding pass sent to email!");
                            validInt = true;
                            break;
                        default:
                            System.out.println("Invalid input, please enter 1 or 2.");
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
    }
    
    //GROUP PASSPORT [UNDER CASE 2]
    private static Group gatherPassportInfo(Scanner scanner){
        boolean validInt, confirm; // Confirm info or edit info
        int answer;
        PassportValidator passportValidator = new PassportValidator();
        // Display questionaires for passport information
        confirm = false;
        while(!confirm){
            System.out.println("\n== Passport Information ==");
            System.out.print("Passport number: ");
            passportNo = scanner.nextLine();
            while (!passportValidator.validatePassportNumber(passportNo)) {
                System.out.print("Passport number: ");
                passportNo = scanner.nextLine();
            }
            
            System.out.print("Country: ");
            country = scanner.nextLine();
            while (!passportValidator.validateCountry(country)) {
                System.out.print("Country: ");
                country = scanner.nextLine();
            }

            System.out.print("Passport expiry date (dd/mm/yyyy): ");
            passportExpiry = scanner.nextLine();
            while (!passportValidator.validateExpiryDate(passportExpiry)) {
                System.out.print("Passport expiry date (dd/mm/yyyy): ");
                passportExpiry = scanner.nextLine();
            }
            
            System.out.print("Passport issuing country: ");
            issuingCountry = scanner.nextLine();
            while (!passportValidator.validateIssuingCountry(issuingCountry)) {
                System.out.print("Passport issuing country: ");
                issuingCountry = scanner.nextLine();
            }

            System.out.println("\n== Passport Information ==");
            System.out.println("Passport number: " + passportNo);
            System.out.println("Country: " + country);
            System.out.println("Passport expiry date (dd/mm/yyyy): " + passportExpiry);
            System.out.println("Passport issuing country: " + issuingCountry);

            validInt = false; // reset value
            while(!validInt){
                System.out.println("\nIs the above infomation correct or do you want to make changes?");
                System.out.println("1. Confirm");
                System.out.println("2. Edit");
                System.out.print("Pick: ");
                try{
                    if (scanner.hasNextInt()){
                        answer = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character left by nextInt()

                        switch(answer){
                            case 1:
                                confirm = true;
                                validInt = true;
                                break;
                            case 2:
                                confirm = false;
                                validInt = true;
                                break;
                            default:
                                System.out.println("Invalid input, please enter 1 or 2.");
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
        }
            return new Group(bookingID, grpLeadBookingID, FName, LName, gender, grpLeadEmail, grpLeadContact, nationality, dob, passportNo, country, passportExpiry, issuingCountry);
    }

    //GROUP MEMBER INFO [UNDER CASE 2]
    private static void gatherGrpMemberInfo(Scanner scanner, ArrayList<Group> members){
        UserInputHandler handle = new UserInputHandler();
        // Fill in info for group members 
        boolean validInt = false; // reset value to prevent looping
        while(!validInt){
            System.out.print("\nAmount of travellers checking in (excluding group representative): ");
            try{
                if (scanner.hasNextInt()){
                    int ticketQty = scanner.nextInt();
                    validInt = true;
                    scanner.nextLine(); // Consume the newline character left by nextInt()

                    if (ticketQty == 0){
                        System.out.println("Invalid input. Enter quantity more than or equals to 1.");
                        validInt = false;
                    }
                    
                    // Display questionaires for passenger info
                    for (int i=0;i<ticketQty;i++){
                        boolean confirm = false;
                        while(!confirm){
                            System.out.println("\n== Enter Passenger Information ==");
                            validInt = false; // reset value
                            while(!validInt){ // validate integer value
                                System.out.print("Booking ID: ");
                                try{
                                    if (scanner.hasNextInt()){
                                        bookingID = scanner.nextInt();
                                        validInt = true;
                                        scanner.nextLine(); // Consume the newline character left by nextInt()
                                        for(Group member:members){
                                            if (bookingID == member.getBookingID() || bookingID == member.getGrpLeadID()){ // If bookingID is not unique
                                                System.out.println("Booking ID is not unique! Enter again.");
                                                validInt = false;
                                                break;
                                            }
                                        }
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
                            FName = handle.getFName();
                            LName = handle.getLName();
                            System.out.println("Email: " + grpLeadEmail);
                            System.out.println("Telephone number: " + grpLeadContact);
                            
                            // Display entered information
                            System.out.println("\n== Passenger Information ==");
                            System.out.println("Booking ID: " + bookingID);
                            System.out.println("Group Lead ID: " + grpLeadBookingID);
                            System.out.println("First Name: " + FName);
                            System.out.println("Last Name: " + LName);
                            System.out.println("Email: " + grpLeadEmail);
                            System.out.println("Telephone Number: " + grpLeadContact);

                            validInt = false; // reset value
                            while(!validInt){
                                System.out.println("\nIs the above infomation correct or do you want to make changes?");
                                System.out.println("1. Confirm");
                                System.out.println("2. Edit");
                                System.out.print("Pick: ");
                                try{
                                    if (scanner.hasNextInt()){
                                        int answer = scanner.nextInt();
                                        scanner.nextLine(); // Consume the newline character left by nextInt()

                                        switch(answer){
                                            case 1:
                                                confirm = true;
                                                validInt = true;
                                                break;
                                            case 2:
                                                confirm = false;
                                                validInt = true;
                                                break;
                                            default:
                                                System.out.println("Invalid input, please enter 1 or 2.");
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
                        }

                        // Display questionaires for personal information
                        confirm = false;
                        while(!confirm){
                            System.out.println("\n== Required Information ==");
                            nationality = handle.getNationality();
                            gender = handle.getGender();
                            dob = handle.getDob();

                            System.out.println("\n== Personal Details ==");
                            System.out.println("Nationality: " + nationality);
                            System.out.print("Gender: ");
                            if (gender == 1){
                                System.out.print("Female");
                            } else {
                                System.out.print("Male");
                            }
                            System.out.println("\nDate of Birth (dd/mm/yyyy): " + dob);

                            validInt = false; // reset value
                            while(!validInt){
                                System.out.println("\nIs the above infomation correct or do you want to make changes?");
                                System.out.println("1. Confirm");
                                System.out.println("2. Edit");
                                System.out.print("Pick: ");
                                try{
                                    if (scanner.hasNextInt()){
                                        int answer = scanner.nextInt();
                                        scanner.nextLine(); // Consume the newline character left by nextInt()

                                        switch(answer){
                                            case 1:
                                                confirm = true;
                                                validInt = true;
                                                break;
                                            case 2:
                                                confirm = false;
                                                validInt = true;
                                                break;
                                            default:
                                                System.out.println("Invalid input, please enter 1 or 2.");
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
                        }
                        // Gather passport info and store all data in arraylist
                        members.add(gatherPassportInfo(scanner));
                        
                        // Generate boarding pass
                        boardingPass("Group Member");
                    }
                }else{
                    System.out.println("Invalid input, please enter an integer.");
                    validInt = false;
                    scanner.nextLine(); // Consume invalid input
                }
            }catch(InputMismatchException ex){
                System.out.println("Invalid input, please enter an integer.");
                validInt = false;
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    //SPECIAL NEEDS CHECK-IN
    private static void gatherSNeedsInfo(Scanner scanner){
        UserInputHandler handle = new UserInputHandler();
        boolean validInt, confirm = false; // Confirm info or edit info
        int answer;//, bookingId = 0;
        // Display questionaires for grp representative
        while(!confirm){
            System.out.println("\n== Special Needs Check-in ==");
            bookingID = handle.getBookingID();
            FName = handle.getFName();
            LName = handle.getLName();
            email = handle.getEmail();
            contact = handle.getContact();

            // Display entered information
            System.out.println("\n== Special Needs Information ==");
            System.out.println("Booking ID: " + bookingID);
            System.out.println("First Name: " + FName);
            System.out.println("Last Name: " + LName);
            System.out.println("Email: " + email);
            System.out.println("Telephone Number: " + contact);

            validInt = false; // reset value
            while(!validInt){
                System.out.println("\nIs the above infomation correct or do you want to make changes?");
                System.out.println("1. Confirm");
                System.out.println("2. Edit");
                System.out.print("Pick: ");
                try{
                    if (scanner.hasNextInt()){
                        answer = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character left by nextInt()

                        switch(answer){
                            case 1:
                                confirm = true;
                                validInt = true;
                                break;
                            case 2:
                                confirm = false;
                                validInt = true;
                                break;
                            default:
                                System.out.println("Invalid input, please enter 1 or 2.");
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
        }

        // Display questionaires for personal information
        confirm = false;
        while(!confirm){
            System.out.println("\n== Required Information ==");
            nationality = handle.getNationality();
            gender = handle.getGender();
            dob = handle.getDob();

            System.out.println("\n== Personal Details ==");
            System.out.println("Nationality: " + nationality);
            System.out.print("Gender: ");
            if (gender == 1){
                System.out.print("Female");
            } else {
                System.out.print("Male");
            }
            System.out.println("\nDate of Birth (dd/mm/yyyy): " + dob);

            validInt = false; // reset value
            while(!validInt){
                System.out.println("\nIs the above infomation correct or do you want to make changes?");
                System.out.println("1. Confirm");
                System.out.println("2. Edit");
                System.out.print("Pick: ");
                try{
                    if (scanner.hasNextInt()){
                        answer = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character left by nextInt()

                        switch(answer){
                            case 1:
                                confirm = true;
                                validInt = true;
                                break;
                            case 2:
                                confirm = false;
                                validInt = true;
                                break;
                            default:
                                System.out.println("Invalid input, please enter 1 or 2.");
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
        }
    }
        //passport part
    public static SpecialNeeds SpecialgatherPassportInfo(Scanner scanner){
        boolean sValidInt, sConfirm; // Confirm info or edit info
        int sAnswer;
        PassportValidator sPassportValidator = new PassportValidator();
        sConfirm = false;
        // String fName, lName, email, contact, nationality, dob, passportNo, country, passportExpiry, issuingCountry, assistanceType;
        // int bookingID =0, gender;

        // // Initialize variables
        // fName = "";
        // lName = "";
        // email = "";
        // contact = "";
        // nationality = "";
        // dob = "";
        // passportNo = "";
        // country = "";
        // passportExpiry = "";
        // issuingCountry = "";
        // assistanceType = "";
        // bookingID = 0;
        // gender = 0;

        while(!sConfirm){
            System.out.println("\n== Passport Information ==");
            System.out.print("Passport number: ");
            passportNo = scanner.nextLine();
            while (!sPassportValidator.validatePassportNumber(passportNo)) {
                System.out.print("Passport number: ");
                passportNo = scanner.nextLine();
            }
            
            System.out.print("Country: ");
            country = scanner.nextLine();
            while (!sPassportValidator.validateCountry(country)) {
                System.out.print("Country: ");
                country = scanner.nextLine();
            }

            System.out.print("Passport expiry date (dd/mm/yyyy): ");
            passportExpiry = scanner.nextLine();
            while (!sPassportValidator.validateExpiryDate(passportExpiry)) {
                System.out.print("Passport expiry date (dd/mm/yyyy): ");
                passportExpiry = scanner.nextLine();
            }
            
            System.out.print("Passport issuing country: ");
            issuingCountry = scanner.nextLine();
            while (!sPassportValidator.validateIssuingCountry(issuingCountry)) {
                System.out.print("Passport issuing country: ");
                issuingCountry = scanner.nextLine();
            }

            System.out.println("\n== Passport Information ==");
            System.out.println("Passport number: " + passportNo);
            System.out.println("Country: " + country);
            System.out.println("Passport expiry date (dd/mm/yyyy): " + passportExpiry);
            System.out.println("Passport issuing country: " + issuingCountry);

            sValidInt = false; // reset value
            while(!sValidInt){
                System.out.println("\nIs the above infomation correct or do you want to make changes?");
                System.out.println("1. Confirm");
                System.out.println("2. Edit");
                System.out.print("Pick: ");
                try{
                    if (scanner.hasNextInt()){
                        sAnswer = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character left by nextInt()

                        switch(sAnswer){
                            case 1:
                                sConfirm = true;
                                sValidInt = true;
                                break;
                            case 2:
                                sConfirm = false;
                                sValidInt = true;
                                break;
                            default:
                                System.out.println("Invalid input, please enter 1 or 2.");
                                sValidInt = false;
                                break;
                        }
                    }else{
                        System.out.println("Invalid input, please enter 1 or 2.");
                        sValidInt = false;
                        scanner.nextLine(); // Consume invalid input
                    }
                }catch(InputMismatchException ex){
                    System.out.println("Invalid input, please enter 1 or 2.");
                    sValidInt = false;
                    scanner.nextLine(); // Consume invalid input
                }

            
            }
            
            // Generate boarding pass
            boardingPass("Passenger");
            
            System.out.print("Enter Assistance Type: ");
            assistanceType = scanner.nextLine();

            // SpecialNeeds specialNeedsPassenger = new SpecialNeeds(
            // bookingID, fName, lName, gender, email, contact, nationality, dob, passportNo, country, passportExpiry, issuingCountry, assistanceType);

            // specialNeedsPassenger.requestAssistance();
            // System.out.println(specialNeedsPassenger);
        }  
        return new SpecialNeeds(bookingID, FName, LName, gender, email, contact, nationality, dob, passportNo, country, passportExpiry, issuingCountry, assistanceType);
    
    }
    //BAGGAGE HANDLING
    /*private static void baggageMethod(Scanner scanner) {
        boolean validInput = false;   
    }*/
    private static void baggageHandling(Scanner scanner, String method){
        UserInputHandler handle = new UserInputHandler();
        String baggageID = null;
        int number = (int)(Math.random() * 3);
        
        System.out.println("\n== Generate your Baggage Tag ==");
        bookingID = handle.getBookingID();
        String seatNo = handle.getSeatNo();
        int flightNo = handle.getFlightNo();
                        
        baggageID = "TAG-" + bookingID + "-" + seatNo + "-" + flightNo; 
        System.out.println("\nYour Baggage Tag: " + baggageID);
        System.out.println("");
        
        while(true){
            boolean confirm = false, valid = false;

            while(!confirm){
                System.out.println("==Baggage Handling==");
                System.out.println("1. Track Baggage");
                System.out.println("2. Screening Status");
                System.out.println("3. Exit");
                System.out.println("Pick: ");

                if(scanner.hasNextInt()) {
                   int baggageHandling = scanner.nextInt();
                   scanner.nextLine();

                   switch(baggageHandling){
                       case 1:
                            confirm = true;
                            if (number == 0){
                                System.out.println("Your Baggage " + baggageID + " is at the pickup point.");
                            }else if (number == 1){
                                System.out.println("Your Baggage " + baggageID + " is checked in the plane.");
                            }else if (number == 2){
                                System.out.println("Your Baggage " + baggageID + " is at the drop-off point.");}
                            break;

                       case 2:
                           confirm = true;
                           System.out.println("\nScreening progess:");
                           System.out.print("Loading");
                           for (int i = 0;i < 20;i++) {
                                try {
                                   System.out.print(".");
                                    TimeUnit.SECONDS.sleep(1);
                                }catch (InterruptedException e) {
                                  e.printStackTrace();
                                } if (i == 3) {
                                    System.out.println("\n");
                                    System.out.println("Screening process completed!");
                                    System.out.println("Baggage " + baggageID + " does not contain restricted items.");
                                    break;
                                }
                           }
                           break;

                       case 3:
                           System.exit(0);
                           break;

                       default:
                           System.out.println("Invalid choice. Pick 1, 2 or 3.");
                           confirm = false;
                           break;}
                }else {
                    System.out.println("Invalid choice. Pick 1, 2 or 3.");
                    confirm = false;
                    scanner.nextLine();
                }
                while(true){
                    System.out.println("\nDo you want to continue baggage handling?\n1. Yes\n2. No");
                    System.out.print("Pick: ");
                        if (scanner.hasNextInt()){
                            int answer = scanner.nextInt();
                            scanner.nextLine();
                            if (answer == 1) {
                            break;
                        } else if (answer == 2) {
                                valid = true;
                                System.out.println("");
                                handleCheckIn(scanner,method);
                        } else {
                            System.out.println("Invalid number, input 1 or 2.");
                        }
                    } else {
                        System.out.println("Invalid number, input 1 or 2."); 
                        scanner.nextLine(); // Consume invalid input
                    }
                }
            }
        }
    }
}
