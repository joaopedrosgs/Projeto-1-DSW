create table if not exists Usuario
(
    id    integer primary key,
    email varchar(256) not null unique,
    senha varchar(256) not null,
    admin boolean default false
);

create table if not exists SiteVendas
(
    id       integer      not null unique,
    url      varchar(256) not null,
    nome     varchar(256) not null,
    telefone varchar(11)  not null,
    foreign key (id) references Usuario (id) on delete cascade
);

create table if not exists Teatro
(
    id     integer      not null unique,
    cnpj   varchar(14)  not null unique,
    nome   varchar(256) not null,
    cidade varchar(256) not null,
    foreign key (id) references Usuario (id) on delete cascade
);

create table if not exists Promocao
(
    id          integer primary key,
    site_id     integer      not null,
    teatro_id   integer      not null,
    nome        varchar(256) not null,
    preco       real         not null,
    dia_horario integer      not null,
    foreign key (site_id) references SiteVendas (id) on delete cascade,
    foreign key (teatro_id) references Teatro (id) on delete cascade,
    unique (site_id, dia_horario),
    unique (teatro_id, dia_horario)
);

