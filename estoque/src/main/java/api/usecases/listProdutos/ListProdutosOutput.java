package api.usecases.listProdutos;

import models.Produto;

import java.util.ArrayList;
import java.util.List;

public class ListProdutosOutput {

  private List<Produto> produtos = new ArrayList<Produto>();

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }
}
