# apring-security
API REST com JDK 1.8, Spring Data JPA e Spring Security


Irei desenvolver uma API REST FULL com Spring Boo, JPA (Spring DAta JPA), Spring Securitye e publicarei na AWS. 

Passo 01: Acesse --> https://start.spring.io/ (crie seu projeto)

Passo 02: cria o banco de dados "spring_aws" no seu Mysql

Passo 03: crie suas entidades e realize a aplicação das anotations do JPA

Passo 04: rode o projeto e verifique se as tabelas relacionadas as suas entidades foram criadas.


Passo extra: 
após instalar o Mysql, crie usuário com acesso externo, tornando possível que sua aplicação acesse o Banco de Dados
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'admin';


Passo 05 - Adoção de boas práticas  - Utilização correta dos códigos HTPP
Toda requisição do cliente ao servidor deve resultar em uma resposta e nela existe um código HTPP.

Classe  - Descrição
 2XX     - Requisição sucedida com sucesso
 3XX     - Indicação de uma ação a ser tomada pelo cliente para a conclusão do seu pedido
 4XX     - Erro na requisição causada pelo cliente
 5XX     - Erros internos do servidor


Exemplos de códigos HTTP

Código    -  Descrição 							- Exemplos
  200       - OK                                       - Listar usuários, buscar um usuário
  201       - CREATED							- Salvar um usuário na base de dados
  302       - FOUND								- Tenta ceder um recurso que foi substituido, assim sendo o recurso disponibiliazado pela API
  400       - BAD_REQUEST					- Acontece em validações (dados incompletos)
  401       - UNAUTHORIZED					- Acontecer quando o cliente não esta autorizado a consumir um recurso (Login/ Password incorreto)
  403       - FORBIDEN							- Acontece quando usuário não priveligiado tentar acessar um determinado recurso (acessar URI/ operação) o qual não possui autorização
  404       - NOT_FOUND                        - Acontece quando o usuário deseja buscar um dado/ resultado que não existe  através em uma operação do tipo GET
  503       - SERVICE UNAVAILABLE		- Acontece por falta capacidade computacional do servidor ou falta de manutenção de infra-estrutura.
  
  
Passo 08 -  Criando as operações/ recursos
 
Passo 09 -  Aguardem os próximos passos
  
Passo 10 - 
   
Passo 11 - 
	
Passo 12 - 
 
 
 
 

 

