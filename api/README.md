## Fullstack - Developer 

Parabéns, você passou para a segunda fase do processo seletivo da MáximaTech para desenvolvedor Fullstack (Java + Angular).

## Instruções

1. Criar um fork deste repositório e implementar o aplicativo conforme instruções abaixo.
2. Abrir um merge request para este repositório para que possamos avaliar o seu código.
3. Enviar um e-mail para talentoshumanos@maximatech.com.br com:
4. Assunto: “[Teste Desenvolvedor Web] - Seu nome” 
5. Corpo do e-mail: Link do Merge request

É hora do show!

## Resumo

Você foi escolhido para escrever uma PoC (Prova de Conceito) de um e-commerce, basicamente o sistema consiste na criação de Pedidos (cliente + produtos + frete).

O usuário após logar no sistema selecionará a opção "Novo Pedido" para iniciar a venda. 

## Seguem os requisitos:

* A stack de tecnologia a ser utilizada é Java (ou Kotlin) + Angular 6 ou Superior + Spring Boot (com Gradle ou Maven).
* O sistema é composto por 3 microserviços: Serviço Web (Angular) + Serviço Api  (Spring Boot) + Serviço de Cálculo de Frete (Spring Boot).
* Banco de dados - NoSQL (MongoDB) ou SQL (PostgreSQL)
* Tela de listagem dos pedidos
* Todas as informações (JSONs e Pedidos) precisam ser persistidos no banco de dados escolhido.
* Documento descrevendo o processo de instalação do sistema
* O fluxo de autenticação é opcional, o mesmo poderá ser mockado para andamento do projeto.
* O Sistema deverá implementar o fluxo baseado nos arquivos de Design listados no item **Arquivos**

## Microserviço de Cálculo de Frete
O microserviço de cálculo de frete terá um webservice que  receberá a quantidade de itens que foram selecionados e multiplicará por um valor aleatório entre R$5,00 e R$10,00. Retornando assim o valor calculado.

### Exemplo
Foram selecionados 2 itens do Produto A e 1 item do Produto B, logo teremos 3 itens. O valor sorteado foi R$ 8,00. Assim: 3 x R$ 8,00 = R$ 24,00.

## Diferenciais

* Utilização de docker
* Load Balancer
* Utilização do Service Discovery e Api Gateway
* Desenho Arquitetural
* Escrita de testes

## Arquivos

**GET Request -> Dados do Cliente e Produtos**

	URL : https://api.myjson.com/bins/tnjfr
  
**Design Mockup**

	URL : https://bit.ly/2P0cw5l
  
**Arquivos de Design**

	URL : https://go.aws/2uvDgkY	

## Design Preview

![Preview](https://uploaddeimagens.com.br/images/002/269/261/original/3-novo-pedido.png?1565958536)

## Critérios de Avaliação

* Organização do projeto
* Utilização de padrões arquiteturais
* Clareza do código
* Escolha de estruturas e bibliotecas
* Ausência de crashs e bugs
* Detalhes de UI
* Linguagem de programação

## Dúvidas
Entre em contato com talentoshumanos@maximatech.com.br