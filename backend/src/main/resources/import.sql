INSERT INTO usuario (nome, cpf) VALUES ('Fagner Cunha da Cruz', 12345678900L);
INSERT INTO usuario (nome, cpf) VALUES ('Maria Aparecida', 12345678900L);
INSERT INTO usuario (nome, cpf) VALUES ('Vanderlaine da Silva Cunha', 12345678900L);
INSERT INTO usuario (nome, cpf) VALUES ('Thomás Kitubaína da Serra', 12345678900L);

INSERT INTO endereco (cep, logradouro, cidade) VALUES ('58011674', 'Rua Capitão Jair Bolsonaro', 'Cabedelo');
INSERT INTO endereco (cep, logradouro, cidade) VALUES ('58785743', 'Rua Presidiário Lula da Silva', 'João Pessoa');
INSERT INTO endereco (cep, logradouro, cidade) VALUES ('58362961', 'Rua Teste Maroto', 'Bananeiras');
INSERT INTO endereco (cep, logradouro, cidade) VALUES ('51049387', 'Rua dos excluídos', 'Maragógi');

INSERT INTO tb_usuario_endereco (usuario_id, endereco_id) VALUES (1,1)
INSERT INTO tb_usuario_endereco (usuario_id, endereco_id) VALUES (2,4)
INSERT INTO tb_usuario_endereco (usuario_id, endereco_id) VALUES (3,1)
INSERT INTO tb_usuario_endereco (usuario_id, endereco_id) VALUES (4,3)