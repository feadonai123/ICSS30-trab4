package api.usecases.pagamentoAprovado;

import errors.AplicationError;

public class PagamentoAprovadoErrors extends AplicationError {
  public PagamentoAprovadoErrors(String message) {
    super(message);
  }
}
