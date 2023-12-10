package console;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try{
            init();
        }catch (Exception e){
            //empty so nothing will show up
        }
        line l = new line();
        Scanner s = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            l.clear();
            l.margin_top();
            l.margin_left("╔══════════════════════════════╗");
            l.margin_left("║          Login Menu          ║");
            l.margin_left("╠══════════════════════════════╣");
            l.margin_left("║ 1. Log In                    ║");
            l.margin_left("║ 2. Exit                      ║");
            l.margin_left("╚══════════════════════════════╝");
            l.margin_left_input(">> ");

            String logChoice = s.nextLine();
            if (logChoice.equals("1")) {
                l.clear();
                login();
            } else if (logChoice.equals("2")) {
                System.exit(0);
                isActive = false;
            } else {
                System.out.println("Incorrect Choice");
            }
        }
    }

    static void init(){
        InitializeDatabase.initializes();
    }

    static void login() {
        line l = new line();
        MainFrame mf = new MainFrame();
        Scanner s = new Scanner(System.in);
        Userframe uf = new Userframe();
        System.out.println();
        while(true){
        l.clear();
        l.margin_top();
        l.margin_left("╔══════════════════════════════╗");
        l.margin_left("║          Login Page          ║");
        l.margin_left("╚══════════════════════════════╝");
        
        l.margin_left_input("Enter User Name: ");
        String username = s.nextLine();
        l.margin_left_input("Enter Password: ");
        String password = s.nextLine();
        if (DBconnection.isValidAdmin(username, password)) {
            l.clear();
            mf.Frames();
        }
        else if(DBconnection.isvalidUser(username,password)){
            l.clear();
            uf.FramesUser();
        }
        else {
            System.out.println("");
            l.margin_left("Invalid username or password.\n");
        }
    }
}
}
