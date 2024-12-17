package api.usecases.createPedido;

public class CreatePedidoInput {
  private String produtoId;
  private Number quantidade;
  private String nomeComprador;

  public CreatePedidoInput() {}

  public String getProdutoId() {
    return produtoId;
  }

  public void setProdutoId(String produtoId) {
    this.produtoId = produtoId;
  }

  public Number getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Number quantidade) {
    this.quantidade = quantidade;
  }

  public String getNomeComprador() {
    return nomeComprador;
  }

  public void setNomeComprador(String nomeComprador) {
    this.nomeComprador = nomeComprador;
  }

  public String toString() {
    return "Produto: " + produtoId + " Quantidade: " + quantidade + " Nome do comprador: " + nomeComprador;
  }
}
