import java.util.Scanner;

public class TextUI {
    public static void main(String[] args){
        //New Grid
        Grid grid = new Grid();
        //Scanner
        Scanner scanner = new Scanner(System.in);
        //If not exit, keep playing.
        boolean playing = true;
        String command;
        while(playing){
            //Show Grid in console
            grid.showTextUI();
            //User input
            command = scanner.nextLine();
            if(command.equals("exit")){
                break;
            }else{
                grid.controller(command);
            }
        }
    }
}
