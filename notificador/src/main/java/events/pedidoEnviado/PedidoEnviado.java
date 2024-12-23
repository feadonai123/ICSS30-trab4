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
import models.Entrega;

public class PedidoEnviado extends EventBase<String> {
  public PedidoEnviado() {
    super("NOTIFICADOR_PEDIDOS_ENVIADOS", Event.PEDIDOS_ENVIADOS);
  }

  public void exec(String input) throws AplicationError {
    Entrega entrega = null;
    try{
      entrega = Format.deserialize(input, Entrega.class);
    } catch (Exception e) {
      throw new AplicationError("Erro ao deserializar objeto: " + e.getMessage());
    }

    Notificacao notificacao = new Notificacao("Pedido enviado", PedidoStatus.ENVIADO, entrega.getPedidoId());
    var sink = Sink.getInstance();
    try {
        System.out.println("Enviando evento: " + notificacao);
        sink.emit(notificacao);
        System.out.println("Evento enviado com sucesso");
    } catch (Exception e) {
        System.err.println("Erro ao enviar evento: " + e.getMessage());
    }
  }
}
