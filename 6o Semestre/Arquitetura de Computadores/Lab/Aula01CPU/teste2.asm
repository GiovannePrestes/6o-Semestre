//região de dados

ram 500 25 //guarda na ram, o valor 25 no endereço 500

//regiao de instruções

cseg            //marca o inicio do segmento do código
org inicio 0    //determina que a instrução após o org está no endereço 0
lda ac, 500     //AC = M[500]
str 4092, ac    //M[4092] = AC (display linha 1)
lda ac, 4094    //AC = M[4094] (chaves)
str 4093, ac    //M[4093] = AC (display linha 2)
jmp inicio      //PC = inicio -> PC = 0, retorna para o início do programa