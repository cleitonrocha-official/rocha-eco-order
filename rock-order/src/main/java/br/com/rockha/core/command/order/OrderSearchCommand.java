package br.com.rockha.core.command.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.rockha.core.common.adapter.command.CommonSearchDataCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class OrderSearchCommand extends CommonSearchDataCommand {

}