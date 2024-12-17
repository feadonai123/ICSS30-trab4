package events.event1;

import events.base.EventBase;

import models.Item;
import persistence.item.ItemPersistence;
import java.util.List;

public class Event1 extends EventBase<String> {

  public Event1() {
    super("queue1", "event1");
  }

  public void exec(String input) {
    System.out.println("Event1: " + input);

    ItemPersistence persistence = ItemPersistence.getInstance();
    List<Item> items = persistence.getAll();
    System.out.println("Items: " + items);
  }
}
