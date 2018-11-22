public class UI{
	public UI(){
		
	}

	public void clear(){
		System.out.print("\033[H\033[2J");
	}

	public void top(){
		p("\n░░░▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓    MANAGER   ▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒░░░░\n");
	}

	public void bot(){
		p("\n░░░▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒░░░░\n");
	}

	public void mainMenu(boolean loggedIn){
		top();
		p("\nWelcome to Manager!\n");

		if(loggedIn) {
			p("\n1. Logout");
		} else {
			p("\n1. Login");
		}
		p("\n2. Exit\n");
		bot();
		input();
	}

	public void login(){
		top();
		p("\nPlease log in.\n");
	}

	public void logout(){
		top();
		p("\nYou are now logged out.\n");
	}

	public void input(){
		p("\n- ");
	}

	public void exit(){
		p("\n Bye!\n\n");
	}

	public void p(String print){
		System.out.print(print);
	}
}