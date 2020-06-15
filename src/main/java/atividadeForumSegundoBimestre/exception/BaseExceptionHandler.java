package atividadeForumSegundoBimestre.exception;

import atividadeForumSegundoBimestre.basedto.BaseErrorResponseDto;
import atividadeForumSegundoBimestre.basedto.BaseResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BaseExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponseDto<BaseErrorResponseDto> handleUnhandledException(Exception exception) {
        return new BaseResponseDto<>(new BaseErrorResponseDto("Todo mundo erra, e parece que dessa vez foram nossos servidores"));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponseDto<BaseErrorResponseDto> handleNotFoundException(Exception exception) {
        return new BaseResponseDto<>(new BaseErrorResponseDto("Não foi possível encontrar o livro requisitado"));
    }
}
