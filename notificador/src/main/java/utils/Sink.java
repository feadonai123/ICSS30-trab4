package main.java.utils;

import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Sinks;
import main.java.models.Notificacao;

public class Sink {

    private static final Sinks.Many<ServerSentEvent<Notificacao>> sink = Sinks.many().multicast()
            .onBackpressureBuffer();

    public static Sinks.Many<ServerSentEvent<Notificacao>> getSink() {
        return sink;
    }

    public static void emit(Notificacao data) {
        ServerSentEvent<Notificacao> event = ServerSentEvent.<Notificacao>builder()
                .id(String.valueOf(System.currentTimeMillis()))
                .event("custom-event")
                .data(data)
                .build();
        sink.tryEmitNext(event);
    }
}
