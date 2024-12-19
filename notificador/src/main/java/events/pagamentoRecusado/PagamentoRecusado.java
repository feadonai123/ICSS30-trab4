package events.pagamentoRecusado;

import events.base.EventBase;
import main.java.models.Notificacao;
import main.java.utils.Sink;
import models.Produto;
import models.Pedido;
import models.Pagamento;
import models.PedidoStatus;

import java.util.List;
import events.Event;
import utils.Format;
import errors.AplicationError;

public class PagamentoRecusado extends EventBase<String> {
  public PagamentoRecusado() {
    super("NOTIFICADOR_PAGAMENTO_RECUSADO", Event.PAGAMENTO_RECUSADO);
  }

  public void exec(String input) throws AplicationError {
    Pagamento pagamento = null;
    try{
      pagamento = Format.deserialize(input, Pagamento.class);
    } catch (Exception e) {
      throw new AplicationError("Erro ao deserializar objeto: " + e.getMessage());
    }

    // Notificacao notificacao = new Notificacao("O pagamento do pedido foi recusado", PedidoStatus.PAGADO, pagamento.getPedidoId());
    // Sink.emit(notificacao);
  }
}
