##Considerações para rodar o projeto

- Rodar projeto no sts executando a classe MsMovieApplication.java

- Subi um banco de dados postgres no heroku para facilitar. De toda forma está no projeto as versões de scripts de banco que utilizei com o flyway.

- Caminho dos endpoint poderão ser visualizados pelo swagger (http://localhost:8001/swagger-ui/).

- Para acessar os endpoints é necessário efetuar uma requisição POST no endpoint '/users/login'

- Será retornado um token que deverá ser inserido no Authorization da requisição via postman.

- As senhas estão sendo salvas criptografadas com BCrypt mas não conclui o decode no login, portanto enviarei dados de 
autenticação com a string encriptada:
	{
	  "email": "mrenancidrao@gmail.com",
	  "password": "$2y$12$g6V03al6xIMCCmXhXXKtCOck7DkzOj2431B24pH7sttzRQtT8D0I2"
	}

- Os dados de acesso de outros usuários poderão ser visualizados no endpoint '/user/all'

- Ficou pendente controlar as authorities de USER e ADMIN, dessa forma todos os endpoint ainda estão acessíveis para qualquer requisição com token ;(

- Fico pendente os testes unitários

