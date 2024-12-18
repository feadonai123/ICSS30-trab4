package api.usecases.createProduto;

import errors.AplicationError;

public class CreateProdutoErrors extends AplicationError {
  public CreateProdutoErrors(String message) {
    super(message);
  }
}
