import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Over {
	public  int totalScore = 0;
	public  int wickets = 0;
	private List<List<String>> overs = new ArrayList();
	int noOfOvers;
	private List<String> team; 
	private List<List<String>> playerScore = new ArrayList();
	public   int strike = 0;
	public   int nonstrike = 1;
	public   int latestPlayer = 1;
	public   int wides = 0;
	public  int noballs = 0;
	public  int fours = 0;
	public   int sixes = 0;
	public int toWin;
	public boolean allout = false;
	public boolean matchFinish = false;
	
	public Over(int noOfOvers,List<String> team, int toWin) {
		this.noOfOvers = noOfOvers;
		this.team = team;
		this.toWin = toWin;
		for(int i=0;i<team.size();i++) {
			List<String> list  = new ArrayList();
			list.add(team.get(i));//playername = 0
			list.add("0"); //score = 1
			list.add("0");//4s = 2
			list.add("0");//6s = 3
			list.add("0");//balls = 4
			playerScore.add(list);
		}
	}

	void bowlOver(int n) {
		Scanner sc = new Scanner(System.in);
		List over = new ArrayList<String>();
		overs.add(over);
		for(int i=0;i<6;i++) {
			System.out.println("Enter your runs for ball no : "+i);
			String run = sc.next();
			if(!updateScore(i,run,n)) {
				i--;
			}
			if(allout || matchFinish) {
				return;
			}
		}
		int temp = strike;
		strike = nonstrike;
		nonstrike = temp;
	}

	private boolean updateScore(int i, String run, int n) {
		if(run.equals("W")) {
			wickets += 1;
			overs.get(n).add(run);
		}else if(run.equals("Wd")) {
			totalScore += 1;
			overs.get(n).add(run);
		}else if(run.equals("N")){
			totalScore += 1;
			overs.get(n).add(run);
		}else {
			totalScore += run.toCharArray()[0] - '0';
			overs.get(n).add(run);
		}
		updatePlayerScore(run);
		if(allout || totalScore > toWin ) {
			matchFinish = true;
			return true;
		}
		if(run.equals("Wd") || run.equals("N")) {
			return false;
		}
		return true;
	}

	private void updatePlayerScore(String run) {
		String balls = playerScore.get(strike).get(4);
		int balls_int = Integer.parseInt(balls);
		balls_int += 1;
		playerScore.get(strike).set(4,balls_int+""); 
		if(run.equals("W")) {
			if(latestPlayer+1 < team.size()) {
				strike = latestPlayer + 1;
				latestPlayer += 1;
			}else {
				allout = true;
				return;
			}
		}else if(run.equals("Wd")) {
			wides += 1;
		}else if(run.equals("N")){
			noballs += 1; 
		}else {
			int playerRuns =Integer.parseInt(run);
			//adding to their score
			System.out.println("Player run will be: "+playerRuns);
			String runsTillNow = playerScore.get(strike).get(1);
			int runsTillNow_int = Integer.parseInt(runsTillNow);
			runsTillNow_int += playerRuns;
			playerScore.get(strike).set(1,runsTillNow_int+""); 
			
			if(playerRuns%2 == 1) { // if odd then change strike;
				int temp = strike;
				strike = nonstrike;
				nonstrike = temp;
			}else if(playerRuns == 4) { // calculate their 4 
				String foursTillNow = playerScore.get(strike).get(2);
				int foursTillNow_int = Integer.parseInt(foursTillNow);
				foursTillNow_int += 1;
//				System.out.println("Your fours till now are: " + foursTillNow_int);
				playerScore.get(strike).set(2,foursTillNow_int+""); 
			}else if(playerRuns == 6) {// calculate their 6
				String sixesTillNow = playerScore.get(strike).get(3);
				int sixesTillNow_int = Integer.parseInt(sixesTillNow);
				sixesTillNow_int += 1;
				playerScore.get(strike).set(3,sixesTillNow_int+""); 
			}
		}
		System.out.println("Strike is with "+ strike);
	}

	public void summary(int i) {
		//for each balls in over;
		System.out.println("This over: ");
		for(String ball : overs.get(i)){
			System.out.print(ball + " ");
		}
		
		System.out.println();
		
		System.out.println("Player Score for this over : ");
		for(List<String> players : playerScore){
			System.out.print(players.get(0)+ " ");
			System.out.print(players.get(1)+ " ");
			System.out.print(players.get(2)+ " ");
			System.out.print(players.get(3)+ " ");
			System.out.print(players.get(4)+ " ");
			System.out.println();
		}
		
		System.out.println("Team Score after this over : "+ totalScore + "/" + wickets);
		
	}
	
}
