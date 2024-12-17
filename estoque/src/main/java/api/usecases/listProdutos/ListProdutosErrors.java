package api.usecases.listProdutos;

import errors.AplicationError;

public class ListProdutosErrors extends AplicationError {
  public ListProdutosErrors(String message) {
    super(message);
  }
}
