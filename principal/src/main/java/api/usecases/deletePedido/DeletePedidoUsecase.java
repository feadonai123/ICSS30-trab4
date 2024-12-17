package api.usecases.deletePedido;

import api.base.Usecase;
import api.usecases.deletePedido.DeletePedidoInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;

import models.Pedido;
import models.PedidoStatus;
import persistence.pedido.PedidoPersistence;

import java.util.List;

public class DeletePedidoUsecase extends Usecase<DeletePedidoInput, DeletePedidoOutput> {
  public void validate(DeletePedidoInput input) throws DeletePedidoErrors {}

  public DeletePedidoOutput exec(DeletePedidoInput input) throws DeletePedidoErrors {
    PedidoPersistence persistence = PedidoPersistence.getInstance();
    persistence.delete(input.getPedidoId());
    
    DeletePedidoOutput response = new DeletePedidoOutput();
    response.setId(input.getPedidoId());

    return response;
  }
}
