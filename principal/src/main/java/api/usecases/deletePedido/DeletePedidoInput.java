package api.usecases.deletePedido;

public class DeletePedidoInput {
  private String pedidoId;

  public DeletePedidoInput() {}

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
