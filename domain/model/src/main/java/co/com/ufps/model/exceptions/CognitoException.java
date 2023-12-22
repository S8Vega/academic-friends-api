package co.com.ufps.model.exceptions;

public class CognitoException extends RuntimeException {
    public CognitoException(String message) {
        super(message);
    }

    public CognitoException(RuntimeException e) {
        super(e);
    }
}
