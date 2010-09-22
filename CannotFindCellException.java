/**
    This is an exception which is thrown when a request for
    a cell cannot be processed.
*/
public class CannotFindCellException extends Exception {
    /**
        The constructor for a new CannotFindCellException
    */
    public CannotFindCellException() {}
    /**
        The constructor for a new CannotFindCellException
        with a field to give a reason.
        @param reason Reason for exception.
    */
    public CannotFindCellException(String reason) {
        super(reason);
    }
}
