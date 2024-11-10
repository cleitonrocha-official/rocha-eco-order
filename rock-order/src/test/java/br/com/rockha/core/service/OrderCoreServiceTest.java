package br.com.rockha.core.service;

import static br.com.rockha.core.data.OrderData.createRandomOrderCreateCommand;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.rockha.core.command.order.OrderCreateCommand;
import br.com.rockha.core.command.order.OrderFindByIdCommand;
import br.com.rockha.core.dto.OrderDTO;
import br.com.rockha.core.port.outbound.order.OrderCreatePortOutbound;
import br.com.rockha.core.port.outbound.order.OrderDeletePortOutbound;
import br.com.rockha.core.port.outbound.order.OrderFindByIdPortOutbound;
import br.com.rockha.core.port.outbound.order.OrderSearchPortOutbound;
import br.com.rockha.core.port.outbound.order.OrderUpdatePortOutbound;
import br.com.rockha.core.port.outbound.order.ProcessedOrderUploadPortOutbound;

public class OrderCoreServiceTest {

	@Mock
    private OrderCalculatorService orderCalculatorService;

    @Mock
    private ProcessedOrderUploadPortOutbound processedOrderUploadPortOutbound;

    @Mock
    private OrderSearchPortOutbound searchPortOutbound;

    @Mock
    private OrderFindByIdPortOutbound findByIdPortOutbound;

    @Mock
    private OrderCreatePortOutbound createPortOutbound;

    @Mock
    private OrderUpdatePortOutbound updatePortOutbound;

    @Mock
    private OrderDeletePortOutbound deletePortOutbound;

    @InjectMocks
    private OrderCoreService orderCoreService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        orderCoreService = new OrderCoreService(searchPortOutbound, findByIdPortOutbound, createPortOutbound, updatePortOutbound, deletePortOutbound);
        orderCoreService.setOrderCalculatorService(orderCalculatorService);
        orderCoreService.setProcessedOrderUploadPortOutbound(processedOrderUploadPortOutbound);
    }

    @Test
    public void testCreateOrder() {
        var orderCreateCommand = createRandomOrderCreateCommand();

        var randomUUID = randomUUID().toString();
        var orderDTO =  
        		OrderDTO.builder()
        		.uuid(randomUUID)
        		.build();

        when(orderCalculatorService.process(any(OrderCreateCommand.class))).thenReturn(orderCreateCommand);        
        when(createPortOutbound.process(any(OrderCreateCommand.class))).thenReturn(orderDTO);
        when(findByIdPortOutbound.process(any(OrderFindByIdCommand.class))).thenReturn(orderDTO);

        var result = orderCoreService.create(orderCreateCommand);

        assertEquals(randomUUID, result.getUuid());
        verify(orderCalculatorService, times(1)).process(any(OrderCreateCommand.class));
        verify(createPortOutbound, times(1)).process(any(OrderCreateCommand.class));
        verify(findByIdPortOutbound, times(1)).process(any(OrderFindByIdCommand.class));
        verify(processedOrderUploadPortOutbound, times(1)).process(any(OrderDTO.class));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}