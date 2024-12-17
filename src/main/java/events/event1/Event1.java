package events.event1;

import events.base.EventBase;

public class Event1 extends EventBase<String> {

  public Event1() {
    super("queue1", "event1");
  }

  public void exec(String input) {
    System.out.println("Event1: " + input);
  }
}
