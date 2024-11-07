package br.com.rockha.adapter.inbound.mq.payload;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OrderCreatePayload {

    private List<OrderItemPayload> items;

}