package console;
import java.util.Scanner;
public class SelectVio {
    static int fromb;
    public void Violation(int fromb, String srCode) {
        line l = new line();
        Scanner s = new Scanner(System.in);
        if (fromb == 1) {
            l.clear();
            l.margin_top();
            l.margin_left("╔════════════════════════════════════════════╗");
            l.margin_left("║           Select Violation to Add          ║");
            l.margin_left("╠════════════════════════════════════════════╣");
            l.margin_left("║ 1. Improper Uniform                        ║");
            l.margin_left("║ 2. Improper Hair Cut                       ║");
            l.margin_left("║ 3. Violence                                ║");
            l.margin_left("║ 4. Smoking                                 ║");
            l.margin_left("║ 5. Possession of Alcohol                   ║");
            l.margin_left("║ 6. Disrespectful behavior                  ║");
            l.margin_left("║ 7. Back                                    ║");
            l.margin_left("╚════════════════════════════════════════════╝");
            l.margin_left_input(">> ");
        } else if (fromb == 2) {
            l.clear();
            l.margin_top();
            l.margin_left("╔════════════════════════════════════════════╗");
            l.margin_left("║          Select Violation to Edit          ║");
            l.margin_left("╠════════════════════════════════════════════╣");
            l.margin_left("║ 1. Improper Uniform                        ║");
            l.margin_left("║ 2. Improper Hair Cut                       ║");
            l.margin_left("║ 3. Violence                                ║");
            l.margin_left("║ 4. Smoking                                 ║");
            l.margin_left("║ 5. Possession of Alcohol                   ║");
            l.margin_left("║ 6. Disrespectful behavior                  ║");
            l.margin_left("║ 7. Back                                    ║");
            l.margin_left("╚════════════════════════════════════════════╝");
            l.margin_left_input(">> ");
        }
        String tbc = s.nextLine();
        if (tbc.equals("1") || tbc.equals("2") || tbc.equals("3") || tbc.equals("4") || tbc.equals("5") || tbc.equals("6") || tbc.equals("7")) {
            int AE = Integer.parseInt(tbc);
            String data = "";
            switch (AE) {
                case 1:
                    data = "Improper Uniform";
                    fixx(fromb, srCode, data);
                    break;
                case 2:
                    data = "Improper Hair Cut";
                    fixx(fromb, srCode, data);
                    break;
                case 3:
                    data = "Violence";
                    fixx(fromb, srCode, data);
                    break;
                case 4:
                    data = "Smoking";
                    fixx(fromb, srCode, data);
                    break;
                case 5:
                    data = "Possession of Alcohol";
                    fixx(fromb, srCode, data);
                    break;
                case 6:
                    data = "Disrespectful behavior";
                    fixx(fromb, srCode, data);
                    break;
                case 7:
                    break;
                default:
            }
        }
        else {
            l.margin_left("Error Input!!");
        }
        l.pause_input();
    }

    public static void fixx(int fromb, String srCode, String data){
            if (fromb == 1) {
                vieww(srCode, data);
            }
            if (fromb == 2) {
                debugg(srCode, data);
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
    
        l.margin_top();
        l.margin_left("╔════════════════════════════════════════════╗");
        l.margin_left("║             Select New Violation           ║");
        l.margin_left("╠════════════════════════════════════════════╣");
        l.margin_left("║ 1. Improper Uniform                        ║");
        l.margin_left("║ 2. Improper Hair Cut                       ║");
        l.margin_left("║ 3. Violence                                ║");
        l.margin_left("║ 4. Smoking                                 ║");
        l.margin_left("║ 5. Possession of Alcohol                   ║");
        l.margin_left("║ 6. Disrespectful behavior                  ║");
        l.margin_left("║ 7. Back                                    ║");
        l.margin_left("╚════════════════════════════════════════════╝");
        l.margin_left_input(">> ");
    
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
            l.margin_left("Error Input!!");
        }
        DBConnectionNew.Editvio(srCode, violationData, Datas);
        l.pause_input();
    }
    
}