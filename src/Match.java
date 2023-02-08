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
        Scanner src=new Scanner(System.in);
        System.out.print("Enter Team1 Name: ");
        team1.setTeamName(src.next());
        System.out.println(team1.getTeamName());
        System.out.print("Enter Total Players in Team1: ");
        team1.setTotalPlayers(src.nextInt());
        for(int i=0;i<team1.getTotalPlayers();i++)
        {
            Player p1=new Player();
            p1.createPlayer();
            team1.listOfPlayers.add(p1);
        }
    }


    public void createTeam2() {
        team2 = new Team();
        Scanner src=new Scanner(System.in);
        System.out.print("Enter Team2 Name: ");
        team2.setTeamName(src.next());
        System.out.println(team2.getTeamName());
        System.out.print("Enter Total Players in Team2: ");
        team2.setTotalPlayers(src.nextInt());

        for(int i=0;i<team2.getTotalPlayers();i++)
        {
            Player p1=new Player();
            p1.createPlayer();
            team2.listOfPlayers.add(p1);
        }
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
        System.out.println("Start Match");
        System.out.print("Enter total number of overs: ");
        Scanner src = new Scanner(System.in);
        this.setOvers(src.nextInt());
        System.out.println("Create Team1");
        this.createTeam1();
        System.out.println("Create Team2");
        this.createTeam2();
        System.out.println("Toss " +
                "Time");
        System.out.println("Team1 has flip the coin");
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
        Player Bowler=BowlingTeam.listOfPlayers.get(0);
        int flag = 0;
        for (int overnum = 0; overnum < overs; overnum++) {
            for (int j = 0; j < 6; j++) {
                Bowler.incrementBallsBowled();
                int run = randomfunction();
                Ball nball=new Ball(overnum,j+1,Bowler,Striker,run);
                BattingTeam.BattingBalls.add(nball);
                //System.out.println(run);
                if (run == 7) {
                    Striker.incrementBallsFaced();
                    BattingTeam.incrementwicket();
                    Bowler.incrementWickets();
                    if (BattingTeam.getWicket() == 2)
                        {
                            flag = 1;
                            break;
                        }
                     else {
                        for (Player player : BattingTeam.listOfPlayers) {
                            if (Striker==player) {
                                player.outOrNot = true;
                                Striker = BattingTeam.getNewBatsman(nonStriker);
                                break;
                            }
                        }
                    }
                } else {
                    BattingTeam.incrementrun(run);
                    Striker.incrementrun(run);
                    Striker.incrementBallsFaced();
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
            int index=BowlingTeam.listOfPlayers.indexOf(Bowler);
            index++;
            index=index%(BowlingTeam.getTotalPlayers());
            Bowler=BowlingTeam.listOfPlayers.get(index);
            if (flag == 1) {
                break;
            }

        }

        Scoreboard nwScoreboard = new Scoreboard();
        nwScoreboard.printScoreboard(BattingTeam,BowlingTeam);
        BattingTeam.endInning();
        nwScoreboard.printBallStatus(BattingTeam);

        flag = 0;
        playerNumber1 = BowlingTeam.listOfPlayers.get(0);
        playerNumber2 = BowlingTeam.listOfPlayers.get(1);
        Striker = playerNumber1;
        nonStriker = playerNumber2;
        Bowler=BattingTeam.listOfPlayers.get(0);
        for (int overnum = 0; overnum < overs; overnum++) {
            for (int j = 0; j < 6; j++) {
                int run = randomfunction();
                Bowler.incrementBallsBowled();
                Ball nball=new Ball(overnum,j+1,Bowler,Striker,run);
                BowlingTeam.BattingBalls.add(nball);
                //System.out.println(run);
                if (run == 7) {
                    Striker.incrementBallsFaced();
                    BowlingTeam.incrementwicket();
                    Bowler.incrementWickets();
                    if (BowlingTeam.getWicket() == 2)
                        {
                            flag = 1;
                            break;
                        }
                     else {
                        for (Player player : BowlingTeam.listOfPlayers) {
                            if (player == Striker) {
                                Striker.outOrNot = true;
                                Striker = BowlingTeam.getNewBatsman(nonStriker);
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
                    Striker.incrementBallsFaced();
                    if (run % 2 == 1) {
                        Player temp = Striker;
                        Striker = nonStriker;
                        nonStriker = temp;
                        //Strike change.
                    } else {

                    }
                }
            }
            // changing the strike at over change.
            Player temp = Striker;
            Striker = nonStriker;
            nonStriker = temp;
            int index=BattingTeam.listOfPlayers.indexOf(Bowler);
            index++;
            index=index%(BattingTeam.getTotalPlayers());
            Bowler=BattingTeam.listOfPlayers.get(index);

            if (flag == 1) {
                break;
            }
        }

        nwScoreboard.printScoreboard(BowlingTeam,BattingTeam);
        BowlingTeam.endInning();
        nwScoreboard.printBallStatus(BowlingTeam);
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
        System.out.println("PRINT MATCH RESULT");
        if (team1.getFinalScore() > team2.getFinalScore()) {
            System.out.println("TEAM1 has won the match");
        } else if (team1.getFinalScore()<team2.getFinalScore()) {
            System.out.println("TEAM2 has won the match");

        } else {
            System.out.println("MATCH DRAWN");
        }

    }
}
