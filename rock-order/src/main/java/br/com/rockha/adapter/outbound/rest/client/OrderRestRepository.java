package br.com.rockha.adapter.outbound.rest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.rockha.adapter.outbound.rest.model.Order;

@FeignClient(name = "orderDataRestClient", url = "http://localhost:8060")
public interface OrderRestRepository {

    @PostMapping("/orders")
    ResponseEntity<Order> create(@RequestBody Order order);

    @DeleteMapping("/orders/{id}")
    ResponseEntity<Void> delete(@PathVariable String id);

    @GetMapping("/orders/{id}?projection=fullOrder")
    ResponseEntity<Order> getById(@PathVariable String id);

    @GetMapping("/orders")
    Page<Order> getAll(Pageable pageable); ;
	
}
