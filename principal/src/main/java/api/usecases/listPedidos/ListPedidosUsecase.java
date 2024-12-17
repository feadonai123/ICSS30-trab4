package api.usecases.listPedidos;

import api.base.Usecase;
import api.usecases.listPedidos.ListPedidosInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;

import models.Pedido;
import models.PedidoStatus;
import persistence.pedido.PedidoPersistence;

import java.util.List;

public class ListPedidosUsecase extends Usecase<ListPedidosInput, ListPedidosOutput> {
  public void validate(ListPedidosInput input) throws ListPedidosErrors {}

  public ListPedidosOutput exec(ListPedidosInput input) throws ListPedidosErrors {
    PedidoPersistence persistence = PedidoPersistence.getInstance();
    List<Pedido> pedidos = persistence.getAll();

    ListPedidosOutput response = new ListPedidosOutput();
    response.setPedidos(pedidos);

    return response;
  }
}
