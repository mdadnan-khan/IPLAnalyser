package IPLAnalyser;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVBuilder<E> implements ICSVBuilder<E> {
	@Override
	public Iterator<E> getCSVFileIterator(Reader reader, Class<E> csvClass) throws CSVBuilderException {
		return this.getCSVbean(reader, csvClass).iterator();
	}

	@Override
	public List<E> getCSVFileList(Reader reader, Class<E> csvClass) throws CSVBuilderException {
		return this.getCSVbean(reader, csvClass).parse();
	}

	private CsvToBean<E> getCSVbean(Reader reader, Class<E> csvClass) throws CSVBuilderException {
		try {
			CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(csvClass);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			return csvToBeanBuilder.build();
		} catch (IllegalStateException e) {
			throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.UNABLE_TO_PARSE);
		}
		
	}
	
	
}
