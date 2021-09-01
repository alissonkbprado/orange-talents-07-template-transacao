package br.com.zup_academy.alisson_prado.transacao.handler;

import java.util.Collection;

public class StandardizedError {

    private Collection<String> mensagens;

    public StandardizedError(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }

    public Collection<String> getMensagens() {
        return mensagens;
    }
}
