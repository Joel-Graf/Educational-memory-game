-- CREATE DATABASE
CREATE DATABASE pac3 WITH OWNER = postgres ENCODING = 'UTF8' CONNECTION
LIMIT = -1;
-- POPULATE DATABASE
BEGIN;
-- -- CREATE TYPES
CREATE TYPE status_partida AS ENUM('ANDAMENTO', 'VITORIA', 'DERROTA');
-- -- CREATE TABLES
CREATE TABLE IF NOT EXISTS professores (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(255) UNIQUE NOT NULL,
  usuario VARCHAR(255) UNIQUE NOT NULL,
  senha VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS alunos (
  id SERIAL PRIMARY KEY,
  id_professor INTEGER,
  nome VARCHAR(255) UNIQUE NOT NULL,
  total_pontos INTEGER DEFAULT 0 NOT NULL,
  CONSTRAINT fk_professores_alunos FOREIGN KEY(id_professor) REFERENCES professores(id)
);
CREATE TABLE IF NOT EXISTS biomas (
  id SERIAL PRIMARY KEY,
  nome varchar(255) UNIQUE NOT NULL
);
CREATE TABLE IF NOT EXISTS animais (
  id SERIAL PRIMARY KEY,
  id_bioma INTEGER,
  nome VARCHAR(255) UNIQUE NOT NULL,
  imagem VARCHAR(255) NOT NULL,
  som VARCHAR(255) NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  alimentacao VARCHAR(255) NOT NULL,
  CONSTRAINT fk_biomas_animais FOREIGN KEY(id_bioma) REFERENCES biomas(id)
);
CREATE TABLE IF NOT EXISTS zoologicos (
  id SERIAL PRIMARY KEY,
  id_aluno INTEGER,
  CONSTRAINT fk_alunos_zoologicos FOREIGN KEY(id_aluno) REFERENCES alunos(id)
);
CREATE TABLE IF NOT EXISTS zoo_anim (
  id SERIAL PRIMARY KEY,
  id_zoologico INTEGER,
  id_animal INTEGER,
  CONSTRAINT fk_zoo_anim_zoologicos FOREIGN KEY(id_zoologico) REFERENCES zoologicos(id),
  CONSTRAINT fk_zoo_anim_animais FOREIGN KEY(id_animal) REFERENCES animais(id)
);
CREATE TABLE IF NOT EXISTS dificuldades (
  id SERIAL PRIMARY KEY,
  numero_cartas INTEGER NOT NULL,
  tempo_limite INTEGER NOT NULL
);
CREATE TABLE IF NOT EXISTS partidas (
  id SERIAL PRIMARY KEY,
  id_aluno INTEGER,
  id_bioma INTEGER,
  id_dificuldade INTEGER,
  tempo INTEGER NOT NULL,
  status status_partida,
  pontos INTEGER NOT NULL,
  CONSTRAINT fk_alunos_partidas FOREIGN KEY(id_aluno) REFERENCES alunos(id),
  CONSTRAINT fk_biomas_partidas FOREIGN KEY(id_bioma) REFERENCES biomas(id),
  CONSTRAINT fk_dificuldades_partidas FOREIGN KEY(id_dificuldade) REFERENCES dificuldades(id)
);
COMMIT;