package br.com.rockha.adapter.inbound.rest.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.rockha.core.common.CommonDTO;
import br.com.rockha.core.common.adapter.adapter.CommonCrudAdapterPortInbound;
import br.com.rockha.core.common.adapter.command.CommonCreateDataCommand;
import br.com.rockha.core.common.adapter.command.CommonReadOrUpadateDataCommand;
import br.com.rockha.core.common.adapter.command.CommonSearchDataCommand;
import jakarta.validation.Valid;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

/**
 * <Classe `GenericCrudRestController`:
 *
 * Esta classe é um controlador genérico para operações CRUD (Create, Read, Update, Delete) em uma arquitetura hexagonal.
 * Ela utiliza um Port Inbound para realizar as operações de negócio e um Mapper para converter entre DTOs, comandos e JSONs.
 * A classe é abstrata, o que significa que deve ser estendida por controladores específicos que forneçam os tipos concretos para os parâmetros genéricos.
 *>
 * <Parâmetros Genéricos:
 *
 * - `PortInbound`: Define a porta de entrada que será usada para realizar as operações de negócio. Deve estender a interface `AdapterPortInbound`.
 * - `Mapper`: Define o mapper responsável pela conversão entre DTOs, comandos e JSONs.
 * - `CreateRequest`: Tipo do request usado para criar um novo recurso.
 * - `UpdateRequest`: Tipo do request usado para atualizar um recurso existente.
 * - `SearchParameter`: Tipo dos parâmetros de busca usados para filtrar os resultados.
 * - `ResponseJson`: Tipo do JSON de resposta que será retornado nas operações.
 * - `DTO`: Tipo do DTO (Data Transfer Object) que representa o recurso.
 * - `CreateCommand`: Tipo do comando usado para criar um novo recurso.
 * - `UpdateCommand`: Tipo do comando usado para atualizar um recurso existente.
 * - `DeleteCommand`: Tipo do comando usado para deletar um recurso.
 * - `FindByIdCommand`: Tipo do comando usado para buscar um recurso por ID.
 * - `SearchCommand`: Tipo do comando usado para realizar buscas com critérios.
 *>
 * <Métodos CRUD:
 *
 * - `create`: Cria um novo recurso com base nos dados fornecidos no request. Retorna o recurso criado e o status HTTP 201 (Created).
 * - `delete`: Deleta um recurso pelo seu ID. Retorna o status HTTP 204 (No Content) se a exclusão for bem-sucedida.
 * - `findById`: Busca um recurso pelo seu ID. Retorna o recurso encontrado e o status HTTP 200 (OK).
 * - `update`: Atualiza um recurso existente com base nos dados fornecidos no request. Retorna o recurso atualizado e o status HTTP 200 (OK).
 * - `search`: Busca uma lista paginada de recursos com base nos parâmetros de busca e paginação. Retorna a lista de recursos e o status HTTP 200 (OK).
 * * Métodos HTTP:
 *  *
 *  * - `POST`: Para criar um novo recurso.
 *  * - `DELETE`: Para deletar um recurso pelo ID.
 *  * - `GET`: Para buscar um recurso pelo ID ou buscar uma lista paginada de recursos.
 *  * - `PATCH`: Para atualizar um recurso existente.
 *>
 * @implSpec
 * Como Usar:
 *
 * Extensão da Classe:
 *
 * Para usar essa classe, você deve criar um controlador específico que estenda `GenericCrudRestController` e forneça os tipos concretos para os parâmetros genéricos.
 *
 * Exemplo:
 *
 *
 * {@code
 * @RestController
 * @RequestMapping("/usuarios")
 * public class UsuarioRestController extends GenericCrudRestController<
 *         UsuarioPortInbound,
 *         UsuarioRestMapper,
 *         UsuarioCreateRequestJson,
 *         UsuarioUpdateRequestJson,
 *         UsuarioSearchParameter,
 *         UsuarioResponseJson,
 *         UsuarioDTO,
 *         UsuarioCreateCommand,
 *         UsuarioUpdateCommand,
 *         UsuarioDeleteCommand,
 *         UsuarioFindByIdCommand,
 *         UsuarioSearchCommand> {
 *
 *     public UsuarioRestController(UsuarioPortInbound portInbound, UsuarioRestMapper mapper) {
 *         super(portInbound, mapper);
 *     }
 * }
 * }
 *
 * @apiNote Controlador genérico para operações CRUD (Create, Read, Update, Delete).
 *
 * Esta classe abstrata fornece uma implementação genérica para operações CRUD em uma arquitetura hexagonal.
 * Ela utiliza um Port Inbound e um Mapper para realizar as operações de conversão e manipulação de dados.
 *
 * @param <PortInbound> Tipo da porta de entrada (Inbound Port), que deve estender {@link CommonCrudAdapterPortInbound}.
 * @param <Mapper> Tipo do mapper responsável pela conversão entre DTOs, comandos e JSONs.
 * @param <CreateRequest> Tipo do request para criação de um novo recurso.
 * @param <UpdateRequest> Tipo do request para atualização de um recurso existente.
 * @param <SearchParameter> Tipo do parâmetro de busca utilizado para filtrar os resultados.
 * @param <ResponseJson> Tipo do JSON de resposta que será retornado nas operações.
 * @param <DTO> Tipo do DTO (Data Transfer Object) que representa o recurso.
 * @param <CreateCommand> Tipo do comando utilizado para criar um novo recurso.
 * @param <UpdateCommand> Tipo do comando utilizado para atualizar um recurso existente.
 * @param <DeleteCommand> Tipo do comando utilizado para deletar um recurso.
 * @param <FindByIdCommand> Tipo do comando utilizado para buscar um recurso por ID.
 * @param <SearchCommand> Tipo do comando utilizado para realizar buscas com critérios.
 */
