ram 100 59
ram 101 1
ram 103 0
cseg
org Inicio          //Inicio

lda ac, 100         //Carrega 59 no acumulador 
str 102, ac         //Coloca no endereco 102, o que ta no acumulador   102 -> 59

    org minutos         
    lda ac, 102         //AC=59
    str 4092, ac        //M[4092]=59
    sub ac, 101         //AC = AC - 1
    str 102, ac         //M[102] = 58
    lda ac, 100         //AC = 59

        org segundos
        str 4093, ac        //M[4093]=59
        sub ac, 101         //AC = AC - 1
        jge segundos        //JUMP if GREATER or EQUALS

    lda ac, 102         //AC = 58   
    sub ac, 103         //AC = AC - 0
    jge minutos

jmp Inicio