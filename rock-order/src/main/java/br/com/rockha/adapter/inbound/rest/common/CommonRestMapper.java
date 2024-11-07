package br.com.rockha.adapter.inbound.rest.common;

import org.springframework.data.domain.Pageable;

import br.com.rockha.core.common.CommonDTO;

public interface CommonRestMapper<DTO extends CommonDTO,CreateRequestJson, UpdateRequestJson, ResponseJson, CreateCommand, UpdateCommand, DeleteCommand, FindByIdCommand, SearchCommand, SearchParameter> {

    // Mapeia de DTO para ResponseJson
    ResponseJson toJson(DTO dto);

    // Mapeia de CreateRequestJson para CreateCommand
    CreateCommand toCommand(CreateRequestJson requestJson);

    // Mapeia de UpdateRequestJson para UpdateCommand, usando o ID
    UpdateCommand toCommand(String id, UpdateRequestJson requestJson);

    // Mapeia de String (id) para DeleteCommand
    DeleteCommand toDeleteCommand(String id);

    // Mapeia de String (id) para FindByIdCommand
    FindByIdCommand toFindByIdCommand(String id);

    // Mapeia de SearchParameter e Pageable para SearchCommand
    SearchCommand toSearchCommand(SearchParameter searchParameter, Pageable pageable);
}