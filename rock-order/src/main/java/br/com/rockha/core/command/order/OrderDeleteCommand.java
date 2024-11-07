package br.com.rockha.core.command.order;

import br.com.rockha.core.common.adapter.command.CommonReadOrUpadateDataCommand;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class OrderDeleteCommand extends CommonReadOrUpadateDataCommand {
}