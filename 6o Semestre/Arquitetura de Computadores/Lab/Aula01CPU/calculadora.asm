ram 4000 0   //soma
ram 4001 1   //subtração
ram 4002 2   //multiplicação
ram 4003 3   //divisão

cseg
org Inicio
lda ac, 4094    //pegar operando
str 4004, ac     //M[104] -> operando (+,-,*,/)
str 4092, ac
lda ac, 4094    //pegar operador 1
str 4005, ac     //M[105] -> operador 1
str 4092, ac
lda ac, 4094    //pegar operador 2
str 4006, ac     //M[105] -> operador 2
str 4093, ac

lda ac, 4004
sub ac, 4000
je Soma
lda ac, 4004
sub ac, 4001
je Sub
lda ac, 4004
sub ac, 4002
je Mult
lda ac, 4004
sub ac, 4003
je Div
jmp Inicio

/////////////////////////////////////////////////////////////////////SOMA/////////////////////////////////////////////////////////////////////

org Soma
lda ac, 4005
add ac, 4006
jmp Fim

org Sub
lda ac, 4005
sub ac, 4006
jmp Fim

/////////////////////////////////////////////////////////////////////MULTIPLICAÇÃO/////////////////////////////////////////////////////////////////////

org Mult
lda ac, 4005         //lendo x
str 4100, ac         // aux = x
//Inicio verificação num = 0
lda ac, 4005
sub ac, 4000
je Fim
lda ac, 4006
sub ac, 4000
je Fim
//Fim verificação num = 0
jmp InicioMult      //começa for

org InicioMult
lda ac, 4006         //AC = y
sub ac, 4001         //AC = y-1
str 4006, ac         //y = AC
je FimMult          //Jump se y=1
lda ac, 4005         //AC = x
add ac, 4100         //AC = x + aux
str 4005, ac         //x = AC
jmp InicioMult

org FimMult
lda ac, 4005         //AC = x
jmp Fim

/////////////////////////////////////////////////////////////////////DIVISÃO/////////////////////////////////////////////////////////////////////

org Div
jmp Fim

/////////////////////////////////////////////////////////////////////FIM/////////////////////////////////////////////////////////////////////
//RESULTADO VAI NO DISPLAY DE CIMA E O DISPLAY DE BAIXO FICA = 0
org Fim
str 4092, ac
lda ac, 4000
str 4093, ac
hlt
/////////////////////////////////////////////////////////////////////ERROS/////////////////////////////////////////////////////////////////////

//SE DER OVERFLOW O DISPLAY DE BAIXO FICARÁ = 1
org Overflow
str 4092, ac
lda ac, 4001
str 4093, ac
hlt
//SE A DIVISAO FOR POR ZERO DISPLAY DE BAIXO FICARÁ = 2
org DivZero
str 4092, ac
lda ac, 4002
str 4093, ac
hlt