package br.com.rockha.core.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import br.com.rockha.core.command.order.OrderCreateCommand;
import br.com.rockha.core.dto.OrderDTO;
import br.com.rockha.core.dto.OrderItemsDTO;
import br.com.rockha.core.dto.ProductDTO;

public class OrderData {

	public static OrderCreateCommand createRandomOrderCreateCommand() {
        List<OrderItemsDTO> items = new ArrayList<>();
        for (int i = 0; i < 3; i++) { 
            items.add(createRandomOrderItem());
        }

        BigDecimal totalValue = items.stream()
                .map(item -> item.getProduct().getValue().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return OrderCreateCommand.builder()
                .items(items)
                .value(totalValue)
                .build();
    }

    public static OrderItemsDTO createRandomOrderItem() {
        ProductDTO product = ProductDTO.builder()
                .name("Product-" + UUID.randomUUID()) 
                .value(BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(10, 100))) 
                .build();

        return OrderItemsDTO.builder()
                .product(product)
                .quantity(ThreadLocalRandom.current().nextInt(1, 5)) 
                .build();
    }
    
	public static OrderDTO createOrderDTO() {
		return OrderDTO.builder().uuid(UUID.randomUUID().toString())
				.items(List.of(OrderItemsDTO.builder()
						.product(ProductDTO.builder()
								.name("Cerveja")
								.value(new BigDecimal("14.00")).build())
						.quantity(2).build()))
				.value(new BigDecimal("28.00")).build();

	}
    
    
	
}
