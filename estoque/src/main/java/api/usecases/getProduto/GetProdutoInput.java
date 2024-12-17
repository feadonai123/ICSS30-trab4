package api.usecases.getProduto;

public class GetProdutoInput {
  private String produtoId;

  public GetProdutoInput() {}

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
