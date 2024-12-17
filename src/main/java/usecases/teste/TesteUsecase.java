package usecases.teste;

import utils.ExampleUtil;
import base.Usecase;

public class TesteUsecase extends Usecase<TesteInput, TesteOutput> {
  public TesteOutput exec(TesteInput input) throws TesteErrors {
    ExampleUtil example = new ExampleUtil();
    example.exec();

    TesteOutput response = new TesteOutput();
    response.setMessage("Hello " + input.getName());
    return response;
  }
}
