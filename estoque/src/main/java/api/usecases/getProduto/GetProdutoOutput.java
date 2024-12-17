package api.usecases.getProduto;

public class GetProdutoOutput {
  private String id;
  private String nome;
  private String slug;
  private Number valor;
  private Number quantidade;

  public GetProdutoOutput() {}

  public String getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public Number getValor() {
    return valor;
  }

  public void setValor(Number valor) {
    this.valor = valor;
  }

  public Number getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Number quantidade) {
    this.quantidade = quantidade;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String toString() {
    return "Nome: " + nome + " Slug: " + slug + " Valor: " + valor + " Quantidade: " + quantidade;
  }
}
