package console;
import java.util.Scanner;
public class createStudent {
    public static void createaccount(){
        boolean isLoop = true;
        while (isLoop) {
            Scanner s = new Scanner(System.in);
            line l = new line();
            System.out.println(l.l);
            System.out.println("Please Choose The Type Of Account To Be Created!!");
            System.out.println("1. Admin\n2. User\n3. Cancel");
            System.out.print(l.c);
            int Au = s.nextInt();
            if (Au == 1) {
                admin();
            } else if (Au == 2) {
                user();
            } else if (Au == 3) {
                isLoop =false;
            } else {
                System.out.println("Error Input!!");
            }
        }
    }
    public static void admin(){
        boolean isLoop = true;
        while(isLoop) {
            Scanner s = new Scanner(System.in);
            System.out.println("You Are Now Creating a Admin Account");
            System.out.print("Enter Username: ");
            String username = s.nextLine();
            System.out.print("Enter Password: ");
            String password = s.nextLine();
            System.out.print("Enter Email: ");
            String email = s.nextLine();
            System.out.println("Are You Sure You Inputted the correct credential? if yes Please Remember the Username and Password\n");
            System.out.println("Do You Accept The Terms And Agreement Regarding The Data You have provided\n");
            System.out.println("The Terms And Agreement stated that we collect information such as Emails, Account username, and password.\nThis information will be used for Logging in and accessing the function of this system application.\n Therefore, We will not be held responsible if other information or data contained in your project is lost\ndue to improper using or managing the data.");
            System.out.println("\nI Agree to The Terms and Agreement and I declare that I used legitimate Credential(Type yes)");
            System.out.println("I Do not Agree to the Terms and Agreement due to error on Credential / other reasons (Type no)");
            System.out.print(">> ");
            String confirm = s.nextLine();

            if (confirm.equals("yes") || confirm.equals("Yes") || confirm.equals("YES")) {
                DBconnection.CreateAccAdmin(username, password,email);
                System.out.println("You Have successfully created a new account!");
                isLoop = false;
            } else if (confirm.equals("no") || confirm.equals("No") || confirm.equals("NO")) {
                isLoop = false;
            }
        }
    }
    public static void user(){
        boolean isLoop = true;
        while(isLoop) {
            Scanner s = new Scanner(System.in);
            System.out.println("You Are Now Creating a User Account");
            System.out.print("Enter Username: ");
            String username = s.nextLine();
            System.out.print("Enter Password: ");
            String password = s.nextLine();
            System.out.print("Enter Email: ");
            String email = s.nextLine();
            System.out.println("Are You Sure You Inputted the correct credential? if yes Please Remember the Username and Password");
            System.out.println("Do You Accept The Terms And Agreement Regarding The Data You have provided");
            System.out.println("The Terms And Agreement stated that we collect information such as Emails, Account username, and password.\nThis information will be used for Logging in and accessing the function of this system application.\n Therefore, We will not be held responsible if other information or data contained in your project is lost\ndue to improper using or managing the data.");
            System.out.println("\nI Agree to The Terms and Agreement and I declare that I used legitimate Credential(Type yes)");
            System.out.println("I Do not Agree to the Terms and Agreement due to error on Credential / other reasons (Type no)");
            System.out.print(">> ");
            String confirm = s.nextLine();
            if (confirm.equals("yes") || confirm.equals("Yes") || confirm.equals("YES")) {
                DBconnection.CreateAccUser(username, password,email);
                System.out.println("You Have successfully created a new account!");
                isLoop = false;
            } else if (confirm.equals("no") || confirm.equals("No") || confirm.equals("NO")) {
                isLoop = false;
            }
        }
    }
}