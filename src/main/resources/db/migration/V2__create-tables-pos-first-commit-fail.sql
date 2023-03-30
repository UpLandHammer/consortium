CREATE TABLE prestacao (
  id_prestacao int(11) NOT NULL AUTO_INCREMENT,
  id_participante int(11) NOT NULL,
  numero_prestacao int(11) NOT NULL,
  valor decimal(10,0) NOT NULL,
  data_vencimento timestamp NOT NULL,
  data_pagamento timestamp NOT NULL,
  status char(1) NOT NULL,
  constraint pk_prestacao PRIMARY KEY (id_prestacao, id_participante),
  CONSTRAINT id_participante_fk FOREIGN KEY (id_participante) REFERENCES participante (id_participante)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE sorteio (
  id_sorteio int(11) NOT NULL AUTO_INCREMENT,
  id_grupo int(11) NOT NULL,
  id_participante int(11) NOT NULL,
  data_sorteio timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  constraint pk_sorteio PRIMARY KEY (id_sorteio, id_grupo, id_participante),
  CONSTRAINT id_grupo_sort_fk FOREIGN KEY (id_grupo) REFERENCES grupo (id_grupo),
  CONSTRAINT id_participante_sort_fk FOREIGN KEY (id_participante) REFERENCES participante (id_participante)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

