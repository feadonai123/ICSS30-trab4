package api.usecases.pagamentoAprovado;

import api.base.Usecase;
import api.usecases.pagamentoAprovado.PagamentoAprovadoInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;

import models.Pagamento;
import models.PagamentoStatus;
import events.Event;
import persistence.pagamento.PagamentoPersistence;
import utils.Format;

public class PagamentoAprovadoUsecase extends Usecase<PagamentoAprovadoInput, PagamentoAprovadoOutput> {
  public void validate(PagamentoAprovadoInput input) throws PagamentoAprovadoErrors {
    if (input.getPagamentoId() == null || input.getPagamentoId().isEmpty()) {
      throw new PagamentoAprovadoErrors("PagamentoId não pode ser vazio");
    }
  }

  public PagamentoAprovadoOutput exec(PagamentoAprovadoInput input) throws PagamentoAprovadoErrors {
    PagamentoPersistence persistence = PagamentoPersistence.getInstance();
    Pagamento pagamento = persistence.get(input.getPagamentoId());

    if(pagamento == null) {
      throw new PagamentoAprovadoErrors("Pagamento não encontrado");
    }

    pagamento.setStatus(PagamentoStatus.APROVADO);
    pagamento.setNomePagante(input.getNomePagante());

    persistence.update(pagamento);

    try{
      String message = Format.serialize(pagamento);
      RabbitMQConfig config = RabbitMQConfig.getInstance();
      MessageProducer producer = new MessageProducer(config, Variables.RABBITMQ_EXCHANGE, Event.PAGAMENTO_APROVADO);
      producer.sendMessage(message);
    } catch (Exception e) {
      throw new PagamentoAprovadoErrors("Erro ao enviar mensagem para a fila");
    }

    PagamentoAprovadoOutput response = new PagamentoAprovadoOutput();
    response.setId(pagamento.getId());
    response.setPedidoId(pagamento.getPedidoId());
    response.setStatus(pagamento.getStatus());
    response.setNomePagante(pagamento.getNomePagante());

    return response;
  }
}
