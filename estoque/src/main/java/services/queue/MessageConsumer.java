package services.queue;

import com.rabbitmq.client.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class MessageConsumer {

    private final RabbitMQConfig config;
    private final String queueName;
    private final String exchangeName;
    private final String routingKey;
    private final ConsumerHandler consumerHandler;

    public MessageConsumer(RabbitMQConfig config, String queueName, String exchangeName, String routingKey, ConsumerHandler consumerHandler) {
        this.config = config;
        this.queueName = queueName;
        this.exchangeName = exchangeName;
        this.routingKey = routingKey;
        this.consumerHandler = consumerHandler;
    }

    public void startConsuming() throws IOException, TimeoutException {
        Connection connection = config.createConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(exchangeName, "direct", true);
        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, exchangeName, routingKey);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            consumerHandler.handleMessage(message);
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {});
    }

    // Interface funcional para lidar com a mensagem recebida
    public interface ConsumerHandler {
        void handleMessage(String message);
    }
}