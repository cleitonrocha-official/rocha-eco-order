package br.com.rockha.adapter.outbound.database.service.product;

import org.springframework.stereotype.Service;

import br.com.rockha.adapter.outbound.database.common.crud.CommonDeleteDatabaseService;
import br.com.rockha.adapter.outbound.database.entity.Product;
import br.com.rockha.adapter.outbound.database.repository.ProductRepository;
import br.com.rockha.core.command.product.ProductDeleteCommand;
import br.com.rockha.core.error.notfound.ProductNaoEncontradoException;
import br.com.rockha.core.port.outbound.product.ProductDeletePortOutbound;

@Service
public class ProductDeleteDatabaseService
        extends CommonDeleteDatabaseService<Product, ProductDeleteCommand>
        implements ProductDeletePortOutbound {

    public ProductDeleteDatabaseService(final ProductRepository repository) {
        super(repository, ProductNaoEncontradoException::new);
    }
}