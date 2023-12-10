package console;
import java.util.Scanner;
public class ViewSearch {
    public ViewSearch(int inheritedValue) {
    }
    public void Srval(String srCode, int value) {
        line l = new line();
        if (DBConnectionNew.isSrCodeExist(srCode)) {
            StudentInfo studentInfo = DBConnectionNew.getStudentInfo(srCode);
            l.clear();
            l.margin_top();
            l.margin_left("╔═════════════════════════════════════════════════════════╗");
            l.margin_left("║                       Result Found                      ║");
            l.margin_left("╠═════════════════════════════════════════════════════════╣");
            l.margin_left(String.format("║ Student Name: %-41s ║", studentInfo.getFirstName() + " " + studentInfo.getMiddleName() + " " + studentInfo.getLastName()));
            l.margin_left(String.format("║ Sr-Code: %-46s ║", srCode));
            l.margin_left("╚═════════════════════════════════════════════════════════╝");
            l.margin_left("╔═════════════════════════════════════════════════════════╗");
            l.margin_left("║                     Violation Info                      ║");
            l.margin_left("╠═════════════════════════════════════════════════════════╣");
            
            for (String violationInfo : studentInfo.getViolationInfoList()) {
                l.margin_left(String.format("║ - %-53s ║", violationInfo));
            }
            
            l.margin_left("╚═════════════════════════════════════════════════════════╝");
            l.pause();
            if(value == 1){
                addvio(srCode);
            }
            if(value == 2){
                editvio(srCode);
            }
        }
        else {
            l.margin_left("Student with SrCode " + srCode + " not found.");
        }
    }
    public static void addvio(String srCode){
        boolean handler = true;
        while(handler) {
            Scanner s = new Scanner(System.in);
            line l = new line();
            l.margin_left("╔═════════════════════════════════════════════════════════╗");
            l.margin_left("║                      Add Violation?                     ║");
            l.margin_left("╠═════════════════════════════════════════════════════════╣");
            l.margin_left("║ 1. Add Violation                                        ║");
            l.margin_left("║ 2. Back                                                 ║");
            l.margin_left("╚═════════════════════════════════════════════════════════╝");
            l.margin_left_input(">> ");
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
            l.margin_left("╔═════════════════════════════════════════════════════════╗");
            l.margin_left("║                     Edit Violation?                     ║");
            l.margin_left("╠═════════════════════════════════════════════════════════╣");
            l.margin_left("║ 1. Edit Violation                                       ║");
            l.margin_left("║ 2. Back                                                 ║");
            l.margin_left("╚═════════════════════════════════════════════════════════╝");
            l.margin_left_input(">> ");
            int choice_ = s.nextInt();
            if (choice_ == 1) {
                handler = false;
                SelectVio sv = new SelectVio();
                int fromb = 2;
                sv.Violation(fromb, srCode);//selectviolation
            }
            if (choice_ == 2) {
                handler = false;
                l.clear();
            }
        }
    }
}