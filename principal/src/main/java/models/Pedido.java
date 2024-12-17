package models;

public class Pedido {
  private String id;
  private String status;
  private String produtoId;
  private Number quantidade;
  private String nomeComprador;

  public Pedido(String produtoId, Number quantidade, String nomeComprador, String status){
    this.produtoId = produtoId;
    this.quantidade = quantidade;
    this.nomeComprador = nomeComprador;
    this.status = status;
  }

  public String getId(){
    return id;
  }

  public String getProdutoId(){
    return produtoId;
  }

  public Number getQuantidade(){
    return quantidade;
  }

  public String getNomeComprador(){
    return nomeComprador;
  }

  public String getStatus(){
    return status;
  }

  public void setProdutoId(String produtoId){
    this.produtoId = produtoId;
  }

  public void setQuantidade(Number quantidade){
    this.quantidade = quantidade;
  }

  public void setNomeComprador(String nomeComprador){
    this.nomeComprador = nomeComprador;
  }

  public void setStatus(String status){
    this.status = status;
  }

  public void setId(String id){
    this.id = id;
  }

  public String toString(){
    return "Produto: " + produtoId + " Quantidade: " + quantidade + " Nome do comprador: " + nomeComprador + " Status: " + status;
  }
}
