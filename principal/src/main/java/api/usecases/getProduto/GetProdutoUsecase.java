package api.usecases.getProduto;

import api.base.Usecase;
import api.usecases.getProduto.GetProdutoInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;
import services.request.RequestService;

import java.util.List;

public class GetProdutoUsecase extends Usecase<GetProdutoInput, GetProdutoOutput> {
  public void validate(GetProdutoInput input) throws GetProdutoErrors {}

  public GetProdutoOutput exec(GetProdutoInput input) throws GetProdutoErrors {

    RequestService requestService = new RequestService();
    DTOGetProduto responseRequest = null;
    try{
      responseRequest = requestService.get(Variables.ESTOQUE_URL + "/api/produto/" + input.getProdutoId(), null, DTOGetProduto.class);
      System.out.println(responseRequest);
    } catch (Exception e) {
      throw new GetProdutoErrors("Erro no feth para o estoque");
    }

    GetProdutoOutput response = new GetProdutoOutput();
    response.setId(responseRequest.getData().getId());
    response.setNome(responseRequest.getData().getNome());
    response.setSlug(responseRequest.getData().getSlug());
    response.setValor(responseRequest.getData().getValor());
    response.setQuantidade(responseRequest.getData().getQuantidade());

    return response;
  }
}
