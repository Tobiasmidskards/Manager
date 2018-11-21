import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataController{

	private ArrayList<Team> teams;
	private ArrayList<Player> players;

	public DataController(){
		teams = new ArrayList<Team>();
		players = new ArrayList<Player>();
	}

	public void loadTeamDB(){
		String[] entry;
		Team team;

		try {
			File tsv = new File("database/teamDB.tsv");

			if (!tsv.canRead()) {
				System.out.println("Cannot read from file");
			}

			Scanner scanner = new Scanner(tsv);
			entry = scanner.nextLine().split("\t");

			while(scanner.hasNext()){
				entry = scanner.nextLine().split("\t");

				team = new Team(Integer.parseInt(entry[0]), entry[1], entry[2]);
				teams.add(team);
			}

			scanner.close();
		}
		catch (IOException e) {
			System.out.println(e);
		}

    }

    public void createTeam(){

	}
	
	public void createPlayer(){

	}

	public ArrayList<Team> getTeams(){
		return teams;
	}
}