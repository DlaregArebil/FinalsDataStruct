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
        //array
        String[] tunayMonths = {"January", "February", "March", "April", "May", "June", "July","August","September","Ocotober","Novmber","December",};
        String[] facility = {"Single Room", "Double", "King", "Suite"};
        double[] pricePerUnit = {1500.00, 2000.00, 3000.00, 4000.00};
        int[] pax = {2, 3, 4, 6};


        // ints
        int year;
        int month;
        int day;
        int monthDays;
        int facilityType;

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
        System.out.println(month + " has " + monthDays + " days");
        System.out.print("Select a day (1 - " + monthDays + "): ");
        day = sc.nextInt();

        if(day < 1 || day > monthDays){
            System.out.println("Invalid day selected. Please try again bitch");
        } else{
            System.out.println("You've choosen: " + month + "/" + day + "/" + year);
        }
        
        System.out.println("    Facility        Price Per Unit     Maximum # of Pax");
        System.out.println("-----------------------------------------------------------");

        for(int i=0; i<facility.length; i++){
            System.out.printf("%-3d %-17s %-23.2f %d%n", i + 1, facility[i], pricePerUnit[i], pax[i]);
        }

        System.out.println("Choose your Facility Type: ");
        facilityType = sc.nextInt();
        if(facilityType > 0 && facilityType <= facility.length){
            
        }

        
        
        System.out.println("Number of guest");

        System.out.println("Number of Faclities to Rerve");
    
    
    
    }
}
