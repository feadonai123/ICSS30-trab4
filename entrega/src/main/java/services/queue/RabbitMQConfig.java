package services.queue;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import config.Variables;

public class RabbitMQConfig {
  private final String host;
  private final int port;
  private final String username;
  private final String password;

  private static RabbitMQConfig instance;

  public RabbitMQConfig(String host, int port, String username, String password) {
    this.host = host;
    this.port = port;
    this.username = username;
    this.password = password;
  }

  public Connection createConnection() throws IOException, TimeoutException{
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost(host);
    factory.setPort(port);
    factory.setUsername(username);
    factory.setPassword(password);
    return factory.newConnection();
  }

  static public RabbitMQConfig getInstance() {
    if (instance == null) {
      instance = new RabbitMQConfig(Variables.RABBITMQ_HOST, Variables.RABBITMQ_PORT, Variables.RABBITMQ_USERNAME, Variables.RABBITMQ_PASSWORD);
    }
    return instance;
  }
}