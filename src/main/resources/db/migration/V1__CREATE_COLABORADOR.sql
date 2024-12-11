CREATE TABLE tb_colaboradores
(
    id_colaborador  UUID                 NOT NULL,
    nome            VARCHAR(100)         NOT NULL,
    cpf             VARCHAR(11)          NOT NULL,
    rg              VARCHAR(9)           NOT NULL,
    data_nascimento date                 NOT NULL,
    email           VARCHAR(100)         NOT NULL,
    telefone        varchar(100)         not null,
    ativo           boolean default true not null,
    CONSTRAINT pk_tb_colaboradores PRIMARY KEY (id_colaborador),
    constraint idx_colaborador_cpf_unq unique (cpf),
    constraint idx_colaborador_rg_unq unique (rg),
    constraint idx_colaborador_email_unq unique (rg)
);


comment on table tb_colaboradores is 'Tabela para armazenar a relação dos colaboradores';
comment on column tb_colaboradores.id_colaborador is 'Identificador do colaborador';
comment on column tb_colaboradores.nome is 'Nome do Colaborador';
comment on column tb_colaboradores.cpf is 'CPF do Colaborador';
comment on column tb_colaboradores.rg is 'RG do Colaborador';
comment on column tb_colaboradores.data_nascimento is 'Data de nascimento do colaboradores';
comment on column tb_colaboradores.email is 'E-mail do colaborador';
comment on column tb_colaboradores.telefone is 'Telefone do Colaborador';
comment on column tb_colaboradores.ativo is 'Indica se o Colaborador esta ativo';
