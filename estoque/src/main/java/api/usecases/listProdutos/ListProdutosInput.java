package api.usecases.listProdutos;

public class ListProdutosInput {
  private String produtoId;

  public ListProdutosInput() {}

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
