package events.pagamentoAprovado;

import events.base.EventBase;

import models.Pedido;
import models.Pagamento;
import models.PedidoStatus;
import persistence.pedido.PedidoPersistence;
import java.util.List;
import events.Event;
import utils.Format;
import errors.AplicationError;

public class PagamentoAprovado extends EventBase<String> {
  public PagamentoAprovado() {
    super("PRINCIPAL_PAGAMENTO_APROVADO", Event.PAGAMENTO_APROVADO);
  }

  public void exec(String input) throws AplicationError {
    Pagamento pagamento = null;
    try{
      pagamento = Format.deserialize(input, Pagamento.class);
    } catch (Exception e) {
      throw new AplicationError("Erro ao deserializar objeto: " + e.getMessage());
    }

    PedidoPersistence persistence = PedidoPersistence.getInstance();
    Pedido pedido = persistence.get(pagamento.getPedidoId());

    if(pedido == null) {
      return;
    }
    
    pedido.setStatus(PedidoStatus.PAGO);
    persistence.update(pedido);
  }
}
