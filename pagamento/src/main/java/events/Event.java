package events;

import services.queue.MessageConsumer;
import services.queue.RabbitMQConfig;
import errors.AplicationError;

import events.pedidoCriado.PedidoCriado;
import events.pedidoExcluido.PedidoExcluido;

import events.base.EventBase;
import config.Variables;

public class Event {

  public static String PAGAMENTO_APROVADO = "pagamento_aprovado";
  public static String PAGAMENTO_RECUSADO = "pagamento_recusado";
  public static String PEDIDOS_ENVIADOS = "pedidos_enviados";
  public static String PEDIDOS_CRIADOS = "pedidos_criados";
  public static String PEDIDOS_EXCLUIDOS = "pedidos_excluidos";

  public static void run() throws AplicationError {
    PedidoCriado pedidoCriado = new PedidoCriado();
    Event.enrollEvent(pedidoCriado);

    PedidoExcluido pedidoExcluido = new PedidoExcluido();
    Event.enrollEvent(pedidoExcluido);
  }
  private static void enrollEvent(EventBase event) throws AplicationError {
    try{
      RabbitMQConfig config = RabbitMQConfig.getInstance();
      MessageConsumer consumer = new MessageConsumer(config, event.getQueueName(), Variables.RABBITMQ_EXCHANGE, event.getRoutingKey(), (message) -> {
        try{
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
