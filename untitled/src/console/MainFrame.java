package console;
import java.util.Scanner;
public class MainFrame {
    private boolean Isopen = true;
    public void Frames() {
        Scanner s = new Scanner(System.in);
        line l = new line();
        while (Isopen) {
            System.out.println(l.l);
            System.out.println("1. View/Search Student Record");//done
            System.out.println("2. Edit Record of Student");//done
            System.out.println("3. View Request");//done
            System.out.println("4. Add a Student");//done
            System.out.println("5. Remove Student");//done
            System.out.println("6. Create Account");//done
            System.out.println("7. Exit");//done
            System.out.println(l.l);
            System.out.print(l.c);
            try {
                String choice = s.nextLine();
                int ch = Integer.parseInt(choice);
                int value = 0;
                EnterSrcode es = new ValEnterSrcode(value);
                if (ch == 1) {
                    value = 1;
                    es.Srval(value);
                } else if (ch == 2) {
                    value = 2;
                    es.Srval(value);
                } else if (ch == 3) {
                    Request.requesta();
                } else if (ch == 4) {
                    addStudent.add();
                } else if (ch == 5) {
                    RemoveStudent.Remove();
                } else if (ch == 6) {
                    createStudent.createaccount();
                } else if (ch == 7) {
                    System.out.println(l.l);
                    System.out.println("Do You Want To Go Back In Log In Or Exit The Application");
                    System.out.println("1. Log In");
                    System.out.println("2. Exit");
                    System.out.print(l.c);
                    System.out.println(l.l);
                    int ex = s.nextInt();
                    try{
                        if(ex == 1){
                            Isopen = false;
                        } else if(ex == 2){
                            System.exit(0);
                        }
                    } catch(NumberFormatException e){
                        System.out.println("Invalid Input!");
                    }

                } else {
                    System.out.println("Invalid Input!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!!");
            }
        }

    }
}
