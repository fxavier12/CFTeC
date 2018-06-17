-- script para criacao de tabelas no banco de dados
--
--antes de cada tabela o nome do responsavel deve ser informado

--Responsavel: Alexandre L Erario
CREATE TABLE public.teste
(
    codigo integer NOT NULL,
    nome character varying(255),
    CONSTRAINT teste_pkey PRIMARY KEY (codigo)
);
-- As tabelas corretas devem ser criadas a partir daqui.
/*
-- Responsavel Sirnande dos Santos Lima
CREATE  TABLE  public.project (
    codigo integer NOT NULL,
    nome varchar(45), 
    descrição varchar(120),
    CONSTRAINT project_pkey PRIMARY KEY (codigo)
);

--Responsavel: Diego Vilella
CREATE TABLE public.message(
    codigo integer NOT NULL,
     CONSTRAINT mensage_pkey PRIMARY KEY (codigo)
);



-- Responsavel Danilo Missao Morita
create table public.host 
(
    codigo integer NOT NULL,
    Constraint host_pkey PRIMARY KEY (codigo)
);


-- Athos Castro Moreno

CREATE TABLE public.content
(
    codigo integer not null,
    tipo_mensagem text, -- campo estranho
    conteudo text, -- pode migrar para byte ou verificar no postgres
	--faltou chave estrangeira para Message
    constraint content_pkey primary key (codigo)
);

-- Responsavel Luis Othavio

CREATE TABLE public.estado
(
    codigo integer NOT NULL,
    nome varchar(255),
    CONSTRAINT estado_pkey PRIMARY KEY (codigo)
);

-- Responsavel Lucas Concato
CREATE TABLE public.city 
(
	codigo integer not null,
	nome varchar(255),
	codigo_estado integer not null,
	constraint city_pkey primary key (codigo),   	
    FOREIGN KEY (codigo_estado) REFERENCES public.estado (codigo)
  );

-- Responsavel Alex Jussiani
CREATE TABLE public.artifact  
(
	codigo integer not null,
	nome varchar(45) not null,
        descrição varchar(120),
        versao varchar(10) not null default '0.1',
        arquivo bytea not null,
        message_codigo integer not null,
	--faltou chave estrangeira para message.
	constraint artifact_pkey primary key (codigo),
	foreign key (message_codigo) references public.message (codigo)
);


--Responsavel: Gabriel Tobias
CREATE TABLE public.type
(
    codigo integer NOT NULL,
    descricao character varying(150), --ajuste de nome(ok)
    CONSTRAINT type_pkey PRIMARY KEY (codigo)
);

--Responsavel: Lais Macedo
CREATE TABLE public.adress
(
codigo INTEGER NOT NULL,
logradouro CHARACTER VARYING(255), --padronizar tamanho (ok)
	--chave estrangeira para collaborator
	--chave para postalcode
	--incluir campos: numero, referencia, descricao
CONSTRAINT adress_pkey PRIMARY KEY (codigo)
);

--Responsavel: Arcádio Macedo
CREATE TABLE public.postalcode
(
codigo INTEGER NOT NULL,
codigo_postal CHARACTER VARYING(100),
codigo_city integer not null,
codigo_type integer not null,
CONSTRAINT postalcode_pkey PRIMARY KEY (codigo),
FOREIGN KEY (codigo_city) REFERENCES public.city (codigo),
FOREIGN KEY (codigo_type) REFERENCES public.type (codigo)
);

--Responsavel: Francisco Xavier
CREATE TABLE public.purpose
(
codigo INTEGER NOT NULL,
nome varchar(45), 
descricao varchar(120),
CONSTRAINT purpose_pkey PRIMARY KEY (codigo)
);

--Responsavel: Tiago Pagotto
CREATE TABLE public.communit
(
	codigo INTEGER NOT NULL,
	codigo_purpose INTEGER,
	codigo_communit INTEGER,
	CONSTRAINT communit_pkey PRIMARY KEY (codigo),
	FOREIGN KEY (codigo_purpose) REFERENCES public.purpose (codigo),
	FOREIGN KEY (codigo_communit) REFERENCES public.communit (codigo)
);

--Responsavel: Felipe Sampaio
CREATE TABLE public.transmissao
(
    codigo integer NOT NULL,
    dt_hora date NOT NULL,
    CONSTRAINT transmissao_pkey PRIMARY KEY (codigo)
);

-- Responsavel: Glauco Yoshikazu Sazaka
CREATE TABLE public.collaborator
(
	codigo INTEGER NOT NULL,
	nome VARCHAR(255) NOT NULL,
	data_nascimento DATE NOT NULL,
	codigo_host INTEGER REFERENCES public.host (codigo), --verificar relacao
	codigo_adress INTEGER REFERENCES public.adress (codigo), --verificar relacao
	CONSTRAINT collaborator_pk PRIMARY KEY (codigo)
	-- colocar campo ativo (bool), verifica se o colaborador está ativo ou nao
	--c olocar campo email principal;
);

*/

    
    CREATE  TABLE  public.project (
    codigo integer NOT NULL,
    nome varchar(45), 
    descrição varchar(120),
    CONSTRAINT project_pkey PRIMARY KEY (codigo)
);


CREATE TABLE public.message(
    codigo integer NOT NULL,
     CONSTRAINT mensage_pkey PRIMARY KEY (codigo)
);



create table public.host 
(
    codigo integer NOT NULL,
    Constraint host_pkey PRIMARY KEY (codigo)
);

CREATE TABLE public.purpose
(
codigo INTEGER NOT NULL,
nome varchar(45), 
descricao varchar(120),
CONSTRAINT purpose_pkey PRIMARY KEY (codigo)
);


