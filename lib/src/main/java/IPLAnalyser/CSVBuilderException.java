package IPLAnalyser;

public class CSVBuilderException extends Exception {

    enum ExceptionType {
        CENSUS_FILE_PROBLEM,
        UNABLE_TO_PARSE,
        WRONG_FILE_TYPE,
        INCORRECT_DELIMITER,
        INCORRECT_HEADER, NO_CENSUS_DATA
    }

    ExceptionType type;

    public CSVBuilderException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public CSVBuilderException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
