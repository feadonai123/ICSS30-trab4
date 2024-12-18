package api.usecases.deleteProduto;

import api.base.Usecase;
import api.usecases.deleteProduto.DeleteProdutoInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;
import services.request.RequestService;

import java.util.List;

public class DeleteProdutoUsecase extends Usecase<DeleteProdutoInput, DeleteProdutoOutput> {
  public void validate(DeleteProdutoInput input) throws DeleteProdutoErrors {}

  public DeleteProdutoOutput exec(DeleteProdutoInput input) throws DeleteProdutoErrors {
    try{
      RequestService requestService = new RequestService();
      requestService.delete(Variables.ESTOQUE_URL + "/api/produto/" + input.getProdutoId(), null, null);
    } catch (Exception e) {
      System.out.println("Erro no feth para o estoque" + e.getMessage());
      throw new DeleteProdutoErrors("Erro no feth para o estoque");
    }
    
    System.out.println("Produto deletado com sucesso");
    DeleteProdutoOutput response = new DeleteProdutoOutput();
    response.setId(input.getProdutoId());

    return response;
  }
}
