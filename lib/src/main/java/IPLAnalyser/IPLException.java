package IPLAnalyser;

public class IPLException extends Exception{
	public enum ExceptionType {
		CSV_FILE_PROBLEM,
        UNABLE_TO_PARSE,
        WRONG_FILE_TYPE,
        INCORRECT_DELIMITER,
        INCORRECT_HEADER, NO_CENSUS_DATA
	}

	ExceptionType type;

	public IPLException(String message, String name) {
		super(message);
		this.type = ExceptionType.valueOf(name);
	}

	public IPLException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}

	public IPLException(String message, ExceptionType type, Throwable cause) {
		super(message, cause);
		this.type = type;
	}
}
