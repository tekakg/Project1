import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Team {
    private String teamName;
    private int totalPlayers;
    public List<Player> listOfPlayers = new ArrayList<>();
    //public int playerNumber;
    public List<Ball> BattingBalls = new ArrayList<>();//when Team is batting.
    public List<Ball> BowlingBalls = new ArrayList<>();// when Team is balling.
    private int score;
    private int wicket;
    public int overNumber;
    public int ballNumber;

    public void setTotalPlayers(int val)
    {
        this.totalPlayers=val;
    }
    public int getTotalPlayers()
    {
        return totalPlayers;
    }
    public void createTeam() {
    }
    public Player getNewBatsman(Player nonStriker) {
        Player nwPlayer=null;
        for (Player player : listOfPlayers) {
            if (player.outOrNot == false && player != nonStriker) {
                {
                    nwPlayer = player;
                    break;
                }
            }
        }
        return nwPlayer;
    }

    public void incrementrun(int run) {
        this.score += run;
    }

    public void incrementwicket() {
        this.wicket += 1;
    }


    public void endInning() {
        System.out.println("The Inning has ended");
        int finalrun = this.getFinalScore();
        System.out.println("The Score is " + finalrun);
    }

    public int getFinalScore() {
        return this.score;
    }
    public int getWicket(){
        return this.wicket;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
