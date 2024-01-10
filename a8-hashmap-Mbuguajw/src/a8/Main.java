package a8;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> passwordManager = new PasswordManager<>();


        // your code below
        System.out.println("Enter Master Password");
        String passwordCheck = scanner.next();
        while (!passwordManager.checkMasterPassword(passwordCheck)) {
            if (passwordManager.checkMasterPassword(passwordCheck)) {
                break;
            } else {
                System.out.println("Enter Master Password");
                passwordCheck = scanner.next();
            }
        }
        System.out.println("Okay then,...");
        String one = "New";
        String two = "Get";
        String three = "Delete";
        String four = "Duplicate";
        String five = "Accounts";
        String six = "Random";
        String seven = "Exit";

        String entry;
        boolean loop = true;

        while(loop) {
            System.out.println("Type one of the following commands:");
            System.out.println("New||Get||Delete||Duplicate||Accounts||Random||Exit");
            entry = scanner.next();
            if (checkEntry(entry, one)) {
                System.out.println("Enter a new password.");
                String password = scanner.next();
                System.out.println("What website is this for?");
                String website = scanner.next();
                passwordManager.put(website, password);
            } else if (checkEntry(entry, two)) {
                System.out.println("Type the website to find its password.");
                String website = scanner.next();
                System.out.println(passwordManager.get(website));
            } else if (checkEntry(entry, three)) {
                System.out.println("Type which website you want to delete from password.");
                String website = scanner.next();
                System.out.println(passwordManager.remove(website));
            } else if (checkEntry(entry, four)) {
                System.out.println("Type the duplicate password you want to check for.");
                String password = scanner.next();
                System.out.println(passwordManager.checkDuplicate(password));
            } else if (checkEntry(entry, five)) {
                System.out.println(passwordManager.keySet());
            } else if (checkEntry(entry, six)) {
                System.out.println("How long do you want your password?");
                int length = scanner.nextInt();
                System.out.println("New Password: " + passwordManager.generateRandomPassword(length));
            } else if (checkEntry(entry, seven)) {
                System.out.println("End of program.");
                loop = false;
            } else {
                System.out.println("Command not found");
            }
        }
    }

    private static boolean checkEntry(String scanner, String compare) {
        return compare.equalsIgnoreCase(scanner);
    }
}
