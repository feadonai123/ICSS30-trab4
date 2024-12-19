package events.pagamentoAprovado;

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

public class PagamentoAprovado extends EventBase<String> {
  public PagamentoAprovado() {
    super("PRINCIPAL_PAGAMENTO_APROVADO", Event.PAGAMENTO_APROVADO);
  }

  public void exec(String input) throws AplicationError {
    Pedido pedido = null;
    try {
      pedido = Format.deserialize(input, Pedido.class);
    } catch (Exception e) {
      throw new AplicationError("Erro ao deserializar objeto: " + e.getMessage());
    }
    // Notificacao notificacao = new Notificacao("O pagamento do pedido foi
    // efetivado", PedidoStatus.PAGADO,
    // pedido.getId());
    // Sink.emit(notificacao);
  }
}
