Ot�vio Mota de Oliveira, de matricula 11218649

Caixeiro viajante -- Traveling salesman problem (TSP) Usando a Meta-heuristica Simulated Annealing (SA)

O TSP � um membro de uma classe de problemas conhecidos como Polinomial-Tempo N�o Determinista Completo
(NPC). Um grande n�mero de problemas importantes e pr�ticos s�o comprovados membros desta classe e s�o
Portanto, an�logo ao TSP, tendo solu��es que s�o transform�veis ??de e para solu��es para o
TSP em tempo polinomial. Os m�todos aplic�veis ??� solu��o de um membro desta classe s�o, portanto,
Interesse para toda a classe. � assumido que os problemas de NPC s� podem ser resolvidos em tempo exponencial, ent�o
Que ordens de magnitude t�picas s�o muitas vezes intrat�vel para solu��o em computadores atuais. Na pr�tica,
Solu��es sub�ptimas que ainda s�o "realmente boas" s�o muitas vezes suficientes, e nestes casos monte carlo
M�todos como SA e GA t�m demonstrado sucesso na gera��o de solu��es �teis, apesar do tamanho do
Problemas.
O TSP consiste em um conjunto de "cidades", ou pontos, com o objetivo de encontrar o caminho mais curto conectando
Sob uma determinada m�trica. A dificuldade deste problema � �bvia quando se percebe que uma n-cidade
Conjunto tem um espa�o de pesquisa de (n-1) !. Tal como acontece com muitos desses problemas, existem heur�sticas especializadas
Algoritmos que foram aplicados ao TSP com excelentes resultados. No entanto, nenhuma tentativa ser� feita
Aqui para usar nosso conhecimento espec�fico do problema para melhorar os algoritmos - o presente interesse �
Somente em usar o TSP como um problema "duro" caracter�stico na esperan�a de que os resultados possam ser similares para
Outros problemas que n�o s�o t�o bem compreendidos ou estudados, mas que, no entanto, precisam de solu��o.

Para implementar tem 2 pontos fundamentais :


Espa�o de estado: Para cada caso do TSP, temos um conjunto de cidades. Assim, o espa�o de pesquisa �
Naturalmente divididos em estados que consistem em ordens �nicas dessas cidades. O custo de
Cada estado � o comprimento de um caminho pelas cidades nessa ordem. O objetivo � encontrar um estado com
Poss�vel.


Temperatura: A chave para a capacidade da SA de encontrar otimiza��es globais e o que a diferencia de
Algoritmos de escalada simples, � que em cada itera��o tem uma probabilidade (decrescente) de
Estados menos aptos.

Para executar o arquivo teste segue o padrao :

Numero par de cidades, sendo que os numeros � o par ordenado.

EXEMPLO : Cidade1(12,51) , Cidade2(13,51) , Cidade 3(231,75)

12 51 13 51 231 75