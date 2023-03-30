DROP TABLE IF EXISTS sorteio;
DROP TABLE IF EXISTS prestacao;
DROP TABLE IF EXISTS participante;
DROP TABLE IF EXISTS grupo;
DROP TABLE IF EXISTS usuario;

CREATE TABLE usuario (
  id_usuario int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  telefone varchar(255) NOT NULL,
  constraint pk_id_isuario PRIMARY KEY (id_usuario)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;

CREATE TABLE grupo (
  id_grupo int(11) NOT NULL AUTO_INCREMENT,
  id_usuario int(11) NOT NULL,
  descricao varchar(255) NOT NULL,
  valor decimal(10,0) NOT NULL,
  data_vigencia_inicial timestamp NOT NULL,
  data_vigencia_final timestamp NOT NULL,
  ativo char(1) DEFAULT 'N',
  dia_pagamento int(11) NOT NULL,
  constraint pk_id_grupo PRIMARY KEY (id_grupo, id_usuario),
  CONSTRAINT id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE participante (
  id_participante int(11) NOT NULL AUTO_INCREMENT,
  id_usuario int(11) NOT NULL,
  id_grupo int(11) NOT NULL,
  ativo char(1) NOT NULL,
  tipo_comunicacao varchar(255) NOT NULL,
  contemplado char(1) DEFAULT 'N',
  constraint pk_id_participante PRIMARY KEY (id_participante),
  KEY id_usuario_part_fk (id_usuario),
  KEY id_grupo_part_fk (id_grupo),
  CONSTRAINT id_grupo_part_fk FOREIGN KEY (id_grupo) REFERENCES grupo (id_grupo),
  CONSTRAINT id_usuario_part_fk FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;