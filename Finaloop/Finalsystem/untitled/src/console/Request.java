package console;
import java.util.Scanner;
public class Request {
    public static void requesta(){
        line l = new line();
        boolean loop = false;
        while(!loop) {
            Scanner s = new Scanner(System.in);
            l.clear();
            l.margin_top();
            l.margin_left("╔══════════════════════════════════════════════════╗");
            l.margin_left("║                 View Request Page                ║");
            l.margin_left("╠══════════════════════════════════════════════════╣");
            Dbconnectionre.req();
            try{
            l.margin_left("Enter the Unique ID of the Request you are Answering");
            l.margin_left("Press 0 to exit");
            l.margin_left_input(">> ");
            int als = s.nextInt();
            if (als == 0){
                loop = true;
            }
            else {
                boolean accject = false;
                while (!accject) {
                    String reqdata = Integer.toString(als);
                    l.clear();
                    l.margin_top();
                    l.margin_left("╔════════════════════════════════════════════╗");
                    l.margin_left("║     Accept or Reject Requested Changes?    ║");
                    l.margin_left("╠════════════════════════════════════════════╣");
                    l.margin_left("║ 1. Accept                                  ║");
                    l.margin_left("║ 2. Reject                                  ║");
                    l.margin_left("║ 3. Back                                    ║");
                    l.margin_left("╚════════════════════════════════════════════╝");
                    l.margin_left_input(">> ");
                    int choi = s.nextInt();
                    if (choi == 1) {
                        l.margin_left("You Have Accepted The Request");
                        Dbconnectionre.accept(reqdata);
                        accject = true;
                        l.pause();
                        l.clear();
                    } else if (choi == 2) {
                        l.margin_left("You Have Rejected The Request");
                        Dbconnectionre.reject(reqdata);
                        accject = true;
                        loop = true;
                        l.pause_input();
                        l.clear();
                    } else if (choi == 3) {
                        accject = true;
                        loop = true;
                        l.pause_input();
                    }
                }
            }
        }catch (Exception e){
            l.margin_left("Please Enter an integer\n");
            l.pause();
            s.nextLine(); 
            l.clear();
        }
        }
    }
}
