package api.usecases.pagamentoRecusado;

import api.base.Usecase;
import api.usecases.pagamentoRecusado.PagamentoRecusadoInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;

import models.Pagamento;
import models.PagamentoStatus;
import events.Event;
import persistence.pagamento.PagamentoPersistence;
import utils.Format;

public class PagamentoRecusadoUsecase extends Usecase<PagamentoRecusadoInput, PagamentoRecusadoOutput> {
  public void validate(PagamentoRecusadoInput input) throws PagamentoRecusadoErrors {
    if (input.getPagamentoId() == null || input.getPagamentoId().isEmpty()) {
      throw new PagamentoRecusadoErrors("PagamentoId não pode ser vazio");
    }
  }

  public PagamentoRecusadoOutput exec(PagamentoRecusadoInput input) throws PagamentoRecusadoErrors {
    PagamentoPersistence persistence = PagamentoPersistence.getInstance();
    Pagamento pagamento = persistence.get(input.getPagamentoId());

    if(pagamento == null) {
      throw new PagamentoRecusadoErrors("Pagamento não encontrado");
    }

    pagamento.setStatus(PagamentoStatus.RECUSADO);
    pagamento.setNomePagante(input.getNomePagante());

    persistence.update(pagamento);

    try{
      String message = Format.serialize(pagamento);
      RabbitMQConfig config = RabbitMQConfig.getInstance();
      MessageProducer producer = new MessageProducer(config, Variables.RABBITMQ_EXCHANGE, Event.PAGAMENTO_RECUSADO);
      producer.sendMessage(message);
    } catch (Exception e) {
      throw new PagamentoRecusadoErrors("Erro ao enviar mensagem para a fila");
    }

    PagamentoRecusadoOutput response = new PagamentoRecusadoOutput();
    response.setId(pagamento.getId());
    response.setPedidoId(pagamento.getPedidoId());
    response.setStatus(pagamento.getStatus());
    response.setNomePagante(pagamento.getNomePagante());

    return response;
  }
}
