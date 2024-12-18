package api.usecases.deleteProduto;

public class DeleteProdutoInput {
  private String produtoId;

  public DeleteProdutoInput() {}

  public String getProdutoId() {
    return produtoId;
  }

  public void setProdutoId(String produtoId) {
    this.produtoId = produtoId;
  }

  public String toString() {
    return "Produto: " + produtoId;
  }
}
