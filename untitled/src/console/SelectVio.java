package console;
import java.util.Scanner;
public class SelectVio {
    static int fromb;
    public static void Violation(int fromb, String srCode) {
        line l = new line();
        Scanner s = new Scanner(System.in);
        if (fromb == 1) {
            System.out.println("Select Violation to Be Added");
        } else if (fromb == 2) {
            System.out.println("Select Violation to Be Edit");
        }
        System.out.println(l.l);
        System.out.println("1. Improper Uniform");
        System.out.println("2. Improper Hair Cut");
        System.out.println("3. Violence");
        System.out.println("4. Smoking");
        System.out.println("5. Possession of Alcohol");
        System.out.println("6. Disrespectful behavior");
        System.out.println("7. Back");
        System.out.println(l.l);
        System.out.print(l.c);
        String tbc = s.nextLine();
        if (tbc.equals("1") || tbc.equals("2") || tbc.equals("3") || tbc.equals("4") || tbc.equals("5") || tbc.equals("6") || tbc.equals("7")) {
            int AE = Integer.parseInt(tbc);
            String data = "";
            switch (AE) {
                case 1:
                    data = "Improper Uniform";
                    break;
                case 2:
                    data = "Improper Hair Cut";
                    break;
                case 3:
                    data = "Violence";
                    break;
                case 4:
                    data = "Smoking";
                    break;
                case 5:
                    data = "Possession of Alcohol";
                    break;
                case 6:
                    data = "Disrespectful behavior";
                    break;
                case 7:
                    break;
                default:
            }
            if (fromb == 1) {
                vieww(srCode, data);
            }
            if (fromb == 2) {
                debugg(srCode, data);
            }
        }
        else {
            System.out.println("Error Input!!");
        }
    }
    public static void debugg(String srCode, String data){
        String Datas = "null";
            editt(srCode, data, Datas);
    }
    public static void vieww(String srCode, String violationData) {
        DBConnectionNew.Insertvio(srCode, violationData);
    }
    public static void editt(String srCode, String violationData, String Datas) {
        line l = new line();
        Scanner s = new Scanner(System.in);
        System.out.println(l.l);
        System.out.println("1. Improper Uniform");
        System.out.println("2. Improper Hair Cut");
        System.out.println("3. Violence");
        System.out.println("4. Smoking");
        System.out.println("5. Possession of Alcohol");
        System.out.println("6. Disrespectful behavior");
        System.out.println("7. Back");
        System.out.println(l.l);
        System.out.print(l.c);
        String tb = s.nextLine();
        if (tb.equals("1") || tb.equals("2") || tb.equals("3") || tb.equals("4") || tb.equals("5") || tb.equals("6") || tb.equals("7")) {
            int AE = Integer.parseInt(tb);
            switch (AE) {
                case 1:
                    Datas = "Improper Uniform";
                    break;
                case 2:
                    Datas = "Improper Hair Cut";
                    break;
                case 3:
                    Datas = "Violence";
                    break;
                case 4:
                    Datas = "Smoking";
                    break;
                case 5:
                    Datas = "Possession of Alcohol";
                    break;
                case 6:
                    Datas = "Disrespectful behavior";
                    break;
                case 7:
                    break;
                default:
            }
        } else {
            System.out.println("Error Input!!");
        }
        DBConnectionNew.Editvio(srCode, violationData, Datas);
    }
}