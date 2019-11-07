ram 100 59
ram 101 1
ram 103 0
cseg
org Inicio          //Inicio

lda ac, 103         //Carrega 0 no acumulador 
str 102, ac         //Coloca no endereco 102, o que ta no acumulador   102 -> 0

    org minutos         
    lda ac, 102         //AC=0
    str 4092, ac        //M[4092]=0
    add ac, 101         //AC = AC + 1
    str 102, ac         //M[102] = 1
    lda ac, 103         //AC = 0
    str 104, ac         //M[104] = 0

        org segundos
        lda ac, 104         //AC = 0
        str 4093, ac        //M[4093] = 0
        add ac, 101         //AC = AC + 1
        str 104, ac         //M[104] = 1
        sub ac, 100         //AC = AC - 59
        jle segundos        //JUMP if LOWER or EQUALS

    lda ac, 102         //AC = 1   
    sub ac, 100         //AC = AC - 59
    jle minutos

jmp Inicio