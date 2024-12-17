package infra.restfull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfullServer {
    public static void run(Number port) {
        SpringApplication.run(RestfullServer.class, new String[] { "--server.port=" + port });
    }

    public static void run() {
        run(8080);
    }
}
