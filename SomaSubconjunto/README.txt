O problema da soma dos subconjuntos � descobrir com o conjuto que foi dado se somando entre eles � possivel
chegar ao valor desejado( a soma ).
Existem v�rias maneiras de resolver soma subconjunto no tempo exponencial em N . O mais algoritmo ing�nuo seria para
 percorrer todos os subconjuntos de N n�meros e, para cada um deles, verificar se as somas de subconjunto para o n�mero certo. 
O tempo de execu��o � da ordem de O (2 N N ), uma vez que existem 2 N subconjuntos e, para verificar cada subconjunto, precisamos 
somar na maioria dos N elementos. Tempo complexidade da solu��o acima � O (soma * N).




********** PARA EXECUTAR *********
O PADRAO DA ENTRADA � -  Tamanho do Conjunto, SOMA DESEJADA , { O CONJUNTO } 


EX : 4 13 54 60 99 10