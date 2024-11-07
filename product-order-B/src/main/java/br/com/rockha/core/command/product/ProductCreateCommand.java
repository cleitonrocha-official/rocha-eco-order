package br.com.rockha.core.command.product;

import java.math.BigDecimal;

import br.com.rockha.core.common.adapter.command.CommonCreateDataCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductCreateCommand extends CommonCreateDataCommand {

	private String name;
	private BigDecimal value;

}