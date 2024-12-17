package api.usecases.getPedido;

public class GetPedidoInput {
  private String pedidoId;

  public GetPedidoInput() {}

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
