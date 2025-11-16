package FinalProject;
import java.util.*;

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


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ReservationDate = new ArrayList<>();
        ArrayList<String> Facilitytype = new ArrayList<>();
        ArrayList<Integer> NumberofGuest = new ArrayList<>();
        ArrayList<Integer> NumberofFacilitytoReserve = new ArrayList<>();

        //array
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July","August","September","Ocotober","Novmber","December",};
        String[] facility = {"Single Room", "Double", "King", "Suite"};
        double[] pricePerUnit = {1500.00, 2000.00, 3000.00, 4000.00};
        int[] pax = {2, 3, 4, 6};

        //strings
        String breakfast = "Free";

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

        //char
        char lunchdinner;

        //STARTING
        System.out.println("Reservation Date");
        System.out.print("Please select a month (1 = January - 12 = December): ");
        month = sc.nextInt();

        if(month < 1 || month > 12){
            System.out.println("Invalid month selected. Please try again bitch.");
        } //maybe try-catch
        System.out.print("Select a year (e.g., 2025, 2026, 2027): ");
        year = sc.nextInt();

        monthDays = getDaysInMonth(month, year);
        System.out.println(monthNames[month - 1] + " has " + monthDays + " days");
        System.out.print("Select a day (1 - " + monthDays + "): ");
        day = sc.nextInt();

        if(day < 1 || day > monthDays){
            System.out.println("Invalid day selected. Please try again bitch");
        } else{
            String reserveDate = monthNames[month - 1] + "/" + day + "/" + year;
            System.out.println("You've choosen: " + reserveDate);
            ReservationDate.add(reserveDate);
        }

        //facility
        System.out.println("    Facility        Price Per Unit     Maximum # of Pax");
        System.out.println("-----------------------------------------------------------");

        for(int i=0; i<facility.length; i++){
            System.out.printf("%-3d %-17s %-23.2f %d%n", i + 1, facility[i], pricePerUnit[i], pax[i]);
        }

        System.out.print("Choose your Facility Type: ");
        facilityType = sc.nextInt();
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

        System.out.print("Number of Faclities to Rerve: ");
        numofFacilitytoReserve = sc.nextInt();
        System.out.println();
        NumberofFacilitytoReserve.add(numofFacilitytoReserve);

        //MEAL
        System.out.println("MEAL");
        System.out.println("    Breakfast        Lunch         Dinner");
        System.out.println("----------------------------------------------");
        System.out.printf("%10s %15.2f %13.2f%n", breakfast, lunch, dinner);

        System.out.println("Would like to avail Lunch and Dinner? (Y/N) ");
        lunchdinner = sc.next().toUpperCase().charAt(0);

        if(lunchdinner == 'Y'){
            do {
                 System.out.println("Lunch: 1");
                 System.out.println("Dinner: 2");
                 System.out.println("Total: 0");
                 foodchoice = sc.nextInt();
            switch (foodchoice) {
                case 1:
                    System.out.print("Meal Lunch Quantity: "); 
                    lunchQuantity = sc.nextInt();
                    lunchTotal = lunchQuantity * 250;
                    System.out.println("Lunch: 1");
                    System.out.println("Dinner: 2");
                    System.out.println("Total: 0");
                    foodchoice = sc.nextInt();
                    break;

                case 2: 
                    System.out.println("Meal Dinner Quantity: "); 
                    dinnerQuantity = sc.nextInt();
                    dinnerTotal = dinnerQuantity * 250;
                    System.out.println("Lunch: 1");
                    System.out.println("Dinner: 2");
                    System.out.println("Total: 0");
                    foodchoice = sc.nextInt();
                    break;
            
                default:
                    break;
            }
            } while (foodchoice != 0);
           
        }
        
        totalmealPrice = lunchTotal + dinnerTotal;

    }
}
