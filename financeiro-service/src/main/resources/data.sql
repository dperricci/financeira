insert into CATEGORIA (id, descricao) values (1, 'MORADIA');
insert into CATEGORIA (id, descricao) values (2, 'LAZER');
insert into CATEGORIA (id, descricao) values (3, 'TRANSPORTE');
insert into CATEGORIA (id, descricao) values (4, 'SAUDE');
insert into CATEGORIA (id, descricao) values (5, 'EDUCACAO');
insert into CATEGORIA (id, descricao) values (6, 'OUTROS');

insert into SUB_CATEGORIA (id, descricao, categoria_id) values (1, 'LUZ', 1);
insert into SUB_CATEGORIA (id, descricao, categoria_id) values (2, 'GAS', 1);
insert into SUB_CATEGORIA (id, descricao, categoria_id) values (3, 'CONDOMINIO', 1);
insert into SUB_CATEGORIA (id, descricao, categoria_id) values (4, 'TV', 1);
insert into SUB_CATEGORIA (id, descricao, categoria_id) values (5, 'INTERNET', 1);
insert into SUB_CATEGORIA (id, descricao, categoria_id) values (6, 'TELEFONE', 1);

insert into SUB_CATEGORIA (id, descricao, categoria_id) values (7, 'CINEMA', 2);
insert into SUB_CATEGORIA (id, descricao, categoria_id) values (8, 'JOGOS', 2);
insert into SUB_CATEGORIA (id, descricao, categoria_id) values (9, 'SHOPPING', 2);
insert into SUB_CATEGORIA (id, descricao, categoria_id) values (10, 'RESTAURANTE', 2);

insert into SUB_CATEGORIA (id, descricao, categoria_id) values (11, 'BILHETE UNICO', 3);

insert into SUB_CATEGORIA (id, descricao, categoria_id) values (12, 'FARMACIA', 4);
insert into SUB_CATEGORIA (id, descricao, categoria_id) values (13, 'MEDICO', 4);

insert into SUB_CATEGORIA (id, descricao, categoria_id) values (14, 'ESCOLA', 5);
insert into SUB_CATEGORIA (id, descricao, categoria_id) values (15, 'LIVRO', 5);
insert into SUB_CATEGORIA (id, descricao, categoria_id) values (16, 'CURSO', 5);
