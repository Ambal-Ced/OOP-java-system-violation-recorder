package console;
import java.util.Scanner;

public class ValEnterSrcode extends EnterSrcode {
    public ValEnterSrcode(int value) {
        super(value);
    }
    @Override
    public void Srval(int value) {
        MainFrame m = new MainFrame();
        line l = new line();
        Scanner s = new Scanner(System.in);
        char choice;
        int inheritedValue = getValue();
        String srCode;
        if (value == 1) {
            l.margin_top();
            l.margin_left("╔═════════════════════════════════════════════════╗");
            l.margin_left("║          View/Search Student Record Page        ║");
            l.margin_left("╚═════════════════════════════════════════════════╝");
            l.margin_left_input("ENTER SR-CODE: ");
            srCode = s.nextLine();
            if (DBConnectionNew.isSrCodeExist(srCode)) {
                // SrCode exists, proceed to ViewSearch
                ViewSearch viewSearch = new ViewSearch(inheritedValue);
                viewSearch.Srval(srCode,value);
            }
            else {
                l.margin_left("SR-Code does not exist in the new database.");
                l.pause_input();
                l.clear();
                m.Frames();
            }
        }
        if (value == 2){
            l.margin_top();
            l.margin_left("╔════════════════════════════════════════════════╗");
            l.margin_left("║           Edit Record of Student Page          ║");
            l.margin_left("╚════════════════════════════════════════════════╝");
            l.margin_left_input("ENTER SR-CODE: ");
            srCode = s.nextLine();
            if (DBConnectionNew.isSrCodeExist(srCode)) {

                ViewSearch viewSearch = new ViewSearch(inheritedValue);
                viewSearch.Srval(srCode,value);
            }
            else {
                l.margin_left("SR-Code does not exist in the new database.");
                l.pause_input();
                l.clear();
                m.Frames();
            }
        }
        else {}//in case there is an error
    }
}