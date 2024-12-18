package events.pagamentoRecusado;

import events.base.EventBase;

import models.Produto;
import models.Pedido;
// import persistence.produto.ProdutoPersistence;
import java.util.List;
import events.Event;
import utils.Format;
import errors.AplicationError;

public class PagamentoRecusado extends EventBase<String> {
  public PagamentoRecusado() {
    super("PRINCIPAL_PAGAMENTO_RECUSADO", Event.PAGAMENTO_RECUSADO);
  }

  public void exec(String input) throws AplicationError {
    // Pedido pedido = null;
    // try{
    //   pedido = Format.deserialize(input, Pedido.class);
    // } catch (Exception e) {
    //   throw new AplicationError("Erro ao deserializar objeto: " + e.getMessage());
    // }

    // ProdutoPersistence persistence = ProdutoPersistence.getInstance();
    // Produto produto = persistence.get(pedido.getProdutoId());

    // if(produto == null) {
    //   return;
    // }
    
    // produto.setQuantidade(produto.getQuantidade() + pedido.getQuantidade());
    // persistence.update(produto);
  }
}
