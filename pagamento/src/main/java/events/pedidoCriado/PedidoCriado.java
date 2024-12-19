package events.pedidoCriado;

import events.base.EventBase;

import models.Pagamento;
import models.Pedido;
import models.PagamentoStatus;
import persistence.pagamento.PagamentoPersistence;
import java.util.List;
import events.Event;
import utils.Format;
import errors.AplicationError;

public class PedidoCriado extends EventBase<String> {
  public PedidoCriado() {
    super("PAGAMENTO_PEDIDOS_CRIADOS", Event.PEDIDOS_CRIADOS);
  }

  public void exec(String input) throws AplicationError {
    Pedido pedido = null;
    try{
      pedido = Format.deserialize(input, Pedido.class);
    } catch (Exception e) {
      throw new AplicationError("Erro ao deserializar objeto: " + e.getMessage());
    }

    PagamentoPersistence persistence = PagamentoPersistence.getInstance();
    Pagamento pagamento = new Pagamento(null, pedido.getId(), PagamentoStatus.PENDENTE, null);
    
    persistence.save(pagamento);
  }
}
