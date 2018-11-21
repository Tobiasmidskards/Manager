import java.util.Scanner;
import java.io.*;

public class Menu{

	DataController datacontroller;
	MenuStates state;
	boolean exit;
	Scanner scanner;
	String input;
	UI ui;

	public Menu(){
		ui = new UI();
		ui.clear();
		datacontroller = new DataController();
		scanner = new Scanner(System.in);
		state = MenuStates.MAINMENU;
		exit = false;
		menu();
	}

	public void menu(){
		while(!exit){
			switch(state){
				case MAINMENU:
					menuDisplay();
					break;
				case LOGIN:
					loginDisplay();
					break;
				default:
					break;
			}
		}

		ui.exit();
	}

	public void menuDisplay() {
		ui.mainMenu(datacontroller.isLoggedIn());
		input = scanner.nextLine();
		switch(input){
			case "1":
				state = MenuStates.LOGIN;
				break;
			case "2":
				exit = true;
				break;
		}
	}

	public void myteamDisplay(){

	}

	public void loginDisplay(){
		if(datacontroller.isLoggedIn()) {
			ui.logout();
			datacontroller.logout();
		} else {
			ui.login();
			ui.p("\nUsername: ");
			String username = scanner.nextLine();
			ui.p("Password: ");
			String password = scanner.nextLine();
	
			if(datacontroller.login(username, password)){
				System.out.printf("\nHi %s! You are now logged in.\n", username);
			} else {
				ui.p("\nUsername/Password was incorrect. Try again!\n");
			}			
			
		}

		state = MenuStates.MAINMENU;
		promt();

	}

	public void promt(){
		Scanner scan = new Scanner(System.in);
		ui.p("\n[ENTER] to continue..\n\n");
		scan.nextLine();
	}
}