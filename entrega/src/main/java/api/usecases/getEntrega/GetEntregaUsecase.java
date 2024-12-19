package api.usecases.getEntrega;

import api.base.Usecase;
import api.usecases.getEntrega.GetEntregaInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;

import models.Entrega;
import models.EntregaStatus;
import persistence.entrega.EntregaPersistence;

import java.util.List;

public class GetEntregaUsecase extends Usecase<GetEntregaInput, GetEntregaOutput> {
  public void validate(GetEntregaInput input) throws GetEntregaErrors {}

  public GetEntregaOutput exec(GetEntregaInput input) throws GetEntregaErrors {
    EntregaPersistence persistence = EntregaPersistence.getInstance();
    Entrega entrega = persistence.get(input.getEntregaId());

    if(entrega == null) {
      throw new GetEntregaErrors("Entrega não encontrado");
    }

    GetEntregaOutput response = new GetEntregaOutput();
    response.setId(entrega.getId());
    response.setPedidoId(entrega.getPedidoId());
    response.setStatus(entrega.getStatus());

    return response;
  }
}
