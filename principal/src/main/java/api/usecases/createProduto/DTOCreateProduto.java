package api.usecases.createProduto;

import models.Produto;

public class DTOCreateProduto {
  private String message;
  private String completedAt;
  private Produto data;

  public DTOCreateProduto() {}

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
