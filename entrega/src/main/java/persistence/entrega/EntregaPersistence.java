package persistence.entrega;

import java.util.List;

import models.Entrega;
import persistence.base.PersistenceBase;
import java.util.ArrayList;
import java.util.UUID;

public class EntregaPersistence extends PersistenceBase<Entrega> {

  List<Entrega> entregas = new ArrayList<Entrega>();
  private static EntregaPersistence instance;

  public void save(Entrega entrega){
    String id = UUID.randomUUID().toString();
    entrega.setId(id);
    entregas.add(entrega);
  }

  public void delete(String id){
    entregas.remove(this.get(id));
  }

  public Entrega get(String id){
    for(Entrega entrega : entregas){
      if(entrega.getId().equals(id)){
        return entrega;
      }
    }
    return null;
  }

  public Entrega getByPedidoId(String id){
    for(Entrega entrega : entregas){
      if(entrega.getPedidoId().equals(id)){
        return entrega;
      }
    }
    return null;
  }

  public List<Entrega> getAll(){
    return this.entregas;
  }

  public Entrega update(Entrega entrega){
    for(int i = 0; i < entregas.size(); i++){
      if(entregas.get(i).getId().equals(entrega.getId())){
        entregas.set(i, entrega);
        return entrega;
      }
    }
    return null;
  }

  public static EntregaPersistence getInstance(){
    if(instance == null){
      instance = new EntregaPersistence();
    }
    return instance;
  }
}
