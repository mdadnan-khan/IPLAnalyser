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

	public void sortByBattingAverage(List<IPLMostRunsCSV> battingList) {
		Comparator<IPLMostRunsCSV> comparator = Comparator.comparing(BatsMan -> BatsMan.battingAverage);
		Collections.sort(battingList, comparator.reversed());
	}

	public void sortByStrikeRate(List<IPLMostRunsCSV> battingList2) {
		Comparator<IPLMostRunsCSV> comparator = Comparator.comparing(BatsMan -> BatsMan.strikeRate);
		Collections.sort(battingList, comparator.reversed());
	}

	public void sortByMaxSixesAndFours(List<IPLMostRunsCSV> battingList) {
		Comparator<IPLMostRunsCSV> comparator = Comparator.comparing(BatsMan -> BatsMan.noOfSixes + BatsMan.noOfFours);
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
