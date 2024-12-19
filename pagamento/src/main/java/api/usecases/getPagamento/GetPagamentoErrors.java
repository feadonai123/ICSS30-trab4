package api.usecases.getPagamento;

import errors.AplicationError;

public class GetPagamentoErrors extends AplicationError {
  public GetPagamentoErrors(String message) {
    super(message);
  }
}
