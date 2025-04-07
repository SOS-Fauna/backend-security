# SOS Fauna - Security

Esta API possui algumas funções e implementações cujo quais são

## Funcionalidades

* Principais funcionalidades:
    * Registro de usuário
    * Login com email e senha
    * Recuperação de senha
    * Autenticação JWT

## Tecnologias Utilizadas

* Tecnologias utilizadas no backend:
    * Springboot
    * MySQL
    * JSON Web Tokens (JWT)
    * Bcrypt
    * Java Mail Sender
    * Docker

## Pré-requisitos

* Liste as dependências necessárias para executar o projeto. Por exemplo:
    * Java (Versão 21)
    * MySQL

## Instalação

1.  Clone o repositório:

    ```bash
    git clone https://github.com/SOS-Fauna/backend-security.git
    ```

## Execução

1.  Inicie o servidor:

    * Basta inicia-la em sua IDE de desenvolvimento e ter o SQL ligado a mesma.

2.  A API estará disponível em `http://localhost:8080` (ou a porta configurada).

## Endpoints da API

* Liste os endpoints da API e seus métodos HTTP. Por exemplo:

  ### Login e Registro

    * `POST /auth/register/user`: Registra um novo usuário.
    *  `POST /auth/register/ong`: Registra uma nova ONG.
    * `POST /auth/login/user`: Autentica um usuário e retorna um token JWT.
    * `POST /auth/login/ong`: Autentica uma ONG e retorna um token JWT.

  ### Reset de senha

    * `POST /reset/solicitar/user`: Inicia o processo de recuperação de senha de Usuário, enviando-o um token de recuperação de senha de 6 dígitos via email.
    * `POST /reset/solicitar/ong`: Inicia o processo de recuperação de senha de ONG, enviando-a um token de recuperação de senha de 6 dígitos via email.
    * `POST /reset/executar/user`: Redefine a senha de um usuário.
    * `POST /reset/executar/ong`: Redefine a senha de uma ONG.

## Testes

* Instruções sobre como executar os testes da API. Por exemplo:

    * Basta ir até o navegador, ou em ferramentas de testes de API (Como Insomnia ou Postman) e utilizar dos endpoints listados, alterando o Corpo de cada requisição.

## Contribuição

* Instruções sobre como contribuir para o projeto. Por exemplo:

    1.  Faça um fork do repositório.
    2.  Crie uma branch para a sua feature (`git checkout -b feature/minha-feature`).
    3.  Faça commit das suas mudanças (`git commit -am 'Adiciona nova feature'`).
    4.  Faça push para a branch (`git push origin feature/minha-feature`).
    5.  Abra um Pull Request.

## Contato

* Informações de contato para dúvidas ou sugestões:

    Se você tiver alguma dúvida ou sugestão, entre em contato comigo no [Meu perfil do LinkedIn](https://www.linkedin.com/in/tallys-labanca/).
