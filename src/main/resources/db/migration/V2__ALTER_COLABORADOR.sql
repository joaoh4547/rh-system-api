alter table tb_colaboradores add COLUMN data_criacao date default now() not null;
alter table tb_colaboradores add COLUMN data_atualizacao date default now() not null;
comment on COLUMN tb_colaboradores.data_criacao IS 'Data de criação do colaborador';
comment on COLUMN tb_colaboradores.data_atualizacao IS 'Data da ultima atualização do colaborador';