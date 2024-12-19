package api.usecases.listPagamentos;

public class ListPagamentosInput {
  private String pagamentoId;

  public ListPagamentosInput() {}

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
