package IPLAnalyser;

import com.opencsv.bean.CsvBindByName;

public class IPLMostRunsCSV {
	@CsvBindByName(column="PLAYER", required=true)
	public String playerName;
	
	@CsvBindByName(column="Runs", required=true)
	public String runs;
	
	@CsvBindByName(column="AVG", required=true)
	public String battingAverage;
	
	@CsvBindByName(column="SR", required=true)
	public String strikeRate;
	
	@CsvBindByName(column="6s", required=true)
	public String noOfSixes;
	
	@CsvBindByName(column="4s", required=true)
	public String noOfFours;
	
	@CsvBindByName(column="100", required=true)
	public String noOfHundreds;
	
	@CsvBindByName(column="50", required=true)
	public String noOfFifties;

	@Override
	public String toString() {
		return "IPLMostRunsCSV [playerName=" + playerName + ", runs=" + runs + ", battingAverage=" + battingAverage
				+ ", strikeRate=" + strikeRate + ", noOfSixes=" + noOfSixes + ", noOfFours=" + noOfFours
				+ ", noOfHundreds=" + noOfHundreds + ", noOfFifties=" + noOfFifties + "]";
	}
	
	
	
}
