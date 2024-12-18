package api.usecases.listPagamentos;

import errors.AplicationError;

public class ListPagamentosErrors extends AplicationError {
  public ListPagamentosErrors(String message) {
    super(message);
  }
}
