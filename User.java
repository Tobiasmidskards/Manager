public class User{

	private String username;
	private String password;
	private String teamID;

	public User(){
		username = "";
		password = "";
		teamID = "";
	}

	public void setTeamID(String teamID){
		this.teamID = teamID;
	}

	public String getTeamID(){
		return teamID;
	}

	public String getUsername(){
		return username;
	}

	
}