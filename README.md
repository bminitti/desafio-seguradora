# desafio-seguradora
 
## Stacks Utilizadas

* Java 17
* Spring Boot
* MockServer
* REDIS
* SOLID
* IDE IntelliJ

## Decisão Arquitetura Classe

Embora não tenha experiência com SOLID a ideia foi usar os conceitos de solid para organizar a arquitetura de classes do projeto.

A classe de dominio princial que é Quote (cotação) possui uma interface e sua implementação na classe QuoteImpl desacopla a implementação para garantir flexibilidade na classe "exposta"

As classes services segue o mesmo principio da Quote utilizando interfaces.

Para a divisão das classes services a ideia foi seperar as responsabilidades de cada uma delas de modo que sejam independetes para serem reutlizadas por outros módulos se necessário.

Tratamento de erros utilizei ControllerAdvice do Spring Boot Web para centralizar os erros e desacoplar o tratamento de erros da lógica de negócio

## Considerações Finais

Não consegui terminar o "projeto" em sua totalidade conforme solicitado.

- Itens faltantes:
  - Persistência em banco de dados. (a ideia aqui seria criar um mysql para persistir em uma tabela o número da cotação)
  - SQS para postar a mensagem de cotação criada com sucesso.
  - Consumer para ler o SQS e gerar o número de apólice e atualizar a tabela de cotação com número da apólice + data de criação
  - Serviço para consulta de cotação
  - Testes unitários



