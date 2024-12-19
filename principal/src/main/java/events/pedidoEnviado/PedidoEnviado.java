package events.pedidoEnviado;

import events.base.EventBase;

import models.Produto;
import models.Pedido;
import models.PedidoStatus;
import persistence.pedido.PedidoPersistence;
import java.util.List;
import events.Event;
import utils.Format;
import errors.AplicationError;
import models.Entrega;

public class PedidoEnviado extends EventBase<String> {
  public PedidoEnviado() {
    super("PRINCIPAL_PEDIDOS_ENVIADOS", Event.PEDIDOS_ENVIADOS);
  }

  public void exec(String input) throws AplicationError {
    Entrega entrega = null;
    try{
      entrega = Format.deserialize(input, Entrega.class);
    } catch (Exception e) {
      throw new AplicationError("Erro ao deserializar objeto: " + e.getMessage());
    }

    PedidoPersistence persistence = PedidoPersistence.getInstance();
    Pedido pedido = persistence.get(entrega.getPedidoId());

    if(pedido == null) {
      return;
    }
    
    pedido.setStatus(PedidoStatus.ENVIADO);
    persistence.update(pedido);
  }
}
