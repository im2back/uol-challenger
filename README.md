# uol-challenger
# Projeto - parcialmente finalizado(VIDEO DEMONSTRATIVO NO MEU LINKEDIN)
https://www.linkedin.com/posts/jefferson-richards-sena-de-souza-4110a3222_compassuol-java-springboot-activity-7128847756936306689-wMbx?utm_source=share&utm_medium=member_desktop
# Sistema de cadastro de jogadores do UOL
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/im2back/Voll.med/blob/main/LICENSE) 

# Sobre o projeto
Link do desafio original : https://github.com/uolhost/test-backEnd-Java#proposta
### Proposta
O 'novo' sistema de cadastro de jogadores do UOL precisa de uma nova cara! Isso porque a área de lazer da empresa definiu que todo jogador deverá ter um codinome. A proposta foi um sucesso e muitos candidatos se inscreveram, por isso a área de lazer acabou restringindo os codinomes em duas listas distintas: "Os Vingadores" e "A Liga da Justiça".

Seu desafio é elaborar um sistema em Java capaz de:

1. Permitir o cadastro de jogadores de acordo com os codinomes contidos nos links de referência vingadores.json e liga_da_justica.xml <br>
2. Apresentar um cadastro contendo nome, e-mail e telefone do jogador (sendo que nome e e-mail são obrigatórios)<br>
3. Persistir a informação cadastrada em um banco de dados em memória, como HSQLDB ou arquivo<br>
4. Obter, a qualquer momento, a lista de todos os jogadores cadastrados com seus respectivos codinomes e também a informação de qual lista o codinome foi extraído<br>
5. Impedir a utilização de um mesmo codinome para diferentes usuários (a menos que o codinome seja para listas diferentes)<br>
6. Incluir o codinome escolhido dentro das listas Os Vingadores ou A Liga da Justiça<br>
7. Obrigatoriamente, ler a informação do codinome em arquivos na internet (links abaixo). Atenção: não vale guardar a informação do codinome localmente (em um arquivo, em uma classe, em um banco de dados etc.)<br>


## Arquitetura de referência
![image](https://github.com/im2back/uol-challenger/assets/117541466/d251cd4c-c05e-427d-82fb-2471502cf642)

## Documentação
![image](https://github.com/im2back/uol-challenger/assets/117541466/871e34bb-23b5-4250-bcb7-4aae7d2dcb31)


# Prints do meu projeto 
## Tela de cadastro:

![image](https://github.com/im2back/uol-challenger/assets/117541466/371d7677-040c-4a72-91bd-6c4e2e67f9fc)


## Tela de feedback pós cadastro: 

![image](https://github.com/im2back/uol-challenger/assets/117541466/5f611cb8-be19-4605-b89a-b70a5f5584c9)

## Tela listar jogadores:

![image](https://github.com/im2back/uol-challenger/assets/117541466/50a354c4-eec9-4669-b550-e2228f50151f)

## Tela Editar jogador :

![image](https://github.com/im2back/uol-challenger/assets/117541466/493d1664-8c2c-4bfe-a31c-c68fa99ad7a5)

## Banco de dados h2 print : 

![image](https://github.com/im2back/uol-challenger/assets/117541466/42e407df-b664-4a74-95c6-56288762f154)





# Tecnologias utilizadas
## Back end
- Linguagem : <a href="" target="_blank"><img loading="lazy" src="https://img.shields.io/badge/Java-blue.svg?style=flat&logo=coffeescript&logoColor=white" target="_blank"></a> <br>
- Framework : <a href="" target="_blank"><img loading="lazy" src="https://img.shields.io/badge/SpringBoot-white.svg?style=flat&logo=springboot&logoColor=green" target="_blank"></a> <br>
- Persistência de dados : <a href="" target="_blank"><img loading="lazy" src="https://img.shields.io/badge/JPA-Hibernate-darkgreen.svg?style=flat&logo=hibernate&logoColor=white" target="_blank"></a> <br>
- Gerenciador de dependencias : <a href="" target="_blank"><img loading="lazy" src="https://img.shields.io/badge/Maven-white.svg?style=flat&logo=apachemaven&logoColor=darkgreen" target="_blank"></a> <br>
- DataBase : <a href="" target="_blank"><img loading="lazy" src="https://img.shields.io/badge/H2-DataBase-darkblue.svg?style=flat&logo=h2&logoColor=blue" target="_blank"></a> <br>
- Thymeleaf(Front) : <a href="" target="_blank"><img loading="lazy" src="https://img.shields.io/badge/Thymeleaf-white.svg?style=flat&logo=Thymeleaf&logoColor=red" target="_blank"></a> <br>
- Ferramenta para testar requisições : <a href="" target="_blank"><img loading="lazy" src="https://img.shields.io/badge/PostMan-white.svg?style=flat&logo=postman&logoColor=red" target="_blank"></a> <br>
- Versionamento do repositorio : <a href="" target="_blank"><img loading="lazy" src="https://img.shields.io/badge/GitHub-white.svg?style=flat&logo=github&logoColor=black" target="_blank"></a> <br>

# Como executar o projeto

## Back end
Pré-requisitos: Java 17

```bash
# clonar repositório
git clone https://github.com/im2back/uol-challenger

# entrar na pasta do projeto back end
cd backend

# executar o projeto
./mvnw spring-boot:run
```


# Autor

Wellington Mazoni de Andrade

https://www.linkedin.com/in/wmazoni
