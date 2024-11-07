package br.com.rockha.core.command.order;

import java.util.List;

import br.com.rockha.core.common.adapter.command.CommonReadOrUpadateDataCommand;
import br.com.rockha.core.dto.OrderItemsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OrderUpdateCommand extends CommonReadOrUpadateDataCommand {
	private List<OrderItemsDTO> products; 
	
}