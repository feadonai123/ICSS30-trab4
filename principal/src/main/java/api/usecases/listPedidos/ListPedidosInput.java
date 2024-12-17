package api.usecases.listPedidos;

public class ListPedidosInput {
  private String pedidoId;

  public ListPedidosInput() {}

  public String getPedidoId() {
    return pedidoId;
  }

  public void setPedidoId(String pedidoId) {
    this.pedidoId = pedidoId;
  }

  public String toString() {
    return "Pedido: " + pedidoId;
  }
}
