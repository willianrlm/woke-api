# woke-api
Dependências :

    Spring Data JPA
    Spring Web
    Dev Tools
    MySQL
    Spring Test - Junit 5
    Spring Security
    JWT
    Jakarta Validation
    Lombok
    
Para executar:

    [projeto] mvn package
    [projeto] java -jar .\target\solucao-0.1.jar
    (Rodando na porta 80)

Arquitetura:
    
    pacote: com.woke.solucao
        config: data initializer do projeto
            security: configuração do web security e jwt, geração de token, 
                      validação do usuário e filtro
        controller: controladores REST para as operações do front e demais chamadas
                    autenticação ocorre no JwtAuthenticationController
        model: modelos de entidades e requisições/respostas
        repository: interfaces de repositórios das entidades
        service: interface e implementações de serviços de lógica de negócio 
                 e validações de acessos

Modelos:
        
    Person: dados pessoais, pessoa pode conter vários usuários
    Contact: contatos pessoais ligados à Person
    User: dados de acesso, pode estar ligado à Person ou Company
    Company: representa um empresa, podendo conter User(s) de acesso e Candidate(s)
    Candidate: represente a candidatura à uma vaga ou ato de permitir enviar seus dados à uma Company
               liga um usuário e uma empresa possuindo uma "opinião" sobre a empresa

Database: 

    adicionado o arquivo na raiz, porém está configurado para realizar todo o create ao iniciar

Adicionado também o UML automático da base

    acessos configurados para localhost, porta 3306, usuário e senha 'java'
    nome da base: woke

    woke.sql -- MySQL 5.7