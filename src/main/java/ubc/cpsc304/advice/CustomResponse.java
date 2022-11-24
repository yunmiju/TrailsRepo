package ubc.cpsc304.advice;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class CustomResponse<T> {

  private final LocalDateTime timestamp = LocalDateTime.now();
  private int status;
  private String code;
  private String message;
  private T body;

  public static <T> CustomResponse of(T data) {
    return CustomResponse.builder()
        .status(HttpStatus.OK.value())
        .code("")
        .message("")
        .body(data)
        .build();
  }
}