package atividadeForumSegundoBimestre.exception;

public class UnauthorizedException extends BaseException {
    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}