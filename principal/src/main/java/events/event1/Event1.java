package events.event1;

import events.base.EventBase;

import models.Pedido;
import persistence.pedido.PedidoPersistence;
import java.util.List;

public class Event1 extends EventBase<String> {

  public Event1() {
    super("queue1", "event1");
  }

  public void exec(String input) {
    System.out.println("Event1: " + input);

    PedidoPersistence persistence = PedidoPersistence.getInstance();
    List<Pedido> pedidos = persistence.getAll();
    System.out.println("pedidos: " + pedidos);
  }
}
