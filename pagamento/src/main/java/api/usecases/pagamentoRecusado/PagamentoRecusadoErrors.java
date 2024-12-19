package api.usecases.pagamentoRecusado;

import errors.AplicationError;

public class PagamentoRecusadoErrors extends AplicationError {
  public PagamentoRecusadoErrors(String message) {
    super(message);
  }
}
