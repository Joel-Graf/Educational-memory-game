CREATE TABLE IF NOT EXISTS professores (
  id INTEGER PRIMARY KEY,
  nome VARCHAR(255) UNIQUE,
  usuario VARCHAR(255) UNIQUE,
  senha VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS alunos (
  id INTEGER PRIMARY KEY,
  id_professor INTEGER,
  nome VARCHAR(255) UNIQUE,
  total_pontos INTEGER DEFAULT 0,
  CONSTRAINT fk_professores_alunos FOREIGN KEY(id_professor) REFERENCES professores(id)
);
CREATE TABLE IF NOT EXISTS biomas (
  id INTEGER PRIMARY KEY,
  nome varchar(255) UNIQUE
);
CREATE TABLE IF NOT EXISTS animais (
  id INTEGER PRIMARY KEY,
  id_bioma INTEGER,
  nome VARCHAR(255) UNIQUE,
  imagem VARCHAR(255),
  som VARCHAR(255),
  descricao VARCHAR(255),
  alimentacao VARCHAR(255),
  CONSTRAINT fk_biomas_animais FOREIGN KEY(id_bioma) REFERENCES biomas(id)
);
CREATE TABLE IF NOT EXISTS zoologicos (
  id INTEGER PRIMARY KEY,
  id_aluno INTEGER,
  CONSTRAINT fk_alunos_zoologicos FOREIGN KEY(id_aluno) REFERENCES alunos(id)
);
CREATE TABLE IF NOT EXISTS zoo_anim (
  id INTEGER PRIMARY KEY,
  id_zoologico INTEGER,
  id_animal INTEGER,
  CONSTRAINT fk_zoo_anim_zoologicos FOREIGN KEY(id_zoologico) REFERENCES zoologicos(id),
  CONSTRAINT fk_zoo_anim_animais FOREIGN KEY(id_animal) REFERENCES animais(id)
);
CREATE TABLE IF NOT EXISTS dificuldades (
  id INTEGER PRIMARY KEY,
  numero_cartas INTEGER,
  tempo_limite INTEGER
);
CREATE TABLE IF NOT EXISTS partidas (
  id INTEGER PRIMARY KEY,
  id_aluno INTEGER,
  id_bioma INTEGER,
  id_dificuldade INTEGER,
  tempo INTEGER,
  status VARCHAR(255),
  pontos INTEGER,
  CONSTRAINT fk_alunos_partidas FOREIGN KEY(id_aluno) REFERENCES alunos(id),
  CONSTRAINT fk_biomas_partidas FOREIGN KEY(id_bioma) REFERENCES biomas(id),
  CONSTRAINT fk_dificuldades_partidas FOREIGN KEY(id_dificuldade) REFERENCES dificuldades(id)
);