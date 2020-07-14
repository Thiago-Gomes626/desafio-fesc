DROP TABLE IF EXISTS movimentoestoque;
DROP TABLE IF EXISTS produto cascade;
 
CREATE TABLE produto (
  codigo INT AUTO_INCREMENT  PRIMARY KEY,
  descricao VARCHAR(250) NOT NULL,
  tipo VARCHAR(250) NOT NULL,
  valorForn DECIMAL(7,2) NOT NULL,
  estoque INT
);

CREATE TABLE movimentoestoque (
	codigo INT AUTO_INCREMENT PRIMARY KEY,
	codProd INT NOT NULL,
	tipo VARCHAR(10) NOT NULL,
	valorVenda DECIMAL(7,2),
	dataVenda DATE,
	qntMovimentada INT,
	FOREIGN KEY (codProd) REFERENCES produto(codigo)
);
 
INSERT INTO produto (descricao, tipo, valorForn, estoque) VALUES
  ('Microondas', 'eletrodomestico', 300.00, 1),
  ('Monitor', 'eletrodomestico', 150.00, 5);

INSERT INTO movimentoestoque (codProd, tipo, valorVenda, qntMovimentada) VALUES
  (1, 'saida', 315.00, 1);