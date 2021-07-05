CREATE TABLE IF NOT EXISTS professor (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(255) UNIQUE,
  usuario VARCHAR(255) UNIQUE,
  senha VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS aluno (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  id_professor INTEGER,
  nome VARCHAR(255) UNIQUE,
  usuario VARCHAR(255) UNIQUE,
  senha VARCHAR(255),
  total_pontos INTEGER DEFAULT 0,
  fase INTEGER DEFAULT 1,
  CONSTRAINT fk_professor_aluno FOREIGN KEY(id_professor) REFERENCES professor(id)
);
CREATE TABLE IF NOT EXISTS bioma (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  nome varchar(255) UNIQUE
);
CREATE TABLE IF NOT EXISTS animal (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  id_bioma INTEGER,
  nome VARCHAR(255) UNIQUE,
  imagem VARCHAR(255),
  som VARCHAR(255),
  descricao VARCHAR(255),
  alimentacao VARCHAR(255),
  CONSTRAINT fk_bioma_animal FOREIGN KEY(id_bioma) REFERENCES bioma(id)
);
CREATE TABLE IF NOT EXISTS zoologico (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  id_aluno INTEGER,
  CONSTRAINT fk_aluno_zoologico FOREIGN KEY(id_aluno) REFERENCES aluno(id)
);
CREATE TABLE IF NOT EXISTS zoo_anim (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  id_zoologico INTEGER,
  id_animal INTEGER,
  CONSTRAINT fk_zoo_anim_zoologico FOREIGN KEY(id_zoologico) REFERENCES zoologico(id),
  CONSTRAINT fk_zoo_anim_animal FOREIGN KEY(id_animal) REFERENCES animal(id)
);
CREATE TABLE IF NOT EXISTS dificuldade (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  numero_cartas INTEGER,
  tempo_limite INTEGER
);
CREATE TABLE IF NOT EXISTS partida (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  id_aluno INTEGER,
  id_bioma INTEGER,
  id_dificuldade INTEGER,
  tempo INTEGER,
  status VARCHAR(255),
  pontos INTEGER,
  CONSTRAINT fk_aluno_partida FOREIGN KEY(id_aluno) REFERENCES aluno(id),
  CONSTRAINT fk_bioma_partida FOREIGN KEY(id_bioma) REFERENCES bioma(id),
  CONSTRAINT fk_dificuldade_partida FOREIGN KEY(id_dificuldade) REFERENCES dificuldade(id)
);