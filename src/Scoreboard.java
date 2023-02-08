import java.util.List;

public class Scoreboard {
    public List<Player> listOfPlayer;

    public void printScoreboard(Team BattingTeam, Team BowlingTeam) {
        System.out.println("+----------------------+----------+-------+----------+");
        System.out.println("|     Name             |    Role  | Runs  | Balls   |");
        System.out.println("+----------------------+----------+-------+----------+");
        for (Player p : BattingTeam.listOfPlayers) {
            System.out.println(String.format("| %-20s | %-8s | %5d | %8d |", p.getname(), p.getrole(), p.getplayerrun(), p.getBallsFaced()));
        }
        System.out.println("+----------------------+----------+-------+----------+");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("+----------------------+----------+---------+----------+");
        System.out.println("|     Name             |    Role  | Wickets | Balls    |");
        System.out.println("+----------------------+----------+---------+----------+");
        for (Player p : BowlingTeam.listOfPlayers) {
            System.out.println(String.format("| %-20s | %-8s | %7d | %6d |", p.getname(), p.getrole(), p.getWickets(), p.getBallsBowled()));
        }
        System.out.println("+----------------------+----------+-------+----------+");
        System.out.println();
        System.out.println();
        System.out.println();

    }
    public void printBallStatus(Team team)
    {
        System.out.println("+----------------------+---------------+--------+-----------+----------");
        System.out.println("|      OverNumber      |   BallNumber  |  Runs  |  Batsman  |  Bowler  |");
        System.out.println("+----------------------+---------------+--------+-----------+-----------");
        for (Ball b: team.BattingBalls) {
            System.out.println(String.format("| %-20d | %-13d | %6s | %9s | %9s |", b.getOverNumber(), b.getBallNumber()
                    , b.getRun(), b.getBatsman().getname(),b.getBowler().getname()));
        }
        System.out.println("+----------------------+---------------+--------+-----------+-----------");
        System.out.println();
        System.out.println();
        System.out.println();
    }

}
