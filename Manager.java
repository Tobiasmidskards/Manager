import java.util.Arrays;

public class Manager{
    public static void main(String[] args) {
        DataController datacontroller = new DataController();
        datacontroller.loadTeamDB();

        System.out.println(datacontroller.getTeams().get(0).name);
    }

}