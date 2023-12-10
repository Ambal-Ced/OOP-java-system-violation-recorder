package console;
import java.util.Scanner;

public class reqdatabase {
    private static boolean reqq =true;
    public static void reqdata(){
        reqq= true;
        line l = new line();
        Scanner s = new Scanner(System.in);
        String wr = "";
        while(reqq) {
            l.clear();
            l.margin_top();
            l.margin_left("╔════════════════════════════════════════════╗");
            l.margin_left("║            Welcome to Request              ║");
            l.margin_left("╠════════════════════════════════════════════╣");
            l.margin_left("║ 1. Write Request                           ║");
            l.margin_left("║ 2. Back                                    ║");
            l.margin_left("╚════════════════════════════════════════════╝");
            l.margin_left_input(">> ");
            wr = s.nextLine();
            if (wr.equals("1")) {
                l.clear();
                writedata.writesql();
            } else if (wr.equals("2")) {
                l.clear();
                reqq = false;
            } else {
                l.margin_left("Error Input!!");
            }
        }

    }
}
