import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataController{

	private ArrayList<Team> teams;
	private User user;

	public DataController(){
		teams = new ArrayList<Team>();
		user = new User();
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

				for (String p : playerIDs) {
					team.addPlayer(searchPlayerDB(p));
				}

				teams.add(team);
			}

			scanner.close();
		}
		catch (IOException e) {
			System.out.println(e);
		}

	}
	
	public Player searchPlayerDB(String playerID){
		String[] entry;
		Player player = new Player();

		try {
			File tsv = new File("database/playerDB.tsv");

			if (!tsv.canRead()) {
				System.out.println("Cannot read from file");
			}

			Scanner scanner = new Scanner(tsv);
			entry = scanner.nextLine().split("\t");

			while(scanner.hasNext()){
				entry = scanner.nextLine().split("\t");

				if (playerID.equals(entry[0])) {
					player.setID(Integer.parseInt(entry[0]));
					player.setName(entry[1]);
					player.setCountry(entry[2]);
					player.setBirth(Integer.parseInt(entry[3]));
				}
			}

			scanner.close();
		}
		catch (IOException e) {
			System.out.println(e);
		}

		return player;

	}
	
	public boolean login(String username, String password){
		String[] entry;

		try {
			File tsv = new File("database/userDB.tsv");

			if (!tsv.canRead()) {
				System.out.println("Cannot read from file");
			}

			Scanner scanner = new Scanner(tsv);
			entry = scanner.nextLine().split("\t");

			while(scanner.hasNext()){
				entry = scanner.nextLine().split("\t");

				if (username.equals(entry[2]) && password.equals(entry[3])) {
					user.setTeamID(entry[0]);
					user.setName(entry[1]);
					user.setUsername(entry[2]);
					user.setActive(true);

					return true;
				}
			}

			scanner.close();
		}
		catch (IOException e) {
			System.out.println(e);
		}
		return false;
	}

	public void logout(){
		user = new User();
	}

	public String getActiveUser(){
		if(isLoggedIn()){
			return user.getName();
		} else {
			return "no user logged in";
		}
	}

	public String getActiveTeamID(){
		if(isLoggedIn()){
			return user.getTeamID();
		} else {
			return "no user logged in";
		}
	}

	public boolean isLoggedIn(){
		if(user.getActive()){
			return true;
		} else {
			return false;
		}
	}

	public void printTeam(String teamID){
		System.out.print("\n");
		for(Team t : teams){
			if(t.getTeamID().equals(teamID)){
				System.out.printf("%s\t%s\nPlayers:\n", t.getName(), t.getManager());

				for (int j = 0; j<t.getPlayers().size(); j++) {
					System.out.printf("%s\n", t.getPlayers().get(j).getName());
				}
			}
		}
	}

	public void printAllTeams(){
		System.out.print("\n");
        for (int i = 0; i<teams.size(); i++) {
			System.out.printf("%s: %s\t%s\t%s\nPlayers:\n", i, teams.get(i).getTeamID(), teams.get(i).getName(), teams.get(i).getManager());

			for (int j = 0; j<teams.get(i).getPlayers().size(); j++) {
				System.out.printf("%s\n", teams.get(i).getPlayers().get(j).getName());
			}

			System.out.print("\n");
			
		}
		System.out.print("\n");
    }
}