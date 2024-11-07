package br.com.rockha.core.command.order;

import java.math.BigDecimal;
import java.util.List;

import br.com.rockha.core.common.adapter.command.CommonCreateDataCommand;
import br.com.rockha.core.dto.OrderItemsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OrderCreateCommand extends CommonCreateDataCommand {

	private List<OrderItemsDTO> items; 
	private BigDecimal value;
	
}