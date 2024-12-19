package models;

public class Entrega {
  private String id;
  private String pedidoId;
  private String status;

  public Entrega(String id, String pedidoId, String status){
    this.id = id;
    this.pedidoId = pedidoId;
    this.status = status;
  }

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  public String getPedidoId(){
    return pedidoId;
  }

  public void setPedidoId(String pedidoId){
    this.pedidoId = pedidoId;
  }

  public String getStatus(){
    return status;
  }

  public void setStatus(String status){
    this.status = status;
  }

  public String toString(){
    return "Pagamento{" +
      "id='" + id + '\'' +
      ", pedidoId='" + pedidoId + '\'' +
      ", status=" + status +
      '}';
  }
}
