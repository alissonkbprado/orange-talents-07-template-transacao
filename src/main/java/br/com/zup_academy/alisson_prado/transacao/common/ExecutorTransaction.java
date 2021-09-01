package br.com.zup_academy.alisson_prado.transacao.common;

import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ExecutorTransaction {

    @Transactional
    public void inTransaction(Runnable runnable) {
        runnable.run();
    }
}
