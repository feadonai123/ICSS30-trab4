package persistence.produto;

import java.util.List;

import models.Produto;
import persistence.base.PersistenceBase;
import java.util.ArrayList;
import java.util.UUID;

public class ProdutoPersistence extends PersistenceBase<Produto> {

  List<Produto> produtos = new ArrayList<Produto>();
  private static ProdutoPersistence instance;

  public void save(Produto produto){
    String id = UUID.randomUUID().toString();
    produto.setId(id);
    produtos.add(produto);
  }

  public void delete(String id){
    produtos.remove(this.get(id));
  }

  public Produto get(String id){
    for(Produto produto : produtos){
      if(produto.getId().equals(id)){
        return produto;
      }
    }
    return null;
  }

  public List<Produto> getAll(){
    return this.produtos;
  }

  public Produto update(Produto produto){
    for(int i = 0; i < produtos.size(); i++){
      if(produtos.get(i).getId().equals(produto.getId())){
        produtos.set(i, produto);
        return produto;
      }
    }
    return null;
  }

  public static ProdutoPersistence getInstance(){
    if(instance == null){
      instance = new ProdutoPersistence();
    }
    return instance;
  }
}
