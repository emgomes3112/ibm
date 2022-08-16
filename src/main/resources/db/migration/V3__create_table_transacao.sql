CREATE TABLE IF NOT EXISTS transacao(
                       id integer AUTO_INCREMENT PRIMARY KEY,
                       preco decimal(10,2),
                       cliente_id int,
                       produto_id int,
                       CONSTRAINT fk_transacao_cliente FOREIGN KEY(cliente_id) REFERENCES cliente(id),
                       CONSTRAINT fk_agenda_produto FOREIGN KEY(produto_id) REFERENCES produto(id)
);