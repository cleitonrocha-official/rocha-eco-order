package br.com.rockha.adapter.outbound.mq.producer;

import static br.com.rockha.core.data.OrderData.createOrderDTO;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.rockha.adapter.outbound.mq.config.RabbitMQOutboundConfig;
import br.com.rockha.adapter.outbound.mq.mapper.OrderOutboundMqMapper;

@ExtendWith(MockitoExtension.class)
public class OrderRabbitMqProducerTest {

	@Mock
	private RabbitTemplate rabbitTemplate;

	@InjectMocks
	private OrderRabbitMqProducer orderProducer;

	private OrderOutboundMqMapper mapper = Mappers.getMapper(OrderOutboundMqMapper.class);

	private final ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
	public void setUp() {
		orderProducer = new OrderRabbitMqProducer(rabbitTemplate, mapper);
	}

	@Test
	public void testProcessOrderSuccess() throws Exception {
		var orderDTO = createOrderDTO();

		var orderProcessedPayload = mapper.toPayload(orderDTO);

		var result = orderProducer.process(orderDTO);

		verify(rabbitTemplate).convertAndSend(RabbitMQOutboundConfig.PROCESSED_QUEUE_NAME,
				objectMapper.writeValueAsString(orderProcessedPayload));

		assertTrue(result);
	}

	@Test
	public void testProcessOrderFailure() throws Exception {
		// Criando o OrderDTO real
		var orderDTO = createOrderDTO();

		doThrow(new RuntimeException("Erro ao enviar mensagem")).when(rabbitTemplate).convertAndSend(any(String.class),
				any(String.class));

		var result = orderProducer.process(orderDTO);

		assertFalse(result);
	}

}
	