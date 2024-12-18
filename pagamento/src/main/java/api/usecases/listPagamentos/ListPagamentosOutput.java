package api.usecases.listPagamentos;

import models.Pagamento;

import java.util.ArrayList;
import java.util.List;

public class ListPagamentosOutput {

  private List<Pagamento> pagamentos = new ArrayList<Pagamento>();

  public List<Pagamento> getPagamentos() {
    return pagamentos;
  }

  public void setPagamentos(List<Pagamento> pagamentos) {
    this.pagamentos = pagamentos;
  }
}
