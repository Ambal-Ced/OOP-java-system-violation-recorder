package console;
import java.util.Scanner;
public class Userframe {
    private static boolean activeframe = true;
    private static boolean ex = true;
    public void FramesUser(){
        activeframe = true; // to avoid the log-out then log-in back bug
        line l = new line();
        Scanner s = new Scanner(System.in);
        /* not done
        * view search
        * request changes
        * exit/logout
        * */
        while (activeframe) {
            int value = 0;
            l.clear();
            l.margin_top();
            l.margin_left("╔════════════════════════════════════════╗");
            l.margin_left("║              User Mode                 ║");
            l.margin_left("╠════════════════════════════════════════╣");
            l.margin_left("║ 1. View/Search Student                 ║");
            l.margin_left("║ 2. Request Changes                     ║");
            l.margin_left("║ 3. Exit/Logout                         ║");
            l.margin_left("╚════════════════════════════════════════╝");
            l.margin_left_input(">> ");
            String chh = s.nextLine();
            EnterSrcode es = new ValEnterSrcode(value);
            try{
                int as = Integer.parseInt(chh);
                if (as == 1){
                    value = 1;
                    l.clear();
                    es.Srval(value);
                } else if (as == 2) {
                    l.clear();
                    reqdatabase.reqdata();
                } else if (as == 3) {
                    l.clear();
                    while (ex){
                        l.margin_left("╔════════════════════════════════════════╗");
                        l.margin_left("║     Do you want to Log out or Exit?    ║");
                        l.margin_left("╠════════════════════════════════════════╣");
                        l.margin_left("║ 1. Log out                             ║");
                        l.margin_left("║ 2. Exit                                ║");
                        l.margin_left("╚════════════════════════════════════════╝");
                        l.margin_left_input(">> ");
                    String gh = s.nextLine();
                        if (gh.equals("1")){
                        ex = false;
                        activeframe = false;
                        l.clear();
                        } else if (gh.equals("2")) {
                        System.exit(0);
                        } else {
                        l.margin_left("Error Input");
                        }
                    }
                } else {
                    l.margin_left("Error Input!!");
                }
            }catch (Exception e){
                l.margin_left("Error input!!");
            }

        }
    }
}
