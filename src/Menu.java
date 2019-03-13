import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Menu {

    Scanner keybord = new Scanner(System.in);
    TextWriterReader textWriterReader = new TextWriterReader();
    Map map = textWriterReader.readFromTsvMap();
    //System.out.println(map.get("101O10-1.0001.100"));
    boolean exit;

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.runMenu();
    }

    public void runMenu() {
        printHeader();
        while (!exit) {
            printMenu();
            int choise = getInput();
            performAction(choise);
        }
    }

    private void printHeader() {
        System.out.println("+-------------------+");
        System.out.println("| Welcom to Mr RS   |");
        System.out.println("|Avesome Search App   |");
        System.out.println("+-------------------+");
    }

    private void printMenu() {
        System.out.println("Please make a selection");
        System.out.println(" 1) search by ID. ");
        System.out.println(" 0) EXIT");
    }

    private int getInput() {
        int choise = -1;
        do {
            System.out.println("Enter your choice: ");
            try {
                choise = Integer.parseInt(keybord.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Number only please");
            }
            if (choise < 0 || choise > 4) {
                System.out.println("Choice outside of range. Please chose again");
            }
        } while (choise < 0 || choise > 4);

        return choise;
    }

    private void performAction(int choise) {
        switch (choise) {
            case 0:
                System.out.println("Thank you for using our application");
                System.exit(0);
                break;
            case 1:
                searchById();
                break;

            default:
                System.out.println("Unknown error has occured.");

        }
    }

    private String searchById() {
        Map map = textWriterReader.readFromTsvMap();
        System.out.println("Please provide your search word");
        String choise = keybord.nextLine();
        Set keys = map.keySet();
        for (int i=0; i<keys.size(); i++) {
            if(choise == keys.){

            } 
        }

        //System.out.println(map.get("101O10-1.0001.100"));
        return null;
    }

}

