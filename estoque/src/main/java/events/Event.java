package events;

import services.queue.MessageConsumer;
import services.queue.RabbitMQConfig;
import errors.AplicationError;

import events.event1.Event1;
import events.base.EventBase;
import config.Variables;

public class Event {
  public static void run() throws AplicationError {
    Event1 event = new Event1();
    Event.enrollEvent(event);
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
