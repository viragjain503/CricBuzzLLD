import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			Scanner sc  = new Scanner(System.in);
			System.out.println("Enter number of Players: ");
			int noOfPlayers = sc.nextInt();
			System.out.println("Enter number of Overs: ");
			int noOfOvers = sc.nextInt();
			
			List team1=new ArrayList();
			System.out.println("Enter batting order of team 1");
			for(int i=0;i<noOfPlayers;i++) {
				String player = sc.next();
				team1.add(player);
			}
			List team2=new ArrayList();
			System.out.println("Enter batting order of team 2");
			for(int i=0;i<noOfPlayers;i++) {
				String player = sc.next();
				team2.add(player);
			}
			Game game = new Game(noOfPlayers, noOfOvers,team1,team2);
			game.play();
	}

}
