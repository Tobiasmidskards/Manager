public class Player{
    String name, country;
    int birth;
    int height;
    int playerID;

    int[] abillities;
    String position, leg;

    int value;

    public Player() {
        this.name = "";
        this.country = "";
        this.birth = -1;
        this.abillities = new int[0];
        this.value = 0;
        this.position = "NA";
        this.leg = "NA";
        this.height = 0;
        this.playerID = -1;
    }

    public void setID(int playerID){
        this.playerID = playerID;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setBirth(int birth){
        this.birth = birth;
    }

}