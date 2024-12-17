package api.usecases.getPedido;

import errors.AplicationError;

public class GetPedidoErrors extends AplicationError {
  public GetPedidoErrors(String message) {
    super(message);
  }
}
