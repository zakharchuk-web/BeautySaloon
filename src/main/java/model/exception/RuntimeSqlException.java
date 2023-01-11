package model.exception;

public class RuntimeSqlException extends RuntimeException {
    public RuntimeSqlException(Throwable cause) {
        super(cause);
    }

    public RuntimeSqlException(String message) {
        super(message);
    }

    public RuntimeSqlException(String message, Throwable cause) {
        super(message, cause);
    }
}
