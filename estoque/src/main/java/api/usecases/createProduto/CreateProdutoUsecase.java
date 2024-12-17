package api.usecases.createProduto;

import api.base.Usecase;
import api.usecases.createProduto.CreateProdutoInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;

import models.Produto;
import persistence.produto.ProdutoPersistence;

public class CreateProdutoUsecase extends Usecase<CreateProdutoInput, CreateProdutoOutput> {
  public void validate(CreateProdutoInput input) throws CreateProdutoErrors {
    if (input.getNome() == null || input.getNome().isEmpty()) {
      throw new CreateProdutoErrors("Nome não pode ser vazio");
    }

    if (input.getSlug() == null || input.getSlug().isEmpty()) {
      throw new CreateProdutoErrors("Slug não pode ser vazio");
    }

    if (input.getValor() == null || input.getValor().intValue() <= 0) {
      throw new CreateProdutoErrors("Valor deve ser maior que 0");
    }

    if (input.getQuantidade() == null || input.getQuantidade().intValue() <= 0) {
      throw new CreateProdutoErrors("Quantidade deve ser maior que 0");
    }
  }


  public CreateProdutoOutput exec(CreateProdutoInput input) throws CreateProdutoErrors {
    Produto produto = new Produto(input.getNome(), input.getSlug(), input.getValor(), input.getQuantidade());
    ProdutoPersistence persistence = ProdutoPersistence.getInstance();
    persistence.save(produto);

    CreateProdutoOutput response = new CreateProdutoOutput();
    response.setId(produto.getId());
    response.setNome(produto.getNome());
    response.setSlug(produto.getSlug());
    response.setValor(produto.getValor());
    response.setQuantidade(produto.getQuantidade());

    return response;
  }
}
