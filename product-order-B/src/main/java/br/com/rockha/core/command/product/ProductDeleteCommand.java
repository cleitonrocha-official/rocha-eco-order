package br.com.rockha.core.command.product;

import br.com.rockha.core.common.adapter.command.CommonReadOrUpadateDataCommand;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ProductDeleteCommand extends CommonReadOrUpadateDataCommand {
}