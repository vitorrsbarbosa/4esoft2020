package atividadeForumSegundoBimestre.exception;

public class LivroNotFoundException extends PreconditionFailedException {

    public LivroNotFoundException() {
        super();
    }

    public LivroNotFoundException(String message) {
        super(message);
    }

    public LivroNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
