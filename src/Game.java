import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private int noOfPlayers;
	private int noOfOvers;
	private List team1;
	private List team2;
	
	public Game(int noOfPlayers, int noOfOvers, List team1, List team2) {
		this.noOfOvers = noOfOvers;
		this.noOfPlayers = noOfPlayers;
		this.team1 = team1;
		this.team2 = team2;
	}

	public void play() {
		Inning inning1 = new Inning(noOfOvers , team1,Integer.MAX_VALUE);
		inning1.play();
		System.out.println("Team 1 score after first inning is: "+ inning1.getScore()+ "/"+ inning1.getWickets());
		System.out.println("Lets Start Inning 2: ");
		System.out.println("Team 2 needs "+inning1.getScore() + " runs to win the match in " +noOfOvers +" overs");
		Inning inning2 = new Inning(noOfOvers , team2,inning1.getScore());
		inning2.play();
		System.out.println("Team 2 score after first inning is: "+ inning2.getScore()+ "/"+ inning2.getWickets());
		System.out.println("Team1 : "+ inning1.getScore()+ "/"+ inning1.getWickets() );
		System.out.println("Team2 : "+ inning2.getScore()+ "/"+ inning2.getWickets() );
		if(inning1.getScore() > inning2.getScore()) {
			System.out.println("Team 1 won the match");
		}else {
			System.out.println("Team 2 won the match");
		}
	}

	public int getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}

	public int getNoOfOvers() {
		return noOfOvers;
	}

	public void setNoOfOvers(int noOfOvers) {
		this.noOfOvers = noOfOvers;
	}

	public List getTeam1() {
		return team1;
	}

	public void setTeam1(List team1) {
		this.team1 = team1;
	}

	public List getTeam2() {
		return team2;
	}

	public void setTeam2(List team2) {
		this.team2 = team2;
	}

}
