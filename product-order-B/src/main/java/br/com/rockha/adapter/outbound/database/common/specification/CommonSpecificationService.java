package br.com.rockha.adapter.outbound.database.common.specification;

import org.springframework.data.jpa.domain.Specification;

public interface CommonSpecificationService<Entity,Command> {
      Specification<Entity> byCriteria(Command command);

}
