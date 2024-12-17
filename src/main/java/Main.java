
import config.Variables;
import api.Server;
import events.Event;

import services.queue.RabbitMQConfig;
import services.queue.MessageConsumer;
import services.queue.MessageProducer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import errors.AplicationError;

public class Main {
  public static void main(String[] args) throws AplicationError {
    
    System.out.println("Hello World");
    System.out.println("Port: " + Variables.PORT);

    Server.run(Variables.PORT);
    Event.run();
  }
}