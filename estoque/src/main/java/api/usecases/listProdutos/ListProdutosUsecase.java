package api.usecases.listProdutos;

import api.base.Usecase;
import api.usecases.listProdutos.ListProdutosInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;

import models.Produto;
import persistence.produto.ProdutoPersistence;

import java.util.List;

public class ListProdutosUsecase extends Usecase<ListProdutosInput, ListProdutosOutput> {
  public void validate(ListProdutosInput input) throws ListProdutosErrors {}

  public ListProdutosOutput exec(ListProdutosInput input) throws ListProdutosErrors {
    ProdutoPersistence persistence = ProdutoPersistence.getInstance();
    List<Produto> produtos = persistence.getAll();

    ListProdutosOutput response = new ListProdutosOutput();
    response.setProdutos(produtos);

    return response;
  }
}
