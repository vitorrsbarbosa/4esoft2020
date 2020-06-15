package atividadeForumSegundoBimestreTest.basedto;

import java.time.Clock;
import java.time.LocalDateTime;

public class BaseResponseDto<T>  {

    public BaseResponseDto() {
        executed = null;
        data = null;
    }

    public BaseResponseDto(T data){
        executed = LocalDateTime.now(Clock.systemUTC());
        this.data = data;
    }

    private final LocalDateTime executed;

    private final T data;

    public LocalDateTime getExecuted() {
        return executed;
    }

    public T getData() {
        return data;
    }
}

