package br.com.rockha.core.dto;

import br.com.rockha.core.common.CommonDTO;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class OrderItemsDTO extends CommonDTO {
    private ProductDTO product;
    private Integer quantity;

}