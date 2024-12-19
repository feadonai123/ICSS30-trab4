package api.usecases.getPedido;

import api.base.Usecase;
import api.usecases.getPedido.GetPedidoInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;

import models.Pedido;
import models.PedidoStatus;
import persistence.pedido.PedidoPersistence;

import java.util.List;

public class GetPedidoUsecase extends Usecase<GetPedidoInput, GetPedidoOutput> {
  public void validate(GetPedidoInput input) throws GetPedidoErrors {}

  public GetPedidoOutput exec(GetPedidoInput input) throws GetPedidoErrors {
    PedidoPersistence persistence = PedidoPersistence.getInstance();
    Pedido pedido = persistence.get(input.getPedidoId());

    if(pedido == null) {
      throw new GetPedidoErrors("Pedido não encontrado");
    }

    GetPedidoOutput response = new GetPedidoOutput();
    response.setId(pedido.getId());
    response.setProdutoId(pedido.getProdutoId());
    response.setQuantidade(pedido.getQuantidade());
    response.setNomeComprador(pedido.getNomeComprador());
    response.setStatus(pedido.getStatus().toString());

    return response;
  }
}
