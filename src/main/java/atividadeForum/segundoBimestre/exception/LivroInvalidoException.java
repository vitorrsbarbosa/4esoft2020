package atividadeForum.segundoBimestre.exception;

public class LivroInvalidoException extends RuntimeException {
    public LivroInvalidoException() {
        super("Tente novamente, pode ser que tenha dados inválidos");
    }
}
