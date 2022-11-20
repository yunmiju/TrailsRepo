package ubc.cpsc304.service;


import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ExceptionEnum {
  RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "400"),
  ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "401"),
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500"),
  EMPTY_RESULT(HttpStatus.NO_CONTENT, "204", "no content"),
  INVALID_INPUT(HttpStatus.UNPROCESSABLE_ENTITY, "422", "invalid input"),
  SECURITY_01(HttpStatus.UNAUTHORIZED, "S0001", "no authorization"),;

  private final HttpStatus status;
  private final String code;
  private String message;

  ExceptionEnum(HttpStatus status, String code) {
    this.status = status;
    this.code = code;
  }

  ExceptionEnum(HttpStatus status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }
  }