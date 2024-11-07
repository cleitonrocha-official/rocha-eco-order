package br.com.rockha.adapter.outbound.mq.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OrderItemPayload {
    private ProductPayload product;
    private Integer quantity;
}