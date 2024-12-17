package api.usecases.getPedido;

public class GetPedidoOutput {
  private String id;
  private String status;
  private String produtoId;
  private Number quantidade;
  private String nomeComprador;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

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
}
