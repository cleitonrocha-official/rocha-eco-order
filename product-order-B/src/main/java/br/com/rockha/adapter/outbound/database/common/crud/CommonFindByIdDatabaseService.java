package br.com.rockha.adapter.outbound.database.common.crud;

import java.util.function.Supplier;

import br.com.rockha.adapter.outbound.database.common.CommonDatabaseMapper;
import br.com.rockha.adapter.outbound.database.common.CommonEntity;
import br.com.rockha.adapter.outbound.database.common.CommonRepository;
import br.com.rockha.core.common.CommonDTO;
import br.com.rockha.core.common.adapter.adapter.CommonUseCase;
import br.com.rockha.core.common.adapter.command.CommonReadOrUpadateDataCommand;
import br.com.rockha.core.error.common.client.CommonNotFoundException;

public abstract class CommonFindByIdDatabaseService<
        Entity extends CommonEntity,
        DTO extends CommonDTO,
        Command extends CommonReadOrUpadateDataCommand
    > implements CommonUseCase<DTO, Command> {

    private final CommonRepository<Entity> repository;
    private final CommonDatabaseMapper<Entity, DTO, ?> mapper;
    private final Supplier<CommonNotFoundException> notFoundExceptionSupplier;

    protected CommonFindByIdDatabaseService(
            CommonRepository<Entity> repository,
            CommonDatabaseMapper<Entity, DTO, ?> mapper,
            Supplier<CommonNotFoundException> notFoundExceptionSupplier
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.notFoundExceptionSupplier = notFoundExceptionSupplier;
    }

    @Override
    public DTO process(Command command) {
        return repository.findById(command.getId())
                .map(mapper::toDTO)  // Usa o método toDTO para mapear a entidade para DTO
                .orElseThrow(notFoundExceptionSupplier);  // Lança exceção se não encontrar
    }
}