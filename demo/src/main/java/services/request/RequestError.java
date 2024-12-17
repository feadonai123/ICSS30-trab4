package services.request;

import errors.AplicationError;

public class RequestError extends AplicationError {
  public RequestError(String message) {
    super(message);
  }
}
