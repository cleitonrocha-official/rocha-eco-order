package br.com.rockha.adapter.outbound.database.service.product;

import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.rockha.adapter.outbound.database.common.crud.CommonSearchDatabaseService;
import br.com.rockha.adapter.outbound.database.entity.Product;
import br.com.rockha.adapter.outbound.database.mapper.ProductDatabaseMapper;
import br.com.rockha.adapter.outbound.database.repository.ProductRepository;
import br.com.rockha.core.command.product.ProductSearchCommand;
import br.com.rockha.core.dto.ProductDTO;
import br.com.rockha.core.port.outbound.product.ProductSearchPortOutbound;
import jakarta.persistence.criteria.Predicate;

@Service
public class ProductSearchDatabaseService extends CommonSearchDatabaseService<Product, ProductSearchCommand, ProductDTO> implements ProductSearchPortOutbound {

    public ProductSearchDatabaseService(final ProductRepository repository, final ProductDatabaseMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Specification<Product> byCriteria(ProductSearchCommand command) {
        return (root, query, criteriaBuilder) -> {
            var predicates = new ArrayList<Predicate>();

       //implementar filtro

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}