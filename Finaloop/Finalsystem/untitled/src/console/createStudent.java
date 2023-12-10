package console;
import java.util.Scanner;
public class createStudent {
    public static void createaccount(){
        boolean isLoop = true;
        while (isLoop) {
            Scanner s = new Scanner(System.in);
            line l = new line();
            l.margin_top();
            l.margin_left("╔════════════════════════════════════════╗");
            l.margin_left("║  Choose Type of Account to Be Created  ║");
            l.margin_left("╠════════════════════════════════════════╣");
            l.margin_left("║ 1. Admin                               ║");
            l.margin_left("║ 2. User                                ║");
            l.margin_left("║ 3. Cancel                              ║");
            l.margin_left("╚════════════════════════════════════════╝");
            l.margin_left_input(">> ");
            int Au = s.nextInt();
            if (Au == 1) {
                l.clear();
                admin();
            } else if (Au == 2) {
                l.clear();
                user();
            } else if (Au == 3) {
                isLoop =false;
            } else {
                l.margin_left("Error Input!!");
            }
        }
    }
    public static void admin(){
        line l = new line();
        boolean isLoop = true;
        while(isLoop) {
            Scanner s = new Scanner(System.in);
            l.margin_left("╔════════════════════════════════════════╗");
            l.margin_left("║        Admin Account Creation          ║");
            l.margin_left("╚════════════════════════════════════════╝");
            l.margin_left_input("Enter Username: ");
            String username = s.nextLine();
            l.margin_left_input("Enter Password: ");
            String password = s.nextLine();
            l.margin_left_input("Enter Email: ");
            String email = s.nextLine();
            l.margin_left("Are You Sure You Inputted the correct credential? if yes Please Remember the Username and Password");
            l.margin_left("Do You Accept The Terms And Agreement Regarding The Data You have provided");
            l.margin_left("The Terms And Agreement stated that we collect information such as Emails, Account username, and password."); 
            l.margin_left("This information will be used for Logging in and accessing the function of this system application.");
            l.margin_left("Therefore, We will not be held responsible if other information or data contained in your project is lost");
            l.margin_left("due to improper using or managing the data");
            System.out.println("");
            l.margin_left("I Agree to The Terms and Agreement and I declare that I used legitimate Credential(Type yes)");
            l.margin_left("I Do not Agree to the Terms and Agreement due to error on Credential / other reasons (Type no)");
            l.margin_left_input(">> ");
            String confirm = s.nextLine();

            if (confirm.equals("yes") || confirm.equals("Yes") || confirm.equals("YES")) {
                DBconnection.CreateAccAdmin(username, password,email);
                System.out.println("You Have successfully created a new account!");
                isLoop = false;
                l.pause();
                l.clear();
            } else if (confirm.equals("no") || confirm.equals("No") || confirm.equals("NO")) {
                isLoop = false;
                l.pause();
                l.clear();
            }
        }
    }
    public static void user(){
        boolean isLoop = true;
        while(isLoop) {
            line l = new line();
            Scanner s = new Scanner(System.in);
            l.margin_left("╔════════════════════════════════════════╗");
            l.margin_left("║         User Account Creation          ║");
            l.margin_left("╚════════════════════════════════════════╝");
            l.margin_left_input("Enter Username: ");
            String username = s.nextLine();
            l.margin_left_input("Enter Password: ");
            String password = s.nextLine();
            l.margin_left_input("Enter Email: ");
            String email = s.nextLine();
            l.margin_left("Are You Sure You Inputted the correct credential? if yes Please Remember the Username and Password");
            l.margin_left("Do You Accept The Terms And Agreement Regarding The Data You have provided");
            l.margin_left("The Terms And Agreement stated that we collect information such as Emails, Account username, and password."); 
            l.margin_left("This information will be used for Logging in and accessing the function of this system application.");
            l.margin_left("Therefore, We will not be held responsible if other information or data contained in your project is lost");
            l.margin_left("due to improper using or managing the data");
            System.out.println("");
            l.margin_left("I Agree to The Terms and Agreement and I declare that I used legitimate Credential(Type yes)");
            l.margin_left("I Do not Agree to the Terms and Agreement due to error on Credential / other reasons (Type no)");
            l.margin_left_input(">> ");
            String confirm = s.nextLine();
            if (confirm.equals("yes") || confirm.equals("Yes") || confirm.equals("YES")) {
                DBconnection.CreateAccUser(username, password,email);
                l.margin_left("You Have successfully created a new account!");
                isLoop = false;
                l.pause();
                l.clear();
            } else if (confirm.equals("no") || confirm.equals("No") || confirm.equals("NO")) {
                isLoop = false;
                l.pause();
                l.clear();
            }
        }
    }
}