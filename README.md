# idwall

Para realizar o teste, criei uma api com duas url de chamada, uma para cada parte do desafio.
A primeira retorna o texto sem  justificar, e a segunda retorna o texto justificado:
http://localhost:8080/string/refactor
http://localhost:8080/string/refactor/justified


Na resolução para parte 1 foi até simples, realizei a leitura da string de imput e fui quebrando após a contagem de caracteres desejada.
Porém na segunda parte fiquei meio na dúvida de utilizar algumas funções que a própria classe String e StringBuilder fornece pois em alguns casos de testes não retornou o resultado esperado, então acabei criando um arquivo txt trantando o texto para ficar justificado pelo java e retornando o resultado após a leitura do arquivo.

Para utilizar a solução basta chamar o endereço, tomei a liberdade de deixar parâmetrizado o tamnho limite e o texto, porém caso faça a chamado sem parâmetro deixei padrão o valor de 40 para limite de caracter que é o solicitado no desafio e também o seguinte texto como padrão:
"In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.
And God said, “Let there be light,” and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light “day,” and the darkness he called “night.” And there was evening, and there was morning - the first day."
Então a chamada funcionará sem parâmetro também.

**Extra** 

Também realizei a configuração do Swagger para documentação, então poderá ser utilizado também para fazer o teste da solução
http://localhost:8080/swagger-ui.html

Também sub um ambiente no elasticBeanStalk para fazer um teste com o docker, vou deixar aberto até até a data combinada com a recrutadora para finalizar o teste, caso queiram utilizar:
[http://idwallapi.us-east-1.elasticbeanstalk.com/swagger-ui.html](http://idwallapi.us-east-1.elasticbeanstalk.com/swagger-ui.html)


Deixei o arquivo _docker-compose.yml_  na raiz da pasta caso queria utilizar basta ter o docker instalado e executar _docker-compose up idwall-api_ para subir o projeto

Desde de já agradeço a oportunidade e mesmo que não seja selecionado para avançar gostaria de receber o feedback para eu melhorar no meu desenvolvimento!
