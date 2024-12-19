package api.usecases.getEntrega;

public class GetEntregaInput {
  private String entregaId;

  public GetEntregaInput() {}

  public String getEntregaId() {
    return entregaId;
  }

  public void setEntregaId(String entregaId) {
    this.entregaId = entregaId;
  }

  public String toString() {
    return "Entrega: " + entregaId;
  }
}
