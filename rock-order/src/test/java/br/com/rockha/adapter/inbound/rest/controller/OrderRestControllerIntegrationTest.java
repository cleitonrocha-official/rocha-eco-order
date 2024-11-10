package br.com.rockha.adapter.inbound.rest.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.rockha.adapter.inbound.rest.request.json.OrderCreateRequestJson;
import br.com.rockha.adapter.inbound.rest.request.json.OrderItemRequestJson;
import br.com.rockha.adapter.inbound.rest.request.json.ProductRequestJson;
import br.com.rockha.core.command.order.OrderCreateCommand;
import br.com.rockha.core.dto.OrderDTO;
import br.com.rockha.core.dto.OrderItemsDTO;
import br.com.rockha.core.dto.ProductDTO;
import br.com.rockha.core.port.inbound.OrderPortInbound;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderRestControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private OrderPortInbound orderPortInbound;

	@Test
	public void testCreateOrder() throws Exception {

		var mockOrderDTO = OrderDTO.builder()
				.uuid(UUID.randomUUID().toString())
				.items(List.of(OrderItemsDTO.builder()
						.product(ProductDTO.builder()
								.name("Cerveja")
								.value(new BigDecimal("14.00"))
								.build())
						.quantity(2)
						.build()))
				.value(new BigDecimal("28.00"))
				.build();

		when(orderPortInbound.create(any(OrderCreateCommand.class))).thenReturn(mockOrderDTO);

		// Criando o objeto de requisição
		var productRequestJson = new ProductRequestJson("Cerveja", new BigDecimal("14.00"));
		var orderItemRequestJson = new OrderItemRequestJson(productRequestJson, 2);
		var requestJson = new OrderCreateRequestJson(List.of(orderItemRequestJson));

		// Executando a requisição POST para criar o pedido
		mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(requestJson)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.items[0].produto.nome").value("Cerveja"))
				.andExpect(jsonPath("$.items[0].produto.valor").value(14.00))
				.andExpect(jsonPath("$.items[0].quantidade").value(2)).andExpect(jsonPath("$.valor").value(28.00));
	}
	

}

