package api.usecases.createPedido;

import api.base.Usecase;
import api.usecases.createPedido.CreatePedidoInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;

import models.Pedido;
import models.PedidoStatus;
import persistence.pedido.PedidoPersistence;

public class CreatePedidoUsecase extends Usecase<CreatePedidoInput, CreatePedidoOutput> {
  public void validate(CreatePedidoInput input) throws CreatePedidoErrors {
    if (input.getProdutoId() == null || input.getProdutoId().isEmpty()) {
      throw new CreatePedidoErrors("ProdutoId não pode ser vazio");
    }
    if (input.getQuantidade() == null || input.getQuantidade().intValue() <= 0) {
      throw new CreatePedidoErrors("Quantidade deve ser maior que 0");
    }
    if (input.getNomeComprador() == null || input.getNomeComprador().isEmpty()) {
      throw new CreatePedidoErrors("Nome do comprador não pode ser vazio");
    }
  }


  public CreatePedidoOutput exec(CreatePedidoInput input) throws CreatePedidoErrors {
    Pedido pedido = new Pedido(input.getProdutoId(), input.getQuantidade(), input.getNomeComprador(), PedidoStatus.CRIADO);
    PedidoPersistence persistence = PedidoPersistence.getInstance();
    persistence.save(pedido);

    CreatePedidoOutput response = new CreatePedidoOutput();
    response.setId(pedido.getId());
    response.setProdutoId(pedido.getProdutoId());
    response.setQuantidade(pedido.getQuantidade());
    response.setNomeComprador(pedido.getNomeComprador());
    response.setStatus(pedido.getStatus().toString());

    // String routingKey = "event1";
    // try{
    //   RabbitMQConfig config = RabbitMQConfig.getInstance();
    //   MessageProducer producer = new MessageProducer(config, Variables.RABBITMQ_EXCHANGE, routingKey);
    //   producer.sendMessage("Hello, RabbitMQ!");
    // } catch (Exception e) {
    //   throw new CreatePedidoErrors("Erro ao enviar mensagem para a fila");
    // }

    return response;
  }
}
