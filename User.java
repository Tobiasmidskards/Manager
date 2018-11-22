public class User{

	private String name;
	private String username;
	private String teamID;
	private boolean active;

	public User(){
		name = "";
		username = "";
		teamID = "";
		active = false;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setActive(boolean flag){
		active = flag;
	}

	public void setTeamID(String teamID){
		this.teamID = teamID;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public boolean getActive(){
		return active;
	}

	public String getName(){
		return name;
	}

	public String getTeamID(){
		return teamID;
	}

	public String getUsername(){
		return username;
	}

	
}