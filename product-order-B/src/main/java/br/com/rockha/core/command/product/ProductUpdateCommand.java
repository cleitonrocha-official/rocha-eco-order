package br.com.rockha.core.command.product;

import java.math.BigDecimal;

import br.com.rockha.core.common.adapter.command.CommonReadOrUpadateDataCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductUpdateCommand extends CommonReadOrUpadateDataCommand {
	private String name;
	private BigDecimal value;

}