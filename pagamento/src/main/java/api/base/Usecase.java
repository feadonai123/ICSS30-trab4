package api.base;

import errors.AplicationError;
import utils.Log;
import java.io.IOException;

public abstract class Usecase <I, O> {
  public O run(I input) throws AplicationError {
    Log.info("USECASE", "Running " + this.getClass().getName());
    validate(input);
    return exec(input);
  }

  public abstract void validate(I input) throws AplicationError;

  public abstract O exec(I input) throws AplicationError;
}