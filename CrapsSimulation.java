import java.util.Scanner;

public class CrapsSimulation{
	
	private CrapsMetricsMonitor metricMon;
	
	private String user;
	private int userBalance;
	private int userBet;
	private int currentWinStreak;
	private int currentLoseStreak;

	private Scanner inp;

	public CrapsSimulation(){
		user = "";
		userBalance = 0;
		userBet = 0;
		currentLoseStreak = 0;
		currentWinStreak = 0;

		metricMon = new CrapsMetricsMonitor();
		inp = new Scanner(System.in);
	}
	public void start(){
		String replay ;
		replay = "";
		do {
			metricMon.reset();
			startNewGame();
			// "\n"
			System.out.println();
            do {
                System.out.print("Replay? Enter 'y' or 'n': ");
                replay= inp.nextLine();
            } while ((!replay.equals("Y") && !replay.equals("y"))  && (!replay.equals("N") && !replay.equals("n") ));
            System.out.println();
        } while (replay.equals("Y") || replay.equals("y"));
    }

	public void startNewGame(){
		System.out.print("Welcome to SimCraps! Enter your username: ");
		user= inp.nextLine();

		System.out.println("Hello " + user + "!");
        System.out.print("Enter the amount of money you will bring to the table: ");

        userBalance = inp.nextInt();
        inp.nextLine();
  		
  		while(userBalance <= 0){
            System.out.print("Invalid balance! Please enter a bet $1 and above: ");
            userBalance = inp.nextInt();
            inp.nextLine();
        }
  		System.out.print("Enter the bet amount between $1 and " + userBalance + ": ");
        userBet = inp.nextInt();
        inp.nextLine();

        while ( userBet > userBalance || userBet <= 0) {
            System.out.print("Invalid bet! Please enter a bet between $1 and " + userBalance + ": ");
            userBet = inp.nextInt();
            inp.nextLine();
        }

        startGameAlgorithm();

	}
	public void startGameAlgorithm(){
		
		while (userBalance > 0){
		int current = userBet;
		userBalance = userBalance - current;
		
		System.out.println(user + " bets $" + current);
		CrapsGame g = new CrapsGame(metricMon);
		int game = metricMon.getGamesPlay();
		metricMon.setGamesPlay(++game);
		boolean recent = true;
		if(g.playGame() == true){
			int numGameWon = metricMon.getGamesWon();
			metricMon.setGamesWon(++numGameWon);
			int winnings = current*2;
			userBalance = userBalance + winnings;
			metricMon.setMaxBalance(userBalance);

			if(recent == true){
				metricMon.setWinStreak(++currentWinStreak);
			}
			else{
				recent = true;
				currentWinStreak = 1;
			}
		}
		else{
			int gameL = metricMon.getGamesLost();
			metricMon.setGamesLost(++gameL);

			if (recent == false){
				metricMon.setLoseStreak(++currentLoseStreak);
			}
			else{
				recent = false;
				currentLoseStreak = 1;
			}
		}
		if (userBalance > 0) {
                System.out.println(user + "'s balance: $" + userBalance + ". Playing a new game...");
            }
        }

        System.out.println(user + "'s balance: $" + userBalance+"\n");
        metricMon.printStatistics();	
	}

}