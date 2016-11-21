Otávio Mota de Oliveira, de matricula 11218649

Caixeiro viajante -- Traveling salesman problem (TSP) Usando a Meta-heuristica Simulated Annealing (SA)

O TSP é um membro de uma classe de problemas conhecidos como Polinomial-Tempo Não Determinista Completo
(NPC). Um grande número de problemas importantes e práticos são comprovados membros desta classe e são
Portanto, análogo ao TSP, tendo soluções que são transformáveis ??de e para soluções para o
TSP em tempo polinomial. Os métodos aplicáveis ??à solução de um membro desta classe são, portanto,
Interesse para toda a classe. É assumido que os problemas de NPC só podem ser resolvidos em tempo exponencial, então
Que ordens de magnitude típicas são muitas vezes intratável para solução em computadores atuais. Na prática,
Soluções subóptimas que ainda são "realmente boas" são muitas vezes suficientes, e nestes casos monte carlo
Métodos como SA e GA têm demonstrado sucesso na geração de soluções úteis, apesar do tamanho do
Problemas.
O TSP consiste em um conjunto de "cidades", ou pontos, com o objetivo de encontrar o caminho mais curto conectando
Sob uma determinada métrica. A dificuldade deste problema é óbvia quando se percebe que uma n-cidade
Conjunto tem um espaço de pesquisa de (n-1) !. Tal como acontece com muitos desses problemas, existem heurísticas especializadas
Algoritmos que foram aplicados ao TSP com excelentes resultados. No entanto, nenhuma tentativa será feita
Aqui para usar nosso conhecimento específico do problema para melhorar os algoritmos - o presente interesse é
Somente em usar o TSP como um problema "duro" característico na esperança de que os resultados possam ser similares para
Outros problemas que não são tão bem compreendidos ou estudados, mas que, no entanto, precisam de solução.

Para implementar tem 2 pontos fundamentais :


Espaço de estado: Para cada caso do TSP, temos um conjunto de cidades. Assim, o espaço de pesquisa é
Naturalmente divididos em estados que consistem em ordens únicas dessas cidades. O custo de
Cada estado é o comprimento de um caminho pelas cidades nessa ordem. O objetivo é encontrar um estado com
Possível.


Temperatura: A chave para a capacidade da SA de encontrar otimizações globais e o que a diferencia de
Algoritmos de escalada simples, é que em cada iteração tem uma probabilidade (decrescente) de
Estados menos aptos.

Para executar o arquivo teste segue o padrao :

Numero par de cidades, sendo que os numeros é o par ordenado.

EXEMPLO : Cidade1(12,51) , Cidade2(13,51) , Cidade 3(231,75)

12 51 13 51 231 75