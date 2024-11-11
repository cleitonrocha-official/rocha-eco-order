package br.com.rockha.adapter.inbound.mq;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.rockha.adapter.inbound.mq.config.RabbitMQConfig;
import br.com.rockha.adapter.inbound.mq.payload.OrderCreatePayload;
import br.com.rockha.adapter.inbound.mq.payload.OrderItemPayload;
import br.com.rockha.adapter.inbound.mq.payload.ProductPayload;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProducer {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private int processos = 0;
    private final int qtdAprocessar =20;
    private final int numeroDeMensagensEnviadasPorProcessos = 5000;
    private boolean on = true;

    public void sendOrders(int numberOfOrders) {
        List<String> messages = new ArrayList<>(); 

        for (int i = 0; i < numberOfOrders; i++) {
            try {
                OrderCreatePayload order = createOrder(i);
                String message = objectMapper.writeValueAsString(order);
                messages.add(message); 
            } catch (JsonProcessingException e) {
                log.error("Erro ao converter o pedido para JSON", e);
            }
        }

        // Envia o lote de mensagens de uma vez
        try {
            rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, messages);
            log.info("Lote de {} pedidos enviado", messages.size());
        } catch (Exception e) {
            log.error("Erro ao enviar o lote de pedidos", e);
        }

        processos++;
    }

    
    @PostConstruct
    public void init() {
    	log.info("-----------------------");
    	log.info("Programado para {} mensagens" , qtdAprocessar * numeroDeMensagensEnviadasPorProcessos);
    	log.info("-----------------------");
    }


    private OrderCreatePayload createOrder(int orderId) {
        List<OrderItemPayload> items = new ArrayList<>();
        Random random = new Random();

        
        for (int i = 0; i < 10; i++) {
            String productName = "Produto " +  (i + 1);
            BigDecimal randomValue = BigDecimal.valueOf(50 + (random.nextDouble() * 150)); 
            int randomQuantity = random.nextInt(10) + 1; 

            items.add(OrderItemPayload.builder()
                    .product(ProductPayload.builder().name(productName).value(randomValue).build())
                    .quantity(randomQuantity)
                    .build());
        }

        return OrderCreatePayload.builder()
                .items(items)
                .build();
    }

   
    @Scheduled(fixedRate = 1000) 
    public void sendOrdersEverySecond() {
    
    	if(on && processos < qtdAprocessar) {
           sendOrders(numeroDeMensagensEnviadasPorProcessos);
    	}
    }
}