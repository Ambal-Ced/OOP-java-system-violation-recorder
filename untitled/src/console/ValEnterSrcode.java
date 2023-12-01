package console;
import java.util.Scanner;

public class ValEnterSrcode extends EnterSrcode {
    public ValEnterSrcode(int value) {
        super(value);
    }
    @Override
    public void Srval(int value) {
        Scanner s = new Scanner(System.in);
        int inheritedValue = getValue();
        String srCode;
        if(value == 1){
            System.out.println("You Are now in View And Add Violation Function! ");
        }
        if (value == 1) {
            System.out.print("ENTER SR-CODE: ");
            srCode = s.nextLine();
            if (DBConnectionNew.isSrCodeExist(srCode)) {
                // SrCode exists, proceed to ViewSearch
                ViewSearch viewSearch = new ViewSearch(inheritedValue);
                viewSearch.Srval(srCode,value);
            }
            else {
                System.out.println("SR-Code does not exist in the new database.");
            }
        }
        if (value == 2){
            System.out.println("You Are now in Editing Function!");
            System.out.print("ENTER SR-CODE: ");
            srCode = s.nextLine();
            if (DBConnectionNew.isSrCodeExist(srCode)) {

                ViewSearch viewSearch = new ViewSearch(inheritedValue);
                viewSearch.Srval(srCode,value);
            }
            else {
                System.out.println("SR-Code does not exist in the new database.");
            }
        }
        else
        {
            System.out.println("A bug probably occur please restart");
        }
    }
}