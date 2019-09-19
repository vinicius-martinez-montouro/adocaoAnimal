create user adocaoanimal identified by 123;
grant all privileges to adocaoanimal;

CREATE TABLE cliente (
    cpf    VARCHAR(14) NOT NULL,
    nome   VARCHAR(50) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    email VARCHAR(50) NOT NULL,
    CONSTRAINT pk_usuario PRIMARY KEY ( cpf )
);

CREATE TABLE ANIMAL(
    id_animal INT NOT NULL,
    raca VARCHAR(50) NOT NULL,
    idade INTEGER,
    peso DECIMAL(7,3),
    porte VARCHAR(7) NOT NULL,
    cpf VARCHAR(14),
    CONSTRAINT pk_animal PRIMARY KEY(id_animal),
    CONSTRAINT fk_usuario FOREIGN KEY(cpf) REFERENCES cliente(cpf)
);
