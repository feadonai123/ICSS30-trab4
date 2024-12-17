package api.usecases.deleteProduto;

import api.base.Usecase;
import api.usecases.deleteProduto.DeleteProdutoInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;

import models.Produto;
import persistence.produto.ProdutoPersistence;

import java.util.List;

public class DeleteProdutoUsecase extends Usecase<DeleteProdutoInput, DeleteProdutoOutput> {
  public void validate(DeleteProdutoInput input) throws DeleteProdutoErrors {}

  public DeleteProdutoOutput exec(DeleteProdutoInput input) throws DeleteProdutoErrors {
    ProdutoPersistence persistence = ProdutoPersistence.getInstance();
    persistence.delete(input.getProdutoId());
    
    DeleteProdutoOutput response = new DeleteProdutoOutput();
    response.setId(input.getProdutoId());

    return response;
  }
}
