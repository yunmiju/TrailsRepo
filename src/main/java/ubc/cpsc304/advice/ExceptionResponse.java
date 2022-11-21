package ubc.cpsc304.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

  private String statusCode;
  private String message;
}
