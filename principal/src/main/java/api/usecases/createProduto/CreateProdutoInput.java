package api.usecases.createProduto;

public class CreateProdutoInput {
  private String nome;
  private String slug;
  private Integer valor;
  private Integer quantidade;

  public CreateProdutoInput() {}

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

  public Integer getValor() {
    return valor;
  }

  public void setValor(Integer valor) {
    this.valor = valor;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public String toString() {
    return "Nome: " + nome + " Slug: " + slug + " Valor: " + valor + " Quantidade: " + quantidade;
  }
}
