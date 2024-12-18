package api.usecases.pagamentoRecusado;

public class PagamentoRecusadoInput {
  private String pagamentoId;
  private String nomePagante;

  public PagamentoRecusadoInput() {}

  public String getPagamentoId() {
    return pagamentoId;
  }

  public void setPagamentoId(String pagamentoId) {
    this.pagamentoId = pagamentoId;
  }

  public String getNomePagante() {
    return nomePagante;
  }

  public void setNomePagante(String nomePagante) {
    this.nomePagante = nomePagante;
  }

  public String toString() {
    return "Pagamento: " + pagamentoId + " Nome do Pagante: " + nomePagante;
  }
}
