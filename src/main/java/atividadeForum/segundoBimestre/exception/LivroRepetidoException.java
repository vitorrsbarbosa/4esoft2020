package atividadeForum.segundoBimestre.exception;

public class LivroRepetidoException extends RuntimeException {
    public LivroRepetidoException() {
        super("Já existe um livro com este Id.");
    }
}
