
A codifica��o de Huffman � um m�todo de compacta��o que usa as probabilidades de
ocorr�ncia dos s�mbolos no conjunto de dados a ser compactado para determinar c�digos de
tamanho vari�vel para cada s�mbolo.

O (n log n), onde n � o n�mero de caracteres �nicos. Se existirem n n�s, extractMin () � chamado 2 * (n - 1) vezes. 
extractMin () leva tempo O (log n), uma vez que calles minHeapify (). 
Assim, a complexidade total � O (nlogn).

Huffman hoje � muitas vezes usado como um "back-end" para alguns outros m�todos de compress�o. 
DEFLATE ( PKZIP 's algoritmo) e multim�dia codecs tais como JPEG e MP3 t�m um modelo de front-end 
e quantiza��o seguido por Huffman (ou Vari�vel comprimento c�digos livre de prefixo com uma estrutura 
semelhante, embora talvez n�o necessariamente projetados usando o algoritmo de Huffman.


 ********Para Execu��o******
O Padr�o para entreda � : Tamanho da entrada - string de caracteres - frequencia dos caracters

EX : 8 12345678 36 18 12 9 7 6 5 4