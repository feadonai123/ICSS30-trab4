package api.usecases.enviarEntrega;

import api.base.Usecase;
import api.usecases.enviarEntrega.EnviarEntregaInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;

import models.Entrega;
import models.EntregaStatus;
import persistence.entrega.EntregaPersistence;

import java.util.List;
import utils.Format;
import events.Event;

public class EnviarEntregaUsecase extends Usecase<EnviarEntregaInput, EnviarEntregaOutput> {
  public void validate(EnviarEntregaInput input) throws EnviarEntregaErrors {}

  public EnviarEntregaOutput exec(EnviarEntregaInput input) throws EnviarEntregaErrors {
    EntregaPersistence persistence = EntregaPersistence.getInstance();
    Entrega entrega = persistence.get(input.getEntregaId());

    if(entrega == null) {
      throw new EnviarEntregaErrors("Entrega não encontrado");
    }

    entrega.setStatus(EntregaStatus.ENVIADO);

    try{
      String message = Format.serialize(entrega);
      RabbitMQConfig config = RabbitMQConfig.getInstance();
      MessageProducer producer = new MessageProducer(config, Variables.RABBITMQ_EXCHANGE, Event.PEDIDOS_ENVIADOS);
      producer.sendMessage(message);
    } catch (Exception e) {
      throw new EnviarEntregaErrors("Erro ao enviar mensagem para a fila");
    }

    EnviarEntregaOutput response = new EnviarEntregaOutput();
    response.setId(entrega.getId());
    response.setPedidoId(entrega.getPedidoId());
    response.setStatus(entrega.getStatus());

    return response;
  }
}
