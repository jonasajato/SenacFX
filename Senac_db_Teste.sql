create database Senac_db_Teste;

use Senac_db_Teste;

create table fabric(
id int(11) not null auto_increment primary key,
razao_social varchar(100),
endereco varchar(100),
bairro varchar(100),
cidade varchar(100),
estado varchar(2),
telefone varchar(100),
email varchar(100)
)Engine=InnoDB default charset=utf8;

create table distrib(
id int(11) not null auto_increment primary key,
razao_social varchar(100),
endereco varchar(100),
bairro varchar(100),
cidade varchar(100),
estado varchar(2),
telefone varchar(100),
email varchar(100)
)Engine=InnoDB default charset=utf8;

create table transport(
id int(11) not null auto_increment primary key,
razao_social varchar(100),
endereco varchar(100),
bairro varchar(100),
cidade varchar(100),
estado varchar(2),
telefone varchar(100),
email varchar(100)
)Engine=InnoDB default charset=utf8;

create table client(
id int(11) not null auto_increment primary key,
razao_social varchar(100),
endereco varchar(100),
bairro varchar(100),
cidade varchar(100),
estado varchar(2),
telefone varchar(100),
email varchar(100)
)Engine=InnoDB default charset=utf8;

insert into cliente values (null, 'Cliente 1', 'Endereço 1', 'Bairro 1', 'Cidade 1', 'SC', '4934330000', 'cliente@teste.com');
insert into fabrica values (null, 'Cliente 1', 'Endereço 1', 'Bairro 1', 'Cidade 1', 'SC', '4934330000', 'cliente@teste.com');
insert into distribuidora values (null, 'Cliente 1', 'Endereço 1', 'Bairro 1', 'Cidade 1', 'SC', '4934330000', 'cliente@teste.com');
insert into transportadora values (null, 'Cliente 1', 'Endereço 1', 'Bairro 1', 'Cidade 1', 'SC', '4934330000', 'cliente@teste.com');

create table fabrica(
id int(11) not null auto_increment primary key,
razao_social varchar(100),
endereco varchar(100),
bairro varchar(100),
cidade varchar(100),
estado varchar(2),
telefone varchar(100),
email varchar(100)
)Engine=InnoDB default charset=utf8;

create table distribuidora(
id int(11) not null auto_increment primary key,
razao_social varchar(100),
endereco varchar(100),
bairro varchar(100),
cidade varchar(100),
estado varchar(2),
telefone varchar(100),
email varchar(100)
)Engine=InnoDB default charset=utf8;

create table transportadora(
id int(11) not null auto_increment primary key,
razao_social varchar(100),
endereco varchar(100),
bairro varchar(100),
cidade varchar(100),
estado varchar(2),
telefone varchar(100),
email varchar(100)
)Engine=InnoDB default charset=utf8;

create table cliente(
id int(11) not null auto_increment primary key,
razao_social varchar(100),
endereco varchar(100),
bairro varchar(100),
cidade varchar(100),
estado varchar(2),
telefone varchar(100),
email varchar(100)
)Engine=InnoDB default charset=utf8;