ram 200 1
ram 300 0

cseg
org Inicio
lda ac, 300
add ac, 200
str 300, ac
str 4092, ac
jmp Inicio