package api.usecases.listEntregas;

import api.base.Usecase;
import api.usecases.listEntregas.ListEntregasInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;

import models.Entrega;
import models.EntregaStatus;
import persistence.entrega.EntregaPersistence;

import java.util.List;

public class ListEntregasUsecase extends Usecase<ListEntregasInput, ListEntregasOutput> {
  public void validate(ListEntregasInput input) throws ListEntregasErrors {}

  public ListEntregasOutput exec(ListEntregasInput input) throws ListEntregasErrors {
    EntregaPersistence persistence = EntregaPersistence.getInstance();
    List<Entrega> entregas = persistence.getAll();

    ListEntregasOutput response = new ListEntregasOutput();
    response.setEntregas(entregas);

    return response;
  }
}
