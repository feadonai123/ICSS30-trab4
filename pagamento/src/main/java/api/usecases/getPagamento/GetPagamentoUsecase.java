package api.usecases.getPagamento;

import api.base.Usecase;
import api.usecases.getPagamento.GetPagamentoInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;

import models.Pagamento;
import models.PagamentoStatus;
import persistence.pagamento.PagamentoPersistence;

import java.util.List;

public class GetPagamentoUsecase extends Usecase<GetPagamentoInput, GetPagamentoOutput> {
  public void validate(GetPagamentoInput input) throws GetPagamentoErrors {}

  public GetPagamentoOutput exec(GetPagamentoInput input) throws GetPagamentoErrors {
    PagamentoPersistence persistence = PagamentoPersistence.getInstance();
    Pagamento pagamento = persistence.get(input.getPagamentoId());

    if(pagamento == null) {
      throw new GetPagamentoErrors("Pagamento não encontrado");
    }

    GetPagamentoOutput response = new GetPagamentoOutput();
    response.setId(pagamento.getId());
    response.setPedidoId(pagamento.getPedidoId());
    response.setStatus(pagamento.getStatus());
    response.setNomePagante(pagamento.getNomePagante());

    return response;
  }
}
