# Projeto CRUD Spring Boot

![Captura de Tela](./assets/170031976-645e9bd8-eaca-4a84-805c-588100e1a770.png)

![Captura de Tela](./assets/170031981-68cf5454-a727-467c-82e6-1ba2f53c2900.png)

## Sobre o Projeto:

Uma aplicação web modelada no padrão MVC em Java e construída com o Spring Boot, o projeto conta com uma estrutura de CRUD, no qual os dados estão sendo persistidos em um banco de dados (MySQL). Na camada de visualização foi utilizado HTML, CSS, o framework Bootstrap e o template Thymeleaf.  Também foi utilizado o JavaScript para validação de uma regra de negócio. O sistema possui outras funcionalidades como, tela de login/cadastro, criptografia de dados do usuário, entre outras.
 
## Tecnologias Utilizadas

- Java
- Spring Boot
- JPA / Hibernate
- Maven
- HTML/CSS/JS
- Bootstrap
- MySQL

## Banco de Dados

![Captura de Tela](./assets/170030916-5c05c8c3-71d7-432e-aa6c-02b0ccf30409.png)

![Captura de Tela](./assets/170030921-8948e471-b0c1-4fcc-94aa-4bc94a554df9.png)

## Instalação

O projeto é gerenciado pelo Maven, então para usa-lo basta importa-lo para uma IDE.

## Configurações do banco de dados

Você pode criar um banco de dados MySQL com o nome o nome de sua preferência, porém é necessario adequar o projeto de acordo com as suas configurações. Para isso abra o arquivo application.properties, localizado em src/main/resources/application.properties e altere os seguintes comandos ao arquivo:

```
- spring.datasource.url = jdbc:mysql://localhost:3306/nome-do-seu-banco-de-dados?useTimezone=true&serverTimezone=UTC
- spring.datasource.username = root
- spring.datasource.password = root
```

## Execução

Execute o projeto através do IDE, abra um navegador de sua preferência e digite: http://localhost:8080
