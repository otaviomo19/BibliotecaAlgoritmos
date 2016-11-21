Ot�vio Mota de Oliveira, de matricula 11218649

Caixeiro viajante -- Traveling salesman problem (TSP) Usando a Meta-heuristica Simulated Annealing (SA)

O TSP e um membro de uma classe de problemas conhecidos como Polinomial-Tempo Nao Determinista Completo
(NPC). Um grande numero de problemas importantes e praticos sao comprovados membros desta classe e s�o
Portanto, analogo ao TSP, tendo solucoes que sao transformaveis ??de e para solu��es para o
TSP em tempo polinomial. Os m�todos aplic�veis ??a solu��o de um membro desta classe sao, portanto,
Interesse para toda a classe. � assumido que os problemas de NPC s� podem ser resolvidos em tempo exponencial, ent�o
Que ordens de magnitude tipicas sao muitas vezes intratavel para solu��o em computadores atuais. Na pratica,
Solucoes subotimas que ainda sao "realmente boas" sao muitas vezes suficientes
Metodos como SA e GA tem demonstrado sucesso na geracao de solu��es uteis, apesar do tamanho do
Problemas.
O TSP consiste em um conjunto de "cidades", ou pontos, com o objetivo de encontrar o caminho mais curto conectando
Sob uma determinada m�trica. A dificuldade deste problema e quando se percebe que uma n-cidade
Conjunto tem um espa�o de pesquisa de (n-1) !. Tal como acontece com muitos desses problemas, existem heuristicas especializadas
Algoritmos que foram aplicados ao TSP com excelentes resultados. No entanto, nenhuma tentativa ser� feita
Aqui para usar nosso conhecimento especifico do problema para melhorar os algoritmos - o presente interesse �
Somente em usar o TSP como um problema "duro" caracteristico na esperanca de que os resultados possam ser similares para
Outros problemas que nao sao tao bem compreendidos ou estudados, mas que, no entanto, precisam de solucao.

Para implementar tem 2 pontos fundamentais :


Espaco de estado: Para cada caso do TSP, temos um conjunto de cidades. Assim, o espa�o de pesquisa e
Naturalmente divididos em estados que consistem em ordens unicas dessas cidades. O custo de
Cada estado e o comprimento de um caminho pelas cidades nessa ordem. O objetivo e encontrar um estado com
Possevel.


Temperatura: A chave para a capacidade da SA de encontrar otimizacoes globais e o que a diferencia de
Algoritmos de escalada simples, e que em cada iteracao tem uma probabilidade (decrescente) de
Estados menos aptos.

Para executar o arquivo teste segue o padrao :

Numero par de cidades, sendo que os numeros � o par ordenado.

EXEMPLO : Cidade1(12,51) , Cidade2(13,51) , Cidade 3(231,75)

12 51 13 51 231 75