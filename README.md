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
