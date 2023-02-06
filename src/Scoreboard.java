import java.util.List;

public class Scoreboard {
    public List<Player> listOfPlayer;

    public void printScoreboard(Team team) {
        System.out.println("PlayerName"+" "+"PlayerRole"+" "+"PlayerScore"+" "+"PlayerBallsFaced");
        for (Player player : team.listOfPlayers) {
            System.out.println(player.getname()+" "+player.getrole()+" "+player.getplayerrun()+" "+player.getBallsFaced());
        }
        System.out.println();

    }
}
