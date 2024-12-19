package events.pagamentoAprovado;

import events.base.EventBase;

import models.Entrega;
import models.Pagamento;
import models.EntregaStatus;
import persistence.entrega.EntregaPersistence;
import java.util.List;
import events.Event;
import utils.Format;
import errors.AplicationError;

public class PagamentoAprovado extends EventBase<String> {
  public PagamentoAprovado() {
    super("ENTREGA_PAGAMENTO_APROVADO", Event.PAGAMENTO_APROVADO);
  }

  public void exec(String input) throws AplicationError {
    Pagamento pagamento = null;
    try{
      pagamento = Format.deserialize(input, Pagamento.class);
    } catch (Exception e) {
      throw new AplicationError("Erro ao deserializar objeto: " + e.getMessage());
    }

    EntregaPersistence persistence = EntregaPersistence.getInstance();
    Entrega entrega = new Entrega(null, pagamento.getPedidoId(), EntregaStatus.PENDENTE);

    persistence.save(entrega);
  }
}
