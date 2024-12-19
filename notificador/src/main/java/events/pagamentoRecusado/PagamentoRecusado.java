package events.pagamentoRecusado;

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

public class PagamentoRecusado extends EventBase<String> {
  public PagamentoRecusado() {
    super("PRINCIPAL_PAGAMENTO_RECUSADO", Event.PAGAMENTO_RECUSADO);
  }

  public void exec(String input) throws AplicationError {
    Pedido pedido = null;
    try {
      pedido = Format.deserialize(input, Pedido.class);
    } catch (Exception e) {
      throw new AplicationError("Erro ao deserializar objeto: " + e.getMessage());
    }

    Notificacao notificacao = new Notificacao("Pagamento recusado", PedidoStatus.RECUSADO, pedido.getId());
    Sink.emit(notificacao);
  }
}
