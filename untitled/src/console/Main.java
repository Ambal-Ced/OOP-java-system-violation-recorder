package console;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            System.out.println("1. Log In");
            System.out.println("2. Exit");
            System.out.print(">> ");
            String logChoice = s.nextLine();
            if (logChoice.equals("1")) {
                login();
            } else if (logChoice.equals("2")) {
                System.exit(0);
                isActive = false;
            } else {
                System.out.println("Incorrect Choice");
            }
        }
    }

    static void login() {
        MainFrame mf = new MainFrame();
        Scanner s = new Scanner(System.in);
        Userframe uf = new Userframe();
        System.out.print("Enter User Name: ");
        String username = s.nextLine();
        System.out.print("Enter Password: ");
        String password = s.nextLine();
        if (DBconnection.isValidAdmin(username, password)) {
            System.out.println("You are logged in as an admin");
            mf.Frames();
        }
        else if(DBconnection.isvalidUser(username,password)){
            System.out.println("It exist the user");
            uf.FramesUser();//comming soon
        }
        else {
            System.out.println("Invalid username or password.");
        }
    }
}
