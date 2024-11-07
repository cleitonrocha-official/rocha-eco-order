package br.com.rockha.adapter.outbound.database.common.crud;

import java.util.function.Supplier;

import br.com.rockha.adapter.outbound.database.common.CommonEntity;
import br.com.rockha.adapter.outbound.database.common.CommonRepository;
import br.com.rockha.core.common.adapter.adapter.CommonUseCase;
import br.com.rockha.core.common.adapter.command.CommonReadOrUpadateDataCommand;
import br.com.rockha.core.error.common.client.CommonNotFoundException;

public abstract class CommonDeleteDatabaseService<
        Entity extends CommonEntity,
        Command extends CommonReadOrUpadateDataCommand
    > implements CommonUseCase<Void, Command> {

    private final CommonRepository<Entity> repository;
    private final Supplier<CommonNotFoundException> notFoundExceptionSupplier;

    protected CommonDeleteDatabaseService(
            CommonRepository<Entity> repository,
            Supplier<CommonNotFoundException> notFoundExceptionSupplier
    ) {
        this.repository = repository;
        this.notFoundExceptionSupplier = notFoundExceptionSupplier;
    }

    @Override
    public Void process(Command command) {
        var entity = repository.findById(command.getId())
                .orElseThrow(notFoundExceptionSupplier);  // Lança exceção se não encontrar
        repository.delete(entity);  // Exclui a entidade
        return null;
    }
}