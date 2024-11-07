package br.com.rockha;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.rockha.entity.Order;

@RepositoryRestResource
public interface OrderRestRepository extends JpaRepository<Order, String>{

}
