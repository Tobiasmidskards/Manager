import java.util.ArrayList;

public class Team{
    private String name;
    private String manager;
    private ArrayList<Player> players;
    private String teamID;

    public Team(String teamID, String name, String manager){
        this.name = name;
        this.manager = manager;
        this.teamID = teamID;
        this.players = new ArrayList<Player>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public String getName(){
        return name;
    }

    public String getManager(){
        return manager;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public String getTeamID(){
        return teamID;
    }
}