public abstract class CommonCrudRestController<
        PortInbound extends CommonCrudAdapterPortInbound<DTO, CreateCommand, UpdateCommand, DeleteCommand, FindByIdCommand, SearchCommand>,
        Mapper extends CommonRestMapper<DTO, CreateRequest, UpdateRequest, ResponseJson, CreateCommand, UpdateCommand, DeleteCommand, FindByIdCommand, SearchCommand, SearchParameter>,
        CreateRequest,
        UpdateRequest,
        SearchParameter,
        ResponseJson,
        DTO extends CommonDTO,
        CreateCommand extends CommonCreateDataCommand,
        UpdateCommand extends CommonReadOrUpadateDataCommand,
        DeleteCommand extends CommonReadOrUpadateDataCommand,
        FindByIdCommand extends CommonReadOrUpadateDataCommand,
        SearchCommand extends CommonSearchDataCommand> {

    /**
     * Porta de entrada (Inbound Port) que define as operações de negócio.
     */
    protected final PortInbound portInbound;

    /**
     * Mapper responsável pela conversão entre DTOs, comandos e JSONs.
     */
    protected final Mapper mapper;

    /**
     * Construtor da classe.
     *
     * @param portInbound A porta de entrada que define as operações de negócio.
     * @param mapper O mapper responsável pela conversão entre DTOs, comandos e JSONs.
     */
    protected CommonCrudRestController(PortInbound portInbound, Mapper mapper) {
        this.portInbound = portInbound;
        this.mapper = mapper;
    }

    /**
     * Cria um novo recurso.
     *
     * @param request O request contendo os dados para criação do recurso.
     * @return Um {@link ResponseEntity} contendo o JSON do recurso criado e o status HTTP 201 (Created).
     */
    @PostMapping
    public ResponseEntity<ResponseJson> create(@Valid @RequestBody CreateRequest request) {
        CreateCommand command = mapper.toCommand(request);
        var entity = portInbound.create(command);
        var location = fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
        var response = mapper.toJson(entity);
        return ResponseEntity.created(location).body(response);
    }

    /**
     * Deleta um recurso pelo seu ID.
     *
     * @param id O ID do recurso a ser deletado.
     * @return Um {@link ResponseEntity} com o status HTTP 204 (No Content) se a exclusão for bem-sucedida.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        DeleteCommand command = mapper.toDeleteCommand(id);
        portInbound.delete(command);
        return ResponseEntity.noContent().build();
    }

    /**
     * Busca um recurso pelo seu ID.
     *
     * @param id O ID do recurso a ser buscado.
     * @return Um {@link ResponseEntity} contendo o JSON do recurso encontrado e o status HTTP 200 (OK).
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResponseJson> findById(@PathVariable String id) {
        FindByIdCommand command = mapper.toFindByIdCommand(id);
        var entity = portInbound.findById(command);
        return ResponseEntity.ok(mapper.toJson(entity));
    }

    /**
     * Atualiza um recurso existente.
     *
     * @param id O ID do recurso a ser atualizado.
     * @param request O request contendo os dados para atualização do recurso.
     * @return Um {@link ResponseEntity} contendo o JSON do recurso atualizado e o status HTTP 200 (OK).
     */
    @PatchMapping("/{id}")
    public ResponseEntity<ResponseJson> update(@PathVariable String id, @Valid @RequestBody UpdateRequest request) {
        UpdateCommand command = mapper.toCommand(id, request);
        var entity = portInbound.update(command);
        return ResponseEntity.ok(mapper.toJson(entity));
    }

    /**
     * Busca uma lista paginada de recursos com base nos parâmetros de busca.
     *
     * @param searchParameter Os parâmetros de busca para filtrar os resultados.
     * @param pageable Os parâmetros de paginação.
     * @return Um {@link ResponseEntity} contendo uma página de recursos e o status HTTP 200 (OK).
     */
    @GetMapping
    public ResponseEntity<Page<ResponseJson>> search(SearchParameter searchParameter, Pageable pageable) {
        SearchCommand command = mapper.toSearchCommand(searchParameter, pageable);
        var page = portInbound.search(command);
        return ResponseEntity.ok(page.map(mapper::toJson));
    }
}