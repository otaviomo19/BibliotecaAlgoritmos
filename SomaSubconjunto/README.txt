O problema da soma dos subconjuntos é descobrir com o conjuto que foi dado se somando entre eles é possivel
chegar ao valor desejado( a soma ).
Existem várias maneiras de resolver soma subconjunto no tempo exponencial em N . O mais algoritmo ingênuo seria para
 percorrer todos os subconjuntos de N números e, para cada um deles, verificar se as somas de subconjunto para o número certo. 
O tempo de execução é da ordem de O (2 N N ), uma vez que existem 2 N subconjuntos e, para verificar cada subconjunto, precisamos 
somar na maioria dos N elementos. Tempo complexidade da solução acima é O (soma * N).




********** PARA EXECUTAR *********
O PADRAO DA ENTRADA É -  Tamanho do Conjunto, SOMA DESEJADA , { O CONJUNTO } 


EX : 4 13 54 60 99 10