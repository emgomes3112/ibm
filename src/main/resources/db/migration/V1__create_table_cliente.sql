CREATE TABLE IF NOT EXISTS cliente (
        id integer AUTO_INCREMENT PRIMARY KEY,
        nome varchar(255),
        data_de_nascimento varchar(10),
        telefone varchar(13),
        email varchar(255),
        cpf varchar(11)


)