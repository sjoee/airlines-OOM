package aerocheck;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AeroCheck {
    static int bookingID, grpLeadBookingID, gender;
    static String FName, LName, grpLeadEmail, grpLeadContact, nationality, dob, passportNo, country, passportExpiry, issuingCountry;
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
                            handleCheckIn(scanner);
                            break;
                        case 2:
                            valid = true;
                            handleCheckIn(scanner);
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
    
    private static void handleCheckIn(Scanner scanner) {
        boolean valid = false;
        ArrayList<Group> members = new ArrayList<>();
        
        while (!valid) {
            System.out.println("== Check-in ==");
            System.out.println("1. Passenger Check-in");
            System.out.println("2. Group Check-in");
            System.out.println("3. Special Needs Assistance");
            System.out.println("4. Exit");
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
                        gatherGrpMemberInfo(scanner, members);
                        // Display all group info
                        for(Group member:members){
                            System.out.println(member);
                        }
                        break;
                    case 3:
                        //EDIT HEREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
                        handleSpecialNeeds(scanner);
                        System.out.println("Special Needs Assistance not implemented yet.");
                        break;
                    case 4:
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
        //here

    //GROUP LEADER CHECK-IN HERE [CASE 2]
    private static void gatherGrpLeadInfo(Scanner scanner){
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
            System.out.print("First Name: ");
            FName = scanner.nextLine();
            System.out.print("Last Name: ");
            LName = scanner.nextLine();
            System.out.print("Email: ");
            grpLeadEmail = scanner.nextLine();
            System.out.print("Telephone number: ");
            grpLeadContact = scanner.nextLine();

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
            System.out.print("Nationality: ");
            nationality = scanner.nextLine();

            validInt = false;
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
            System.out.println("Date of Birth (dd/mm/yyyy): ");
            dob = scanner.nextLine();

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
    
    //GROUP PASSPORT [UNDER CASE 2]
    private static Group gatherPassportInfo(Scanner scanner){
        boolean validInt, confirm; // Confirm info or edit info
        int answer;
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
            System.out.print("Passport expiry date (dd/mm/yyyy): ");
            passportExpiry = scanner.nextLine();
            
            // Validate passport expiry
            // boolean valid = false;
            // while (!valid){
            //     System.out.print("Passport expiry date (dd/mm/yyyy): ");
            //     passportExpiry = scanner.nextLine();
                
            //     SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            //     Date expiryDate;
            //     try {
            //         expiryDate = dateFormat.parse(passportExpiry);
            //         Date currentDate = new Date(); // Get current date
            //         if (expiryDate.before(currentDate)) {
            //             System.out.println("Passport has expired!");
            //         } else {
            //             valid = true;
            //         }
            //     } catch (ParseException e) {
            //         System.out.println("Invalid date. Follow the format dd/mm/yyyy.");
            //     }
            // }
            
            System.out.print("Passport issuing country: ");
            issuingCountry = scanner.nextLine();

            System.out.println("\n== Passport Information ==");
            System.out.println("Passport number: " + passportNo);
            System.out.println("Country: " + country);
            System.out.println("Passport expiry date (dd/mm/yyyy): " + passportExpiry);
            System.out.println("Passport issuing country: " + issuingCountry);

            //new validator
        //     PassportValidator passportValidator = new PassportValidator();
        // if (!passportValidator.validatePassport(passportNo, country, passportExpiry)) {
        //     System.out.println("Invalid passport information. Please try again.");
        //     continue;
        }

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
        // Fill in info for group members 
        boolean validInt = false; // reset value to prevent looping
        while(!validInt){
            System.out.print("\nAmount of travellers checking in (excluding group representative): ");
            try{
                if (scanner.hasNextInt()){
                    int ticketQty = scanner.nextInt();
                    validInt = true;
                    scanner.nextLine(); // Consume the newline character left by nextInt()

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
                                            if (bookingID == member.getBookingID() || bookingID == member.getGrpLeadID()){
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
                            System.out.print("First Name: ");
                            FName = scanner.nextLine();
                            System.out.print("Last Name: ");
                            LName = scanner.nextLine();
                            System.out.print("Email: " + grpLeadEmail);
                            System.out.print("Telephone number: " + grpLeadContact);

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
                            System.out.print("Nationality: ");
                            nationality = scanner.nextLine();

                            validInt = false;
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
                            System.out.println("Date of Birth (dd/mm/yyyy): ");
                            dob = scanner.nextLine();

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
                        gatherPassportInfo(scanner);
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
    private static void handleSpecialNeeds(Scanner scanner){
        boolean sValidInt, sConfirm; // Confirm info or edit info
        int sAnswer;

        System.out.println("== Special Needs Check-in ==");

        System.out.print("Enter Booking ID: ");
        int bookingID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter First Name: ");
        String fName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lName = scanner.nextLine();

        System.out.print("Enter Gender (1 for Female, 2 for Male): ");
        int gender = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();

        System.out.print("Enter Nationality: ");
        String nationality = scanner.nextLine();

        System.out.print("Date of Birth (dd/mm/yyyy): ");
        String dob = scanner.nextLine();

        //passport part
        sConfirm = false;
        while(!sConfirm){
            System.out.println("\n== Passport Information ==");
            System.out.print("Passport number: ");
            passportNo = scanner.nextLine();
            System.out.print("Country: ");
            country = scanner.nextLine();
            
            // Validate passport expiry
            boolean valid = false;
            while (!valid){
                System.out.print("Passport expiry date (dd/mm/yyyy): ");
                passportExpiry = scanner.nextLine();
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date expiryDate;
                try {
                    expiryDate = dateFormat.parse(passportExpiry);
                    Date currentDate = new Date(); // Get current date
                    if (expiryDate.before(currentDate)) {
                        System.out.println("Passport has expired!");
                    } else {
                        valid = true;
                    }
                } catch (ParseException e) {
                    System.out.println("Invalid date. Follow the format dd/mm/yyyy.");
                }
            }


            System.out.print("Passport issuing country: ");
            issuingCountry = scanner.nextLine();

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
            
            System.out.print("Enter Assistance Type: ");
            String assistanceType = scanner.nextLine();

            SpecialNeeds specialNeedsPassenger = new SpecialNeeds(
                bookingID, fName, lName, gender, email, contact, nationality, dob, passportNo, country, passportExpiry, issuingCountry, assistanceType
            );

            specialNeedsPassenger.requestAssistance();
            System.out.println(specialNeedsPassenger);
        }    
    }
}
