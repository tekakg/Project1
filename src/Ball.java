public class Ball {

    private int overNumber;
    private int ballNumber;
    private Player bowler;
    private Player batsman;
    private String run;

    Ball(int overNumber,int ballNumber, Player bowler , Player batsman ,  int run)
    {
        this.overNumber=overNumber;
        this.ballNumber=ballNumber;
        this.bowler=bowler;
        this.batsman=batsman;
        if(run>6)
        this.run="W";
        else
            this.run=Integer.toString(run);
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public int getOverNumber() {
        return overNumber;
    }

    public Player getBatsman() {
        return batsman;
    }

    public Player getBowler() {
        return bowler;
    }

    public String getRun() {
        return run;
    }
}
