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
    CONSTRAINT state_pkey PRIMARY KEY (codigo)
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
CREATE TABLE public.arctifact  
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
descrição varchar(120),
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
