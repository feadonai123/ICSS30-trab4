
package main.java.utils;

import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Sinks;
import main.java.models.Notificacao;

public class Sink {

    private final Sinks.Many<ServerSentEvent<Notificacao>> sink;
    private static Sink instance;

    private Sink() {
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public Sinks.Many<ServerSentEvent<Notificacao>> getSink() {
        return sink;
    }

    public void emit(Notificacao data) {
        ServerSentEvent<Notificacao> event = ServerSentEvent.<Notificacao>builder()
                .id(String.valueOf(System.currentTimeMillis()))
                .event("custom-event")
                .data(data)
                .build();
        sink.tryEmitNext(event).orThrow();
    }

    public static synchronized Sink getInstance() {
        if (instance == null) {
            instance = new Sink();
        }
        return instance;
    }
}