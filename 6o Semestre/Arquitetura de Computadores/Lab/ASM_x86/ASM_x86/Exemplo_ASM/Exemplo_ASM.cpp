// Exemplo_ASM.cpp : Este arquivo contém a função 'main'. A execução do programa começa e termina ali.
//

#include "pch.h"
#include <iostream>

void Exemplo1(void);
void Exemplo2(void);
void Exemplo3(void);
void Exemplo4(void);
void Exemplo5(void);

int main()
{
    std::cout << "Hello World!\n";

	Exemplo1();
	Exemplo2();
	Exemplo3();
	Exemplo4();
	Exemplo5();
	Soma();
	Subtracao();
	Multiplicacao();
	Divisao();
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

void Soma(void)
{
	int A = 10;
	int B = 15;
	int R;
	__asm {
		mov eax, [A] //EAX=A
		add eax, [B] //EAX=A+B
		mov [R], eax //R=EAX
	}
}

void Subtracao(void)
{
	int A = 10;
	int B = 1;
	int R;
	__asm {
		mov eax, [A] //EAX=A
		sub eax, [B] //EAX=A-B
		mov [R], eax //R=EAX
	}
}

void Multiplicacao(void)
{
	int A = 3;
	int B = 8;
	int R;
	__asm {
		mov eax, [A] //EAX=A
		mul eax, [B] //EAX=A*B
		mov [R], eax //R=EAX
	}
}

void Divisao(void)
{
	int A = 20;
	int B = 10;
	int R;
	__asm {
		mov eax, [A] //EAX=A
		idiv eax, [B] //EAX=A/B
		mov [R], eax //R=EAX
	}
}






// Executar programa: Ctrl + F5 ou Menu Depurar > Iniciar Sem Depuração
// Depurar programa: F5 ou menu Depurar > Iniciar Depuração

// Dicas para Começar: 
//   1. Use a janela do Gerenciador de Soluções para adicionar/gerenciar arquivos
//   2. Use a janela do Team Explorer para conectar-se ao controle do código-fonte
//   3. Use a janela de Saída para ver mensagens de saída do build e outras mensagens
//   4. Use a janela Lista de Erros para exibir erros
//   5. Ir Para o Projeto > Adicionar Novo Item para criar novos arquivos de código, ou Projeto > Adicionar Item Existente para adicionar arquivos de código existentes ao projeto
//   6. No futuro, para abrir este projeto novamente, vá para Arquivo > Abrir > Projeto e selecione o arquivo. sln
