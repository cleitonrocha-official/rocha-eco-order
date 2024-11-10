package br.com.rockha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.rockha.entity.OrderItem;

@RepositoryRestResource
public interface OrderItemRestRepository extends JpaRepository<OrderItem, String>{

}
