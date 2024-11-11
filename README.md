# Projeto com ecosistema de gerencimento de pedidos

Este projeto é responsável por processar eventos de pedidos recebidos de uma fila RabbitMQ. Ele consome mensagens da fila, processa os dados e persiste as informações no banco de dados entre os projetos de pedidos produtoA, produtoB e dominio.
São 4 projetos que farão toda a orquestração necessaria

## Requisitos

Antes de rodar o projeto, certifique-se de que você tem os seguintes requisitos instalados:

- **Java 17+**
- **Maven 3.6+**
- **RabbitMQ** (para o sistema de mensageria)
- **Banco de Dados Embuitod nas aplicações**

## Configuração do RabbitMQ

Para que o projeto funcione corretamente, você precisa ter uma instância do RabbitMQ rodando. Siga os passos abaixo para configurar o RabbitMQ:

1. **Instalar RabbitMQ**:
   - Você pode instalar o RabbitMQ localmente ou usar uma instância em um servidor.
   - Para instalar localmente, siga as instruções no site oficial: [RabbitMQ Installation Guide](https://www.rabbitmq.com/download.html).

2. **Configurar a Fila**:
   - O projeto espera que uma fila chamada `pedido-event-processed` esteja configurada no RabbitMQ.
   - Você pode criar a fila manualmente ou configurar o RabbitMQ para criar a fila automaticamente ao iniciar o projeto.

## Padrões de Projeto Utilizados

### 1. **Arquitetura Hexagonal (Ports and Adapters)**
- **Evidência**: A arquitetura hexagonal é utilizada com a separação entre **Portas de Entrada (Inbound Ports)** e **Portas de Saída (Outbound Ports)**. Isso é visível nas interfaces como `OrderPortInbound`, `OrderCreatePortOutbound`, `OrderDeletePortOutbound`, etc.
- **Descrição**: A arquitetura hexagonal promove a separação de responsabilidades, permitindo que a lógica de negócios seja isolada de detalhes de infraestrutura, como APIs externas, bancos de dados ou filas de mensagens.
- **Benefício**: Facilita a testabilidade, manutenção e evolução do sistema, além de permitir a substituição de componentes externos sem impactar a lógica de negócios.

### 2. **Mapper (MapStruct)**
- **Evidência**: O uso de mapeadores como `OrderInboundMqMapper` e `OrderRestMapper` indica a aplicação do padrão **Mapper**.
- **Descrição**: O padrão **Mapper** é utilizado para converter entre diferentes representações de dados, como DTOs, comandos e entidades. O `MapStruct` é utilizado para gerar automaticamente o código de mapeamento entre objetos.
- **Benefício**: Reduz a quantidade de código boilerplate e facilita a manutenção, já que as conversões entre objetos são centralizadas e automatizadas.

### 3. **Command Pattern**
- **Evidência**: O uso de comandos como `OrderCreateCommand`, `OrderUpdateCommand`, `OrderDeleteCommand`, etc., é uma clara aplicação do **Command Pattern**.
- **Descrição**: O **Command Pattern** encapsula uma solicitação como um objeto, permitindo que você parametrize clientes com diferentes solicitações, enfileire ou registre solicitações e suporte operações que podem ser desfeitas.
- **Benefício**: Facilita a extensão e modificação de operações sem alterar o código que invoca essas operações. Também permite o desacoplamento entre a solicitação e a execução.

### 4. **Service Layer**
- **Evidência**: Classes como `OrderCoreService`, `OrderCreateRestService`, e `OrderCalculatorService` seguem o padrão de **Service Layer**.
- **Descrição**: O **Service Layer** é uma camada intermediária que contém a lógica de negócios e orquestra as interações entre diferentes componentes, como repositórios, mapeadores e portas de entrada/saída.
- **Benefício**: Centraliza a lógica de negócios, promovendo a reutilização de código e facilitando a manutenção e testes.

### 5. **Factory Method (parcial)**
- **Evidência**: O método `toCommand` nos mapeadores (`OrderRestMapper`, `OrderInboundMqMapper`) atua como uma fábrica para criar objetos de comando a partir de diferentes representações (como JSON ou DTOs).
- **Descrição**: O **Factory Method** é um padrão de criação que define uma interface para criar objetos, mas permite que as subclasses alterem o tipo de objeto que será criado.
- **Benefício**: Facilita a criação de objetos complexos e promove a reutilização de código.

### 6. **Feign Client (Client-Side Proxy)**
- **Evidência**: O uso de `FeignClient` na interface `OrderRestRepository` é um exemplo de **Client-Side Proxy**.
- **Descrição**: O **Feign Client** é um cliente HTTP declarativo que simplifica a comunicação com APIs RESTful. Ele atua como um proxy, permitindo que você faça chamadas HTTP como se estivesse chamando métodos locais.
- **Benefício**: Reduz a complexidade de fazer chamadas HTTP, abstraindo detalhes como serialização, deserialização e tratamento de erros.

### 7. **DTO (Data Transfer Object)**
- **Evidência**: O uso de objetos como `OrderDTO`, `OrderCreateRequestJson`, `OrderResponseJson`, etc., segue o padrão **DTO**.
- **Descrição**: O **DTO** é um padrão usado para transferir dados entre diferentes camadas de um sistema, especialmente entre a camada de apresentação e a camada de serviço.
- **Benefício**: Reduz o número de chamadas remotas e encapsula os dados que precisam ser transferidos, promovendo a separação de preocupações.

### 8. **SLF4J (Logging)**
- **Evidência**: O uso de `@Slf4j` em várias classes, como `OrderCreateRestService` e `OrderCoreService`, indica a aplicação de boas práticas de **Logging**.
- **Descrição**: O SLF4J é uma API de logging que permite que você logue informações importantes sobre o comportamento do sistema, como erros, exceções e eventos de negócios.
- **Benefício**: Facilita a depuração e monitoramento do sistema, além de permitir a integração com diferentes frameworks de logging (Logback, Log4j, etc.).

### 9. **Controller Advice (Exception Handling)**
- **Evidência**: A classe `ErrorRestControllerAdvice` segue o padrão **Controller Advice** para tratamento centralizado de exceções.
- **Descrição**: O **Controller Advice** é uma anotação do Spring que permite o tratamento global de exceções em controladores REST. Ele captura exceções lançadas pelos controladores e retorna respostas HTTP apropriadas.
- **Benefício**: Centraliza o tratamento de erros, promovendo a reutilização de código e garantindo respostas consistentes para erros.

### 10. **OpenAPI/Swagger (API Documentation)**
- **Evidência**: A classe `RestDocConfig` configura o **OpenAPI** para gerar documentação da API.
- **Descrição**: O **OpenAPI** (anteriormente Swagger) é um padrão para descrever APIs RESTful. Ele permite a geração automática de documentação interativa para APIs.
- **Benefício**: Facilita a comunicação entre desenvolvedores e consumidores da API, além de permitir a geração automática de clientes e servidores.

### 11. **Record (Imutabilidade)**
- **Evidência**: O uso de `record` em classes como `OrderCreateRequestJson` e `OrderItemRequestJson` é uma boa prática para garantir a imutabilidade.
- **Descrição**: O **record** é uma funcionalidade do Java que permite a criação de classes imutáveis de forma concisa, com suporte automático para getters, `equals`, `hashCode` e `toString`.
- **Benefício**: Promove a imutabilidade, que é uma boa prática para evitar efeitos colaterais indesejados e facilitar a concorrência.

### 12. **Validation (Bean Validation)**
- **Evidência**: O uso de anotações como `@NotNull` em `OrderCreateRequestJson` e `OrderItemRequestJson` indica a aplicação de **Bean Validation**.
- **Descrição**: O **Bean Validation** é um padrão para validar os dados de entrada de forma declarativa, usando anotações como `@NotNull`, `@Size`, etc.
- **Benefício**: Garante que os dados de entrada estejam corretos antes de serem processados, evitando erros de validação na lógica de negócios.

### 13. **Builder Pattern**
- **Evidência**: O uso de `@SuperBuilder` em classes como `CommonDTO` e `OrderUpdateCommand` indica a aplicação do **Builder Pattern**.
- **Descrição**: O **Builder Pattern** é um padrão de criação que facilita a construção de objetos complexos, permitindo a criação de objetos passo a passo.
- **Benefício**: Facilita a criação de objetos imutáveis e melhora a legibilidade do código, especialmente quando há muitos parâmetros.

## Boas Práticas

### 1. **Injeção de Dependências**
- O uso de `@Autowired` e construtores para injeção de dependências segue as boas práticas de inversão de controle (IoC), promovendo o desacoplamento entre componentes.

### 2. **Responsabilidade Única (SRP)**
- Cada classe tem uma responsabilidade bem definida, como `OrderCoreService` para lógica de negócios, `OrderRestMapper` para mapeamento, e `OrderRestController` para controle de requisições HTTP.

### 3. **Segregação de Interfaces**
- As interfaces são bem definidas e segregadas, como `OrderPortInbound` e `OrderCreatePortOutbound`, seguindo o princípio de segregação de interfaces (ISP).

---