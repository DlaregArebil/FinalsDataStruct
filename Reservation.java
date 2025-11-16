package FinalProject;
import java.util.*;
import java.io.*;

public class Reservation {


    static boolean isLeapYear (int year){
        return (year % 4 == 0 && (year % 100 !=0 || year % 400 == 0));
    }

    static int getDaysInMonth(int month, int year){
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(month == 2 && isLeapYear(year)){
            return 29;
        }

        return days[month - 1];
    }

   static void getcreateFile(File reserFile){
        try {
            if (reserFile.createNewFile()) {
                System.out.println("RESERVE text file created successfully.");
            } else {
                System.out.println("RESERVE text file already exist.");
            }
        } catch (IOException e) {
            System.out.println("Failed to create the file.");
            e.printStackTrace();
        }
   }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ReservationDate = new ArrayList<>();
        ArrayList<String> Facilitytype = new ArrayList<>();
        ArrayList<Integer> NumberofGuest = new ArrayList<>();
        ArrayList<Integer> NumberofFacilitytoReserve = new ArrayList<>();

        //file
        File reservFile = new File("RESERVE text file");
        //array
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July","August","September","Ocotober","Novmber","December",};
        String[] facility = {"Single Room", "Double", "King", "Suite"};
        double[] pricePerUnit = {1500.00, 2000.00, 3000.00, 4000.00};
        int[] pax = {2, 3, 4, 6};

        //strings
        String breakfast = "Free";
        String reservationRecord;

        // ints
        int year;
        int month;
        int day;
        int monthDays;
        int facilityType;
        int numofGuest;
        int numofFacilitytoReserve;
        int addPerson;
        int additionalFee = 0;
        int foodchoice = 0;
        int dinnerQuantity = 0;
        int dinnerTotal = 0;
        int lunchQuantity = 0;
        int lunchTotal = 0;
        int totalmealPrice = 0;
        //doubles
        Double lunch = 250.00;
        Double dinner = 350.00;
        Double payment = 0.00;
        Double kulang;
        Double partialFee;
        
        //char
        char lunchdinner;
        char fullpayment;

