package br.com.rockha.core.service;

import org.springframework.stereotype.Service;

import br.com.rockha.core.command.product.ProductCreateCommand;
import br.com.rockha.core.command.product.ProductDeleteCommand;
import br.com.rockha.core.command.product.ProductFindByIdCommand;
import br.com.rockha.core.command.product.ProductSearchCommand;
import br.com.rockha.core.command.product.ProductUpdateCommand;
import br.com.rockha.core.common.CommonCrudCoreService;
import br.com.rockha.core.dto.ProductDTO;
import br.com.rockha.core.port.inbound.ProductPortInbound;
import br.com.rockha.core.port.outbound.product.ProductCreatePortOutbound;
import br.com.rockha.core.port.outbound.product.ProductDeletePortOutbound;
import br.com.rockha.core.port.outbound.product.ProductFindByIdPortOutbound;
import br.com.rockha.core.port.outbound.product.ProductSearchPortOutbound;
import br.com.rockha.core.port.outbound.product.ProductUpdatePortOutbound;

@Service
public class ProductCoreService extends CommonCrudCoreService<
		ProductDTO,
        ProductCreateCommand,
        ProductUpdateCommand,
        ProductDeleteCommand,
        ProductFindByIdCommand,
        ProductSearchCommand,
        ProductSearchPortOutbound,
        ProductFindByIdPortOutbound,
        ProductCreatePortOutbound,
        ProductUpdatePortOutbound,
        ProductDeletePortOutbound
    > implements ProductPortInbound {

	 
    public ProductCoreService(
            ProductSearchPortOutbound searchPortOutbound,
            ProductFindByIdPortOutbound findByIdPortOutbound,
            ProductCreatePortOutbound createPortOutbound,
            ProductUpdatePortOutbound updatePortOutbound,
            ProductDeletePortOutbound deletePortOutbound
    ) {
        super(searchPortOutbound, findByIdPortOutbound, createPortOutbound, updatePortOutbound, deletePortOutbound);
        
     
    }
    
    
}