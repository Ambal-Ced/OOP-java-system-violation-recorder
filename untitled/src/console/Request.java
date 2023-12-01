package console;
import java.util.Scanner;
public class Request {
    public static void requesta(){
        line l = new line();
        boolean loop = false;
        while(!loop) {
            Scanner s = new Scanner(System.in);
            System.out.println(l.l);
            Dbconnectionre.req();
            System.out.println("0 for Exit");
            System.out.println(l.l);
            System.out.println("Enter the Unique ID of the Request you are Answering");
            System.out.print(l.c);
            int als = s.nextInt();
            if (als == 0){
                loop = true;
            }
            else {
                boolean accject = false;
                while (!accject) {
                    String reqdata = Integer.toString(als);
                    System.out.println(l.l);
                    System.out.println("Do You Accept the Requested Changes or Reject it");
                    System.out.println("1. Accept");
                    System.out.println("2. Reject");
                    System.out.println("3. Back");
                    System.out.print(l.c);
                    int choi = s.nextInt();
                    if (choi == 1) {
                        System.out.println("You Have Accepted The Request");
                        Dbconnectionre.accept(reqdata);
                        accject = true;
                    } else if (choi == 2) {
                        System.out.println("You Have Rejected The Request");
                        Dbconnectionre.reject(reqdata);
                        accject = true;
                        loop = true;
                    } else if (choi == 3) {
                        accject = true;
                        loop = true;
                    }
                }
            }
        }
    }
}
