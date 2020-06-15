package atividadeForumSegundoBimestre.exception;

public class PreconditionFailedException extends BaseException {
    public PreconditionFailedException() {
        super();
    }

    public PreconditionFailedException(String message) {
        super(message);
    }

    public PreconditionFailedException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
