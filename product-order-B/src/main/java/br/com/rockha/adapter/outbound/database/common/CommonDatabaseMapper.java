package br.com.rockha.adapter.outbound.database.common;

import org.mapstruct.Mapping;

import br.com.rockha.core.common.CommonDTO;
import br.com.rockha.core.common.adapter.command.CommonCreateDataCommand;

public interface CommonDatabaseMapper<Entity extends CommonEntity, DTO extends CommonDTO, CreateCommand extends CommonCreateDataCommand> {

    @Mapping(target = "id", ignore = true) // Ignora o campo "id" em todas as entidades
    Entity toEntity(CreateCommand command);

    DTO toDTO(Entity entity);
}