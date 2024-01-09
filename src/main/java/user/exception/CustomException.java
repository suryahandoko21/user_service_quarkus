package user.exception;

import java.io.Serializable;

public class CustomException extends
        RuntimeException implements Serializable {
    public CustomException(String message) {
        super(message);
    }
}
