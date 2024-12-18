package api.usecases.getProduto;

import errors.AplicationError;

public class GetProdutoErrors extends AplicationError {
  public GetProdutoErrors(String message) {
    super(message);
  }
}
