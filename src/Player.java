import java.util.Scanner;

public class Player {
    public String name;
    public String role;
    private int run;
    private int BallsFaced;
    private int wickets;
    private int BallsBowled;
    boolean outOrNot;

    public void createPlayer() {
        this.run = 0;
        this.BallsBowled = 0;
        this.BallsFaced = 0;
        this.wickets = 0;
        this.outOrNot = false;
    }

    public String getname() {
        return name;
    }

    public String getrole() {
        return role;
    }

    public void incrementrun(int run) {
        this.run += run;
    }

    public void incrementBalls() {
        this.BallsFaced++;
    }
    public int getplayerrun()
    {
        return run;
    }
    public int getBallsFaced()
    {
        return BallsFaced;
    }

}
