package api.usecases.listEntregas;

import models.Entrega;

import java.util.ArrayList;
import java.util.List;

public class ListEntregasOutput {

  private List<Entrega> entregas = new ArrayList<Entrega>();

  public List<Entrega> getEntregas() {
    return entregas;
  }

  public void setEntregas(List<Entrega> entregas) {
    this.entregas = entregas;
  }
}
