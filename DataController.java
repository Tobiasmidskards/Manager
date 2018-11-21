import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataController{

	private ArrayList<Team> teams;
	private ArrayList<Player> players;

	public DataController(){
		teams = new ArrayList<Team>();
		players = new ArrayList<Player>();
		loadPlayerDB();
		loadTeamDB();
	}

	public void loadTeamDB(){
		String[] entry;
		Team team;
		String[] playerIDs;

		try {
			File tsv = new File("database/teamDB.tsv");

			if (!tsv.canRead()) {
				System.out.println("Cannot read from file");
			}

			Scanner scanner = new Scanner(tsv);
			entry = scanner.nextLine().split("\t");

			while(scanner.hasNext()){
				entry = scanner.nextLine().split("\t");

				team = new Team(entry[0], entry[1], entry[2]);
				playerIDs = entry[3].split(",");
				
				teams.add(team);
			}

			scanner.close();
		}
		catch (IOException e) {
			System.out.println(e);
		}

	}
	
	public void loadPlayerDB(){
		String[] entry;
		Player player;

		try {
			File tsv = new File("database/playerDB.tsv");

			if (!tsv.canRead()) {
				System.out.println("Cannot read from file");
			}

			Scanner scanner = new Scanner(tsv);
			entry = scanner.nextLine().split("\t");

			while(scanner.hasNext()){
				entry = scanner.nextLine().split("\t");

				player = new Player();
				player.setID(Integer.parseInt(entry[0]));
				player.setName(entry[1]);
				player.setCountry(entry[2]);
				player.setBirth(Integer.parseInt(entry[3]));
				players.add(player);
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

	public void printAllTeams(){
		System.out.print("\n");
        for (int i = 0; i<teams.size(); i++) {
			System.out.printf("%s: %s\t%s\t%s\n", i, teams.get(i).teamID, teams.get(i).name, teams.get(i).manager);
		}
		System.out.print("\n");
    }
}