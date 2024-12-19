package api.usecases.listEntregas;

import errors.AplicationError;

public class ListEntregasErrors extends AplicationError {
  public ListEntregasErrors(String message) {
    super(message);
  }
}
