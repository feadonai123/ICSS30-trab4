package api.usecases.enviarEntrega;

import errors.AplicationError;

public class EnviarEntregaErrors extends AplicationError {
  public EnviarEntregaErrors(String message) {
    super(message);
  }
}
