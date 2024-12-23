package events.pagamentoRecusado;

import events.base.EventBase;

import models.Pedido;
import models.Pagamento;
import models.PedidoStatus;
import persistence.pedido.PedidoPersistence;
import config.Variables;
import java.util.List;
import events.Event;
import utils.Format;
import errors.AplicationError;
import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;

public class PagamentoRecusado extends EventBase<String> {
  public PagamentoRecusado() {
    super("PRINCIPAL_PAGAMENTO_RECUSADO", Event.PAGAMENTO_RECUSADO);
  }

  public void exec(String input) throws AplicationError {
    Pagamento pagamento = null;
    try{
      pagamento = Format.deserialize(input, Pagamento.class);
    } catch (Exception e) {
      throw new AplicationError("Erro ao deserializar objeto: " + e.getMessage());
    }

    PedidoPersistence persistence = PedidoPersistence.getInstance();
    Pedido pedido = persistence.get(pagamento.getPedidoId());
    if(pedido == null) {
      return;
    }
    try {
          String message = Format.serialize(pedido);
          RabbitMQConfig config = RabbitMQConfig.getInstance();
          MessageProducer producer = new MessageProducer(config, Variables.RABBITMQ_EXCHANGE, Event.PEDIDOS_EXCLUIDOS);
          producer.sendMessage(message);
    } catch (Exception e) {
      throw new AplicationError("Erro ao enviar mensagem para a fila");
    }
    pedido.setStatus(PedidoStatus.REJEITADO);
    persistence.update(pedido);
  }
}
