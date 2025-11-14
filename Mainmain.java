package FinalProject;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.*;

public class Mainmain {

    // public static boolean nameValidation(String clientFName){
    //     Pattern patternName = Pattern.compile("^[A-Z][a-z]+(?: [A-Z][a-z]+)+$"); //rule
    //     Matcher matcherName = patternName.matcher(clientFName); //inspect/check
    //     boolean isMatchFoundName;
    //     isMatchFoundName = matcherName.matches(); //validate

    //     if (isMatchFoundName){
    //             return true;
    //     } else {
    //             return false;
    //     }
    // }

    // public static boolean addressValidation(String clientAdd){
    //     Pattern patternAdd = Pattern.compile("^\\d+\\s[A-Za-z0-9\\s]+,\\s[A-Za-z\\s]+,\\s[A-Za-z0-9\\s]+$"); //street num, city name,  
    //     Matcher matcherAdd = patternAdd.matcher(clientAdd); //inspect/check
    //     boolean isMatchFoundAdd;
    //     isMatchFoundAdd = matcherAdd.matches(); //validate

    //     if (isMatchFoundAdd){
    //             return true;
    //     } else {
    //             return false;
    //     }
    // }

    public static boolean continfoValidation(String clientCInfo){
        Pattern patternCI = Pattern.compile("^0\\d{10}$"); //rule
        Matcher matcherCI = patternCI.matcher(clientCInfo); //inspect/check
        boolean isMatchFoundCI;
        isMatchFoundCI = matcherCI.matches(); //validate

        if (isMatchFoundCI){
                return true;
        } else {
                return false;
        }
    }

    public static boolean emailValidation(String clientEAdd){
        Pattern patternEmail = Pattern.compile("^[\\w.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"); //rule
        Matcher matcherEmail = patternEmail.matcher(clientEAdd); //inspect/check
        boolean isMatchFoundEmail;
        isMatchFoundEmail = matcherEmail.matches(); //validate

        if (isMatchFoundEmail){
                return true;
        } else {
                return false;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //arraylist
        ArrayList<String> FName = new ArrayList<>();
        ArrayList<String> Add = new ArrayList<>();
        ArrayList<String> CInfo = new ArrayList<>();
        ArrayList<String> EAdd = new ArrayList<>();
        
        //strings
        String clientFName;
        String clientAdd;
        String clientCInfo;
        String clientEAdd;
        //booleans
        boolean isnameValid;
        boolean isAddValid;
        boolean isContInfoValid;
        boolean isEmailAddValid;

        System.out.print("Client Full Name (ex.: Paul Harris B. Bathan): ");
        clientFName = sc.nextLine();
        FName.add(clientFName);

        System.out.print("Client Address (ex.: Mataas na Lupa, Lipa City, Batangas): ");
        clientAdd = sc.nextLine();
        Add.add(clientAdd);
    

        System.out.print("Client Contact Information (ex.: 09123456789): ");
        clientCInfo = sc.nextLine();

        isContInfoValid = continfoValidation(clientCInfo);
        if (!isContInfoValid){
            System.out.println("Invalid Contact Information. Please try again. \n");
        } else {
            CInfo.add(clientCInfo);
        }

        System.out.print("Client Email Address (ex.: john.doe@example.com): ");
        clientEAdd = sc.nextLine();

        isEmailAddValid = continfoValidation(clientEAdd);
        if (!isEmailAddValid){
            System.out.println("Invalid Email Address. Please try again. \n");
        } else {
            EAdd.add(clientEAdd);
        }




    }
}
