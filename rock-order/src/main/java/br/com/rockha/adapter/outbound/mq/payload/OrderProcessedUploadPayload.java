package br.com.rockha.adapter.outbound.mq.payload;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OrderProcessedUploadPayload {

	private String id;
    private List<OrderItemPayload> items;
    private BigDecimal value;

}