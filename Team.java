import java.util.ArrayList;

public class Team{
    String name;
    String manager;
    ArrayList<Player> players;
    String teamID;

    public Team(String teamID, String name, String manager){
        this.name = name;
        this.manager = manager;
        this.teamID = teamID;
        this.players = new ArrayList<Player>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}