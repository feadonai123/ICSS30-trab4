package api.usecases.getProduto;

import api.base.Usecase;
import api.usecases.getProduto.GetProdutoInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;

import models.Produto;
import persistence.produto.ProdutoPersistence;

import java.util.List;

public class GetProdutoUsecase extends Usecase<GetProdutoInput, GetProdutoOutput> {
  public void validate(GetProdutoInput input) throws GetProdutoErrors {}

  public GetProdutoOutput exec(GetProdutoInput input) throws GetProdutoErrors {
    ProdutoPersistence persistence = ProdutoPersistence.getInstance();
    Produto produto = persistence.get(input.getProdutoId());

    GetProdutoOutput response = new GetProdutoOutput();
    response.setId(produto.getId());
    response.setNome(produto.getNome());
    response.setSlug(produto.getSlug());
    response.setValor(produto.getValor());
    response.setQuantidade(produto.getQuantidade());

    return response;
  }
}
