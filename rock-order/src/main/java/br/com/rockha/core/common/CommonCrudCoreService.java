package br.com.rockha.core.common;


import org.springframework.data.domain.Page;

import br.com.rockha.core.common.adapter.adapter.CommonUseCase;
import br.com.rockha.core.common.adapter.adapter.CommonCrudAdapterPortInbound;
import br.com.rockha.core.common.adapter.command.CommonCreateDataCommand;
import br.com.rockha.core.common.adapter.command.CommonReadOrUpadateDataCommand;
import br.com.rockha.core.common.adapter.command.CommonSearchDataCommand;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe abstrata que implementa operações CRUD (Create, Read, Update, Delete) comuns para entidades de domínio.
 * Esta classe deve ser estendida por serviços específicos que implementam a lógica de negócios para diferentes entidades.
 *
 * @param <DTO> O tipo de DTO (Data Transfer Object) que será retornado nas operações.
 * @param <CreateCommand> O tipo de comando usado para criar uma nova entidade.
 * @param <UpdateCommand> O tipo de comando usado para atualizar uma entidade existente.
 * @param <DeleteCommand> O tipo de comando usado para deletar uma entidade existente.
 * @param <FindByIdCommand> O tipo de comando usado para buscar uma entidade pelo ID.
 * @param <SearchCommand> O tipo de comando usado para buscar entidades com critérios de pesquisa.
 * @param <SearchPortOutbound> O tipo de porta de saída usada para realizar a operação de busca.
 * @param <FindByIdPortOutbound> O tipo de porta de saída usada para realizar a operação de busca por ID.
 * @param <CreatePortOutbound> O tipo de porta de saída usada para realizar a operação de criação.
 * @param <UpdatePortOutbound> O tipo de porta de saída usada para realizar a operação de atualização.
 * @param <DeletePortOutbound> O tipo de porta de saída usada para realizar a operação de exclusão.
 */
@Slf4j
public abstract class CommonCrudCoreService<
        DTO extends CommonDTO,
        CreateCommand extends CommonCreateDataCommand,
        UpdateCommand extends CommonReadOrUpadateDataCommand,
        DeleteCommand extends CommonReadOrUpadateDataCommand,
        FindByIdCommand extends CommonReadOrUpadateDataCommand,
        SearchCommand extends CommonSearchDataCommand,
        SearchPortOutbound extends CommonUseCase<Page<DTO>, SearchCommand>,
        FindByIdPortOutbound extends CommonUseCase<DTO, FindByIdCommand>,
        CreatePortOutbound extends CommonUseCase<DTO, CreateCommand>,
        UpdatePortOutbound extends CommonUseCase<DTO, UpdateCommand>,
        DeletePortOutbound extends CommonUseCase<Void, DeleteCommand>
        > implements CommonCrudAdapterPortInbound<DTO, CreateCommand, UpdateCommand, DeleteCommand, FindByIdCommand, SearchCommand> {

    protected final SearchPortOutbound searchPortOutbound;
    protected final FindByIdPortOutbound findByIdPortOutbound;
    protected final CreatePortOutbound createPortOutbound;
    protected final UpdatePortOutbound updatePortOutbound;
    protected final DeletePortOutbound deletePortOutbound;

    /**
     * Construtor para inicializar as portas de saída necessárias para as operações CRUD.
     *
     * @param searchPortOutbound Porta de saída para a operação de busca.
     * @param findByIdPortOutbound Porta de saída para a operação de busca por ID.
     * @param createPortOutbound Porta de saída para a operação de criação.
     * @param updatePortOutbound Porta de saída para a operação de atualização.
     * @param deletePortOutbound Porta de saída para a operação de exclusão.
     */
    protected CommonCrudCoreService(SearchPortOutbound searchPortOutbound,
                                    FindByIdPortOutbound findByIdPortOutbound,
                                    CreatePortOutbound createPortOutbound,
                                    UpdatePortOutbound updatePortOutbound,
                                    DeletePortOutbound deletePortOutbound) {
        this.searchPortOutbound = searchPortOutbound;
        this.findByIdPortOutbound = findByIdPortOutbound;
        this.createPortOutbound = createPortOutbound;
        this.updatePortOutbound = updatePortOutbound;
        this.deletePortOutbound = deletePortOutbound;
    }

    /**
     * Realiza a operação de busca com base nos critérios fornecidos no comando de busca.
     *
     * @param input O comando de busca contendo os critérios de pesquisa.
     * @return Uma página de DTOs que correspondem aos critérios de pesquisa.
     */
    @Override
    public Page<DTO> search(SearchCommand input) {
        log.info("Iniciou search");
        Page<DTO> dtoPage = searchPortOutbound.process(input);
        log.info("Finalizou search com sucesso");
        return dtoPage;
    }

    /**
     * Busca uma entidade pelo seu ID.
     *
     * @param input O comando contendo o ID da entidade a ser buscada.
     * @return O DTO da entidade encontrada.
     */
    @Override
    public DTO findById(FindByIdCommand input) {
        log.info("Iniciou findById para o ID: {}", input.getUuid());
        DTO dto = findByIdPortOutbound.process(input);
        log.info("Finalizou findById com sucesso para o ID: {}", input.getUuid());
        return dto;
    }

    /**
     * Cria uma nova entidade com base nos dados fornecidos no comando de criação.
     *
     * @param input O comando contendo os dados para criar a nova entidade.
     * @return O DTO da entidade criada.
     */
    @Override
    public DTO create(CreateCommand input) {
        log.info("Iniciou create");
        DTO dto = createPortOutbound.process(input);
        log.info("Finalizou create com sucesso");
        return dto;
    }

    /**
     * Atualiza uma entidade existente com base nos dados fornecidos no comando de atualização.
     *
     * @param input O comando contendo os dados para atualizar a entidade.
     * @return O DTO da entidade atualizada.
     */
    @Override
    public DTO update(UpdateCommand input) {
        log.info("Iniciou update para o ID: {}", input.getUuid());
        DTO dto = updatePortOutbound.process(input);
        log.info("Finalizou update com sucesso para o ID: {}", input.getUuid());
        return dto;
    }

    /**
     * Exclui uma entidade com base no ID fornecido no comando de exclusão.
     *
     * @param input O comando contendo o ID da entidade a ser excluída.
     */
    @Override
    public void delete(DeleteCommand input) {
        log.info("Iniciou delete para o ID: {}", input.getUuid());
        deletePortOutbound.process(input);
        log.info("Finalizou delete com sucesso para o ID: {}", input.getUuid());
    }
}