package br.com.zup_academy.alisson_prado.transacao.ListenerKafka;

import br.com.zup_academy.alisson_prado.transacao.common.ExecutorTransaction;
import br.com.zup_academy.alisson_prado.transacao.dto.TransacaoDto;
import br.com.zup_academy.alisson_prado.transacao.model.Transacao;
import br.com.zup_academy.alisson_prado.transacao.repository.CartaoRepository;
import br.com.zup_academy.alisson_prado.transacao.repository.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {

    private static final Logger logger = LoggerFactory.getLogger(TransactionListener.class);
    private TransacaoRepository transacaoRepository;
    private CartaoRepository cartaoRepository;
    private ExecutorTransaction executor;

    public TransactionListener(TransacaoRepository transacaoRepository, CartaoRepository cartaoRepository, ExecutorTransaction executor) {
        this.transacaoRepository = transacaoRepository;
        this.cartaoRepository = cartaoRepository;
        this.executor = executor;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}", containerFactory = "kafkaListenerContainerFactory")
    public void listenerTransacoes(@Payload TransacaoDto transacaoDto) {

        executor.inTransaction(() -> {
            Transacao transacao = transacaoDto.toModel(cartaoRepository);

            transacaoRepository.save(transacao);

            logger.info("Transaction saved: {}",  transacao.getIdTransacao());
        });
    }

}
