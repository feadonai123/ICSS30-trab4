package events.pedidoEnviado;

import events.base.EventBase;

import models.Produto;
import models.Pedido;
// import persistence.produto.ProdutoPersistence;
import java.util.List;
import events.Event;
import utils.Format;
import errors.AplicationError;

public class PedidoEnviado extends EventBase<String> {
  public PedidoEnviado() {
    super("PRINCIPAL_PEDIDOS_ENVIADOS", Event.PEDIDOS_ENVIADOS);
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
