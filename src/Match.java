import java.util.Collections;
import java.util.Scanner;
public class Match {
    private int overs;
    private Team team1;
    private Team team2;
    private Scoreboard scoreboard;

    public void setOvers(int overs) {
        this.overs = 4;
    }

    public int getOvers() {
        return overs;
    }

    public void createTeam1() {
        team1 = new Team();
        Player p1=new Player();
        p1.name="Aditya";
        p1.role="Batsman";
        p1.createPlayer();
        Player p2=new Player();
        p2.name="Arpit";
        p2.role="Batsman";
        p2.createPlayer();
        Player p3=new Player();
        p3.name="vivek";
        p3.role="bowler";
        p3.createPlayer();
        team1.listOfPlayers.add(p1);
        team1.listOfPlayers.add(p2);
        team1.listOfPlayers.add(p3);
    }


    public void createTeam2() {
        team2 = new Team();
        Player p1=new Player();
        p1.name="Sanny";
        p1.role="Batsman";
        p1.createPlayer();
        Player p2=new Player();
        p2.name="Apoorv";
        p2.role="Batsman";
        p2.createPlayer();
        Player p3=new Player();
        p3.name="Aman";
        p3.role="bowler";
        p3.createPlayer();
        team2.listOfPlayers.add(p1);
        team2.listOfPlayers.add(p2);
        team2.listOfPlayers.add(p3);
    }

    public int toss() {
        int tossResult = (int) (Math.random() * 2);
        if(tossResult==0)
        {
            System.out.println("Team1 has won the toss and elected to bat first");
        }
        else
        {
            System.out.println("Team2 has won the toss and elected to bat first");
        }
        return tossResult;
    }

    public void startMatch() {
        System.out.println("Enter total number of overs");
        Scanner src = new Scanner(System.in);
        this.setOvers(src.nextInt());
        System.out.println("Create Team1");
        this.createTeam1();
        System.out.println("Create Team2");
        this.createTeam2();
        System.out.println("Toss " +
                "Time");
        int tossResult = this.toss();
        if (tossResult == 0) {
            this.playMatch(team1, team2);
        } else if (tossResult == 1) {
            this.playMatch(team2, team1);
        }
    }

    public void playMatch(Team BattingTeam, Team BowlingTeam) {
        Player playerNumber1 = BattingTeam.listOfPlayers.get(0);
        Player playerNumber2 = BattingTeam.listOfPlayers.get(1);
        Player Striker = playerNumber1;
        Player nonStriker = playerNumber2;
        int flag = 0;
        for (int overnum = 0; overnum < overs; overnum++) {
            for (int j = 0; j < 6; j++) {
                int run = randomfunction();
                System.out.println(run);
                if (run == 7) {
                    Striker.incrementBalls();
                    BattingTeam.incrementwicket();
                    if (BattingTeam.wicket == 2)
                        {
                            flag = 1;
                            break;
                        }
                     else {
                        for (Player player : BattingTeam.listOfPlayers) {
                            if (Striker==player) {
                                player.outOrNot = true;
                                Striker = BattingTeam.getPlayer(nonStriker);
                                break;
                            }
                        }
                    }
                } else {
                    BattingTeam.incrementrun(run);
                    Striker.incrementrun(run);
                    Striker.incrementBalls();
                    if (run % 2 == 1) {
                        Player temp = Striker;
                        Striker = nonStriker;
                        nonStriker = temp;
                        //Strike change.
                    } else {

                    }
                }
            }
            Player temp = Striker;
            Striker = nonStriker;
            nonStriker = temp;
            if (flag == 1) {
                break;
            }

        }
        BattingTeam.endInning();
        Scoreboard nwScoreboard = new Scoreboard();
        nwScoreboard.printScoreboard(BattingTeam);
        flag = 0;
        playerNumber1 = BowlingTeam.listOfPlayers.get(0);
        playerNumber2 = BowlingTeam.listOfPlayers.get(1);
        Striker = playerNumber1;
        nonStriker = playerNumber2;
        for (int overnum = 0; overnum < overs; overnum++) {
            for (int j = 0; j < 6; j++) {
                int run = randomfunction();
                System.out.println(run);
                if (run == 7) {
                    Striker.incrementBalls();
                    BowlingTeam.incrementwicket();
                    if (BowlingTeam.wicket == 2)
                        {
                            flag = 1;
                            break;
                        }
                     else {
                        for (Player player : BowlingTeam.listOfPlayers) {
                            if (player == Striker) {
                                Striker.outOrNot = true;
                                Striker = BattingTeam.getPlayer(nonStriker);
                                break;
                            }
                        }
                    }
                } else {
                    if(BowlingTeam.getFinalScore()> BattingTeam.getFinalScore())
                    {
                        flag=1;
                        break;
                    }
                    BowlingTeam.incrementrun(run);
                    Striker.incrementrun(run);
                    Striker.incrementBalls();
                    if (run % 2 == 1) {
                        Player temp = Striker;
                        Striker = nonStriker;
                        nonStriker = temp;
                        //Strike change.
                    } else {

                    }
                }
            }
            Player temp = Striker;
            Striker = nonStriker;
            nonStriker = temp;

            if (flag == 1) {
                break;
            }
        }
        BowlingTeam.endInning();
        nwScoreboard.printScoreboard(BowlingTeam);
        this.MatchResult();
    }

    public int randomfunction() {
        int val = (int)(Math.random() * 100);
        if (val >90) {
            return 7;
        } else {
            int runval = (int) (Math.random() * 7);
            return runval;
        }
    }

    public void printScoreboard() {
        //later
    }

    public void MatchResult() {
        if (team1.getFinalScore() > team2.getFinalScore()) {
            System.out.println("team1 has won the match");
        } else if (team1.getFinalScore()<team2.getFinalScore()) {
            System.out.println("team2 has won the match");

        } else {
            System.out.println("Match Draw");
        }

    }
}
