package br.com.rockha.core.service;

import static br.com.rockha.core.data.OrderData.createRandomOrderCreateCommand;
import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.rockha.core.command.order.OrderCreateCommand;
import br.com.rockha.core.dto.OrderItemsDTO;
import br.com.rockha.core.dto.ProductDTO;

public class OrderCalculatorServiceTest {

    private OrderCalculatorService orderCalculatorService;

    @BeforeEach
    public void setUp() {
        orderCalculatorService = new OrderCalculatorService();
    }

    @Test
    public void testCalculateOrderTotalWithValidItems() {
        var orderCreateCommand = createRandomOrderCreateCommand();

        var result = orderCalculatorService.process(orderCreateCommand);

        var expectedTotal = orderCreateCommand.getItems().stream()
                .map(item -> item.getProduct()
                		.getValue()
                		.multiply(valueOf(item.getQuantity())))
                .reduce(ZERO, BigDecimal::add);

        assertEquals(expectedTotal, result.getValue());
    }

    @Test
    public void testCalculateOrderTotalWithEmptyItems() {
        var orderCreateCommand = OrderCreateCommand.builder()
                .items(new ArrayList<>()) //<<<<<
                .build();
        var result = orderCalculatorService.process(orderCreateCommand);

        assertEquals(ZERO, result.getValue());
    }

    @Test
    public void testCalculateOrderTotalWithNullItems() {
        var orderCreateCommand = OrderCreateCommand.builder()
                .build();

        assertThrows(NullPointerException.class, () -> {
            orderCalculatorService.process(orderCreateCommand);
        });
    }

    @Test
    public void testCalculateOrderTotalWithNullProductValue() {
  
    	List<OrderItemsDTO> items = new ArrayList<>();
        items.add(OrderItemsDTO.builder()
                .product(ProductDTO.builder().name("Product-1")
                		.value(null).build()) //<<<<<
                .quantity(2)
                .build());

        var orderCreateCommand = OrderCreateCommand.builder()
                .items(items)
                .build();

        assertThrows(NullPointerException.class, () -> {
            orderCalculatorService.process(orderCreateCommand);
        });
    }

    
}