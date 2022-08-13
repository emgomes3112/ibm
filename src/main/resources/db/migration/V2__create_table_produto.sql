CREATE TABLE IF NOT EXISTS produto (
    id integer AUTO_INCREMENT PRIMARY KEY,
    nome varchar(255),
    tipo varchar(150),
    codigo_de_barras varchar(5),
    preco decimal(5)

    )