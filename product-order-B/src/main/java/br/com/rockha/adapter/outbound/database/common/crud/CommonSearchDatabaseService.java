package br.com.rockha.adapter.outbound.database.common.crud;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.com.rockha.adapter.outbound.database.common.CommonDatabaseMapper;
import br.com.rockha.adapter.outbound.database.common.CommonEntity;
import br.com.rockha.adapter.outbound.database.common.CommonRepository;
import br.com.rockha.adapter.outbound.database.common.specification.CommonSpecificationService;
import br.com.rockha.core.common.CommonDTO;
import br.com.rockha.core.common.adapter.adapter.CommonUseCase;
import br.com.rockha.core.common.adapter.command.CommonSearchDataCommand;

public abstract class CommonSearchDatabaseService<
        Entity extends CommonEntity,
        Command extends CommonSearchDataCommand,
        DTO extends CommonDTO
    > implements CommonSpecificationService<Entity, Command>, CommonUseCase<Page<DTO>, Command> {

    private final CommonRepository<Entity> repository;
    private final CommonDatabaseMapper<Entity, DTO, ?> mapper;

    protected CommonSearchDatabaseService(CommonRepository<Entity> repository, CommonDatabaseMapper<Entity, DTO, ?> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<DTO> process(Command command) {
        Pageable pageable = command.getPageable();
        return repository.findAll(byCriteria(command), pageable)
                         .map(mapper::toDTO);
    }

    @Override
    public abstract Specification<Entity> byCriteria(Command command);
}