CREATE TABLE public.communit
(
	codigo INTEGER NOT NULL,
	codigo_purpose INTEGER,
	codigo_communit INTEGER,
	CONSTRAINT communit_pkey PRIMARY KEY (codigo),
	FOREIGN KEY (codigo_purpose) REFERENCES public.purpose (codigo),
	FOREIGN KEY (codigo_communit) REFERENCES public.communit (codigo)
);


CREATE TABLE public.transmissao
(
    codigo integer NOT NULL,
    dt_hora date NOT NULL,
    CONSTRAINT transmissao_pkey PRIMARY KEY (codigo)
);

CREATE TABLE public.estado
(
    codigo integer NOT NULL,
    nome varchar(255),
    CONSTRAINT estado_pkey PRIMARY KEY (codigo)
);


CREATE TABLE public.city 
(
	codigo integer not null,
	nome varchar(255),
	codigo_estado integer not null,
	constraint city_pkey primary key (codigo),   	
    FOREIGN KEY (codigo_estado) REFERENCES public.estado (codigo)
  );

CREATE TABLE public.type
(
    codigo integer NOT NULL,
    descricao character varying(150), --ajuste de nome(ok)
    CONSTRAINT type_pkey PRIMARY KEY (codigo)
);

CREATE TABLE public.postalcode
(
codigo INTEGER NOT NULL,
codigo_postal CHARACTER VARYING(100),
codigo_city integer not null,
codigo_type integer not null,
CONSTRAINT postalcode_pkey PRIMARY KEY (codigo),
FOREIGN KEY (codigo_city) REFERENCES public.city (codigo),
FOREIGN KEY (codigo_type) REFERENCES public.type (codigo)
);

CREATE TABLE public.collaborator
(
	codigo INTEGER NOT NULL,
	nome VARCHAR(255) NOT NULL,
	data_nascimento varchar(15) NOT NULL,
	CONSTRAINT collaborator_pk PRIMARY KEY (codigo),
    email varchar(255),
    collaborator_ativo boolean,
    codativacao varchar(8)
	
);
CREATE TABLE public.content
(
    codigo integer not null,
    tipo_mensagem text, -- campo estranho
    conteudo bytea, -- pode migrar para byte ou verificar no postgres
	--faltou chave estrangeira para Message
    codigo_message integer not null,
    constraint content_pkey primary key (codigo),
    FOREIGN KEY (codigo_message) REFERENCES public.message (codigo)
    
);

CREATE TABLE public.artifact  
(
	codigo serial,
	nome varchar(45) not null,
    descricao varchar(120),
    versao varchar(10) not null default '0.1',
    arquivo bytea not null,
	arquivo_type varchar(45) not null,
	arquivo_name varchar(45) not null,
    message_codigo integer not null,
	constraint artifact_pkey primary key (codigo),
	foreign key (message_codigo) references public.message (codigo)
);



CREATE TABLE public.adress
(
	codigo INTEGER NOT NULL,
	logradouro CHARACTER VARYING(255), --padronizar tamanho (ok)
    codigo_collaborator integer not null,
    codigo_postalcode integer,
    numero integer not null,
    referencia varchar (255),
    descricao varchar (255),
	--chave estrangeira para collaborator
	--chave para postalcode
	--incluir campos: numero, referencia, descricao
	CONSTRAINT adress_pkey PRIMARY KEY (codigo),
    FOREIGN KEY (codigo_collaborator) REFERENCES public.collaborator(codigo),
    FOREIGN KEY (codigo_postalcode) REFERENCES public.postalcode (codigo)
);




CREATE TABLE public.site 
(
	codigo integer not null,
    nome varchar(255),
    posicao point,
    observações text,
    codigo_project integer not null,
    CONSTRAINT site_pk PRIMARY KEY (codigo),
    FOREIGN KEY (codigo_project) REFERENCES public.project (codigo)
);

CREATE TABLE public.sitecolaborador
(
    codigo integer not null,
    codigo_colaborador integer not null,
    CONSTRAINT sitecolaborador_pk PRIMARY KEY (codigo),
    FOREIGN KEY (codigo_colaborador) REFERENCES public.collaborator(codigo)
    
);

CREATE TABLE public.hosttype 
(
    codigo integer not null,
    nome varchar (255),
    descricao text, 
    codigo_host integer not null,
    CONSTRAINT codigo_hosttype_pk PRIMARY KEY (codigo),
    FOREIGN KEY (codigo_host) REFERENCES public.host (codigo)
);

CREATE TABLE public.SEtool 
(
	codigo integer not null,
    nome varchar (255),
    descricao text,
    versao numeric(2,2),
    url text,
    codigo_host integer,
    CONSTRAINT codigo_SEtool_pk PRIMARY KEY (codigo),
    FOREIGN KEY (codigo_host) REFERENCES public.host (codigo)
);

CREATE TABLE public.configuracao 
(
	codigo integer not null,
    chave integer,
    parametro varchar (255),
    codigo_SEtool integer,
    CONSTRAINT codigo_configuracao_pk PRIMARY KEY (codigo),
    FOREIGN KEY (codigo_SEtool) REFERENCES public.type (codigo)
);

CREATE TABLE public.evaluation(
	codigo INTEGER NOT NULL,
	codigo_collaborator INTEGER NOT NULL,
	codigo_message INTEGER NOT NULL,
	data DATE,
	value real,
	CONSTRAINT evaluation_pk PRIMARY KEY (codigo),
	FOREIGN KEY (codigo_collaborator) REFERENCES public.collaborator (codigo),
	FOREIGN KEY (codigo_message) REFERENCES public.message (codigo)
);
