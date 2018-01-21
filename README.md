### Desafio Conductor de Seleção 
Olá, queremos convidá-lo a participar de nosso desafio de seleção.  Pronto para participar? Seu trabalho será visto por nosso time e você receberá ao final um feedback sobre o que achamos do seu trabalho. Não é legal?

### Sobre a oportunidade 
A vaga é para Desenvolvedor, temos vagas com diversos níveis de senioridade e para cada um deles utilizaremos critérios específicos considerando esse aspecto, combinado? 
Se você for aprovado nesta etapa, será convidado para uma entrevista final com nosso time de especialistas.

### Desafio Técnico
  Nós da Conductor trabalhamos com meios de pagamento e nada melhor para um bom sistema que um ótimo cadastro de seus clientes:
  - Pré-requisitos:
    ```
    * Desenvolver os recursos em API Rest;
    ```

  - O que esperamos como escopo mínimo:
    ```
    * Implementar a listagem;
    * Implementar a consulta do cliente;
    * Implementar o cadastro de um novo cliente;
    * Implementar edição de cliente;
    ```
  - O que será diferencial:
    ```
    * Implementar paginação;
    * Elaborar documentação;
    * Elaborar testes.
    ```
    
  - O que vamos avaliar:
    ```
    * Seu código; 
    * Organização;
    * Boas práticas;
    * Diferenciais;    
    ```


### Instruções
      1. Faça o fork do desafio e crie uma branch 'desafio_clientes_nome_candidato';
      2. Desenvolva. Você terá 2 (dois) dias a partir da data do envio do desafio; 
      3. Após concluir seu trabalho faça um push; 
      4. Solicite o Merge request para o repositório original e que a força esteja com você.

### Serviços REST:
1. GET '/cliente/get' - Lista todos os clientes.
2. GET '/cliente/get/{id}' - Pega o cliente do ID passado.
3. POST '/cliente/add' - Adiciona um novo cliente. Requer o objecto 'cliente'.
4. PUT '/cliente/edit' - Edita o cliente. Requer o objecto 'cliente', com o id a ser editado.
5. DELETE '/cliente/delete/{id}' - Deleta o cliente do ID passado.
	  
### Instruções para abrir a página
1. Necessário ter o Node e NPM instalado, pois o front-end está em angular;
2. Na linha de comando acesse a pasta 'web/' dentro do projeto e rode 'npm install' para instalar as dependecias do angular;
3. Após as instalações de pacotes execute 'ng serve --open' para executar e abrir o projeto.
4. É possível fazer testes dos comandos por ferramentas de acesso a API ou REST, como plugins do chrome ou firefox.
