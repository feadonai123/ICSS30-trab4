package api.usecases.deleteProduto;

import errors.AplicationError;

public class DeleteProdutoErrors extends AplicationError {
  public DeleteProdutoErrors(String message) {
    super(message);
  }
}
