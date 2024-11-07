package br.com.rockha.adapter.outbound.database.service.product;

import org.springframework.stereotype.Service;

import br.com.rockha.adapter.outbound.database.common.crud.CommonFindByIdDatabaseService;
import br.com.rockha.adapter.outbound.database.entity.Product;
import br.com.rockha.adapter.outbound.database.mapper.ProductDatabaseMapper;
import br.com.rockha.adapter.outbound.database.repository.ProductRepository;
import br.com.rockha.core.command.product.ProductFindByIdCommand;
import br.com.rockha.core.dto.ProductDTO;
import br.com.rockha.core.error.notfound.ProductNaoEncontradoException;
import br.com.rockha.core.port.outbound.product.ProductFindByIdPortOutbound;

@Service
public class ProductFindByIdDatabaseService extends CommonFindByIdDatabaseService<Product, ProductDTO, ProductFindByIdCommand> implements ProductFindByIdPortOutbound {

    public ProductFindByIdDatabaseService(final ProductRepository repository, final ProductDatabaseMapper mapper) {
        super(repository, mapper, ProductNaoEncontradoException::new);
    }
}