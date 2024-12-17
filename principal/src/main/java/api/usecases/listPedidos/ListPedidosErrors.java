package api.usecases.listPedidos;

import errors.AplicationError;

public class ListPedidosErrors extends AplicationError {
  public ListPedidosErrors(String message) {
    super(message);
  }
}
