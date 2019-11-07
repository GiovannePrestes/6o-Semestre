//comecar codigo
cseg
//comeca no endereco 0
org inicio 0
//load ac o valor do endereco 4094
lda ac, 4094
//store no endereco 4092 o que tem no ac
str 4092, ac 
//jump inicio
jmp inicio