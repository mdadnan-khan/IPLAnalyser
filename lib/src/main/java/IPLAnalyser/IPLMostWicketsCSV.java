package IPLAnalyser;

import com.opencsv.bean.CsvBindByName;

public class IPLMostWicketsCSV {
	@CsvBindByName(column = "PLAYER")
	public String playerName;
	
	@CsvBindByName(column = "Wkts")
	public int totalWickets;
	
	@CsvBindByName(column = "Avg")
	public double bowlingAverage;
	
	@CsvBindByName(column = "SR")
	public double strikeRate;
	
	@CsvBindByName(column = "econ")
	public double economy;
	
	@CsvBindByName(column = "5w")
	public int fiveWickets;
}
