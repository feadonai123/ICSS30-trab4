package main.java.models;

public class Notificacao {
    private String mensagem;
    private String status;
    private String pedidoId;

    public Notificacao(String mensagem, String status, String pedidoId) {
        this.mensagem = mensagem;
        this.status = status;
        this.pedidoId = pedidoId;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getStatus() {
        return status;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public String toString() {
        return "Mensagem: " + mensagem + " Status: " + status + " PedidoId: " + pedidoId;
    }
}
