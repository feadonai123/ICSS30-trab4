package api.usecases.getEntrega;

import errors.AplicationError;

public class GetEntregaErrors extends AplicationError {
  public GetEntregaErrors(String message) {
    super(message);
  }
}
