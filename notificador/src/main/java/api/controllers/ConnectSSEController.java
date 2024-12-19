package api.controllers;

import org.springframework.web.bind.annotation.RestController;
import api.base.ApiResponse;
import main.java.models.Notificacao;
import main.java.utils.Sink;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.MediaType;
import reactor.core.publisher.Flux;
import org.springframework.http.codec.ServerSentEvent;
import java.time.Duration;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Sinks;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@CrossOrigin(origins = "*")
@RestController
public class ConnectSSEController {

    private static final Sinks.Many<ServerSentEvent<Notificacao>> sink = Sinks.many().multicast()
            .onBackpressureBuffer();

    // ExecutorService para gerenciar threads separadas para emissão dos eventos
    private static final ExecutorService executorService = Executors.newFixedThreadPool(2);

    // Endpoint SSE que o cliente consome
    @GetMapping("/stream-sse")
    public Flux<ServerSentEvent<Notificacao>> streamEvents() {
        return sink.asFlux();
    }

    // Endpoint para enviar mensagens para o cliente
    @PostMapping("/send-event")
    public void sendEvent(@RequestBody String message) {
        Notificacao event = new Notificacao(message, "recusado", "1");
        // Submetendo a tarefa para o ExecutorService
        submitEventForAsyncProcessing(event);
    }

    public static void submitEventForAsyncProcessing(Notificacao data) {
        // Enviando a tarefa para o ExecutorService, que processa em uma thread separada
        executorService.submit(() -> {
            try {
                // Emite o evento para o sink
                ServerSentEvent<Notificacao> event = ServerSentEvent.<Notificacao>builder()
                        .id(String.valueOf(System.currentTimeMillis()))
                        .event("custom-event")
                        .data(data)
                        .build();
                // Tente emitir o evento, tratando exceções
                sink.tryEmitNext(event);
            } catch (Exception e) {
                // Trate a exceção ou logue o erro
                e.printStackTrace();
            }
        });
    }

    // Método para encerrar o ExecutorService quando não for mais necessário
    public static void shutdownExecutorService() {
        executorService.shutdown();
    }
}
