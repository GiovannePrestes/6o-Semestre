-----------------------BLOCOS---------------------
insert into tb_Bloco values ('A');--1--
insert into tb_Bloco values ('B');--2--
insert into tb_Bloco values ('C');--3--
insert into tb_Bloco values ('D');--4--
insert into tb_Bloco values ('E');--5--
insert into tb_Bloco values ('F');--6--
insert into tb_Bloco values ('G');--7--
insert into tb_Bloco values ('H');--8--
insert into tb_Bloco values ('I');--9--
insert into tb_Bloco values ('J');--10--
insert into tb_Bloco values ('K');--11--
insert into tb_Bloco values ('L');--12--

select * from tb_Bloco

-----------------------SETOR---------------------
insert into tb_Setor values ('Laboratorio de Informatica', 1);	--1--
insert into tb_Setor values ('LIS', 1);							--2--
insert into tb_Setor values ('Industria 4.0', 12);				--3--
insert into tb_Setor values ('FabLab', 3);						--4--
insert into tb_Setor values ('BIM', 9);							--5--
 
select * from tb_Setor

-----------------------TIPO---------------------
insert into tb_Tipo values ('Monitor');		--1--
insert into tb_Tipo values ('CPU');			--2--
insert into tb_Tipo values ('Notebook');	--3--

select * from tb_Tipo

-----------------------ESTADO---------------------
insert into tb_Estado values ('Ativo');		--1--
insert into tb_Estado values ('Doado');		--2--
insert into tb_Estado values ('Perdido');	--3--

select * from tb_Estado

-----------------------ITEM---------------------
insert into tb_Item values (1, 2, 1, 10511, '7Y1PSP1', 'DELL OPTIPLEX 980', GETDATE()); --1--
insert into tb_Item values (1, 2, 1, 10531, '7YLL9P1', 'DELL OPTIPLEX 980', GETDATE()); --2--

select * from tb_Item

-----------------------ENCERRAMENTO---------------------
insert into tb_Encerramento values (1, GETDATE(), 'Maquina sem patrimonio');

select * from tb_Encerramento
