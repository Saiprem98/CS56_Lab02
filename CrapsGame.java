
import java.util.Random;

public class CrapsGame{
	private int numOfRolls;
	private CrapsMetricsMonitor metricMonitor;

	public CrapsGame(CrapsMetricsMonitor metricMonitor){
		this.metricMonitor = metricMonitor;
	}
	//t = win , f= lose ?? 
	public boolean playGame(){
		Random dice1 = new Random();
		int range = dice1.nextInt(12)+1;
		numOfRolls++;

		// print rolled value prolly here
		System.out.println("Roled a " + range);

		if ( range == 7 || range == 11){
			// win so update counter + rolls 
			int count = metricMonitor.getNaturalCount();
			metricMonitor.setNaturalCount(++count);
			metricMonitor.setMaxRollsGame(numOfRolls);
			System.out.println("*****Natural! You win!*****");
			return true;
		}
		if ( range == 2 || range == 3 || range ==12){
			int crapsCount = metricMonitor.getTotCraps();
			metricMonitor.setTotCraps(++crapsCount);
			metricMonitor.setMaxRollsGame(numOfRolls);
			System.out.println("*****Craps! You loose.*****");
			return false; 
		}
		// if none of these returned 
		int point = range;

		while(true){
			range = dice1.nextInt(12)+1;
			numOfRolls++;
			System.out.println("Roled a " + range);

			if(range == 7){
				metricMonitor.setMaxRollsGame(numOfRolls);
				System.out.println("*****Crap out! You loose.*****");
				return false;
			}
			if (range == point){
				metricMonitor.setMaxRollsGame(numOfRolls);
				System.out.println("*****Rolled the point! You win!*****");
				return true;
			}

		}
	}
}