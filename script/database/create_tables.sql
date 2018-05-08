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
create table public.host (
    codigo integer NOT NULL,
    Constraint codigo_pkey PRIMARY KEY (codigo)
);


-- Athos Castro Moreno

CREATE TABLE public.content
(
    codigo integer not null,
    tipo_mensagem text,
    conteudo text,
    constraint content_pkey primary key (codigo)
);

-- Responsavel Luis Othavio

CREATE TABLE public.state
(
    codigo integer NOT NULL,
    nome varchar(255),
    CONSTRAINT state_pkey PRIMARY KEY (codigo)
);

-- Responsavel Lucas Concato
CREATE TABLE public.city 
(
	codigo integer not null,
	nome character varying(255),
	constraint city_pkey primary key (codigo)
);

-- Responsavel Alex Jussiani
CREATE TABLE public.arctifact  
(
	codigo integer not null,
	artefato character varying(200),
	constraint artifact_pkey primary key (codigo)
);

--Responsavel: Gabriel Tobias
CREATE TABLE public.type
(
    codigo integer NOT NULL,
    nome character varying(150),
    CONSTRAINT type_pkey PRIMARY KEY (codigo)
);

--Responsavel: Lais Macedo
CREATE TABLE public.adress
(
codigo INTEGER NOT NULL,
logradouro TEXT,
CONSTRAINT adress_pkey PRIMARY KEY (codigo)
);

--Responsavel: Arcádio Macedo
CREATE TABLE public.postalcode
(
codigo INTEGER NOT NULL,
nome CHARACTER VARYING(100),
CONSTRAINT postalcode_pkey PRIMARY KEY (codigo)
);

--Responsavel? Francisco Xavier
CREATE TABLE public.purpose
(
codigo INTEGER NOT NULL,
nome varchar(45), 
descrição varchar(120),
CONSTRAINT purpose_pkey PRIMARY KEY (codigo)
);

-- Responsavel: Glauco Yoshikazu Sazaka
CREATE TABLE public.collaborator
(
	codigo INTEGER NOT NULL,
	nome VARCHAR(255) NOT NULL,
	data_nascimento DATE NOT NULL,
	codigo_host INTEGER REFERENCES public.host (codigo),
	codigo_adress INTEGER REFERENCES public.adress (codigo),
	CONSTRAINT collaborator_pk PRIMARY KEY (codigo)
);
