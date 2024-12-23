package utils;

public class Log {
  public static void error(String category, String message) {
    System.out.println("\nERROR [" + Time.now() + "]" + "[" + category + "] " + message);
  }

  public static void info(String category, String message) {
    System.out.println("\nINFO [" + Time.now() + "] " + "[" + category + "] " + message);
  }
}
