// Exemplo_ASM.cpp : Este arquivo contém a função 'main'. A execução do programa começa e termina ali.
//

#include "pch.h"
#include <iostream>

void Exemplo1(void);
void Exemplo2(void);
void Exemplo3(void);
void Exemplo4(void);
void Exemplo5(void);
void Relogio(void);
void Delta(void);
void Facens(void);
void Maior(void);
void Exercicio1(void);
void Exercicio2(void);
void Exercicio3(void);

int main()
{
    std::cout << "Hello World!\n";

	//Exemplo1();
	//Exemplo2();
	//Exemplo3();
	//Exemplo4();
	//Exemplo5();
	//Relogio();
	//Delta();
	//Facens();
	//Maior();
	//Exercicio1();
	//Exercicio2();
	Exercicio3();
}

void Exemplo1(void)
{
	int var1 = 10;

	//Movimentação de dados
	__asm {
		//para registradores
		mov eax, 2 //EAX=2
		mov eax, [var1] //EAX=var1

		//para endereços de memória
		mov[var1], 2 //var1=2
		mov[var1], eax //var1=EAX
	}
}
void Exemplo2(void)
{
	int A = 26;
	int B = 5;
	int R;

	//Operações Aritméticas
	__asm {
		mov eax, [A] //EAX=A
		add eax, [B] //EAX=A+B
		mov[R], eax  //R=EAX

		mov eax, [A] //EAX=A
		sub eax, [B] //EAX=A-B
		mov[R], eax  //R=EAX

		//Multiplicação de EAX por um registrador ou variável
		mov eax, [A] //EAX=A
		mul[B] //EAX=A+B
		mov[R], eax  //R=EAX

		//Divide EDX:EAX por um registrador ou variável
		mov edx, 0
		mov eax, [A] //EAX=A
		idiv[B] //EAX =A/B
		mov[R], EAX //resultado está em EAX e o resto em EDX
	}
}
void Exemplo3(void)
{
	int vetor[] = { 10,20,30,40,50 };

	__asm {
		mov eax, [vetor + 0]
		mov eax, [vetor + 4]
		mov eax, [vetor + 8]
		mov eax, [vetor + 12]
		mov eax, [vetor + 16]

		mov esi, 0 //índice = 0
		mov eax, [vetor + esi * 4]

		inc esi  //índice = 1
		mov eax, [vetor + esi * 4]

		inc esi  //índice = 2
		mov eax, [vetor + esi * 4]
	}
}
void Exemplo4(void)
{
	__asm {
		mov ecx, 0 //contador = 0
		mov eax, 0
		//enquando contador < 5
		loop_while:
		//procedimento executado
		add eax, 5

			//controle de execução do laço
			inc ecx
			cmp ecx, 5
			jl loop_while

	}
}
void Exemplo5(void) {

	char str_format[] = "Valor = %i";
	int valor = 10;

	//chamada de função
	__asm {

		//printf para string de exemplo tem dois parâmetros
		//print("Valor = %i", valor);

		//1° passo: Informar os valor da direita para esquerda na chamada da função usando a instrução PUSH
		push[valor]
		lea eax, str_format //endereço da string
		push eax

		//2° passo: chamar a função com a instrução CALL
		call Exemplo1

		//3° passo: retornar o valor esp -> Para cada push some 4
		add esp, 8
	}
}
void Relogio(void) {
	int minutos = 0;
	int segundos;

	__asm {
		loop_minutos:
			mov ecx, 0
			mov segundos, 0
			loop_segundos:
				add segundos, 1
				inc ecx
				cmp ecx,59
				jl loop_segundos
			add minutos, 1
			cmp minutos, 59
			jl loop_minutos
	}
	Relogio();
}
void Delta(void) {
	int A = 1;
	int B = 4;
	int C = 3;
	int R;

	__asm {
		mov eax, [B]
		mul[B]
		mov [R], eax

		mov eax, [A]
		mul [C]
		mov [A], eax
		mov [C], 4
		mov eax, [A]
		mul [C]
		mov [A], eax

		mov eax, [R]
		sub eax, [A]
		mov [R], eax

	}
}
void Facens(void) {
	char str1[7] = "FACENS";
	char str2[7];

	__asm {
		mov esi, 0
		loop_contador:
			mov eax, esi
			mov ecx, esi
			mov dl, BYTE PTR [str1 + ecx]
			mov BYTE PTR [str2 + eax], dl

			inc esi
			cmp esi, 6
			jl loop_contador
	}
}
void Maior(void) {
	int v[10] = { 3, 153, 4, 7, 12, 20, 133, 11, 9, 144 }, maior, indice = 4, inteiro = 4, cont = 0;

	__asm {
		mov eax, DWORD PTR[v]
		mov[maior], eax

		INICIO :
			mov ecx, indice
			mov eax, [maior]
			cmp eax, DWORD PTR[v + ecx]
			jl MAIORTRUE
			jg MAIORFALSE

		MAIORTRUE :
			mov eax, DWORD PTR[v + ecx]
			mov[maior], eax
		MAIORFALSE :
			mov ecx, [indice]
			add ecx, [inteiro]
			mov[indice], ecx
			inc cont
			cmp cont, 10
			jl INICIO
			jmp FIM

		FIM :

	}
}
void Exercicio1(void) {
	int lista[] = { 1,2,3,4,2,1 };
	int valor = 1;
	int cont = 0;

	__asm {
		mov ecx, 0
		START:
		mov eax, DWORD PTR[lista + ecx * 4]
			cmp eax, valor
			je FIND
			inc ecx
			cmp ecx, 6
			jg END
			jmp START

			FIND :
		inc cont
			inc ecx
			jmp START

			END :
	}
}
// valor aparece x vezes
void Exercicio2(void) {
	char string1[] = "teste\0";
	char string2[] = "abcde\0";
	bool result = true;

	__asm {
		mov ecx, 0
		START:
			mov eax, DWORD PTR[string1 + ecx]
			cmp eax, DWORD PTR[string2 + ecx]
			je FIND
			mov result, 0
			jmp END

		FIND:
			inc ecx
			cmp ecx, 6
			jg END
			jmp START

		END:
	}
}
// teste string
void Exercicio3(void) {
	int lista[] = { 20,15,10,18,5,7 };

	__asm {
	}
}
// ordem crescente ----- INCOMPLETO