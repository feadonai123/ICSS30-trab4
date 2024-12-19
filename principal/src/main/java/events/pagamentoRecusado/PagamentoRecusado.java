package events.pagamentoRecusado;

import events.base.EventBase;

import models.Pedido;
import models.Pagamento;
import models.PedidoStatus;
import persistence.pedido.PedidoPersistence;
import java.util.List;
import events.Event;
import utils.Format;
import errors.AplicationError;

public class PagamentoRecusado extends EventBase<String> {
  public PagamentoRecusado() {
    super("PRINCIPAL_PAGAMENTO_RECUSADO", Event.PAGAMENTO_RECUSADO);
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
    
    pedido.setStatus(PedidoStatus.REJEITADO);
    persistence.update(pedido);
  }
}
