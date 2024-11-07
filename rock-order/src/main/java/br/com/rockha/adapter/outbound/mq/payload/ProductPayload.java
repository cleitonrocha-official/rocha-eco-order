package br.com.rockha.adapter.outbound.mq.payload;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductPayload {
    private String name;
    private BigDecimal value;
}