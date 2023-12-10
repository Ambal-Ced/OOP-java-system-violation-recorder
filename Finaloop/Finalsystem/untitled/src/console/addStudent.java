package console;
import java.util.Scanner;
public class addStudent {
    public static void add(){
        Scanner s = new Scanner(System.in);
        line l = new line();
        l.margin_top();
        l.margin_left("╔══════════════════════════════════════╗");
        l.margin_left("║           Add Student Page           ║");
        l.margin_left("╚══════════════════════════════════════╝");
        l.margin_left("Enter Last Name");
        l.margin_left_input(">> ");
        String lname = s.nextLine();
        l.margin_left("Enter First Name");
        l.margin_left_input(">> ");
        String fname = s.nextLine();
        l.margin_left("Enter Middle Name");
        l.margin_left_input(">> ");
        String mname = s.nextLine();
        l.margin_left("Sr-Code");
        l.margin_left_input(">> ");
        String SrCode = s.nextLine();
        
        l.margin_left("╔════════════════════════════════════════╗");
        l.margin_left("║ Are You Sure The Information Above Is  ║");
        l.margin_left("║             Correct? [Y/N]             ║");
        l.margin_left("╚════════════════════════════════════════╝");
        l.margin_left_input(">> ");
        String confirm = s.nextLine();

        if(confirm.equals("Y") || confirm.equals("y")){
            l.margin_left("Student Added");
            l.pause_input();
            DBConnectionNew.AddStudent(SrCode,fname,lname,mname);
        } else if (confirm.equals("N") || confirm.equals("n")) {
            l.margin_left("Adding Student Is Cancelled");
            l.pause_input();    
        } else{
            l.margin_left("Invalid Info");
            l.pause_input();
        }
    }
}