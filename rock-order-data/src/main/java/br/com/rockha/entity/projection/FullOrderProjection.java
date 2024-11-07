package br.com.rockha.entity.projection;

import br.com.rockha.entity.Order;
import br.com.rockha.entity.OrderItem;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;
import java.util.List;

@Projection(name = "fullOrder", types = { Order.class })
public interface FullOrderProjection {
    
    String getId();
    
    BigDecimal getValue();
    
    List<OrderItem> getItems();  // Carregar sempre os itens

}