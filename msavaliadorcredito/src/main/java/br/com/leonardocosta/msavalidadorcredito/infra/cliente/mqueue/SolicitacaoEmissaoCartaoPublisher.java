package br.com.leonardocosta.msavalidadorcredito.infra.cliente.mqueue;

import br.com.leonardocosta.msavalidadorcredito.domain.model.DadosSolicitacaoEmissaoCartao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SolicitacaoEmissaoCartaoPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue fileEmissaoCartao;

    public void solicitarCartao(DadosSolicitacaoEmissaoCartao dados) throws JsonProcessingException {
        var json = convertIntoJson(dados);
        rabbitTemplate.convertAndSend(fileEmissaoCartao.getName(), json);
    }

    private String convertIntoJson(DadosSolicitacaoEmissaoCartao dadosSolicitacaoEmissaoCartao) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        var json = objectMapper.writeValueAsString(dadosSolicitacaoEmissaoCartao);
        return json;
    }

}
