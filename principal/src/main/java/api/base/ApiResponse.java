package api.base;

public class ApiResponse<T> {
  private String message;
  private String completedAt;
  private T data;

  public ApiResponse() {}

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getCompletedAt() {
    return completedAt;
  }

  public void setCompletedAt(String completedAt) {
    this.completedAt = completedAt;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
