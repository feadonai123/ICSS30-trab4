package api.usecases.deletePedido;

import api.base.Usecase;
import api.usecases.deletePedido.DeletePedidoInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;

import models.Pedido;
import models.PedidoStatus;
import persistence.pedido.PedidoPersistence;
import utils.Format;
import events.Event;

import java.util.List;

public class DeletePedidoUsecase extends Usecase<DeletePedidoInput, DeletePedidoOutput> {
  public void validate(DeletePedidoInput input) throws DeletePedidoErrors {}

  public DeletePedidoOutput exec(DeletePedidoInput input) throws DeletePedidoErrors {
    PedidoPersistence persistence = PedidoPersistence.getInstance();
    Pedido pedido = persistence.get(input.getPedidoId());
    persistence.delete(input.getPedidoId());
    
    DeletePedidoOutput response = new DeletePedidoOutput();
    response.setId(input.getPedidoId());

    try{
      String message = Format.serialize(pedido);
      RabbitMQConfig config = RabbitMQConfig.getInstance();
      MessageProducer producer = new MessageProducer(config, Variables.RABBITMQ_EXCHANGE, Event.PEDIDOS_EXCLUIDOS);
      producer.sendMessage(message);
    } catch (Exception e) {
      throw new DeletePedidoErrors("Erro ao enviar mensagem para a fila");
    }

    return response;
  }
}
