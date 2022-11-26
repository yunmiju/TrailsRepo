package ubc.cpsc304.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false));

    return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ApiException.class)
  public final ResponseEntity<Object> handleUserNotFoundException(ApiException ex,
      WebRequest request) {
    System.out.println("in apiException");
    ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getError().getCode(), ex.getMessage());
    System.out.println("exceptionRespons : " + exceptionResponse);
    ResponseEntity<Object> result = new ResponseEntity<Object>(exceptionResponse,
        ex.getError().getStatus());
    System.out.println(result);
    return result;
  }

}