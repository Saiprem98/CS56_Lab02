public class CrapsMetricsMonitor{
	private int gamesPlay;
	private int gamesWon;
	private int gamesLost;
	private int maxRollsInGame;
	private int totNatural;
	private int totCraps;
	private int winStreak;
	private int loseStreak;
	private int maxBalance;
	private int maxBalanceGame;

	public CrapsMetricsMonitor(){
		reset();
	}
	public void reset(){
		 gamesPlay = 0;
		 gamesWon =0;
		 gamesLost = 0;
		 maxRollsInGame =0;
		 totNatural = 0;
		 totCraps = 0;
		 winStreak =0;
		 loseStreak = 0;
		 maxBalance =0;
		 maxBalanceGame = 0;
	}
	public void printStatistics(){
		System.out.println("*****************************");
		System.out.println("*** SIMULATION STATISTICS ***");
		System.out.println("*****************************");
		System.out.println("Games played: " + gamesPlay);
		System.out.println("Games won: " + gamesWon);
		System.out.println("Games lost: " + gamesLost);
		System.out.println("Maximum Rolls in a single game: " + maxRollsInGame);
		System.out.println("Natural Count: " + totNatural);
		System.out.println("Craps count: "+ totCraps);
		System.out.println("Maximum Winning Streak: " + winStreak);
		System.out.println("Maximum Loosing Streak: " + loseStreak);
		System.out.println("Maximum balance:" + maxBalance + " during game " + maxBalanceGame);

	}
	public int getNaturalCount() {
       return totNatural;
    }

    public void setNaturalCount(int num) {
       totNatural= num;
    }

    public void setMaxRollsGame(int numRolls) {
        if (numRolls > maxRollsInGame) {
            maxRollsInGame = numRolls;
        }
    }

    public int getTotCraps() {
        return totCraps;
    }

    public void setTotCraps(int num) {
        totCraps = num;
    }

    public int getGamesWon() {
       return gamesWon;
    }

     public void setGamesWon(int num) {
       gamesWon = num;
    }

    public int getGamesLost() {
        return gamesLost;
    }
     public void setGamesLost(int num) {
       gamesLost = num;
    }

    public int getGamesPlay() {
        return gamesPlay;
    }

    public void setGamesPlay(int num) {
        gamesPlay = num;
    }

    public void setWinStreak(int current) {
        if (current > winStreak) {
            winStreak = current;
        }
    }

    public void setLoseStreak(int current) {
        if (current > loseStreak) {
            loseStreak = current;
        }
    }

    public void setMaxBalance(int userBalance) {
        if (userBalance > maxBalance) {
            maxBalance = userBalance;
            maxBalanceGame = gamesPlay;
        }
    }
}