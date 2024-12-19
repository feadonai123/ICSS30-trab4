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

import java.time.LocalTime;

@RestController
public class ConnectSSEController {

    private final Sinks.Many<ServerSentEvent<Notificacao>> sink;

    // Endpoint SSE que o cliente consome
    @GetMapping("/stream-sse")
    public Flux<ServerSentEvent<Notificacao>> streamEvents() {
        return Sink.getSink().asFlux();
    }

    // Endpoint para enviar mensagens para o cliente
    @PostMapping("/send-event")
    public void sendEvent(@RequestBody String message) {
        Notificacao event = new Notificacao(message, "recusado", "1");
        Sink.emit(event);
    }
}
