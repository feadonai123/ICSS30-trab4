package api.usecases.teste;

import utils.ExampleUtil;
import api.base.Usecase;
import api.usecases.teste.TesteInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;

public class TesteUsecase extends Usecase<TesteInput, TesteOutput> {
  public TesteOutput exec(TesteInput input) throws TesteErrors {
    ExampleUtil example = new ExampleUtil();
    example.exec();

    TesteOutput response = new TesteOutput();
    response.setMessage("Hello " + input.getName());

    String routingKey = "event1";
    try{
      RabbitMQConfig config = RabbitMQConfig.getInstance();
      MessageProducer producer = new MessageProducer(config, Variables.RABBITMQ_EXCHANGE, routingKey);
      producer.sendMessage("Hello, RabbitMQ!");
    } catch (Exception e) {
      throw new TesteErrors("Erro ao enviar mensagem para a fila");
    }

    return response;
  }
}
