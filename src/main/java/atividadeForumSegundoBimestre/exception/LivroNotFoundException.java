package atividadeForumSegundoBimestre.exception;

public class LivroNotFoundException extends RuntimeException {
    public LivroNotFoundException() {
        super("Livro não foi encontrado");
    }
}
