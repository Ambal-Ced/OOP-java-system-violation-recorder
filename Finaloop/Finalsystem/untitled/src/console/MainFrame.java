package console;
import java.util.Scanner;
public class MainFrame { 
    public void Frames() {
        Boolean Isopen = true;
        
        Scanner s = new Scanner(System.in);
        line l = new line();
        while (Isopen) {
            l.clear();
            l.margin_top();
            l.margin_left("╔════════════════════════════════════════╗");
            l.margin_left("║           Super Account Mode           ║");
            l.margin_left("╠════════════════════════════════════════╣");
            l.margin_left("║ 1. View/Search Student Record          ║");
            l.margin_left("║ 2. Edit Record of Student              ║");
            l.margin_left("║ 3. View Request                        ║");
            l.margin_left("║ 4. Add a Student                       ║");
            l.margin_left("║ 5. Remove Student                      ║");
            l.margin_left("║ 6. Create Account                      ║");
            l.margin_left("║ 7. Exit                                ║");
            l.margin_left("╚════════════════════════════════════════╝");
            l.margin_left_input(">> ");
            try {
                String choice = s.nextLine();
                int ch = Integer.parseInt(choice);
                int value = 0;
                EnterSrcode es = new ValEnterSrcode(value);
                if (ch == 1) {
                    l.clear();
                    value = 1;
                    es.Srval(value);
                } else if (ch == 2) {
                    l.clear();
                    value = 2;
                    es.Srval(value);
                } else if (ch == 3) {
                    l.clear();
                    Request.requesta();
                } else if (ch == 4) {
                    l.clear();
                    addStudent.add();
                } else if (ch == 5) {
                    l.clear();
                    RemoveStudent.Remove();
                } else if (ch == 6) {
                    l.clear();
                    createStudent.createaccount();
                } else if (ch == 7) {
                    l.clear();
                    l.margin_top();
                    l.margin_left("╔═════════════════════════════════════════════╗");
                    l.margin_left("║   Do You Want To Go Back In Log In Or Exit  ║");
                    l.margin_left("║               The Application?              ║");
                    l.margin_left("╚═════════════════════════════════════════════╝");
                    l.margin_left("1. Log In");
                    l.margin_left("2. Exit");
                    l.margin_left_input(">> ");
                    int ex = s.nextInt();
                    try{
                        if(ex == 1){
                            Isopen = false;
                        } else if(ex == 2){
                            System.exit(0);
                        }
                    } catch(NumberFormatException e){
                        l.margin_left("Invalid Input!");
                    }

                } else {
                    l.margin_left("Invalid Input!");
                }
            } catch (NumberFormatException e) {
                l.clear();
                l.margin_left("Invalid input!!\n");
            }
        }

    }
    
}
