package console;
import java.util.Scanner;
public class RemoveStudent {
    private static boolean loops = true;
    public static void Remove() {
        line l = new line();
        Scanner s = new Scanner(System.in);
        while (loops) {
            System.out.println("Remove student. Please type the Sr-Code of the Student and confirm it");
            System.out.print("SR-CODE: ");
            String Srcode = s.nextLine();
            System.out.println(l.l);
            StudentInfo studentInfo = DBConnectionNew.getStudentInfo(Srcode);
            if (studentInfo != null) {
                System.out.println("Student Name: " + studentInfo.getFirstName() + " " + studentInfo.getMiddleName() + " " + studentInfo.getLastName());
                System.out.println("Sr-Code: " + Srcode);
            } else {
                System.out.println("Student with SR-CODE " + Srcode + " not found.");
                continue;
            }
            System.out.println(l.l);
            System.out.println("Are You Sure You Want To Delete This Student? (Type y for confirmation)");
            System.out.print(l.c);
            String Con1 = s.nextLine();
            System.out.println(l.l);
            if ("y".equalsIgnoreCase(Con1)) {
                System.out.println("Are You Sure You Want To Delete This Student?");
                System.out.print(l.c);
                String Con2 = s.nextLine();
                System.out.println(l.l);
                if ("y".equalsIgnoreCase(Con2)) {
                    System.out.println("All The Information Will Be Deleted On The Database. Do You Want To Continue?");
                    System.out.print(l.c);
                    String Con3 = s.nextLine();
                    System.out.println(l.l);
                    if ("y".equalsIgnoreCase(Con3)) {
                        System.out.println("Please Confirm One More Time To Delete it Permanently!");
                        System.out.print(l.c);
                        String Con4 = s.nextLine();
                        System.out.println(l.l);
                        if ("y".equalsIgnoreCase(Con4)) {
                            DBConnectionNew.DeleteStudent(Srcode);
                            System.out.println("Student Name: " + studentInfo.getFirstName() + " " + studentInfo.getMiddleName() + " " + studentInfo.getLastName());
                            System.out.println("Sr-Code: " + Srcode);
                            System.out.println("Has Been Deleted Successfully!!!");
                            loops = false;
                        } else if ("n".equalsIgnoreCase(Con4)) {
                            loops = false;
                        } else {
                            System.out.println("Error Input!!");
                            loops = true;
                        }
                    } else if ("n".equalsIgnoreCase(Con3)) {
                        loops = false;
                    } else {
                        System.out.println("Error Input!!");
                        loops = true;
                    }
                } else if ("n".equalsIgnoreCase(Con2)) {
                    loops = false;
                } else {
                    System.out.println("Error Input!!");
                    loops = true;
                }
            } else if ("n".equalsIgnoreCase(Con1)) {
                loops = false;
            } else {
                System.out.println("Error Input!!");
                loops = true;
            }
        }
    }
}