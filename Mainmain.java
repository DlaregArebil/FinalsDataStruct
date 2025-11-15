package FinalProject;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.regex.*;

public class ClientClass {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static boolean continfoValidation(String clientCInfo) {
        Pattern patternCI = Pattern.compile("^0\\d{10}$"); // rule
        Matcher matcherCI = patternCI.matcher(clientCInfo); // inspect/check
        boolean isMatchFoundCI;
        isMatchFoundCI = matcherCI.matches(); // validate

        if (isMatchFoundCI) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean emailValidation(String clientEAdd) {
        Pattern patternEmail = Pattern.compile("^[\\w.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"); // rule
        Matcher matcherEmail = patternEmail.matcher(clientEAdd); // inspect/check
        boolean isMatchFoundEmail;
        isMatchFoundEmail = matcherEmail.matches(); // validate

        if (isMatchFoundEmail) {
            return true;
        } else {
            return false;
        }
    }

    public static int ClientID(ArrayList<String> CInfo) {

        int sum = 0;

        for (int i = 0; i < CInfo.size(); i++) {
            String phone = CInfo.get(i);

            int[] digits = new int[phone.length()];
            for (int j = 0; j < phone.length(); j++) {
                digits[j] = Character.getNumericValue(phone.charAt(j));
            }

            // take not sa mag dodocumentary BUBBLE SORTING PO ITO HEHEHE
            // converting your phone number into ascending order
            for (int j = 0; j < digits.length - 1; j++) {
                for (int k = 0; k < digits.length - 1 - j; k++) {
                    if (digits[k] > digits[k + 1]) {
                        int temp = digits[k];
                        digits[k] = digits[k + 1];
                        digits[k + 1] = temp;
                    }
                }
            }

            for (int j = 0; j < digits.length; j++) {
                sum += digits[j] * (j + 1);
            }
        }

        return sum;
    }

    public static void getcreateFile(File file){
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Failed to create the file   .");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // arraylist
        ArrayList<String> FName = new ArrayList<>();
        ArrayList<String> Add = new ArrayList<>();
        ArrayList<String> CInfo = new ArrayList<>();
        ArrayList<String> EAdd = new ArrayList<>();

        // strings
        String clientFName;
        String clientAdd;
        String clientCInfo;
        String clientEAdd;
        // booleans
        boolean isnameValid;
        boolean isAddValid;
        boolean isContInfoValid;
        boolean isEmailAddValid;

        //File
        File clientFile = new File("CLEINT text file");

        System.out.print("Client Full Name (ex.: Paul Harris B. Bathan): \n");
        clientFName = sc.nextLine();
        FName.add(clientFName);

        System.out.print("Client Address (ex.: Mataas na Lupa, Lipa City, Batangas): \n");
        clientAdd = sc.nextLine();
        Add.add(clientAdd);

        while (true) {
            System.out.print("Client Contact Information (ex.: 09123456789): \n");
            clientCInfo = sc.nextLine();

            isContInfoValid = continfoValidation(clientCInfo);
            if (!isContInfoValid) {
                System.out.println("Invalid Contact Information. Please try again. \n");
            } else {
                CInfo.add(clientCInfo);
                break;
            }
        }

        while (true) {
            System.out.println("Client Email Address (ex.: john.doe@example.com): ");
            clientEAdd = sc.nextLine();

            isEmailAddValid = emailValidation(clientEAdd);

            if (!isEmailAddValid) {
                System.out.println("Invalid Email Address. Please try again. \n");
            } else {
                EAdd.add(clientEAdd);
                break;
            }

        }

        // para firstname lang lalabas sa output
        String fullname = FName.get(0);
        String firstname = fullname.split(" ")[0];

        clearScreen();

        System.out.println("Successful Registration!!! Congratulations " + firstname + "!\n");

        int newClientID = ClientID(CInfo);

        System.out.println("Here is your Client ID: " + newClientID);
        System.out.print("Please do not share it to anyone");

       try (BufferedWriter clientWrite = new BufferedWriter(new FileWriter("client", true))) {
			clientWrite.write("Full Name: " + clientFName);
            clientWrite.newLine();
            clientWrite.write("Address: " + clientAdd);
            clientWrite.newLine();
            clientWrite.write("Contact Info: " + clientCInfo);
            clientWrite.newLine();
            clientWrite.write("Email Address: " + clientEAdd);
            clientWrite.newLine();
            clientWrite.write("Client ID: " + newClientID);
            clientWrite.write("----------------------------------------");
			clientWrite.newLine();
			 System.out.println("Client information saved to file successfully.");
		} catch (IOException e) {
			System.out.println("Failed to update the file.");
			e.printStackTrace();
		}


    }
}

