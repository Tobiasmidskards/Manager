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

}