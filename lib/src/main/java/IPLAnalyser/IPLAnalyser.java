package IPLAnalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IPLAnalyser {

	List<IPLMostRunsCSV> battingList = null;
	List<IPLMostWicketsCSV> bowlingList = null;

	public List<IPLMostRunsCSV> loadBattingData(String mostRunsCsvFilePath) throws IPLException {
		try (Reader reader = Files.newBufferedReader(Paths.get(mostRunsCsvFilePath))) {
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			battingList = csvBuilder.getCSVFileList(reader, IPLMostRunsCSV.class);
			return battingList;
		} catch (CSVBuilderException e) {
			throw new IPLException(e.getMessage(), e.type.name());
		} catch (IOException e) {
			throw new IPLException(e.getMessage(), IPLException.ExceptionType.CSV_FILE_PROBLEM);
		} catch (Exception e) {
			throw new IPLException(e.getMessage(), IPLException.ExceptionType.CSV_FILE_PROBLEM);
		}
	}

	public List<IPLMostWicketsCSV> loadBowlingData(String mostWicketsCsvFilePath) throws IPLException {
		try (Reader reader = Files.newBufferedReader(Paths.get(mostWicketsCsvFilePath))) {
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			bowlingList = csvBuilder.getCSVFileList(reader, IPLMostWicketsCSV.class);
			return bowlingList;
		} catch (CSVBuilderException e) {
			throw new IPLException(e.getMessage(), e.type.name());
		} catch (IOException e) {
			throw new IPLException(e.getMessage(), IPLException.ExceptionType.CSV_FILE_PROBLEM);
		} catch (Exception e) {
			throw new IPLException(e.getMessage(), IPLException.ExceptionType.CSV_FILE_PROBLEM);
		}
	}

	public void sortByBattingAverage(List<IPLMostRunsCSV> battingList) {
		Comparator<IPLMostRunsCSV> comparator = Comparator.comparing(BatsMan -> BatsMan.battingAverage);
		Collections.sort(battingList, comparator.reversed());
	}

	public void sortByStrikeRate(List<IPLMostRunsCSV> battingList) {
		Comparator<IPLMostRunsCSV> comparator = Comparator.comparing(BatsMan -> BatsMan.strikeRate);
		Collections.sort(battingList, comparator.reversed());
	}

	public void sortByMaxSixesAndFours(List<IPLMostRunsCSV> battingList) {
		Comparator<IPLMostRunsCSV> comparator = Comparator.comparing(BatsMan -> BatsMan.noOfSixes + BatsMan.noOfFours);
		this.sortCSVDescending(comparator, battingList);
	}

	public void sortByTopStrikeRateAndBestAverage(List<IPLMostRunsCSV> battingList) {
		Comparator<IPLMostRunsCSV> averageComparator = Comparator.comparing(BatsMan -> BatsMan.battingAverage);
		Comparator<IPLMostRunsCSV> strikeRateComparator = Comparator.comparing(BatsMan -> BatsMan.strikeRate);
		Collections.sort(battingList, averageComparator.reversed());
		Collections.sort(battingList, strikeRateComparator.reversed());
	}

	public void sortByMaxRunsAndBestAverage(List<IPLMostRunsCSV> battingList) {
		Comparator<IPLMostRunsCSV> maxRunsComparator = Comparator.comparing(BatsMan -> BatsMan.runs);
		Comparator<IPLMostRunsCSV> averageComparator = Comparator.comparing(BatsMan -> BatsMan.battingAverage);
		Collections.sort(battingList, maxRunsComparator.reversed());
		Collections.sort(battingList, averageComparator.reversed());
	}

	public void sortByBowlingAverage(List<IPLMostWicketsCSV> bowlingList) {
		Comparator<IPLMostWicketsCSV> comparator = Comparator.comparing(Bowler -> Bowler.bowlingAverage);
		Collections.sort(bowlingList, comparator.reversed());
	}

	public void sortBowlersByBestStrikeRate(List<IPLMostWicketsCSV> bowlingList) {
		Comparator<IPLMostWicketsCSV> comparator = Comparator.comparing(Bowler -> Bowler.strikeRate);
		Collections.sort(bowlingList, comparator.reversed());
	}

	public void sortBowlersByBestEconomy(List<IPLMostWicketsCSV> bowlingList) {
		Comparator<IPLMostWicketsCSV> comparator = Comparator.comparing(Bowler -> Bowler.economy);
		Collections.sort(bowlingList, comparator.reversed());
	}

	public void sortBowlersByStrikeRateAndWickets(List<IPLMostWicketsCSV> bowlingList) {
		Comparator<IPLMostWicketsCSV> strikeRateComparator = Comparator.comparing(Bowler -> Bowler.strikeRate);
		Comparator<IPLMostWicketsCSV> wicketsComparator = Comparator
				.comparing(Bowler -> Bowler.fiveWickets + Bowler.fourWickets);
		Collections.sort(bowlingList, strikeRateComparator.reversed());
		Collections.sort(bowlingList, wicketsComparator.reversed());
	}

	public void sortBowlersByBowlingAverageAndStrikeRate(List<IPLMostWicketsCSV> bowlingList) {
		Comparator<IPLMostWicketsCSV> strikeRateComparator = Comparator.comparing(Bowler -> Bowler.strikeRate);
		Comparator<IPLMostWicketsCSV> bowlingAverageComparator = Comparator.comparing(Bowler -> Bowler.bowlingAverage);
		Comparator comparator = bowlingAverageComparator.thenComparing(strikeRateComparator);
		bowlingList.stream().sorted(comparator).collect(Collectors.toList());
	}

	public void sortBowlersByMaxWicketsAndBowlingAverage(List<IPLMostWicketsCSV> bowlingList) {
		Comparator<IPLMostWicketsCSV> maxWicketsComparator = Comparator.comparing(Bowler -> Bowler.totalWickets);
		Comparator<IPLMostWicketsCSV> bowlingAverageComparator = Comparator.comparing(Bowler -> Bowler.bowlingAverage);
		Comparator comparator = maxWicketsComparator.thenComparing(bowlingAverageComparator);
		bowlingList.stream().sorted(comparator).collect(Collectors.toList());
	}


	public String sortBowlersByBattingAverageAndBowlingAverage(List<IPLMostWicketsCSV> bowlingList,
			List<IPLMostRunsCSV> battingList) {
		this.sortByBowlingAverage(bowlingList);
		this.sortByBattingAverage(battingList);
		for (int i = 0; i < (bowlingList.size() > battingList.size() ? battingList.size() - 1
				: bowlingList.size() - 1); i++) {
			if (bowlingList.get(i).playerName.equals(battingList.get(i).playerName))
				return bowlingList.get(i).playerName;
		}
		return null;
	}

	public String sortCricketersByMostRunsAndWickets(List<IPLMostWicketsCSV> bowlingList, List<IPLMostRunsCSV> battingList) {
		Comparator<IPLMostWicketsCSV> wicketsComparator = Comparator.comparing(Bowler -> Bowler.totalWickets);
		Collections.sort(bowlingList, wicketsComparator.reversed());
		Comparator<IPLMostRunsCSV> runsComparator = Comparator.comparing(Batsman -> Batsman.runs);
		Collections.sort(battingList, runsComparator.reversed());
		for (int i = 0; i < (bowlingList.size() > battingList.size() ? battingList.size() - 1
				: bowlingList.size() - 1); i++) {
			if (bowlingList.get(i).playerName.equals(battingList.get(i).playerName))
				return bowlingList.get(i).playerName;
		}
		return null;
	}

	public void sortByMaxHundredsAndBestBattingAverages(List<IPLMostRunsCSV> battingList) {
		Comparator<IPLMostRunsCSV> hundredsComparator = Comparator.comparing(BatsMan -> BatsMan.noOfHundreds);
		Comparator<IPLMostRunsCSV> battingAverageComparator = Comparator.comparing(BatsMan -> BatsMan.battingAverage);
		Comparator comparator = hundredsComparator.thenComparing(battingAverageComparator);
		battingList.stream().sorted(comparator).collect(Collectors.toList());
	}

	public void sortByMinHundredsFiftiesAndBestBattingAverages(List<IPLMostRunsCSV> battingList) {
		Comparator<IPLMostRunsCSV> hundredsComparator = Comparator.comparing(Batsmen -> Batsmen.noOfHundreds);
		Comparator<IPLMostRunsCSV> fiftiesComparator = Comparator.comparing(Batsmen -> Batsmen.noOfFifties);
		Comparator<IPLMostRunsCSV> battingAverageComparator = Comparator.comparing(Batsmen -> Batsmen.battingAverage);
		Comparator<IPLMostRunsCSV> comparator = hundredsComparator.thenComparing(fiftiesComparator).thenComparing(battingAverageComparator.reversed());
		this.sortCSVDescending(comparator, battingList);
	}
	
	private <E> void sortCSVDescending(Comparator<E> Comparator, List<E> csvList) {
		for (int i = 0; i < csvList.size() - 1; i++) {
			for (int j = 0; j < csvList.size() - i - 1; j++) {
				E census1 = csvList.get(j);
				E census2 = csvList.get(j + 1);
				if (Comparator.compare(census1, census2) > 0) {
					csvList.set(j, census2);
					csvList.set(j + 1, census1);
				}
			}
		}
	}

}
