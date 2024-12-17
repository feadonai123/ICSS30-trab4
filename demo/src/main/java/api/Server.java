package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Server {
    public static void run(Number port) {
        SpringApplication.run(Server.class, new String[] { "--server.port=" + port });
    }

    public static void run() {
        run(8080);
    }
}
