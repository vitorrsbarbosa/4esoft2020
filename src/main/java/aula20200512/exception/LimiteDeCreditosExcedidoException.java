package aula20200512.exception;

public class LimiteDeCreditosExcedidoException extends RuntimeException{
    
    private static final long serialVersionUID = -544886765160126539L;

    LimiteDeCreditosExcedidoException() {
    }
    LimiteDeCreditosExcedidoException(String message) {
        super(message);
    }
    LimiteDeCreditosExcedidoException(String message, Exception e) {
        super(message);
    }
}