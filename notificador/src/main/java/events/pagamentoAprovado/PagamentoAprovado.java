package events.pagamentoAprovado;

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

public class PagamentoAprovado extends EventBase<String> {
  public PagamentoAprovado() {
    super("NOTIFICADOR_PAGAMENTO_APROVADO", Event.PAGAMENTO_APROVADO);
  }

  public void exec(String input) throws AplicationError {
    Pagamento pagamento = null;
    try{
      pagamento = Format.deserialize(input, Pagamento.class);
    } catch (Exception e) {
      throw new AplicationError("Erro ao deserializar objeto: " + e.getMessage());
    }

    Notificacao notificacao = new Notificacao("Pedido pago com sucesso", PedidoStatus.PAGADO, pagamento.getPedidoId());
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
