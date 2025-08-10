
# 📣 My Forum Hub 

<img width="1058" height="285" alt="image" src="https://github.com/user-attachments/assets/faba025d-a7dc-496a-a458-0b76ff2e0c1a" />

O Fórum Hub é uma API REST de um fórum, onde nós criamos e respondemos tópicos e respostas a fim de interagir uns com os outros.  
Seja no intuito de ajudar ou de opinar, o Fórum Hub disponibiliza uma experiência sólida e segura na hora de socializar na internet.



## 🚀 Tecnologias Usadas

- Java LTS 17
- Spring Boot 3.5.3
  - Validation
  - Flyway
  - Security (Com JWT Auth0)
- Maven 
- MySQL  
- Swagger


## ⚙️ Como configurar o projeto

1. Clone o projeto  
   Baixe diretamente aqui na página ou usando o comando:
```
git clone <url-do-repositorio>
```

2. Configure o MySQL  
Com o MySQL já instalado, vá até o terminal com suas informações de acesso e crie um banco de dados chamado "my_forum_hub"
```
CREATE DATABASE my\_forum\_hub;
```

3. Inicie o projeto  
Rode a aplicação pela classe principal:

<img width="302" height="64" alt="image" src="https://github.com/user-attachments/assets/2bc2df24-c926-4bff-ba8a-a9d5a99fa736" />


## 📲 Como usar o projeto

> [!TIP]
> Antes de tudo, é necessário possuir uma aplicação que te permite executar testes na api, como o [Postman](https://www.postman.com/explore) ou [Insomnia](https://insomnia.rest/), entre outros...

1. digite (padronizando o modelo JSON) um usuário e faça login no endpoint "/users/signup" usando apenas um bom username e uma senha da sua preferência.
2. Após ter sua conta criada, é só usar seus dados para fazer login no endpoint "users/login"
3. depois disso, copie seu token e utilize o mesmo para autenticar seus acessos a outras requisições.
4. Pronto! agora é só usar sua imaginação para criar e responder tópicos usando os endpoints de "topics" e "answers"

mas a melhor forma de poder testar o projeto é usando o que o Swagger disponibiliza [neste link.](http://localhost:8080/swagger-ui/index.html)


## Possíveis implementações

Até o momento não foi possível executar tudo o que tinha em mente sobre o que eu tinha do projeto, mas segue uma lista de coisas que você pode criar ao projeto:

- [ ] Sistema de Tags, a qual ao criar seu tópico você insere algumas tags e procura por elas;
- [ ] Tipo de usuário Moderador, que não tem privilégio de Administrador;
- [ ] Marcar soluções como RESOLVIDO;

## 🙏 Créditos

- Alura e Oracle, pela oportunidade de aprender
- Todos os professores do curso até o momento, mas especial a Jaque e o Rodrigo
- Alunos do fórum e do Discord que me motivaram com suas experiências na jornada
  

