package api.usecases.listProdutos;

import api.base.Usecase;
import api.usecases.listProdutos.ListProdutosInput;

import services.queue.MessageProducer;
import services.queue.RabbitMQConfig;
import config.Variables;
import services.request.RequestService;
import models.Produto;

import java.util.List;

public class ListProdutosUsecase extends Usecase<ListProdutosInput, ListProdutosOutput> {
  public void validate(ListProdutosInput input) throws ListProdutosErrors {}

  public ListProdutosOutput exec(ListProdutosInput input) throws ListProdutosErrors {
    RequestService requestService = new RequestService();
    DTOListProdutos responseRequest = null;

    try{
      responseRequest = requestService.get(Variables.ESTOQUE_URL + "/api/produtos", null, DTOListProdutos.class);
      System.out.println(responseRequest);
    } catch (Exception e) {
      throw new ListProdutosErrors("Erro no feth para o estoque: " + e.getMessage());
    }

    System.out.println("TUDO CERTO");

    ListProdutosOutput response = new ListProdutosOutput();
    response.setProdutos(responseRequest.getData().getProdutos());

    return response;
  }
}
