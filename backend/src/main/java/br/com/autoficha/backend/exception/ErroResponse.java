package br.com.autoficha.backend.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ErroResponse {

    private int status;
    private String erro;
    private String mensagem;
    private LocalDateTime timestamp;
    private Map<String, String> campos;

    public ErroResponse(
            int status,
            String erro,
            String mensagem
    ) {
        this(status, erro, mensagem, null);
    }

    public ErroResponse(
            int status,
            String erro,
            String mensagem,
            Map<String, String> campos
    ) {
        this.status = status;
        this.erro = erro;
        this.mensagem = mensagem;
        this.timestamp = LocalDateTime.now();
        this.campos = campos;
    }

    public int getStatus() {
        return status;
    }

    public String getErro() {
        return erro;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Map<String, String> getCampos() {
        return campos;
    }
}