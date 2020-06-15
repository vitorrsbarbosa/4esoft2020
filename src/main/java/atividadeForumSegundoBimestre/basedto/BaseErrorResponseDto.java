package atividadeForumSegundoBimestre.basedto;

public class BaseErrorResponseDto {
    private String message;

    public BaseErrorResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
