package persistence.item;

import java.util.List;

import models.Item;
import persistence.base.PersistenceBase;
import java.util.ArrayList;
import java.util.UUID;

public class ItemPersistence extends PersistenceBase<Item> {

  List<Item> items = new ArrayList<Item>();
  private static ItemPersistence instance;

  public void save(Item item){
    String id = UUID.randomUUID().toString();
    item.setId(id);
    items.add(item);
  }

  public void delete(String id){
    items.remove(this.get(id));
  }

  public Item get(String id){
    for(Item item : items){
      if(item.getId().equals(id)){
        return item;
      }
    }
    return null;
  }

  public List<Item> getAll(){
    return this.items;
  }

  public Item update(Item item){
    for(int i = 0; i < items.size(); i++){
      if(items.get(i).getId().equals(item.getId())){
        items.set(i, item);
        return item;
      }
    }
    return null;
  }

  public static ItemPersistence getInstance(){
    if(instance == null){
      instance = new ItemPersistence();
    }
    return instance;
  }
}
