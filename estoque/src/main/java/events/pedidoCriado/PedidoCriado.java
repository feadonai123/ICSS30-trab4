package events.pedidoCriado;

import events.base.EventBase;

import models.Produto;
import models.Pedido;
import persistence.produto.ProdutoPersistence;
import java.util.List;
import events.Event;
import utils.Format;
import errors.AplicationError;

public class PedidoCriado extends EventBase<String> {
  public PedidoCriado() {
    super("ESTOQUE_PEDIDOS_CRIADOS", Event.PEDIDOS_CRIADOS);
  }

  public void exec(String input) throws AplicationError {
    System.out.println("PedidoCriado: " + input);
    Pedido pedido = null;
    try{
      pedido = Format.deserialize(input, Pedido.class);
    } catch (Exception e) {
      System.out.println("Erro ao deserializar objeto: " + e.getMessage());
      throw new AplicationError("Erro ao deserializar objeto: " + e.getMessage());
    }

    ProdutoPersistence persistence = ProdutoPersistence.getInstance();
    Produto produto = persistence.get(pedido.getProdutoId());

    if(produto == null) {
      return;
    }
    
    produto.setQuantidade(produto.getQuantidade() - pedido.getQuantidade());
    persistence.update(produto);
  }
}
