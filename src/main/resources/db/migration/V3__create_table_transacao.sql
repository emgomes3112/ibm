CREATE TABLE IF NOT EXISTS transacao (
        id integer AUTO_INCREMENT PRIMARY KEY,
        data_transacao timestamp,
        valor decimal(10),
        medicamento_id int,
        cliente_id int,
        CONSTRAINT fk_transacao_cliente FOREIGN KEY(cliente_id) REFERENCES cliente(id),
        CONSTRAINT fk_transacao_medicamento FOREIGN KEY(medicamento_id) REFERENCES medicamento(id)

)