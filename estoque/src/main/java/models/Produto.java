package models;

public class Produto {
  private String id;
  private String nome;
  private String slug;
  private Number valor;
  private Number quantidade;

  public Produto(String nome, String slug, Number valor, Number quantidade){
    this.nome = nome;
    this.slug = slug;
    this.valor = valor;
    this.quantidade = quantidade;
  }

  public String getId(){
    return id;
  }

  public String getNome(){
    return nome;
  }

  public String getSlug(){
    return slug;
  }

  public Number getValor(){
    return valor;
  }

  public Number getQuantidade(){
    return quantidade;
  }

  public void setNome(String nome){
    this.nome = nome;
  }

  public void setSlug(String slug){
    this.slug = slug;
  }

  public void setValor(Number valor){
    this.valor = valor;
  }

  public void setQuantidade(Number quantidade){
    this.quantidade = quantidade;
  }

  public void setId(String id){
    this.id = id;
  }

  public String toString(){
    return "Nome: " + nome + " Slug: " + slug + " Valor: " + valor + " Quantidade: " + quantidade;
  }
}
