package events.base;

import errors.AplicationError;
import utils.Log;

public abstract class EventBase <I> {

  private String queueName;
  private String routingKey;

  public EventBase(String queueName, String routingKey) {
    this.queueName = queueName;
    this.routingKey = routingKey;
  }

  public void run(I input) throws AplicationError {
    Log.info("EVENT", "Running " + this.getClass().getName());
    exec(input);
  }

  public abstract void exec(I input) throws AplicationError;

  public String getQueueName() {
    return this.queueName;
  }

  public String getRoutingKey() {
    return this.routingKey;
  }
}