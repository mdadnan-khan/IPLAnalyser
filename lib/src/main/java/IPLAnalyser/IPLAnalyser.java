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

}
