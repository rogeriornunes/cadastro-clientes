CREATE TABLE ESTADO (
	ID_ESTADO BIGINT PRIMARY KEY AUTO_INCREMENT,
	NOME_ESTADO VARCHAR(50) NOT NULL UNIQUE,
	SIGLA VARCHAR(3) NOT NULL UNIQUE
);

CREATE TABLE CIDADE (
	ID_CIDADE BIGINT PRIMARY KEY AUTO_INCREMENT,
	NOME_CIDADE VARCHAR(80) NOT NULL UNIQUE,
	ESTADO_ID BIGINT,
	
	FOREIGN KEY (ESTADO_ID) REFERENCES ESTADO(ID_ESTADO) ON DELETE CASCADE
);

CREATE TABLE ENDERECO (
	ID_ENDERECO BIGINT PRIMARY KEY AUTO_INCREMENT,
	RUA VARCHAR(255) NOT NULL,
	CEP VARCHAR(25) NOT NULL,
	NUMERO BIGINT NOT NULL,
	COMPLEMENTO VARCHAR(255)
);

CREATE TABLE CLIENTE (
	ID_CLIENTE BIGINT PRIMARY KEY AUTO_INCREMENT,
	NOME_COMPLETO VARCHAR(255) NOT NULL UNIQUE,
	CPF VARCHAR(25) NOT NULL UNIQUE,
	EMAIL VARCHAR(100) NOT NULL UNIQUE,
	SEXO ENUM('M', 'F') NOT NULL,
	DATA_NASCIMENTO DATE NOT NULL,
	TELEFONE BIGINT NOT NULL,
	CIDADE_ID BIGINT,
	ENDERECO_ID BIGINT,
	
	FOREIGN KEY (CIDADE_ID) REFERENCES CIDADE(ID_CIDADE) ON DELETE SET NULL, 
	FOREIGN KEY (ENDERECO_ID) REFERENCES ENDERECO(ID_ENDERECO) ON DELETE SET NULL 
);