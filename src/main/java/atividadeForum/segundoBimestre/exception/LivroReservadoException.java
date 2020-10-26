package atividadeForum.segundoBimestre.exception;

public class LivroReservadoException extends RuntimeException{
    private static final long serialVersionUID = -4340854646986430801L;
    public LivroReservadoException() {
        super("Livro já reservado.");
    }

}
