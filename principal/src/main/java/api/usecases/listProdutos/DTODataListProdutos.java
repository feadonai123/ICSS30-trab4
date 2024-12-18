package api.usecases.listProdutos;

import models.Produto;
import java.util.List;

public class DTODataListProdutos {
  private List<Produto> produtos;

  public DTODataListProdutos(){}

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }
}