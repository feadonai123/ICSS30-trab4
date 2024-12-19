package api.usecases.listPagamentos;

import api.base.Usecase;
import api.usecases.listPagamentos.ListPagamentosInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;

import models.Pagamento;
import models.PagamentoStatus;
import persistence.pagamento.PagamentoPersistence;

import java.util.List;

public class ListPagamentosUsecase extends Usecase<ListPagamentosInput, ListPagamentosOutput> {
  public void validate(ListPagamentosInput input) throws ListPagamentosErrors {}

  public ListPagamentosOutput exec(ListPagamentosInput input) throws ListPagamentosErrors {
    PagamentoPersistence persistence = PagamentoPersistence.getInstance();
    List<Pagamento> pagamentos = persistence.getAll();

    ListPagamentosOutput response = new ListPagamentosOutput();
    response.setPagamentos(pagamentos);

    return response;
  }
}
