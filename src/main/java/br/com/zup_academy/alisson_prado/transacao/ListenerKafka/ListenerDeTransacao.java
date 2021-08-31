package br.com.zup_academy.alisson_prado.transacao.ListenerKafka;

import br.com.zup_academy.alisson_prado.transacao.dto.EventoDeTransacaoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    private static final Logger logger = LoggerFactory.getLogger(ListenerDeTransacao.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listenerTransacoes(EventoDeTransacaoDto eventoDeTransacaoDto) {
        logger.info("Messaga received. Id: {}", eventoDeTransacaoDto.getId());
        logger.info("Messaga received. Valor: {}", eventoDeTransacaoDto.getValor());
        logger.info("Messaga received. Efetivada em: {}", eventoDeTransacaoDto.getEfetivadaEm());
    }
}
