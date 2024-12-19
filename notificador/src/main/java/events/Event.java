package events;

import services.queue.MessageConsumer;
import services.queue.RabbitMQConfig;
import errors.AplicationError;

import events.pagamentoAprovado.PagamentoAprovado;
import events.pagamentoRecusado.PagamentoRecusado;
import events.pedidoEnviado.PedidoEnviado;
import main.java.events.pedidoCriado.PedidoCriado;
import events.base.EventBase;
import config.Variables;

public class Event {

  public static String PAGAMENTO_APROVADO = "pagamento_aprovado";
  public static String PAGAMENTO_RECUSADO = "pagamento_recusado";
  public static String PEDIDOS_ENVIADOS = "pedidos_enviados";
  public static String PEDIDOS_CRIADOS = "pedidos_criados";
  public static String PEDIDOS_EXCLUIDOS = "pedidos_excluidos";

  public static void run() throws AplicationError {
    PagamentoAprovado pagamentoAprovado = new PagamentoAprovado();
    Event.enrollEvent(pagamentoAprovado);

    PagamentoRecusado pagamentoRecusado = new PagamentoRecusado();
    Event.enrollEvent(pagamentoRecusado);

    PedidoEnviado pedidoEnviado = new PedidoEnviado();
    Event.enrollEvent(pedidoEnviado);

    PedidoCriado pedidoCriado = new PedidoCriado();
    Event.enrollEvent(pedidoCriado);
  }

  private static void enrollEvent(EventBase event) throws AplicationError {
    try {
      RabbitMQConfig config = RabbitMQConfig.getInstance();
      MessageConsumer consumer = new MessageConsumer(config, event.getQueueName(), Variables.RABBITMQ_EXCHANGE,
          event.getRoutingKey(), (message) -> {
            try {
              event.run(message);
            } catch (AplicationError e) {
            } finally {
            }
          });
      consumer.startConsuming();
    } catch (Exception e) {
      throw new AplicationError("Error enrolling event: " + e.getMessage());
    }
  }
}
