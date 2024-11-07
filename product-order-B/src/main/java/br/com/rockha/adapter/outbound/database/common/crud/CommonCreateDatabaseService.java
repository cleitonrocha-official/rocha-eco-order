package br.com.rockha.adapter.outbound.database.common.crud;

import br.com.rockha.adapter.outbound.database.common.CommonDatabaseMapper;
import br.com.rockha.adapter.outbound.database.common.CommonEntity;
import br.com.rockha.adapter.outbound.database.common.CommonRepository;
import br.com.rockha.core.common.CommonDTO;
import br.com.rockha.core.common.adapter.adapter.CommonUseCase;
import br.com.rockha.core.common.adapter.command.CommonCreateDataCommand;

public abstract class CommonCreateDatabaseService<
        Entity extends CommonEntity,
        DTO extends CommonDTO,
        Command extends CommonCreateDataCommand>
        implements CommonUseCase<DTO, Command> {

    private final CommonRepository<Entity> repository;
    private final CommonDatabaseMapper<Entity, DTO, Command> mapper;

    protected CommonCreateDatabaseService(CommonRepository<Entity> repository, CommonDatabaseMapper<Entity, DTO, Command> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DTO process(Command command) {
        var entity = mapper.toEntity(command);
        var newEntity = repository.save(entity);
        return mapper.toDTO(newEntity);
    }
}