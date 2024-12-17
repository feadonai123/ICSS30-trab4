package events.event1;

import events.base.EventBase;

import models.Produto;
import persistence.produto.ProdutoPersistence;
import java.util.List;

public class Event1 extends EventBase<String> {

  public Event1() {
    super("queue1", "event1");
  }

  public void exec(String input) {
    System.out.println("Event1: " + input);

    ProdutoPersistence persistence = ProdutoPersistence.getInstance();
    List<Produto> produtos = persistence.getAll();
    System.out.println("produtos: " + produtos);
  }
}
