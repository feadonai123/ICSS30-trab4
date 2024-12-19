package api.usecases.listEntregas;

public class ListEntregasInput {
  private String entregaId;

  public ListEntregasInput() {}

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
