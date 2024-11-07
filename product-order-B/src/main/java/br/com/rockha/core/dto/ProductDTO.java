package br.com.rockha.core.dto;

import java.math.BigDecimal;

import br.com.rockha.core.common.CommonDTO;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ProductDTO extends CommonDTO {
    private String name;
	private BigDecimal value;

}