package api.usecases.createPedido;

public class CreatePedidoOutput {
  private String id;
  private String status;
  private String produtoId;
  private Integer quantidade;
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

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public String getNomeComprador() {
    return nomeComprador;
  }

  public void setNomeComprador(String nomeComprador) {
    this.nomeComprador = nomeComprador;
  }
}
