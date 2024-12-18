package api.usecases.listProdutos;

import models.Produto;

public class DTOListProdutos {
  private String message;
  private String completedAt;
  private DTODataListProdutos data;

  public DTOListProdutos() {}

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

  public DTODataListProdutos getData() {
    return data;
  }

  public void setData(DTODataListProdutos data) {
    this.data = data;
  }
}
