package console;
public class line {

    public void margin_left(String text){
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + text);
    }
    public void emp(){
        System.out.print("");
    }

    public void margin_left_input(String text){
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + text);
    }

    public void margin_top(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    public void pause(){
        margin_left("Press Enter to continue... ");
        try{
            System.in.read();
        }  
        catch(Exception e){

        }  
    }

    public void pause_input(){
        margin_left_input("Press Enter to go back to Homepage... ");
        try{
            System.in.read();
        }  
        catch(Exception e){

        }  
    }

    public void clear(){
        try {
            final String os = System.getProperty("os.name");

            ProcessBuilder processBuilder;

            if (os.contains("Windows")) {
                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            } else {
                processBuilder = new ProcessBuilder("clear");
            }

            processBuilder.inheritIO().start().waitFor();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public String formatString(String input, int width) {
        if (input.length() > width) {
            return input.substring(0, width - 4) + "...";
        } else {
            return String.format("%-" + width + "s", input);
        }
    }
}
