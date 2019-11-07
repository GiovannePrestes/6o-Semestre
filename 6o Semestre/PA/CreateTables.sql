create table tb_Bloco (
	idBloco int primary key identity,
	nomeBloco varchar(1) not null
);

create table tb_Setor(
	idSetor int primary key identity,
	nomeSetor varchar(30) not null,
	idBloco int not null
);

create table tb_Tipo (
	idTipo int primary key identity,
	descricaoTipo varchar(20) not null
);

create table tb_Estado(
	idEstado int primary key identity,
	descricaoEstado varchar(20) not null
);

create table tb_Item (
	idItem int primary key identity,
	idSetor int not null,
	idTipo int not null,
	idEstado int not null,
	patrimonio decimal(7,0) not null,
	serviceTag varchar(10) not null,
	descricao varchar(200) not null,
	dataCriacao datetime not null
);

create table tb_Encerramento(
	idEncerramento int primary key identity,
	idItem int not null,
	dataEncerramento datetime not null,
	motivo varchar(200) not null
);


alter table tb_Setor
add foreign key (idBloco) references tb_Bloco(idBloco);

alter table tb_Item
add foreign key (idTipo) references tb_Tipo(idTipo);
alter table tb_Item
add foreign key (idEstado) references tb_Estado(idEstado);
alter table tb_Item
add foreign key (idSetor) references tb_Setor(idSetor);

alter table tb_Encerramento
add foreign key (idItem) references tb_Item(idItem);