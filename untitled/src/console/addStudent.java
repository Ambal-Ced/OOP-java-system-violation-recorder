package console;
import java.util.Scanner;
public class addStudent {
    public static void add(){
        Scanner s = new Scanner(System.in);
        line l = new line();
        System.out.println(l.l);
        System.out.println("Enter Last Name");
        System.out.print(l.c);
        String lname = s.nextLine();
        System.out.println("Enter First Name");
        System.out.print(l.c);
        String fname = s.nextLine();
        System.out.println("Enter Middle Name");
        System.out.print(l.c);
        String mname = s.nextLine();
        System.out.println("Sr-Code");
        System.out.print(l.c);
        String SrCode = s.nextLine();
        System.out.println(l.l);
        System.out.println("Are You Sure The Information Above Is Correct? Y/N");
        System.out.print(l.c);
        String confirm = s.nextLine();
        if(confirm.equals("Y") || confirm.equals("y")){
            System.out.println("Student Added");
        DBConnectionNew.AddStudent(SrCode,fname,lname,mname);
        } else if (confirm.equals("N") || confirm.equals("n")) {
            System.out.println("Adding Student Is Cancelled");
        } else{
            System.out.println("Invalid Info");
        }
    }
}