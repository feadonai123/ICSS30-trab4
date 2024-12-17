package api.usecases.deletePedido;

import errors.AplicationError;

public class DeletePedidoErrors extends AplicationError {
  public DeletePedidoErrors(String message) {
    super(message);
  }
}
