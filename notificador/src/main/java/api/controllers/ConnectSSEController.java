
package api.controllers;

import main.java.utils.Sink;
import main.java.models.Notificacao;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@CrossOrigin(origins = "*")
@RestController
public class ConnectSSEController {

    @GetMapping("/stream-sse")
    public Flux<ServerSentEvent<Notificacao>> streamEvents() {
        var sink = Sink.getInstance().getSink();
        return sink.asFlux();
    }

    @PostMapping("/send-event")
    public void sendEvent(@RequestBody String message) {
        Notificacao event = new Notificacao(message, "recusado", "1");
        var sink = Sink.getInstance();
        try {
            System.out.println("Enviando evento: " + event);
            sink.emit(event);
            System.out.println("Evento enviado com sucesso");
        } catch (Exception e) {
            System.err.println("Erro ao enviar evento: " + e.getMessage());
        }
    }
}
