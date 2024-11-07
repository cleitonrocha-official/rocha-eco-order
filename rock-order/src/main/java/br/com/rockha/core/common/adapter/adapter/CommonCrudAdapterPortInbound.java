package br.com.rockha.core.common.adapter.adapter;

import org.springframework.data.domain.Page;

import br.com.rockha.core.common.CommonDTO;
import br.com.rockha.core.common.adapter.command.CommonCreateDataCommand;
import br.com.rockha.core.common.adapter.command.CommonReadOrUpadateDataCommand;
import br.com.rockha.core.common.adapter.command.CommonSearchDataCommand;

/**
 * Interface genérica para portas de entrada (Inbound Ports) na Arquitetura Hexagonal.
 *
 * @param <DTO> Tipo do DTO que será retornado.
 * @param <CreateCommand> Tipo do comando para criação.
 * @param <UpdateCommand> Tipo do comando para atualização.
 * @param <DeleteCommand> Tipo do comando para exclusão.
 * @param <FindByIdCommand> Tipo do comando para busca por ID.
 * @param <SearchCommand> Tipo do comando para busca com critérios.
 */
public interface CommonCrudAdapterPortInbound<
        DTO extends CommonDTO,
        CreateCommand extends CommonCreateDataCommand,
        UpdateCommand extends CommonReadOrUpadateDataCommand,
        DeleteCommand extends CommonReadOrUpadateDataCommand,
        FindByIdCommand extends CommonReadOrUpadateDataCommand,
        SearchCommand extends CommonSearchDataCommand>{

    /**
     * Busca uma lista paginada de DTOs com base nos critérios de busca.
     *
     * @param input O comando de busca com critérios.
     * @return Uma página de DTOs.
     */
    Page<DTO> search(SearchCommand input);

    /**
     * Busca um DTO por ID.
     *
     * @param input O comando de busca por ID.
     * @return O DTO correspondente ao ID.
     */
    DTO findById(FindByIdCommand input);

    /**
     * Cria um novo recurso com base no comando de criação.
     *
     * @param input O comando de criação.
     * @return O DTO do recurso criado.
     */
    DTO create(CreateCommand input);


    /**
     * Atualiza um recurso existente com base no comando de atualização.
     *
     * @param input O comando de atualização.
     * @return O DTO do recurso atualizado.
     */
    DTO update(UpdateCommand input);

    /**
     * Exclui um recurso com base no comando de exclusão.
     *
     * @param input O comando de exclusão.
     */
    void delete(DeleteCommand input);
}