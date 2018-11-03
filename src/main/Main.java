package main;
import java.util.Scanner;
import javaMatic.JavaMatic;
public class Main {

	public static void main(String[] args) {
		JavaMatic javaMatic = new JavaMatic();
		Scanner scan = new Scanner(System.in);
		boolean done= false;
		while(!done) {
			javaMatic.printInventory();
			System.out.println();
			javaMatic.printMenu();
			System.out.println();
			System.out.println("Please type in a drink number, 'r' to  restock, or 'q' to quit");
			String command = "";
			while(command.replaceAll("\\s","").equals("")) {
				command= scan.nextLine();
			}
			if (command.equals("1") 
				|| command.equals("2")
				|| command.equals("3")
				|| command.equals("4")
				|| command.equals("5")
				|| command.equals("6")) {
				javaMatic.orderDrink(javaMatic.getMenu().get(Integer.parseInt(command)-1));
			} else if (command.equalsIgnoreCase("r")) {
				javaMatic.reStock();
			} else if (command.equalsIgnoreCase("q")) {
				done= true;
			} else if (!command.equals("")){
				System.out.println("Invalid selection: "+ command);
			}
		}
	}

}
