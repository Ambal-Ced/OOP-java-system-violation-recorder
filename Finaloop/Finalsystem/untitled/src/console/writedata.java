package console;
import java.util.Scanner;
public class writedata {

    public static void writesql(){
        line l = new line();
        Scanner s = new Scanner(System.in);
        l.margin_left("╔════════════════════════════════════════════╗");
        l.margin_left("║          Write Your Request Here           ║");
        l.margin_left("╚════════════════════════════════════════════╝");
        l.margin_left_input(">> ");
        String query = s.nextLine();
        l.margin_left("Request Submitted");
        l.pause();
        l.clear();
            Dbconnectionre.insertreq(query);
    }
}
