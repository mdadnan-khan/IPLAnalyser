/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package IPLAnalyser;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Assert;

import java.util.List;

public class IPLAnalyserTest {

	private static final String MOST_RUNS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
	private static final String MOST_WICKETS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

	@Test
	public void givenMostRunsCSVFile_ShouldReturnTopBattingAverage() throws IPLException {
		IPLAnalyser iplAnalyser = new IPLAnalyser();
		List<IPLMostRunsCSV> battingList = iplAnalyser.loadBattingData(MOST_RUNS_CSV_FILE_PATH);
		iplAnalyser.sortByBattingAverage(battingList);
		Assert.assertEquals("MS Dhoni", battingList.get(0).playerName);
	}
	
	@Test
	public void givenMostRunsCSVFile_ShouldReturnTopStrikeRate() throws IPLException {
		IPLAnalyser iplAnalyser = new IPLAnalyser();
		List<IPLMostRunsCSV> battingList = iplAnalyser.loadBattingData(MOST_RUNS_CSV_FILE_PATH);
		iplAnalyser.sortByStrikeRate(battingList);
		Assert.assertEquals("Ishant Sharma", battingList.get(0).playerName);
	}
	
	@Test
	public void givenMostRunsCSVFile_ShouldReturnMaxSixesAndFours() throws IPLException {
		IPLAnalyser iplAnalyser = new IPLAnalyser();
		List<IPLMostRunsCSV> battingList = iplAnalyser.loadBattingData(MOST_RUNS_CSV_FILE_PATH);
		iplAnalyser.sortByMaxSixesAndFours(battingList);
		Assert.assertEquals("Andre Rusell", battingList.get(0).playerName);
	}
	
	@Test
	public void givenMostRunsCSVFile_ShouldReturnTopStrikingAndMaxSixesAndFours() throws IPLException {
		IPLAnalyser iplAnalyser = new IPLAnalyser();
		List<IPLMostRunsCSV> battingList = iplAnalyser.loadBattingData(MOST_RUNS_CSV_FILE_PATH);
		iplAnalyser.sortByMaxSixesAndFours(battingList);
		iplAnalyser.sortByStrikeRate(battingList);
		Assert.assertEquals("MS Dhoni", battingList.get(0).playerName);
	}
	
	@Test
	public void givenMostRunsCSVFile_ShouldReturnTopStrikingAndBestAverages() throws IPLException {
		IPLAnalyser iplAnalyser = new IPLAnalyser();
		List<IPLMostRunsCSV> battingList = iplAnalyser.loadBattingData(MOST_RUNS_CSV_FILE_PATH);
		iplAnalyser.sortByTopStrikeRateAndBestAverage(battingList);
		Assert.assertEquals("David Warner", battingList.get(0).playerName);
	}
	
	@Test
	public void givenMostRunsCSVFile_ShouldReturnMaxRunsAndBestAverages() throws IPLException {
		IPLAnalyser iplAnalyser = new IPLAnalyser();
		List<IPLMostRunsCSV> battingList = iplAnalyser.loadBattingData(MOST_RUNS_CSV_FILE_PATH);
		iplAnalyser.sortByMaxRunsAndBestAverage(battingList);
		Assert.assertEquals("David Warner", battingList.get(0).playerName);
	}
	
	@Test
	public void givenMostWicketsCSVFile_ShouldReturnBestBowlingAverages() throws IPLException {
		IPLAnalyser iplAnalyser = new IPLAnalyser();
		List<IPLMostWicketsCSV> bowlingList = iplAnalyser.loadBowlingData(MOST_WICKETS_CSV_FILE_PATH);
		iplAnalyser.sortByBowlingAverage(bowlingList);
		Assert.assertEquals("Krishnappa Gowtham", bowlingList.get(0).playerName);
	}
	
