package api.usecases.enviarEntrega;

public class EnviarEntregaInput {
  private String entregaId;

  public EnviarEntregaInput() {}

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
