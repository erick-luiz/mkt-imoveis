# 🏠 Marketplace Imobiliario 

Este projeto visa unificar as ofertas imobiliarias distribuidas nos sites das corretoras. 
Em cidades interioranas é bem comum vermos sites de pouca qualidade quando estamos procurando um lugar para alugar ou mesmo comprar. 
A ideia aqui é unificar as informações sobre os imoveis e apresentar de uma forma mais intuitiva e facilitada para o usuário final, 
permitindo que ele acesse o link original da publicação. 


# Local

### ➡️ Pré-requisitos 
* Docker 

### 🐋 Docker 

Como descrito no tópico anterior o docker é um pré-requisito para 
rodar este serviço. As dependencias como banco de dados, sistema de 
mock, etc... estarão rodando via docker compose. 

Para isso navegue até a pasta do projeto e rode o comando: 

``` docker-compose up -d ```

este comando irá baixar as imagens caso elas não tenham sido baixadas anteriormente
e irá subir os containers delas. 

#### 🐘 Postgres e PGAdmin 

Após rodar o docker compose você poderá acessar o PGAdmin que é uma das imagens inclusas no docker-compose file. 

Para isso vá no navegador e acesse localhost:5050. 
O usuario padrão é pgadmin@example.com e a senha padrão é admin.

Estes são configurações padrões que você pode mudar setando as variaveis de ambiente: 
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

IMPORTANTE: como você está rodando o postgres via docker é crucial verificar se o postgres não está rodando no local antes e finalizalo. 

Após conectar no server crie o banco imobiliaria. 

### Configurando o Serviço no intelij 

* Vá na opção "edit run/debug configurations" e selecione "edit configurations"
* Click no botão de + e selecione Application 
* Preencha os dados: 
  * **Name**: Main (ou outro a seu critério)
  * **JDK** or JRE: Java 17 ou superior 
  * **Module**: imobiliaria.imobiliaria.main~1 
  * **Main Class**: com.mkt.imobiliaria.ImobiliariaApplication
  * **Variaveis de Ambiente**: 
    * DB_URL: jdbc:postgresql://localhost:5432/imobiliaria
    * POSTGRES_USER=postgres;
    * POSTGRES_PASSWORD=postgres