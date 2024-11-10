package br.com.rockha.adapter.inbound.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.rockha.adapter.inbound.mq.config.RabbitMQInboundConfig;
import br.com.rockha.adapter.inbound.mq.mapper.OrderInboundMqMapper;
import br.com.rockha.adapter.inbound.mq.payload.OrderCreatePayload;
import br.com.rockha.core.port.inbound.OrderPortInbound;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderEventConsumer {
	
	private final OrderPortInbound portInbound;
	private final ObjectMapper objectMapper = new ObjectMapper();
	private final OrderInboundMqMapper mapper;

	@RabbitListener(queues = RabbitMQInboundConfig.QUEUE_NAME)
	public void receiveMessage(String message) throws JsonMappingException, JsonProcessingException {
		System.out.println("Mensagem recebida da fila 'pedido-event': " + message);
		var orderPayload = objectMapper.readValue(message, OrderCreatePayload.class);
		
		portInbound.create(mapper.toCommand(orderPayload));
	}

}
