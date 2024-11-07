package br.com.rockha.adapter.outbound.database.service.product;

import org.springframework.stereotype.Service;

import br.com.rockha.adapter.outbound.database.common.crud.CommonUpdateDatabaseService;
import br.com.rockha.adapter.outbound.database.entity.Product;
import br.com.rockha.adapter.outbound.database.mapper.ProductDatabaseMapper;
import br.com.rockha.adapter.outbound.database.repository.ProductRepository;
import br.com.rockha.core.command.product.ProductUpdateCommand;
import br.com.rockha.core.dto.ProductDTO;
import br.com.rockha.core.error.notfound.ProductNaoEncontradoException;
import br.com.rockha.core.port.outbound.product.ProductUpdatePortOutbound;

@Service
public class ProductUpdateDatabaseService extends CommonUpdateDatabaseService<Product, ProductDTO, ProductUpdateCommand> implements ProductUpdatePortOutbound {

    public ProductUpdateDatabaseService(
            final ProductRepository repository,
            final ProductDatabaseMapper mapper) {
        super(repository, mapper, ProductNaoEncontradoException::new);
    }

    @Override
    public void patch(Product Product, ProductUpdateCommand command) {
    }
}