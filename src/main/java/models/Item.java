package models;

public class Item {
  private String name;
  private String id;

  public Item(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public String getId(){
    return id;
  }

  public void setName(String name){
    this.name = name;
  }

  public void setId(String id){
    this.id = id;
  }
}
