# 🏠 Marketplace Imobiliario 

Este projeto visa unificar as ofertas imobiliárias distribuídas nos sites das corretoras. 
Em cidades interioranas é bem comum vermos sites de pouca qualidade quando estamos procurando um lugar para alugar ou mesmo comprar. 
A ideia aqui é unificar as informações sobre os imóveis e apresentar de uma forma mais intuitiva e facilitada para o usuário final, 
permitindo que ele acesse o link original da publicação. 


# Local

### ➡️ Pré-requisitos 
* Docker 

### 🐋 Docker 

Como descrito no tópico anterior o docker é um pré-requisito para 
rodar este serviço. As dependências como banco de dados, sistema de 
mock, etc... estarão rodando via docker compose. 

Para isso navegue até a pasta do projeto e rode o comando: 

``` docker-compose up -d ```

este comando irá baixar as imagens caso elas não tenham sido baixadas anteriormente
e irá subir os containers delas. 

#### 🐘 Postgres e PGAdmin 

Após rodar o docker compose você poderá acessar o PGAdmin que é uma das imagens inclusas no docker-compose file. 

Para isso vá no navegador e acesse localhost:5050. 
O usuário padrão é pgadmin@example.com e a senha padrão é admin.

Estas são configurações padrões que você pode mudar setando as variáveis de ambiente: 
* 👤 PGADMIN_DEFAULT_EMAIL
* 🔑 PGADMIN_DEFAULT_PASSWORD

Para conectar o pgAdmin ao servidor PostgreSQL que está sendo executado no Docker Compose:

1. No painel do lado esquerdo do pgAdmin, clique com o botão direito em "Servers" e escolha "Add Server...".
1. Na aba "General":
1. Name: Um nome para identificar seu servidor PostgreSQL (por exemplo, "Meu Servidor PostgreSQL").
Na aba "Connection":
   1. Host name/address: Use o nome do serviço do PostgreSQL definido no seu arquivo docker-compose.yml. Por padrão, é postgres.
   1. Port: Deixe como 5432 (porta padrão do PostgreSQL).
   1. Maintenance database: Deixe em branco ou use postgres.
   1. Username: 👤 POSTGRES_USER definido no docker-compose.yml (postgres por padrão)
   1. Password: 🔑 POSTGRES_PASSWORD definido no docker-compose.yml (postgres por padrão) 

IMPORTANTE: como você está rodando o postgres via docker é crucial verificar se o postgres não está rodando no local antes e finalizá-lo. 

Após conectar no server crie o banco imobiliaria. 

### Configurando o Serviço no intelij 

* Vá na opção "edit run/debug configurations" e selecione "edit configurations"
* Click no botão de + e selecione Application 
* Preencha os dados: 
  * **Name**: Main (ou outro a seu critério)
  * **JDK** or JRE: Java 17 ou superior 
  * **Module**: imobiliaria.imobiliaria.main
  * **Main Class**: com.mkt.imobiliaria.ImobiliariaApplication
  * **Variaveis de Ambiente**: 
    * DB_URL=jdbc:postgresql://localhost:5432/imobiliaria;
    * POSTGRES_USER=postgres;
    * POSTGRES_PASSWORD=postgres

# 🔧 Code Style (Configure sua IDE)

* Configurando o número de espaços do TAB
  * File > settings > Editor > Code Style > Java > Tabs and Idents
    * Tab size: 4
    * Ident: 4
    * Continuation ident: 8

* Configurando os imports
  * File > settings > Editor > Code Style > Java > Imports
    * Class count to use import with '*': 999 (Isso evita uso de *)
    * Name count to use static import with '*': 999

* Configurando os imports automáticos e a reordenação
  * File > settings > Editor > General > Auto Imports
    * Marque a opção: Optimize imports on the fly 

# Teste Local 
 
Após inicializar o serviço você pode testar as interações com imóveis utilizando a coleção do postman que está
dentro da pasta /doc. 

Como para cadastrar um imóvel é necessário ter uma imobiliária cadastrada, use o sql abaixo para ter a 
imobiliária e seu respectivo endereço cadastrados: 

_Criando o endereço_
```sql
INSERT INTO endereco (endereco_id, logradouro, numero, complemento, bairro, cidade, estado, cep, data_de_atualizacao, data_de_criacao)
VALUES
(nextval('endereco_seq'), 'Rua Teste', '100', 'Apto 101', 'Centro', 'São Paulo', 'SP', '01000-000', NOW(), NOW());
```
_Com o id do endereço criado, crie a imobiliária_
```sql
INSERT INTO imobiliaria (imobiliaria_id, endereco_id, logotipo, nome, contato, data_de_atualizacao, data_de_criacao)
VALUES
(nextval('imobiliaria_seq'), currval('endereco_seq'), 'caminho/do/logotipo.png', 'Imobiliária Teste', '(11) 98765-4321', NOW(), NOW());
```