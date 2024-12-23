package main.java.events.pedidoCriado;

import errors.AplicationError;
import events.Event;
import events.base.EventBase;
import main.java.models.Notificacao;
import main.java.utils.Sink;
import models.Pedido;
import models.PedidoStatus;
import utils.Format;

public class PedidoCriado extends EventBase<String> {

    public PedidoCriado() {
        super("NOTIFICADOR_PEDIDO_CRIADO", Event.PEDIDOS_CRIADOS);
    }

    public void exec(String input) throws AplicationError {
        Pedido pedido = null;
        try {
            pedido = Format.deserialize(input, Pedido.class);
        } catch (Exception e) {
            throw new AplicationError("Erro ao deserializar objeto: " + e.getMessage());
        }
        Notificacao notificacao = new Notificacao("Pedido criado", PedidoStatus.CRIADO, pedido.getId());
        var sink = Sink.getInstance();
        try {
            System.out.println("Enviando evento: " + notificacao);
            sink.emit(notificacao);
            System.out.println("Evento enviado com sucesso");
        } catch (Exception e) {
            System.err.println("Erro ao enviar evento: " + e.getMessage());
        }
    }

}
