CREATE TABLE SiteVendas (
  id integer primary key,
  email varchar(256) not null unique,
  senha varchar(256) not null,
  url varchar(256) not null,
  nome varchar(256) not null,
  telefone varchar(11) not null
);

CREATE TABLE Usuario (
    id integer primary key,
    email varchar(256) not null unique,
    senha varchar(256) not null
);