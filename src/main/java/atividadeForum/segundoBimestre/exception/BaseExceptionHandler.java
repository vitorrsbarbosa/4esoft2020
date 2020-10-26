package atividadeForum.segundoBimestre.exception;

import atividadeForum.segundoBimestre.base.dto.BaseErrorResponseDto;
import atividadeForum.segundoBimestre.base.dto.BaseResponseDto;
import mySpringBootApp.livro.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BaseExceptionHandler {
    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // @ExceptionHandler(Exception.class)
    // @ResponseBody
    // public BaseResponseDto<BaseErrorResponseDto> handleUnhandledException(Exception exception) {
    //     return new BaseResponseDto<>(new BaseErrorResponseDto("Todo mundo erra, e parece que dessa vez foram nossos servidores"));
    // }

    // @ResponseStatus(HttpStatus.NOT_FOUND)
    // @ExceptionHandler(NotFoundException.class)
    // @ResponseBody
    // public BaseResponseDto<BaseErrorResponseDto> handleNotFoundException(Exception exception) {
    //     return new BaseResponseDto<>(new BaseErrorResponseDto("Não foi possível encontrar o livro requisitado"));
    // }

    // @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    // @ResponseBody
    // public BaseResponseDto<BaseErrorResponseDto> handlePreconditionFailedException(Exception exception) {
    //     return new BaseResponseDto<>(new BaseErrorResponseDto("Faltam informações na requisição."));
    // }
}
