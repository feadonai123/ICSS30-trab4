package api.usecases.createPedido;

import errors.AplicationError;

public class CreatePedidoErrors extends AplicationError {
  public CreatePedidoErrors(String message) {
    super(message);
  }
}
