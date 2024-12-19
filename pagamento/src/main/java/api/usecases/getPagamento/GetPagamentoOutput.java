package api.usecases.getPagamento;

public class GetPagamentoOutput {
  private String id;
  private String pedidoId;
  private String status;
  private String nomePagante;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPedidoId() {
    return pedidoId;
  }

  public void setPedidoId(String pedidoId) {
    this.pedidoId = pedidoId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getNomePagante() {
    return nomePagante;
  }

  public void setNomePagante(String nomePagante) {
    this.nomePagante = nomePagante;
  }
}
