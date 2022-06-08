CREATE TABLE ESTADO (
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(50) NOT NULL UNIQUE,
	SIGLA VARCHAR(3) NOT NULL UNIQUE
);

CREATE TABLE CIDADE (
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(80) NOT NULL UNIQUE,
	ESTADO_ID BIGINT,
	
	FOREIGN KEY (ESTADO_ID) REFERENCES ESTADO(ID) ON DELETE CASCADE
);

CREATE TABLE ENDERECO (
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	RUA VARCHAR(255) NOT NULL,
	CEP VARCHAR(25) NOT NULL,
	COMPLEMENTO VARCHAR(255),
	NUMERO BIGINT,
);

CREATE TABLE CLIENTE (
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	NOME_COMPLETO VARCHAR(255) NOT NULL UNIQUE,
	CPF VARCHAR(25) NOT NULL UNIQUE,
	EMAIL VARCHAR(100) NOT NULL UNIQUE,
	SEXO ENUM('M', 'F') NOT NULL,
	DATA_NASCIMENTO DATE NOT NULL,
	TELEFONE BIGINT NOT NULL,
	CIDADE_ID BIGINT,
	ENDERECO_ID BIGINT,
	
	FOREIGN KEY (CIDADE_ID) REFERENCES CIDADE(ID) ON DELETE SET NULL 
	FOREIGN KEY (ENDERECO_ID) REFERENCES ENDERECO(ID) ON DELETE SET NULL 
);