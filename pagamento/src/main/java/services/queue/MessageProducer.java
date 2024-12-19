package services.queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class MessageProducer {

    private final RabbitMQConfig config;
    private final String exchangeName;
    private final String routingKey;

    public MessageProducer(RabbitMQConfig config, String exchangeName, String routingKey) {
        this.config = config;
        this.exchangeName = exchangeName;
        this.routingKey = routingKey;
    }

    public void sendMessage(String message) throws IOException, TimeoutException {
          try (Connection connection = config.createConnection();
             Channel channel = connection.createChannel()){
            channel.exchangeDeclare(exchangeName, "direct", true);
            channel.basicPublish(exchangeName, routingKey, null, message.getBytes(StandardCharsets.UTF_8));
        }
    }
}