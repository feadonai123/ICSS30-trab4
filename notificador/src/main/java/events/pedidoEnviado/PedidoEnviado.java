package events.pedidoEnviado;

import events.base.EventBase;
import main.java.models.Notificacao;
import main.java.utils.Sink;
import models.Produto;
import models.Pedido;
import models.PedidoStatus;
import java.util.List;
import events.Event;
import utils.Format;
import errors.AplicationError;

public class PedidoEnviado extends EventBase<String> {
  public PedidoEnviado() {
    super("PRINCIPAL_PEDIDOS_ENVIADOS", Event.PEDIDOS_ENVIADOS);
  }

  public void exec(String input) throws AplicationError {
    Pedido pedido = null;
    try {
      pedido = Format.deserialize(input, Pedido.class);
    } catch (Exception e) {
      throw new AplicationError("Erro ao deserializar objeto: " + e.getMessage());
    }

    // Notificacao notificacao = new Notificacao("Pedido enviado",
    // PedidoStatus.ENVIADO, pedido.getId());
    // Sink.emit(notificacao);
  }
}
