package api.usecases.getPagamento;

public class GetPagamentoInput {
  private String pagamentoId;

  public GetPagamentoInput() {}

  public String getPagamentoId() {
    return pagamentoId;
  }

  public void setPagamentoId(String pagamentoId) {
    this.pagamentoId = pagamentoId;
  }

  public String toString() {
    return "Pagamento: " + pagamentoId;
  }
}
