package persistence.pagamento;

import java.util.List;

import models.Pagamento;
import persistence.base.PersistenceBase;
import java.util.ArrayList;
import java.util.UUID;

public class PagamentoPersistence extends PersistenceBase<Pagamento> {

  List<Pagamento> pagamentos = new ArrayList<Pagamento>();
  private static PagamentoPersistence instance;

  public void save(Pagamento pagamento){
    String id = UUID.randomUUID().toString();
    pagamento.setId(id);
    pagamentos.add(pagamento);
  }

  public void delete(String id){
    pagamentos.remove(this.get(id));
  }

  public Pagamento get(String id){
    for(Pagamento pagamento : pagamentos){
      if(pagamento.getId().equals(id)){
        return pagamento;
      }
    }
    return null;
  }

  public Pagamento getByPedidoId(String id){
    for(Pagamento pagamento : pagamentos){
      if(pagamento.getPedidoId().equals(id)){
        return pagamento;
      }
    }
    return null;
  }

  public List<Pagamento> getAll(){
    return this.pagamentos;
  }

  public Pagamento update(Pagamento pagamento){
    for(int i = 0; i < pagamentos.size(); i++){
      if(pagamentos.get(i).getId().equals(pagamento.getId())){
        pagamentos.set(i, pagamento);
        return pagamento;
      }
    }
    return null;
  }

  public static PagamentoPersistence getInstance(){
    if(instance == null){
      instance = new PagamentoPersistence();
    }
    return instance;
  }
}
