package console;
import java.util.Scanner;
public class ViewSearch {
    public ViewSearch(int inheritedValue) {
    }
    public static void Srval(String srCode, int value) {
        line l = new line();
        if (DBConnectionNew.isSrCodeExist(srCode)) {
            StudentInfo studentInfo = DBConnectionNew.getStudentInfo(srCode);
            System.out.println(l.l);
            System.out.println("Student Sr-Code: "+srCode);
            System.out.println("Student Name: " + studentInfo.getLastName()+", "+ studentInfo.getFirstName() + " " + studentInfo.getMiddleName());
            System.out.println("Violation Info:");
            for (String violationInfo : studentInfo.getViolationInfoList()) {
                System.out.println("- " + violationInfo);
            }

            System.out.println(l.l);
            if(value == 1){
                addvio(srCode);
            }
            if(value == 2){
                editvio(srCode);
            }
        }
        else {
            System.out.println("Student with SrCode " + srCode + " not found.");
        }
    }
    public static void addvio(String srCode){
        boolean handler = true;
        while(handler) {
            Scanner s = new Scanner(System.in);
            line l = new line();
            System.out.println("1. Add Violation");
            System.out.println("2. Back");
            System.out.print(l.c);
            int choice_ = s.nextInt();
            if (choice_ == 1) {
                handler = false;
                SelectVio sv = new SelectVio();
                int fromb = 1;
                sv.Violation(fromb, srCode);//selectviolation
            }
            if (choice_ == 2) {
                handler = false;
            }
        }
    }
    public static void editvio(String srCode){
        boolean handler = true;
        while(handler) {
            Scanner s = new Scanner(System.in);
            line l = new line();
            System.out.println("1. Edit Violation");
            System.out.println("2. Back");
            System.out.print(l.c);
            int choice_ = s.nextInt();
            if (choice_ == 1) {
                handler = false;
                SelectVio sv = new SelectVio();
                int fromb = 2;
                sv.Violation(fromb, srCode);//selectviolation
            }
            if (choice_ == 2) {
                handler = false;
            }
        }
    }
}