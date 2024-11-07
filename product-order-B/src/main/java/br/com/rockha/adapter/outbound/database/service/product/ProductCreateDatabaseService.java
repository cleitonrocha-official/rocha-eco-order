package br.com.rockha.adapter.outbound.database.service.product;

import org.springframework.stereotype.Service;

import br.com.rockha.adapter.outbound.database.common.crud.CommonCreateDatabaseService;
import br.com.rockha.adapter.outbound.database.entity.Product;
import br.com.rockha.adapter.outbound.database.mapper.ProductDatabaseMapper;
import br.com.rockha.adapter.outbound.database.repository.ProductRepository;
import br.com.rockha.core.command.product.ProductCreateCommand;
import br.com.rockha.core.dto.ProductDTO;
import br.com.rockha.core.port.outbound.product.ProductCreatePortOutbound;

@Service
public class ProductCreateDatabaseService extends CommonCreateDatabaseService<Product, ProductDTO, ProductCreateCommand> implements ProductCreatePortOutbound {

    public ProductCreateDatabaseService(final ProductRepository repository, final ProductDatabaseMapper mapper) {
        super(repository, mapper);
    }
}