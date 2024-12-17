package config;

import io.github.cdimascio.dotenv.Dotenv;

public class Variables {
  public static int PORT = Integer.parseInt(Dotenv.load().get("PORT"));
  public static String RABBITMQ_HOST = Dotenv.load().get("RABBITMQ_HOST");
  public static int RABBITMQ_PORT = Integer.parseInt(Dotenv.load().get("RABBITMQ_PORT"));
  public static String RABBITMQ_USERNAME = Dotenv.load().get("RABBITMQ_USERNAME");
  public static String RABBITMQ_PASSWORD = Dotenv.load().get("RABBITMQ_PASSWORD");
  public static String RABBITMQ_EXCHANGE = Dotenv.load().get("RABBITMQ_EXCHANGE");
}
