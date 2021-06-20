INSERT INTO professor (nome, usuario, senha) VALUES
  ('professor1', 'professor1', 'senha1'),
  ('professor2', 'professor2', 'senha2'),
  ('professor3', 'professor3', 'senha3'),
  ('professor4', 'professor4', 'senha4'),
  ('professor5', 'professor5', 'senha5'),
  ('professor6', 'professor6', 'senha6');

INSERT INTO aluno (id_professor, nome, usuario, senha, total_pontos, fase) VALUES
  (1, 'aluno1', 'professor1', 'senha1', 1, 1),
  (1, 'aluno2', 'professor2', 'senha2', 3, 1),
  (2, 'aluno3', 'professor3', 'senha3', 4, 1),
  (2, 'aluno4', 'professor4', 'senha4', 0, 1),
  (3, 'aluno5', 'professor5', 'senha5', 3, 1),
  (6, 'aluno6', 'professor7', 'senha7', 0, 1),
  (5, 'aluno7', 'professor8', 'senha8', 0, 1),
  (6, 'aluno8', 'professor9', 'senha9', 0, 1),
  (6, 'aluno9', 'professor10', 'senha10', 10, 1);

INSERT INTO bioma (nome) VALUES
  ('Oceano'),
  ('Campo'),
  ('Deserto'),
  ('Floresta');

INSERT INTO animal (id_bioma, nome, imagem) VALUES
  (4, 'Água-viva', 'agua_viva'),
  (4, 'Arraia', 'arraia'),
  (4, 'Bagre', 'bagre'),
  (4, 'Baleia Azul', 'baleia_azul'),
  (4, 'Baleia Orca', 'baleia_orca'),
  (4, 'Camarão', 'camarao'),
  (4, 'Cavalo-marinho', 'cavalo_marinho'),
  (4, 'Estrela-do-mar', 'estrela_do_mar'),
  (4, 'Foca', 'foca'),
  (4, 'Golfinho', 'golfinho'),
  (4, 'Peixe-palhaço', 'peixe_palhaço'),
  (4, 'Polvo', 'polvo'),
  (4, 'Tartaruga', 'tartaruga'),
  (4, 'Tubarão', 'tubarao');

INSERT INTO dificuldade (numero_cartas, tempo_limite) VALUES
  (8, 120),
  (14, 240),
  (20, 300);

INSERT INTO partida (id_aluno, id_bioma, id_dificuldade, status) VALUES
  (1, 1, 3, 'FINALIZADO'),
  (1, 2, 1, 'FINALIZADO'),
  (2, 1, 3, 'FINALIZADO'),
  (5, 4, 1, 'FINALIZADO'),
  (3, 4, 2, 'FINALIZADO'),
  (4, 4, 1, 'FINALIZADO'),
  (3, 4, 2, 'FINALIZADO'),
  (4, 4, 3, 'FINALIZADO'),
  (1, 4, 3, 'FINALIZADO'),
  (3, 2, 1, 'FINALIZADO'),
  (4, 3, 2, 'FINALIZADO'),
  (5, 1, 2, 'FINALIZADO');