package api.usecases.pagamentoAprovado;

public class PagamentoAprovadoInput {
  private String pagamentoId;
  private String nomePagante;

  public PagamentoAprovadoInput() {}

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
