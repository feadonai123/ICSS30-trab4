import infra.restfull.RestfullServer;
import config.Varibles;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World");
    System.out.println("Port: " + Varibles.PORT);
    RestfullServer.run(Varibles.PORT);
  }
}

