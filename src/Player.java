import java.util.Scanner;

public class Player {
    private String name;
    private String role;
    private int run;
    private int BallsFaced;
    private int wickets;
    private int BallsBowled;
    public boolean outOrNot;

    public void createPlayer() {
        Scanner src=new Scanner(System.in);
        System.out.print("Enter Player Name: ");
        this.name=src.nextLine();
        System.out.print("Enter Player Role: ");
        this.role=src.nextLine();
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

    public void incrementBallsFaced() {

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
    public void incrementBallsBowled(){
        this.BallsBowled++;
    }
    public int getBallsBowled(){
        return BallsBowled;
    }
    public void incrementWickets(){
        this.wickets++;
    }
    public int getWickets(){
        return wickets;
    }

}
