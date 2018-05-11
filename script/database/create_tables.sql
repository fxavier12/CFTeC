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
	nome varchar(255), --padronizar tipo do campo
	--faltou chave estrangeira
	constraint city_pkey primary key (codigo)
	constraint state_fkey foreign key (codigo) references public.state(codigo)
);

-- Responsavel Alex Jussiani
CREATE TABLE public.arctifact  
(
	codigo integer not null,
	artefato character varying(200),
	--faltou chave estrangeira para message.
	constraint artifact_pkey primary key (codigo)
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
nome CHARACTER VARYING(100), --mudar nome para codigo_postal
	--chave para type, city
CONSTRAINT postalcode_pkey PRIMARY KEY (codigo)
);

--Responsavel: Francisco Xavier
CREATE TABLE public.purpose
(
codigo INTEGER NOT NULL,
nome varchar(45), 
descrição varchar(120),
CONSTRAINT purpose_pkey PRIMARY KEY (codigo)
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
);
