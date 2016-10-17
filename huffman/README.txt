
A codificação de Huffman é um método de compactação que usa as probabilidades de
ocorrência dos símbolos no conjunto de dados a ser compactado para determinar códigos de
tamanho variável para cada símbolo.

O (n log n), onde n é o número de caracteres únicos. Se existirem n nós, extractMin () é chamado 2 * (n - 1) vezes. 
extractMin () leva tempo O (log n), uma vez que calles minHeapify (). 
Assim, a complexidade total é O (nlogn).

Huffman hoje é muitas vezes usado como um "back-end" para alguns outros métodos de compressão. 
DEFLATE ( PKZIP 's algoritmo) e multimédia codecs tais como JPEG e MP3 têm um modelo de front-end 
e quantização seguido por Huffman (ou Variável comprimento códigos livre de prefixo com uma estrutura 
semelhante, embora talvez não necessariamente projetados usando o algoritmo de Huffman.


 ********Para Execução******
O Padrão para entreda é : Tamanho da entrada - string de caracteres - frequencia dos caracters

EX : 8 12345678 36 18 12 9 7 6 5 4