package api.usecases.listPedidos;

import models.Pedido;

import java.util.ArrayList;
import java.util.List;

public class ListPedidosOutput {

  private List<Pedido> pedidos = new ArrayList<Pedido>();

  public List<Pedido> getPedidos() {
    return pedidos;
  }

  public void setPedidos(List<Pedido> pedidos) {
    this.pedidos = pedidos;
  }
}