	@Test
	public void givenMostWicketsCSVFile_ShouldReturnBestStrikeRate() throws IPLException {
		IPLAnalyser iplAnalyser = new IPLAnalyser();
		List<IPLMostWicketsCSV> bowlingList = iplAnalyser.loadBowlingData(MOST_WICKETS_CSV_FILE_PATH);
		iplAnalyser.sortBowlersByBestStrikeRate(bowlingList);
		Assert.assertEquals("Krishnappa Gowtham", bowlingList.get(0).playerName);
	}
	
	@Test
	public void givenMostWicketsCSVFile_ShouldReturnBestEconomy() throws IPLException {
		IPLAnalyser iplAnalyser = new IPLAnalyser();
		List<IPLMostWicketsCSV> bowlingList = iplAnalyser.loadBowlingData(MOST_WICKETS_CSV_FILE_PATH);
		iplAnalyser.sortBowlersByBestEconomy(bowlingList);
		Assert.assertEquals("Shivam Dube", bowlingList.get(0).playerName);
	}
	
	@Test
	public void givenMostWicketsCSVFile_ShouldReturnBestStrikeRateWith5WicketsAnd4Wickets() throws IPLException {
		IPLAnalyser iplAnalyser = new IPLAnalyser();
		List<IPLMostWicketsCSV> bowlingList = iplAnalyser.loadBowlingData(MOST_WICKETS_CSV_FILE_PATH);
		iplAnalyser.sortBowlersByStrikeRateAndWickets(bowlingList);
		Assert.assertEquals("Alzarri Joseph", bowlingList.get(0).playerName);
	}
	
	@Test
	public void givenMostWicketsCSVFile_ShouldReturnBestBowlingAverageAndStrikeRate() throws IPLException {
		IPLAnalyser iplAnalyser = new IPLAnalyser();
		List<IPLMostWicketsCSV> bowlingList = iplAnalyser.loadBowlingData(MOST_WICKETS_CSV_FILE_PATH);
		iplAnalyser.sortBowlersByBowlingAverageAndStrikeRate(bowlingList);
		Assert.assertEquals("Anukul Roy", bowlingList.get(0).playerName);
	}
	
	@Test
	public void givenMostWicketsCSVFile_ShouldReturnMostWicketsAndBestBowlingAverage() throws IPLException {
		IPLAnalyser iplAnalyser = new IPLAnalyser();
		List<IPLMostWicketsCSV> bowlingList = iplAnalyser.loadBowlingData(MOST_WICKETS_CSV_FILE_PATH);
		iplAnalyser.sortBowlersByMaxWicketsAndBowlingAverage(bowlingList);
		Assert.assertEquals("Umesh Yadav", bowlingList.get(0).playerName);
	}
	
	@Test
	public void givenMostWicketsCSVFile_ShouldReturnBestBattingAverageAndBestBowlingAverage() throws IPLException {
		IPLAnalyser iplAnalyser = new IPLAnalyser();
		List<IPLMostRunsCSV> battingList = iplAnalyser.loadBattingData(MOST_RUNS_CSV_FILE_PATH);
		List<IPLMostWicketsCSV> bowlingList = iplAnalyser.loadBowlingData(MOST_WICKETS_CSV_FILE_PATH);
		String name = iplAnalyser.sortBowlersByBattingAverageAndBowlingAverage(bowlingList, battingList);
		Assert.assertEquals("Umesh Yadav", name);
	}
	
	@Test
	public void givenMostWicketsCSVFile_ShouldReturnMostRunsAndWickets() throws IPLException {
		IPLAnalyser iplAnalyser = new IPLAnalyser();
		List<IPLMostRunsCSV> battingList = iplAnalyser.loadBattingData(MOST_RUNS_CSV_FILE_PATH);
		List<IPLMostWicketsCSV> bowlingList = iplAnalyser.loadBowlingData(MOST_WICKETS_CSV_FILE_PATH);
		String name = iplAnalyser.sortCricketersByMostRunsAndWickets(bowlingList, battingList);
		Assert.assertEquals("David Warner", name);
	}
}
