package api.middlewares;

import errors.AplicationError;
import errors.ResponseError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(AplicationError.class)
  public ResponseEntity<ResponseError> handleAplicationError(AplicationError ex, WebRequest request) {
      ResponseError ResponseError = new ResponseError(
          HttpStatus.BAD_REQUEST.value(),
          "Bad Request",
          ex.getMessage(),
          request.getDescription(false)
      );
      return new ResponseEntity<>(ResponseError, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseError> handleGlobalException(Exception ex, WebRequest request) {
      ResponseError ResponseError = new ResponseError(
          HttpStatus.INTERNAL_SERVER_ERROR.value(),
          "Internal Server Error",
          ex.getMessage(),
          request.getDescription(false)
      );
      return new ResponseEntity<>(ResponseError, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
