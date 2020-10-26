package atividadeForum.segundoBimestre.exception;

public class LivroRepetidoException extends RuntimeException {
    private static final long serialVersionUID = -2052013370043705392L;
    public LivroRepetidoException() {
        super("Já existe um livro com este Id.");
    }
}
