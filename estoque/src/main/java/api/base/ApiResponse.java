package api.base;

import java.time.LocalDateTime;

public class ApiResponse<T> {
  private String message;
  private LocalDateTime completedAt;
  private T data;

  public ApiResponse() {}

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public LocalDateTime getCompletedAt() {
    return completedAt;
  }

  public void setCompletedAt(LocalDateTime completedAt) {
    this.completedAt = completedAt;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
