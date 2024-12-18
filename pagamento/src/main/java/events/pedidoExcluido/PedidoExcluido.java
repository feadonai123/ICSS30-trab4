package events.pedidoExcluido;

import events.base.EventBase;

import models.Pagamento;
import models.Pedido;
import persistence.pagamento.PagamentoPersistence;
import java.util.List;
import events.Event;
import utils.Format;
import errors.AplicationError;

public class PedidoExcluido extends EventBase<String> {
  public PedidoExcluido() {
    super("PAGAMENTO_PEDIDOS_EXCLUIDOS", Event.PEDIDOS_EXCLUIDOS);
  }

  public void exec(String input) throws AplicationError {
    Pedido pedido = null;
    try{
      pedido = Format.deserialize(input, Pedido.class);
    } catch (Exception e) {
      throw new AplicationError("Erro ao deserializar objeto: " + e.getMessage());
    }

    PagamentoPersistence persistence = PagamentoPersistence.getInstance();
    Pagamento pagamento = persistence.getByPedidoId(pedido.getId());

    if(pagamento == null) {
      return;
    }
    
    persistence.delete(pagamento.getId());
  }
}
