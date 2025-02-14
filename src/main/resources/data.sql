create schema if not exists cadastro;

use cadastro;

create table if not exists cadastro.tb_pessoa (
  id int auto_increment primary key,
  nome varchar(200) not null,
  sexo char(1) not null check (sexo in ('F', 'M', 'O')),
  cpf varchar(11) not null,
  email varchar(200) not null,
  celular varchar(11),
  constraint uk_cpf unique (cpf),
  constraint uk_email unique (email)
);

insert into cadastro.tb_pessoa (nome, sexo, cpf, email, celular)
values
  ('João', 'M', '12345678901', 'joao@example.com', '9999999999'),
  ('Maria', 'F', '98765432109', 'maria@example.com', '8888888888');