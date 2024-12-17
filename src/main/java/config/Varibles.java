package config;

import io.github.cdimascio.dotenv.Dotenv;

public class Varibles {
  public static int PORT = Integer.parseInt(Dotenv.load().get("PORT"));
}
