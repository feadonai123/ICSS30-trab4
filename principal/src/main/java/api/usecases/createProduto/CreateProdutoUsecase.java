package api.usecases.createProduto;

import api.base.Usecase;
import api.usecases.createProduto.CreateProdutoInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;
import services.request.RequestService;
import api.base.ApiResponse;
import models.Produto;

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
    RequestService requestService = new RequestService();

    DTOCreateProduto responseRequest = null;
    try{
      responseRequest = requestService.post(Variables.ESTOQUE_URL + "/api/produto", input, null, DTOCreateProduto.class);
    } catch (Exception e) {
      throw new CreateProdutoErrors("Erro no feth para o estoque");
    }
    
    CreateProdutoOutput response = new CreateProdutoOutput();

    response.setId(responseRequest.getData().getId());
    response.setNome(responseRequest.getData().getNome());
    response.setSlug(responseRequest.getData().getSlug());
    response.setValor(responseRequest.getData().getValor());
    response.setQuantidade(responseRequest.getData().getQuantidade());

    return response;
  }

}
