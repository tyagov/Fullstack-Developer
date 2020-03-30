# Introduções para instalação do Sistema.

Comando para subir o container docker com a imagem do PostgresSQL

1°
	- docker-compose -f compose.yml up -d dentro do service "api"
	Se estiver utilizando banco local, execute este passo:
	- crie um banco PostgresSQL com usuario postgres e senha postgres, em seguida uma tabela com nome "api"
	
	
2° crar base de dados com nome "api"

3° Rodar service "discovery-server", para que as demais aplicações se registrem no EurekaService

4° Rodar api-gateway-zuul para centralizar as rotas a partir do EurekaService;

5° Rodar o service "api"

6° Rodar o service "frete-service"

7° Rodar o service "angular-service" utlizando o comando ng s
