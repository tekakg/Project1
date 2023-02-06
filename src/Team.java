import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Team {
    String teamName;
    public final int totalPlayers = 3;
    List<Player> listOfPlayers = new ArrayList<>();
    //public int playerNumber;
    List<Ball> BattingBalls = new ArrayList<>();//when Team is batting.
    List<Ball> BowlingBalls = new ArrayList<>();// when Team is balling.
    public int score;
    public int wicket;
    public int overNumber;
    public int ballNumber;

    public void createTeam() {
    }


    public Player getPlayer(Player nonStriker) {
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

    public void callNextBatsman() {

    }

    public int getFinalScore() {
        return this.score;
    }

}
