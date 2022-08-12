CREATE TABLE IF NOT EXISTS medicamento (
    id integer AUTO_INCREMENT PRIMARY KEY,
    nome varchar(255),
    marca varchar(150),
    codigo_de_barras varchar(5),
    valor decimal(5),
    cliente_id int,
    CONSTRAINT fk_medicamento_cliente FOREIGN KEY(cliente_id) REFERENCES cliente(id)

    )