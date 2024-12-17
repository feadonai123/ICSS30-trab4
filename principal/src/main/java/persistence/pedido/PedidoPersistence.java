package persistence.pedido;

import java.util.List;

import models.Pedido;
import persistence.base.PersistenceBase;
import java.util.ArrayList;
import java.util.UUID;

public class PedidoPersistence extends PersistenceBase<Pedido> {

  List<Pedido> pedidos = new ArrayList<Pedido>();
  private static PedidoPersistence instance;

  public void save(Pedido pedido){
    String id = UUID.randomUUID().toString();
    pedido.setId(id);
    pedidos.add(pedido);
  }

  public void delete(String id){
    pedidos.remove(this.get(id));
  }

  public Pedido get(String id){
    for(Pedido pedido : pedidos){
      if(pedido.getId().equals(id)){
        return pedido;
      }
    }
    return null;
  }

  public List<Pedido> getAll(){
    return this.pedidos;
  }

  public Pedido update(Pedido pedido){
    for(int i = 0; i < pedidos.size(); i++){
      if(pedidos.get(i).getId().equals(pedido.getId())){
        pedidos.set(i, pedido);
        return pedido;
      }
    }
    return null;
  }

  public static PedidoPersistence getInstance(){
    if(instance == null){
      instance = new PedidoPersistence();
    }
    return instance;
  }
}
