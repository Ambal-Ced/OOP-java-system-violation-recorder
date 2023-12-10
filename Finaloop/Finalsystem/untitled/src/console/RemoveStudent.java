package console;
import java.util.Scanner;
public class RemoveStudent {
    private static boolean loopsies = true;
    public static void Remove() {
        loopsies = true;
        line l = new line();
        Scanner s = new Scanner(System.in);
        while (loopsies) {
            l.margin_top();
            l.margin_left("╔════════════════════════════════════════╗");
            l.margin_left("║          Remove Student Page           ║");
            l.margin_left("╚════════════════════════════════════════╝");
            l.margin_left_input("SR-CODE: ");
            String Srcode = s.nextLine();
            StudentInfo studentInfo = DBConnectionNew.getStudentInfo(Srcode);
            checker(Srcode);
            boolean exists = checker(Srcode);
            try {
                if (exists) {
                    l.clear();
                    l.margin_top();
                    l.margin_left("╔═════════════════════════════════════════════════════════╗");
                    l.margin_left("║                Student Information Found                ║");
                    l.margin_left("╠═════════════════════════════════════════════════════════╣");
                    l.margin_left(String.format("║ Student Name: %-41s ║", studentInfo.getFirstName() + " " + studentInfo.getMiddleName() + " " + studentInfo.getLastName()));
                    l.margin_left(String.format("║ Sr-Code: %-46s ║", Srcode));
                    l.margin_left("╚═════════════════════════════════════════════════════════╝");
    l.margin_left("Are You Sure You Want To Delete This Student? (Type y for confirmation)");
                    l.margin_left_input(">> ");
                    String Con1 = s.nextLine();
                    if ("y".equalsIgnoreCase(Con1)) {
                        l.margin_left("Are You Sure You Want To Delete This Student?");
                        l.margin_left_input(">> ");
                        String Con2 = s.nextLine();
                        if ("y".equalsIgnoreCase(Con2)) {
                            l.margin_left("All The Information Will Be Deleted On The Database. Do You Want To Continue?");
                            l.margin_left_input(">> ");
                            String Con3 = s.nextLine();
                            if ("y".equalsIgnoreCase(Con3)) {
                                l.margin_left("Please Confirm One More Time To Delete it Permanently!");
                                l.margin_left_input(">> ");
                                String Con4 = s.nextLine();
                                l.clear();
                                if ("y".equalsIgnoreCase(Con4)) {
                                    DBConnectionNew.DeleteStudent(Srcode);
                                    l.margin_left("Student Name: " + studentInfo.getFirstName() + " " + studentInfo.getMiddleName() + " " + studentInfo.getLastName());
                                    l.margin_left("Sr-Code: " + Srcode);
                                    l.margin_left("Has Been Deleted Successfully!!!");
                                    loopsies = false;
                                    l.pause_input();
                                } else if ("n".equalsIgnoreCase(Con4)) {
                                    loopsies = false;
                                } else {
                                    l.margin_left("Error Input!!");
                                    loopsies = true;
                                }
                            } else if ("n".equalsIgnoreCase(Con3)) {
                                loopsies = false;
                            } else {
                                l.margin_left("Error Input!!");
                                loopsies = true;
                            }
                        } else if ("n".equalsIgnoreCase(Con2)) {
                            loopsies = false;
                        } else {
                            l.margin_left("Error Input!!");
                            loopsies = true;
                        }
                    } else if ("n".equalsIgnoreCase(Con1)) {
                        loopsies = false;
                    } else {
                        l.margin_left("Error Input!!");
                        loopsies = true;
                    }
                } else {
                    l.clear();
                    l.margin_top();
                    l.margin_left("Student with SR-CODE " + Srcode + " not found.");
                    l.pause();
                    loopsies = false;
                }
            } catch (Exception e) {
            }
            
        }
    }

    public static boolean checker(String Srcode) {
        // Use the isSrCodeExist method from DBConnectionNew
        boolean exists = DBConnectionNew.isSrCodeExist(Srcode);

        if (exists) {
            System.out.println("SR-Code exists in the database.");
        } else {
            System.out.println("SR-Code does not exist in the database.");
        }

        return exists;
    }
}