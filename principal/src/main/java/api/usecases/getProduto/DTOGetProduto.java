package api.usecases.getProduto;

import models.Produto;

public class DTOGetProduto {
  private String message;
  private String completedAt;
  private Produto data;

  public DTOGetProduto() {}

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getCompletedAt() {
    return completedAt;
  }

  public void setCompletedAt(String completedAt) {
    this.completedAt = completedAt;
  }

  public Produto getData() {
    return data;
  }

  public void setData(Produto data) {
    this.data = data;
  }
}
