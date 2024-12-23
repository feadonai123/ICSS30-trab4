package api.base;

import utils.Log;
import utils.Time;
import errors.AplicationError;
import java.io.IOException;

public abstract class Controller <I,O> {
  public ApiResponse run(I input) throws AplicationError {
    Log.info("CONTROLLER", "Running " + this.getClass().getName());
    O data = exec(input);
    ApiResponse response = new ApiResponse<O>();
    response.setMessage(this.getClass().getName());
    response.setData(data);
    response.setCompletedAt(Time.now().toString());
    return response;
  }

  public abstract O exec(I input) throws AplicationError;
}
