package br.com.rockha.core.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.rockha.core.common.CommonDTO;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class OrderDTO extends CommonDTO {

	
    private List<OrderItemsDTO> items;
    private BigDecimal value;
   

}