        //STARTING
        System.out.println("Reservation Date");
        while(true){
            try{
                System.out.print("Please select a month (1 = January - 12 = December): ");
                month = sc.nextInt();

                if (month < 1 || month > 12) {
                    throw new IllegalArgumentException("Invalid month. Please enter a number between 1 and 12.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the month.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
            }    
                    
        }

       while (true) {
            try {
                System.out.print("Select a year (e.g., 2025, 2026, 2027): ");
                year = sc.nextInt();
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid year.");
                sc.nextLine();
            }
        }

        monthDays = getDaysInMonth(month, year);
        System.out.println(monthNames[month - 1] + " has " + monthDays + " days");
        while (true) {
            try{
                System.out.print("Select a day (1 - " + monthDays + "): ");
                day = sc.nextInt();

                if(day < 1 || day > monthDays){
                    System.out.println("Invalid day selected. Please try again.");
                } else {
                    String reserveDate = monthNames[month - 1] + "/" + day + "/" + year;
                    System.out.println("You've choosen: " + reserveDate);
                    ReservationDate.add(reserveDate);
                    break;
                }
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid integer for the day.");
                sc.nextLine();
            }
        }

        //facility
        System.out.println("    Facility        Price Per Unit     Maximum # of Pax");
        System.out.println("-----------------------------------------------------------");

        for(int i=0; i<facility.length; i++){
            System.out.printf("%-3d %-17s %-23.2f %d%n", i + 1, facility[i], pricePerUnit[i], pax[i]);
        }

        while (true) {
            try {
                System.out.print("Choose your Facility Type: ");
                facilityType = sc.nextInt();
                break;
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid integer for the day.");
                sc.nextLine();
            }
        }
        int i = facilityType - 1;
        if(facilityType > 0 && facilityType <= facility.length){
            String reserveFacility = facility[i] + " | Price: " + pricePerUnit[i] + " | Pax: " + pax[i];
            System.out.println("\nYou selected:");
            System.out.println(reserveFacility);
            Facilitytype.add(reserveFacility);
            System.out.println();
        } else {
            System.out.println("Invalid choice. Please try again.");
        }

        while (true) {
            try {
                System.out.print("Number of guest (REMEMBER: There is an additional Php500.00 for every extra person for room accommodation): " );
                numofGuest = sc.nextInt();

                if(numofGuest > pax[i]){
                    addPerson = numofGuest - pax[i];
                    additionalFee = addPerson * 500;

                    System.out.println("You added: " + addPerson + " pax");
                    System.out.println("Your additioanl fee is: Php" + additionalFee);
                }
                System.out.println();
                NumberofGuest.add(numofGuest);
                break;
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid integer for the day.");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Number of Faclities to Rerve: ");
                numofFacilitytoReserve = sc.nextInt();
                
                System.out.println();
                NumberofFacilitytoReserve.add(numofFacilitytoReserve);
                break;
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid integer for the day.");
                sc.nextLine();
            }
        }
        

        //MEAL
        System.out.println("MEAL");
        System.out.println("    Breakfast        Lunch         Dinner");
        System.out.println("----------------------------------------------");
        System.out.printf("%10s %15.2f %13.2f%n", breakfast, lunch, dinner);

        while (true) {
            try {
                System.out.print("Would like to avail Lunch and Dinner? (Y/N) ");
                lunchdinner = sc.next().toUpperCase().charAt(0);

                if(lunchdinner == 'Y'){
                    do {
                        System.out.println("Select 1 to input Lunch quantity");
                        System.out.println("Select 2 to input Dinner quantity");
                        System.out.println("Select 0 to view Total");
                        foodchoice = sc.nextInt();
                    switch (foodchoice) {
                        case 1:
                            System.out.print("Meal Lunch Quantity: "); 
                            lunchQuantity = sc.nextInt();
                            lunchTotal = lunchQuantity * 250;
                            System.out.println("Select 0 to view Total");
                            foodchoice = sc.nextInt();
                            continue;

                        case 2: 
                            System.out.print("Meal Dinner Quantity: "); 
                            dinnerQuantity = sc.nextInt();
                            dinnerTotal = dinnerQuantity * 250;
                            System.out.println("Select 0 to view Total");
                            foodchoice = sc.nextInt();
                            break;
                    
                        default:
                            break;
                    }
                } while (foodchoice != 0);
            
            }
            totalmealPrice = lunchTotal + dinnerTotal;
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid character.");
                sc.nextLine();
            }
        }
        
        //payment
        System.out.println("\nReservation Summary:");
        System.out.println("----------------------------");
        System.out.println("Reservation Date: " + ReservationDate.get(0));
        System.out.println("Facility Type: " + Facilitytype.get(0));
        System.out.println("Number of Guests: " + NumberofGuest.get(0));

        if (additionalFee > 0) {
            System.out.println("Additional Fee for Extra Pax: Php " + additionalFee);
        } else {
            System.out.println("No Additional Fee for Extra Pax.");
        }

        System.out.println("Total Meal Price: Php " + totalmealPrice);
        System.out.println("------------------------------------------------------------");
        System.out.println("Total Cost for Reservation: Php " + (pricePerUnit[i] * NumberofFacilitytoReserve.get(0) + additionalFee + totalmealPrice));
        System.out.println("------------------------------------------------------------");
        System.out.println("Thank you for your reservation! We look forward to serving you.");


        System.out.println("You have the option to pay 30% reservation fee or pay the full amount.");
        Double totalReservation = (pricePerUnit[i] * NumberofFacilitytoReserve.get(0) + additionalFee + totalmealPrice);

        System.out.println("Total Reservation Amount: " + totalReservation);
            while (true) {
                try {
                    System.out.print("Would you be able to pay for everything now? (Y/N): ");
                    fullpayment = sc.next().toUpperCase().charAt(0);

                    if (fullpayment == 'Y') {
                        System.out.println("Total Reservation Amount: " + totalReservation);
                        System.out.print("Input your payment: P");
                        payment = sc.nextDouble();

                        while (payment < totalReservation) {
                            kulang = totalReservation - payment;
                            System.out.println("Insufficient payment (Php " + kulang + ")");
                            System.out.print("Input your reservation payment: Php");
                            payment += sc.nextDouble();
                        }
                    } else if (fullpayment == 'N') {
                        partialFee = totalReservation * 0.30;
                        System.out.println("30% Reservation fee: Php " + partialFee);
                        System.out.print("Input your reservation payment: P");
                        payment = sc.nextDouble();

                        while (payment < partialFee) {
                            kulang = partialFee - payment;
                            System.out.println("Insufficient payment (Php " + kulang + ")");
                            System.out.print("Input your payment: Php");
                            payment += sc.nextDouble();
                        }
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid character or number.");
                    sc.nextLine();
                }
        }

        getcreateFile(reservFile);

        try (BufferedWriter reserveWriter = new BufferedWriter(new FileWriter(reservFile, true))) {
            reserveWriter.write(ReservationDate.get(0));
            reserveWriter.newLine();
            reserveWriter.write(Facilitytype.get(0));
            reserveWriter.newLine();
            reserveWriter.write(String.valueOf(NumberofGuest.get(0)));
            reserveWriter.newLine();
            reserveWriter.write(String.valueOf(additionalFee));
            reserveWriter.newLine();
            reserveWriter.write(String.valueOf(totalmealPrice));
            reserveWriter.newLine();
            reserveWriter.write(String.valueOf(totalReservation));
            reserveWriter.newLine();
            reserveWriter.write(String.valueOf(payment));
            reserveWriter.newLine();
            
            System.out.println("Reservation saved to file.");

        } catch (IOException e) {
            System.out.println("Failed to write to the file.");
            e.printStackTrace();
        }


    }
}
