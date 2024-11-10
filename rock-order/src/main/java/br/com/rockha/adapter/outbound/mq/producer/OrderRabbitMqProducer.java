package br.com.rockha.adapter.outbound.mq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.rockha.adapter.outbound.mq.config.RabbitMQOutboundConfig;
import br.com.rockha.adapter.outbound.mq.mapper.OrderOutboundMqMapper;
import br.com.rockha.core.dto.OrderDTO;
import br.com.rockha.core.port.outbound.order.ProcessedOrderUploadPortOutbound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderRabbitMqProducer implements ProcessedOrderUploadPortOutbound {

	private final RabbitTemplate rabbitTemplate;
	private final ObjectMapper objectMapper = new ObjectMapper();
	private final OrderOutboundMqMapper mapper;

	@Override
	public Boolean process(OrderDTO dto) {
		try {
			var payload = mapper.toPayload(dto);
			var message = objectMapper.writeValueAsString(payload);
			rabbitTemplate.convertAndSend(RabbitMQOutboundConfig.PROCESSED_QUEUE_NAME, message);
		} catch (Exception e) {
			log.error("Erro ao enviar menssagem {}", dto.getUuid(), e);
			return false;
		}

		return true;
	}

}