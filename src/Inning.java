import java.util.List;
import java.util.Scanner;

public class Inning {
	private int noOfOvers;
	private List team;
	private int score = 0;
	private int wickets = 0;
	private int toWin;
	
	public Inning(int noOfOvers, List team,int toWin) {
		this.noOfOvers = noOfOvers;
		this.team = team;
		this.toWin = toWin;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public void play() {
		Over over = new Over(noOfOvers, team, toWin);
		for(int i=0;i<noOfOvers;i++) {
			System.out.println("Lets Start over number: "+ i);
			over.bowlOver(i);
			over.summary(i);
			score = over.totalScore;
			wickets = over.wickets;
			if(over.allout || over.matchFinish) {
				return;
			}
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
